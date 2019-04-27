package com.company.team.project.library.multiple_sources.common

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
	private const val exampleProperty = "com.company.team.project.common.multiple_sources.common"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.common.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}

//fun getPackage(`class`: KClass<*>): String? = `class`.qualifiedName?.replace(".${`class`.simpleName}", "")
