import com.company.team.project.dsl.Util

plugins {
	kotlin("multiplatform") version com.company.team.project.dsl.Util.kotlinVersion
}

Util.rootProject = project

// Used mainly by the android-ios and spring boot applications.
buildscript {
	val util = com.company.team.project.dsl.Util

	repositories {
		maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
		google()
		jcenter()
		mavenCentral()

		maven { url = uri("http://dl.bintray.com/kotlin/kotlin-dev") }
		maven { url = uri("http://dl.bintray.com/kotlinx/kotlinx") }
		maven { url = uri("https://kotlin.bintray.com/kotlinx") }
		maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
		maven { url = uri("https://dl.bintray.com/jetbrains/kotlin-native-dependencies") }
	}

	dependencies {
		classpath("com.android.tools.build:gradle:${util.androidToolsVersion}")
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${util.springBootVersion}")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${util.kotlinVersion}")
		classpath("org.jetbrains.kotlin:kotlin-allopen:${util.kotlinVersion}")
		classpath("org.jetbrains.kotlin:kotlin-frontend-plugin:${util.frontendVersion}")
		classpath("org.jetbrains.kotlin:kotlin-serialization:${util.kotlinVersion}")
		classpath("org.jetbrains.kotlin:kotlin-native-gradle-plugin:${util.kotlinVersion}")
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
	repositories {
		maven {
			url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
			content {
				excludeGroup("Kotlin/Native")
			}
		}
		mavenLocal().apply {
			content {
				excludeGroup("Kotlin/Native")
			}
		}
		maven {
			url = uri("https://dl.bintray.com/soywiz/soywiz")
			content {
				includeGroup("com.soywiz")
				excludeGroup("Kotlin/Native")
			}
		}
		jcenter() {
			content {
				excludeGroup("Kotlin/Native")
			}
		}
		google().apply {
			content {
				excludeGroup("Kotlin/Native")
			}
		}
	}

//	repositories {
//		google()
//		jcenter()
//		mavenCentral()
//		maven("https://dl.bintray.com/kotlin/kotlin-eap")
//	}
}

repositories {
	maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
	maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev") }
	mavenCentral()
}
