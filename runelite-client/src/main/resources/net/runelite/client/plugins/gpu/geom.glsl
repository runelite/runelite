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

//#define ZBUF

// smallest unit of the texture which can be moved per tick. textures are all
// 128x128px - so this is equivalent to +1px
#define TEXTURE_ANIM_UNIT (1.0f / 128.0f)

layout(triangles) in;
layout(triangle_strip, max_vertices = 3) out;

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

#include "uv.glsl"

uniform vec2 textureAnimations[128];
uniform int tick;
uniform mat4 projectionMatrix;

in vec3 gVertex[3];
in vec4 gColor[3];
in float gHsl[3];
in int gTextureId[3];
in vec3 gTexPos[3];
in float gFogAmount[3];

out vec4 fColor;
noperspective centroid out float fHsl;
flat out int fTextureId;
out vec2 fUv;
out float fFogAmount;
#ifdef ZBUF
out float fDepth;
#endif

void main() {
  int textureId = gTextureId[0];
  vec2 uv[3];

  if (textureId > 0) {
    vec3 cameraPos = vec3(cameraX, cameraY, cameraZ);
    compute_uv(cameraPos, gVertex[0], gVertex[1], gVertex[2], gTexPos[0], gTexPos[1], gTexPos[2], uv[0], uv[1], uv[2]);

    vec2 textureAnim = textureAnimations[textureId - 1];
    for (int i = 0; i < 3; ++i) {
      uv[i] += tick * textureAnim * TEXTURE_ANIM_UNIT;
    }
  } else {
    uv[0] = vec2(0);
    uv[1] = vec2(0);
    uv[2] = vec2(0);
  }

  for (int i = 0; i < 3; ++i) {
    fColor = gColor[i];
    fHsl = gHsl[i];
    fTextureId = gTextureId[i];
    fUv = uv[i];
    fFogAmount = gFogAmount[i];

    vec4 pos = projectionMatrix * vec4(gVertex[i], 1);
#ifdef ZBUF
    fDepth = pos.z / pos.w;
#endif
    gl_Position = pos;

    EmitVertex();
  }

  EndPrimitive();
}