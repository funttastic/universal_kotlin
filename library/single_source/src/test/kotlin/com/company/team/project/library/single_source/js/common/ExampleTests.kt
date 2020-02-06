package com.company.team.project.library.single_source.js.common

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
	fun `Should have the expected amount of included modules`() {
		assertEquals(4, exampleFunction().size)
	}

	/**
	 *
	 */
	@Test
	fun checkIfExampleObjectPackageIsOk() {
		assertTrue(checkExampleObjectPackageAndReturnIt().isNotBlank())
	}
}
