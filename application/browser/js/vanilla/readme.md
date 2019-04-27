# Universal Kotlin

## Application -> Browser -> Js -> Vanilla

Module with a Vanilla JavaScript application.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="application-browser-js-vanilla"
```

## Building

```bash
./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

Start Webpack development server:

```bash
./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:run
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
./gradlew :application:application-browser:application-browser-js:application-browser-js-vanilla:stop
```

or in a simplified way (can run more tasks):

```bash
./gradlew stop
```
