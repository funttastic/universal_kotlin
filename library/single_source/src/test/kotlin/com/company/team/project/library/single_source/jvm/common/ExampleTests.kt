package com.company.team.project.library.single_source.jvm.common

import kotlin.test.Test
import kotlin.test.assertEquals

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
}
