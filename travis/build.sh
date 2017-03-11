#!/bin/bash

if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
	mvn clean deploy --settings travis/settings.xml
else
	mvn clean verify --settings travis/settings.xml
fi
