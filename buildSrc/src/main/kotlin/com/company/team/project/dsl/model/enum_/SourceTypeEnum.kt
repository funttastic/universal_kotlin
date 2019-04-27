package com.company.team.project.dsl.model.enum_

/**
 *
 */
enum class SourceTypeEnum(

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

	kotlin(),
	resources();

	/**
	 *
	 */
	init {
		if (id == null) id = name

		if (title == null) title = id!!.capitalize()

		if (description == null) description = "$title source type."
	}

	/**
	 *
	 */
	companion object {

		/**
		 *
		 */
		fun getByName(name: String?): SourceTypeEnum? {
			if (name == null) return null

			for (item in SourceTypeEnum.values()) {
				if (item.name == name) {
					return item
				}
			}

			return null
		}

		/**
		 *
		 */
		fun getById(id: String?): SourceTypeEnum? {
			if (id == null) return null

			for (item in SourceTypeEnum.values()) {
				if (item.id == id) {
					return item
				}
			}

			return null
		}
	}
}
