import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
	kotlin("multiplatform")
//	id("kotlin2js")
	id("kotlin-dce-js")
	id("org.jetbrains.kotlin.frontend")
//	id("kotlinx-serialization")
}

//repositories {
//	jcenter()
//	mavenLocal()
//	mavenCentral()
//	maven { url = uri("http://dl.bintray.com/kotlin/kotlin-dev") }
//	maven { url = uri("http://dl.bintray.com/kotlinx/kotlinx") }
//	maven { url = uri("https://kotlin.bintray.com/kotlinx") }
//	maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
//}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib-js:1.3.20")
	implementation("org.jetbrains.kotlin:kotlin-test-js:1.3.20")
	implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.10.0")
	implementation("org.jetbrains:kotlin-react:16.6.0-pre.68-kotlin-1.3.20")
	implementation("org.jetbrains:kotlin-react-dom:16.6.0-pre.68-kotlin-1.3.20")
}

kotlinFrontend {
	downloadNodeJsVersion = "latest"

	sourceMaps = true

	npm {
		dependency("style-loader")
		dependency("react")
		dependency("react-dom")

		devDependency("karma")
	}

	bundle<WebPackExtension>("webpack", {
		(this as WebPackExtension).apply {
			bundleName = "main"
			contentPath = file("src/main/web")
		}
	})
}

//kotlinFrontend {
//	sourceMaps = true
//
//	npm {
//		dependency("css-loader")
//		dependency("style-loader")
//		devDependency("karma")
//	}
//
//	bundle<WebPackExtension>("webpack", {
//		(this as WebPackExtension).apply {
//			port = 8080
//			publicPath = "/frontend/"
//			proxyUrl = "http://localhost:9000"
//		}
//	})
//
//	define("PRODUCTION", true)
//}

tasks.withType<Kotlin2JsCompile> {
	kotlinOptions {
//		languageVersion = "1.3"
//		moduleKind = "umd"
//		sourceMap = true
//		metaInfo = true

		metaInfo = true
		outputFile = "$project.buildDir.path/js/${project.name}.js"
		sourceMap = true
		moduleKind = "commonjs"
		main = "call"
	}
}
