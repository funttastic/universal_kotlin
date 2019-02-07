plugins {
	kotlin("multiplatform") version "1.3.20"
}

group = ext["project.group"]!!
version = ext["project.version"]!!

allprojects {
//	ext {
//		set("property", "value")
//	}

	// Workaround to avoid downloading dependencies every time.
	repositories {
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

//// Used in the android-ios application
//buildscript {
//	repositories {
//		google()
//		jcenter()
//	}
//	dependencies {
//		classpath 'com.android.tools.build:gradle:3.2.0'
//	}
//}
//repositories {
//	google()
//	jcenter()
//}
