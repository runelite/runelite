/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

#version 330

#define PI 3.1415926535897932384626433832795f
#define UNIT PI / 1024.0f

layout(triangles) in;
layout(triangle_strip, max_vertices = 3) out;

layout(std140) uniform uniforms {
  int cameraYaw;
  int cameraPitch;
  int centerX;
  int centerY;
  int zoom;
  int cameraX;
  int cameraY;
  int cameraZ;
  ivec2 sinCosTable[2048];
};

uniform mat4 projectionMatrix;

in ivec3 vPosition[];
in vec4 vColor[];
in float vHsl[];
in vec4 vUv[];
in float vFogAmount[];

out vec4 Color;
out float fHsl;
out vec4 fUv;
out float fogAmount;

#include to_screen.glsl

void main() {
  ivec3 cameraPos = ivec3(cameraX, cameraY, cameraZ);
  ivec3 screenA = toScreen(vPosition[0] - cameraPos, cameraYaw, cameraPitch, centerX, centerY, zoom);
  ivec3 screenB = toScreen(vPosition[1] - cameraPos, cameraYaw, cameraPitch, centerX, centerY, zoom);
  ivec3 screenC = toScreen(vPosition[2] - cameraPos, cameraYaw, cameraPitch, centerX, centerY, zoom);

  if (-screenA.z < 50 || -screenB.z < 50 || -screenC.z < 50) {
    // the client does not draw a triangle if any vertex distance is <50
    return;
  }

  vec4 tmp = vec4(screenA.xyz, 1.0);
  Color = vColor[0];
  fHsl = vHsl[0];
  fUv = vUv[0];
  fogAmount = vFogAmount[0];
  gl_Position  = projectionMatrix * tmp;
  EmitVertex();

  tmp = vec4(screenB.xyz, 1.0);
  Color = vColor[1];
  fHsl = vHsl[1];
  fUv = vUv[1];
  fogAmount = vFogAmount[1];
  gl_Position  = projectionMatrix * tmp;
  EmitVertex();

  tmp = vec4(screenC.xyz, 1.0);
  Color = vColor[2];
  fHsl = vHsl[2];
  fUv = vUv[2];
  fogAmount = vFogAmount[2];
  gl_Position  = projectionMatrix * tmp;
  EmitVertex();

  EndPrimitive();
}
