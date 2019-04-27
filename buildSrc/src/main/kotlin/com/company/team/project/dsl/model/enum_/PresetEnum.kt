package com.company.team.project.dsl.model.enum_

import org.gradle.internal.os.OperatingSystem
import org.gradle.internal.os.OperatingSystem.FREE_BSD
import org.gradle.internal.os.OperatingSystem.LINUX
import org.gradle.internal.os.OperatingSystem.MAC_OS
import org.gradle.internal.os.OperatingSystem.SOLARIS
import org.gradle.internal.os.OperatingSystem.UNIX
import org.gradle.internal.os.OperatingSystem.WINDOWS
import org.jetbrains.kotlin.konan.target.KonanTarget

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
	var supportedOSes: MutableList<OperatingSystem> = mutableListOf()
) {

	android(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX,
			WINDOWS
		)
	),
	android_native_arm32(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX
		),
		konanTarget = KonanTarget.ANDROID_ARM32
	),
	android_native_arm64(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX
		),
		konanTarget = KonanTarget.ANDROID_ARM64
	),
	ios_arm32(
		supportedOSes = mutableListOf(
			MAC_OS
		),
		konanTarget = KonanTarget.IOS_ARM32
	),
	ios_arm64(
		supportedOSes = mutableListOf(
			MAC_OS
		),
		konanTarget = KonanTarget.IOS_ARM64
	),
	ios_x64(
		supportedOSes = mutableListOf(
			MAC_OS
		),
		konanTarget = KonanTarget.IOS_X64
	),
	js(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX,
			WINDOWS
		)
	),
	jvm(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX,
			WINDOWS
		)
	),
	linux_arm32_hfp(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			SOLARIS
		),
		konanTarget = KonanTarget.LINUX_ARM32_HFP
	),
	linux_mips32(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			SOLARIS
		),
		konanTarget = KonanTarget.LINUX_MIPS32
	),
	linux_mipsel32(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			SOLARIS
		),
		konanTarget = KonanTarget.LINUX_MIPSEL32
	),
	linux_x64(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			SOLARIS
		),
		konanTarget = KonanTarget.LINUX_X64
	),
	macos_x64(
		supportedOSes = mutableListOf(
			MAC_OS
		),
		konanTarget = KonanTarget.MACOS_X64
	),
	mingw_x64(
		supportedOSes = mutableListOf(
			WINDOWS
		),
		konanTarget = KonanTarget.MINGW_X64
	),
	wasm32(
		supportedOSes = mutableListOf(
			FREE_BSD,
			LINUX,
			MAC_OS,
			SOLARIS,
			UNIX,
			WINDOWS
		),
		konanTarget = KonanTarget.WASM32
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

	/**
	 *
	 */
	companion object {

		/**
		 *
		 */
		fun getByName(name: String?): PresetEnum? {
			if (name == null) return null

			for (item in PresetEnum.values()) {
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

			for (item in PresetEnum.values()) {
				if (item.id == id) {
					return item
				}
			}

			return null
		}
	}
}
