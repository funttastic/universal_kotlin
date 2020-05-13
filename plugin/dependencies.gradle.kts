/**
 *
 */
data class Dependency(
	val group: String,
	val artifact: String,
	val version: String
)

/**
 *
 */
object Dependencies {

	/**
	 *
	 */
	private val dependencies: MutableMap<String, MutableMap<String, Dependency>> = mutableMapOf()

	fun add(rawDependency: String, rawModules: Set<String>) {
		val rawDependencySplit = rawDependency.split(":")
		val dependencyGroup = rawDependencySplit[0]
		val dependencyArtifact = rawDependencySplit[1]
		val dependencyVersion = rawDependencySplit[2]

		rawModules.map {
			val group = it.trim()

			if (!dependencies.containsKey(group)) dependencies[group] = mutableMapOf()

			dependencies[group]!!["${dependencyGroup}:${dependencyArtifact}"] = Dependency(dependencyGroup, dependencyArtifact, dependencyVersion)
		}
	}

	/**
	 *
	 */
	fun getVersion(group: String, dependencyId: String): String {
		if (!dependencies.containsKey(group)) throw Exception("""Module "${group}" not found in the dependencies.""")
		if (!dependencies[group]!!.containsKey(dependencyId)) throw Exception("""Dependency "${dependencyId}" not found in the module "${group}".""")

		return dependencies[group]!![dependencyId]!!.version
	}
}

extra["getDependencyVersion"] = { group: String, dependencyId: String -> Dependencies.getVersion(group, dependencyId) }

Dependencies.add("com.github.salomonbrys.gradle.kotlin.js:kotlin-js-gradle-utils:1.2.0", setOf("settings.gradle.kts"))
