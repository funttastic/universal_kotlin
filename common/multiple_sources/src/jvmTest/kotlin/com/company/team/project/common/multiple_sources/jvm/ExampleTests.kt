package com.company.team.project.common.multiple_sources.jvm

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
		assertEquals(2, exampleFunction().size)
	}
}
