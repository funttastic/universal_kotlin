package com.company.team.project.plugin.maestro

import org.gradle.api.Project
import org.gradle.api.Plugin as GradlePlugin

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
		project.extensions.create("maestro", PluginExtension::class.java, project)
	}
}
