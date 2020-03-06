plugins {
	`kotlin-dsl`
	`maven-publish`
	id("com.gradle.plugin-publish") version "0.10.1"
}

val pluginName = "plugin"

gradlePlugin {
	plugins {
		register(pluginName) {
			// TODO Fix
			id = "${group}.${project.name}"
			implementationClass = "com.company.team.project.plugin.jvm.gradle.Plugin"
		}
	}
}

dependencies {
	// TODO Fix
	compileOnly("org.jetbrains.kotlin", "kotlin-gradle-plugin", "1.3.60+")
}

publishing {
	repositories {
		maven("$buildDir/repository")
	}
}

repositories {
	jcenter()
	maven("http://dl.bintray.com/kotlin/kotlin-eap")
}


pluginBundle {
	website = "https://github.com/funttastic/universal_kotlin"
	vcsUrl = "https://github.com/funttastic/universal_kotlin"

	(plugins) {
		pluginName {
			displayName = "Universal Kotlin Gradle Plugin"
			description = "Universal Kotlin Gradle Plugin."
			tags = listOf("Kotlin")
			version = rootProject.version.toString()
		}
	}
}
