import java.io.File.separator

/*
	TODO Support `gradle.startParameter.taskNames` property, and the environment variables `modules.include`,
	 `includeModules`, `INCLUDE_MODULES`, `modules.exclude`, `excludeModules`, and `EXCLUDE_MODULES`. These environment
	 variables must accept regex patterns to allow more flexibility when including / excluing modules.
 */

val buildFilename = "build.gradle(\\.kts)?".toRegex()
val includeModules = ".*".toRegex()
val excludeModules = "^\$|^buildSrc.*|^temporary.*|^plugin.*".toRegex()

println("""
Modules:
========
""".trimEnd())
rootDir.walk().filter {
	val relativeDirectoryPath = it.parentFile.toRelativeString(rootDir)

	it.name.matches(buildFilename)
	&& relativeDirectoryPath.matches(includeModules)
	&& !relativeDirectoryPath.matches(excludeModules)
}.forEach {
	val directory = it.parentFile
	val relativeDirectoryPath = directory.toRelativeString(rootDir)
	val id = relativeDirectoryPath.replace(separator, "-")

	include(id)
	project(":${id}").projectDir = directory
	println(":${id} ($relativeDirectoryPath)")
}
println()
