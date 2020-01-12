package com.company.team.project.dsl

import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.enum_.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

/**
 *
 */
object Util {

	/**
	 *
	 */
	private val jacksonObjectMapper by lazy {
		ObjectMapper()
			.registerModule(KotlinModule())
			.enable(SerializationFeature.INDENT_OUTPUT)
	}

	/**
	 *
	 */
	val logger = LoggerFactory.getLogger(Util::class.java)

	/**
	 *
	 */
	fun initialize() {
		// automaticallyDefineAndroidHomeIfPossible()
		checkAndSetModulesAvailabilities()
	}

	/**
	 *
	 */
	fun relativePathFromRoot(absolutePath: String): String? {
		return Properties.projects.root.absolutePath?.let { absolutePath.removePrefix(it) }
	}

	/**
	 *
	 */
	fun relativePathFromRoot(file: File): String? {
		return relativePathFromRoot(file.absolutePath)
	}

	/**
	 *
	 */
	fun relativePathFromRoot(path: Path): String? {
		return relativePathFromRoot(path.toFile())
	}

	/**
	 *
	 */
	fun checkAndSetModulesAvailabilities() {
		val enabledModules = Properties.properties.get<String>("enabledModules")
		val disabledModules = Properties.properties.get<String>("disabledModules")

		if (!enabledModules.isNullOrBlank()) {
			ModuleEnum.values().map { it.status = StatusEnum.disabled }

			enabledModules.split(",").map {
				ModuleEnum.getByName(it.trim())!!.status = StatusEnum.enabled
			}
		}

		if (!disabledModules.isNullOrBlank()) {
			disabledModules.split(",").map {
				ModuleEnum.getByName(it.trim())!!.status = StatusEnum.disabled
			}
		}

		SourceSetEnum.values()
			.filter { it.module?.status == StatusEnum.enabled }
			.forEach {
				it.dependencies?.modules?.forEach { it2 ->
					it2.status = StatusEnum.enabled
				}

				it.dependencies?.targets?.forEach { it2 ->
					it2.status = StatusEnum.enabled
					it2.module?.status = StatusEnum.enabled
				}

				it.dependencies?.sourceSets?.forEach {it2 ->
					it2.status = StatusEnum.enabled
					it2.target?.status = StatusEnum.enabled
					it2.module?.status = StatusEnum.enabled
				}
			}

		ModuleEnum.values()
			.filter { it.status == StatusEnum.enabled }
			.forEach {
				enableParents(it)
			}

		ModuleEnum.root.status = StatusEnum.disabled
	}

	/**
	 *
	 */
	fun enableParents(module: ModuleEnum) {
		if (module.parent != null) {
			module.parent!!.status = StatusEnum.enabled
			enableParents(module.parent!!)
		}
	}

	fun automaticallyDefineAndroidHomeIfPossible() {
		var androidHome = Properties.properties.get<String>("ANDROID_HOME")
		if (androidHome == null) androidHome = Properties.properties.get<String>("sdk.dir")
		if (androidHome == null) {
			val probablePaths = mutableListOf<Path>()

			with(Properties.util.os) {
				with(Properties.properties) {
					when {
						isLinux -> {
							if (containsKey("user.home")) {
								probablePaths.add(
									Paths.get(
										get<String>("user.home"),
										"Android",
										"Sdk"
									)
								)
							}

							if (containsKey("HOME")) {
								probablePaths.add(
									Paths.get(
										get<String>("HOME"),
										"Android",
										"Sdk"
									)
								)
							}

							null
						}
						isMacOsX -> {
							if (containsKey("user.home")) {
								probablePaths.add(
									Paths.get(
										get<String>("user.home"),
										"Library",
										"Android",
										"sdk"
									)
								)
							}

							if (containsKey("HOME")) {
								probablePaths.add(
									Paths.get(
										get<String>("HOME"),
										"Library",
										"Android",
										"sdk"
									)
								)
							}

							null
						}
						isWindows -> {
							if (containsKey("LOCALAPPDATA")) {
								probablePaths.add(
									Paths.get(
										get<String>("LOCALAPPDATA"),
										"Android",
										"sdk"
									)
								)
							}

							null
						}
						else -> null
					}
				}
			}

			for (path in probablePaths) {
				val file = path.toFile()
				if (file.exists()) {
					logger.warn(
						"""
    				| Automatically defining "ANDROID_HOME" to "${file.absolutePath}".
    				| If this path is not correct, please set the "ANDROID_HOME" environment variable or configure your "local.properties" file.
						""".trimMargin()
					)

					addAdditionalEnvironmentVariables(mapOf("ANDROID_HOME" to file.absolutePath))

					break
				}
			}
		}
	}

	/**
	 * TODO This method causes problems when importing the project on IntelliJ. Try to improve it later.
	 */
	@Suppress("UNCHECKED_CAST")
	@Throws(Exception::class)
	fun addAdditionalEnvironmentVariables(additionalEnvironmentVariables: Map<String, String>) {
		try {
			val processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment")
			val theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment")
			theEnvironmentField.isAccessible = true
			val env = theEnvironmentField.get(null) as MutableMap<String, String>
			env.putAll(additionalEnvironmentVariables)
			val theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment")
			theCaseInsensitiveEnvironmentField.isAccessible = true
			val cienv = theCaseInsensitiveEnvironmentField.get(null) as MutableMap<String, String>
			cienv.putAll(additionalEnvironmentVariables)
		} catch (e: NoSuchFieldException) {
			val classes = Collections::class.java.getDeclaredClasses()
			val env = System.getenv()
			for (cl in classes) {
				if ("java.util.Collections\$UnmodifiableMap" == cl.getName()) {
					val field = cl.getDeclaredField("m")
					field.setAccessible(true)
					val obj = field.get(env)
					val map = obj as MutableMap<String, String>
					map.clear() // Do we need this here?
					map.putAll(additionalEnvironmentVariables)
				}
			}
		}
	}

	/**
	 *
	 */
	fun dumpConfigurations() {
		dump(Properties.properties.environment, Properties.properties::environment.name)
		dump(Properties.properties.system, Properties.properties::system.name)
		dump(Properties.properties.gradle, Properties.properties::gradle.name)
		dump(Properties.properties.local, Properties.properties::local.name)
		dump(Properties.util.os, Properties.util::os.name)
		dump(Properties.util.jvm, Properties.util::jvm.name)
		dump(ModuleEnum.values().filter { StatusEnum.enabled == it.status }, ModuleEnum::class.qualifiedName)
		dump(TargetEnum.values().filter { StatusEnum.enabled == it.status }, TargetEnum::class.qualifiedName)
		dump(SourceSetEnum.values().filter { StatusEnum.enabled == it.status }, SourceSetEnum::class.qualifiedName)
	}

	/**
	 *
	 */
	fun dump(target: Any?, title: String? = null) {
		val dump = try {
			jacksonObjectMapper.writeValueAsString(target)
		} catch (exception: Exception) {
			target.toString()
		}

		logger.warn(
			"${if(title != null && title.isNotBlank()) title else "dump"}: $dump"
		)
	}
}
