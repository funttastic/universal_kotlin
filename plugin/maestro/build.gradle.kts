plugins {
	`kotlin-dsl`
	id("com.gradle.plugin-publish") version "0.10.1"
	`maven-publish`
}

val pluginName = "plugin.maestro"

group = "com.company.team.project"
version = "0.0.1"

gradlePlugin {
	plugins {
		register(pluginName) {
			id = "com.company.team.project.plugin.maestro"
			implementationClass = "com.company.team.project.plugin.maestro.Plugin"
		}
	}
}

dependencies {
	compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:+")
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
			displayName = "Universal Kotlin Maestro Gradle Plugin"
			description = "Universal Kotlin Maestro Gradle Plugin."
			tags = listOf("Kotlin")
			version = rootProject.version.toString()
		}
	}
}
