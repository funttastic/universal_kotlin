echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

echo "Installing and updating system packages:"
if [ "$BUILD_CI" == "APPVEYOR" ]; then
	echo "Skipping"
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	apt-get update && apt install unzip zip curl sed -y
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	brew install unzip zip curl sed
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi
