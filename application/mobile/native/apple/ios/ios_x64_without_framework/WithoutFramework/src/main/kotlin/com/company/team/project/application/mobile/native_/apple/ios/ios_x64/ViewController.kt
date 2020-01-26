package com.company.team.project.application.mobile.native_.apple.ios.ios_x64

import kotlinx.cinterop.*
import platform.Foundation.*
import platform.UIKit.*
import com.company.team.project.application.mobile.native_.apple.ios.ios_x64.exampleValue

/**
 *
 */
@ExportObjCClass
class ViewController : UIViewController {

	/**
	 *
	 */
	@OverrideInit
	constructor() : super(nibName = null, bundle = null)

	/**
	 *
	 */
	@OverrideInit
	constructor(coder: NSCoder) : super(coder)

	/**
	 *
	 */
	@ObjCOutlet
	lateinit var label: UILabel

	/**
	 *
	 */
	override fun viewDidLoad() {
		super.viewDidLoad()
		label.text = exampleValue
	}
}
