package com.company.team.project.common.single_source.jvm.common

import java.util.ArrayList
import com.company.team.project.common.single_source.common.formatOuput

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
	private const val exampleProperty = "com.company.team.project.common.single_source.jvm.common"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.single_source.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
