package com.company.team.project.common.multiple_sources.android_native_arm32

import com.company.team.project.common.multiple_sources.common.formatOutput

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
	private const val exampleProperty = "com.company.team.project.common.multiple_sources.android_native_arm32"

	/**
	 *
	 */
	fun exampleMethod(): Set<String> {
		val output = mutableSetOf<String>()

		output.addAll(com.company.team.project.common.multiple_sources.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
