import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

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
		binaries {
			framework {}
		}
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64@main`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}

		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64@test`) {
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
	dependsOn((kotlin.targets[target] as KotlinNativeTarget).binaries.getFramework(buildType).linkTask)

	doLast {
		val srcFile = (kotlin.targets[target] as KotlinNativeTarget).binaries.getFramework(buildType).outputFile
		val targetDir = project.properties["configuration.build.dir"]!!

		Util.dump(srcFile.parent)
		Util.dump(targetDir)

		copy {
			from(srcFile.parent)
			into(targetDir)
			include("${ModuleEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework`.name}.framework/**")
			include("${ModuleEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework`.name}.framework.dSYM")
		}

		// copy {
		// 	from(srcFile.parent)
		// 	into(targetDir)
		// 	include("main.framework/**")
		// 	include("main.framework.dSYM")
		// }
	}
}
