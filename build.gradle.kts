import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.extension.*
import com.company.team.project.dsl.generateGraphvizDiagrams
import com.company.team.project.dsl.model.enum_.StatusEnum.enabled

buildscript {
	apply("plugin/properties.gradle.kts")
	apply("plugin/dependencies.gradle.kts")
	@Suppress("unchecked_cast", "nothing_to_inline")
	fun <T> uncheckedCast(target: Any?): T = target as T
	val getProperty = uncheckedCast<(key: String) -> String>(extra["getProperty"])
	val getDependencyVersion = uncheckedCast<(group: String, dependencyId: String) -> String>(extra["getDependencyVersion"])

	// The full package is needed here.
	com.company.team.project.dsl.model.Properties.projects.root.project = rootProject

	val kotlinVersion = getProperty("kotlin.version")

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

		maven( url = "https://dl.bintray.com/kotlinx/kotlinx" )
		maven( url = "https://kotlin.bintray.com/kotlinx" )
		maven( url = "https://dl.bintray.com/kotlin/kotlin-js-wrappers" )
		maven( url = "https://dl.bintray.com/jetbrains/kotlin-native-dependencies" )

		maven( url = "https://dl.bintray.com/salomonbrys/gradle-plugins" )
	}

	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
		classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
		classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")

		// For Terminal modules
		classpath("com.github.jengelman.gradle.plugins:shadow:5.0.0")

		// For Spring Boot modules
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.2.2.RELEASE")

		// For Android modules
		classpath("com.android.tools.build:gradle:3.3.2")
		classpath("com.android.tools.build:gradle:3.5.3")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

		// For JavaScript modules
		classpath("org.jetbrains.kotlin:kotlin-frontend-plugin:0.0.45")
		classpath("com.github.salomonbrys.gradle.kotlin.js:kotlin-js-gradle-utils:1.2.0")

		// TODO Add reference in the future
//		classpath ("com.company.team.project:plugin-jvm-gradle")
	}
}

Util.initialize(gradle.startParameter.taskNames)

// TODO Add reference in the future
//apply(plugin = "com.company.team.project:plugin-jvm-gradle")

allprojects {
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
}

subprojects {
	// Also force the initialization of the module property
	if (this.module.status != enabled) {
		this.tasks.all {
			this.enabled = false
		}
	}
}

task("generateGraphvizDiagrams") {
	doLast {
		generateGraphvizDiagrams()
	}
}
