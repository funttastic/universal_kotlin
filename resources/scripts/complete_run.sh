set -e
trap 'last_command=$current_command; current_command=$BASH_COMMAND' DEBUG
trap 'echo "\"${last_command}\" command finshied with exit code $?."' EXIT

scriptDir=`dirname "$0"`

printf "All Builds:\n"
time $scriptDir/all_builds.sh

printf "\n\nAssertive Builds:\n"
time $scriptDir/assertive_builds.sh
