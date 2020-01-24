import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.extension.configureTargetAttributes

plugins {
	kotlin("multiplatform")
	kotlin("xcode-compat")
}

repositories {
	mavenCentral()
	maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-mobile-native-apple-ios-ios_x64`)

	xcode {
		setupApplication("application") {
			baseName = "application"
		}
	}
}
