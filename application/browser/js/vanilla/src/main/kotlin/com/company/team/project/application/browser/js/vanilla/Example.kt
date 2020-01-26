package com.company.team.project.application.browser.js.vanilla

import kotlin.browser.document
import com.company.team.project.common.single_source.common.formatOuput

/**
 *
 */
fun main() {
	updateTargetContent()
}

/**
 *
 */
@JsName("updateTargetContent")
fun updateTargetContent() {
	document.getElementById("target")?.textContent = exampleValue
}

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
	private const val exampleProperty = "com.company.team.project.application.browser.js.vanilla"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.js.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.js.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
