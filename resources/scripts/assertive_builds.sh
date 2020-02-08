set -e
trap 'last_command=$current_command; current_command=$BASH_COMMAND' DEBUG
trap 'echo "\"${last_command}\" command failed with exit code $?."' EXIT

printf "Assertive common-multiple_sources:\n"
./gradlew --stacktrace :common-multiple_sources:publishToMavenLocal

printf "Assertive common-single_source:\n"
./gradlew --stacktrace :common-single_source:publishToMavenLocal

printf "Assertive library-multiple_sources:\n"
./gradlew --stacktrace :library-multiple_sources:publishToMavenLocal

printf "Assertive library-single_source:\n"
./gradlew --stacktrace :library-single_source:publishToMavenLocal

printf "Assertive application-backend-jvm-spring_boot:\n"

printf "Assertive application-browser-js-spa-react:\n"

printf "Assertive application-browser-js-vanilla:\n"

printf "Assertive application-browser-native-wasm32:\n"

printf "Assertive application-desktop-jvm-tornado_fx:\n"

printf "Assertive application-mobile-jvm-android:\n"

printf "Assertive application-mobile-native-apple-ios-ios_x64:\n"

printf "Assertive application-mobile-native-apple-ios-ios_x64_copying_framework:\n"

printf "Assertive application-mobile-native-apple-ios-ios_x64_framework:\n"

printf "Assertive application-mobile-native-apple-ios-ios_x64_with_framework:\n"

printf "Assertive application-script-jvm-script:\n"
kscript application/script/jvm/script/src/main/kotlin/com/company/team/project/application/script/jvm/script/Example.kt

printf "Assertive application-terminal-jvm-terminal:\n"
./gradlew --stacktrace :application-terminal-jvm-terminal:shadowJar
java -jar application/terminal/jvm/terminal/build/libs/application-terminal-jvm-terminal-0.0.1-all.jar

printf "Assertive all:\n"
