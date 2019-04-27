import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//	kotlin("multiplatform")
	id("kotlin-spring")
	id("kotlin-platform-jvm")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
}

//group = "com.company.team"
//version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib-common"))
	implementation(kotlin("stdlib"))
	implementation(kotlin("stdlib-jdk8"))
	implementation(kotlin("reflect"))

//	 Workaround to solve a problem trying to download an nonexistent dependency: org.apache.logging.log4j:log4j-api:0.0.1
	implementation("org.apache.logging.log4j:log4j-api:2.11.2")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")

	configureDependencies(SourceSetEnum.`application-backend-jvm-spring_boot@main@jvm`)

//	 This dependencies will be loaded from the local maven repository
//	implementation(ModuleEnum.`library-multiple_sources`.fullIdentifier!!)
//	implementation(ModuleEnum.`library-single_source`.fullIdentifier!!)

	testImplementation(kotlin("test-common"))
	testImplementation(kotlin("test-annotations-common"))
	testImplementation(kotlin("test"))
	testImplementation(kotlin("test-junit"))

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	configureDependencies(SourceSetEnum.`application-backend-jvm-spring_boot@test@jvm`)
}

// Due to current limitations we are not properly able to use the ``kotlin("multiplatform") plugin.
// 	The related issue is: https://youtrack.jetbrains.com/issue/KT-30340
//kotlin {
//	val commonAttribute = Attribute.of("com.company.team.project.common.single_source", String::class.java)
//
//	jvm() {
//		attributes.attribute(commonAttribute, "jvmJvm8ApiSpringBoot")
//	}
//
//	sourceSets {
//		val jvmMain by getting {
//			kotlin.srcDir("src/main/kotlin")
//			resources.srcDir("src/main/resources")
//
//			dependencies {
//				implementation(project(":common:single_source"))
//
//				implementation(kotlin("stdlib-common"))
//				implementation(kotlin("stdlib"))
//				implementation(kotlin("stdlib-jdk8"))
//				implementation(kotlin("reflect"))
//
//				// Workaround to solve a problem trying to download an nonexistent dependency: org.apache.logging.log4j:log4j-api:0.0.1
//				implementation("org.apache.logging.log4j:log4j-api:2.11.2")
//
//				implementation("org.springframework.boot:spring-boot-starter")
//				implementation("org.springframework.boot:spring-boot-starter-web")
//			}
//		}
//
//		val jvmTest by getting {
//			kotlin.srcDir("src/test/kotlin")
//			resources.srcDir("src/test/resources")
//
//			dependencies {
//				implementation(project(":common:single_source"))
//
//				implementation(kotlin("test-common"))
//				implementation(kotlin("test-annotations-common"))
//				implementation(kotlin("test"))
//				implementation(kotlin("test-junit"))
//
//				implementation("org.springframework.boot:spring-boot-starter-test")
//			}
//		}
//	}
//}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		jvmTarget = "1.8"
		freeCompilerArgs = listOf("-Xjsr305=strict")
	}
}
