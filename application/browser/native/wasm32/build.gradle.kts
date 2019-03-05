import org.jetbrains.kotlin.gradle.tasks.KotlinNativeCompile
import java.nio.file.Paths

plugins {
	kotlin("multiplatform")
}

repositories {
	jcenter()
}

val packageName = "kotlinx.interop.wasm.dom"
val jsinteropKlibFileName = Paths.get(buildDir.toString(), "klib", "$packageName-jsinterop.klib").toString()

kotlin {
	val commonAttribute = Attribute.of("com.company.team.project.common.single_source_set", String::class.java)

	wasm32 {
		attributes.attribute(commonAttribute, "nativeWasm32")

		compilations["main"].outputKinds("EXECUTABLE")
		compilations["main"].entryPoint("com.company.team.project.application.browser.native_.wasm32.main")
	}

	sourceSets {
		val wasm32Main by getting {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(files(jsinteropKlibFileName))
			}
		}
		val wasm32Test by getting {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
			}
		}
	}
}

val jsinterop = tasks.create("jsinterop", Exec::class.java) {
	workingDir = projectDir
	val os = org.gradle.internal.os.OperatingSystem.current()!!
	val ext = if (os.isWindows) ".bat" else ""
	val distributionPath = project.properties["konanHome"] as String
	val jsinteropCommand = Paths.get(file(distributionPath).path, "bin", "jsinterop$ext").toString()

	inputs.property("jsinteropCommand", jsinteropCommand)
	inputs.property("jsinteropPackageName", packageName)
	outputs.file(jsinteropKlibFileName)

	commandLine(
		jsinteropCommand,
		"-pkg",
		packageName,
		"-o",
		jsinteropKlibFileName,
		"-target",
		"wasm32"
	)
}

tasks.withType(KotlinNativeCompile::class.java).all {
	dependsOn(jsinterop)
}
