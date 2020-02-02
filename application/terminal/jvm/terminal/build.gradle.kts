import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
	kotlin("multiplatform")

	id("com.github.johnrengelman.shadow")
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
		withJava()
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-terminal-jvm-terminal@jvm@main`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-jdk8"))
				implementation("org.jline:jline-terminal:3.13.3")
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

val postBuild by tasks.registering {
	doLast {
		println("\n\n\n")
		com.company.team.project.dsl.model.Properties.projects.root.project?.allprojects?.forEach { project ->
			println("Project: ${project.name}")

			project.configurations.forEach { configuration ->
				println("\tConfiguration: ${configuration.name}")

				if (configuration.allDependencies.isNotEmpty()) {
					configuration.allDependencies.forEach { dependency ->
						println("\t\tDependency: ${dependency.group}:${dependency.name}:${dependency.version}")
					}
				}
			}
		}
		println("\n\n\n")

		 println("\n\n\n")
		 ModuleEnum.values().forEach { module ->
		 	println("Module ${module.name} (status: ${module.status}, kotlinId: ${module.kotlinId})")
		 	println("\tRequired at")
		 	module.requiredAt.forEach { requiredAt ->
		 		println("\t\t${requiredAt.name} (status: ${requiredAt.status})")
		 	}
		 	module.targets.forEach { target ->
		 		println("\tTarget ${target.name} (status: ${target.status}, kotlinId: ${target.kotlinId}, kotlinTarget ${target.kotlinTarget})")
		 		println("\t\tRequired at")
		 		target.requiredAt.forEach { requiredAt ->
		 			println("\t\t\t${requiredAt.name} (status: ${requiredAt.status})")
		 		}
		 		target.sourceSets.forEach { sourceSet ->
		 			println("\t\tSource set ${sourceSet.name} (status: ${sourceSet.status}, kotlinId: ${sourceSet.kotlinId}, kotlinSourceSet: ${sourceSet.kotlinSourceSet})")
		 			println("\t\t\tDepends on")
		 			sourceSet.kotlinSourceSet?.dependsOn?.forEach { dependOn ->
		 				println("\t\t\t\t${dependOn.name}")
		 			}
		 			println("\t\t\tRequired at")
		 			sourceSet.requiredAt.forEach { requiredAt ->
		 				println("\t\t\t\t${requiredAt.name} (status: ${requiredAt.status})")
		 			}
		 		}
		 	}
		 }
	}
}

//tasks.named("shadowJar").configure {
//	dependsOn(postBuild)
//}
