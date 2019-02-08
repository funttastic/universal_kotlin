package com.company.team.project.application.jvm.jvm8.terminal

import com.company.team.project.common.commonJvm
import org.junit.Test
import kotlin.test.assertEquals

class ApplicationJvmJvm8TerminalGreetingTests {

	@Test
	fun testJvmTerminal() {
		assertEquals("${commonJvm()}|applicationJvmJvm8Terminal",
			applicationJvmTerminal()
		)
	}
}
