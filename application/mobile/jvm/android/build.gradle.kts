import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import com.company.team.project.dsl.model.Properties

plugins {
	id("com.android.application")
	id("kotlin-android")
	id("kotlin-android-extensions")
}

android {
	compileSdkVersion(29)
	buildToolsVersion = "29.0.2"

	defaultConfig {
		applicationId = "com.company.team.project.application.mobile.jvm.android"
		minSdkVersion(29)
		targetSdkVersion(29)
		versionCode = 1
		versionName = "1.0"
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
			sourceSets {
				val main by getting {
					manifest.srcFile("src/main/resources/manifest/AndroidManifest.xml")
					resources.srcDirs(listOf("src/main/resources/res"))
					res.srcDirs(listOf("src/main/resources/res"))
					dependencies {
						implementation(kotlin("stdlib-common"))
						implementation(kotlin("stdlib"))
						implementation(project(":common-multiple_sources"))
						implementation(project(":common-single_source"))
						implementation(project(":library-multiple_sources"))
						implementation(project(":library-single_source"))
					}
				}

				val test by getting {
					resources.srcDirs(listOf("src/test/resources"))
					res.srcDirs(listOf("src/test/resources"))
					dependencies {
						implementation(kotlin("test-common"))
						implementation(kotlin("test-annotations-common"))
						implementation(kotlin("test"))
						implementation(kotlin("test-junit"))
					}
				}
			}
		}
	}
}

dependencies {
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Properties.vendor.kotlin}")
	implementation("androidx.appcompat:appcompat:1.1.0")
	implementation("androidx.core:core-ktx:1.2.0")
	implementation("com.android.support.constraint:constraint-layout:1.1.3")
	testImplementation("junit:junit:4.12")
	androidTestImplementation("androidx.test.ext:junit:1.1.1")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
