package com.company.team.project.common

import kotlin.test.Test
import kotlin.test.assertEquals

class CommonNativeGreetingTests {

	@Test
	fun testCommonJsMain() {
		assertEquals("${common()}|commonNative", commonNative())
	}
}
