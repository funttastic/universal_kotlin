import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
	kotlin("multiplatform")

	id("com.github.johnrengelman.shadow")
	id("java")
//	 id("no.tornado.fxlauncher") version "1.0.20"
//	 id("javafx-gradle-plugin")
}

repositories {
	mavenCentral()
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-desktop-jvm-tornado_fx`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

	jvm(TargetEnum.`application-desktop-jvm-tornado_fx@jvm`) {
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-desktop-jvm-tornado_fx@main@jvm`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-jdk8"))

				implementation("no.tornado:tornadofx:1.7.18")
			}
		}

		configureSourceSet(SourceSetEnum.`application-desktop-jvm-tornado_fx@test@jvm`) {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}
	}
}

tasks {
	withType<KotlinCompile>().configureEach {
		kotlinOptions {
			jvmTarget = "1.8" // JavaVersion.VERSION_1_8
		}
	}
}

tasks.withType<ShadowJar> {
	manifest {
		attributes.put("Main-Class", "com.company.team.project.application.desktop.jvm.tornado_fx.App")
	}

//	val target = TargetEnum.`application-desktop-jvm-tornado_fx@jvm`.kotlinTarget!!
	// Assuming just one target.
	val target = kotlin.targets.iterator().next()
	from(target.compilations[CompilationEnum.main.id!!].output)
	val runtimeClasspath = target.compilations[CompilationEnum.main.id!!].compileDependencyFiles as Configuration
	configurations = mutableListOf(runtimeClasspath)
}


//fxlauncher {
//	applicationVendor = "My Company"
//	// Base URL where you will host the application artifacts
//	applicationUrl = "http://fxldemo.tornado.no/"
//	applicationMainClass = "no.tornado.FxlDemo"
//	acceptDowngrade = false
//	// Optional scp target for application artifacts hosted at the above url
//	deployTarget = "w48839@fxldemo.tornado.no:fxldemo"
//}

// jfx {
// 	// minimal requirement for jfxJar-task
// 	mainClass = "com.company.team.project.application.desktop.jvm.tornado_fx.App"
//
// 	// minimal requirement for jfxNative-task
// 	vendor = "YourName"
// }
