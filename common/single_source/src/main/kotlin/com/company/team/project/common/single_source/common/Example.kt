package com.company.team.project.common.single_source.common

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
	private const val exampleProperty = "com.company.team.project.common.single_source.common"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.add(exampleProperty)

		return output
	}
}

/**
 *
 */
fun formatOutput(input: List<String>?, showBanner: Boolean = false): String {
	val prefix = "com.company.team.project."

	var output = ""

	if (showBanner) {
		output = """
		|
		|	_|    _|            _|                                                      _|      _|    _|              _|      _|  _|
		|	_|    _|  _|_|_|        _|      _|    _|_|    _|  _|_|    _|_|_|    _|_|_|  _|      _|  _|      _|_|    _|_|_|_|  _|      _|_|_|
		|	_|    _|  _|    _|  _|  _|      _|  _|_|_|_|  _|_|      _|_|      _|    _|  _|      _|_|      _|    _|    _|      _|  _|  _|    _|
		|	_|    _|  _|    _|  _|    _|  _|    _|        _|            _|_|  _|    _|  _|      _|  _|    _|    _|    _|      _|  _|  _|    _|
		|	_|_|    _|    _|  _|      _|        _|_|_|  _|        _|_|_|      _|_|_|  _|      _|    _|    _|_|        _|_|  _|  _|  _|    _|
		|
		|
		|
		|                                                        One language to rule them all!
		|
		|
		|
		""".trimMargin()
	}

	output += "Used modules:\n"

	input?.forEach {
		output += "\n${it.removePrefix(prefix)}"
	}

	output += "\n\n"

	return output
}
