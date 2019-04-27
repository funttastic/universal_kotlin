package com.company.team.project.dsl.model.enum_

/**
 *
 */
enum class StatusEnum(

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

	enabled,
	disabled;

	/**
	 *
	 */
	init {
		if (id == null) id = name

		if (title == null) title = id!!.capitalize()

		if (description == null) description = "$title status."
	}

	/**
	 *
	 */
	companion object {

		/**
		 *
		 */
		fun getByName(name: String?): StatusEnum? {
			if (name == null) return null

			for (item in StatusEnum.values()) {
				if (item.name == name) {
					return item
				}
			}

			return null
		}

		/**
		 *
		 */
		fun getById(id: String?): StatusEnum? {
			if (id == null) return null

			for (item in StatusEnum.values()) {
				if (item.id == id) {
					return item
				}
			}

			return null
		}
	}
}
