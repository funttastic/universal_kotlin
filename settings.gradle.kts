rootProject.name = "universal-kotlin"

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }
    }
}

enableFeaturePreview("GRADLE_METADATA")


val properties = System.getProperties()

val splitRegex = ",[\\s]*".toRegex()

val enabledModules = if (properties.containsKey("enabledModules")) {
	System.getProperty("enabledModules").toString().split(splitRegex)
} else {
	listOf(
		"common"
		, "library:example"
		, "application:js:vanilla"
		, "application:jvm:jvm8:android"
		, "application:jvm:jvm8:api:spring_boot"
		, "application:jvm:jvm8:terminal"
		, "application:native:apple:iosApp"
	)
}

val disabledModules = if (properties.containsKey("disabledModules")) {
	System.getProperty("disabledModules").toString().split(splitRegex)
} else {
	ArrayList()
}

enabledModules.forEach{
	if (it !in disabledModules) {
		include(it)
	}
}
