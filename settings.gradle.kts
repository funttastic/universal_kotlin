pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "universal-kotlin"

enableFeaturePreview("GRADLE_METADATA")

val enabledModules = arrayOf(
	"common",
	"library:common",
	"application:jvm:jvm8:android",
	"application:jvm:jvm8:terminal",
	"application:native:apple:iosApp"
)

enabledModules.forEach{include(it)}
