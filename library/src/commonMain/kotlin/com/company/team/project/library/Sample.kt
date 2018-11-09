package com.company.team.project.library

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun hello(): String = "library ${com.company.team.project.common.hello()}"
