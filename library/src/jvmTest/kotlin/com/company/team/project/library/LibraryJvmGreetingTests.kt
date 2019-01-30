import com.company.team.project.common.common
import com.company.team.project.common.commonJvm
import com.company.team.project.library.libraryCommon
import kotlin.test.Test
import kotlin.test.assertEquals

class GreetingTests {

	@Test
	fun testLibraryCommon() {
		assertEquals("${commonJvm()}|${libraryCommon()}|jvm", libraryJvm())
	}
}

//package com.company.team.project.library
//
//import com.company.team.project.common.hello
//import kotlin.test.Test
//import kotlin.test.assertTrue
//
//class SampleTestsJVM {
//    @Test
//    fun testHello() {
//        assertTrue("JVM" in hello())
//    }
//}
