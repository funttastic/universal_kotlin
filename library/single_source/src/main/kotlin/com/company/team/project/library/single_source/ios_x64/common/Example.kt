package com.company.team.project.library.single_source.ios_x64.common

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
	private const val exampleProperty = "com.company.team.project.library.single_source.linux_arm32_hfp.common"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.common.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.common.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
