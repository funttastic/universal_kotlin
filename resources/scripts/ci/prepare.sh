set -e
trap 'last_command=$current_command; current_command=$BASH_COMMAND' DEBUG
trap 'echo "\"${last_command}\" command failed with exit code $?."' EXIT

echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

NVM_VERSION="0.35.2"
JAVA_VERSION="8.0.232.fx-zulu"

printf "\n\n"

if [ "$BUILD_CI" == "APPVEYOR" ]; then
	printf "Updating package manager:\n"
	choco upgrade chocolatey

	printf "Installing common packages from the package manager:\n"
	choco install zip nvm tree

	printf "Installing NVM:\n"
	cmd /c "call refreshenv"

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
	RMDIR "%ProgramFiles(x86)%\\Android\\android-sdk" /S /Q
	appveyor DownloadFile https://dl.google.com/android/repository/sdk-tools-windows-4333796.zip
	7z x sdk-tools-windows-4333796.zip -o"%ProgramFiles(x86)%\\Android\\android-sdk" > nul
	echo off
	yes | "%ProgramFiles(x86)%\\Android\\android-sdk\\tools\\bin\\sdkmanager.bat" --licenses
	echo on
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
	curl -L https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip -o $HOME/tools.zip
	unzip -q $HOME/tools.zip -d $ANDROID_HOME
	(echo y; echo y; echo y; echo y; echo y; echo y; echo y) | $ANDROID_HOME/tools/bin/sdkmanager --licenses
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
	sdk install java $JAVA_VERSION

	printf "Installing KScript:\n"
	sdk install kscript

	printf "Installing Android SDK:\n"
	curl -L https://dl.google.com/android/repository/sdk-tools-darwin-4333796.zip -o $HOME/tools.zip
	unzip -q $HOME/tools.zip -d $ANDROID_HOME
	yes | $ANDROID_HOME/tools/bin/sdkmanager --licenses
else
	printf "Unrecognized CI $BUILD_CI with OS $BUILD_OS.\n"
fi

printf "Relevant information:\n"
printf "=====================\n"

printf "Java:\n"
java -version

printf "Gradle:\n"
./gradlew --version

printf "Environment Variables:\n"
env

