package com.company.team.project.library.multiple_sources.common

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
	private const val exampleProperty = "com.company.team.project.library.multiple_sources.common"

	/**
	 *
	 */
	fun exampleMethod(): Set<String> {
		val output = mutableSetOf<String>()

		output.addAll(com.company.team.project.common.multiple_sources.common.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}

//fun getPackage(`class`: KClass<*>): String? = `class`.qualifiedName?.replace(".${`class`.simpleName}", "")
