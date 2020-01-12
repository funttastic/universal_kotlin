#!/usr/bin/env bash

#cd ../../

## Builds and Tests:

export enabledModules="common-multiple_sources"
echo "TARGET MODULES '$enabledModules'"
./gradlew :common:common-multiple_sources:build
#./gradlew :common:common-multiple_sources:check

export enabledModules="common-single_source"
echo "TARGET MODULES '$enabledModules'"
./gradlew :common:common-single_source:build
#./gradlew :common:common-single_source:check

export enabledModules="library-multiple_sources"
echo "TARGET MODULES '$enabledModules'"
./gradlew :library:library-multiple_sources:build
#./gradlew :library:library-multiple_sources:check

export enabledModules="library-single_source"
echo "TARGET MODULES '$enabledModules'"
./gradlew :library:library-single_source:build
#./gradlew :library:library-single_source:check

export enabledModules="application-backend-jvm-spring_boot"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:build
#./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:check

export enabledModules="application-browser-js-spa-react"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:build
#./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:check

export enabledModules="application-browser-js-vanilla"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:build
#./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:check

export enabledModules="application-browser-native-wasm32"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:build
#./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:check

export enabledModules="application-desktop-jvm-tornado_fx"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-desktop:application-desktop-jvm:application-desktop-jvm-tornado_fx:build
#./gradlew :application:application-desktop:application-desktop-jvm:application-desktop-jvm-tornado_fx:check

export enabledModules="application-mobile-jvm-android"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-jvm:application-mobile-jvm-android:build
#./gradlew :application:application-mobile:application-mobile-jvm:application-mobile-jvm-android:check

export enabledModules="application-mobile-native-apple-ios-ios_x64"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64:build
#./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64:check

export enabledModules="application-mobile-native-apple-ios-ios_x64_copying_framework"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_copying_framework:build
#./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_copying_framework:check

export enabledModules="application-mobile-native-apple-ios-ios_x64_framework"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_framework:build
#./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_framework:check

export enabledModules="application-mobile-native-apple-ios-ios_x64_with_framework"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_with_framework:build
#./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_with_framework:check

export enabledModules="application-script-jvm-script"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-script:application-script-jvm:application-script-jvm-script:build
#./gradlew :application:application-script:application-script-jvm:application-script-jvm-script:check

export enabledModules="application-terminal-jvm-terminal"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-terminal:application-terminal-jvm:application-terminal-jvm-terminal:build
#./gradlew :application:application-terminal:application-terminal-jvm:application-terminal-jvm-terminal:check

export enabledModules=""
echo "TARGET MODULES '$enabledModules'"
./gradlew build
#./gradlew check

## Specific Tests

#./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:bootRun
#curl "http://localhost:8080/exampleController/exampleMethod"
#
#./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:run
#./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:stop
#
#./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:run
#./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:stop
#
#./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:run
#./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:stop
#
#missing tornado_fx specific test
#
#missing android specific test
#
#missing ios_x64 specific test
#
#missing ios_x64_copying_framework specific test
#
#missing ios_x64_framework specific test
#
#missing ios_x64_with_framework specific test
#
#missing script specific test
