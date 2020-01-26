# Universal Kotlin

## Library -> Multiple Sources

Module with an example of a multiplatform library.
Similarly to the [:common-multiple_sources](common/multiple_sources/readme.md) module, this library shows how to use multiple
source folders for all targets. Please see the documentation of the [:common-multiple_sources](common/multiple_sources/readme.md)
for more information.

It uses the common modules as dependencies.

<!--
## Screenshot

## Architecture

### Targets

### Source Sets
-->

## Setting Up

```bash
export enabledModules="library-multiple_sources"
```

The other modules, on which this module depends, will be automatically enabled.

## Building

```bash
./gradlew :library-multiple_sources:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :library-multiple_sources:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

Testing if the library can be published to the local maven repository:

```bash
./gradlew :library-multiple_sources:publishToMavenLocal
```

or in a simplified way (can run more tasks):

```bash
./gradlew publishToMavenLocal
```

Listing the published library files:

For (Linux, MacOS, Unix):

```bash
ls -1a ~/.m2/repository/com/company/team/project
```

For Windows:

```bash
dir %userprofile%\.m2\repository\com\company\team\project
```

The expected output should be similar to this one:

```bash
library-multiple_sources
library-multiple_sources-iosx64
library-multiple_sources-js
library-multiple_sources-jvm
library-multiple_sources-macosx64
library-multiple_sources-metadata
library-multiple_sources-wasm32
```

<!-- TODO: include Windows documentation. -->
