package com.company.team.project.plugin.jvm.gradle

import org.gradle.api.Project
import org.gradle.api.Plugin as GradlePlugin
import com.company.team.project.common.single_source.common.formatOutput

/**
 *
 */
val exampleValue = formatOutput(exampleFunction())

/**
 *
 */
fun exampleFunction(): List<String> {
	return ExampleObject.exampleMethod()
}

/**
 *
 */
object ExampleObject {

	/**
	 *
	 */
	private val exampleProperty = "com.company.team.project.plugin.jvm.gradle"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.add(exampleProperty)

		return output
	}
}

/**
 *
 */
open class PluginExtension(private val project: Project) {
}

/**
 *
 */
open class Plugin : GradlePlugin<Project> {

	/**
	 *
	 */
	override fun apply(project: Project) {
		// TODO Fix
		project.extensions.create("plugin", PluginExtension::class.java, project)
	}
}
