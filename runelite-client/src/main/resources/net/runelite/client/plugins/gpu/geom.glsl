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

#include texture_config

//#define ZBUF_DEBUG
//#define BIAS_DEBUG

// smallest unit of the texture which can be moved per tick. textures are all
// 128x128px - so this is equivalent to +1px
#define TEXTURE_ANIM_UNIT (1.0f / 128.0f)

layout(triangles) in;
layout(triangle_strip, max_vertices = 3) out;

layout(std140) uniform uniforms {
  float cameraYaw;
  float cameraPitch;
  float cameraX;
  float cameraY;
  float cameraZ;
};

#include "uv.glsl"

uniform vec2 textureAnimations[TEXTURE_COUNT];
uniform int tick;
uniform mat4 worldProj;

in vec4 gVertex[3];
in vec4 gColor[3];
in float gHsl[3];
in int gTextureId[3];
in vec4 gTexPos[3];
in float gFogAmount[3];
in int gBias[3];

out vec4 fColor;
noperspective centroid out float fHsl;
flat out int fTextureId;
out vec2 fUv;
out float fFogAmount;
#ifdef ZBUF_DEBUG
out float fDepth;
#endif

void main() {
  int textureId = gTextureId[0];
  vec2 uv[3];

  if (textureId > 0) {
    vec3 cameraPos = vec3(cameraX, cameraY, cameraZ);
    compute_uv(cameraPos, gVertex[0].xyz, gVertex[1].xyz, gVertex[2].xyz, gTexPos[0].xyz, gTexPos[1].xyz, gTexPos[2].xyz, uv[0], uv[1], uv[2]);

    vec2 textureAnim = textureAnimations[min(textureId - 1, TEXTURE_COUNT - 1)];
    for (int i = 0; i < 3; ++i) {
      uv[i] += tick * textureAnim * TEXTURE_ANIM_UNIT;
    }
  } else {
    uv[0] = vec2(0);
    uv[1] = vec2(0);
    uv[2] = vec2(0);
  }

  for (int i = 0; i < 3; ++i) {
#ifdef BIAS_DEBUG
    fColor = vec4(clamp(gBias[i], 0, 12) / 12.0, 0.0, 0.0, 1.0);
#else
    fColor = gColor[i];
#endif
    fHsl = gHsl[i];
    fTextureId = gTextureId[i];
    fUv = uv[i];
    fFogAmount = gFogAmount[i];

    vec4 pos = worldProj * gVertex[i];
#ifdef ZBUF_DEBUG
    fDepth = pos.z / pos.w;
#endif
    pos.z += gBias[i] / 128.0;
    gl_Position = pos;

    EmitVertex();
  }

  EndPrimitive();
}