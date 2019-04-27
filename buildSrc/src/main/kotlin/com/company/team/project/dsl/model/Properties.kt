package com.company.team.project.dsl.model

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.gradle.api.Project
import org.gradle.api.initialization.ProjectDescriptor
import java.io.File
import java.nio.file.Paths
import java.util.Properties

/**
 *
 */
object Properties {

	/**
	 *
	 */
	object general {
		val group = properties.getOrDefault("project.group", "com.company.team.project")
		val groupAsPath = Paths.get(group.replace(".", "/"))
		val version = properties.getOrDefault("project.version", "0.0.1")
	}

	/**
	 *
	 */
	object util {
		val groupSeparator = "."
		val folderSeparator = "-"
		val nameSeparator = "_"
		val domainSeparator = "@"
		val pathSeparator = File.pathSeparator
		val folderConcatenator = " -> "
		val nameConcatenator = " "
		val domainConcatenator = " -> "

		/**
		 *
		 */
		val os by lazy {
			org.gradle.internal.os.OperatingSystem.current()!!
		}

		/**
		 *
		 */
		val jvm by lazy {
			org.gradle.internal.jvm.Jvm.current()
		}

		val commonMain = "commonMain"
		val commonTest = "commonTest"
	}

	object properties {

		/**
		 *
		 */
		val environment by lazy {
			System.getenv()
		}

		/**
		 *
		 */
		var system: Properties = Properties()

		/**
		 *
		 */
		val gradle: Properties by lazy {
			val relativePath = "gradle.properties"
			val file = Paths.get(projects.root.descriptor?.projectDir?.absolutePath, relativePath).toFile()

			val properties = Properties()

			if (file.canRead()) {
				properties.load(java.io.FileInputStream(file))
			}

			properties
		}

		/**
		 *
		 */
		val local: Properties by lazy {
			val relativePath = "local.properties"
			val file = Paths.get(projects.root.descriptor?.projectDir?.absolutePath, relativePath).toFile()

			val properties = Properties()

			if (file.canRead()) {
				properties.load(java.io.FileInputStream(file))
			}

			properties
		}

//		/**
//		 *
//		 */
//		val configuration by lazy {
//			String relativePath = "buildSrc/src/main/resources/configuration.yml"
//			val path = Paths.get(projects.root.descriptor?.projectDir?.absolutePath, relativePath)
//
//			val mapper = ObjectMapper(YAMLFactory())
//			mapper.registerModule(KotlinModule())
//
//			return@lazy Files.newBufferedReader(path).use {
//				mapper.readValue(it, Configuration::class.java)
//			}
//		}

		/**
		 *
		 */
		fun containsKey(key: String?): Boolean {
			if (key == null) return false

			return when {
				environment.containsKey(key) -> true
				system.containsKey(key) -> true
				local.containsKey(key) -> true
				gradle.containsKey(key) -> true
				else -> false
			}
		}

		/**
		 *
		 */
		inline fun <reified R> get(key: String?): R? {
			if (key == null) return null

			return when {
				environment.containsKey(key) -> environment[key]
				system.containsKey(key) -> system[key]
				local.containsKey(key) -> local[key]
				gradle.containsKey(key) -> gradle[key]
				else -> null
			} as R?
		}

		/**
		 *
		 */
		inline fun <reified R> getOrDefault(key: String?, default: R): R {
			return get(key) ?: default
		}

//		/**
//		 *
//		 */
//		fun get(key: String?): Any? {
//			if (key == null) return null
//
//			return when {
//				environment.containsKey(key) -> environment[key]
//				system.containsKey(key) -> system[key]
//				local.containsKey(key) -> local[key]
//				gradle.containsKey(key) -> gradle[key]
//				else -> null
//			}
//		}
//
//		/**
//		 *
//		 */
//		fun getOrDefault(key: String?, default: Any): Any {
//			return get(key) ?: default
//		}
	}

	object projects {
		object root {
			var descriptor: ProjectDescriptor? = null

			var project: Project? = null
		}
	}

	/**
	 *
	 */
	object vendor {
		val kotlin = properties.get<String>("kotlin.version")

		val springBoot = "2.1.2.RELEASE"
		val androidTools = "3.3.2"
		val frontend = "0.0.45"
	}
}
