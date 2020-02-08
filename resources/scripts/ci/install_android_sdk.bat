if exists %ANDROID_HOME% rd /q /s %ANDROID_HOME%
appveyor DownloadFile https://dl.google.com/android/repository/sdk-tools-windows-4333796.zip
7z x sdk-tools-windows-4333796.zip -o"%ProgramFiles(x86)%\\Android\\android-sdk" > nul
echo off
yes | "%ANDROID_HOME%\\tools\\bin\\sdkmanager.bat" --licenses
echo on
echo "After::::::"
echo %ANDROID_SDK_TOOLS_VERSION%
echo $ANDROID_SDK_TOOLS_VERSION
