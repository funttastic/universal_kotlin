package sample

import com.company.team.project.common.native.common.commonNative

fun hello(): String = "Hello from" + commonNative()

class Proxy {
    fun proxyHello() = hello()
}

fun main() {
    println(hello())
}
