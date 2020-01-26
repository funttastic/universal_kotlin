# Universal Kotlin

## Application -> Desktop -> JVM -> Tornado FX

Module with a Tornado FX desktop application.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="application-desktop-jvm-tornado_fx"
```

## Building

```bash
./gradlew :application-desktop-jvm-tornado_fx:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :application-desktop-jvm-tornado_fx:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

Run with:

```bash
./gradlew :application-desktop-jvm-tornado_fx:run
```

<!--
Or create a fatJar with:

```bash
./gradlew :application-desktop-jvm-tornado_fx:shadowJar
```

and run the fatJar with:

````bash
java -jar application/desktop/jvm/tornado_fx/build/libs/application-desktop-jvm-tornado_fx-0.0.1.jar
````
-->

You should see the TornadoFx application window.

The output should be similar to this one:

```bash
["com.company.team.project.common.multiple_sources.jvm","com.company.team.project.common.single_source.common","com.company.team.project.common.single_source.jvm.common","com.company.team.project.application.desktop.jvm.tornado_fx"]
```
