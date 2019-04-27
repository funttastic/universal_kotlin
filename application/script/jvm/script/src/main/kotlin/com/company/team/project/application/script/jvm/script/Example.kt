package com.company.team.project.application.script.jvm.script

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
	private val exampleProperty = ExampleObject::class.java.`package`.toString()

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
//		output.addAll(com.company.team.project.common.single_source.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
