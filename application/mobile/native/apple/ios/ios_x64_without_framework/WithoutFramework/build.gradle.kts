import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.enum_.SourceSetEnum
import com.company.team.project.dsl.model.enum_.TargetEnum
import com.company.team.project.dsl.model.extension.configureSourceSet
import com.company.team.project.dsl.model.extension.configureTargetAttributes
import com.company.team.project.dsl.model.extension.iosX64
import com.company.team.project.dsl.model.extension.setupApplication
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
	configureTargetAttributes(ModuleEnum.`application-mobile-native-apple-ios-ios_x64_without_framework`)

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

	xcode {
		setupApplication (
			iosX64(TargetEnum.`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64`) {
				binaries {
					executable {
						baseName = "WithoutFramework"
						setupTask(this)
					}
				}
			}
		)
	}
}
