import kotlinx.cinterop.*
import platform.Foundation.*
import platform.UIKit.*

@ExportObjCClass
class ViewController : UIViewController {

	@OverrideInit
	constructor() : super(nibName = null, bundle = null)

	@OverrideInit
	constructor(coder: NSCoder) : super(coder)

	@ObjCOutlet
	lateinit var label: UILabel

	@ObjCOutlet
	lateinit var textField: UITextField

	@ObjCOutlet
	lateinit var button: UIButton

	@ObjCAction
	fun buttonPressed() {
		label.text = "Konan says: 'Hello, ${textField.text}!'"
	}
}
