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
	var status: StatusEnum = StatusEnum.enabled,

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
		status = StatusEnum.disabled
	),
	`common-multiple_sources@android_native_arm64`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@ios_arm32`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@ios_arm64`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@ios_x64`(
		status = StatusEnum.enabled
	),
	`common-multiple_sources@js`(
		status = StatusEnum.enabled
	),
	`common-multiple_sources@jvm`(
		status = StatusEnum.enabled
	),
	`common-multiple_sources@linux_arm32_hfp`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@linux_mips32`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@linux_mipsel32`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@linux_x64`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@macos_x64`(
		status = StatusEnum.enabled
	),
	`common-multiple_sources@mingw_x64`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@wasm32`(
		status = StatusEnum.enabled
	),

	`common-multiple_sources@ios_x64@mobile-native-ios_x64`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@js@browser`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@js@browser-spa`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@js@browser-spa-react`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@js@browser-vanilla`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@backend`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@backend-spring_boot`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@desktop`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@desktop-tornado_fx`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@mobile`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@mobile-android`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@script`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@jvm@terminal`(
		status = StatusEnum.disabled
	),
	`common-multiple_sources@wasm32@browser-native-wasm32`(
		status = StatusEnum.disabled
	),


	`common-single_source@android_native_arm32`(
		status = StatusEnum.disabled
	),
	`common-single_source@android_native_arm64`(
		status = StatusEnum.disabled
	),
	`common-single_source@ios_arm32`(
		status = StatusEnum.disabled
	),
	`common-single_source@ios_arm64`(
		status = StatusEnum.disabled
	),
	`common-single_source@ios_x64`(
		status = StatusEnum.enabled
	),
	`common-single_source@js`(
		status = StatusEnum.enabled
	),
	`common-single_source@jvm`(
		status = StatusEnum.enabled
	),
	`common-single_source@linux_arm32_hfp`(
		status = StatusEnum.disabled
	),
	`common-single_source@linux_mips32`(
		status = StatusEnum.disabled
	),
	`common-single_source@linux_mipsel32`(
		status = StatusEnum.disabled
	),
	`common-single_source@linux_x64`(
		status = StatusEnum.disabled
	),
	`common-single_source@macos_x64`(
		status = StatusEnum.enabled
	),
	`common-single_source@mingw_x64`(
		status = StatusEnum.disabled
	),
	`common-single_source@wasm32`(
		status = StatusEnum.enabled
	),

	`common-single_source@ios_x64@mobile-native-ios_x64`(
		status = StatusEnum.disabled
	),
	`common-single_source@js@browser`(
		status = StatusEnum.disabled
	),
	`common-single_source@js@browser-spa`(
		status = StatusEnum.disabled
	),
	`common-single_source@js@browser-spa-react`(
		status = StatusEnum.disabled
	),
	`common-single_source@js@browser-vanilla`(
		status = StatusEnum.disabled
	),
	`common-single_source@jvm@backend`(
		status = StatusEnum.disabled
	),
	`common-single_source@jvm@backend-spring_boot`(
		status = StatusEnum.disabled
	),
	`common-single_source@jvm@desktop`(
		status = StatusEnum.disabled
	),
	`common-single_source@jvm@desktop-tornado_fx`(
		status = StatusEnum.disabled
	),
	`common-single_source@jvm@mobile`(
		status = StatusEnum.disabled
	),
	`common-single_source@jvm@mobile-android`(
		status = StatusEnum.disabled
	),
	`common-single_source@jvm@script`(
		status = StatusEnum.disabled
	),
	`common-single_source@jvm@terminal`(
		status = StatusEnum.disabled
	),
	`common-single_source@wasm32@browser-native-wasm32`(
		status = StatusEnum.disabled
	),


	`library-multiple_sources@android_native_arm32`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@android_native_arm64`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@ios_arm32`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@ios_arm64`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@ios_x64`(
		status = StatusEnum.enabled
	),
	`library-multiple_sources@js`(
		status = StatusEnum.enabled
	),
	`library-multiple_sources@jvm`(
		status = StatusEnum.enabled
	),
	`library-multiple_sources@linux_arm32_hfp`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@linux_mips32`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@linux_mipsel32`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@linux_x64`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@macos_x64`(
		status = StatusEnum.enabled
	),
	`library-multiple_sources@mingw_x64`(
		status = StatusEnum.disabled
	),
	`library-multiple_sources@wasm32`(
		status = StatusEnum.enabled
	),


	`library-single_source@android_native_arm32`(
		status = StatusEnum.disabled
	),
	`library-single_source@android_native_arm64`(
		status = StatusEnum.disabled
	),
	`library-single_source@ios_arm32`(
		status = StatusEnum.disabled
	),
	`library-single_source@ios_arm64`(
		status = StatusEnum.disabled
	),
	`library-single_source@ios_x64`(
		status = StatusEnum.enabled
	),
	`library-single_source@js`(
		status = StatusEnum.enabled
	),
	`library-single_source@jvm`(
		status = StatusEnum.enabled
	),
	`library-single_source@linux_arm32_hfp`(
		status = StatusEnum.disabled
	),
	`library-single_source@linux_mips32`(
		status = StatusEnum.disabled
	),
	`library-single_source@linux_mipsel32`(
		status = StatusEnum.disabled
	),
	`library-single_source@linux_x64`(
		status = StatusEnum.disabled
	),
	`library-single_source@macos_x64`(
		status = StatusEnum.enabled
	),
	`library-single_source@mingw_x64`(
		status = StatusEnum.disabled
	),
	`library-single_source@wasm32`(
		status = StatusEnum.enabled
	),



	`application-backend-jvm-spring_boot@jvm`(
		status = StatusEnum.enabled
	),
	`application-browser-js-spa-react@js`(
		status = StatusEnum.enabled
	),
	`application-browser-js-vanilla@js`(
		status = StatusEnum.enabled
	),
	`application-browser-native-wasm32@wasm32`(
		status = StatusEnum.enabled
	),
	`application-desktop-jvm-tornado_fx@jvm`(
		status = StatusEnum.enabled
	),
	`application-mobile-jvm-android@android`(
		status = StatusEnum.enabled,
		kotlinId = "android"
	),
	`application-mobile-native-apple-ios-ios_x64@ios_x64`(
		status = StatusEnum.enabled
	),
	`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64`(
		status = StatusEnum.enabled
	),
	`application-script-jvm-script@jvm`(
		status = StatusEnum.enabled
	),
	`application-terminal-jvm-terminal@jvm`(
		status = StatusEnum.enabled
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
