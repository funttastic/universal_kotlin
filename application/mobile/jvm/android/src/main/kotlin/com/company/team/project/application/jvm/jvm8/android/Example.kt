package com.company.team.project.application.jvm.jvm8.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

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
val exampleValue = exampleFunction().toString()

/**
 *
 */
fun exampleFunction(): List<String> {
	return ExampleObject.exampleMethod()
}

/**
 *
 */
object ExampleObject {

	/**
	 *
	 */
	private const val exampleProperty = "com.company.team.project.application.jvm.jvm8.android"

	/**
	 *
	 */
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.single_source_set.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
