#!/bin/bash

JAVA="java -cp target/deob-1.0-SNAPSHOT-jar-with-dependencies.jar"

$JAVA net.runelite.deob.updater.UpdateDetector /tmp/rsupdate
if [ $? -ne 0 ] ; then
        exit
fi
