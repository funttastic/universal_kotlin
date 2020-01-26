package com.company.team.project.application.mobile.native_.apple.ios.ios_x64

import kotlinx.cinterop.autoreleasepool
import kotlinx.cinterop.cstr
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toCValues
import platform.Foundation.NSStringFromClass
import platform.UIKit.UIApplicationMain

/**
 *
 */
fun main(args: Array<String>) {
	println(exampleValue)

	memScoped {
		val argc = args.size + 1
		val argv = (arrayOf("konan") + args).map { it.cstr.ptr }.toCValues()

		autoreleasepool {
			UIApplicationMain(argc, argv, null, NSStringFromClass(AppDelegate))
		}
	}
}
