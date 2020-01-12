echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

JAVA_VERSION="8.0.202-zulufx"

echo "Installing Java $JAVA_VERSION:"
if [ "$BUILD_CI" == "APPVEYOR" ]; then
	echo "Skipping."
#	echo "Updating packages:"
#	choco install zip unzip curl sed
#
#	echo "Installing SDKMAN!"
#	curl -s "https://get.sdkman.io" | bash
#	source "$HOME/.sdkman/bin/sdkman-init.sh"
#
#	echo "Installing Java $JAVA_VERSION through SDKMAN!:"
#	sdk install java $JAVA_VERSION
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	echo "Updating packages:"
	apt-get update && apt install unzip zip curl sed -y

	echo "Installing SDKMAN!"
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"

	echo "Installing Java $JAVA_VERSION through SDKMAN!:"
	sdk install java $JAVA_VERSION
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	echo "Updating packages:"
#	brew install unzip zip curl sed

	echo "Installing SDKMAN!"
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"

	echo "Installing Java $JAVA_VERSION through SDKMAN!:"
	sdk install java $JAVA_VERSION
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi
