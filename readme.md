<p align="center">
	<a href="https://github.com/funttastic/universal-kotlin">
		<img src="https://raw.githubusercontent.com/funttastic/universal-kotlin/development/resources/design/logo/logo.png" alt="Universal Kotlin Logo" width="180" height="180">
	</a>
</p>

<h3 align="center">Universal Kotlin</h3>

<h4 align="center">An universal Kotlin project that aims to run on <strong>ALL</strong> supported platforms</h4>

<br/>

## Status
<p>
	<a href="https://travis-ci.com/funttastic/universal-kotlin">
			<img
					src="https://circleci.com/gh/funttastic/universal-kotlin/tree/master.svg?style=svg"
					align="right"
			/>
	</a>
	CircleCI (Linux (JDK 8))
</p>
<p>
	<a href="https://travis-ci.com/funttastic/universal-kotlin">
			<img align="right" src="https://travis-ci.com/funttastic/universal-kotlin.svg?branch=master" />
	</a>
	Travis (MacOS, XCode 9.3 (JDK 8))
</p>
<p>
	<a href="https://ci.appveyor.com/project/funttastic/universal-kotlin/branch/master">
			<img align="right" src="https://ci.appveyor.com/api/projects/status/jkg4rkxt8m33jd69/branch/master?svg=true" />
	</a>
	AppVeyour (Windows, Visual Studio 2017 (JDK 8))
</p>

## Architechture

- common
	- [x] <strong>single_source</strong>: Common module using just a single source
	- [ ] <strong>multiple_sources</strong>: Common module using multiple sources
	- [ ] <strong>multiple_modules</strong>: Common module using multiple modules
- library
	- [x] <strong>example</strong>: Multiplatform example library
- application
	- backend
		- jvm
			- [x] <strong>spring_boot</strong>: Spring Boot API application
	- browser
		- js
			- spa
				- [x] <strong>reactApp</strong>: React with webpack application
			- [x] <strong>vanilla</strong>: Vanilla JavaScript application
		- native
			- [x] <strong>wasm32</strong>: WebAssembly application
	- desktop
		- jvm
			- [x] <strong>tornado_fx</strong>: TornadoFX application
	- mobile
		- jvm
			- [x] <strong>android</strong>: Android application
		- native
			- [x] <strong>iosApp</strong>: iOS application
	- terminal
		- jvm
			- [x] <strong>terminal</strong>: Terminal application
	
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing 
purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

The project prerequisites are:

```
JDK 8
```

### Installing

1. Clone:

	```
	git clone https://github.com/funttastic/universal-kotlin.git
	```

2. Run:

	```
	cd universal-kotlin
	./gradlew build
	```

## Running the tests

To run the test do:

```
./gradlew test
```

## Deployment

Please refer to the `readme` of the correspondent module.

## Built With

* [Kotlin](https://kotlinlang.org/) (`1.3.21`): Multi-purpose programming language
* [Gradle](https://gradle.org/) (`5.2.1`): Dependency management

<!--
## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/funttastic/universal-kotlin/tags).
-->

## Authors

### Contributors

All contributions are very welcome. [Contribute!](contributing.md)

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
	<strong>Danilo Araújo Silva</strong> - <i>Initial work</i> - Funttastic
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

We would like to thank [all Kotlin's contributors](https://github.com/JetBrains/kotlin/graphs/contributors), which are doing a very good job. Thanks a lot!
	
## License

Licensed under the MIT License.

See [license](license.md) for more information.
