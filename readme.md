<p align="center">
	<a href="https://github.com/funttastic/universal-kotlin">
		<img src="https://raw.githubusercontent.com/funttastic/universal-kotlin/development/resources/design/logo/logo.png" alt="Universal Kotlin Logo" width="180" height="180">
	</a>
</p>

<h3 align="center">Universal Kotlin</h3>

<h4 align="center">One language to rule them all!</h4>

<br/>

## Status
<p>
	<a href="https://ci.appveyor.com/project/funttastic/universal-kotlin/branch/master">
			<img align="right" src="https://ci.appveyor.com/api/projects/status/158nax2h6hvw9bhv/branch/master?svg=true" />
	</a>
	AppVeyour (Windows)
</p>
<p>
	<a href="https://circleci.com/gh/funttastic/universal_kotlin/tree/master">
			<img
					src="https://circleci.com/gh/funttastic/universal_kotlin/tree/master.svg?style=svg"
					align="right"
			/>
	</a>
	CircleCI (Linux)
</p>
<p>
	<a href="https://travis-ci.com/funttastic/universal_kotlin">
			<img align="right" src="https://api.travis-ci.com/funttastic/universal_kotlin.svg?branch=master" />
	</a>
	Travis (MacOS)
</p>

## Overview

Universal Kotlin is a project that aims to run on the most popular platforms using just Kotlin.
Also, one of its goals is to use shared code from the common modules and libraries in all other ones.

## Architecture

- [x] <strong>[buildSrc](buildSrc)</strong>: Kotlin DSL module to help with the build scripts
- common
	- [x] <strong>[multiple_sources](common/multiple_sources)</strong>: Common module using multiple sources folders
	- [x] <strong>[single_source](common/single_source)</strong>: Common module using just a single source folders
- library
	- [x] <strong>[multiple_sources](library/multiple_sources)</strong>: Multiplatform library using multiple sources folders
	- [x] <strong>[single_source](library/single_source)</strong>: Multiplatform library using just a single source folders
- application
	- backend
	    - js
	        - [ ] <strong>[express](application/backend/js/express)</strong>: Express API application (not yet implemented)
		- jvm
			- [x] <strong>[spring_boot](application/backend/jvm/spring_boot)</strong>: Spring Boot API application
	- browser
		- js
			- spa
				- [x] <strong>[react](application/browser/js/spa/react)</strong>: React with Webpack application
			- [x] <strong>[vanilla](application/browser/js/vanilla)</strong>: Vanilla JavaScript with Webpack application
		- native
			- [x] <strong>[wasm32](application/browser/native/wasm32)</strong>: WebAssembly application
	- desktop
		- jvm
			- [x] <strong>[tornado_fx](application/desktop/jvm/tornado_fx)</strong>: TornadoFX application for Windows, Linux and Mac
	- mobile
		- jvm
			- [x] <strong>[android](application/mobile/jvm/android)</strong>: Android application
		- native
			- apple
				- ios
					- [x] <strong>[ios_x64_copying_framework](application/mobile/native/apple/ios/ios_x64_copying_framework)</strong>: iOS X64 application copying a Kotlin framework
					- [x] <strong>[ios_x64_framework](application/mobile/native/apple/ios/ios_x64_framework)</strong>: iOS X64 Kotlin framework only
					- [x] <strong>[ios_x64_with_framework](application/mobile/native/apple/ios/ios_x64_with_framework)</strong>: iOS X64 application with a Kotlin framework
					- [ ] <strong>[ios_x64_without_framework](application/mobile/native/apple/ios/ios_x64_witout_framework)</strong>: iOS X64 application using only Kotlin
	- script
  		- jvm
  			- [x] <strong>[script](application/script/jvm/script)</strong>: Script application running through KScript (not using common modules yet)
    - television
        - native
            - apple
                - tvos
                    - [ ] <strong>[tvos_x64](application/television/native/apple/tvos/tvos_x64)</strong>: tvOS X64 application (not yet implemented)
	- terminal
		- jvm
			- [x] <strong>[terminal](application/terminal/jvm/terminal)</strong>: Terminal application
    - watch
        - native
            - apple
                - watchos
                    - [ ] <strong>[watchos_x64](application/television/native/apple/watchos/watch_x64)</strong>: watchOS X64 application (not yet implemented)
- plugin
	- [ ] <strong>[gradle](plugin/jvm/gradle)</strong>: Gradle plugin (not using common modules)


This structure is also available in this diagram:

<img
    src="https://raw.githubusercontent.com/funttastic/universal_kotlin/development/resources/architecture/diagram/graphviz/images/modules.svg?sanitize=true"
    alt="Modules Diagram"
    width="882"
    height="90"
/>

Other diagrams can be found in the [diagrams](resources/architecture/diagram/graphviz) folder.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

The CIs configurations can be found at:

- [AppVeyor](appveyor.yml) (being used for Windows)
- [CircleCI](.circleci/config.yml) (being used for Linux)
- [Travis](.travis.yml) (being used for MacOS)

<!--
These instructions will get you a copy of the project up and running on your local machine for development and testing
purposes.
See the [Deployment](https://github.com/funttastic/universal_kotlin#deployment) section for notes on how to deploy the project on a live system.
-->

### Prerequisites

The project prerequisites are:

- [JDK 8](https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html)

Note that JavaFX support is needed for the TornadoFX module, if you are using OpenJDK, consider changing to Oracle
or Zulu (FX) for a more straightforward configuration.

Specific prerequisites:

- [Android SDK or Android Studio](https://developer.android.com/studio#downloads) (if you're going to use the [android](application/mobile/jvm/android) module.)
- [XCode](https://developer.apple.com/xcode/) (if you're going to use the [iOS](application/mobile/native/apple/ios) modules.)
- [KScript](https://github.com/holgerbrandl/kscript) (if you're going to use the [script](application/script/jvm/script) module.)
- [Konan](https://github.com/JetBrains/kotlin-native) (for Kotlin Native modules, but this dependency will be automatically installed when building these modules.)

If you don't have `Java` or `KScript` installed yet, consider to use [SDKMAN!](https://sdkman.io/install)
to install these packages on a straightforward way.

If you don't have the `Android SDK`, go to this [link](https://developer.android.com/studio#downloads)
and download the command line tools or `Android Studio`.

If you don't have `XCode` you can download it from the [Apple Store](https://developer.apple.com/xcode/).

### Installing

1. Clone:

```bash
git clone https://github.com/funttastic/universal_kotlin.git

cd universal_kotlin
```

2. Configure:

If you are going to use the Android module, it is needed to configure `ANDROID_HOME` as system environment variable:

```bash
export ANDROID_HOME="/Users/<username>/Library/Android/sdk"
```

or create a `local.properties` file and configure it appropriately. A template is available at
`local.properties.template`.

Also the Android module can be disabled directly in the `com.company.team.project.dsl.model.enum_.ModuleEnum` enum
or exporting the `disabledModules` environment variable:

```bash
export disabledModules="application-mobile-jvm-android"
```

<!--
The build script will automatically try to define the `ANDROID_HOME` system variable looking at the default paths.
But if you need to customize it, you can set the `sdk.dir` property in your `local.properties` file or define the
`ANDROID_HOME` variable in your system environment.

There is a [local.properties.template](local.properties.template) file available that you can use as a basis.
-->

3. Build:

```bash
./gradlew build
```

Obs.: since this build will be enabling all modules, this could take too long.
But you can enable or disable modules going to this class inside the [buildSrc](buildSrc) module:

> com.company.team.project.dsl.model.enum_.ModuleEnum

Also you can enable or disable modules using environment variables (`enabledModules` and `disabledModules`).
Check the [common-multiple_sources](common/multiple_sources) module for an example.

The `buildSrc` method responsible to define which modules will be enabled and which don't is this one:

> com.company.team.project.dsl.Util.initialize

## Running the tests

To run the tests/checks do:

```
./gradlew check
```

or

```
./gradlew test
```

Note that the `check` task depends on the `test` one ([reference](https://docs.gradle.org/current/userguide/java_plugin.html)).

## Running

Please refer to the `readme` of the correspondent module that you would like to run.

<!--
## Deploy

Please refer to the `readme` of the correspondent module that you would like to deploy.
-->

## Built With

* [Kotlin](https://kotlinlang.org/) (`1.3.61`): Multi-purpose programming language
* [Gradle](https://gradle.org/) (`5.4.1`): Dependency management

Note that the modules themselves have many other dependencies and you can find them in their `build.gradle.kts` files.

<!--
## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/funttastic/universal-kotlin/tags).
-->

## FAQ

Please take a look at this documentation file for the [Frequently Asked Questions](resources/documentation/faq.md).

## Authors

### Contributors

All contributions are very welcome. Contribute!!!

<!--
This project exists thanks to [all the people who contribute](https://github.com/funttastic/universal_kotlin/graphs/contributors)!

Thanks a lot to all of our contributors!

All contributions are very welcome. [Contribute!](contributing.md)
-->

<!--
This project exists thanks to all the people who contribute. [Contribute!](contributing.md)

<a href="https://github.com/funttastic/universal-kotlin/graphs/contributors">
	<img src="https://opencollective.com/funttastic-universal-kotlin/contributors.svg?width=890" />
</a>
-->

### Creator

<a href="https://www.linkedin.com/in/daniloaraujosilva">
<img align="left" width="60" height="60" src="https://avatars2.githubusercontent.com/u/1139202?s=88&v=4" />

<p>
	<br/>
	<strong>Danilo Araújo Silva</strong></i>
</p>
</a>

<br/>

<!--
## Backers

Thank you to all our backers! 🙏 [Become a backer!](backing.md)

<a href="https://opencollective.com/funttastic-universal-kotlin#backers" target="_blank">
	<img src="https://opencollective.com/funttastic-universal-kotlin/backers.svg?width=890">
</a>

## Sponsor

Support this project by becoming a sponsor. Your logo will show up here with a link to your website. [Become a sponsor!](https://opencollective.com/funttastic-universal-kotlin#sponsor)

<a href="https://opencollective.com/funttastic-universal-kotlin/sponsor/1/website" target="_blank">
	<img src="https://opencollective.com/funttastic-universal-kotlin/sponsor/1/avatar.svg">
</a>
-->

## Acknowledgments

We would like to thank [all Kotlin's contributors](https://github.com/JetBrains/kotlin/graphs/contributors),
which are doing a very good job. Thanks a lot!

## License

Licensed under the Apache License 2.0.

See [license](license.md) for more information.
