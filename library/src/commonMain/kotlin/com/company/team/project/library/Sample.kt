package com.company.team.project.library

import com.company.team.project.common.hello

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun hello(): String = "library ${hello()}"
