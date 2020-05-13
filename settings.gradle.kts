rootProject.name = "universal_kotlin"

@Suppress("unchecked_cast", "nothing_to_inline")
inline fun <T> uncheckedCast(target: Any?): T = target as T

apply("plugin/properties.gradle.kts")
apply("plugin/dependencies.gradle.kts")

val getProperty = uncheckedCast<(key: String) -> String>(extra["getProperty"])
val getDependencyVersion = uncheckedCast<(group: String, dependencyId: String) -> String>(extra["getDependencyVersion"])


pluginManagement {
	repositories {
		flatDir { dirs("plugin") }
		mavenLocal()
		gradlePluginPortal()
		mavenCentral()
		jcenter()
		google()
		maven( url = "https://plugins.gradle.org/m2" )
		maven( url = "https://repo.gradle.org/gradle/libs-releases-local" )
		maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
		// maven( url = "https://dl.bintray.com/kotlin/kotlin-dev" )

		// For Kotlin JS modules
		maven( url = "https://dl.bintray.com/salomonbrys/gradle-plugins" )
	}

	resolutionStrategy {
		apply("plugin/properties.gradle.kts")
		apply("plugin/dependencies.gradle.kts")
		@Suppress("unchecked_cast", "nothing_to_inline")
		fun <T> uncheckedCast(target: Any?): T = target as T
		val getProperty = uncheckedCast<(key: String) -> String>(extra["getProperty"])
		val getDependencyVersion = uncheckedCast<(group: String, dependencyId: String) -> String>(extra["getDependencyVersion"])

		eachPlugin {
			if (requested.id.id == "kotlin-multiplatform") {
				useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
			}

			// For Kotlin JS modules
			if (requested.id.id.startsWith("com.github.salomonbrys.gradle.kotlin.js")) {
				useModule(getDependencyVersion("settings.gradle.kts", "com.github.salomonbrys.gradle.kotlin.js:kotlin-js-gradle-utils"))
			}
		}
	}
}

apply("plugin/initialize.gradle.kts")
