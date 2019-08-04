#!/bin/bash
cd ..

# Get new tags from remote
git fetch upstream --tags

# Get latest tag name
latestTag=$(git describe --tags `git rev-list --tags --max-count=1`)

# Checkout latest tag
git pull origin master
git pull upstream tags/$latestTag

