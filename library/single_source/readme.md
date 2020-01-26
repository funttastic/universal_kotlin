# Universal Kotlin

## Library -> Single Source

Module with an example of a multiplatform library.
Similarly to the [:common-single_source](common/single_source/readme.md) module, this library shows how to use just one
source folder for all targets. Please see the documentation of the [:common-single_source](common/single_source/readme.md)
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
export enabledModules="library-single_source"
```

The other modules, on which this module depends, will be automatically enabled.

## Building

```bash
./gradlew :library-single_source:build
```

or in a simplified way (can run more tasks):

```bash
./gradlew build
```

## Testing

```bash
./gradlew :library-single_source:check
```

or in a simplified way (can run more tasks):

```bash
./gradlew check
```

## Running

Testing if the library can be published to the local maven repository:

```bash
./gradlew :library-single_source:publishToMavenLocal
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
library-single_source
library-single_source-iosx64
library-single_source-js
library-single_source-jvm
library-single_source-macosx64
library-single_source-metadata
library-single_source-wasm32
```

<!-- TODO: include Windows documentation. -->
