package com.company.team.project.library.multiple_sources.js

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 *
 */
class ExampleTests {

	/**
	 *
	 */
	@Test
	fun exampleValueCannotBeEmpty() {
		assertTrue(exampleFunction().isNotEmpty())
	}

	/**
	 *
	 */
	@Test
	fun checkIfExampleObjectPackageIsOk() {
		assertTrue(checkExampleObjectPackageAndReturnIt().isNotBlank())
	}
}
