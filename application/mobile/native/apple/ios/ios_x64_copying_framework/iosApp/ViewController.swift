import UIKit
import KotlinFramework

/**
 *
 */
class ViewController: UIViewController {

	/**
	 *
	 */
	override func viewDidLoad() {
		super.viewDidLoad()
		label.text = ExampleKt.exampleValue
	}

	/**
	 *
	 */
	override func didReceiveMemoryWarning() {
		super.didReceiveMemoryWarning()
	}

	/**
	 *
	 */
	@IBOutlet weak var label: UILabel!
}
