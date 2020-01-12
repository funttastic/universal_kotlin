export enabledModules="common-multiple_sources"
echo "TARGET MODULES '$enabledModules'"
./gradlew :common:common-multiple_sources:build

export enabledModules="common-single_source"
echo "TARGET MODULES '$enabledModules'"
./gradlew :common:common-single_source:build

export enabledModules="library-multiple_sources"
echo "TARGET MODULES '$enabledModules'"
./gradlew :library:library-multiple_sources:build

export enabledModules="library-single_source"
echo "TARGET MODULES '$enabledModules'"
./gradlew :library:library-single_source:build

export enabledModules="application-backend-jvm-spring_boot"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:build

export enabledModules="application-browser-js-spa-react"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:build

export enabledModules="application-browser-js-vanilla"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:build

export enabledModules="application-browser-native-wasm32"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:build

export enabledModules="application-desktop-jvm-tornado_fx"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-desktop:application-desktop-jvm:application-desktop-jvm-tornado_fx:build

export enabledModules="application-mobile-jvm-android"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-jvm:application-mobile-jvm-android:build

export enabledModules="application-mobile-native-apple-ios-ios_x64"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64:build

export enabledModules="application-mobile-native-apple-ios-ios_x64_copying_framework"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_copying_framework:build

export enabledModules="application-mobile-native-apple-ios-ios_x64_framework"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_framework:build

export enabledModules="application-mobile-native-apple-ios-ios_x64_with_framework"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-mobile:application-mobile-native:application-mobile-native-apple:application-mobile-native-apple-ios:application-mobile-native-apple-ios-ios_x64_with_framework:build

export enabledModules="application-script-jvm-script"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-script:application-script-jvm:application-script-jvm-script:build

export enabledModules="application-terminal-jvm-terminal"
echo "TARGET MODULES '$enabledModules'"
./gradlew :application:application-terminal:application-terminal-jvm:application-terminal-jvm-terminal:build

export enabledModules=""
echo "TARGET MODULES '$enabledModules'"
./gradlew build
