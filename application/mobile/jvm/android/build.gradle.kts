import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig

plugins {
	kotlin("multiplatform")
	id("com.android.application")
	id("kotlin-android-extensions")
}

repositories {
	google()
	jcenter()
	mavenCentral()
}

android {
	compileSdkVersion(28)
//	buildToolsVersion = "28.0.0"

	defaultConfig {
		applicationId = "org.jetbrains.kotlin.mpp_app_android"
		minSdkVersion(15)
		targetSdkVersion(28)
		versionCode = 1
		versionName = "1.0"
		testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
	}
	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			sourceSets {
				val main by getting {
					manifest.srcFile("src/main/resources/manifest/AndroidManifest.xml")
					resources.srcDirs(listOf("src/main/resources/res"))
					res.srcDirs(listOf("src/main/resources/res"))
//					java.srcDirs(listOf("src"))
//					aidl.srcDirs(listOf("src"))
//					renderscript.srcDirs(listOf("src"))
//					assets.srcDirs(listOf("src/main/resources/assets"))
				}

				val test by getting {
					resources.srcDirs(listOf("src/test/resources"))
					res.srcDirs(listOf("src/test/resources"))
				}
			}
//			proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-r")
		}
	}

//	packagingOptions.exclude("META-INF/main.kotlin_module")
}

dependencies {
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation("com.android.support:appcompat-v7:28.0.0")
	implementation("com.android.support.constraint:constraint-layout:1.1.3")
	androidTestImplementation("com.android.support.test:runner:1.0.2")
}

kotlin {
	android("android") {
	}

	sourceSets {
		val androidMain by getting {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(project(":common:single_source_set", "jvmJvm8AndroidDefault"))

				implementation(kotlin("stdlib-common"))
				implementation(kotlin("stdlib"))
			}
		}

		val androidTest by getting {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(project(":common:single_source_set", "jvmJvm8AndroidDefault"))

				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}
	}
}
