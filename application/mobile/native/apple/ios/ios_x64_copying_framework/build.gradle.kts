import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeCompilation

plugins {
	kotlin("multiplatform")
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

	iosX64(TargetEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64`) {
		compilations[CompilationEnum.main.id!!].outputKinds("framework")
		compilations[CompilationEnum.test.id!!].outputKinds("framework")

//		This can change the framework name. Related: https://github.com/JetBrains/kotlin/blob/1.3.20/libraries/tools/kotlin-gradle-plugin-integration-tests/src/test/resources/testProject/new-mpp-native-binaries/kotlin-dsl/build.gradle.kts#L69
//		binaries {
//			framework("app")
//		}
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework@main@ios_x64`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}
		
		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework@test@ios_x64`) {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
	}
}

configurations {
	val compileClasspath by creating {
	}
}


// This task attaches native framework built from ios module to Xcode project
// (see iosApp directory). Don"t run this task directly,
// Xcode runs this task itself during its build process.
// Before opening the project from iosApp directory in Xcode,
// make sure all Gradle infrastructure exists (gradle.wrapper, gradlew).
task("copyFramework") {
	Util.dump(kotlin.targets.asMap)
	val buildType = (project.findProperty("kotlin.build.type") ?: "DEBUG").toString()
//	val target = project.findProperty("kotlin.target") ?: "iosX64"
	val target = TargetEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64`.kotlinId!!
	dependsOn((kotlin.targets[target].compilations[CompilationEnum.main.id!!] as KotlinNativeCompilation).linkTaskName("FRAMEWORK", buildType))

	doLast {
		val srcFile = (kotlin.targets[target].compilations[CompilationEnum.main.id!!] as KotlinNativeCompilation).getBinary("FRAMEWORK", buildType)
		val targetDir = project.properties["configuration.build.dir"]!!

		copy {
			from(srcFile.parent)
			into(targetDir)
			include("main.framework/**")
			include("main.framework.dSYM")
		}
	}
}
