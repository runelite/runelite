#!/bin/bash


# Get new tags from remote
git fetch upstream --tags

# Get latest tag name
latestTag=$(git describe --tags `git rev-list --tags --max-count=1`)

# Checkout latest tag
git checkout tags/$latestTag
git pull upstream master

# Checkout master
git checkout master

