#!/bin/bash
cd ..

mvn dependency:resolve
mvn dependency:resolve-plugins
mvn clean install -Dproject.build.sourceEncoding=UTF-8 -DskipTests -U