package com.company.team.project.dsl.model.enum_

import com.company.team.project.dsl.model.Properties
import com.company.team.project.dsl.model.Properties.util.commonMain
import com.company.team.project.dsl.model.Properties.util.commonTest
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

/**
 *
 */
enum class SourceSetEnum(

	/**
	 *
	 */
	var kotlinId: String? = null,

	/**
	 *
	 */
	var title: String? = null,

	/**
	 *
	 */
	var description: String? = null,

	/**
	 *
	 */
	var module: ModuleEnum? = null,

	/**
	 *
	 */
	var target: TargetEnum? = null,

	/**
	 *
	 */
	var compilation: CompilationEnum? = null,

	/**
	 *
	 */
	var defaultStatus: StatusEnum = StatusEnum.disabled,

	/**
	 *
	 */
	var kotlinSourceSet: KotlinSourceSet? = null,

	/**
	 *
	 */
	val dependencies: Dependencies = Dependencies(),

	/**
	 *
	 */
	val requiredAt: MutableSet<SourceSetEnum> = mutableSetOf()
) {

	`common-multiple_sources@common@main`(
		kotlinId = commonMain
	),
	`common-multiple_sources@common@test`(
		kotlinId = commonTest
	),

	`common-multiple_sources@android_native_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@android_native_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@android_native_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@android_native_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@ios_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@ios_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@ios_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@ios_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@ios_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@ios_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@js@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@js@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@jvm@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@jvm@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@linux_arm32_hfp@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@linux_arm32_hfp@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@linux_mips32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@linux_mips32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@linux_mipsel32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@linux_mipsel32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@linux_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@linux_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@macos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@macos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@mingw_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@mingw_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@mingw_x86@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@mingw_x86@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@tvos_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@tvos_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@tvos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@tvos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@wasm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@wasm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@watchos_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@watchos_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@watchos_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@watchos_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@watchos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@watchos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),
	`common-multiple_sources@watchos_x86@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@main`)
		)
	),
	`common-multiple_sources@watchos_x86@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-multiple_sources@common@test`)
		)
	),


	`common-single_source@common@main`(
		kotlinId = commonMain
	),
	`common-single_source@common@test`(
		kotlinId = commonTest,
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),

	`common-single_source@android_native_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@android_native_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@android_native_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@android_native_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@ios_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@ios_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@ios_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@ios_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@ios_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@ios_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
 	`common-single_source@js@main`(
 		dependencies = Dependencies(
 			sourceSets = mutableSetOf(`common-single_source@common@main`)
 		)
 	),
 	`common-single_source@js@test`(
 		dependencies = Dependencies(
 			sourceSets = mutableSetOf(`common-single_source@common@test`)
 		)
 	),
	`common-single_source@jvm@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@jvm@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(
				`common-single_source@common@test`,
				`common-single_source@jvm@main`
			)
		)
	),
	`common-single_source@linux_arm32_hfp@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@linux_arm32_hfp@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@linux_mips32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@linux_mips32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@linux_mipsel32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@linux_mipsel32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@linux_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@linux_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@macos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@macos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@mingw_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@mingw_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@mingw_x86@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@mingw_x86@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@tvos_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@tvos_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@tvos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@tvos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
 	`common-single_source@wasm32@main`(
 		dependencies = Dependencies(
 			sourceSets = mutableSetOf(`common-single_source@common@main`)
 		)
 	),
 	`common-single_source@wasm32@test`(
 		dependencies = Dependencies(
 			sourceSets = mutableSetOf(`common-single_source@common@test`)
 		)
 	),
	`common-single_source@watchos_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@watchos_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@watchos_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@watchos_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@watchos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@watchos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),
	`common-single_source@watchos_x86@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@main`)
		)
	),
	`common-single_source@watchos_x86@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`common-single_source@common@test`)
		)
	),


	`library-multiple_sources@common@main`(
		kotlinId = commonMain,
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`common-single_source`
			)
		)
	),
	`library-multiple_sources@common@test`(
		kotlinId = commonTest
	),
	`library-multiple_sources@native@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@native@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@android_native_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@android_native_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@android_native_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@android_native_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@ios_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@ios_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@ios_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@ios_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@ios_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@ios_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@js@main`(
		dependencies = Dependencies(
//			targets = mutableSetOf(TargetEnum.`common-single_source@js`),
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@js@test`(
		dependencies = Dependencies(
//			targets = mutableSetOf(TargetEnum.`common-single_source@js`),
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@jvm@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@jvm@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@linux_arm32_hfp@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@linux_arm32_hfp@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@linux_mips32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@linux_mips32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@linux_mipsel32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@linux_mipsel32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@linux_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@linux_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@macos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@macos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@mingw_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@mingw_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@mingw_x86@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@mingw_x86@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@tvos_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@tvos_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@tvos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@tvos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@wasm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@wasm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@watchos_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@watchos_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@watchos_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@watchos_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@watchos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@watchos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),
	`library-multiple_sources@watchos_x86@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@main`)
		)
	),
	`library-multiple_sources@watchos_x86@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-multiple_sources@common@test`)
		)
	),


	`library-single_source@common@main`(
		kotlinId = commonMain,
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`common-single_source`
			)
		)
	),
	`library-single_source@common@test`(
		kotlinId = commonTest
	),
	`library-single_source@native@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@native@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@android_native_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@android_native_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@android_native_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@android_native_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@ios_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@ios_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@ios_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@ios_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@ios_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@ios_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@js@main`(
		dependencies = Dependencies(
//			targets = mutableSetOf(TargetEnum.`common-single_source@js`),
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@js@test`(
		dependencies = Dependencies(
//			targets = mutableSetOf(TargetEnum.`common-single_source@js`),
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@jvm@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@jvm@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@linux_arm32_hfp@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@linux_arm32_hfp@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@linux_mips32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@linux_mips32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@linux_mipsel32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@linux_mipsel32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@linux_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@linux_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@macos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@macos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@mingw_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@mingw_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@mingw_x86@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@mingw_x86@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@tvos_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@tvos_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@tvos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@tvos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@wasm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@wasm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@watchos_arm32@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@watchos_arm32@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@watchos_arm64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@watchos_arm64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@watchos_x64@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@watchos_x64@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),
	`library-single_source@watchos_x86@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@main`)
		)
	),
	`library-single_source@watchos_x86@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(`library-single_source@common@test`)
		)
	),


	`application-backend-js-express@js@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-backend-js-express@js@test`(),
	`application-backend-jvm-spring_boot@jvm@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-backend-jvm-spring_boot@jvm@test`(),
	`application-browser-js-spa-react@js@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-browser-js-spa-react@js@test`(),
	`application-browser-js-vanilla@js@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-browser-js-vanilla@js@test`(),
	`application-browser-native-wasm32@wasm32@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-browser-native-wasm32@wasm32@test`(),
	`application-desktop-jvm-tornado_fx@jvm@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-desktop-jvm-tornado_fx@jvm@test`(),
	`application-mobile-jvm-android@android@main`(
		kotlinId = "androidMain",
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-mobile-jvm-android@android@test`(
		kotlinId = "androidTest",
		// This is needed as an workaround to the this issue: https://youtrack.jetbrains.com/issue/KT-29343
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-mobile-native-apple-ios-ios_x64_without_framework@ios_x64@test`(),
	`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-mobile-native-apple-ios-ios_x64_copying_framework@ios_x64@test`(),
	`application-mobile-native-apple-ios-ios_x64_framework@ios_x64@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-mobile-native-apple-ios-ios_x64_framework@ios_x64@test`(),
	`application-mobile-native-apple-ios-ios_x64_with_framework@ios_x64@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-mobile-native-apple-ios-ios_x64_with_framework@ios_x64@test`(),
	`application-script-jvm-script@jvm@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-script-jvm-script@jvm@test`(),
	`application-television-native-apple-tvos-tvos_x64@tvos_x64@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-television-native-apple-tvos-tvos_x64@tvos_x64@test`(),
	`application-terminal-jvm-terminal@jvm@main`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(
				`common-single_source@jvm@main`,
				`common-multiple_sources@jvm@main`,
				`library-single_source@jvm@main`,
				`library-multiple_sources@jvm@main`
			)
		)
	),
	`application-terminal-jvm-terminal@jvm@test`(
		dependencies = Dependencies(
			sourceSets = mutableSetOf(
				`common-single_source@jvm@test`,
				`application-terminal-jvm-terminal@jvm@main`
			)
		)
	),
	`application-watch-native-apple-watchos-watchos_x64@watchos_x64@main`(
		dependencies = Dependencies(
			modules = mutableSetOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`,
				ModuleEnum.`library-single_source`,
				ModuleEnum.`library-multiple_sources`
			)
		)
	),
	`application-watch-native-apple-watchos-watchos_x64@watchos_x64@test`(),
	;

	/**
	 *
	 */
	var status: StatusEnum = defaultStatus
		set(value) {
			val caller = Thread.currentThread().stackTrace[2]
			println("Status update to ${value}. Source set ${this.name}. ${caller.className}#${caller.methodName}:${caller.lineNumber}")
			field = value
		}

	init {
		val splitName = name.split("@")

		if (compilation == null) compilation = CompilationEnum.getByName(splitName[2])

		if (kotlinId == null) {
			kotlinId = splitName[1].split("_").joinToString("") { it.capitalize() }.decapitalize().plus(splitName[2].capitalize())
		}

//		if (kotlinId == null) {
//			kotlinId = name.replace("@${compilation!!.id!!}", "").split("[@_-]".toRegex()).
//				joinToString("") { it.capitalize() }.decapitalize().plus(compilation!!.id!!.capitalize())
//		}

		println("""SourceSet "$name", kotlinId "$kotlinId".""")

		if (title == null) title = name.replace("_", " ").replace("[-@]".toRegex(), " -> ").
			split(" ".toRegex()).joinToString(" ") { it.capitalize() }

		if (description == null) description = "$title source set."

		if (module == null) module = ModuleEnum.getByName(splitName[0])

		if (module != null) module!!.sourceSets.add(this)

		if (name.split("@").size == 3) {
			if (target == null) target = TargetEnum.getByName("${splitName[0]}@${splitName[1]}")

			if (target != null) target!!.sourceSets.add(this)
		}

		if (StatusEnum.disabled == target?.status) {
			status = StatusEnum.disabled
		}

		maintainEnabledIfOSSupportsOrDisableOtherwise()

//		if (
//			StatusEnum.enabled == status
//			&& (target?.status == null || StatusEnum.enabled == target?.status)
//			&& StatusEnum.enabled == module!!.status
//		) {
//			dependencies?.modules?.forEach {
//				if (StatusEnum.enabled != it.status) {
//					it.status = StatusEnum.enabled
//					it.requiredAt.add(this)
//				}
//			}
//
//			dependencies?.targets?.forEach {
//				if (StatusEnum.enabled != it.status) {
//					if (it.enableIfOSSupportsOrDisableOtherwise()) {
//						it.module!!.status = StatusEnum.enabled
//						it.module!!.requiredAt.add(this)
//						it.requiredAt.add(this)
////						target!!.attributes.add(
////							Pair(
////								Attribute.of(String::class.java),
////								it.id!!
////							)
////						)
//					}
//				}
//			}
//
//			dependencies?.sourceSets?.forEach {
//				if (StatusEnum.enabled != it.status) {
//					if (it.enableIfOSSupportsOrDisableOtherwise()) {
//						it.target!!.status = StatusEnum.enabled
//						it.target!!.requiredAt.add(this)
//						it.module!!.status = StatusEnum.enabled
//						it.module!!.requiredAt.add(this)
//						it.requiredAt.add(this)
////						target!!.attributes.add(
////							Pair(
////								Attribute.of(String::class.java),
////								it.target!!.id!!
////							)
////						)
//					}
//				}
//			}
//		}
	}

	/**
	 *
	 */
	companion object {

		/**
		 *
		 */
		fun getByName(name: String?): SourceSetEnum? {
			if (name == null) return null

			for (item in values()) {
				if (item.name == name) {
					return item
				}
			}

			return null
		}

		/**
		 *
		 */
		fun getByKotlinIdAndModule(kotlinId: String?, module: ModuleEnum): SourceSetEnum? {
			if (kotlinId == null) return null

			for (item in values().filter { it.module == module }) {
				if (item.kotlinId == kotlinId) {
					return item
				}
			}

			return null
		}

		/**
		 *
		 */
		fun getByTargetAndCompilation(target: TargetEnum, compilation: CompilationEnum): SourceSetEnum? {
			for (item in values()) {
				if (
					item.target == target
					&& item.compilation == compilation
				) {
					return item
				}
			}

			return null
		}

		/**
		 *
		 */
		fun getMainByTarget(target: TargetEnum): SourceSetEnum? {
			return getByTargetAndCompilation(target, CompilationEnum.main)
		}

		/**
		 *
		 */
		fun getTestByTarget(target: TargetEnum): SourceSetEnum? {
			return getByTargetAndCompilation(target, CompilationEnum.test)
		}
	}

	/**
	 *
	 */
	fun maintainEnabledIfOSSupportsOrDisableOtherwise() {
		if (StatusEnum.enabled != status) return

		// We need to skip the common source sets since they are not attached to any target.
		if (kotlinId in listOf(commonMain, commonTest)) return

		if (target?.preset?.supportedOSes?.contains(Properties.util.os) != true) {
			status = StatusEnum.disabled
		}
	}

	/**
	 *
	 */
	override fun toString(): String {
		return "SourceSetEnum(" +
			"name=$name, " +
			"kotlinId=$kotlinId, " +
			"title=$title, " +
			"description=$description, " +
			"module=${module?.name}, " +
			"target=${target?.name}, " +
			"compilation=$compilation, " +
			"dependencies=$dependencies, " +
			"status=$status, " +
			"kotlinSourceSet=$kotlinSourceSet" +
			")"
	}
}

/**
 *
 */
class Dependencies(

	/**
	 *
	 */
	val modules: MutableSet<ModuleEnum> = mutableSetOf(),

	/**
	 *
	 */
	val targets: MutableSet<TargetEnum> = mutableSetOf(),

	/**
	 *
	 */
	val sourceSets: MutableSet<SourceSetEnum> = mutableSetOf(),

	/**
	 *
	 */
	val other: MutableSet<Any> = mutableSetOf()
) {

	/**
	 *
	 */
	override fun toString(): String {
		return "Dependencies(" +
			"modules=${modules.joinToString { it.name }}, " +
			"targets=${targets.joinToString { it.name }}, " +
			"sourceSets=${sourceSets.joinToString { it.name }}, " +
			"other=${other.joinToString { it.toString() }}" +
			")"
	}
}
