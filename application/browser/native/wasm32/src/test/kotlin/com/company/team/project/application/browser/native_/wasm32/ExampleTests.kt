package com.company.team.project.application.browser.native_.wasm32

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
		assertEquals(9, exampleFunction().size)
	}
}

