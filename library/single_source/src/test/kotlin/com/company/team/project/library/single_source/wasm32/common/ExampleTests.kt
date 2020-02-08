package com.company.team.project.library.single_source.wasm32.common

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
