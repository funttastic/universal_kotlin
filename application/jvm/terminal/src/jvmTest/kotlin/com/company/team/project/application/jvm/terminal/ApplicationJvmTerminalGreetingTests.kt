package com.company.team.project.application.jvm.terminal

import com.company.team.project.common.commonJvm
import org.junit.Test
import kotlin.test.assertEquals

class ApplicationJvmTerminalGreetingTests {

	@Test
	fun testJvmTerminal() {
		assertEquals("${commonJvm()}|applicationJvmTerminal", applicationJvmTerminal())
	}
}
