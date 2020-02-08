set -e
trap 'last_command=$current_command; current_command=$BASH_COMMAND' DEBUG
trap 'echo "\"${last_command}\" command finshied with exit code $?."' EXIT

printf "\n\nBuilding common-multiple_sources:\n"
time (./gradlew --stacktrace :common-multiple_sources:build)

printf "\n\nBuilding common-single_source:\n"
time (./gradlew --stacktrace :common-single_source:build)

printf "\n\nBuilding library-multiple_sources:\n"
time (./gradlew --stacktrace :library-multiple_sources:build)

printf "\n\nBuilding library-single_source:\n"
time (./gradlew --stacktrace :library-single_source:build)

printf "\n\nBuilding application-backend-jvm-spring_boot:\n"
time (./gradlew --stacktrace :application-backend-jvm-spring_boot:build)

printf "\n\nBuilding application-browser-js-spa-react:\n"
time (./gradlew --stacktrace :application-browser-js-spa-react:build)

printf "\n\nBuilding application-browser-js-vanilla:\n"
time (./gradlew --stacktrace :application-browser-js-vanilla:build)

printf "\n\nBuilding application-browser-native-wasm32:\n"
time (./gradlew --stacktrace :application-browser-native-wasm32:build)

printf "\n\nBuilding application-desktop-jvm-tornado_fx:\n"
time (./gradlew --stacktrace :application-desktop-jvm-tornado_fx:build)

printf "\n\nBuilding application-mobile-jvm-android:\n"
time (./gradlew --stacktrace :application-mobile-jvm-android:build)

printf "\n\nBuilding application-mobile-native-apple-ios-ios_x64_without_framework:\n"
time (./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_without_framework:build)

printf "\n\nBuilding application-mobile-native-apple-ios-ios_x64_copying_framework:\n"
time (./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_copying_framework:build)

printf "\n\nBuilding application-mobile-native-apple-ios-ios_x64_framework:\n"
time (./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_framework:build)

printf "\n\nBuilding application-mobile-native-apple-ios-ios_x64_with_framework:\n"
time (./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_with_framework:build)

printf "\n\nBuilding application-script-jvm-script:\n"
time (./gradlew --stacktrace :application-script-jvm-script:build)

printf "\n\nBuilding application-terminal-jvm-terminal:\n"
time (./gradlew --stacktrace :application-terminal-jvm-terminal:build)

printf "\n\nBuilding all:\n"
time (./gradlew --stacktrace build)
