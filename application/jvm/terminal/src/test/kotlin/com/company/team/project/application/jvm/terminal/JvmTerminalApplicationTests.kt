package com.company.team.project.application.jvm.terminal

import org.junit.Test
import kotlin.test.assertEquals

class JvmTerminalApplicationTests {

	@Test
	fun testMe() {
		assertEquals(JvmTerminalApplication().hello(), "Terminal: Hello from JVM")
	}
}
