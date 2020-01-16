# Preparation
clear

mkdir -p temporary

printf "\nRunning Webpack server for React\n"
nohup ./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:run >> temporary/log.out 2>&1 &

printf "\nRunning NodeJS server for Wasm32\n"
nohup node $(pwd)"/application/browser/native/wasm32/express.js" >> temporary/log.out 2>&1 &

printf "\nRunning Webpack server for Vanilla JavaScript\n"
nohup ./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:run >> temporary/log.out 2>&1 &

printf "\nRunning Spring Boot server\n"
nohup ./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:bootRun >> temporary/log.out 2>&1 &
springBootPid=$!
printf "Spring Boot PID: $springBootPid\n"

printf "\nPreparing Wasm32\n"
nohup ./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:build

printf "\nPreparing TornadoFX\n"
nohup ./gradlew :application:application-desktop:application-desktop-jvm:application-desktop-jvm-tornado_fx:build

printf "\nPreparing JVM Terminal\n"
nohup ./gradlew :application:application-terminal:application-terminal-jvm:application-terminal-jvm-terminal:shadowJar

printf "\nPreparing Android\n"
nohup ./gradlew :application:application-terminal:application-mobile-jvm:application-mobile-jvm-android:build

# Test
printf "\nRunning TornadoFX\n"
nohup ./gradlew :application:application-desktop:application-desktop-jvm:application-desktop-jvm-tornado_fx:run

printf "\nRunning KScript\n"
kscript application/script/jvm/script/src/main/kotlin/com/company/team/project/application/script/jvm/script/Example.kt

printf "\nRunning JVM Terminal\n"
java -jar application/terminal/jvm/terminal/build/libs/application-terminal-jvm-terminal-0.0.1-all.jar

printf "\nOpening Google Chrome\n"
open -na "Google Chrome" --args --new-window "http://localhost:10001/exampleController/exampleMethod"
open -na "Google Chrome" --args "http://localhost:10002"
open -na "Google Chrome" --args "http://localhost:10003"
open -na "Google Chrome" --args "http://localhost:10004"
open -na "Google Chrome" --args $(pwd)"/application/browser/native/wasm32/index.html"
read -p "It is needed to wait until the servers start propertly"

printf "\nRunning Android\n"
nohup ./gradlew :application:application-terminal:application-mobile-jvm:application-mobile-jvm-android:installDebug
# ios

# Finish
printf "\Stopping React Webpack server\n"
nohup ./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:stop

printf "\Stopping Vanilla JavaScript Webpack server\n"
nohup ./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:stop

printf "\Killing Spring Boot server\n"
kill $springBootPid
