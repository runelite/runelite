#!/bin/bash
cd ..

mvn dependency:resolve
mvn dependency:resolve-plugins
mvn clean install -DskipTests -U