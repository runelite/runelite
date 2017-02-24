#!/bin/bash

if [ "$#" -ne 2 ] ; then
	exit 1
fi

echo "Deploying vanilla version $1 ($2) to $RUNELITE_REPOSITORY_URL"

mvn deploy:deploy-file -DgroupId=net.runelite.rs -DartifactId=vanilla -Dversion=$1 -Dfile=$2 -DrepositoryId=runelite -Durl=$RUNELITE_REPOSITORY_URL
