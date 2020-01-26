package com.company.team.project.application.mobile.native_.apple.ios.ios_x64

import kotlinx.cinterop.ExportObjCClass
import kotlinx.cinterop.ObjCOutlet
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGPointMake
import platform.CoreGraphics.CGRectMake
import platform.Foundation.NSCoder
import platform.UIKit.*

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

		val (width, height) = UIScreen.mainScreen.bounds.useContents {
			this.size.width to this.size.height
		}

		val header = UIView().apply {
			backgroundColor = UIColor.lightGrayColor
			view.addSubview(this)
			translatesAutoresizingMaskIntoConstraints = false
			leadingAnchor.constraintEqualToAnchor(view.leadingAnchor).active = true
			topAnchor.constraintEqualToAnchor(view.topAnchor).active = true
			widthAnchor.constraintEqualToAnchor(view.widthAnchor).active = true
			heightAnchor.constraintEqualToAnchor(view.heightAnchor).active = true
		}

		label = UILabel().apply {
			setFrame(CGRectMake(x = 0.0, y = 0.0, width = width, height = height))
			center = CGPointMake(x = width / 2, y = height/2 )
			textAlignment = NSTextAlignmentCenter
			text = exampleValue
			header.addSubview(this)
		}
	}
}
