package com.company.team.project.application.jvm.jvm8.terminal

import com.company.team.project.common.jvm.common.commonJvm

fun applicationJvmTerminal(): String = "${commonJvm()}|applicationJvmJvm8Terminal"

class ApplicationJvmTerminalGreeting {
}

fun main() {
	println(applicationJvmTerminal())
}
