import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.enum_.SourceSetEnum
import com.company.team.project.dsl.model.enum_.TargetEnum
import com.company.team.project.dsl.model.extension.configureSourceSet
import com.company.team.project.dsl.model.extension.configureTargetAttributes
import com.company.team.project.dsl.model.extension.iosX64
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
	kotlin("multiplatform")
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework`)

	iosX64(TargetEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64`) {
		binaries {
			framework {
				baseName = "UniversalKotlin"
			}
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

/**
 * This task will be automatically called by Xcode.
 */
task("copyFramework") {
	val buildType = (project.findProperty("kotlin.build.type") ?: "DEBUG").toString()
	val target = TargetEnum.`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64`.kotlinId!!
	val linkTask = (kotlin.targets[target] as KotlinNativeTarget).binaries.getFramework(buildType).linkTask

	dependsOn(linkTask)

	doLast {
		val srcFile = (kotlin.targets[target] as KotlinNativeTarget).binaries.getFramework(buildType).outputFile
		val targetDir = project.properties["configuration.build.dir"]!!

		/*
		These names need to be coincident with the imported framework inside of the ios project,
			also the name configured in the target -> binaries -> framework -> baseName.
		 */
		copy {
			from(srcFile.parent)
			into(targetDir)
			include("UniversalKotlin.framework/**")
			include("UniversalKotlin.framework.dSYM")
		}
	}
}
