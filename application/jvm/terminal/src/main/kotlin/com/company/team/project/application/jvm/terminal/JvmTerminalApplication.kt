package com.company.team.project.application.jvm.terminal

import com.company.team.project.common.hello

class JvmTerminalApplication {

	fun hello(): String {
		return "Terminal: ${com.company.team.project.common.hello()}"
	}
}

fun main() {
	println(hello())
}
