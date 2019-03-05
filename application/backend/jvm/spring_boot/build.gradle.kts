import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("multiplatform")
	id("kotlin-spring")
//	id("kotlin-platform-jvm")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
}

group = "com.company.team"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

kotlin {
	val commonAttribute = Attribute.of("com.company.team.project.common.single_source_set", String::class.java)

	jvm() {
		attributes.attribute(commonAttribute, "jvmJvm8ApiSpringBoot")
	}

	sourceSets {
		val jvmMain by getting {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(project(":common:single_source_set"))

				implementation(kotlin("stdlib-common"))
				implementation(kotlin("stdlib"))
				implementation(kotlin("stdlib-jdk8"))
				implementation(kotlin("reflect"))

				// Workaround to solve a problem trying to download an nonexistent dependency: org.apache.logging.log4j:log4j-api:0.0.1
				implementation("org.apache.logging.log4j:log4j-api:2.11.2")

				implementation("org.springframework.boot:spring-boot-starter")
				implementation("org.springframework.boot:spring-boot-starter-web")
			}
		}

		val jvmTest by getting {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(project(":common:single_source_set"))

				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))

				implementation("org.springframework.boot:spring-boot-starter-test")
			}
		}
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		jvmTarget = "1.8"
		freeCompilerArgs = listOf("-Xjsr305=strict")
	}
}
