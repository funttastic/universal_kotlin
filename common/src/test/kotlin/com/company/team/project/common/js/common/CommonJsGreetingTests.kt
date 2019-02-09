package com.company.team.project.common.js.common

import com.company.team.project.common.common.common
import kotlin.test.Test
import kotlin.test.assertEquals

class CommonJsGreetingTests {

    @Test
    fun testCommonJsMain() {
        assertEquals("${common()}|commonJs",
					commonJs()
				)
    }
}
