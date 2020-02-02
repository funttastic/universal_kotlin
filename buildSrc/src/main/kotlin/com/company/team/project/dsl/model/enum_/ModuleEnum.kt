package com.company.team.project.dsl.model.enum_

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.enum_.StatusEnum.enabled
import com.company.team.project.dsl.model.enum_.StatusEnum.disabled

/**
 *
 */
enum class ModuleEnum(

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
	var parent: ModuleEnum? = null,

	/**
	 *
	 */
	var group: String? = null,

	/**
	 *
	 */
	var artifact: String? = null,

	/**
	 *
	 */
	var version: String? = null,

	/**
	 *
	 */
	var fullIdentifier: String? = null,

	/**
	 *
	 */
	var defaultStatus: StatusEnum = disabled,

	/**
	 *
	 */
	var path: Path? = null,

	/**
	 *
	 */
	var file: File? = null,

	/**
	 *
	 */
	var absolutePath: String? = null,

	/**
	 *
	 */
	var relativePath: String? = null,

	/**
	 *
	 */
	val targets: MutableSet<TargetEnum> = mutableSetOf(),

	/**
	 *
	 */
	val sourceSets: MutableSet<SourceSetEnum> = mutableSetOf(),

	/**
	 *
	 */
	val children: MutableSet<ModuleEnum> = mutableSetOf(),

	/**
	 *
	 */
	val requiredAt: MutableSet<SourceSetEnum> = mutableSetOf()
) {

	root(
		kotlinId = "",
		path = Properties.projects.root.path,
		file = Properties.projects.root.file,
		absolutePath = Properties.projects.root.absolutePath
	),
	common(
		parent = root
	),
	`common-multiple_modules`(
		parent = common
	),
	`common-multiple_sources`(
		parent = common,
		defaultStatus = enabled
	),
	`common-single_source`(
		parent = common,
		defaultStatus = enabled
	),
	library(
		parent = root
	),
	`library-multiple_modules`(
		parent = library
	),
	`library-multiple_sources`(
		parent = library,
		defaultStatus = enabled
	),
	`library-single_source`(
		parent = library,
		defaultStatus = enabled
	),
	application(
		parent = root
	),
	`application-backend`(
		parent = application
	),
	`application-backend-js`(
		parent = `application-backend`
	),
	`application-backend-js-express`(
		parent = `application-backend-js`
	),
	`application-backend-jvm`(
		parent = `application-backend`
	),
	`application-backend-jvm-spring_boot`(
		parent = `application-backend-jvm`,
		defaultStatus = enabled
	),
	`application-browser`(
		parent = application
	),
	`application-browser-js`(
		parent = `application-browser`
	),
	`application-browser-js-spa`(
		parent = `application-browser-js`
	),
	`application-browser-js-spa-react`(
		parent = `application-browser-js-spa`,
		defaultStatus = enabled
	),
	`application-browser-js-vanilla`(
		parent = `application-browser-js`,
		defaultStatus = enabled
	),
	`application-browser-native`(
		parent = `application-browser`
	),
	`application-browser-native-wasm32`(
		parent = `application-browser-native`,
		defaultStatus = enabled
	),
	`application-desktop`(
		parent = application
	),
	`application-desktop-jvm`(
		parent = `application-desktop`
	),
	`application-desktop-jvm-tornado_fx`(
		parent = `application-desktop-jvm`,
		defaultStatus = enabled
	),
	`application-mobile`(
		parent = application
	),
	`application-mobile-jvm`(
		parent = `application-mobile`
	),
	`application-mobile-jvm-android`(
		parent = `application-mobile-jvm`,
		defaultStatus = enabled
	),
	`application-mobile-native`(
		parent = `application-mobile`
	),
	`application-mobile-native-apple`(
		parent = `application-mobile-native`
	),
	`application-mobile-native-apple-ios`(
		parent = `application-mobile-native-apple`
	),
	`application-mobile-native-apple-ios-ios_x64_without_framework`(
		parent = `application-mobile-native-apple-ios`,
		defaultStatus = enabled,
		file = Paths.get(
			Properties.projects.root.absolutePath!!,
			"application/mobile/native/apple/ios/ios_x64_without_framework/WithoutFramework"
		).toFile()
	),
	`application-mobile-native-apple-ios-ios_x64_copying_framework`(
		parent = `application-mobile-native-apple-ios`,
		defaultStatus = enabled
	),
	`application-mobile-native-apple-ios-ios_x64_framework`(
		parent = `application-mobile-native-apple-ios`,
		defaultStatus = enabled,
		file = Paths.get(
			Properties.projects.root.absolutePath!!,
			"application/mobile/native/apple/ios/ios_x64_framework/Framework"
		).toFile()
	),
	`application-mobile-native-apple-ios-ios_x64_with_framework`(
		parent = `application-mobile-native-apple-ios`,
		defaultStatus = enabled,
		file = Paths.get(
			Properties.projects.root.absolutePath!!,
			"application/mobile/native/apple/ios/ios_x64_with_framework/UniversalKotlin"
		).toFile()
	),
	`application-script`(
		parent = application
	),
	`application-script-jvm`(
		parent = `application-script`
	),
	`application-script-jvm-script`(
		parent = `application-script-jvm`,
		defaultStatus = enabled
	),
	`application-television`(
		parent = application
	),
	`application-television-native`(
		parent = `application-television`
	),
	`application-television-native-apple`(
		parent = `application-television-native`
	),
	`application-television-native-apple-tvos`(
		parent = `application-television-native-apple`
	),
	`application-television-native-apple-tvos-tvos_x64`(
		parent = `application-television-native-apple-tvos`,
		file = Paths.get(
			Properties.projects.root.absolutePath!!,
			"application/television/native/apple/tvos/tvos_x64/application"
		).toFile()
	),
	`application-terminal`(
		parent = application
	),
	`application-terminal-jvm`(
		parent = `application-terminal`
	),
	`application-terminal-jvm-terminal`(
		parent = `application-terminal-jvm`,
		defaultStatus = enabled
	),
	`application-watch`(
		parent = application
	),
	`application-watch-native`(
		parent = `application-watch`
	),
	`application-watch-native-apple`(
		parent = `application-watch-native`
	),
	`application-watch-native-apple-watchos`(
		parent = `application-watch-native-apple`
	),
	`application-watch-native-apple-watchos-watchos_x64`(
		parent = `application-watch-native-apple-watchos`,
		file = Paths.get(
			Properties.projects.root.absolutePath!!,
			"application/television/native/apple/watchos/watchos_x64/application"
		).toFile()
	),
	`plugin`(
		parent = root
	),
	`plugin-jvm`(
		parent = `plugin`
	),
	`plugin-jvm-gradle`(
		parent = `plugin-jvm`
	),
	;

	/**
	 *
	 */
	var status: StatusEnum = disabled
		set(value) {
			val caller = Thread.currentThread().stackTrace[2]
			println("Status updated to ${value}. Module ${this.name}. ${caller.className}#${caller.methodName}:${caller.lineNumber}")
			field = value
		}

	/**
	 *
	 */
	init {
//		val splitName = name.split("-")

		if (kotlinId == null) {
			kotlinId = name

//			kotlinId = when {
//				parent == null -> ""
//				splitName.size == 1 -> name
//				else -> parent?.kotlinId?.plus(":").plus(name)
//			}
		}

		println("""Module "$name", kotlinId "$kotlinId".""")

		if (title == null) title = name.replace("_", " ").replace("-", " -> ").
			split(" ".toRegex()).joinToString(" ") { it.capitalize() }

		if (description == null) description = "$title module."

		if (group == null) group = Properties.general.group

		if (artifact == null) artifact = name

		if (version == null) version = Properties.general.version

		if (fullIdentifier == null) fullIdentifier = "$group:$artifact:$version"

		if (file == null) {
			file = Paths.get(
				Properties.projects.root.absolutePath!!,
				name.replace("-", "/")
			).toFile()
		}

		if (absolutePath == null) absolutePath = file?.absolutePath

		if (relativePath == null && absolutePath != null) relativePath = Util.relativePathFromRoot(absolutePath!!)

		if (path == null) path = Paths.get(relativePath)

		if (parent != null) parent!!.children.add(this)

		status = defaultStatus
	}

	/**
	 *
	 */
	companion object {

		/**
		 *
		 */
		fun getByName(name: String?): ModuleEnum? {
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
		fun getByFile(file: File?): ModuleEnum? {
			if (file == null) return null

			for (item in values()) {
				if (item.absolutePath == file.absolutePath) {
					return item
				}
			}

			return null
		}
	}

	/**
	 * TODO Improve toString with Jackson to show the information as a Json. It is needed to handle infinite recursions.
	 */
	override fun toString(): String {
		return "ModuleEnum(" +
			"name=$name, " +
			"kotlinId=$kotlinId, " +
			"title=$title, " +
			"description=$description, " +
			"parent=${parent?.name}, " +
			"group=$group, " +
			"artifact=$artifact, " +
			"version=$version, " +
			"status=$status, " +
			"path=$path, " +
			"targets=${targets.joinToString { it.name }}, " +
			"sourceSets=${sourceSets.joinToString { it.name }}, " +
			"children=${children.joinToString { it.name }}" +
			")"
	}
}
