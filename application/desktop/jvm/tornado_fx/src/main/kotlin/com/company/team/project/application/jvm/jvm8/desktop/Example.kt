package com.company.team.project.application.jvm.jvm8.desktop

import tornadofx.App
import tornadofx.label
import tornadofx.launch
import tornadofx.vbox

/**
 *
 */
fun main(args: Array<String>) {
	launch<App>(args)
}

/**
 *
 */
class App: tornadofx.App(View::class)

/**
 *
 */
class View: tornadofx.View() {
	override val root = vbox {
		label(exampleValue)
	}
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
		output.addAll(com.company.team.project.common.single_source_set.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
