package com.company.team.project.application.jvm.terminal

import com.company.team.project.common.commonJvm

fun applicationJvmTerminal(): String = "${commonJvm()}|applicationJvmTerminal"

class ApplicationJvmTerminalGreeting {
}

fun main() {
	println(applicationJvmTerminal())
}
