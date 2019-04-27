package com.company.team.project.library.single_source.js.common

import kotlin.reflect.KClass

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
	private val exampleProperty by lazy {
		checkAndReturnPackage(
			"com.company.team.project.library.single_source.js.common",
			this::class
		)
	}

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
 * The `_` value is where kotlin put the js packages.
 * 	This value is defined both in the test module and in the main module, so they will have
 * 	different values depending on it is being called.
 */
@JsName("_")
external val `_`: dynamic

/**
 * Since with Kotlin Js is not possible to extract the package of a class we did this workaround just to check
 * 	if the package is ok.
 */
fun checkAndReturnPackage(package_: String, class_: KClass<*>): String {
	if (
		class_.js.name
		=== eval("get_js(Kotlin.getKClassFromExpression(_.$package_.${class_.simpleName})).name")
	) {
		return package_
	}

	throw IllegalArgumentException(
		"""
    	The package $package_ isn't the correct package for the class $class_.
    """
	)
}

/**
 * Since with Kotlin Js is not possible to extract the package of a class, we did this workaround to check
 * 	if the package is ok and return it. Otherwise this method throws an exception.
 */
fun checkExampleObjectPackageAndReturnIt(): String {
	val expectedPackage = "com.company.team.project.library.single_source.js.common"
	if (
		ExampleObject::class.js.name
		=== `_`.com.company.team.project.library.single_source.js.common.ExampleObject::class.js.name
	) {
		return expectedPackage
	}

	throw IllegalArgumentException(
		"""
    	The "$expectedPackage" isn't the correct package for the class "${ExampleObject::class.simpleName}".
    """
	)
}
