package com.company.team.project.dsl.model.enum_

import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.Properties.util.os
import org.gradle.api.attributes.Attribute
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import com.company.team.project.dsl.model.enum_.StatusEnum.enabled
import com.company.team.project.dsl.model.enum_.StatusEnum.disabled

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

	`common-multiple_sources@android_native_arm32`,
	`common-multiple_sources@android_native_arm64`,
	`common-multiple_sources@ios_arm32`,
	`common-multiple_sources@ios_arm64`,
	`common-multiple_sources@ios_x64`,
	`common-multiple_sources@js`,
	`common-multiple_sources@jvm`,
	`common-multiple_sources@linux_arm32_hfp`,
	`common-multiple_sources@linux_mips32`,
	`common-multiple_sources@linux_mipsel32`,
	`common-multiple_sources@linux_x64`,
	`common-multiple_sources@macos_x64`,
	`common-multiple_sources@mingw_x64`,
	`common-multiple_sources@mingw_x86`,
	`common-multiple_sources@tvos_arm64`,
	`common-multiple_sources@tvos_x64`,
	`common-multiple_sources@wasm32`,
	`common-multiple_sources@watchos_arm32`,
	`common-multiple_sources@watchos_arm64`,
	`common-multiple_sources@watchos_x64`,
	`common-multiple_sources@watchos_x86`,

	`common-multiple_sources@ios_x64@mobile-native-ios_x64`,
	`common-multiple_sources@js@browser`,
	`common-multiple_sources@js@browser-spa`,
	`common-multiple_sources@js@browser-spa-react`,
	`common-multiple_sources@js@browser-vanilla`,
	`common-multiple_sources@jvm@backend`,
	`common-multiple_sources@jvm@backend-spring_boot`,
	`common-multiple_sources@jvm@desktop`,
	`common-multiple_sources@jvm@desktop-tornado_fx`,
	`common-multiple_sources@jvm@mobile`,
	`common-multiple_sources@jvm@mobile-android`,
	`common-multiple_sources@jvm@script`,
	`common-multiple_sources@jvm@terminal`,
	`common-multiple_sources@wasm32@browser-native-wasm32`,


	`common-single_source@android_native_arm32`,
	`common-single_source@android_native_arm64`,
	`common-single_source@ios_arm32`,
	`common-single_source@ios_arm64`,
	`common-single_source@ios_x64`,
	`common-single_source@js`,
	`common-single_source@jvm`,
	`common-single_source@linux_arm32_hfp`,
	`common-single_source@linux_mips32`,
	`common-single_source@linux_mipsel32`,
	`common-single_source@linux_x64`,
	`common-single_source@macos_x64`,
	`common-single_source@mingw_x64`,
	`common-single_source@mingw_x86`,
	`common-single_source@tvos_arm64`,
	`common-single_source@tvos_x64`,
	`common-single_source@wasm32`,
	`common-single_source@watchos_arm32`,
	`common-single_source@watchos_arm64`,
	`common-single_source@watchos_x64`,
	`common-single_source@watchos_x86`,
	`common-single_source@ios_x64@mobile-native-ios_x64`,
	`common-single_source@js@browser`,
	`common-single_source@js@browser-spa`,
	`common-single_source@js@browser-spa-react`,
	`common-single_source@js@browser-vanilla`,
	`common-single_source@jvm@backend`,
	`common-single_source@jvm@backend-spring_boot`,
	`common-single_source@jvm@desktop`,
	`common-single_source@jvm@desktop-tornado_fx`,
	`common-single_source@jvm@mobile`,
	`common-single_source@jvm@mobile-android`,
	`common-single_source@jvm@script`,
	`common-single_source@jvm@terminal`,
	`common-single_source@wasm32@browser-native-wasm32`,


	`library-multiple_sources@android_native_arm32`,
	`library-multiple_sources@android_native_arm64`,
	`library-multiple_sources@ios_arm32`,
	`library-multiple_sources@ios_arm64`,
	`library-multiple_sources@ios_x64`,
	`library-multiple_sources@js`,
	`library-multiple_sources@jvm`,
	`library-multiple_sources@linux_arm32_hfp`,
	`library-multiple_sources@linux_mips32`,
	`library-multiple_sources@linux_mipsel32`,
	`library-multiple_sources@linux_x64`,
	`library-multiple_sources@macos_x64`,
	`library-multiple_sources@mingw_x64`,
	`library-multiple_sources@mingw_x86`,
	`library-multiple_sources@tvos_arm64`,
	`library-multiple_sources@tvos_x64`,
	`library-multiple_sources@wasm32`,
	`library-multiple_sources@watchos_arm32`,
	`library-multiple_sources@watchos_arm64`,
	`library-multiple_sources@watchos_x64`,
	`library-multiple_sources@watchos_x86`,


	`library-single_source@android_native_arm32`,
	`library-single_source@android_native_arm64`,
	`library-single_source@ios_arm32`,
	`library-single_source@ios_arm64`,
	`library-single_source@ios_x64`,
	`library-single_source@js`,
	`library-single_source@jvm`,
	`library-single_source@linux_arm32_hfp`,
	`library-single_source@linux_mips32`,
	`library-single_source@linux_mipsel32`,
	`library-single_source@linux_x64`,
	`library-single_source@macos_x64`,
	`library-single_source@mingw_x64`,
	`library-single_source@mingw_x86`,
	`library-single_source@tvos_arm64`,
	`library-single_source@tvos_x64`,
	`library-single_source@wasm32`,
	`library-single_source@watchos_arm32`,
	`library-single_source@watchos_arm64`,
	`library-single_source@watchos_x64`,
	`library-single_source@watchos_x86`,



	`application-backend-js-express@js`,
	`application-backend-jvm-spring_boot@jvm`,
	`application-browser-js-spa-react@js`,
	`application-browser-js-vanilla@js`,
	`application-browser-native-wasm32@wasm32`,
	`application-desktop-jvm-tornado_fx@jvm`,
	`application-mobile-jvm-android@android`,
	`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64`,
	`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64`,
	`application-mobile-native-apple-ios-ios_x64_framework@ios_x64`,
	`application-mobile-native-apple-ios-ios_x64_with_framework@ios_x64`,
	`application-script-jvm-script@jvm`,
	`application-television-native-apple-tvos-tvos_x64@tvos_x64`,
	`application-terminal-jvm-terminal@jvm`,
	`application-watch-native-apple-watchos-watchos_x64@watchos_x64`,
	;

	/**
	 *
	 */
	var status: StatusEnum = disabled
		set(value) {
			val caller = Thread.currentThread().stackTrace[2]
			println("Status updated to ${value}. Target ${this.name}. ${caller.className}#${caller.methodName}:${caller.lineNumber}")
			field = value
		}

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

		status = defaultStatus

		maintainEnabledIfOSSupportsOrDisableOtherwise()

//		attributes.add(
//			Pair(
//				Attribute.of(String::class.java),
//				id!!
//			)
//		)
	}

	val isSupportedByOs by lazy { preset!!.isSupportedByOs }

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
	fun enableEnabledIfOSSupportsOrDisableOtherwise() {
		if (
			status != enabled
			&& isSupportedByOs
		) {
			status = enabled
		}
	}

	/**
	 *
	 */
	fun maintainEnabledIfOSSupportsOrDisableOtherwise() {
		if (status != enabled) return

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
