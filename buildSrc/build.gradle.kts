import java.io.FileInputStream
import java.util.Properties

plugins {
	`kotlin-dsl`
}

//apply(from = "load_gradle_properties.gradle.kts")

val properties = Properties()
val input = FileInputStream(file("../gradle.properties"))
properties.load(input)
input.close()

for (key in properties.stringPropertyNames()) {
	extensions.extraProperties[key] = properties.getProperty(key)
}

group = project.properties["project.group"].toString()
version = project.properties["project.version"].toString()

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
	val kotlinVersion = project.properties["kotlin.version"]

	testImplementation("junit:junit:4.12")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.10.1")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.8")

	implementation("com.android.tools.build:gradle:3.3.2")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
	implementation(gradleApi())
	implementation("org.jetbrains.kotlin.xcode-compat:org.jetbrains.kotlin.xcode-compat.gradle.plugin:0.2.5")
}
