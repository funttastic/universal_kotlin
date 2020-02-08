set -e
trap 'last_command=$current_command; current_command=$BASH_COMMAND' DEBUG
trap 'echo "\"${last_command}\" command finshied with exit code $?."' EXIT

echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

NVM_VERSION="0.35.2"
JAVA_VERSION="8.0.232.fx-zulu"
ANDROID_SDK_TOOLS_URL_PREFIX="https://dl.google.com/android/repository/sdk-tools"
ANDROID_SDK_TOOLS_VERSION="4333796"

printf "\n\n"

if [ "$BUILD_CI" == "APPVEYOR" ]; then
	printf "Updating package manager:\n"
	choco upgrade chocolatey

	printf "Installing common packages from the package manager:\n"
	choco install zip nvm nodejs tree

#	printf "Installing NVM:\n"
#	cmd "/C refreshenv"
#	nvm --version

	printf "Installing latest NodeJS:\n"
	node --version

	printf "Installing latest NPM:\n"
	npm install -g npm

	printf "Installing SDKMAN!:\n"
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version

	printf "Installing Java $JAVA_VERSION:\n"
	sdk install java $JAVA_VERSION

	printf "Installing KScript:\n"
	sdk install kscript

	printf "Installing Android SDK:\n"
	if [ -d "$ANDROID_HOME" ]; then
		rm -rf "$ANDROID_HOME";
	fi
	mkdir -p "$ANDROID_HOME"
	curl -L "$ANDROID_SDK_TOOLS_URL_PREFIX-windows-$ANDROID_SDK_TOOLS_VERSION.zip" -o "$HOME/tools.zip"
	unzip -q "$HOME/tools.zip" -d "$ANDROID_HOME"
	(echo y; echo y; echo y; echo y; echo y; echo y; echo y) | "$ANDROID_HOME/tools/bin/sdkmanager.bat" --licenses
	rm -rf "$HOME/tools.zip"

	printf "Installing Gradle:\n"
	./gradlew --stacktrace --version
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	printf "Updating package manager:\n"
	apt update

	printf "Installing common packages from the package manager:\n"
	apt install unzip zip curl sed -y

	printf "Installing NVM:\n"
	curl -o- "https://raw.githubusercontent.com/nvm-sh/nvm/v$NVM_VERSION/install.sh" | bash
	[[ -s $HOME/.nvm/nvm.sh ]] && . $HOME/.nvm/nvm.sh

	printf "Installing latest NodeJS:\n"
	nvm install node

	printf "Installing latest NPM:\n"
	npm install -g npm

	printf "Installing SDKMAN!:\n"
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version

	printf "Installing Java $JAVA_VERSION:\n"
	sdk install java $JAVA_VERSION

	printf "Installing KScript:\n"
	sdk install kscript

	printf "Installing Android SDK:\n"
	if [ -d "$ANDROID_HOME" ]; then
		rm -rf "$ANDROID_HOME";
	fi
	mkdir -p "$ANDROID_HOME"
	curl -L "$ANDROID_SDK_TOOLS_URL_PREFIX-linux-$ANDROID_SDK_TOOLS_VERSION.zip" -o "$HOME/tools.zip"
	unzip -q "$HOME/tools.zip" -d "$ANDROID_HOME"
	(echo y; echo y; echo y; echo y; echo y; echo y; echo y) | "$ANDROID_HOME/tools/bin/sdkmanager.bat" --licenses
	rm -rf "$HOME/tools.zip"

	printf "Installing Gradle:\n"
	./gradlew --stacktrace --version
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	printf "Updating package manager:\n"
	echo "Skipping upgrade."
#	brew upgrade

	printf "Installing common packages from the package manager:\n"
	printf "Skipping packages installation."
#	brew install unzip zip curl sed

	printf "Installing NVM:\n"
	curl -o- "https://raw.githubusercontent.com/nvm-sh/nvm/v$NVM_VERSION/install.sh" | bash
	[[ -s $HOME/.nvm/nvm.sh ]] && . $HOME/.nvm/nvm.sh

	printf "Installing latest NodeJS:\n"
	nvm install node

	printf "Installing latest NPM:\n"
	npm install -g npm

	printf "Installing SDKMAN!:\n"
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version

	printf "Installing Java $JAVA_VERSION:\n"
	set +e # In this CI the Repackaging command was failing without a reason.
	sdk install java $JAVA_VERSION
	set -e

	printf "Installing KScript:\n"
	sdk install kscript

	printf "Installing Android SDK:\n"
	if [ -d "$ANDROID_HOME" ]; then
		rm -rf "$ANDROID_HOME";
	fi
	mkdir -p "$ANDROID_HOME"
	curl -L "$ANDROID_SDK_TOOLS_URL_PREFIX-darwin-$ANDROID_SDK_TOOLS_VERSION.zip" -o "$HOME/tools.zip"
	unzip -q "$HOME/tools.zip" -d "$ANDROID_HOME"
	(echo y; echo y; echo y; echo y; echo y; echo y; echo y) | "$ANDROID_HOME/tools/bin/sdkmanager.bat" --licenses
	rm -rf "$HOME/tools.zip"

	printf "Installing Gradle:\n"
	./gradlew --stacktrace --version
else
	printf "Unrecognized CI $BUILD_CI with OS $BUILD_OS.\n"
fi
