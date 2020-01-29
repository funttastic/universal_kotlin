package com.company.team.project.application.backend.jvm.spring_boot.model

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
	private val exampleProperty = "com.company.team.project.application.backend.jvm.spring_boot"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.jvm.common.exampleFunction())
		output.addAll(com.company.team.project.library.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
