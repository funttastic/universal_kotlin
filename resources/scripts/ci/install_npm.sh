echo "CI: $BUILD_CI"
echo "OS: $BUILD_OS"

if [ "$BUILD_CI" == "APPVEYOUR" ]; then
	echo "Installing NPM:"
#	npm install -g npm
elif [ "$BUILD_CI" == "CIRCLE_CI" ]; then
	echo "Installing NPM:"
#	npm install -g npm
elif [ "$BUILD_CI" == "TRAVIS" ]; then
	echo "Installing NPM:"
	npm install -g npm
else
	echo "Unrecognized CI $BUILD_CI with OS $BUILD_OS."
fi
