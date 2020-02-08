scriptDir=`dirname "$0"`

printf "All Builds:\n"
time $scriptDir/all_builds.sh

printf "\n\nAssertive Builds:\n"
time $scriptDir/assertive_builds.sh
