import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import com.github.salomonbrys.gradle.kotlin.js.jstests.node.Engine.Companion.mocha
import groovy.util.Node

plugins {
	kotlin("multiplatform")
	id("maven-publish")
	id("signing")

	id("com.github.salomonbrys.gradle.kotlin.js.mpp-tests.node")
}

kotlin {
	configureTargetAttributes(ModuleEnum.`library-multiple_sources`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}


	androidNativeArm32(TargetEnum.`library-multiple_sources@android_native_arm32`) {
	}

	androidNativeArm64(TargetEnum.`library-multiple_sources@android_native_arm64`) {
	}

	iosArm32(TargetEnum.`library-multiple_sources@ios_arm32`) {
		compilations[CompilationEnum.main.id!!].outputKinds("framework")
	}

	iosArm64(TargetEnum.`library-multiple_sources@ios_arm64`) {
		compilations[CompilationEnum.main.id!!].outputKinds("framework")
	}

	iosX64(TargetEnum.`library-multiple_sources@ios_x64`) {
		compilations[CompilationEnum.main.id!!].outputKinds("framework")
	}

	js(TargetEnum.`library-multiple_sources@js`) {
		kotlinJsNodeTests {
			thisTarget {
				engine = mocha
			}
		}

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

	jvm(TargetEnum.`library-multiple_sources@jvm`) {
	}

	linuxArm32Hfp(TargetEnum.`library-multiple_sources@linux_arm32_hfp`) {
	}

	linuxMips32(TargetEnum.`library-multiple_sources@linux_mips32`) {
	}

	linuxMipsel32(TargetEnum.`library-multiple_sources@linux_mipsel32`) {
	}

	linuxX64(TargetEnum.`library-multiple_sources@linux_x64`) {
	}

	macosX64(TargetEnum.`library-multiple_sources@macos_x64`) {
	}

	mingwX64(TargetEnum.`library-multiple_sources@mingw_x64`) {
	}

	wasm32(TargetEnum.`library-multiple_sources@wasm32`) {
	}

	sourceSets {
		all {
			val sourceSetEnum =
				when (name) {
					SourceSetEnum.`common-single_source@main@common`.kotlinId -> SourceSetEnum.`common-single_source@main@common`
					SourceSetEnum.`common-single_source@test@common`.kotlinId -> SourceSetEnum.`common-single_source@test@common`
					else -> SourceSetEnum.getByKotlinIdAndModule(name, ModuleEnum.`library-multiple_sources`)!!
				}

			if (CompilationEnum.main == sourceSetEnum.compilation) {
				kotlin.srcDir(getMainSourcesPath(sourceSetEnum))
				resources.srcDir(getMainResourcesPath(sourceSetEnum))
			} else if (CompilationEnum.test == sourceSetEnum.compilation) {
				kotlin.srcDir(getTestSourcesPath(sourceSetEnum))
				resources.srcDir(getTestResourcesPath(sourceSetEnum))
			}

//			languageSettings {
//				progressiveMode = true
//			}
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@common`) {
			dependencies {
				implementation(kotlin("stdlib-common"))
			}

//			languageSettings {
//				languageVersion = "1.3" // possible values: "1.0", "1.1", "1.2", "1.3"
//				apiVersion = "1.3" // possible values: "1.0", "1.1", "1.2", "1.3"
//				enableLanguageFeature("InlineClasses") // language feature name
//				useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes") // annotation FQ-name
//				progressiveMode = true // false by default
//			}
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@common`) {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@android_native_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@android_native_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@android_native_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@android_native_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@ios_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@ios_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@ios_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@ios_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@ios_x64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@ios_x64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@js`) {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@js`) {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@jvm`) {
			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@jvm`) {
			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@linux_arm32_hfp`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@linux_arm32_hfp`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@linux_mips32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@linux_mips32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@linux_mipsel32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@linux_mipsel32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@linux_x64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@linux_x64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@macos_x64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@macos_x64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@mingw_x64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@mingw_x64`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@main@wasm32`) {
		}

		configureSourceSet(SourceSetEnum.`library-multiple_sources@test@wasm32`) {
		}
	}
}

configurations {
	val compileClasspath by creating {
	}
}

fun getPath(sourceTypeEnum: SourceTypeEnum, compilationEnum: CompilationEnum, sourceSetEnum: SourceSetEnum): String {
	return "src/${sourceSetEnum.kotlinId!!}/${sourceTypeEnum.id!!}"
}

fun getSourcesPath(compilationEnum: CompilationEnum, sourceSetEnum: SourceSetEnum): String {
	return getPath(SourceTypeEnum.kotlin, compilationEnum, sourceSetEnum)
}

fun getResourcesPath(compilationEnum: CompilationEnum, sourceSetEnum: SourceSetEnum): String {
	return getPath(SourceTypeEnum.resources, compilationEnum, sourceSetEnum)
}

fun getMainSourcesPath(sourceSetEnum: SourceSetEnum): String {
	return getSourcesPath(CompilationEnum.main, sourceSetEnum)
}

fun getTestSourcesPath(sourceSetEnum: SourceSetEnum): String {
	return getSourcesPath(CompilationEnum.test, sourceSetEnum)
}

fun getMainResourcesPath(sourceSetEnum: SourceSetEnum): String {
	return getResourcesPath(CompilationEnum.main, sourceSetEnum)
}

fun getTestResourcesPath(sourceSetEnum: SourceSetEnum): String {
	return getResourcesPath(CompilationEnum.test, sourceSetEnum)
}

publishing {
    repositories {
       mavenLocal()
    }
}

// Add a Javadoc JAR to each publication as required by Maven Central

val javadocJar by tasks.creating(Jar::class) {
    archiveClassifier.value("javadoc")
    // TODO: instead of a single empty Javadoc JAR, generate real documentation for each module
}

publishing {
    publications.withType<MavenPublication>().all {
        artifact(javadocJar)
    }
}

//// The root publication also needs a sources JAR as it does not have one by default

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.value("sources")
}

publishing.publications.withType<MavenPublication>().getByName("kotlinMultiplatform").artifact(sourcesJar)

//// Customize the POMs adding the content required by Maven Central

fun customizeForMavenCentral(pom: org.gradle.api.publish.maven.MavenPom) = pom.withXml {
    fun Node.add(key: String, value: String) {
        appendNode(key).setValue(value)
    }

    fun Node.node(key: String, content: Node.() -> Unit) {
        appendNode(key).also(content)
    }

    asNode().run {
        add("description", "Universal Kotlin Multiplatform library using multiple sources.")
        add("name", "Multiple Sources Multiplatform Library - Universal Kotlin")
        add("url", "https://github.com/funttastic/universal_kotlin")
        node("organization") {
            add("name", "com.github.funttastic")
            add("url", "https://github.com/funttastic")
        }
        node("issueManagement") {
            add("system", "github")
            add("url", "https://github.com/funttastic/universal_kotlin/issues")
        }
        node("licenses") {
            node("license") {
                add("name", "MIT")
                add("url", "https://github.com/funttastic/universal_kotlin/blob/master/license.md")
                add("distribution", "repo")
            }
        }
        node("scm") {
            add("url", "https://github.com/funttastic/universal_kotlin")
            add("connection", "scm:git:git://github.com/funttastic/universal_kotlin.git")
            add("developerConnection", "scm:git:ssh://github.com/funttastic/universal_kotlin.git")
        }
        node("developers") {
            node("developer") {
                add("name", "funttastic")
            }
        }
    }
}

publishing {
    publications.withType<MavenPublication>().all {
        customizeForMavenCentral(pom)
    }
}

//// Sign the publications:

////// Also requires that signing.keyId, signing.password, and signing.secretKeyRingFile are provided as Gradle
////// properties.

////// No complex signing configuration is required here, as the signing plugin interoperates with maven-publish
////// and can simply add the signature files directly to the publications:

// publishing {
//     publications.withType<MavenPublication>().all {
//         signing.sign(this@all)
//     }
// }
