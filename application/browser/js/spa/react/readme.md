# Universal Kotlin

## Application -> Browser -> JavaScript -> SPA -> React

Module with a React with Webpack application.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="application-browser-js-spa-react"
```

## Building

```bash
./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

Start Webpack development server:

```bash
./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:run
```

or in a simplified way (can run more tasks):

```bash
./gradlew run
```

Checking the application:

Go to the url provided after running the `run` command. The default one is:

- [http://localhost:3101/](http://localhost:3101/)

The output should be similar to this one:

```bash
[com.company.team.project.common.multiple_sources.js, com.company.team.project.common.single_source.js.common, com.company.team.project.application.browser.js.spa.react]
```

Stop Webpack development server:

```bash
./gradlew :application:application-browser:application-browser-js:application-browser-js-spa:application-browser-js-spa-react:stop
```

or in a simplified way (can run more tasks):

```bash
./gradlew stop
```
