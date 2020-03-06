import java.nio.file.Path
import java.nio.file.Paths
import java.util.Properties as JavaProperties

/**
 *
 */
object Properties {

	/**
	 *
	 */
	object modules {

		/**
		 *
		 */
		object root {

			/**
			 *
			 */
			lateinit var file: File

			/**
			 *
			 */
			val path: Path by lazy {
				file.absoluteFile.toPath()
			}

			/**
			 *
			 */
			val absolutePath: String by lazy {
				file.absolutePath
			}

			/**
			 *
			 */
			val group: String by lazy {
				get("group")
			}

			/**
			 *
			 */
			val artifact: String by lazy {
				get("artifact")
			}

			/**
			 *
			 */
			val version: String by lazy {
				get("version")
			}
		}
	}

	/**
	 *
	 */
	val local: JavaProperties by lazy {
		loadProperties(JavaProperties(), Paths.get(modules.root.absolutePath, "local.properties").toFile())
	}

	/**
	 *
	 */
	val environment by lazy {
		System.getenv()
	}

	/**
	 *
	 */
	val system: JavaProperties = JavaProperties()

	/**
	 *
	 */
	val gradle: JavaProperties by lazy {
		loadProperties(JavaProperties(), Paths.get(modules.root.absolutePath, "gradle.properties").toFile())
	}

	/**
	 *
	 */
	val globalGradle: JavaProperties by lazy {
		loadProperties(JavaProperties(), Paths.get(System.getProperty("user.home"), ".gradle", "gradle.properties").toFile())
	}

	/**
	 *
	 */
	fun containsKey(vararg keys: String): Boolean {
		if (keys.isNullOrEmpty()) return false

		keys.forEach {
			when {
				local.containsKey(it) -> return true
				environment.containsKey(it) -> return true
				system.containsKey(it) -> return true
				gradle.containsKey(it) -> return true
				globalGradle.containsKey(it) -> return true
			}
		}

		return false
	}

	/**
	 *
	 */
	fun get(vararg keys: String): String {
		return this.getAndCast<String>(*keys) ?: throw IllegalArgumentException("Property key(s) ${keys} not found.")
	}

	/**
	 *
	 */
	fun getOrNull(vararg keys: String): String? {
		return getAndCast<String>(*keys)
	}

	/**
	 *
	 */
	inline fun <reified R> getOrDefault(vararg keys: String, default: R?): R? {
		return getAndCast<R>(*keys) ?: default
	}

	/**
	 *
	 */
	inline fun <reified R> getAndCast(vararg keys: String): R? {
		if (keys.isNullOrEmpty()) return null

		keys.forEach {
			val value = when {
				local.containsKey(it) -> local[it]
				environment.containsKey(it) -> environment[it]
				system.containsKey(it) -> system[it]
				gradle.containsKey(it) -> gradle[it]
				globalGradle.containsKey(it) -> globalGradle[it]
				else -> null
			}

			// TODO Improve the casting using Jackson
			if (value != null) return value as R
		}

		return null
	}

	/**
	 *
	 */
	private fun loadProperties(target: JavaProperties, file: File): JavaProperties {
		if (file.canRead()) {
			file.inputStream().use { target.load(it) }
		}

		return target
	}
}

if (rootProject.name == "buildSrc") {
	Properties.modules.root.file = rootDir.parentFile
} else {
	Properties.modules.root.file = rootDir
}

extra["getProperty"] = { key: String -> Properties.get(key) }
