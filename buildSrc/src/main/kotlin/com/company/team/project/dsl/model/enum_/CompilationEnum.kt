package com.company.team.project.dsl.model.enum_

import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation.Companion.MAIN_COMPILATION_NAME
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation.Companion.TEST_COMPILATION_NAME

/**
 *
 */
enum class CompilationEnum(

	/**
	 *
	 */
	var id: String? = null,

	/**
	 *
	 */
	var title: String? = null,

	/**
	 *
	 */
	var description: String? = null
) {

	main(id = MAIN_COMPILATION_NAME),
	test(id = TEST_COMPILATION_NAME);

	/**
	 *
	 */
	init {
		if (id == null) id = name

		if (title == null) title = id!!.capitalize()

		if (description == null) description = "$title compilation."
	}

	/**
	 *
	 */
	companion object {

		/**
		 *
		 */
		fun getByName(name: String?): CompilationEnum? {
			if (name == null) return null

			for (item in CompilationEnum.values()) {
				if (item.name == name) {
					return item
				}
			}

			return null
		}

		/**
		 *
		 */
		fun getById(id: String?): CompilationEnum? {
			if (id == null) return null

			for (item in CompilationEnum.values()) {
				if (item.id == id) {
					return item
				}
			}

			return null
		}
	}
}
