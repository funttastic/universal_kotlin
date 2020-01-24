import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.enum_.*

Properties.projects.root.descriptor = rootProject
rootProject.name = "universal_kotlin"

pluginManagement {
	repositories {
		// TODO Fix
		flatDir {
			dirs("plugin")
		}
		mavenLocal()
		gradlePluginPortal()
		mavenCentral()
		jcenter()
		google()
		maven( url = "https://plugins.gradle.org/m2" )
		maven( url = "https://repo.gradle.org/gradle/libs-releases-local" )
		maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
		maven( url = "https://dl.bintray.com/kotlin/kotlin-dev" )

		maven( url = "https://dl.bintray.com/salomonbrys/gradle-plugins" )
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
