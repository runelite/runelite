#!/bin/bash

if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
	ssh-keyscan -t rsa $RUNELITE_BACKEND > ~/.ssh/known_hosts 2>/dev/null

	openssl aes-256-cbc -d -in travis/runelite.key.enc -out ~/.ssh/runelite -k $SECRET_KEY
	chmod 600 ~/.ssh/runelite

	set -o pipefail
	mvn clean deploy --settings travis/settings.xml | sed "s/$RUNELITE_BACKEND/REDACTED/g"
	exit
else
	mvn clean verify --settings travis/settings.xml
	exit
fi
