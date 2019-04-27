import java.io.FileInputStream
import java.util.*

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
	mavenCentral()
	jcenter()
	google()
	mavenLocal()
	maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
//	maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev") }
	maven { url = uri("https://repo.gradle.org/gradle/libs-releases-local")}
	gradlePluginPortal()
}

dependencies {
	val kotlinVersion = project.properties["kotlin.version"]

	testCompile("junit:junit:4.12")
	compile("com.fasterxml.jackson.core:jackson-databind:2.9.8")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
	compile("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.8")

	compile("com.android.tools.build:gradle:3.3.2")
	compile("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
	compile(gradleApi())
	compile("org.jetbrains.kotlin.xcode-compat:org.jetbrains.kotlin.xcode-compat.gradle.plugin:0.1")
}
