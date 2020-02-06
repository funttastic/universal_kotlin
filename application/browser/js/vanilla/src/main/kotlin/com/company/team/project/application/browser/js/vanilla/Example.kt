package com.company.team.project.application.browser.js.vanilla

import kotlin.browser.document
import org.w3c.dom.*
import com.company.team.project.common.single_source.common.formatOutput
import com.company.team.project.common.single_source.common.OutputType.BROWSER

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
	document.getElementById("target")?.innerHTML = exampleValue
}

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
	private const val exampleProperty = "com.company.team.project.application.browser.js.vanilla"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.js.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.js.common.exampleFunction())
		output.addAll(com.company.team.project.library.multiple_sources.js.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.js.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
