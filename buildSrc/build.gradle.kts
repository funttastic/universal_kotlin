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

	maven( url = "http://dl.bintray.com/kotlinx/kotlinx" )
	maven( url = "https://kotlin.bintray.com/kotlinx" )
	maven( url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers" )
	maven( url = "https://dl.bintray.com/jetbrains/kotlin-native-dependencies" )

	maven( url = "https://dl.bintray.com/salomonbrys/gradle-plugins" )
}

dependencies {
	val kotlinVersion = project.properties["kotlin.version"]

	compile("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
//	compile("org.jetbrains.kotlin:kotlin-frontend-plugin:0.0.45")
	compile("javassist:javassist:3.12.1.GA")

	testCompile("junit:junit:4.12")
	compile("com.fasterxml.jackson.core:jackson-databind:2.9.8")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
	compile("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.8")

	compile("com.android.tools.build:gradle:3.3.2")
	compile("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
	compile(gradleApi())
	compile("org.jetbrains.kotlin.xcode-compat:org.jetbrains.kotlin.xcode-compat.gradle.plugin:0.2.5")
}
