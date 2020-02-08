echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

echo "Installing SDKMAN:"
if [ "$BUILD_CI" == "APPVEYOR" ]; then
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi
