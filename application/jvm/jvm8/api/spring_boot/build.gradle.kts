plugins {
	kotlin("multiplatform")
	id("kotlin-spring")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
}

group = "com.company.team"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

kotlin {
	val commonAttribute = Attribute.of("com.company.team.project.common", String::class.java)

	jvm {
		attributes.attribute(commonAttribute, "jvmJvm8ApiSpringBoot")
	}

	sourceSets {
		val jvmMain by getting {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
				implementation(kotlin("stdlib-jdk8"))
				implementation(kotlin("reflect"))

				implementation(project(":common"))

				implementation("org.springframework.boot:spring-boot-starter")
			}
		}

		val jvmTest by getting {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))

				implementation(project(":common"))

				implementation("org.springframework.boot:spring-boot-starter-test")
			}
		}
	}
}
