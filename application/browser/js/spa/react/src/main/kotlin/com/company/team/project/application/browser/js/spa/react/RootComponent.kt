package com.company.team.project.application.browser.js.spa.react

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

/**
 *
 */
interface RootProps : RProps {
}

/**
 *
 */
interface RootState : RState {
}

/**
 *
 */
class Root(props: RootProps) : RComponent<RootProps, RootState>(props) {

	/**
	 *
	 */
	override fun RootState.init(props: RootProps) {
	}

	/**
	 *
	 */
	override fun RBuilder.render() {
		div {
			+exampleValue
		}
	}
}

/**
 *
 */
fun RBuilder.root() = child(Root::class) {
}
