import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.extension.*
import com.company.team.project.dsl.generateGraphvizDiagrams
import com.company.team.project.dsl.model.enum_.StatusEnum.enabled

buildscript {
	com.company.team.project.dsl.model.Properties.projects.root.project = rootProject

	val vendorProperties = com.company.team.project.dsl.model.Properties.vendor

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
//		maven( url = "https://dl.bintray.com/kotlin/kotlin-dev" )

		maven( url = "http://dl.bintray.com/kotlinx/kotlinx" )
		maven( url = "https://kotlin.bintray.com/kotlinx" )
		maven( url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers" )
		maven( url = "https://dl.bintray.com/jetbrains/kotlin-native-dependencies" )

		maven( url = "https://dl.bintray.com/salomonbrys/gradle-plugins" )
	}

	dependencies {
		classpath("com.android.tools.build:gradle:${vendorProperties.androidTools}")
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${vendorProperties.springBoot}")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${vendorProperties.kotlin}")
		classpath("org.jetbrains.kotlin:kotlin-allopen:${vendorProperties.kotlin}")
		classpath("org.jetbrains.kotlin:kotlin-frontend-plugin:${vendorProperties.frontend}")
		classpath("org.jetbrains.kotlin:kotlin-serialization:${vendorProperties.kotlin}")
//		classpath("org.jetbrains.kotlin:kotlin-native-gradle-plugin:${vendorProperties.kotlin}")

		classpath("com.github.salomonbrys.gradle.kotlin.js:kotlin-js-gradle-utils:1.2.0")

		classpath("com.github.jengelman.gradle.plugins:shadow:5.0.0")

//		classpath("no.tornado:fxlauncher-gradle-plugin:1.0.20")
//		classpath("de.dynamicfiles.projects.gradle.plugins:javafx-gradle-plugin:8.8.2")

		// TODO Fix
//		classpath ("com.company.team.project:plugin-jvm-gradle")
	}
}

Util.initialize(gradle.startParameter.taskNames)

// TODO Fix
//apply(plugin = "com.company.team.project:plugin-jvm-gradle")

//group = Properties.general.group
//version = Properties.general.version

//version = ext["project.version"]!!
//group = ext["project.group"]!!

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
		maven( url = "https://dl.bintray.com/kotlin/kotlin-dev" )
	}

	group = Properties.general.group
	version = Properties.general.version

//	version = ext["project.version"]!!
//	group = ext["project.group"]!!

//	ext {
//		set("property", "value")
//	}

//	// Workaround to avoid downloading dependencies every time.
//	repositories {
//		maven {
//			url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
//			content {
////				excludeGroup("Kotlin/Native")
//			}
//		}
//		mavenLocal().apply {
//			content {
////				excludeGroup("Kotlin/Native")
//			}
//		}
//		maven {
//			url = uri("https://dl.bintray.com/soywiz/soywiz")
//			content {
//				includeGroup("com.soywiz")
////				excludeGroup("Kotlin/Native")
//			}
//		}
//		jcenter() {
//			content {
////				excludeGroup("Kotlin/Native")
//			}
//		}
//		google().apply {
//			content {
////				excludeGroup("Kotlin/Native")
//			}
//		}
//	}
}

rootProject.allprojects.forEach { project ->
	// Force initialization of the module property
	if (project.module.status != enabled) {
		project.tasks.all {
			this.enabled = false
		}
	}
}

repositories {
	mavenCentral()
	jcenter()
	google()
	mavenLocal()
	maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
	maven( url = "https://dl.bintray.com/kotlin/kotlin-dev" )
}

tasks.register("generateGraphvizDiagrams") {
	doLast {
		generateGraphvizDiagrams()
	}
}
