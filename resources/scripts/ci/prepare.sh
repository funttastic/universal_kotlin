set -e
trap 'last_command=$current_command; current_command=$BASH_COMMAND' DEBUG
trap 'echo "\"${last_command}\" command failed with exit code $?."' EXIT

echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

JAVA_VERSION="8.0.232.fx-zulu"

if [ "$BUILD_CI" == "APPVEYOR" ]; then
	echo "Updating package manager:"
	choco upgrade chocolatey

	echo "Installing common packages from the package manager:"
	choco install nvm zip

	echo "Installing latest NodeJS:"
	nvm install node

	echo "Installing latest NPM:"
	npm install -g npm

	echo "Installing SDKMAN!:"
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version

	echo "Installing Java $JAVA_VERSION:"
	sdk install java $JAVA_VERSION

	echo "Installing KScript:"
	sdk install kscript

	echo "Installing Android SDK:"
	RMDIR "%ProgramFiles(x86)%\\Android\\android-sdk" /S /Q
	appveyor DownloadFile https://dl.google.com/android/repository/sdk-tools-windows-4333796.zip
	7z x sdk-tools-windows-4333796.zip -o"%ProgramFiles(x86)%\\Android\\android-sdk" > nul
	echo off
	yes | "%ProgramFiles(x86)%\\Android\\android-sdk\\tools\\bin\\sdkmanager.bat" --licenses
	echo on
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	echo "Updating package manager:"
	apt update

	echo "Installing common packages from the package manager:"
	apt install unzip zip curl sed -y

	echo "Installing latest NodeJS:"
	nvm install node

	echo "Installing latest NPM:"
	npm install -g npm

	echo "Installing SDKMAN!:"
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version

	echo "Installing Java $JAVA_VERSION:"
	sdk install java $JAVA_VERSION

	echo "Installing KScript:"
	sdk install kscript

	echo "Installing Android SDK:"
	curl -L https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip -o $HOME/tools.zip
	unzip -q $HOME/tools.zip -d $ANDROID_HOME
	(echo y; echo y; echo y; echo y; echo y; echo y; echo y) | $ANDROID_HOME/tools/bin/sdkmanager --licenses
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	echo "Updating package manager:"
	brew upgrade

	echo "Installing common packages from the package manager:"
	echo "Nothing to install"
#	brew install unzip zip curl sed

	echo "Installing latest NodeJS:"
	nvm install node

	echo "Installing latest NPM:"
	npm install -g npm

	echo "Installing SDKMAN!:"
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk version

	echo "Installing Java $JAVA_VERSION:"
	sdk install java $JAVA_VERSION

	echo "Installing KScript:"
	sdk install kscript

	echo "Installing Android SDK:"
	curl -L https://dl.google.com/android/repository/sdk-tools-darwin-4333796.zip -o $HOME/tools.zip
	unzip -q $HOME/tools.zip -d $ANDROID_HOME
	yes | $ANDROID_HOME/tools/bin/sdkmanager --licenses
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi

echo "Relevant information:"
echo "====================="

echo "Java:"
java -version

echo "Gradle:"
./gradlew --version

echo "Environment Variables:"
env

