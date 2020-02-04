echo "Building common-multiple_sources"
./gradlew --stacktrace :common-multiple_sources:build

echo "Building common-single_source"
./gradlew --stacktrace :common-single_source:build

echo "Building library-multiple_sources"
./gradlew --stacktrace :library-multiple_sources:build

echo "Building library-single_source"
./gradlew --stacktrace :library-single_source:build

echo "Building application-backend-jvm-spring_boot"
./gradlew --stacktrace :application-backend-jvm-spring_boot:build

echo "Building application-browser-js-spa-react"
./gradlew --stacktrace :application-browser-js-spa-react:build

echo "Building application-browser-js-vanilla"
./gradlew --stacktrace :application-browser-js-vanilla:build

echo "Building application-browser-native-wasm32"
./gradlew --stacktrace :application-browser-native-wasm32:build

echo "Building application-desktop-jvm-tornado_fx"
./gradlew --stacktrace :application-desktop-jvm-tornado_fx:build

echo "Building application-mobile-jvm-android"
./gradlew --stacktrace :application-mobile-jvm-android:build

echo "Building application-mobile-native-apple-ios-ios_x64"
./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64:build

echo "Building application-mobile-native-apple-ios-ios_x64_copying_framework"
./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_copying_framework:build

echo "Building application-mobile-native-apple-ios-ios_x64_framework"
./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_framework:build

echo "Building application-mobile-native-apple-ios-ios_x64_with_framework"
./gradlew --stacktrace :application-mobile-native-apple-ios-ios_x64_with_framework:build

echo "Building application-script-jvm-script"
./gradlew --stacktrace :application-script-jvm-script:build

echo "Building application-terminal-jvm-terminal"
./gradlew --stacktrace :application-terminal-jvm-terminal:build

echo "Building all"
./gradlew --stacktrace build
