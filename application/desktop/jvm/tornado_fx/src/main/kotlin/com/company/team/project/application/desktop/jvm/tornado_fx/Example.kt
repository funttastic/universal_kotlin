package com.company.team.project.application.desktop.jvm.tornado_fx

import tornadofx.App
import tornadofx.label
import tornadofx.launch
import tornadofx.vbox
import com.company.team.project.common.single_source.common.formatOuput

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
