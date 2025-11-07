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

#include sampling_mode
#include colorblind_mode

#define SAMPLING_NEAREST 0
#define SAMPLING_LINEAR 1
#define SAMPLING_MITCHELL 2
#define SAMPLING_CATROM 3
#define SAMPLING_XBR 4
#define SAMPLING_HYBRID 5

uniform sampler2D tex;

uniform ivec2 sourceDimensions;
uniform ivec2 targetDimensions;
uniform vec4 alphaOverlay;

#if COLORBLIND_MODE > 0
#include "colorblind.glsl"
#endif

in vec2 TexCoord;
#if SAMPLING_MODE == SAMPLING_MITCHELL || SAMPLING_MODE == SAMPLING_CATROM
#include "scale/bicubic.glsl"
#elif SAMPLING_MODE == SAMPLING_XBR
#include "scale/xbr_lv2_frag.glsl"

in XBRTable xbrTable;
#elif SAMPLING_MODE == SAMPLING_HYBRID
#include "scale/hybrid.glsl"
#endif

out vec4 FragColor;

vec4 alphaBlend(vec4 src, vec4 dst) {
  return vec4(src.rgb + dst.rgb * (1.0f - src.a), src.a + dst.a * (1.0f - src.a));
}

void main() {
  vec4 c;

#if SAMPLING_MODE == SAMPLING_MITCHELL || SAMPLING_MODE == SAMPLING_CATROM
  c = textureCubic(tex, TexCoord);
#elif SAMPLING_MODE == SAMPLING_XBR
  c = textureXBR(tex, TexCoord, xbrTable, ceil(1.0 * targetDimensions.x / sourceDimensions.x));
#elif SAMPLING_MODE == SAMPLING_HYBRID
  c = textureHybrid(tex, TexCoord);
#else
  // NEAREST or LINEAR, which uses GL_TEXTURE_MIN_FILTER/GL_TEXTURE_MAG_FILTER to affect sampling
  c = texture(tex, TexCoord);
#endif

  c = alphaBlend(c, alphaOverlay);
#if COLORBLIND_MODE > 0
  c.rgb = colorblind(c.rgb);
#endif

  FragColor = c;
}
