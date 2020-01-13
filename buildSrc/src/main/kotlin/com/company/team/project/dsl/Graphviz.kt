package com.company.team.project.dsl

import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.enum_.TargetEnum
import com.company.team.project.dsl.model.enum_.SourceSetEnum
import java.nio.file.Paths

fun generateGraphviz() {
	val modulesDefinitions = generateModulesDefinitions()

	val modulesLinks = generateModulesLinks()

	val graphviz = """
	|digraph G {
	|	ratio = fill
	|	node [style=filled]
	|
	|	$modulesDefinitions
	|	
	|	$modulesLinks
	|}
	""".trimMargin()

	save(graphviz)
}

fun generateModulesDefinitions(): String {
	var output = ""

	ModuleEnum.values().forEach {
		output += "\n\t\"${it.name}\" [label=\"${it.title}\", color=darkorange]"
	}

	TargetEnum.values().forEach {
		output += "\n\t\"${it.name}\" [label=\"${it.title}\", color=darkorange]"
	}

	SourceSetEnum.values().forEach {
		output += "\n\t\"${it.name}\" [label=\"${it.title}\", color=darkorange]"
	}

	return output
}

fun generateModulesLinks(root: ModuleEnum = ModuleEnum.root): String {
	var output = ""

	root.children.forEach {module ->
		output += "\n\t\"${module.parent?.name}\" -> \"${module.name}\""

		module.targets.forEach {target ->
			output += "\n\t\"${module.name}\" -> \"${target.name}\""

			target.sourceSets.forEach {sourceSet ->
				output += "\n\t\"${target.name}\" -> \"${sourceSet.name}\""
			}
		}

		output += generateModulesLinks(module)
	}

	return output
}

fun save(content: String) {
	Paths.get(
		com.company.team.project.dsl.model.Properties.projects.root.absolutePath!!,
		"resources/architecture/diagram/graphviz.txt"
	).toFile().writeText(content)
}
