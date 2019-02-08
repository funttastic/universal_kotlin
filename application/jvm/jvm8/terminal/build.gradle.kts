plugins {
	kotlin("multiplatform")
}

group = "com.company.team.application.jvm.terminal"
version = "0.0.1"

kotlin {
	val commonAttribute = Attribute.of("com.company.team.common", String::class.java)

	jvm {
		attributes.attribute(commonAttribute, "jvm")

		// TODO Using the following version works but IntelliJ do not recognize the functions correctly.
//		attributes.attribute(commonAttribute, "jvmJvm8")
	}

	sourceSets {
		val jvmMain by getting {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(project(":common"))

				implementation(kotlin("stdlib-jdk8"))
			}
		}

		val jvmTest by getting {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(project(":common"))

				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}
	}
}
