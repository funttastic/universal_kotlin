package com.company.team.project.library.single_source.mingw_x64.common

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
	private const val exampleProperty = "com.company.team.project.library.single_source.mingw_x64.common"

	/**
	 *
	 */
	fun exampleMethod(): Set<String> {
		val output = mutableSetOf<String>()

		output.addAll(com.company.team.project.common.multiple_sources.common.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.common.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
