echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"
echo "Java:"
java -version

echo "Installing Android SDK:"
RMDIR "%ProgramFiles(x86)%\\Android\\android-sdk" /S /Q
appveyor DownloadFile https://dl.google.com/android/repository/sdk-tools-windows-4333796.zip
7z x sdk-tools-windows-4333796.zip -o"%ProgramFiles(x86)%\\Android\\android-sdk" > nul
echo off
yes | "%ProgramFiles(x86)%\\Android\\android-sdk\\tools\\bin\\sdkmanager.bat" --licenses
echo on
