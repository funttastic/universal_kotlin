import kotlin.browser.*

class Sample {
	fun checkMe() = 12
}

object Platform {
	val name: String = "JS"
}


@Suppress("unused")
@JsName("helloWorld")
fun helloWorld(salutation: String) {
	val message = "$salutation from Kotlin.JS, check me value: ${Sample().checkMe()}"
	document.getElementById("js-response")?.textContent = message
}

fun main() {
	helloWorld("Test")
}
