#!/bin/bash

JAVA="java -cp target/deob-1.0-SNAPSHOT-jar-with-dependencies.jar"
DEOBFUSCATOR_REPO=/home/runelite/jbytecode
RS_CLIENT_REPO=/home/runelite/rs2-client
M2_REPOSITORY=/home/runelite/.m2/repository
FERNFLOWER_JAR=/home/runelite/fernflower/fernflower.jar

# Find latest deobfuscator
DEOB_VER=$(mvn -f $DEOBFUSCATOR_REPO/pom.xml org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -e '^[[:digit:]]')
DEOB_JAR="$M2_REPOSITORY/net/runelite/deob/$DEOB_VER/deob-$DEOB_VER-jar-with-dependencies.jar"

# Update deobfuscator
cd $DEOBFUSCATOR_REPO
git pull
#mvn install -Dmaven.test.skip=true

# Find latest client
RS_CLIENT_VER=$(mvn -f $RS_CLIENT_REPO/pom.xml org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -e '^[[:digit:]]')
RS_CLIENT_JAR="$M2_REPOSITORY/net/runelite/rs/rs-client/$RS_CLIENT_VER/rs-client-$RS_CLIENT_VER.jar"

# Update latest client
cd $RS_CLIENT_REPO
git pull
#mvn install -Dmaven.test.skip=true

echo Deobfuscator version $DEOB_VER, jar $DEOB_JAR
echo RS client version $RS_CLIENT_VER, jar at $RS_CLIENT_JAR

JAV_CONFIG=/tmp/jav_config.ws
VANILLA=/tmp/vanilla.jar
DEOBFUSCATED=/tmp/deobfuscated.jar
DEOBFUSCATED_WITH_MAPPINGS=/tmp/deobfuscated_with_mappings.jar
VANILLA_INJECTED=/tmp/vanilla_injected.jar

#curl -L oldschool.runescape.com/jav_config.ws > $JAV_CONFIG

CODEBASE=$(grep codebase $JAV_CONFIG | cut -d'=' -f2)
INITIAL_JAR=$(grep initial_jar $JAV_CONFIG | cut -d'=' -f2)
JAR_URL=$CODEBASE$INITIAL_JAR

echo Downloading vanilla client from $JAR_URL

rm $VANILLA
#wget $JAR_URL -O $VANILLA

# step 1. deobfuscate vanilla jar. store in $DEOBFUSCATED.
rm $DEOBFUSCATED
java -cp $DEOB_JAR net.runelite.deob.Deob $VANILLA $DEOBFUSCATED

# step 2. map old deob (which has the mapping annotations) -> new client
rm $DEOBFUSCATED_WITH_MAPPINGS
java -cp $DEOB_JAR net.runelite.deob.updater.UpdateMappings $RS_CLIENT_JAR $DEOBFUSCATED $DEOBFUSCATED_WITH_MAPPINGS

# step 3. inject vanilla client.
rm $VANILLA_INJECTED
java -cp $DEOB_JAR net.runelite.deob.updater.UpdateIject $DEOBFUSCATED_WITH_MAPPINGS $VANILLA $VANILLA_INJECTED

# step 4. deploy vanilla client.

# step 5. decompile deobfuscated mapped client.
rm -rf /tmp/dest
mkdir /tmp/dest
java -Xmx1024m -jar $FERNFLOWER_JAR $DEOBFUSCATED_WITH_MAPPINGS /tmp/dest/

# extract source
cd /tmp/dest
jar xf *.jar
cd -

# update deobfuscated client repository
cd $DEOBFUSCATOR_REPO
git rm src/main/java/*.java
mkdir -p src/main/java/
cp /tmp/dest/*.java src/main/java/
git add src/main/java/

git config user.name "Runelite auto updater"
git config user.email runelite@runelite.net

git commit -m "Update"
git push

