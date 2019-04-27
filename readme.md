<p align="center">
	<a href="https://github.com/funttastic/universal-kotlin">
		<img src="https://raw.githubusercontent.com/funttastic/universal-kotlin/development/resources/design/logo/logo.png" alt="Universal Kotlin Logo" width="180" height="180">
	</a>
</p>

<h3 align="center">Universal Kotlin</h3>

<h4 align="center">A multiplatform Kotlin project to rule them all</h4>

<br/>

## Status
<p>
	<a href="https://travis-ci.com/funttastic/universal-kotlin">
			<img
					src="https://circleci.com/gh/funttastic/universal_kotlin/tree/master.svg?style=svg"
					align="right"
			/>
	</a>
	CircleCI (Linux (JDK 8))
</p>
<p>
	<a href="https://travis-ci.com/funttastic/universal-kotlin">
			<img align="right" src="https://api.travis-ci.com/funttastic/universal_kotlin.svg?branch=master" />
	</a>
	Travis (MacOS, XCode 9.3 (JDK 8))
</p>
<p>
	<a href="https://ci.appveyor.com/project/funttastic/universal-kotlin/branch/master">
			<img align="right" src="https://ci.appveyor.com/api/projects/status/158nax2h6hvw9bhv/branch/master?svg=true" />
	</a>
	AppVeyour (Windows, Visual Studio 2017 (JDK 8))
</p>

## Overview

Universal Kotlin is a project that aims to run on the most popular platforms using just Kotlin.
Also, one of its goals is to use shared code from the common modules in all other ones.

## Architecture

- [x] <strong>buildSrc</strong>: Kotlin DSL module to help with the build scripts
- common
	- [x] <strong>single_source</strong>: Common module using just a single source
	- [x] <strong>multiple_sources</strong>: Common module using multiple sources
- library
	- [x] <strong>single_source</strong>: Multiplatform library using just a single source
	- [x] <strong>multiple_sources</strong>: Multiplatform library using multiple sources
- application
	- backend
		- jvm
			- [x] <strong>spring_boot</strong>: Spring Boot API application
	- browser
		- js
			- spa
				- [x] <strong>react</strong>: React with Webpack application
			- [x] <strong>vanilla</strong>: Vanilla JavaScript with Webpack application
		- native
			- [x] <strong>wasm32</strong>: WebAssembly application
	- desktop
		- jvm
			- [x] <strong>tornado_fx</strong>: TornadoFX application
	- mobile
		- jvm
			- [x] <strong>android</strong>: Android application
		- native
			- apple
				- ios
					- [x] <strong>ios_x64</strong>: iOS X64 application (without framework)
					- [x] <strong>ios_x64_copying_framework</strong>: iOS X64 application copying a Kotlin framework
					- [x] <strong>ios_x64_framework</strong>: iOS X64 Kotlin framework only
					- [x] <strong>ios_x64_with_framework</strong>: iOS X64 application with a Kotlin framework
	- script
  		- jvm
  			- [x] <strong>script</strong>: Script application running through KScript
	- terminal
		- jvm
			- [x] <strong>terminal</strong>: Terminal application
	
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing 
purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

The project prerequisites are:

- [JDK 8](https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html)

Specific prerequisites:

- [Android SDK or Android Studio](https://developer.android.com/studio#downloads) (if you're going to use the [android](application/mobile/jvm/android/readme.md) module.)
- [XCode](https://developer.apple.com/xcode/) (if you're going to use the [iOS](application/mobile/native/apple/ios) modules.)
- [KScript](https://github.com/holgerbrandl/kscript) (if you're going to use the [script](application/script/jvm/script/readme.md) module.)
- [Konan](https://github.com/JetBrains/kotlin-native) (for Kotlin Native modules, but this dependency will be automatically installed when building these modules.)

If you don't have `Java` or `KScript` installed yet, consider to use [SDKMAN](https://sdkman.io/install)
to install these packages on a straightforward way.

If you don't have the `Android SDK`, go to this [link](https://developer.android.com/studio#downloads)
and download the command line tools or `Android Studio`.

If you don't have `XCode` you can download it from the [Apple Store](https://developer.apple.com/xcode/).

### Installing

1. Clone:

```bash
git clone https://github.com/funttastic/universal_kotlin.git
```

2. Configure:

Create your `local.properties` configuration file.
A template is available at `local.properties.template`.

```bash
cp local.properties.template local.properties
```

Then change the `local.properties` file accordingly.

Note: after running any native module for the first time you will get `konan` installed on your machine.
The `konan.home` configuration is needed in the `wasm32` module to run the `jsinterop` task.

3. Run:

```bash
cd universal_kotlin

./gradlew build
```

Obs.: since this build will be enabling all modules, this could take too long.
But you can enable or disable modules going to this class in `buildSrc`:

> com.company.team.project.dsl.model.enum_.ModuleEnum

Also you can enable or disable modules using environment variables.
Check the [common-single_sources](common/multiple_sources/readme.md) module for an example.

## Running the tests

To run the tests / checks do:

```
./gradlew check
```

or

```
./gradlew test
```

Note the `check` task includes the `test` one.

## Deployment

Please refer to the `readme` of the correspondent module that you would like to deploy.

## Built With

* [Kotlin](https://kotlinlang.org/) (`1.3.31`): Multi-purpose programming language
* [Gradle](https://gradle.org/) (`5.4`): Dependency management

Note that the modules themselves have many other dependencies and you can find them in their `build.gradle.kts` files.

<!--
## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/funttastic/universal-kotlin/tags).
-->

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

<a href="https://goo.gl/D0Oedt">
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

Licensed under the MIT License.

See [license](license.md) for more information.
