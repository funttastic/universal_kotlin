import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.enum_.*

//rootProject.projectDir
Properties.projects.root.descriptor = rootProject
rootProject.name = "universal_kotlin"

pluginManagement {
	repositories {
		gradlePluginPortal()
		mavenCentral()
		jcenter()
		google()
		mavenLocal()
		maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
		maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev") }

		maven(url = "https://plugins.gradle.org/m2/")
		maven(url = "https://dl.bintray.com/salomonbrys/gradle-plugins")
	}

	resolutionStrategy {
		eachPlugin {
			if (requested.id.id == "kotlin-multiplatform") {
				useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
			}

			if (requested.id.id.startsWith("com.github.salomonbrys.gradle.kotlin.js.")) {
				useModule("com.github.salomonbrys.gradle.kotlin.js:kotlin-js-gradle-utils:1.2.0")
			}
		}
	}
}

enableFeaturePreview("GRADLE_METADATA")

Util.initialize()

ModuleEnum.values().forEach { module ->
	if (
		StatusEnum.enabled == module.status
	) {
		Util.logger.warn("Including ${module.kotlinId}")
		include(module.kotlinId)
		project(":${module.kotlinId}").projectDir = module.file!!
	}
}
