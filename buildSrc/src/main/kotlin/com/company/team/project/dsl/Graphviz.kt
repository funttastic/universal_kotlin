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
		output += "\n\t\"${it.name}\" [label=\"${it.title}\", fontcolor=\"black\", color=\"#00C853\"]"
	}

	TargetEnum.values().forEach {
		output += "\n\t\"${it.name}\" [label=\"${it.title}\", fontcolor=\"black\", color=\"#FFD600\"]"
	}

	SourceSetEnum.values().forEach {
		output += "\n\t\"${it.name}\" [label=\"${it.title}\", fontcolor=\"white\", color=\"#0091EA\"]"
	}

	return output
}

fun generateModulesLinks(root: ModuleEnum = ModuleEnum.root): String {
	var output = ""

	root.children.forEach {module ->
		output += "\n\t\"${module.parent?.name}\" -> \"${module.name}\" [color=\"#1B5E20\"]"

		module.targets.forEach {target ->
			output += "\n\t\"${module.name}\" -> \"${target.name}\" [color=\"#F57F17\"]"

			target.sourceSets.forEach {sourceSet ->
				output += "\n\t\"${target.name}\" -> \"${sourceSet.name}\" [color=\"#01579B\"]"

				sourceSet.requiredAt.forEach { sourceSet2->
					output += "\n\t\"${sourceSet2.name}\" -> \"${sourceSet.name}\" [color=\"#880E4F\"]"
				}
			}

			target.requiredAt.forEach { sourceSet->
				output += "\n\t\"${sourceSet.name}\" -> \"${target.name}\" [color=\"#880E4F\"]"
			}
		}

		output += generateModulesLinks(module)
	}

	return output
}

fun save(content: String) {
	Paths.get(
		com.company.team.project.dsl.model.Properties.projects.root.absolutePath!!,
		"resources/architecture/diagram/graphviz/all_connections.txt"
	).toFile().writeText(content)
}
