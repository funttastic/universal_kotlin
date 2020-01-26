# Universal Kotlin

## Common -> Single Source

Module with code common to all other modules.

This module is so called `single_source` because all code, from all source sets,
live in the same folder (`src/main` or `src/test` for tests). This is possible
because all packages are well organized preventing conflicts.

Another alternative is to use the `multiple_sources` module, which is the most
common approach for multiplatform projects.

Note that we still can use the kotlin `expect` declarations with this method,
but we will need to put the code on a different directory.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="common-single_source"
```

## Building

Usually there's no need to build this module separately since it's used as a
dependency in other modules. But if you would like to build only this module do:

```bash
./gradlew :common-single_source:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :common-single_source:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

This module does not run separately, but as a part of other modules.
