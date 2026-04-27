#!/bin/bash

set -e -x

CACHEDIR="$HOME/.cache/runelite"
mkdir -p "${CACHEDIR}"
GLSLANG_ARCHIVE="${CACHEDIR}/glslang.zip"
GLSLANG_DIR="${CACHEDIR}/glslang"
GLSLANG_RELEASE='https://github.com/KhronosGroup/glslang/releases/download/8.13.3743/glslang-master-linux-Release.zip'
GLSLANG_CHECKSUM='d02b22d35ba7bc786a115fbc90ff2caef7f1cd99d87ab053e3dba8efda5b405a'

if [ ! -f "${GLSLANG_ARCHIVE}" ] || [ ! -d "${GLSLANG_DIR}" ] || ! echo "${GLSLANG_CHECKSUM} ${GLSLANG_ARCHIVE}" | sha256sum -c -; then
  wget -O "${GLSLANG_ARCHIVE}" "${GLSLANG_RELEASE}"
  echo "${GLSLANG_CHECKSUM} ${GLSLANG_ARCHIVE}" | sha256sum -c
  unzip -o -q "${GLSLANG_ARCHIVE}" -d "${GLSLANG_DIR}"
fi

export ORG_GRADLE_PROJECT_glslangPath="$GLSLANG_DIR/bin/glslangValidator"
./gradlew --build-cache ':buildAll'
