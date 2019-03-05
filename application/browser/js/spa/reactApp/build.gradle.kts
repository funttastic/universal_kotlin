import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension

plugins {
	kotlin("multiplatform")
//	id("kotlin2js")
	id("kotlin-dce-js")
	id("org.jetbrains.kotlin.frontend")
	id("kotlinx-serialization")
}

kotlin {
	val commonAttribute = Attribute.of("com.company.team.project.common.single_source_set", String::class.java)

	js {
		attributes.attribute(commonAttribute, "jsSpaReact")

		configure(listOf(compilations["main"], compilations["test"])) {
			tasks.getByName(compileKotlinTaskName) {
				kotlinOptions {
//					languageVersion = "1.3"
					metaInfo = true
					sourceMap = true
					sourceMapEmbedSources = "always"
					moduleKind = "umd"
				}
			}
		}

		configure(listOf(compilations["main"])) {
			tasks.getByName(compileKotlinTaskName) {
				kotlinOptions {
//					outputFile = "${project.buildDir.path}/js/${project.name}.js"
					main = "call"
				}
			}
		}
	}

	sourceSets {
		val jsMain by getting {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(project(":common:single_source_set"))

				implementation(kotlin("stdlib-js"))

				implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
				implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.10.0")
				implementation("org.jetbrains:kotlin-react:16.6.0-pre.68-kotlin-1.3.20")
				implementation("org.jetbrains:kotlin-react-dom:16.6.0-pre.68-kotlin-1.3.20")
			}
		}

		val jsTest by getting {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(project(":common:single_source_set"))

				implementation(kotlin("test-js"))
			}
		}
	}
}

repositories {
	jcenter()
	mavenLocal()
	mavenCentral()
	maven { url = uri("http://dl.bintray.com/kotlin/kotlin-dev") }
	maven { url = uri("http://dl.bintray.com/kotlinx/kotlinx") }
	maven { url = uri("https://kotlin.bintray.com/kotlinx") }
	maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
}

kotlinFrontend {
	downloadNodeJsVersion = "latest"

	sourceMaps = true

	npm {
		dependency("css-loader")
		dependency("style-loader")
		dependency("react")
		dependency("react-dom")

		devDependency("karma")
	}

	bundle<WebPackExtension>("webpack", {
		(this as WebPackExtension).apply {
			bundleName = "main"
			sourceMapEnabled = true
			contentPath = file("src/main/resources/public")
			publicPath = "/"
			host = "localhost"
			port = 3100
			mode = "development" // or "production"
//			proxyUrl = "http://localhost:30000"
//			stats = "errors-only"
		}
	})

//	karma {
//		port = 9876
//		runnerPort = 9100
//		reporters = mutableListOf("progress")
//		frameworks = mutableListOf("qunit") // for now only qunit works as intended
////		preprocessors = mutableListOf("...")
////
////		customConfigFile = "myKarma.conf.js" // Custom configuration
//	}
//
//	define("PRODUCTION", false)
//	define("X", false)
}
