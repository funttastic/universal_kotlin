plugins {
	`kotlin-dsl`
}

apply("../plugin/properties.gradle.kts")
apply("../plugin/dependencies.gradle.kts")

@Suppress("unchecked_cast", "nothing_to_inline")
inline fun <T> uncheckedCast(target: Any?): T = target as T

val getProperty = uncheckedCast<(key: String) -> String>(extra["getProperty"])
val getDependencyVersion = uncheckedCast<(group: String, dependencyId: String) -> String>(extra["getDependencyVersion"])

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
}

dependencies {
	val kotlinVersion = getProperty("kotlin.version")

	testImplementation("junit:junit:4.12")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.10.1")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.8")

	implementation("com.android.tools.build:gradle:3.3.2")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
	implementation(gradleApi())
	implementation("org.jetbrains.kotlin.xcode-compat:org.jetbrains.kotlin.xcode-compat.gradle.plugin:0.2.5")

	// For Android modules
	implementation("com.android.tools.build:gradle:3.5.3")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}
