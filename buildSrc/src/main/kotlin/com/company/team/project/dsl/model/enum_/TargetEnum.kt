package com.company.team.project.dsl.model.enum_

import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.Properties.util.os
import org.gradle.api.attributes.Attribute
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import com.company.team.project.dsl.model.enum_.StatusEnum.enabled
import com.company.team.project.dsl.model.enum_.StatusEnum.disabled
import kotlin.properties.Delegates

/**
 *
 */
enum class TargetEnum(

	/**
	 *
	 */
	var kotlinId: String? = null,

	/**
	 *
	 */
	var title: String? = null,

	/**
	 *
	 */
	var description: String? = null,

	/**
	 *
	 */
	var module: ModuleEnum? = null,

	/**
	 *
	 */
	var preset: PresetEnum? = null,

	/**
	 *
	 */
	var defaultStatus: StatusEnum = StatusEnum.disabled,

	/**
	 *
	 */
	var kotlinTarget: KotlinTarget? = null,

	/**
	 *
	 */
	val sourceSets: MutableList<SourceSetEnum> = mutableListOf(),

	/**
	 *
	 */
	val attributes: MutableList<Pair<Attribute<String>, String>> = mutableListOf(),

	/**
	 *
	 */
	val requiredAt: MutableList<SourceSetEnum> = mutableListOf()
) {

	`common-multiple_sources@android_native_arm32`( defaultStatus = enabled ),
	`common-multiple_sources@android_native_arm64`( defaultStatus = enabled ),
	`common-multiple_sources@ios_arm32`( defaultStatus = enabled ),
	`common-multiple_sources@ios_arm64`( defaultStatus = enabled ),
	`common-multiple_sources@ios_x64`( defaultStatus = enabled ),
	`common-multiple_sources@js`( defaultStatus = enabled ),
	`common-multiple_sources@jvm`( defaultStatus = enabled ),
	`common-multiple_sources@linux_arm32_hfp`( defaultStatus = disabled ),
	`common-multiple_sources@linux_mips32`( defaultStatus = disabled ),
	`common-multiple_sources@linux_mipsel32`( defaultStatus = disabled ),
	`common-multiple_sources@linux_x64`( defaultStatus = disabled ),
	`common-multiple_sources@macos_x64`( defaultStatus = disabled ),
	`common-multiple_sources@mingw_x64`( defaultStatus = disabled ),
	`common-multiple_sources@mingw_x86`( defaultStatus = disabled ),
	`common-multiple_sources@tvos_arm64`( defaultStatus = disabled ),
	`common-multiple_sources@tvos_x64`( defaultStatus = disabled ),
	`common-multiple_sources@wasm32`( defaultStatus = enabled ),
	`common-multiple_sources@watchos_arm32`( defaultStatus = disabled ),
	`common-multiple_sources@watchos_arm64`( defaultStatus = disabled ),
	`common-multiple_sources@watchos_x64`( defaultStatus = disabled ),
	`common-multiple_sources@watchos_x86`( defaultStatus = disabled ),

	`common-single_source@android_native_arm32`( defaultStatus = enabled ),
	`common-single_source@android_native_arm64`( defaultStatus = enabled ),
	`common-single_source@ios_arm32`( defaultStatus = enabled ),
	`common-single_source@ios_arm64`( defaultStatus = enabled ),
	`common-single_source@ios_x64`( defaultStatus = enabled ),
	`common-single_source@js`( defaultStatus = enabled ),
	`common-single_source@jvm`( defaultStatus = enabled ),
	`common-single_source@linux_arm32_hfp`( defaultStatus = disabled ),
	`common-single_source@linux_mips32`( defaultStatus = disabled ),
	`common-single_source@linux_mipsel32`( defaultStatus = disabled ),
	`common-single_source@linux_x64`( defaultStatus = disabled ),
	`common-single_source@macos_x64`( defaultStatus = disabled ),
	`common-single_source@mingw_x64`( defaultStatus = disabled ),
	`common-single_source@mingw_x86`( defaultStatus = disabled ),
	`common-single_source@tvos_arm64`( defaultStatus = disabled ),
	`common-single_source@tvos_x64`( defaultStatus = disabled ),
	`common-single_source@wasm32`( defaultStatus = enabled ),
	`common-single_source@watchos_arm32`( defaultStatus = disabled ),
	`common-single_source@watchos_arm64`( defaultStatus = disabled ),
	`common-single_source@watchos_x64`( defaultStatus = disabled ),
	`common-single_source@watchos_x86`( defaultStatus = disabled ),

	`library-multiple_sources@android_native_arm32`( defaultStatus = enabled ),
	`library-multiple_sources@android_native_arm64`( defaultStatus = enabled ),
	`library-multiple_sources@ios_arm32`( defaultStatus = enabled ),
	`library-multiple_sources@ios_arm64`( defaultStatus = enabled ),
	`library-multiple_sources@ios_x64`( defaultStatus = enabled ),
	`library-multiple_sources@js`( defaultStatus = enabled ),
	`library-multiple_sources@jvm`( defaultStatus = enabled ),
	`library-multiple_sources@linux_arm32_hfp`( defaultStatus = disabled ),
	`library-multiple_sources@linux_mips32`( defaultStatus = disabled ),
	`library-multiple_sources@linux_mipsel32`( defaultStatus = disabled ),
	`library-multiple_sources@linux_x64`( defaultStatus = disabled ),
	`library-multiple_sources@macos_x64`( defaultStatus = disabled ),
	`library-multiple_sources@mingw_x64`( defaultStatus = disabled ),
	`library-multiple_sources@mingw_x86`( defaultStatus = disabled ),
	`library-multiple_sources@tvos_arm64`( defaultStatus = disabled ),
	`library-multiple_sources@tvos_x64`( defaultStatus = disabled ),
	`library-multiple_sources@wasm32`( defaultStatus = enabled ),
	`library-multiple_sources@watchos_arm32`( defaultStatus = disabled ),
	`library-multiple_sources@watchos_arm64`( defaultStatus = disabled ),
	`library-multiple_sources@watchos_x64`( defaultStatus = disabled ),
	`library-multiple_sources@watchos_x86`( defaultStatus = disabled ),

	`library-single_source@android_native_arm32`( defaultStatus = enabled ),
	`library-single_source@android_native_arm64`( defaultStatus = disabled ),
	`library-single_source@ios_arm32`( defaultStatus = enabled ),
	`library-single_source@ios_arm64`( defaultStatus = enabled ),
	`library-single_source@ios_x64`( defaultStatus = enabled ),
	`library-single_source@js`( defaultStatus = enabled ),
	`library-single_source@jvm`( defaultStatus = enabled ),
	`library-single_source@linux_arm32_hfp`( defaultStatus = disabled ),
	`library-single_source@linux_mips32`( defaultStatus = disabled ),
	`library-single_source@linux_mipsel32`( defaultStatus = disabled ),
	`library-single_source@linux_x64`( defaultStatus = disabled ),
	`library-single_source@macos_x64`( defaultStatus = disabled ),
	`library-single_source@mingw_x64`( defaultStatus = disabled ),
	`library-single_source@mingw_x86`( defaultStatus = disabled ),
	`library-single_source@tvos_arm64`( defaultStatus = disabled ),
	`library-single_source@tvos_x64`( defaultStatus = disabled ),
	`library-single_source@wasm32`( defaultStatus = enabled ),
	`library-single_source@watchos_arm32`( defaultStatus = disabled ),
	`library-single_source@watchos_arm64`( defaultStatus = disabled ),
	`library-single_source@watchos_x64`( defaultStatus = disabled ),
	`library-single_source@watchos_x86`( defaultStatus = disabled ),

	`application-backend-js-express@js`,
	`application-backend-jvm-spring_boot@jvm`( defaultStatus = enabled ),
	`application-browser-js-spa-react@js`( defaultStatus = enabled ),
	`application-browser-js-vanilla@js`( defaultStatus = enabled ),
	`application-browser-native-wasm32@wasm32`( defaultStatus = enabled ),
	`application-desktop-jvm-tornado_fx@jvm`( defaultStatus = enabled ),
	`application-mobile-jvm-android@android`( defaultStatus = enabled ),
	`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64`( defaultStatus = enabled ),
	`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64`( defaultStatus = enabled ),
	`application-mobile-native-apple-ios-ios_x64_framework@ios_x64`( defaultStatus = enabled ),
	`application-mobile-native-apple-ios-ios_x64_with_framework@ios_x64`( defaultStatus = enabled ),
	`application-script-jvm-script@jvm`( defaultStatus = enabled ),
	`application-television-native-apple-tvos-tvos_x64@tvos_x64`,
	`application-terminal-jvm-terminal@jvm`( defaultStatus = enabled ),
	`application-watch-native-apple-watchos-watchos_x64@watchos_x64`,
	;

	/**
	 *
	 */
	var status: StatusEnum = defaultStatus
		set(value) {
			if (value == enabled && !isSupportedByOs) {
				Util.logger.warn("Not enabling target ${this.name} since it is not supported by this OS.")

				return
			}

			if (field != value) {
				val caller = Thread.currentThread().stackTrace[2]
				println("Status updated to ${value}. Target ${this.name}. ${caller.className}#${caller.methodName}:${caller.lineNumber}")

				field = value
			}
		}

	var isSupportedByOs : Boolean

	/**
	 *
	 */
	init {
		val splitName = name.split("@")

		if (kotlinId == null) kotlinId = splitName[1].split("_").joinToString("") { it.capitalize() }.decapitalize()

//		if (kotlinId == null) kotlinId = name.split("[@_-]".toRegex()).joinToString("") { it.capitalize() }.decapitalize()

		println("""Target "$name", kotlinId "$kotlinId".""")

		if (title == null) title = name.replace("_", " ").replace("[-@]".toRegex(), " -> ").
			split(" ".toRegex()).joinToString(" ") { it.capitalize() }

		if (description == null) description = "$title target."

		if (module == null) module = ModuleEnum.getByName(splitName[0])

		if (module != null) module!!.targets.add(this)

		if (preset == null) preset = PresetEnum.getByName(splitName[1])

		if (preset == null) throw NoSuchFieldException("Preset not properly initialized.")

		isSupportedByOs = preset!!.isSupportedByOs

		maintainEnabledIfOSSupportsOrDisableOtherwise()

//		attributes.add(
//			Pair(
//				Attribute.of(String::class.java),
//				id!!
//			)
//		)
	}

	/**
	 *
	 */
	companion object {

		/**
		 *
		 */
		fun getByName(name: String?): TargetEnum? {
			if (name == null) return null

			for (item in values()) {
				if (item.name == name) {
					return item
				}
			}

			return null
		}

		/**
		 *
		 */
		fun getByKotlinIdAndModule(kotlinId: String?, module: ModuleEnum): TargetEnum? {
			if (kotlinId == null) return null

			for (item in values().filter { it.module == module }) {
				if (item.kotlinId == kotlinId) {
					return item
				}
			}

			return null
		}
	}

	/**
	 *
	 */
	fun maintainEnabledIfOSSupportsOrDisableOtherwise() {
		if (!isSupportedByOs) {
			status = disabled
		}
	}

	/**
	 *
	 */
	override fun toString(): String {
		return "TargetEnum(" +
			"name=$name, " +
			"kotlinId=$kotlinId, " +
			"title=$title, " +
			"description=$description, " +
			"module=${module?.name}, " +
			"preset=$preset, " +
			"status=$status, " +
			"sourceSets=${sourceSets.joinToString { it.name }}, " +
			"attributes=${attributes.joinToString{ "${it.first}:${it.second}"}}, " +
			"kotlinTarget=$kotlinTarget" +
			")"
	}
}
