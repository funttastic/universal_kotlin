package com.company.team.project.common

import kotlin.test.Test
import kotlin.test.assertEquals

class CommonJsGreetingTests {

    @Test
    fun testCommonJsMain() {
        assertEquals("${common()}|commonJs", commonJs())
    }
}
