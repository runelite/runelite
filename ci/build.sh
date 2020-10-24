#!/bin/bash

set -e -x

CACHEDIR="$HOME/.cache/runelite"
mkdir -p "${CACHEDIR}"
GLSLANG_ARCHIVE="${CACHEDIR}/glslang.zip"
GLSLANG_DIR="${CACHEDIR}/glslang"
GLSLANG_RELEASE='https://github.com/KhronosGroup/glslang/releases/download/8.13.3559/glslang-master-linux-Release.zip'
GLSLANG_CHECKSUM='9adcfdef5b52275e61068aafbb62747936c6c18ab6dc32a6ef707cfc7b0df423'

if [ ! -f "${GLSLANG_ARCHIVE}" ] || [ ! -d "${GLSLANG_DIR}" ] || ! echo "${GLSLANG_CHECKSUM} ${GLSLANG_ARCHIVE}" | sha256sum -c -; then
  wget -O "${GLSLANG_ARCHIVE}" "${GLSLANG_RELEASE}"
  echo "${GLSLANG_CHECKSUM} ${GLSLANG_ARCHIVE}" | sha256sum -c
  unzip -o -q "${GLSLANG_ARCHIVE}" -d "${GLSLANG_DIR}"
fi

mvn clean install --settings ci/settings.xml -Dglslang.path="${GLSLANG_DIR}/bin/glslangValidator"
