package com.company.team.project.common.single_source.common

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
	private const val exampleProperty = "com.company.team.project.common.single_source.common"

	/**
	 *
	 */
	fun exampleMethod(): Set<String> {
		val output = mutableSetOf<String>()

		output.add(exampleProperty)

		return output
	}
}
