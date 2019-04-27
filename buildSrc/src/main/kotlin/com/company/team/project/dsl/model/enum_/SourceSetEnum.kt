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
	var dependencies: Dependencies? = null,

	/**
	 *
	 */
	var status: StatusEnum = StatusEnum.enabled,

	/**
	 *
	 */
	var kotlinSourceSet: KotlinSourceSet? = null,

	/**
	 *
	 */
	var requiredAt: MutableList<SourceSetEnum> = mutableListOf()
) {

	`common-multiple_sources@main@common`(
		status = StatusEnum.enabled,
		kotlinId = commonMain
	),
	`common-multiple_sources@test@common`(
		status = StatusEnum.enabled,
		kotlinId = commonTest
	),

	`common-multiple_sources@main@android_native_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@android_native_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@android_native_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@android_native_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@ios_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@ios_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@ios_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@ios_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@ios_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@ios_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@linux_arm32_hfp`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@linux_arm32_hfp`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@linux_mips32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@linux_mips32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@linux_mipsel32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@linux_mipsel32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@linux_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@linux_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@macos_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@macos_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@mingw_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@mingw_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),
	`common-multiple_sources@main@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@main@common`)
		)
	),
	`common-multiple_sources@test@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-multiple_sources@test@common`)
		)
	),


	`common-single_source@main@common`(
		status = StatusEnum.enabled,
		kotlinId = commonMain
	),
	`common-single_source@test@common`(
		status = StatusEnum.enabled,
		kotlinId = commonTest
	),

	`common-single_source@main@android_native_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@android_native_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@android_native_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@android_native_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@ios_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@ios_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@ios_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@ios_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@ios_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@ios_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@linux_arm32_hfp`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@linux_arm32_hfp`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@linux_mips32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@linux_mips32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@linux_mipsel32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@linux_mipsel32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@linux_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@linux_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@macos_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@macos_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@mingw_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@mingw_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),
	`common-single_source@main@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@main@common`)
		)
	),
	`common-single_source@test@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`common-single_source@test@common`)
		)
	),


	`library-multiple_sources@main@common`(
		status = StatusEnum.enabled,
		kotlinId = commonMain,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-multiple_sources`
				, ModuleEnum.`common-single_source`
			)
		)
	),
	`library-multiple_sources@test@common`(
		status = StatusEnum.enabled,
		kotlinId = commonTest
	),
	`library-multiple_sources@main@native`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@native`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@android_native_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@android_native_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@android_native_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@android_native_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@ios_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@ios_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@ios_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@ios_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@ios_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@ios_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
//			targets = mutableListOf(TargetEnum.`common-single_source@js`),
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
//			targets = mutableListOf(TargetEnum.`common-single_source@js`),
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@linux_arm32_hfp`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@linux_arm32_hfp`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@linux_mips32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@linux_mips32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@linux_mipsel32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@linux_mipsel32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@linux_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@linux_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@macos_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@macos_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@mingw_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@mingw_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),
	`library-multiple_sources@main@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@main@common`)
		)
	),
	`library-multiple_sources@test@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-multiple_sources@test@common`)
		)
	),


	`library-single_source@main@common`(
		status = StatusEnum.enabled,
		kotlinId = commonMain,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-multiple_sources`
				, ModuleEnum.`common-single_source`
			)
		)
	),
	`library-single_source@test@common`(
		status = StatusEnum.enabled,
		kotlinId = commonTest
	),
	`library-single_source@main@native`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@native`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@android_native_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@android_native_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@android_native_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@android_native_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@ios_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@ios_arm32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@ios_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@ios_arm64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@ios_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@ios_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
//			targets = mutableListOf(TargetEnum.`common-single_source@js`),
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
//			targets = mutableListOf(TargetEnum.`common-single_source@js`),
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@linux_arm32_hfp`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@linux_arm32_hfp`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@linux_mips32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@linux_mips32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@linux_mipsel32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@linux_mipsel32`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@linux_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@linux_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@macos_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@macos_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@mingw_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@mingw_x64`(
		status = StatusEnum.disabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),
	`library-single_source@main@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@main@common`)
		)
	),
	`library-single_source@test@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			sourceSets = mutableListOf(`library-single_source@test@common`)
		)
	),


	`application-backend-jvm-spring_boot@main@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-backend-jvm-spring_boot@test@jvm`(
		status = StatusEnum.enabled
	),
	`application-browser-js-spa-react@main@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-browser-js-spa-react@test@js`(
		status = StatusEnum.enabled
	),
	`application-browser-js-vanilla@main@js`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-browser-js-vanilla@test@js`(
		status = StatusEnum.enabled
	),
	`application-browser-native-wasm32@main@wasm32`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-browser-native-wasm32@test@wasm32`(
		status = StatusEnum.enabled
	),
	`application-desktop-jvm-tornado_fx@main@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-desktop-jvm-tornado_fx@test@jvm`(
		status = StatusEnum.enabled
	),
	`application-mobile-jvm-android@main@android`(
		status = StatusEnum.enabled,
		kotlinId = "androidMain",
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-mobile-jvm-android@test@android`(
		status = StatusEnum.enabled,
		kotlinId = "androidTest",
		// This is needed as an workaround to the this issue: https://youtrack.jetbrains.com/issue/KT-29343
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-mobile-native-apple-ios-ios_x64@main@ios_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-mobile-native-apple-ios-ios_x64@test@ios_x64`(
		status = StatusEnum.enabled
	),
	`application-mobile-native-apple-ios-ios_x64_copying_framework@main@ios_x64`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-mobile-native-apple-ios-ios_x64_copying_framework@test@ios_x64`(
		status = StatusEnum.enabled
	),
	`application-script-jvm-script@main@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			modules = mutableListOf(
				ModuleEnum.`common-single_source`,
				ModuleEnum.`common-multiple_sources`
			)
		)
	),
	`application-script-jvm-script@test@jvm`(
		status = StatusEnum.enabled
	),
	`application-terminal-jvm-terminal@main@jvm`(
		status = StatusEnum.enabled,
		dependencies = Dependencies(
			targets = mutableListOf(
				TargetEnum.`common-multiple_sources@jvm`
				, TargetEnum.`common-single_source@jvm`
			)
		)
	),
	`application-terminal-jvm-terminal@test@jvm`(
		status = StatusEnum.enabled
	),
	;

	init {
		val splitName = name.split("@")

		if (compilation == null) compilation = CompilationEnum.getByName(splitName[1])

		if (kotlinId == null) {
			kotlinId = splitName[2].split("_").joinToString("") { it.capitalize() }.decapitalize().plus(splitName[1].capitalize())
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
			if (target == null) target = TargetEnum.getByName("${splitName[0]}@${splitName[2]}")

			if (target != null) target!!.sourceSets.add(this)
		}

		if (StatusEnum.disabled == target?.status) {
			status = StatusEnum.disabled
		}

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
	fun enableIfOSSupportsOrDisableOtherwise(): Boolean {
		if (target?.preset?.supportedOSes?.contains(Properties.util.os) == true) {
			status = StatusEnum.enabled

			return true
		}

//		status = StatusEnum.enabled

		return false
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
	var modules: MutableList<ModuleEnum> = mutableListOf(),

	/**
	 *
	 */
	var targets: MutableList<TargetEnum> = mutableListOf(),

	/**
	 *
	 */
	var sourceSets: MutableList<SourceSetEnum> = mutableListOf(),

	/**
	 *
	 */
	var other: MutableList<Any> = mutableListOf()
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
