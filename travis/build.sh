#!/bin/bash

set -e -x

wget -O/tmp/glslang.zip 'https://github.com/KhronosGroup/glslang/releases/download/8.13.3559/glslang-master-linux-Release.zip'
echo '9adcfdef5b52275e61068aafbb62747936c6c18ab6dc32a6ef707cfc7b0df423  /tmp/glslang.zip' | sha256sum -c
unzip -q /tmp/glslang.zip -d /tmp/glslang

mvn clean install --settings travis/settings.xml -Dglslang.path=/tmp/glslang/bin/glslangValidator
