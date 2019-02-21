import org.jdom2.filter.Filters.content

plugins {
	kotlin("multiplatform") version "1.3.20"
}

// Used mainly by the android-ios and spring boot applications.
buildscript {
	val kotlinVersion = "1.3.20"
	val springBootVersion = "2.1.2.RELEASE"
	val androidToolsVersion = "3.2.0"

	repositories {
		google()
		jcenter()
		mavenCentral()
		maven("https://dl.bintray.com/kotlin/kotlin-eap")
	}

	dependencies {
		classpath("com.android.tools.build:gradle:$androidToolsVersion")
		classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
		classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
	}
}

group = ext["project.group"]!!
version = ext["project.version"]!!

allprojects {
//	group = ext["project.group"]!!

//	ext {
//		set("property", "value")
//	}

	// Workaround to avoid downloading dependencies every time.
//	repositories {
//		mavenLocal().apply {
//			content {
//				excludeGroup("Kotlin/Native")
//			}
//		}
//		maven {
//			url = uri("https://dl.bintray.com/soywiz/soywiz")
//			content {
//				includeGroup("com.soywiz")
//				excludeGroup("Kotlin/Native")
//			}
//		}
//		jcenter() {
//			content {
//				excludeGroup("Kotlin/Native")
//			}
//		}
//		google().apply {
//			content {
//				excludeGroup("Kotlin/Native")
//			}
//		}
//	}

	repositories {
		google()
		jcenter()
		mavenCentral()
		maven("https://dl.bintray.com/kotlin/kotlin-eap")
	}
}
