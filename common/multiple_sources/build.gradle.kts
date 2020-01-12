import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*

plugins {
	kotlin("multiplatform")

	id("com.github.salomonbrys.gradle.kotlin.js.mpp-tests.node")
}

kotlin {
	configureTargetAttributes(ModuleEnum.`common-multiple_sources`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

	androidNativeArm32(TargetEnum.`common-multiple_sources@android_native_arm32`) {
	}

	androidNativeArm64(TargetEnum.`common-multiple_sources@android_native_arm64`) {
	}

	iosArm32(TargetEnum.`common-multiple_sources@ios_arm32`) {
		binaries {
			framework {}
		}
	}

	iosArm64(TargetEnum.`common-multiple_sources@ios_arm64`) {
		binaries {
			framework {}
		}
	}

	iosX64(TargetEnum.`common-multiple_sources@ios_x64`) {
		binaries {
			framework {}
		}
	}

	js(TargetEnum.`common-multiple_sources@js`) {
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

	jvm(TargetEnum.`common-multiple_sources@jvm`) {
	}

	linuxArm32Hfp(TargetEnum.`common-multiple_sources@linux_arm32_hfp`) {
	}

	linuxMips32(TargetEnum.`common-multiple_sources@linux_mips32`) {
	}

	linuxMipsel32(TargetEnum.`common-multiple_sources@linux_mipsel32`) {
	}

	linuxX64(TargetEnum.`common-multiple_sources@linux_x64`) {
	}

	macosX64(TargetEnum.`common-multiple_sources@macos_x64`) {
	}

	mingwX64(TargetEnum.`common-multiple_sources@mingw_x64`) {
	}

	wasm32(TargetEnum.`common-multiple_sources@wasm32`) {
	}

	sourceSets {
		all {
			val sourceSetEnum =
				when (name) {
					SourceSetEnum.`common-single_source@main@common`.kotlinId -> SourceSetEnum.`common-single_source@main@common`
					SourceSetEnum.`common-single_source@test@common`.kotlinId -> SourceSetEnum.`common-single_source@test@common`
					else -> SourceSetEnum.getByKotlinIdAndModule(name, ModuleEnum.`common-multiple_sources`)!!
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

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@common`) {
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

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@common`) {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@android_native_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@android_native_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@android_native_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@android_native_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@ios_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@ios_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@ios_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@ios_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@ios_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@ios_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@js`) {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@js`) {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@jvm`) {
			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@jvm`) {
			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@linux_arm32_hfp`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@linux_arm32_hfp`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@linux_mips32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@linux_mips32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@linux_mipsel32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@linux_mipsel32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@linux_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@linux_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@macos_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@macos_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@mingw_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@mingw_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@main@wasm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-multiple_sources@test@wasm32`) {
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
