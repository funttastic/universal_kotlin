import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension

plugins {
	kotlin("multiplatform")
//	id("kotlin2js")
	id("kotlin-dce-js")
	id("org.jetbrains.kotlin.frontend")
	id("kotlinx-serialization")
}

//group = "com.company.team.application.browser.js.vanilla"
//version = "0.0.1"

kotlin {
	configureTargetAttributes(ModuleEnum.`application-browser-js-vanilla`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

	js(TargetEnum.`application-browser-js-vanilla@js`) {
		configure(listOf(compilations[CompilationEnum.main.id!!], compilations[CompilationEnum.test.id!!])) {
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

		configure(listOf(compilations[CompilationEnum.main.id!!])) {
			tasks.getByName(compileKotlinTaskName) {
				kotlinOptions {
//					outputFile = "${project.buildDir.path}/js/${project.name}.js"
					main = "call"
				}
			}
		}
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-browser-js-vanilla@js@main`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`application-browser-js-vanilla@js@test`) {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test-js"))
			}
		}
	}
}

kotlinFrontend {
	downloadNodeJsVersion = "latest"

	sourceMaps = true

	npm {
//		dependency("css-loader")
//		dependency("style-loader")

//		devDependency("karma")
	}

	bundle<WebPackExtension>("webpack", {
		(this as WebPackExtension).apply {
			bundleName = "main"
			sourceMapEnabled = true
			contentPath = file("src/main/resources/public")
			publicPath = "/"
			host = "localhost"
			port = 10003
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


//tasks.withType<Kotlin2JsCompile> {
//	kotlinOptions {
////		languageVersion = "1.3"
//		moduleKind = "umd"
//		sourceMap = true
//		metaInfo = true
//	}
//}
//
//val webFolder = File(project.buildDir, "../src/main/web")
//val jsCompilations = kotlin.targets["js"].compilations
//
//task("populateWebFolder"){
//	dependsOn("jsMainClasses")
//	doLast {
//		copy {
//			from(jscompilations[CompilationEnum.main.id!!].output)
//				from(kotlin.sourceSets["jsMain"].resources.srcDirs)
//			(jscompilations[CompilationEnum.test.id!!]as KotlinJsCompilation).runtimeDependencyFiles.forEach {
//					if (it.exists() && !it.isDirectory()) {
//						from(zipTree(it.absolutePath).matching { include("*.js") })
//					}
//				}
//			into(webFolder)
//		}
//	}
//}
//
//tasks.getByName("jsJar") {
//	dependsOn("populateWebFolder")
//}
