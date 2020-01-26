import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.enum_.SourceSetEnum
import com.company.team.project.dsl.model.enum_.TargetEnum
import com.company.team.project.dsl.model.extension.*
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
	kotlin("multiplatform")
	kotlin("xcode-compat")
}

repositories {
	mavenCentral()
	maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-mobile-native-apple-ios-ios_x64_without_framework`)

	iosX64(TargetEnum.`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64`) {
		binaries {
			executable {
				baseName = "WithoutFramework"
				entryPoint = "com.company.team.project.application.mobile.native_.apple.ios.ios_x64.main"
			}
		}
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64@main`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}

		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64@test`) {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
	}

//	xcode {
//		setupApplication (
//			iosX64(TargetEnum.`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64`) {
//				binaries {
//					executable {
//						baseName = "WithoutFramework"
//						entryPoint = "ccom.company.team.project.application.mobile.native_.apple.ios.ios_x64.main"
//						setupTask(this)
//					}
//				}
//			}
//		)
//	}
}

/**
 * This task will be automatically called by Xcode.
 */
task("copyApplication", Copy::class) {
	val buildType = (project.findProperty("kotlin.build.type") ?: NativeBuildType.DEBUG.name).toString()
	val target = TargetEnum.`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64`.kotlinId!!
	val kotlinBinary = (kotlin.targets[target] as KotlinNativeTarget).binaries.getExecutable(buildType)
	val linkTask = kotlinBinary.linkTask

	val targetBuildDir: String = System.getenv("TARGET_BUILD_DIR")
	val executablePath: String = System.getenv("EXECUTABLE_PATH")
	val dsymSource = kotlinBinary.outputFile.absolutePath + ".dSYM"
	val dsymDestination = File(executablePath).parentFile.name + ".dSYM"
	val oldExecName = kotlinBinary.outputFile.name
	val newExecName = File(executablePath).name

	println("""
			targetBuildDir: $targetBuildDir
			executablePath: $executablePath
			dsymSource: $dsymSource
			dsymDestination: $dsymDestination
			oldExecName: $oldExecName
			newExecName: $newExecName
		""".trimIndent())

	dependsOn(linkTask)

	destinationDir = file(targetBuildDir)

	from(dsymSource) {
		into(dsymDestination)
		rename(oldExecName, newExecName)
	}

	from(kotlinBinary.outputFile) {
		rename { executablePath }
	}
}
