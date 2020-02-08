package com.company.team.project.common.single_source.wasm32.common

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
