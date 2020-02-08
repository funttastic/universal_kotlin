printf "Relevant information:\n"
printf "=====================\n"

printf "Java:\n"
java -version

printf "Gradle:\n"
./gradlew --version

printf "SDKMAN!:\n"
sdk version

#printf "NVM:\n"
#nvm --version

printf "NodeJS:\n"
node --version

printf "NPM:\n"
npm --version

printf "Environment Variables:\n"
set +e
( set -o posix ; set ) | sort
set -e
