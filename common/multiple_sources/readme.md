# Universal Kotlin

## Common -> Multiple Sources

Module with code common to all other modules.

This module is so called `multiple_sources` because the code of each source set
live in its own folder. This is the usual approach for multiplatform projects.

For example, the code common to all jvm projects lives in the `src/jvmMain`
(or `src/jvmTest` for tests) folder. And the code common to all JavaScript
applications lives in the `src/jsMain` (or `src/jsTest` for tests) folder.

Another alternative is to use the `single_source` module, which shows how we
can use all source sets in the same folder.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="common-multiple_sources"
```

## Building

Usually there's no need to build this module separately since it's used as a
dependency in other modules. But if you would like to build only this module do:

```bash
./gradlew :common:common-multiple_sources:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :common:common-multiple_sources:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

This module does not run separately, but as a part of other modules.
