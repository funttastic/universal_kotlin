package com.company.team.project.library.multiple_sources.wasm32

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
	fun shouldHaveTheExpectedAmountOfIncludedModules() {
		assertEquals(4, exampleFunction().size)
	}
}
