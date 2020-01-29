package com.company.team.project.dsl.model.enum_

import com.company.team.project.dsl.model.Properties
import org.gradle.api.attributes.Attribute
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget

/**
 *
 */
enum class TargetEnum(

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
	var defaultStatus: StatusEnum = StatusEnum.enabled,

	/**
	 *
	 */
	var status: StatusEnum = defaultStatus,

	/**
	 *
	 */
	var sourceSets: MutableList<SourceSetEnum> = mutableListOf(),

	/**
	 *
	 */
	var attributes: MutableList<Pair<Attribute<String>, String>> = mutableListOf(),

	/**
	 *
	 */
	var kotlinId: String? = null,

	/**
	 *
	 */
	var kotlinTarget: KotlinTarget? = null,

	/**
	 *
	 */
	var requiredAt: MutableList<SourceSetEnum> = mutableListOf()
) {

	`common-multiple_sources@android_native_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@android_native_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@ios_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@ios_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@ios_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`common-multiple_sources@js`(
		defaultStatus = StatusEnum.enabled
	),
	`common-multiple_sources@jvm`(
		defaultStatus = StatusEnum.enabled
	),
	`common-multiple_sources@linux_arm32_hfp`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@linux_mips32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@linux_mipsel32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@linux_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@macos_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`common-multiple_sources@mingw_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@mingw_x86`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@tvos_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@tvos_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@wasm32`(
		defaultStatus = StatusEnum.enabled
	),
	`common-multiple_sources@watchos_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@watchos_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@watchos_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@watchos_x86`(
		defaultStatus = StatusEnum.disabled
	),

	`common-multiple_sources@ios_x64@mobile-native-ios_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@js@browser`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@js@browser-spa`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@js@browser-spa-react`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@js@browser-vanilla`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@backend`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@backend-spring_boot`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@desktop`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@desktop-tornado_fx`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@mobile`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@mobile-android`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@script`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@terminal`(
		defaultStatus = StatusEnum.disabled
	),
	`common-multiple_sources@wasm32@browser-native-wasm32`(
		defaultStatus = StatusEnum.disabled
	),


	`common-single_source@android_native_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@android_native_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@ios_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@ios_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@ios_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`common-single_source@js`(
		defaultStatus = StatusEnum.enabled
	),
	`common-single_source@jvm`(
		defaultStatus = StatusEnum.enabled
	),
	`common-single_source@linux_arm32_hfp`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@linux_mips32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@linux_mipsel32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@linux_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@macos_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`common-single_source@mingw_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@mingw_x86`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@tvos_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@tvos_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@wasm32`(
		defaultStatus = StatusEnum.enabled
	),
	`common-single_source@watchos_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@watchos_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@watchos_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@watchos_x86`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@ios_x64@mobile-native-ios_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@js@browser`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@js@browser-spa`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@js@browser-spa-react`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@js@browser-vanilla`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@jvm@backend`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@jvm@backend-spring_boot`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@jvm@desktop`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@jvm@desktop-tornado_fx`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@jvm@mobile`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@jvm@mobile-android`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@jvm@script`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@jvm@terminal`(
		defaultStatus = StatusEnum.disabled
	),
	`common-single_source@wasm32@browser-native-wasm32`(
		defaultStatus = StatusEnum.disabled
	),


	`library-multiple_sources@android_native_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@android_native_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@ios_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@ios_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@ios_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`library-multiple_sources@js`(
		defaultStatus = StatusEnum.enabled
	),
	`library-multiple_sources@jvm`(
		defaultStatus = StatusEnum.enabled
	),
	`library-multiple_sources@linux_arm32_hfp`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@linux_mips32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@linux_mipsel32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@linux_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@macos_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`library-multiple_sources@mingw_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@mingw_x86`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@tvos_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@tvos_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@wasm32`(
		defaultStatus = StatusEnum.enabled
	),
	`library-multiple_sources@watchos_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@watchos_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@watchos_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-multiple_sources@watchos_x86`(
		defaultStatus = StatusEnum.disabled
	),


	`library-single_source@android_native_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@android_native_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@ios_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@ios_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@ios_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`library-single_source@js`(
		defaultStatus = StatusEnum.enabled
	),
	`library-single_source@jvm`(
		defaultStatus = StatusEnum.enabled
	),
	`library-single_source@linux_arm32_hfp`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@linux_mips32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@linux_mipsel32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@linux_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@macos_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`library-single_source@mingw_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@mingw_x86`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@tvos_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@tvos_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@wasm32`(
		defaultStatus = StatusEnum.enabled
	),
	`library-single_source@watchos_arm32`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@watchos_arm64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@watchos_x64`(
		defaultStatus = StatusEnum.disabled
	),
	`library-single_source@watchos_x86`(
		defaultStatus = StatusEnum.disabled
	),



	`application-backend-js-express@js`(
		defaultStatus = StatusEnum.enabled
	),
	`application-backend-jvm-spring_boot@jvm`(
		defaultStatus = StatusEnum.enabled
	),
	`application-browser-js-spa-react@js`(
		defaultStatus = StatusEnum.enabled
	),
	`application-browser-js-vanilla@js`(
		defaultStatus = StatusEnum.enabled
	),
	`application-browser-native-wasm32@wasm32`(
		defaultStatus = StatusEnum.enabled
	),
	`application-desktop-jvm-tornado_fx@jvm`(
		defaultStatus = StatusEnum.enabled
	),
	`application-mobile-jvm-android@android`(
		defaultStatus = StatusEnum.enabled,
		kotlinId = "android"
	),
	`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`application-mobile-native-apple-ios-ios_x64_framework@ios_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`application-mobile-native-apple-ios-ios_x64_with_framework@ios_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`application-script-jvm-script@jvm`(
		defaultStatus = StatusEnum.enabled
	),
	`application-television-native-apple-tvos-tvos_x64@tvos_x64`(
		defaultStatus = StatusEnum.enabled
	),
	`application-terminal-jvm-terminal@jvm`(
		defaultStatus = StatusEnum.enabled
	),
	`application-watch-native-apple-watchos-watchos_x64@watchos_x64`(
		defaultStatus = StatusEnum.enabled
	),
	;

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

		if (StatusEnum.enabled == status) {
			enableIfOSSupportsOrDisableOtherwise()
		}

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
	fun enableIfOSSupportsOrDisableOtherwise(): Boolean {
		if (preset?.supportedOSes?.contains(Properties.util.os) == true) {
			status = StatusEnum.enabled

			return true
		}

//		status = StatusEnum.disabled

		return false
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
