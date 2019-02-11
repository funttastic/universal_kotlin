import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinJsCompilation
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
	kotlin("multiplatform")
}

group = "com.company.team.application.js.vanilla"
version = "0.0.1"

kotlin {
	val commonAttribute = Attribute.of("com.company.team.project.common", String::class.java)

	js {
		attributes.attribute(commonAttribute, "jsVanilla")
	}

	sourceSets {
		val jsMain by getting {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(project(":common"))

				implementation(kotlin("stdlib-js"))
			}
		}

		val jsTest by getting {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(project(":common"))

				implementation(kotlin("test-js"))
			}
		}
	}
}

tasks.withType<Kotlin2JsCompile> {
	kotlinOptions {
		languageVersion = "1.3"
		moduleKind = "umd"
		sourceMap = true
		metaInfo = true
	}
}

val webFolder = File(project.buildDir, "../src/main/web")
val jsCompilations = kotlin.targets["js"].compilations

task("populateWebFolder"){
	dependsOn("jsMainClasses")
	doLast {
		copy {
			from(jsCompilations["main"].output)
				from(kotlin.sourceSets["jsMain"].resources.srcDirs)
			(jsCompilations["test"]as KotlinJsCompilation).runtimeDependencyFiles.forEach {
					if (it.exists() && !it.isDirectory()) {
						from(zipTree(it.absolutePath).matching { include("*.js") })
					}
				}
			into(webFolder)
		}
	}
}

tasks.getByName("jsJar") {
	dependsOn("populateWebFolder")
}
