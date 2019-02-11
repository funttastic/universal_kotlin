import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeCompilation

plugins {
	kotlin("multiplatform")
}

kotlin {
	val commonAttribute = Attribute.of("com.company.team.project.common", String::class.java)

	iosX64("ios") {
		attributes.attribute(commonAttribute, "nativeIosX64")

		compilations["main"].outputKinds("framework")
		compilations["test"].outputKinds("framework")

//		This can change the framework name. Related: https://github.com/JetBrains/kotlin/blob/1.3.20/libraries/tools/kotlin-gradle-plugin-integration-tests/src/test/resources/testProject/new-mpp-native-binaries/kotlin-dsl/build.gradle.kts#L69
//		binaries {
//			framework("app")
//		}
	}

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(project(":common"))

				implementation(kotlin("stdlib-common"))
			}
		}

		val commonTest by getting {
			dependencies {
				implementation(project(":common"))

				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
		
		val iosMain by getting {
			dependsOn(commonMain)
		}
		
		val iosTest by getting {
			dependsOn(commonTest)
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
	val buildType = (project.findProperty("kotlin.build.type") ?: "DEBUG").toString()
	val target = project.findProperty("kotlin.target") ?: "ios"
	dependsOn((kotlin.targets["$target"].compilations["main"] as KotlinNativeCompilation).linkTaskName("FRAMEWORK", buildType))

	doLast {
		val srcFile = (kotlin.targets["$target"].compilations["main"] as KotlinNativeCompilation).getBinary("FRAMEWORK", buildType)
		val targetDir = project.properties["configuration.build.dir"]!!

		copy {
			from(srcFile.parent)
			into(targetDir)
			include("main.framework/**")
			include("main.framework.dSYM")
		}
	}
}
