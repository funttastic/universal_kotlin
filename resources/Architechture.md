Simplified architecture
=======================
application
	js
		spa
			angular
			react
			vue
		vanilla
	jvm
		android-jvm
		api
			spring-boot
		desktop
			tornado-fx?
		full_stack
			vaadin?
			jsf?
		terminal
		script
	native
		android-native
common
	common-js
		common-spa
			common-react
			common-angular
			common-vue
		common-vanilla
	common-jvm
	common-jvm-6
	common-jvm-8
		common-android (depends on common-mobile too)
		common-desktop
			common-swing?
			common-tornado_fx?
		common-dsl
		common-api
			common-spring_boot
		common-full_stack
			common-jsf?
			common-vaadin?
		common-script
		common-terminal
	common-mobile
	common-native
		common-android-native (depends on common-mobile)
		common-apple
			common-ios (depends on common-mobile)
				common-iphone
				common-ipad
			common-macos
				common-imac
			common-tvos
				common-apple-tv
		common-linux
			common-raspeberrypi
		common-stm32
		common-web_assembly
		common-windows
library
	js
	jvm
	native
		android-native
		linux
		macos
		windows


Complete common architecture
=====================
common
	common-js
		common-js-node
		common-spa
			common-react
			common-angular
			common-vue
		common-vanilla
	common-jvm
		common-android (depends on common-mobile too)
		common-desktop
			common-swing
			common-tornado_fx
		common-dsl
		common-api
			common-spring_boot
		common-full_stack
			common-vaadin
		common-script
		common-terminal
	common-mobile
	common-native
		common-android-native (depends on common-mobile)
		common-apple
			common-ios (depends on common-mobile)
			common-macos
			common-tvos
		common-arm32
			common-linux-arm32 (depends on common-linux too)
				common-android-arm32 (depends on common-android-native too)
				common-arm32_hfp
					common-raspeberrypi
			common-ios-arm32 (depends on common-ios too)
				common-iphone-32
		common-arm64
			common-linux-arm64 (depends on common-linux too)
				common-android-arm64 (depends on common-android-native too)
			common-ios-arm64 (depends on common-ios too)
				common-iphone
				common-ipad
				common-ios?
		common-linux
		common-mingw
			common-mingw-windows (see common-windows)
		common-mips
			common-linux-mips (depends on common-linux too)
			common-linux-mipsel32 (depends on common-linux too)
		common-x86_64
			common-linux-x86_64 (depends on common-linux too)
			common-ios-x64 (depends on common-ios too)
				common-iphone_simulator
			common-macos-x86_64 (depends on common-macos too)
				common-macbook
				common-macos?
				common-imac
			common-windows-x86_64 (depends on common-mingw-windows)
		common-stm32
			common-zephyr_stm32f4_disco
		common-wasm32
		common-windows

see:
	https://kotlinlang.org/docs/reference/native-overview.html
	https://kotlinlang.org/docs/tutorials/native/targeting-multiple-platforms.html (most important)
