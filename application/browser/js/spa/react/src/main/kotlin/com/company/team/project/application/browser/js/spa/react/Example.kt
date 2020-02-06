package com.company.team.project.application.browser.js.spa.react

import com.company.team.project.common.single_source.common.formatOutput
import com.company.team.project.common.single_source.common.OutputType.BROWSER

/**
 *
 */
val exampleValue = formatOutput(exampleFunction(), BROWSER)

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
	private const val exampleProperty = "com.company.team.project.application.browser.js.spa.react"

	/**
	 *
	 */
	fun exampleMethod(): Set<String> {
		val output = mutableSetOf<String>()

		output.addAll(com.company.team.project.common.multiple_sources.js.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.js.common.exampleFunction())
		output.addAll(com.company.team.project.library.multiple_sources.js.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.js.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
