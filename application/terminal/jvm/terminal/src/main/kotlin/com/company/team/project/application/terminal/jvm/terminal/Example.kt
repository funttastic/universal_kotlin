package com.company.team.project.application.terminal.jvm.terminal

import com.company.team.project.common.single_source.common.formatOutput
import com.company.team.project.common.single_source.common.OutputType.TERMINAL
import org.jline.terminal.TerminalBuilder.terminal

/**
 *
 */
fun main() {
	println(exampleValue)
}



/**
 *
 */
val exampleValue = formatOutput(exampleFunction(), TERMINAL, terminal().width)

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
	private val exampleProperty = ExampleObject::class.java.`package`.name

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.jvm.common.exampleFunction())
		output.addAll(com.company.team.project.library.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
