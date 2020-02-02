package com.company.team.project.dsl.model.enum_

import org.gradle.internal.os.OperatingSystem
import org.gradle.internal.os.OperatingSystem.*
import org.jetbrains.kotlin.konan.target.KonanTarget
import com.company.team.project.dsl.model.Properties.util.os

/**
 *
 */
@Suppress("INACCESSIBLE_TYPE")
enum class PresetEnum (

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
	var description: String? = null,

	/**
	 *
	 */
	var konanTarget: KonanTarget? = null,

	/**
	 *
	 */
	val supportedOSes: MutableSet<OperatingSystem> = mutableSetOf()
) {

	android(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX,
			WINDOWS
		)
	),
	android_native_arm32(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX
		),
		konanTarget = KonanTarget.ANDROID_ARM32
	),
	android_native_arm64(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX
		),
		konanTarget = KonanTarget.ANDROID_ARM64
	),
	ios_arm32(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.IOS_ARM32
	),
	ios_arm64(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.IOS_ARM64
	),
	ios_x64(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.IOS_X64
	),
	js(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX,
			WINDOWS
		)
	),
	jvm(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX,
			WINDOWS
		)
	),
	linux_arm32_hfp(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			SOLARIS
		),
		konanTarget = KonanTarget.LINUX_ARM32_HFP
	),
	linux_mips32(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			SOLARIS
		),
		konanTarget = KonanTarget.LINUX_MIPS32
	),
	linux_mipsel32(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			SOLARIS
		),
		konanTarget = KonanTarget.LINUX_MIPSEL32
	),
	linux_x64(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			SOLARIS
		),
		konanTarget = KonanTarget.LINUX_X64
	),
	macos_x64(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.MACOS_X64
	),
	mingw_x64(
		supportedOSes = mutableSetOf(
			WINDOWS
		),
		konanTarget = KonanTarget.MINGW_X64
	),
	mingw_x86(
		supportedOSes = mutableSetOf(
			WINDOWS
		),
		konanTarget = KonanTarget.MINGW_X86
	),
	tvos_arm64(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.TVOS_ARM64
	),
	tvos_x64(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.TVOS_X64
	),
	wasm32(
		supportedOSes = mutableSetOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX,
			WINDOWS
		),
		konanTarget = KonanTarget.WASM32
	),
	watchos_arm32(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.WATCHOS_ARM32
	),
	watchos_arm64(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.WATCHOS_ARM64
	),
	watchos_x64(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.WATCHOS_X64
	),
	watchos_x86(
		supportedOSes = mutableSetOf(
			MAC_OS
		),
		konanTarget = KonanTarget.WATCHOS_X86
	),
	;

	/**
	 *
	 */
	init {
		if (id == null) id = name.split("[_]".toRegex()).joinToString("") { it.capitalize() }.decapitalize()

		if (title == null) title = name.replace("_", " ").replace("-", " -> ").
			split(" ".toRegex()).joinToString(" ") { it.capitalize() }

		if (description == null) description = "$title preset."
	}

	val isSupportedByOs by lazy { os in supportedOSes }

	/**
	 *
	 */
	companion object {

		/**
		 *
		 */
		fun getByName(name: String?): PresetEnum? {
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
		fun getById(id: String?): PresetEnum? {
			if (id == null) return null

			for (item in values()) {
				if (item.id == id) {
					return item
				}
			}

			return null
		}
	}
}
