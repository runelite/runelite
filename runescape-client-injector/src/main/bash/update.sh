#!/bin/bash

JAVA_ARGS="-ea -Xmx512m"

DEOB_PATH=`echo $DEOB_PATH | sed 's/\.jar$/-jar-with-dependencies.jar/'`

echo RS client $RS_CLIENT_PATH
echo Deobfuscator at $DEOB_PATH

JAV_CONFIG=/tmp/jav_config.ws
VANILLA=/tmp/vanilla.jar
VANILLA_INJECTED=/tmp/vanilla_injected.jar

curl -L oldschool.runescape.com/jav_config.ws > $JAV_CONFIG

CODEBASE=$(grep codebase $JAV_CONFIG | cut -d'=' -f2)
INITIAL_JAR=$(grep initial_jar $JAV_CONFIG | cut -d'=' -f2)
JAR_URL=$CODEBASE$INITIAL_JAR

echo Downloading vanilla client from $JAR_URL

#rm -f $VANILLA
#wget $JAR_URL -O $VANILLA

# get version of vanilla
VANILLA_VER=$(java -cp $DEOB_PATH net.runelite.deob.clientver.ClientVersionMain $VANILLA)
echo "Vanilla client version $VANILLA_VER"

# inject vanilla client.
rm -f $VANILLA_INJECTED
java $JAVA_ARGS -cp $DEOB_PATH net.runelite.deob.updater.UpdateInject $RS_CLIENT_PATH $VANILLA $VANILLA_INJECTED

rm -rf /tmp/runelite-work
mkdir /tmp/runelite-work
cd /tmp/runelite-work
jar xf $VANILLA_INJECTED
cd -
