package com.company.team.project.dsl

import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.enum_.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.slf4j.LoggerFactory

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
				it.dependencies?.modules?.forEach {
					it2 -> it2.status = StatusEnum.enabled
				}

				it.dependencies?.targets?.forEach {
					it2 -> it2.status = StatusEnum.enabled
					it2.module?.status = StatusEnum.enabled
				}

				it.dependencies?.sourceSets?.forEach {
					it2 -> it2.status = StatusEnum.enabled
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
