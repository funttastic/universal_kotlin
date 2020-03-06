data class Dependency(
	val group: String,
	val artifact: String,
	val version: String,
	val module: String = "root"
)

data class Dependencies(
	val dependencies = mapOf()
) {
	fun add(dependency: Dependency) {
		dependencies["${dependency.group}:${dependency.artifact}:${dependency.module}"] = dependency
	}
}

val dependencies = Dependencies()

dependencies.add(Dependency(
	"com.github.salomonbrys.gradle.kotlin.js",
	"kotlin-js-gradle-utils",
	"1.2.0"
))
