echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"
echo "Java:"
java -version

echo "Installing Android SDK:"
if [ "$BUILD_CI" == "APPVEYOR" ]; then
	echo "Skipping."
#	RMDIR "%ProgramFiles(x86)%\\Android\\android-sdk" /S /Q
#	appveyor DownloadFile https://dl.google.com/android/repository/sdk-tools-windows-4333796.zip
#	7z x sdk-tools-windows-4333796.zip -o"%ProgramFiles(x86)%\\Android\\android-sdk" > nul
#	echo off
#	yes | "%ProgramFiles(x86)%\\Android\\android-sdk\\tools\\bin\\sdkmanager.bat" --licenses
#	echo on
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	curl -L https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip -o $HOME/tools.zip
	unzip -q $HOME/tools.zip -d $ANDROID_HOME
	(echo y; echo y; echo y; echo y; echo y; echo y; echo y) | $ANDROID_HOME/tools/bin/sdkmanager --licenses
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	curl -L https://dl.google.com/android/repository/sdk-tools-darwin-4333796.zip -o $HOME/tools.zip
	unzip -q $HOME/tools.zip -d $ANDROID_HOME
	yes | $ANDROID_HOME/tools/bin/sdkmanager --licenses
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi
