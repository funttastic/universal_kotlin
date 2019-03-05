import com.company.team.project.dsl.Util

rootProject.name = "universal-kotlin"

pluginManagement {
	repositories {
		gradlePluginPortal()
		maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
	}

	resolutionStrategy {
		eachPlugin {
			if (requested.id.id == "kotlin-multiplatform") {
				useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
			}
		}
	}
}

enableFeaturePreview("GRADLE_METADATA")

val splitRegex = ",[\\s]*".toRegex()

val finalModules = ArrayList<String>()

Util.systemProperties = System.getProperties()

var enabledModules = if (
	Util.systemProperties.containsKey("enabledModules")
) {
	if (Util.systemProperties.getProperty("enabledModules").toString().isNotBlank()) {
		Util.systemProperties.getProperty("enabledModules").toString().split(splitRegex)
	} else {
		ArrayList()
	}
} else {
	listOf(
		"common:single_source_set"
		, "common:multiple_source_sets"
		, "common:multiple_modules"
		, "library:example"
		, "application:backend:jvm:spring_boot"
		, "application:browser:js:vanilla"
		, "application:browser:js:spa:reactApp"
		, "application:browser:native:wasm32"
		, "application:desktop:jvm:tornado_fx"
		, "application:mobile:jvm:android"
		, "application:mobile:native:iosApp"
		, "application:terminal:jvm:terminal"
	)
}
enabledModules = enabledModules.map { it.trim()}

var disabledModules = if (
	Util.systemProperties.containsKey("disabledModules")
) {
	if (Util.systemProperties.getProperty("disabledModules").toString().isNotBlank()) {
		Util.systemProperties.getProperty("disabledModules").toString().split(splitRegex)
	} else {
		System.getProperty("disabledModules").toString().split(splitRegex)
	}
} else {
	ArrayList()
}
disabledModules = disabledModules.map { it.trim()}

enabledModules.forEach{
	if (it !in disabledModules) {
		finalModules.add(it)
	}
}

Util.dump(finalModules)

finalModules.forEach {
	include(it)
}
