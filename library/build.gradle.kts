plugins {
	kotlin("multiplatform")
	id("maven-publish")
}

group = "com.company.team.library"
version = "0.0.1"

kotlin {
	val commonAttribute = Attribute.of("com.company.team.common", String::class.java)

	targets.all {
		attributes.attribute(commonAttribute, targetName)
	}

	js("js") {
	}

	jvm("jvm") {
	}

	androidNativeArm32("nativeAndroidArm32") {
	}

	androidNativeArm64("nativeAndroidArm64") {
	}

	iosArm32("nativeIosArm32") {
		compilations["main"].outputKinds("framework")
	}

	iosArm64("nativeIosArm64") {
		compilations["main"].outputKinds("framework")
	}

	iosX64("nativeIosX64") {
		compilations["main"].outputKinds("framework")
	}

	linuxArm32Hfp("nativeLinuxArm32Hfp") {
	}

	linuxMips32("nativeLinuxMips32") {
	}

	linuxMipsel32("nativeLinuxMipsel32") {
	}

	linuxX64("nativeLinuxX64") {
	}

	macosX64("nativeMacosX64") {
	}

	mingwX64("nativeMingwX64") {
	}

	wasm32("nativeWasm32") {
	}

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(kotlin("stdlib-common"))

				implementation(project(":common"))
			}
		}

		val commonTest by getting {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

		val jsMain by getting {
			dependsOn(commonMain)

			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}

		val jsTest by getting {
			dependsOn(commonTest)

			dependencies {
				implementation(kotlin("test-js"))
			}
		}

		val jvmMain by getting {
			dependsOn(commonMain)

			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}

		val jvmTest by getting {
			dependsOn(commonTest)

			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}

		val nativeMain by creating {
			dependsOn(commonMain)
		}

		val nativeTest by creating {
			dependsOn(commonTest)
		}

		val nativeAndroidArm32Main by getting {
			dependsOn(nativeMain)
		}

		val nativeAndroidArm32Test by getting {
			dependsOn(nativeTest)
		}

		val nativeAndroidArm64Main by getting {
			dependsOn(nativeMain)
		}

		val nativeAndroidArm64Test by getting {
			dependsOn(nativeTest)
		}

		val nativeIosArm32Main by getting {
			dependsOn(nativeMain)
		}

		val nativeIosArm32Test by getting {
			dependsOn(nativeTest)
		}

		val nativeIosArm64Main by getting {
			dependsOn(nativeMain)
		}

		val nativeIosArm64Test by getting {
			dependsOn(nativeTest)
		}

		val nativeIosX64Main by getting {
			dependsOn(nativeMain)
		}

		val nativeIosX64Test by getting {
			dependsOn(nativeTest)
		}

		val nativeLinuxArm32HfpMain by getting {
			dependsOn(nativeMain)
		}

		val nativeLinuxArm32HfpTest by getting {
			dependsOn(nativeTest)
		}

		val nativeLinuxMips32Main by getting {
			dependsOn(nativeMain)
		}

		val nativeLinuxMips32Test by getting {
			dependsOn(nativeTest)
		}

		val nativeLinuxMipsel32Main by getting {
			dependsOn(nativeMain)
		}

		val nativeLinuxMipsel32Test by getting {
			dependsOn(nativeTest)
		}

		val nativeLinuxX64Main by getting {
			dependsOn(nativeMain)
		}

		val nativeLinuxX64Test by getting {
			dependsOn(nativeTest)
		}

		val nativeMacosX64Main by getting {
			dependsOn(nativeMain)
		}

		val nativeMacosX64Test by getting {
			dependsOn(nativeTest)
		}

		val nativeMingwX64Main by getting {
			dependsOn(nativeMain)
		}

		val nativeMingwX64Test by getting {
			dependsOn(nativeTest)
		}

		val nativeWasm32Main by getting {
			dependsOn(nativeMain)
		}

		val nativeWasm32Test by getting {
			dependsOn(nativeTest)
		}
	}
}

//// Used in android-ios library
//configurations {
//	compileClasspath
//}
