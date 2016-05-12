#!/bin/bash

JAVA_ARGS="-ea -Xmx512m"

echo RS client $RS_CLIENT_PATH
echo Deobfuscator at $DEOB_PATH
echo Vanilla at $VANILLA_PATH

JAV_CONFIG=/tmp/jav_config.ws
VANILLA=/tmp/vanilla.jar
VANILLA_INJECTED=/tmp/vanilla_injected.jar

# get version of vanilla
VANILLA_VER=$(java -cp $DEOB_PATH net.runelite.deob.clientver.ClientVersionMain $VANILLA_PATH)
echo "Vanilla client version $VANILLA_VER"

# inject vanilla client.
rm -f $VANILLA_INJECTED
java $JAVA_ARGS -cp $DEOB_PATH net.runelite.deob.updater.UpdateInject $RS_CLIENT_PATH $VANILLA_PATH $VANILLA_INJECTED
if [ $? -ne 0 ] ; then
        exit 1
fi

# Unpack so maven can pick this up as a built artifact
rm -rf /tmp/runelite-work
mkdir /tmp/runelite-work
cd /tmp/runelite-work
jar xf $VANILLA_INJECTED
cd -
