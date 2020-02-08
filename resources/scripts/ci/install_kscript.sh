echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

echo "Installing SDKMAN:"
if [ "$BUILD_CI" == "APPVEYOR" ]; then
	sdk install kscript
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	sdk install kscript
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	sdk install kscript
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi
