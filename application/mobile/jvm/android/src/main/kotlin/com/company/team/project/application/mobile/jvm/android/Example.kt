package com.company.team.project.application.mobile.jvm.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.company.team.project.common.single_source.common.formatOutput

/**
 *
 */
class MainActivity : AppCompatActivity() {

	/**
	 *
	 */
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val textView = findViewById<TextView>(R.id.example)
		textView.text = exampleValue
	}
}


/**
 *
 */
val exampleValue = formatOutput(exampleFunction())

/**
 *
 */
fun exampleFunction(): Set<String> {
	return ExampleObject.exampleMethod()
}

/**
 *
 */
object ExampleObject {

	/**
	 *
	 */
	private const val exampleProperty = "com.company.team.project.application.mobile.jvm.android"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.jvm.common.exampleFunction())
		output.addAll(com.company.team.project.library.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
