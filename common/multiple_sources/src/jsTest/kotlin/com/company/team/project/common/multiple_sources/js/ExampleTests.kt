package com.company.team.project.common.multiple_sources.js

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
		assertEquals(2, exampleFunction().size)
	}

	/**
	 *
	 */
	@Test
	fun checkIfExampleObjectPackageIsOk() {
		assertTrue(checkExampleObjectPackageAndReturnIt().isNotBlank())
	}
}
