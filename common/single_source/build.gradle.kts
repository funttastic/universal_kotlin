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

//	android(TargetEnum.`common-single_source@android`) {
//	}

	androidNativeArm32(TargetEnum.`common-single_source@android_native_arm32`) {
	}

	androidNativeArm64(TargetEnum.`common-single_source@android_native_arm64`) {
	}

	iosArm32(TargetEnum.`common-single_source@ios_arm32`) {
		compilations[CompilationEnum.main.id!!].outputKinds("framework")
	}

	iosArm64(TargetEnum.`common-single_source@ios_arm64`) {
		compilations[CompilationEnum.main.id!!].outputKinds("framework")
	}

	iosX64(TargetEnum.`common-single_source@ios_x64`) {
		compilations[CompilationEnum.main.id!!].outputKinds("framework")
	}

	js(TargetEnum.`common-single_source@js`) {
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

	jvm(TargetEnum.`common-single_source@jvm`) {
	}

	linuxArm32Hfp(TargetEnum.`common-single_source@linux_arm32_hfp`) {
	}

	linuxMips32(TargetEnum.`common-single_source@linux_mips32`) {
	}

	linuxMipsel32(TargetEnum.`common-single_source@linux_mipsel32`) {
	}

	linuxX64(TargetEnum.`common-single_source@linux_x64`) {
	}

	macosX64(TargetEnum.`common-single_source@macos_x64`) {
	}

	mingwX64(TargetEnum.`common-single_source@mingw_x64`) {
	}

	wasm32(TargetEnum.`common-single_source@wasm32`) {
	}

	sourceSets {
		all {
			val sourceSetEnum =
				when (name) {
					SourceSetEnum.`common-single_source@main@common`.kotlinId -> SourceSetEnum.`common-single_source@main@common`
					SourceSetEnum.`common-single_source@test@common`.kotlinId -> SourceSetEnum.`common-single_source@test@common`
					else -> SourceSetEnum.getByKotlinIdAndModule(name, ModuleEnum.`common-single_source`)!!
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

		configureSourceSet(SourceSetEnum.`common-single_source@main@common`) {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/single_source/js/common")
			resources.srcDir("src/main/kotlin/com/company/team/project/common/single_source/js/common")
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

		configureSourceSet(SourceSetEnum.`common-single_source@test@common`) {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

//		configureSourceSet(SourceSetEnum.`common-single_source@main@android`) {
//		}
//
//		configureSourceSet(SourceSetEnum.`common-single_source@test@android`) {
//		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@android_native_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@android_native_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@android_native_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@android_native_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@ios_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@ios_arm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@ios_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@ios_arm64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@ios_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@ios_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@js`) {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@js`) {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@jvm`) {
			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@jvm`) {
			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@linux_arm32_hfp`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@linux_arm32_hfp`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@linux_mips32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@linux_mips32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@linux_mipsel32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@linux_mipsel32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@linux_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@linux_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@macos_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@macos_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@mingw_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@mingw_x64`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@main@wasm32`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@test@wasm32`) {
		}
	}
}

configurations {
	val compileClasspath by creating {
	}
}

fun getPath(sourceTypeEnum: SourceTypeEnum, compilationEnum: CompilationEnum, sourceSetEnum: SourceSetEnum): String {
	var output = "src/${compilationEnum.id!!}/${sourceTypeEnum.id!!}"

	if (SourceTypeEnum.kotlin == sourceTypeEnum) {
		output += "/${project.module.group!!.replace(".", "/")}/${project.module.path}"
	}

	if (sourceSetEnum.target?.preset?.name != null) {
		output += "/" + sourceSetEnum.target?.preset?.name
	}

	output += "/common"

	return output
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
