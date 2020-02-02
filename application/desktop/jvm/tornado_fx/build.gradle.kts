import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	// kotlin("multiplatform")

	id("kotlin")

    java
    application

	// id("com.github.johnrengelman.shadow")
 	// id("no.tornado.fxlauncher") version "1.0.20"
 	// id("javafx-gradle-plugin")
}

application {
    mainClassName = "com.company.team.project.application.desktop.jvm.tornado_fx.App"
}

repositories {
	mavenCentral()
	jcenter()
	google()
	mavenLocal()
	maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
	maven( url = "https://dl.bintray.com/kotlin/kotlin-dev" )
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	implementation("no.tornado:tornadofx:1.7.18")

	configureDependencies(SourceSetEnum.`application-desktop-jvm-tornado_fx@jvm@main`)


	testImplementation(kotlin("test"))
	testImplementation(kotlin("test-junit"))

	configureDependencies(SourceSetEnum.`application-desktop-jvm-tornado_fx@jvm@test`)
}

// kotlin {
// 	configureTargetAttributes(ModuleEnum.`application-desktop-jvm-tornado_fx`)

// //	targets.all {
// //			compilations.all {
// //				tasks[compileKotlinTaskName].kotlinOptions {
// //					allWarningsAsErrors = true
// //				}
// //			}
// //	}

// 	jvm(TargetEnum.`application-desktop-jvm-tornado_fx@jvm`) {
// 	}

// 	sourceSets {
// 		configureSourceSet(SourceSetEnum.`application-desktop-jvm-tornado_fx@jvm@main`) {
// 			kotlin.setSrcDir("src/main/kotlin")
// 			resources.setSrcDir("src/main/resources")

// 			dependencies {
// 				implementation(kotlin("stdlib-jdk8"))

// 				implementation("no.tornado:tornadofx:1.7.18")
// 			}
// 		}

// 		configureSourceSet(SourceSetEnum.`application-desktop-jvm-tornado_fx@jvm@test`) {
// 			kotlin.setSrcDir("src/test/kotlin")
// 			resources.setSrcDir("src/test/resources")

// 			dependencies {
// 				implementation(kotlin("test"))
// 				implementation(kotlin("test-junit"))
// 			}
// 		}
// 	}
// }

tasks {
	withType<KotlinCompile>().configureEach {
		kotlinOptions {
			jvmTarget = "1.8" // JavaVersion.VERSION_1_8
		}
	}
}

// tasks.withType<ShadowJar> {
// 	manifest {
// 		attributes.put("Main-Class", "com.company.team.project.application.desktop.jvm.tornado_fx.App")
// 	}

// //	val target = TargetEnum.`application-desktop-jvm-tornado_fx@jvm`.kotlinTarget!!
// 	// Assuming just one target (this strategy works with the kotlin multiplatform plugin only for now).
// 	val target = kotlin.targets.iterator().next()
// 	from(target.compilations[CompilationEnum.main.id!!].output)
// 	val runtimeClasspath = target.compilations[CompilationEnum.main.id!!].compileDependencyFiles as Configuration
// 	configurations = mutableListOf(runtimeClasspath)
// }

//fxlauncher {
//	applicationVendor = "Company"
//	applicationUrl = "file:///path/to/project/application/desktop/jvm/tornado_fx/build/fxlauncher"
//	applicationMainClass = "com.company.team.project.application.desktop.jvm.tornado_fx.App"
//	acceptDowngrade = true
//	deployTarget = "/path/to/project/application/desktop/jvm/tornado_fx/build/fxlauncher"
//}

// jfx {
// 	mainClass = "com.company.team.project.application.desktop.jvm.tornado_fx.App"
//
// 	vendor = "Company"
// }
