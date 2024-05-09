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

#define TILE_SIZE 128.f

#define FOG_SCENE_EDGE_MIN ((-expandedMapLoadingChunks * 8 + 1) * TILE_SIZE)
#define FOG_SCENE_EDGE_MAX ((104 + expandedMapLoadingChunks * 8 - 1) * TILE_SIZE)
#define FOG_CORNER_ROUNDING 1.5
#define FOG_CORNER_ROUNDING_SQUARED (FOG_CORNER_ROUNDING * FOG_CORNER_ROUNDING)

layout(location = 0) in vec3 vert;
layout(location = 1) in int ahsl;
layout(location = 2) in vec4 uv;

layout(std140) uniform uniforms {
  float cameraYaw;
  float cameraPitch;
  int centerX;
  int centerY;
  int zoom;
  float cameraX;
  float cameraY;
  float cameraZ;
};

uniform float brightness;
uniform int useFog;
uniform int fogDepth;
uniform int drawDistance;
uniform int expandedMapLoadingChunks;

out vec3 gVertex;
out vec4 gColor;
out float gHsl;
out int gTextureId;
out vec3 gTexPos;
out float gFogAmount;

#include "hsl_to_rgb.glsl"

float fogFactorLinear(const float dist, const float start, const float end) {
  return 1.0 - clamp((dist - start) / (end - start), 0.0, 1.0);
}

void main() {
  int hsl = ahsl & 0xffff;
  float a = float(ahsl >> 24 & 0xff) / 255.f;

  vec3 rgb = hslToRgb(hsl);

  gVertex = vert;
  gColor = vec4(rgb, 1.f - a);
  gHsl = float(hsl);

  gTextureId = int(uv.x);  // the texture id + 1;
  gTexPos = uv.yzw;

  // the client draws one less tile to the north and east than it does to the south
  // and west, so subtract a tiles width from the north and east edges.
  float fogWest = max(FOG_SCENE_EDGE_MIN, cameraX - drawDistance);
  float fogEast = min(FOG_SCENE_EDGE_MAX, cameraX + drawDistance - TILE_SIZE);
  float fogSouth = max(FOG_SCENE_EDGE_MIN, cameraZ - drawDistance);
  float fogNorth = min(FOG_SCENE_EDGE_MAX, cameraZ + drawDistance - TILE_SIZE);

  // Calculate distance from the scene edge
  float xDist = min(vert.x - fogWest, fogEast - vert.x);
  float zDist = min(vert.z - fogSouth, fogNorth - vert.z);
  float nearestEdgeDistance = min(xDist, zDist);
  float secondNearestEdgeDistance = max(xDist, zDist);
  float fogDistance =
      nearestEdgeDistance - FOG_CORNER_ROUNDING * TILE_SIZE *
                                max(0.f, (nearestEdgeDistance + FOG_CORNER_ROUNDING_SQUARED) / (secondNearestEdgeDistance + FOG_CORNER_ROUNDING_SQUARED));

  gFogAmount = fogFactorLinear(fogDistance, 0, fogDepth * TILE_SIZE) * useFog;
}
