import com.company.team.project.common.commonJvm
import com.company.team.project.library.libraryCommon

fun libraryJvm(): String = "${commonJvm()}|${libraryCommon()}|jvm"

//package com.company.team.project.library
//
//actual class Sample {
//    actual fun checkMe() = 42
//}
//
//actual object Platform {
//    actual val name: String = "JVM"
//}
