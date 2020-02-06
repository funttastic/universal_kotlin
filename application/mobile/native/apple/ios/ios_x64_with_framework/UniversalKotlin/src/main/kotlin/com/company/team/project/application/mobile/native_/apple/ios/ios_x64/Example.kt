package com.company.team.project.application.mobile.native_.apple.ios.ios_x64

import com.company.team.project.common.single_source.common.formatOutput

/**
 *
 */
fun main() {
	println(exampleValue)
}

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
	val exampleProperty = "com.company.team.project.application.mobile.native_.apple.ios.ios_x64"

	/**
	 *
	 */
	fun exampleMethod(): Set<String> {
		val output = mutableSetOf<String>()

		output.addAll(com.company.team.project.common.multiple_sources.ios_x64.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.ios_x64.common.exampleFunction())
		output.addAll(com.company.team.project.library.multiple_sources.ios_x64.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.ios_x64.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
