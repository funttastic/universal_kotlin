# Universal Kotlin

## Application -> Script -> JVM -> Script

Module with a Kotlin Script to run through KScript.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

<!-- Fix documentation -->
<!--
## Setting Up

```bash
export enabledModules="application-script-jvm-script"
```

## Building

```bash
./gradlew :application-script-jvm-script:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :application-script-jvm-script:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```
-->

## Running

```bash
kscript application/script/jvm/script/src/main/kotlin/com/company/team/project/application/script/jvm/script/Example.kt
```

or if you are in the same path of the script file:

```bash
kscript Example.kt
```

The output should be similar to this one (KScript is not using common dependencies yet):

```bash
[package com.company.team.project.application.script.jvm.script]
```
