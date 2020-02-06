printf "Building common-multiple_sources:\n"
./gradlew --stacktrace :common-multiple_sources:build

printf "Building common-single_source:\n"
./gradlew --stacktrace :common-single_source:build

printf "Building library-multiple_sources:\n"
./gradlew --stacktrace :library-multiple_sources:build

printf "Building library-single_source:\n"
./gradlew --stacktrace :library-single_source:build

printf "Building application-backend-jvm-spring_boot:\n"
./gradlew --stacktrace :application-backend-jvm-spring_boot:build

printf "Building application-browser-js-spa-react:\n"
./gradlew --stacktrace :application-browser-js-spa-react:build

printf "Building application-browser-js-vanilla:\n"
./gradlew --stacktrace :application-browser-js-vanilla:build

printf "Building application-browser-native-wasm32:\n"
./gradlew --stacktrace :application-browser-native-wasm32:build

printf "Building application-desktop-jvm-tornado_fx:\n"
./gradlew --stacktrace :application-desktop-jvm-tornado_fx:build

printf "Building application-mobile-jvm-android:\n"
./gradlew --stacktrace :application-mobile-jvm-android:build

printf "Building application-mobile-native-apple-ios-ios_x64:\n"
./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64:build

printf "Building application-mobile-native-apple-ios-ios_x64_copying_framework:\n"
./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_copying_framework:build

printf "Building application-mobile-native-apple-ios-ios_x64_framework:\n"
./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_framework:build

printf "Building application-mobile-native-apple-ios-ios_x64_with_framework:\n"
./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_with_framework:build

printf "Building application-script-jvm-script:\n"
./gradlew --stacktrace :application-script-jvm-script:build

printf "Building application-terminal-jvm-terminal:\n"
./gradlew --stacktrace :application-terminal-jvm-terminal:build

printf "Building all:\n"
./gradlew --stacktrace build
