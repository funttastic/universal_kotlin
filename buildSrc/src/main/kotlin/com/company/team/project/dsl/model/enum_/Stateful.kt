package com.company.team.project.dsl.model.enum_

/**
 *
 */
interface Stateful {

	/**
	 *
	 */
	var status: StatusEnum

	/**
	 *
	 */
	fun isEnabled() = StatusEnum.enabled == status
}
