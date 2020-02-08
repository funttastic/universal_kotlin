package com.company.team.project.common.multiple_sources.wasm32

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
		assertEquals(2, exampleFunction().size)
	}
}
