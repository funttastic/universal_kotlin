# Universal Kotlin

## Application -> Browser -> Native -> Wasm32

Module with a Web Assembly (Wasm32) native application.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="application-browser-native-wasm32"
```

## Building

```bash
./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

<!-- Fix documentation
## Running

Start Webpack development server:

```bash
./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:run
```

or in a simplified way (can run more tasks):

```bash
./gradlew run
```

Checking the application:

Go to the url provided after running the `run` command. The default one is:

- [http://localhost:3101/](http://localhost:3101/)

Stop Webpack development server:

```bash
./gradlew :application:application-browser:application-browser-native:application-browser-native-wasm32:stop
```

or in a simplified way (can run more tasks):

```bash
./gradlew stop
```
-->
