package com.company.team.project.common.native.common

import com.company.team.project.common.common.common
import kotlin.test.Test
import kotlin.test.assertEquals

class CommonNativeGreetingTests {

	@Test
	fun testCommonJsMain() {
		assertEquals("${common()}|commonNative",
			commonNative()
		)
	}
}
