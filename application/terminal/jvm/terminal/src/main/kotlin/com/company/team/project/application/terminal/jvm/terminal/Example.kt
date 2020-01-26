package com.company.team.project.application.terminal.jvm.terminal

/**
 *
 */
fun main() {
	println(exampleValue)
}

/**
 *
 */
val exampleValue = com.company.team.project.common.single_source.common.formatOuput(exampleFunction(), true)

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
	private val exampleProperty = ExampleObject::class.java.`package`.name

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
