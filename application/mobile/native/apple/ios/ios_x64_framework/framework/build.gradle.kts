import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.extension.configureTargetAttributes

plugins {
	kotlin("multiplatform")
	kotlin("xcode-compat")
}

repositories {
	mavenCentral()
	maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-mobile-native-apple-ios-ios_x64_framework`)

	xcode {
		setupFramework("framework") {
			baseName = "framework"
		}
	}

	iosX64(TargetEnum.`application-mobile-native-apple-ios-ios_x64_framework@ios_x64`) {
		binaries {
			framework {
				baseName = "main"
			}
		}
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_framework@ios_x64@main`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}

		configureSourceSet(SourceSetEnum.`application-mobile-native-apple-ios-ios_x64_framework@ios_x64@test`) {
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
