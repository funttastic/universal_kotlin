import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
	kotlin("multiplatform")

	id("com.github.johnrengelman.shadow")
	id("java")
}

//group = "com.company.team.application.jvm.jvm8.terminal"
//version = "0.0.1"

kotlin {
	configureTargetAttributes(ModuleEnum.`application-terminal-jvm-terminal`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

	jvm(TargetEnum.`application-terminal-jvm-terminal@jvm`) {
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-terminal-jvm-terminal@jvm@main`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}

		configureSourceSet(SourceSetEnum.`application-terminal-jvm-terminal@jvm@test`) {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}
	}
}

tasks.withType<ShadowJar> {
	manifest {
		attributes.put("Main-Class", "com.company.team.project.application.terminal.jvm.terminal.ExampleKt")
	}

//	val target = TargetEnum.`application-terminal-jvm-terminal@jvm`.kotlinTarget!!
	// Assuming just one target.
	val target = kotlin.targets.iterator().next()
	from(target.compilations[CompilationEnum.main.id!!].output)
	val runtimeClasspath = target.compilations[CompilationEnum.main.id!!].compileDependencyFiles as Configuration
	configurations = mutableListOf(runtimeClasspath)
}
