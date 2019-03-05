package com.company.team.project.application.js.vanilla

import kotlin.browser.document

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
val exampleValue = exampleFunction().toString()

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
	private const val exampleProperty = "com.company.team.project.application.js.vanilla"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.single_source_set.js.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
