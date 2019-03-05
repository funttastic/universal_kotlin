package com.company.team.project.application.backend.jvm.spring_boot.model

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
	private val exampleProperty = "com.company.team.project.application.backend.jvm.spring_boot"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.single_source_set.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
