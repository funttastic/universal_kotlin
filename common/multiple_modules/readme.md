# Universal Kotlin

## Common -> Multiple Modules

<!-- TODO: fix or complete the documentation -->

<!--
Instead of using a single module to keep the common code we can use an approach
to split all of this configuration.

Here is where these modules live.

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
