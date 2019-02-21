plugins {
	kotlin("multiplatform")
}

kotlin {
	val os = org.gradle.internal.os.OperatingSystem.current()!!

	val commonAttribute = Attribute.of("com.company.team.project.common", String::class.java)

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

	jvm("jvmJvm7") {
	}

	jvm("jvmJvm8") {
	}

//	android("jvmJvm8Android") {
//	}

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

	jvm("jvmJvm8FullstackJsf") {
	}

	jvm("jvmJvm8FullstackVaadin") {
	}

	jvm("jvmJvm9") {
	}

	jvm("jvmJvm10") {
	}

	jvm("jvmJvm11") {
	}

	androidNativeArm32("nativeAndroidArm32") {
	}

	androidNativeArm64("nativeAndroidArm64") {
	}

//	if (os.isMacOsX) {
		iosArm32("nativeIosArm32") {
		}

		iosArm64("nativeIosArm64") {
		}

		iosX64("nativeIosX64") {
			compilations["main"].outputKinds("framework")
		}

		macosX64("nativeMacosX64") {
		}
//	}

//	if (os.isLinux()) {
		linuxArm32Hfp("nativeLinuxArm32Hfp") {
		}

		linuxMips32("nativeLinuxMips32") {
		}

		linuxMipsel32("nativeLinuxMipsel32") {
		}

		linuxX64("nativeLinuxX64") {
		}
//	}

//	if (os.isWindows()) {
		mingwX64("nativeMingwX64") {
		}
//	}

	wasm32("nativeWasm32") {
	}

	sourceSets {
		all {
//			languageSettings {
//				progressiveMode = true
//			}
		}

		val commonMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/common")
			resources.srcDir("src/main/resources/common")

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
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/common")
			resources.srcDir("src/test/resources/common")

			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

		val mobileMain by creating {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/mobile/common")
			resources.srcDir("src/main/resources/mobile/common")

			dependsOn(commonMain)

			dependencies {
			}
		}

		val mobileTest by creating {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/mobile/common")
			resources.srcDir("src/test/resources/mobile/common")

			dependsOn(commonTest)
		}

		val jsMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/js/common")
			resources.srcDir("src/main/resources/js/common")

			dependsOn(commonMain)

			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}

		val jsTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/js/common")
			resources.srcDir("src/test/resources/js/common")

			dependsOn(commonTest)

			dependencies {
				implementation(kotlin("test-js"))
			}
		}

		val jsSpaMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/js/spa/common")
			resources.srcDir("src/main/resources/js/spa/common")

			dependsOn(jsMain)
		}

		val jsSpaTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/js/spa/common")
			resources.srcDir("src/test/resources/js/spa/common")

			dependsOn(jsTest)
		}

		val jsSpaAngularMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/js/spa/angular/common")
			resources.srcDir("src/main/resources/js/spa/angular/common")

			dependsOn(jsSpaMain)
		}

		val jsSpaAngularTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/js/spa/angular/common")
			resources.srcDir("src/test/resources/js/spa/angular/common")

			dependsOn(jsSpaTest)
		}

		val jsSpaReactMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/js/spa/react/common")
			resources.srcDir("src/main/resources/js/spa/react/common")

			dependsOn(jsSpaMain)
		}

		val jsSpaReactTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/js/spa/react/common")
			resources.srcDir("src/test/resources/js/spa/react/common")

			dependsOn(jsSpaTest)
		}

		val jsSpaVueMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/js/spa/vue/common")
			resources.srcDir("src/main/resources/js/spa/vue/common")

			dependsOn(jsSpaMain)
		}

		val jsSpaVueTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/js/spa/vue/common")
			resources.srcDir("src/test/resources/js/spa/vue/common")

			dependsOn(jsSpaTest)
		}

		val jsVanillaMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/js/vanilla/common")
			resources.srcDir("src/main/resources/js/vanilla/common")

			dependsOn(jsMain)
		}

		val jsVanillaTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/js/vanilla/common")
			resources.srcDir("src/test/resources/js/vanilla/common")

			dependsOn(jsTest)
		}

		val jvmMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/common")
			resources.srcDir("src/main/resources/jvm/common")

			dependsOn(commonMain)

			dependencies {
//				implementation(kotlin("stdlib"))
			}
		}

		val jvmTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/common")
			resources.srcDir("src/test/resources/jvm/common")

			dependsOn(commonTest)

			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}

		val jvmJvm6Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm6/common")
			resources.srcDir("src/main/resources/jvm/jvm6/common")

			dependsOn(jvmMain)
		}

		val jvmJvm6Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm6/common")
			resources.srcDir("src/test/resources/jvm/jvm6/common")

			dependsOn(jvmTest)
		}

		val jvmJvm7Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm7/common")
			resources.srcDir("src/main/resources/jvm/jvm7/common")

			dependsOn(jvmMain)
		}

		val jvmJvm7Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm7/common")
			resources.srcDir("src/test/resources/jvm/jvm7/common")

			dependsOn(jvmTest)
		}

		val jvmJvm8Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/common")
			resources.srcDir("src/main/resources/jvm/jvm8/common")

			dependsOn(jvmMain)

			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}

		val jvmJvm8Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/common")
			resources.srcDir("src/test/resources/jvm/jvm8/common")

			dependsOn(jvmTest)
		}

		val jvmJvm8AndroidMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/android/common")
			resources.srcDir("src/main/resources/jvm/jvm8/android/common")

			dependsOn(jvmJvm8Main)
			dependsOn(mobileMain)
		}

		val jvmJvm8AndroidTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/android/common")
			resources.srcDir("src/test/resources/jvm/jvm8/android/common")

			dependsOn(jvmJvm8Test)
			dependsOn(mobileTest)
		}

		val jvmJvm8ApiMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/api/common")
			resources.srcDir("src/main/resources/jvm/jvm8/api/common")

			dependsOn(jvmJvm8Main)
		}

		val jvmJvm8ApiTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/api/common")
			resources.srcDir("src/test/resources/jvm/jvm8/api/common")

			dependsOn(jvmJvm8Test)
		}

		val jvmJvm8ApiSpringBootMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/api/spring_boot/common")
			resources.srcDir("src/main/resources/jvm/jvm8/api/spring_boot/common")

			dependsOn(jvmJvm8ApiMain)
		}

		val jvmJvm8ApiSpringBootTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/api/spring_boot/common")
			resources.srcDir("src/test/resources/jvm/jvm8/api/spring_boot/common")

			dependsOn(jvmJvm8ApiTest)
		}

		val jvmJvm8DesktopMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/desktop/common")
			resources.srcDir("src/main/resources/jvm/jvm8/desktop/common")
			dependsOn(jvmJvm8Main)
		}

		val jvmJvm8DesktopTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/desktop/common")
			resources.srcDir("src/test/resources/jvm/jvm8/desktop/common")

			dependsOn(jvmJvm8Test)
		}

		val jvmJvm8DesktopSwingMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/desktop/swing/common")
			resources.srcDir("src/main/resources/jvm/jvm8/desktop/swing/common")

			dependsOn(jvmJvm8DesktopMain)
		}

		val jvmJvm8DesktopSwingTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/desktop/swing/common")
			resources.srcDir("src/test/resources/jvm/jvm8/desktop/swing/common")

			dependsOn(jvmJvm8DesktopTest)
		}

		val jvmJvm8DesktopTornadoFxMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/desktop/tornadofx/common")
			resources.srcDir("src/main/resources/jvm/jvm8/desktop/tornadofx/common")

			dependsOn(jvmJvm8DesktopMain)
		}

		val jvmJvm8DesktopTornadoFxTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/desktop/tornadofx/common")
			resources.srcDir("src/test/resources/jvm/jvm8/desktop/tornadofx/common")

			dependsOn(jvmJvm8DesktopTest)
		}

		val jvmJvm8FullstackMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/fullstack/common")
			resources.srcDir("src/main/resources/jvm/jvm8/fullstack/common")

			dependsOn(jvmJvm8Main)
		}

		val jvmJvm8FullstackTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/fullstack/common")
			resources.srcDir("src/test/resources/jvm/jvm8/fullstack/common")

			dependsOn(jvmJvm8Test)
		}

		val jvmJvm8FullstackJsfMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/fullstack/jsf/common")
			resources.srcDir("src/main/resources/jvm/jvm8/fullstack/jsf/common")

			dependsOn(jvmJvm8FullstackMain)
		}

		val jvmJvm8FullstackJsfTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/fullstack/jsf/common")
			resources.srcDir("src/test/resources/jvm/jvm8/fullstack/jsf/common")

			dependsOn(jvmJvm8FullstackTest)
		}

		val jvmJvm8FullstackVaadinMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm8/fullstack/vaadin/common")
			resources.srcDir("src/main/resources/jvm/jvm8/fullstack/vaadin/common")

			dependsOn(jvmJvm8FullstackMain)
		}

		val jvmJvm8FullstackVaadinTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm8/fullstack/vaadin/common")
			resources.srcDir("src/test/resources/jvm/jvm8/fullstack/vaadin/common")

			dependsOn(jvmJvm8FullstackTest)
		}

		val jvmJvm9Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm9/common")
			resources.srcDir("src/main/resources/jvm/jvm9/common")

			dependsOn(jvmMain)
		}

		val jvmJvm9Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm9/common")
			resources.srcDir("src/test/resources/jvm/jvm9/common")

			dependsOn(jvmTest)
		}

		val jvmJvm10Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm10/common")
			resources.srcDir("src/main/resources/jvm/jvm10/common")

			dependsOn(jvmMain)
		}

		val jvmJvm10Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm10/common")
			resources.srcDir("src/test/resources/jvm/jvm10/common")

			dependsOn(jvmTest)
		}

		val jvmJvm11Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/jvm/jvm11/common")
			resources.srcDir("src/main/resources/jvm/jvm11/common")

			dependsOn(jvmMain)
		}

		val jvmJvm11Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/jvm/jvm11/common")
			resources.srcDir("src/test/resources/jvm/jvm11/common")

			dependsOn(jvmTest)
		}

		val nativeMain by creating {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/common")
			resources.srcDir("src/main/resources/native/common")

			dependsOn(commonMain)
		}

		val nativeTest by creating {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/common")
			resources.srcDir("src/test/resources/native/common")

			dependsOn(commonTest)
		}

		val nativeAndroidArm32Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/linux/android/arm32/common")
			resources.srcDir("src/main/resources/native/linux/android/arm32/common")

			dependsOn(nativeMain)
		}

		val nativeAndroidArm32Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/linux/android/arm32/common")
			resources.srcDir("src/test/resources/native/linux/android/arm32/common")

			dependsOn(nativeTest)
		}

		val nativeAndroidArm64Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/linux/android/arm64/common")
			resources.srcDir("src/main/resources/native/linux/android/arm64/common")

			dependsOn(nativeMain)
		}

		val nativeAndroidArm64Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/linux/android/arm64/common")
			resources.srcDir("src/test/resources/native/linux/android/arm64/common")

			dependsOn(nativeTest)
		}

		val nativeIosArm32Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/apple/ios/arm32/common")
			resources.srcDir("src/main/resources/native/apple/ios/arm32/common")

			dependsOn(nativeMain)
		}

		val nativeIosArm32Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/apple/ios/arm32/common")
			resources.srcDir("src/test/resources/native/apple/ios/arm32/common")

			dependsOn(nativeTest)
		}

		val nativeIosArm64Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/apple/ios/arm64/common")
			resources.srcDir("src/main/resources/native/apple/ios/arm64/common")

			dependsOn(nativeMain)
		}

		val nativeIosArm64Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/apple/ios/arm64/common")
			resources.srcDir("src/test/resources/native/apple/ios/arm64/common")

			dependsOn(nativeTest)
		}

		val nativeIosX64Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/apple/ios/x64/common")
			resources.srcDir("src/main/resources/native/apple/ios/x64/common")

			dependsOn(nativeMain)
		}

		val nativeIosX64Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/apple/ios/x64/common")
			resources.srcDir("src/test/resources/native/apple/ios/x64/common")

			dependsOn(nativeTest)
		}

		val nativeLinuxArm32HfpMain by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/linux/arm32_hfp/common")
			resources.srcDir("src/main/resources/native/linux/arm32_hfp/common")

			dependsOn(nativeMain)
		}

		val nativeLinuxArm32HfpTest by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/linux/arm32_hfp/common")
			resources.srcDir("src/test/resources/native/linux/arm32_hfp/common")

			dependsOn(nativeTest)
		}

		val nativeLinuxMips32Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/linux/mips/mips32/common")
			resources.srcDir("src/main/resources/native/linux/mips/mips32/common")

			dependsOn(nativeMain)
		}

		val nativeLinuxMips32Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/linux/mips/mips32/common")
			resources.srcDir("src/test/resources/native/linux/mips/mips32/common")

			dependsOn(nativeTest)
		}

		val nativeLinuxMipsel32Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/linux/mips/mipsel32/common")
			resources.srcDir("src/main/resources/native/linux/mips/mipsel32/common")

			dependsOn(nativeMain)
		}

		val nativeLinuxMipsel32Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/linux/mips/mipsel32/common")
			resources.srcDir("src/test/resources/native/linux/mips/mipsel32/common")

			dependsOn(nativeTest)
		}

		val nativeLinuxX64Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/linux/x64/common")
			resources.srcDir("src/main/resources/native/linux/x64/common")

			dependsOn(nativeMain)
		}

		val nativeLinuxX64Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/linux/x64/common")
			resources.srcDir("src/test/resources/native/linux/x64/common")

			dependsOn(nativeTest)
		}

		val nativeMacosX64Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/apple/macos/x64/common")
			resources.srcDir("src/main/resources/native/apple/macos/x64/common")

			dependsOn(nativeMain)
		}

		val nativeMacosX64Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/apple/macos/x64/common")
			resources.srcDir("src/test/resources/native/apple/macos/x64/common")

			dependsOn(nativeTest)
		}

		val nativeMingwX64Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/windows/mingw_x64/common")
			resources.srcDir("src/main/resources/native/windows/mingw_x64/common")

			dependsOn(nativeMain)
		}

		val nativeMingwX64Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/windows/mingw_x64/common")
			resources.srcDir("src/test/resources/native/windows/mingw_x64/common")

			dependsOn(nativeTest)
		}

		val nativeWasm32Main by getting {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/native/web/wasm32/common")
			resources.srcDir("src/main/resources/native/web/wasm32/common")

			dependsOn(nativeMain)
		}

		val nativeWasm32Test by getting {
			kotlin.srcDir("src/test/kotlin/com/company/team/project/common/native/web/wasm32/common")
			resources.srcDir("src/test/resources/native/web/wasm32/common")

			dependsOn(nativeTest)
		}
	}
}

configurations {
	val compileClasspath by creating {
	}
}
