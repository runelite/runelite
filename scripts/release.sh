#!/bin/bash

if [ "$#" -ne 1 ] ; then
	exit 1
fi

echo "Releasing version $1"

VANILLA_VER=$1

cd ..

pushd runescape-client
find src/main/java -maxdepth 1 -name "*.java" -printf "%f\n" | sed 's/\.java$//'  > src/main/resources/classes.txt
git add src/main/resources/classes.txt
popd

# bump versions
find . -name pom.xml -exec sed -i "s/<version>.*<\/version>.*rs version.*/<version>$VANILLA_VER.1-SNAPSHOT<\/version> <!-- rs version -->/" {} \;

pushd runescape-client-injector
# update vanilla jar version for injector
mvn -U versions:use-latest-versions -DincludesList=net.runelite.rs:vanilla:jar
if [ $? -ne 0 ] ; then
  exit 1
fi
popd

find . -name pom.xml -exec git add {} \;

git commit -m "Update $VANILLA_VER"

mvn release:clean release:prepare release:perform -Darguments="-DskipTests" -B
