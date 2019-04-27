# Universal Kotlin

## Library -> Multiple Modules

<!-- TODO: fix or complete the documentation -->

<!--
Module with an example of a multiplatform library.
Similarly to the [:commonMultipleModules](common/multiple_modules/readme.md) module, this library shows how to use several
modules. Please see the documentation of the [:commonMultipleModules](common/multiple_modules/readme.md)
for more information.

## Screenshot

## Architecture

### Targets

### Source Sets

## Setting Up

```bash
export enabledModules="
	common:multiple_modules:submodule_1
	, common:multiple_modules:submodule_2
	... and so on ...
	, common:multiple_modules:submodule_n
"
```

## Building

Usually there's no need to build this module separately since it's used as a
dependency in other modules. But if you would like to build only this module do:

```bash
./gradlew \
 :common:multiple_modules:submodule_1:build \
 :common:multiple_modules:submodule_2:build \
 ... and so on ...
 :common:multiple_modules:submodule_n:build \

```

## Testing

```bash
./gradlew \
 :common:multiple_modules:submodule_1:check \
 :common:multiple_modules:submodule_2:check \
 ... and so on ...
 :common:multiple_modules:submodule_n:check \

```

## Running

This module does not run separately, but as a part of other modules.
-->
