package com.company.team.project.common.single_source.common

/**
 *
 */
val exampleValue = formatOuput(exampleFunction())

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

fun formatOuput(input: List<String>?, showBanner: Boolean = false): String {
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
		""".trimMargin()
	}

	output += "Modules used:\n"

	input?.forEach {
		output += "\n$it"
	}

	output += "\n"

	return output
}
