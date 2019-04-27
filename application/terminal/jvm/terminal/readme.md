# Universal Kotlin

## Application -> Terminal -> Jvm -> Terminal

Module with a Terminal / CLI application.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="application-terminal-jvm-terminal"
```

## Building

```bash
./gradlew :application:application-terminal:application-terminal-jvm:application-terminal-jvm-terminal:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :application:application-terminal:application-terminal-jvm:application-terminal-jvm-terminal:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

Create a fatJar with:

```bash
./gradlew :application:application-terminal:application-terminal-jvm:application-terminal-jvm-terminal:shadowJar
```

or in a simplified way (can run more tasks):

```bash
./gradlew shadowJar
```

Run the fatJar with:

```bash
java -jar application/terminal/jvm/terminal/build/libs/application-terminal-jvm-terminal-0.0.1-all.jar
```

The output should be similar to this one:

```bash
[com.company.team.project.common.multiple_sources.jvm, com.company.team.project.common.single_source.common, com.company.team.project.common.single_source.jvm.common, package com.company.team.project.application.terminal.jvm.terminal]
```
