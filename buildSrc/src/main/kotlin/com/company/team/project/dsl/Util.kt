package com.company.team.project.dsl

import org.gradle.api.Project
import java.util.*

/**
 *
 */
object Util {

	/**
	 *
	 */
	val os by lazy {
		org.gradle.internal.os.OperatingSystem.current()!!
	}

	val kotlinVersion = "1.3.30-eap-11"

	val kotlinNativeVersion = "1.1.2"

	val springBootVersion = "2.1.2.RELEASE"

	val androidToolsVersion = "3.3.1"

	val frontendVersion = "0.0.45"

	val group = "com.company.team.project"

	/**
	 *
	 */
	var systemProperties: Properties = Properties()

	/**
	 *
	 */
	val localPropertiesPath = "local.properties"

	/**
	 *
	 */
	val localProperties by lazy {
		val properties = Properties()

		if (rootProject!!.file(localPropertiesPath).canRead()) {
			properties.load(java.io.FileInputStream(rootProject!!.file(localPropertiesPath)))
		}

		properties
	}

	/**
	 *
	 * This property is defined in the build.gradle.kts of the root project.
	 *
	 */
	var rootProject: Project? = null

	/**
	 *
	 */
	fun dump(target: Any?) {
		println("Dumping: ${target.toString()}")
	}
}
