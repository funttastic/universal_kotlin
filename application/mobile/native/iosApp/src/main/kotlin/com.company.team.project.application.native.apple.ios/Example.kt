package com.company.team.project.application.native.apple.ios

/**
 *
 */
fun main() {
	println(exampleValue)
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
	val exampleProperty = "com.company.team.project.application.native.apple.ios"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.single_source_set.native.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
