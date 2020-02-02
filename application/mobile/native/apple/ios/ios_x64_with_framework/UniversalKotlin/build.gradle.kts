import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.enum_.SourceSetEnum
import com.company.team.project.dsl.model.enum_.TargetEnum
import com.company.team.project.dsl.model.extension.configureSourceSet
import com.company.team.project.dsl.model.extension.configureTargetAttributes
import com.company.team.project.dsl.model.extension.iosX64
import com.company.team.project.dsl.model.extension.setupFramework
import com.company.team.project.dsl.model.extension.setupTask

plugins {
	kotlin("multiplatform")
	kotlin("xcode-compat")
}

repositories {
	mavenCentral()
	maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-mobile-native-apple-ios-ios_x64_with_framework`)

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_with_framework@ios_x64@main`) {
			kotlin.setSrcDir("src/main/kotlin")
			resources.setSrcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}

		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_with_framework@ios_x64@test`) {
			kotlin.setSrcDir("src/test/kotlin")
			resources.setSrcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
	}

	xcode {
		setupFramework (
			iosX64(TargetEnum.`application-mobile-native-apple-ios-ios_x64_with_framework@ios_x64`) {
				binaries {
					framework {
						baseName = "UniversalKotlin"
						setupTask(this)
					}
				}
			}
		)
	}
}

configurations {
	val compileClasspath by creating {
	}
}
