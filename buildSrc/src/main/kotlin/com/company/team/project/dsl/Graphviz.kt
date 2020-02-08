package com.company.team.project.dsl

import com.company.team.project.dsl.model.enum_.ModuleEnum
import com.company.team.project.dsl.model.enum_.TargetEnum
import com.company.team.project.dsl.model.enum_.SourceSetEnum
import java.nio.file.Paths

enum class GraphvizDiagram {
	modules,
	all
}

fun generateGraphvizDiagrams() {
	GraphvizDiagram.values().forEach {
		generateGraphvizDiagram(it)
	}
}

fun generateGraphvizDiagram(diagram: GraphvizDiagram) {
	val modulesDefinitions = generateModulesDefinitions(diagram)

	val modulesLinks = generateModulesLinks(diagram)

	val content = """
	|digraph G {
	|	ratio = fill
	|	node [style=filled]
	|
	|	$modulesDefinitions
	|
	|	$modulesLinks
	|}
	""".trimMargin()

	save(diagram, content)
}

fun generateModulesDefinitions(diagram: GraphvizDiagram): String {
	var output = ""

	ModuleEnum.values().forEach {
		output += "\n\t\"${it.name}\" [label=\"${it.title}\", fontcolor=\"black\", color=\"#00C853\"]"
	}

	if (GraphvizDiagram.all == diagram) {
		TargetEnum.values().forEach {
			output += "\n\t\"${it.name}\" [label=\"${it.title}\", fontcolor=\"black\", color=\"#FFD600\"]"
		}

		SourceSetEnum.values().forEach {
			output += "\n\t\"${it.name}\" [label=\"${it.title}\", fontcolor=\"white\", color=\"#0091EA\"]"
		}
	}

	return output
}

fun generateModulesLinks(diagram: GraphvizDiagram, root: ModuleEnum = ModuleEnum.root): String {
	var output = ""

	root.children.forEach {module ->
		output += "\n\t\"${module.parent?.name}\" -> \"${module.name}\" [color=\"#1B5E20\"]"

		if (GraphvizDiagram.all == diagram) {
			module.targets.forEach { target ->
				output += "\n\t\"${module.name}\" -> \"${target.name}\" [color=\"#F57F17\"]"

				target.sourceSets.forEach { sourceSet ->
					output += "\n\t\"${target.name}\" -> \"${sourceSet.name}\" [color=\"#01579B\"]"

					sourceSet.requiredAt.forEach { sourceSet2 ->
						output += "\n\t\"${sourceSet2.name}\" -> \"${sourceSet.name}\" [color=\"#880E4F\"]"
					}
				}

				target.requiredAt.forEach { sourceSet ->
					output += "\n\t\"${sourceSet.name}\" -> \"${target.name}\" [color=\"#880E4F\"]"
				}
			}
		}

		output += generateModulesLinks(diagram, module)
	}

	return output
}

fun save(diagram: GraphvizDiagram, content: String) {
	Paths.get(
		com.company.team.project.dsl.model.Properties.projects.root.absolutePath,
		"resources/architecture/diagram/graphviz/definitions/${diagram.name}.txt"
	).toFile().writeText(content)
}
