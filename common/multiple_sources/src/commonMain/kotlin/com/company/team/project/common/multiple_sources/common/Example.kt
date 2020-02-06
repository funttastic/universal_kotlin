package com.company.team.project.common.multiple_sources.common

/**
 *
 */
val exampleValue = formatOutput(exampleFunction())

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
	private const val exampleProperty = "com.company.team.project.common.multiple_sources.common"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.add(exampleProperty)

		return output
	}
}

//fun getPackage(`class`: KClass<*>): String? = `class`.qualifiedName?.replace(".${`class`.simpleName}", "")

/**
 *
 */
fun formatOutput(input: List<String>?, showBanner: Boolean = false): String {
	val prefix = "com.company.team.project."

	var output = ""

	if (showBanner) {
		output = """
		|
		| _|    _|            _|                                                      _|      _|    _|              _|      _|  _|
		| _|    _|  _|_|_|        _|      _|    _|_|    _|  _|_|    _|_|_|    _|_|_|  _|      _|  _|      _|_|    _|_|_|_|  _|      _|_|_|
		| _|    _|  _|    _|  _|  _|      _|  _|_|_|_|  _|_|      _|_|      _|    _|  _|      _|_|      _|    _|    _|      _|  _|  _|    _|
		| _|    _|  _|    _|  _|    _|  _|    _|        _|            _|_|  _|    _|  _|      _|  _|    _|    _|    _|      _|  _|  _|    _|
		| _|_|    _|    _|  _|      _|        _|_|_|  _|        _|_|_|      _|_|_|  _|      _|    _|    _|_|        _|_|  _|  _|  _|    _|
		|
		|
		|
		|                                                        One language to rule them all!
		|
		|
		|
		""".trimMargin()
	}

	output += "Modules:\n"

	output += input?.distinct()?.sorted()?.joinToString("\n") { it.removePrefix(prefix) }

	return output
}
