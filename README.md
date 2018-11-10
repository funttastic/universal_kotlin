# Universal Kotlin

An universal Kotlin project that aims to run on ALL supported platforms.

## Currently Supported Platforms

- Common: a common module with code to use in all platforms
	- supports common, js, jvm, and native code
- Library: a module to build a multiplatform library in all platforms
	- supports common, js, jvm, and native code
	- can use code from the common module
- Application: a module to hold as many as possible different kotlin applications
	- supports the following applications: JVM Terminal (CLI) Application
	- wanted applications: JVM Android Application, and others. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing 
purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

The project prerequisites are:

```
Java 8 or superior
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

To deploy this project do:

[TODO]

## Built With

* [Kotlin](https://kotlinlang.org/) - Multi-purpose programming language
* [Gradle](https://gradle.org/) - Dependency management

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/funttastic/universal-kotlin/tags). 

## Authors

* **[Danilo Araújo Silva](https://goo.gl/D0Oedt)** - *Initial work* - [Funttastic](https://www.funttastic.com/)

See also the list of [contributors](https://github.com/funttastic/universal-kotlin/graphs/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* I would like to thank [all Kotlin's contributors](https://github.com/JetBrains/kotlin/graphs/contributors), 
	which are doing a very good job. Thanks a lot!
