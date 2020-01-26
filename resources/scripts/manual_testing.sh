#!/bin/zsh
#	Improvements
# Check if it is possible to use webpack for wasm32
# Find a way to wait for the background servers before opening the browser
# Run ios projects
# Open a new terminal grepping for key lines
# Secure spring boot shutdown and improve readme
# Upgrade to latest spring boot
# Move index.html from wasm to resources folder
# Improve react module to use new plugin
# Fix ios modules (not including main and test source sets), remove the other source sets they are using
# Run command when executing Ctrl+C to kill the remaining processes
# Open new termminal tab with the full log
# Divide the terminal screen to grep the important messages from the background process
# Improve output for all modules
# Upgrade gradle

# Prerequisites
#   npm install -g serve
#   sdk install kscript
#   sdk install java 8.0.202-zulufx
#   sdk use java 8.0.202-zulufx
#   XCode command line tools (@see: https://stackoverflow.com/questions/40743713/command-line-tool-error-xcrun-error-unable-to-find-utility-xcodebuild-n)


# Variables
currentDir=$(pwd)
enabledModules=""
disabledModules=""
pids=()
logPath="temporary/log.out"
androidSdkDir=/Users/$USER/Library/Android/sdk
androidEmulatorId=Nexus_5X_API_29_x86_64
androidPackage=com.company.team.project.application.mobile.jvm.android
iosEmulatorId=iPhone-11-Pro-Max
unset enabled
declare -A enabled
enabled[spring_boot]=false
enabled[vanilla]=false
enabled[tornadofx]=false
enabled[android]=false
enabled[kscript]=false
enabled[terminal]=false
enabled[react]=false
enabled[wasm32]=false
enabled[ios_copying_framework]=false
enabled[ios_framework]=false
enabled[ios_with_framework]=false
enabled[ios_without_framework]=false
enabled[plugin]=false

# Functions
# run -t "Title" -p "Prefix" -c "full command" -r true -b true -o "temporary/log.out"
function run() {
    zmodload zsh/zutil
    zparseopts -A arguments k: c: r: b: p: o: t:

    key=$arguments[-k]

    if [ "$enabled[$key]" != "true" ] && [[ "$key" != "all" ]]; then
        return
    fi

    title=$arguments[-t]
    command=$arguments[-c]
    redirectOutput="${arguments[-r]-true}"
    runInBackground="${arguments[-b]-true}"
    logLinesPrefix="${arguments[-p]-''}"
    outputFile="${arguments[-o]-$logPath}"

    fullCommand="$command"

    if [[ $title = *[!\ ]* ]]; then
        echo "$title"
    fi

    # if [ ! -z "$logLinesPrefix" ]; then
    #     fullCommand="$fullCommand | sed  's/^/[$logLinesPrefix] /'"
    # fi

    if [ "$redirectOutput" = "true" ]; then
        fullCommand="$fullCommand >> $outputFile 2>&1"
    fi

    if [ "$runInBackground" = "true" ]; then
        fullCommand="$fullCommand &"
    fi

    # printf "command: $command\nredirectOutput: $redirectOutput\nrunInBackground: $runInBackground\nlogLinesPrefix: $logLinesPrefix\noutputFile: $outputFile\ntitle: $title\nfullCommand: $fullCommand"

    eval $fullCommand

    if [ "$runInBackground" = "true" ]; then
        pids+=( $! ) 2>&1
    fi

    unset fullCommand command redirectOutput runInBackground logLinesPrefix outputFile title
}

function closeChromeTab() {
    url=$1

    osascript -e '
        tell application "Google Chrome"
            set windowList to every tab of every window whose URL starts with "'"$url"'"
            repeat with tabList in windowList
                set tabList to tabList as any
                repeat with tabItr in tabList
                    set tabItr to tabItr as any
                    delete tabItr
                end repeat
            end repeat
        end tell
    '
}

function killRemainingProcesses() {
    # TODO Improve to kill only processes that still exist
    for pid in $pids ; do kill $pid ; done
}


# Preparation
clear

mkdir -p temporary
: > temporary/log.out

run -k build -t "Cleaning, building and checking" -p "Build" -c "./gradlew build check" -b false

# ttab tail -f $logPath | grep "running at http://localhost:10002"

run -k android -t "Preparing Android" -p "Android" -c "$androidSdkDir/emulator/emulator -avd $androidEmulatorId"

run -k spring_boot -t "Running Spring Boot server" -p "Spring Boot" -c "./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:bootRun"

run -k react -t "Running Webpack server for React" -p "React" -c "./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:run"

run -k wasm32 -t "Preparing Wasm32" -p "Wasm32" -c "./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:build" -b false -r true
run -k wasm32 -t "Running server for Wasm32" -p "Wasm32" -c "serve -l 10004 '$currentDir/application/browser/native/wasm32'"

run -k vanilla -t "Running Webpack server for Vanilla JavaScript" -p "Vanilla JS" -c "./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:run"

run -k terminal -t "Preparing JVM Terminal" -p "JVM Terminal" -c "./gradlew :application:application-terminal:application-terminal-jvm:application-terminal-jvm-terminal:shadowJar" -b false

# Test
run -k tornadofx -t "Running TornadoFX" -p "Tornado FX" -c "./gradlew :application:application-desktop:application-desktop-jvm:application-desktop-jvm-tornado_fx:run"

run -k kscript -t "Running KScript" -p "KScript" -c "kscript application/script/jvm/script/src/main/kotlin/com/company/team/project/application/script/jvm/script/Example.kt" -b false -r false

run -k terminal -t "Running JVM Terminal" -p "JVM Terminal" -c "java -jar application/terminal/jvm/terminal/build/libs/application-terminal-jvm-terminal-0.0.1-all.jar" -b false -r false

run -k spring_boot -t "Opening Chrome tab for Spring Boot" -c "open -na 'Google Chrome' --args 'http://localhost:10001/exampleController/exampleMethod'" -b false -r false
run -k react -t "Opening Chrome tab for React" -c "open -na 'Google Chrome' --args 'http://localhost:10002'" -b false -r false
run -k vanilla -t "Opening Chrome tab for Vanilla JavaScript" -c "open -na 'Google Chrome' --args 'http://localhost:10003'" -b false -r false
run -k wasm32 -t "Opening Chrome tab for Wasm32" -c "open -na 'Google Chrome' --args 'http://localhost:10004'" -b false -r false

run -k android -t "Running Android" -p "Android" -c "$androidSdkDir/platform-tools/adb wait-for-device" -b false
run -k android -p "Android" -c "./gradlew :application:application-mobile:application-mobile-jvm:application-mobile-jvm-android:installDebug" -b false
run -k android -p "Android" -c "$androidSdkDir/platform-tools/adb shell monkey -p $androidPackage 1" -b false

# TODO check paths
# plutil -convert binary1 Info.plist
run -k ios_copying_framework -t "Running iOS copying framework" -p "iOS X64 copying Framework" -c "ios-sim launch $currentDir/application/mobile/native/apple/ios/ios_x64_copying_framework/application -d $iOSEmulatorId"
run -k ios_framework -t "Running iOS framework" -p "iOS X64 Framework" -c "ios-sim launch $currentDir/application/mobile/native/apple/ios/ios_x64_framework/framework -d $iOSEmulatorId"
run -k ios_with_framework -t "Running iOS with framework" -p "iOS X64 with Framework" -c "ios-sim launch $currentDir/application/mobile/native/apple/ios/ios_x64_with_framework/application -d $iOSEmulatorId"
run -k ios_without_framework -t "Running iOS without framework" -p "iOS X64 without Framework" -c "ios-sim launch $currentDir/application/mobile/native/apple/ios/ios_x64_without_framework/application -d $iOSEmulatorId"

# Finish
read -s -k "?Press any key to proceed with the shutdown."
printf "\n"

run -k wasm32 -t "Closing Wasm32 Google Chrome tab" -p "Wasm32" -c "closeChromeTab http://localhost:10004"

run -k react -t "Stopping React Webpack server" -p "React" -c "./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:stop"
run -k react -t "Closing React Google Chrome tab" -p "React" -c "closeChromeTab http://localhost:10002"

run -k vanilla -t "Stopping Vanilla JavaScript Webpack server" -p "Vanilla JS" -c "./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:stop"
run -k vanilla -t "Closing Vanilla JavaScript Google Chrome tab" -p "Vanilla JS" -c "closeChromeTab http://localhost:10003"

run -k spring_boot -t "Stopping Spring Boot server" -p "Spring Boot" -c "curl -sS -X POST localhost:10001/actuator/shutdown"
run -k spring_boot -t "Closing Spring Boot Google Chrome tab" -p "Spring Boot" -c "closeChromeTab http://localhost:10001"

run -k android -t "Stopping Android emulator" -p "Android" -c "$androidSdkDir/platform-tools/adb -s emulator-5554 emu kill"

run -k all -t "Killing remaining processes" -p "All" -c "for pid in \$pids ; do kill \$pid ; done"
