package com.company.team.project.application.mobile.native_.apple.ios.ios_x64

import kotlinx.cinterop.*
import platform.Foundation.*
import platform.UIKit.*
import com.company.team.project.application.mobile.native_.apple.ios.ios_x64.ViewController

/**
 *
 */
fun main(args: Array<String>) {
	memScoped {
		val argc = args.size + 1
		val argv = (arrayOf("konan") + args).map { it.cstr.ptr }.toCValues()

		autoreleasepool {
			UIApplicationMain(argc, argv, null, NSStringFromClass(AppDelegate))
		}
	}
}
