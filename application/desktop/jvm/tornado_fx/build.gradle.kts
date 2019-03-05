import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("multiplatform")
}

group = "com.company.team.application.jvm.jvm8.terminal"
version = "0.0.1"

repositories {
	mavenCentral()
}

kotlin {
	val commonAttribute = Attribute.of("com.company.team.project.common.single_source_set", String::class.java)

	jvm {
		attributes.attribute(commonAttribute, "jvm")

		// TODO Using the following version works but IntelliJ do not recognize the functions correctly.
//		attributes.attribute(commonAttribute, "jvmJvm8Desktop")
	}

	sourceSets {
		val jvmMain by getting {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(project(":common:single_source_set"))

				implementation(kotlin("stdlib-jdk8"))

				implementation("no.tornado:tornadofx:1.7.18")
			}
		}

		val jvmTest by getting {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(project(":common:single_source_set"))

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
