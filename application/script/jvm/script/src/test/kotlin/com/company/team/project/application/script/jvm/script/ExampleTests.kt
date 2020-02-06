package com.company.team.project.application.script.jvm.script

import org.junit.Test
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
