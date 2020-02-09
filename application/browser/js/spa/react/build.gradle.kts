import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*

plugins {
	kotlin("multiplatform")
//	id("kotlin2js")
//	id("kotlin-dce-js")
//	id("org.jetbrains.kotlin.frontend")
//	id("kotlinx-serialization")
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-browser-js-spa-react`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-browser-js-spa-react@js@main`) {
			kotlin.setSrcDir("src/main/kotlin")
			resources.setSrcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-js"))

				implementation(npm("react", "16.9.0"))
				implementation(npm("react-dom", "16.9.0"))
				implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
				implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.14.0")
				implementation("org.jetbrains:kotlin-react:16.9.0-pre.89-kotlin-1.3.60")
				implementation("org.jetbrains:kotlin-react-dom:16.9.0-pre.89-kotlin-1.3.60")
			}
		}

		configureSourceSet(SourceSetEnum.`application-browser-js-spa-react@js@test`) {
			kotlin.setSrcDir("src/test/kotlin")
			resources.setSrcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test-js"))
			}
		}
	}

	js(TargetEnum.`application-browser-js-spa-react@js`) {
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
					outputFile = "${project.buildDir.path}/classes/kotlin/js/${project.name}.js"
					main = "call"
				}
			}
		}

//		browser {
////			testTask {
////				enabled = false
////			}
//		}
//		browser {
//			testTask {
//				useKarma {
//					useIe()
//					useSafari()
//					useFirefox()
//					useChrome()
//					useChromeCanary()
//					useChromeHeadless()
//					usePhantomJS()
//					useOpera()
//				}
//			}
//		}
	}
}

repositories {
	jcenter()
	mavenLocal()
	mavenCentral()
	maven( url = "http://dl.bintray.com/kotlin/kotlin-dev" )
	maven( url = "http://dl.bintray.com/kotlinx/kotlinx" )
	maven( url = "https://kotlin.bintray.com/kotlinx" )
	maven( url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers" )
}

//kotlinFrontend {
//	downloadNodeJsVersion = "latest"
//
//	sourceMaps = true
//
//	npm {
//		dependency("css-loader")
//		dependency("style-loader")
//		dependency("react")
//		dependency("react-dom")
//
//		devDependency("karma")
//	}
//
//	bundle<WebPackExtension>("webpack", {
//		(this as WebPackExtension).apply {
//			bundleName = "main"
//			sourceMapEnabled = true
//			contentPath = file("src/main/resources/public")
//			publicPath = "/"
//			host = "localhost"
//			port = 10002
//			mode = "development" // or "production"
////			proxyUrl = "http://localhost:30000"
////			stats = "errors-only"
//		}
//	})
//
////	karma {
////		port = 9876
////		runnerPort = 9100
////		reporters = mutableListOf("progress")
////		frameworks = mutableListOf("qunit") // for now only qunit works as intended
//////		preprocessors = mutableListOf("...")
//////
//////		customConfigFile = "myKarma.conf.js" // Custom configuration
////	}
////
////	define("PRODUCTION", false)
////	define("X", false)
//}
