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

#version 400

// Define tile size.
#define FOG_DIST_SCALE 64

layout (location = 0) in ivec4 VertexPosition;
layout (location = 1) in vec4 uv;

uniform float brightness;
uniform int useFog;
uniform int drawDistance;
uniform ivec3 cameraPosition;

out ivec3 vPosition;
out vec4 vColor;
out float vHsl;
out vec4 vUv;
out float vFogAmount;

#include hsl_to_rgb.glsl

float fogFactorLinear(const float dist, const float start, const float end) {
    return 1.0 - clamp((end - dist) / (end - start), 0.0, 1.0);
}

float boxDistance(vec3 v1, vec3 v2){
    return max(abs(v1.x - v2.x), abs(v1.z - v2.z));
}

void main()
{
  ivec3 vertex = VertexPosition.xyz;
  int ahsl = VertexPosition.w;
  int hsl = ahsl & 0xffff;
  float a = float(ahsl >> 24 & 0xff) / 255.f;

  vec3 rgb = hslToRgb(hsl);

  vPosition = vertex;
  vColor = vec4(rgb, 1.f - a);
  vHsl = float(hsl);
  vUv = uv;

  if (useFog == 1)
  {
    float fogDistance = boxDistance(vPosition, cameraPosition);
    float fogEnd = (drawDistance * 2) * FOG_DIST_SCALE;
    float fogStart = fogEnd - ((drawDistance / 2) * FOG_DIST_SCALE);

    vFogAmount = fogFactorLinear(fogDistance, fogStart, fogEnd);
  }
  else
  {
    vFogAmount = 0;
  }
}
