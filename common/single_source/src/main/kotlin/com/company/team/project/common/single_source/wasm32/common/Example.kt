package com.company.team.project.common.single_source.wasm32.common

import com.company.team.project.common.single_source.common.formatOutput

/**
 *
 */
val exampleValue = formatOutput(exampleFunction())

/**
 *
 */
fun exampleFunction(): Set<String> {
	return ExampleObject.exampleMethod()
}

/**
 *
 */
object ExampleObject {

	/**
	 *
	 */
	private const val exampleProperty = "com.company.team.project.common.single_source.wasm32.common"

	/**
	 *
	 */
	fun exampleMethod(): Set<String> {
		val output = mutableSetOf<String>()

		output.addAll(com.company.team.project.common.single_source.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
