echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

echo "Installing and updating system packages:"
if [ "$BUILD_CI" == "APPVEYOR" ]; then
	choco upgrade chocolatey
	choco install nvm zip

	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	apt update
	apt install unzip zip curl sed -y

	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	brew upgrade
#	brew install unzip zip curl sed

	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi
