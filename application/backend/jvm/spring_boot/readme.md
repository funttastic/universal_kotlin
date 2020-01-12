# Universal Kotlin

## Application -> Backend -> JVM -> Spring Boot

Module with a Spring Boot API JVM application.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="application-backend-jvm-spring_boot"
```

## Building

```bash
./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

Starting:

```bash
./gradlew :application:application-backend:application-backend-jvm:application-backend-jvm-spring_boot:bootRun
```

or in a simplified way (can run more tasks):

```bash
./gradlew bootRun
```

Calling the API:

```bash
curl "http://localhost:8080/exampleController/exampleMethod"
```

The output should be similar to this one:

```bash
["com.company.team.project.common.multiple_sources.jvm","com.company.team.project.common.single_source.common","com.company.team.project.common.single_source.jvm.common","com.company.team.project.application.backend.jvm.spring_boot"]
```
