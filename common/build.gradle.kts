plugins {
	kotlin("multiplatform")
}

kotlin {
	val commonAttribute = Attribute.of("com.company.team.common", String::class.java)

	targets.all {
		attributes.attribute(commonAttribute, targetName)

//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
	}

	js("js") {
	}

	js("jsSpa") {
	}

	js("jsSpaAngular") {
	}

	js("jsSpaReact") {
	}

	js("jsSpaVue") {
	}

	js("jsVanilla") {
	}

	jvm("jvm") {
	}

	jvm("jvmJvm6") {
	}

	jvm("jvmJvm8") {
	}

	jvm("jvmJvm8Android") {
	}

	jvm("jvmJvm8Api") {
	}

	jvm("jvmJvm8ApiSpringBoot") {
	}

	jvm("jvmJvm8Desktop") {
	}

	jvm("jvmJvm8DesktopSwing") {
	}

	jvm("jvmJvm8DesktopTornadoFx") {
	}

	jvm("jvmJvm8Fullstack") {
	}

	jvm("jvmJvm8AFullstackVaadin") {
	}

	androidNativeArm32("nativeAndroidArm32") {
	}

	androidNativeArm64("nativeAndroidArm64") {
	}

	iosArm32("nativeIosArm32") {
	}

	iosArm64("nativeIosArm64") {
	}

	iosX64("nativeIosX64") {
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
		all {
//			languageSettings {
//				progressiveMode = true
//			}
		}

		val commonMain by getting {
			dependencies {
				implementation(kotlin("stdlib-common"))

			}

//			languageSettings {
//				languageVersion = "1.3" // possible values: "1.0", "1.1", "1.2", "1.3"
//				apiVersion = "1.3" // possible values: "1.0", "1.1", "1.2", "1.3"
//				enableLanguageFeature("InlineClasses") // language feature name
//				useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes") // annotation FQ-name
//				progressiveMode = true // false by default
//			}
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

		val jsSpaMain by getting {
			dependsOn(jsMain)
		}

		val jsSpaTest by getting {
			dependsOn(jsTest)
		}

		val jsSpaAngularMain by getting {
			dependsOn(jsSpaMain)
		}

		val jsSpaAngularTest by getting {
			dependsOn(jsSpaTest)
		}

		val jsSpaReactMain by getting {
			dependsOn(jsSpaMain)
		}

		val jsSpaReactTest by getting {
			dependsOn(jsSpaTest)
		}

		val jsSpaVueMain by getting {
			dependsOn(jsSpaMain)
		}

		val jsSpaVueTest by getting {
			dependsOn(jsSpaTest)
		}

		val jsVanillaMain by getting {
			dependsOn(jsMain)
		}

		val jsVanillaTest by getting {
			dependsOn(jsTest)
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

		val jvmJvm6Main by getting {
			dependsOn(jvmMain)
		}

		val jvmJvm6Test by getting {
			dependsOn(jvmTest)
		}

		val jvmJvm8Main by getting {
			dependsOn(jvmMain)
		}

		val jvmJvm8Test by getting {
			dependsOn(jvmTest)
		}

		val mobileMain by creating {
			dependsOn(commonMain)

			dependencies {
			}
		}

		val mobileTest by creating {
			dependsOn(commonTest)
		}

		val jvmJvm8AndroidMain by getting {
			dependsOn(jvmJvm8Main)
			dependsOn(mobileMain)
		}

		val jvmJvm8AndroidTest by getting {
			dependsOn(jvmJvm8Test)
			dependsOn(mobileTest)
		}

		val jvmJvm8ApiMain by getting {
			dependsOn(jvmJvm8Main)
		}

		val jvmJvm8ApiTest by getting {
			dependsOn(jvmJvm8Test)
		}

		val jvmJvm8ApiSpringBootMain by getting {
			dependsOn(jvmJvm8ApiMain)
		}

		val jvmJvm8ApiSpringBootTest by getting {
			dependsOn(jvmJvm8ApiTest)
		}

		val jvmJvm8DesktopMain by getting {
			dependsOn(jvmJvm8Main)
		}

		val jvmJvm8DesktopTest by getting {
			dependsOn(jvmJvm8Test)
		}

		val jvmJvm8DesktopSwingMain by getting {
			dependsOn(jvmJvm8DesktopMain)
		}

		val jvmJvm8DesktopSwingTest by getting {
			dependsOn(jvmJvm8DesktopTest)
		}

		val jvmJvm8DesktopTornadoFxMain by getting {
			dependsOn(jvmJvm8DesktopMain)
		}

		val jvmJvm8DesktopTornadoFxTest by getting {
			dependsOn(jvmJvm8DesktopTest)
		}

		val jvmJvm8FullstackMain by getting {
			dependsOn(jvmJvm8Main)
		}

		val jvmJvm8FullstackTest by getting {
			dependsOn(jvmJvm8Test)
		}

		val jvmJvm8AFullstackVaadinMain by getting {
			dependsOn(jvmJvm8FullstackMain)
		}

		val jvmJvm8AFullstackVaadinTest by getting {
			dependsOn(jvmJvm8FullstackTest)
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
