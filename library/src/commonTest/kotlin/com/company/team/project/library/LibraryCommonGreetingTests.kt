package com.company.team.project.library

import com.company.team.project.common.common
import kotlin.test.Test
import kotlin.test.assertEquals

class LibraryCommonGreetingTests {

    @Test
    fun testLibraryCommon() {
        assertEquals("${common()}|library", libraryCommon())
    }
}
