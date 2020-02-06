package com.company.team.project.dsl

import org.junit.Test
import org.junit.Assert.assertEquals

/**
 *
 */
class ExampleTests {

	/**
	 *
	 */
	@Test
	fun `Should have the expected amount of included modules`() {
		assertEquals(1, exampleFunction().size)
	}
}
