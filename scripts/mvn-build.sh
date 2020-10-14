#!/bin/bash
cd ..

#mvn dependency:resolve
#mvn dependency:resolve-plugins
"C:\Program Files\Java\jdk1.8.0_121\bin\java.exe" -Dmaven.multiModuleProjectDirectory=C:\Users\Mutoh\IdeaProjects\runelite-regionlock "-Dmaven.home=C:\Program Files\JetBrains\IntelliJ IDEA 2018.3.3\plugins\maven\lib\maven3" "-Dclassworlds.conf=C:\Program Files\JetBrains\IntelliJ IDEA 2018.3.3\plugins\maven\lib\maven3\bin\m2.conf" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.3.3\lib\idea_rt.jar=52118:C:\Program Files\JetBrains\IntelliJ IDEA 2018.3.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA 2018.3.3\plugins\maven\lib\maven3\boot\plexus-classworlds-2.5.2.jar" org.codehaus.classworlds.Launcher -Didea.version="2018.3.3" -Dcheckstyle.skip=false clean install -DskipTests -U