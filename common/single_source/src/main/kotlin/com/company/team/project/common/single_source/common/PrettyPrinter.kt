package com.company.team.project.common.single_source.common

enum class OutputType {
	BROWSER,
	MOBILE,
	PLAIN,
	TERMINAL
}

/**
 *
 */
fun formatOutput(input: List<String>?, outputType: OutputType = OutputType.PLAIN, width: Int = 0): String {
	val prefix = "com.company.team.project."

	val list = input?.distinct()?.sorted()?.map { it.removePrefix(prefix) }

	var output = ""

	when {
		OutputType.BROWSER == outputType -> {
			output += """
<style>
	* {
		margin: 0;
		padding: 0;
	}

	html {
		background-color: black;
		color: white;
	}

	h1 {
		text-align: center;
	}

	#logo {
		text-align: center;
	}

	h2 {
		text-align: center;
	}

	ul {
		text-align: center;
	}

	li {
		list-style-type: none;
	}
</style>

<h1>Universal Kotlin</h1>

<p id="logo">
	<a href="https://github.com/funttastic/universal-kotlin">
		<img
			src="https://raw.githubusercontent.com/funttastic/universal-kotlin/development/resources/design/logo/logo.png"
			alt="Universal Kotlin Logo"
			width="180"
			height="180"
		>
	</a>
</p>

<h2>Modules</h2>

<div>
	<ul>
		${list?.joinToString("") {"<li>$it</li>"}}
	</ul>
</div>
			""".trimMargin()
		}
		OutputType.MOBILE == outputType -> {
			output += list?.joinToString("\n")
		}
		OutputType.PLAIN == outputType -> {
			output += list?.joinToString("\n")
		}
		OutputType.TERMINAL == outputType -> {
			val padLength = ((width - 117) / 2).takeIf { it > 0 } ?: 0


			output += """

   /  /\         /  /\           ___         ___          /  /\         /  /\         /  /\         /  /\         /  /\
   /  /:/        /  /::|         /__/\       /  /\        /  /::\       /  /::\       /  /::\       /  /::\       /  /:/
  /  /:/        /  /:|:|         \__\:\     /  /:/       /  /:/\:\     /  /:/\:\     /__/:/\:\     /  /:/\:\     /  /:/
 /  /:/        /  /:/|:|__       /  /::\   /  /:/       /  /::\ \:\   /  /::\ \:\   _\_ \:\ \:\   /  /::\ \:\   /  /:/
/__/:/     /\ /__/:/ |:| /\   __/  /:/\/  /__/:/  ___  /__/:/\:\ \:\ /__/:/\:\_\:\ /__/\ \:\ \:\ /__/:/\:\_\:\ /__/:/
\  \:\    /:/ \__\/  |:|/:/  /__/\/:/~~   |  |:| /  /\ \  \:\ \:\_\/ \__\/~|::\/:/ \  \:\ \:\_\/ \__\/  \:\/:/ \  \:\
 \  \:\  /:/      |  |:/:/   \  \::/      |  |:|/  /:/  \  \:\ \:\      |  |:|::/   \  \:\_\:\        \__\::/   \  \:\
  \  \:\/:/       |__|::/     \  \:\      |__|:|__/:/    \  \:\_\/      |  |:|\/     \  \:\/:/        /  /:/     \  \:\
   \  \::/        /__/:/       \__\/       \__\::::/      \  \:\        |__|:|~       \  \::/        /__/:/       \  \:\
    \__\/         \__\/                        ~~~~        \__\/         \__\|         \__\/         \__\/         \__\/
                          ___           ___                         ___                    ___
                         /  /\         /  /\          ___          /  /\       ___        /  /\
                        /  /:/        /  /::\        /__/\        /  /:/      /__/\      /  /::|
                       /  /:/        /  /:/\:\       \  \:\      /  /:/       \__\:\    /  /:|:|
                      /  /::\____   /  /:/  \:\       \__\:\    /  /:/        /  /::\  /  /:/|:|__
                     /__/:/\:::::\ /__/:/ \__\:\      /  /::\  /__/:/      __/  /:/\/ /__/:/ |:| /\
                     \__\/~|:|~~~~ \  \:\ /  /:/     /  /:/\:\ \  \:\     /__/\/:/~~  \__\/  |:|/:/
                        |  |:|      \  \:\  /:/     /  /:/__\/  \  \:\    \  \::/         |  |:/:/
                        |  |:|       \  \:\/:/     /__/:/        \  \:\    \  \:\         |__|::/
                        |__|:|        \  \::/      \__\/          \  \:\    \__\/         /__/:/
                         \__\|         \__\/                       \__\/                  \__\/


				""".split("\n").joinToString("\n" + " ".repeat(padLength))

			output += "\n\n"
			output += centerString("One language to rule them all!", width)
			output += "\n\n\n\n"
			output += centerString("Modules", width)
			output += "\n\n"
			output += list?.joinToString("\n") { centerString(it, width) }
		}
	}

	return output
}


fun centerString(string: String, width: Int): String {
	val padLength = ((width - string.length) / 2).takeIf { it > 0 } ?: 0

	return " ".repeat(padLength) + string
}
