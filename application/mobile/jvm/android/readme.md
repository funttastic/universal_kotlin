# Universal Kotlin

## Application -> Mobile -> JVM -> Android

Module with an Android application.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="application-mobile-jvm-android"
```

## Building

```bash
./gradlew :application:application-mobile:application-mobile-jvm:application-mobile-jvm-android:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :application:application-mobile:application-mobile-jvm:application-mobile-jvm-android:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

Update the Android SDK or the Android Studio to its latest version, so the latest Android SDK will be available.

Make sure to enable the Android module, so IntelliJ will be able to automatically recognize the Android app and pre-configure it.

Create a new `Run/Debug Configurations` of type `Android App` on IntelliJ choosing the Android module.

Run the application through the simulator or mobile phone and wait until the application is installed and launched.

The output should be similar to this one:

```bash
["com.company.team.project.common.multiple_sources.jvm","com.company.team.project.common.single_source.common","com.company.team.project.common.single_source.jvm.common","com.company.team.project.application.mobile.jvm.android"]
```
