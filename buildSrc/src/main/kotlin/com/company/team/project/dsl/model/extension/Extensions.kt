package com.company.team.project.dsl.model.extension

import com.company.team.project.dsl.Util
import com.company.team.project.dsl.model.enum_.*
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.attributes.Attribute
import org.gradle.api.attributes.AttributeContainer
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.*
import java.lang.RuntimeException

/**
 *
 */
@Suppress("unchecked_cast", "nothing_to_inline")
internal
inline fun <T> uncheckedCast(target: Any?): T =
	target as T

/**
 *
 */
fun AttributeContainer.attribute(pair: Pair<Attribute<String>, String>) {
	attribute(pair.first, pair.second)
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.js(
	target: TargetEnum,
	configure: KotlinOnlyTarget<KotlinJsCompilation>.() -> Unit = { }
): KotlinOnlyTarget<KotlinJsCompilation>? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.jvm(
	target: TargetEnum,
	configure: KotlinOnlyTarget<KotlinJvmCompilation>.() -> Unit = { }
): KotlinOnlyTarget<KotlinJvmCompilation>? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.android(
	target: TargetEnum,
	configure: KotlinAndroidTarget.() -> Unit = { }
): KotlinAndroidTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.androidNativeArm32(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.androidNativeArm64(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.iosArm32(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.iosArm64(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.iosX64(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.linuxX64(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.linuxArm32Hfp(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.linuxMips32(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.linuxMipsel32(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.macosX64(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.mingwX64(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.wasm32(
	target: TargetEnum,
	configure: KotlinNativeTarget.() -> Unit = { }
): KotlinNativeTarget? {
	return uncheckedCast(configureTarget(target, uncheckedCast(configure)))
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.configureTarget(target: TargetEnum, configuration: (AbstractKotlinTarget.() -> Unit) = {}): KotlinTarget? {
	if (StatusEnum.enabled != target.status) {
		Util.logger.warn("""Skipping target "${target.name}" of module "${target.module?.name ?: "unknown"}", since it is disabled.""")

		return null
	}

	val id = target.kotlinId!!

	target.kotlinTarget = when(target.preset) {
		PresetEnum.android -> android(id, configuration as KotlinAndroidTarget.() -> Unit)
		PresetEnum.android_native_arm32 -> androidNativeArm32(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.android_native_arm64 -> androidNativeArm64(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.ios_arm32 -> iosArm32(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.ios_arm64 -> iosArm64(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.ios_x64 -> iosX64(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.linux_arm32_hfp -> linuxArm32Hfp(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.linux_mips32 -> linuxMips32(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.linux_mipsel32 -> linuxMipsel32(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.linux_x64 -> linuxX64(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.macos_x64 -> macosX64(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.mingw_x64 -> mingwX64(id, configuration as KotlinNativeTarget.() -> Unit)
		PresetEnum.js -> js(id, configuration as KotlinOnlyTarget<KotlinJsCompilation>.() -> Unit)
		PresetEnum.jvm -> jvm(id, configuration as KotlinOnlyTarget<KotlinJvmCompilation>.() -> Unit)
		PresetEnum.wasm32 -> wasm32(id, configuration as KotlinNativeTarget.() -> Unit)
		else -> throw IllegalArgumentException("""Unknown preset "${target.preset?.name ?: "unknown"} for target "${target.name}" in module "${target.module?.name ?: "unknown"}"""")
	}

	return target.kotlinTarget
}

/**
 *
 */
fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.configureTargetAttributes(module: ModuleEnum) {
	targets.all {
		TargetEnum.getByKotlinIdAndModule(targetName, module)?.attributes?.forEach {
			attributes.attribute(it)
		}
	}
}

/**
 *
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.configureSourceSet(target: TargetEnum, compilation: CompilationEnum, configuration: KotlinSourceSet.() -> Unit): KotlinSourceSet? {
	if (StatusEnum.enabled != target.status) {
		Util.logger.warn("""Not getting "${compilation.name}" source set of target "${target.name}", since the target is disabled.""")

		return null
	}

	val sourceSet = SourceSetEnum.getByTargetAndCompilation(target, compilation)

	if (sourceSet == null) {
		Util.logger.warn(""""Not getting ${compilation.name}" source set of target "${target.name}", since the source set was not found.""")

		return null
	}

	if (sourceSet.kotlinSourceSet == null) {
		sourceSet.kotlinSourceSet = configureSourceSet(sourceSet, configuration)
	}

	return sourceSet.kotlinSourceSet
}

/**
 *
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.configureMainSourceSet(target: TargetEnum, configuration: KotlinSourceSet.() -> Unit): KotlinSourceSet? {
	return configureSourceSet(target, CompilationEnum.main, configuration)
}

/**
 *
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.configureTestSourceSet(target: TargetEnum, configuration: KotlinSourceSet.() -> Unit): KotlinSourceSet? {
	return configureSourceSet(target, CompilationEnum.test, configuration)
}

/**
 *
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.getOrConfigureSourceSet(sourceSet: SourceSetEnum, configuration: (KotlinSourceSet.() -> Unit) = {}): KotlinSourceSet? {
	return getSourceSet(sourceSet) ?: configureSourceSet(sourceSet, configuration)
}

/**
 *
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.getSourceSet(sourceSet: SourceSetEnum): KotlinSourceSet? {
	if (StatusEnum.enabled != sourceSet.status) {
		Util.logger.warn("""Not getting source set "${sourceSet.name}", since it's disabled.""")

		return null
	}

	if (sourceSet.kotlinSourceSet == null) {
		sourceSet.kotlinSourceSet = get(sourceSet.kotlinId.toString())
	}

	return sourceSet.kotlinSourceSet
}

fun KotlinDependencyHandler.project(module: ModuleEnum, configuration: String? = null): ProjectDependency {
	val path = ":${module.kotlinId!!}"

	return uncheckedCast(
		project(
			if (configuration != null) mapOf("path" to path, "configuration" to configuration)
			else mapOf("path" to path)
		)
	)
}

fun DependencyHandler.project(module: ModuleEnum, configuration: String? = null): ProjectDependency {
	val path = ":${module.kotlinId!!}"

	return uncheckedCast(
		project(
			if (configuration != null) mapOf("path" to path, "configuration" to configuration)
			else mapOf("path" to path)
		)
	)
}

fun KotlinDependencyHandler.project(target: TargetEnum, configuration: String? = null): ProjectDependency {
	val path = ":${target.module!!.kotlinId!!}"

	return uncheckedCast(
		project(
			if (configuration != null) mapOf("path" to path, "configuration" to configuration)
			else mapOf("path" to path)
		)
	)
}

fun DependencyHandler.project(target: TargetEnum, configuration: String? = null): ProjectDependency {
	val path = ":${target.module!!.kotlinId!!}"

	return uncheckedCast(
		project(
			if (configuration != null) mapOf("path" to path, "configuration" to configuration)
			else mapOf("path" to path)
		)
	)
}

fun KotlinDependencyHandler.project(sourceSet: SourceSetEnum, configuration: String? = null): ProjectDependency {
	val path = ":${sourceSet.module!!.kotlinId!!}"

	return uncheckedCast(
		project(
			if (configuration != null) mapOf("path" to path, "configuration" to configuration)
			else mapOf("path" to path)
		)
	)
}

fun DependencyHandler.project(sourceSet: SourceSetEnum, configuration: String? = null): ProjectDependency {
	val path = ":${sourceSet.module!!.kotlinId!!}"

	return uncheckedCast(
		project(
			if (configuration != null) mapOf("path" to path, "configuration" to configuration)
			else mapOf("path" to path)
		)
	)
}

/**
 *
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.configureSourceSet(sourceSet: SourceSetEnum, configuration: KotlinSourceSet.() -> Unit): KotlinSourceSet? {
	if (StatusEnum.enabled != sourceSet.status) {
		Util.logger.warn("""Not configuring source set "${sourceSet.name}", since it's disabled.""")

		return null
	}

	val modulesAndTargetsConfigurations: KotlinSourceSet.() -> Unit = {
		sourceSet.dependencies?.sourceSets?.forEach {
			Util.logger.warn("""The sourceSet "${sourceSet.name}" depends on the sourceSet "${it.name}."""")
			dependsOn(it.kotlinSourceSet!!)
		}

		dependencies {
			sourceSet.dependencies?.modules?.forEach {
				Util.logger.warn("""The sourceSet "${sourceSet.name}" depends on the module "${it.name}."""")
				implementation(project(it))
			}

			sourceSet.dependencies?.targets?.forEach {
				Util.logger.warn("""The sourceSet "${sourceSet.name}" depends on the target "${it.name}."""")
				implementation(project(it))
			}
		}
	}

	val mergedConfiguration : KotlinSourceSet.() -> Unit = {
		configuration()
		modulesAndTargetsConfigurations()
	}

	if (findByName(sourceSet.kotlinId.toString()) == null) {
		sourceSet.kotlinSourceSet = create(sourceSet.kotlinId.toString(), mergedConfiguration)
	} else {
		sourceSet.kotlinSourceSet = getByName(sourceSet.kotlinId.toString(), mergedConfiguration)
	}

	return sourceSet.kotlinSourceSet
}

fun kotlinNativeTarget(configure: KotlinNativeTarget.() -> Unit): KotlinNativeTarget.() -> Unit {
	return configure
}

val Project.module: ModuleEnum
	get() = ModuleEnum.getByPath(projectDir)
		?: throw RuntimeException("""It wasn't possible to find the module with the path "$projectDir".""")

fun DependencyHandlerScope.configureDependencies(sourceSet: SourceSetEnum) {
	val configurationName = if (CompilationEnum.main == sourceSet.compilation) {"implementation"} else {"testImplementation"}

//	sourceSet.dependencies?.sourceSets?.forEach {
//		dependsOn(it.kotlinSourceSet!!)
//	}

	sourceSet.dependencies?.modules?.forEach {
		Util.logger.warn("""The sourceSet "${sourceSet.name}" depends on the module "${it.name}."""")
		configurationName(project(it))
	}

	sourceSet.dependencies?.targets?.forEach {
		Util.logger.warn("""The sourceSet "${sourceSet.name}" depends on the target "${it.name}."""")
		configurationName(project(it))
	}
}
