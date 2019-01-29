plugins {
	kotlin("multiplatform") version "1.3.20"
}
group = "com.company.team.project"
version = "0.0.1"

allprojects {
	repositories {
		google()
		jcenter()
		mavenCentral()
		maven("https://dl.bintray.com/kotlin/kotlin-eap")
	}
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
