package com.company.team.project.library.multiple_sources.linux_x64

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
