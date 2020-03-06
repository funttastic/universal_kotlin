rootProject.name = "universal_kotlin"

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
		eachPlugin {
			if (requested.id.id == "kotlin-multiplatform") {
				useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
			}

			// For Kotlin JS modules
			if (requested.id.id.startsWith("com.github.salomonbrys.gradle.kotlin.js.")) {
				useModule("com.github.salomonbrys.gradle.kotlin.js:kotlin-js-gradle-utils:1.2.0")
			}
		}
	}
}

apply("plugin/init/build.gradle.kts")

apply("plugin/properties/build.gradle.kts")
@Suppress("unchecked_cast", "nothing_to_inline")
inline fun <T> uncheckedCast(target: Any?): T = target as T
val getProperty = uncheckedCast<(key: String) -> String>(extra["getProperty"])

fun <T> cast(target: Any?, `class`: Class<T>): T {
	return `class`.cast(target)
}

val myTest = extra["myTest"]!!

val test = cast(myTest, myTest::class.java)

println(test)
//data class Dummy(val test: String = "fdsa")
//val myTest by extra.get("myTest")
//println(myTest as Any)
