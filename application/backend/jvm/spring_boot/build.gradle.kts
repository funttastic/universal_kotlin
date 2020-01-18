import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("multiplatform")
	kotlin("plugin.spring")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

kotlin {
	// TODO Fix the usage of this target.
//	jvm(TargetEnum.`application-backend-jvm-spring_boot@jvm`) {
//		withJava()
//	}

	jvm {
		withJava()
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-backend-jvm-spring_boot@jvm@main`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-common"))
				implementation(kotlin("stdlib"))
				implementation(kotlin("stdlib-jdk8"))
				implementation(kotlin("reflect"))

				// Workaround to solve a problem trying to download an nonexistent dependency: org.apache.logging.log4j:log4j-api:0.0.1
				implementation("org.apache.logging.log4j:log4j-api:2.11.2")

				implementation("org.springframework.boot:spring-boot-starter")
				implementation("org.springframework.boot:spring-boot-starter-web")
				implementation("org.springframework.boot:spring-boot-starter-actuator")
			}
		}

		configureSourceSet(SourceSetEnum.`application-backend-jvm-spring_boot@jvm@test`) {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
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
