package sample

import com.company.team.project.common.jvm.common.commonJvm

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun hello(): String = "Hello from ${Platform.name}" + commonJvm()

class Proxy {
    fun proxyHello() = hello()
}

fun main() {
    println(hello())
}
