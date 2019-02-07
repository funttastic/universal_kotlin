plugins {
	kotlin("multiplatform")
}

group = "com.company.team.application.jvm.terminal"
version = "0.0.1"

kotlin {
	val commonAttribute = Attribute.of("com.company.team.common", String::class.java)

	jvm {
		attributes.attribute(commonAttribute, targetName)
	}

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(kotlin("stdlib-common"))

				implementation(project(":common"))
			}
		}

		val commonTest by getting {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))

				implementation(project(":common"))
			}
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
	}
}
