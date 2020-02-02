import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.enum_.SourceSetEnum
import com.company.team.project.dsl.model.enum_.TargetEnum
import com.company.team.project.dsl.model.extension.*

plugins {
	kotlin("multiplatform")
	kotlin("xcode-compat")
}

repositories {
	mavenCentral()
	maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-mobile-native-apple-ios-ios_x64_framework`)

	xcode {
		setupFramework(
			iosX64(TargetEnum.`application-mobile-native-apple-ios-ios_x64_framework@ios_x64`) {
				binaries {
					framework {
						baseName = "UniversalKotlin"
					}
				}
			}
		)
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_framework@ios_x64@main`) {
			kotlin.setSrcDir("src/main/kotlin")
			resources.setSrcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}

		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_framework@ios_x64@test`) {
			kotlin.setSrcDir("src/test/kotlin")
			resources.setSrcDir("src/test/resources")

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
