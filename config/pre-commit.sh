#!/bin/sh
# this hook is in SCM so that it can be shared
# to install it, create a symbolic link in the projects .git/hooks folder
#
# from the root directory, run
# - $ ln -s ../../git-hooks/pre-commit.sh .git/hooks/pre-commit
#
# to skip the tests, run with the --no-verify argument
# - $ 'git commit --no-verify'

# stash any unstaged changes
git stash -q --keep-index

# run the task with the gradle wrapper
./gradlew spotlessCheck

# store the last exit code in a variable
RESULT=$?

# unstash the unstashed changes quietly
git stash pop -q

# return the gradle task exit code
exit $RESULT