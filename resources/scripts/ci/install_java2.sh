echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

JAVA_VERSION="8.0.232.fx-zulu"

echo "Installing Java $JAVA_VERSION:"
if [ "$BUILD_CI" == "APPVEYOR" ]; then
	sdk install java $JAVA_VERSION
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	sdk install java $JAVA_VERSION
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	sdk install java $JAVA_VERSION
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi
