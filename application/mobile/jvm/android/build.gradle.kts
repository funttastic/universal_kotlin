import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*

plugins {
	kotlin("multiplatform")
	id("com.android.application")
	id("kotlin-android-extensions")
}

repositories {
	google()
	jcenter()
	mavenCentral()
	mavenLocal()
	maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
	maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev") }
}

android {
	compileSdkVersion(28)
//	buildToolsVersion = "28.0.0"

	defaultConfig {
		applicationId = "com.company.team.project.application.mobile.jvm.android"
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
	configureTargetAttributes(ModuleEnum.`application-mobile-jvm-android`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

	@Suppress("IllegalIdentifier")
	android(TargetEnum.`application-mobile-jvm-android@android`) {
	}

//	android("android") {
//	}

	sourceSets {
//		val androidMain by getting {
		@Suppress("IllegalIdentifier")
		configureSourceSet(SourceSetEnum.`application-mobile-jvm-android@main@android`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
				implementation(kotlin("stdlib"))
			}
		}

//		val androidTest by getting {
		@Suppress("IllegalIdentifier")
		configureSourceSet(SourceSetEnum.`application-mobile-jvm-android@test@android`) {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}
	}
}
