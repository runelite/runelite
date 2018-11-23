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

uniform sampler2DArray textures;
uniform vec2 textureOffsets[64];
uniform float brightness;
uniform float smoothBanding;

in vec4 Color;
in float fHsl;
in vec4 fUv;

out vec4 FragColor;

#include hsl_to_rgb.glsl

void main() {
  float n = fUv.x;

  int hsl = int(fHsl);
  vec3 rgb = hslToRgb(hsl) * smoothBanding + Color.rgb * (1.f - smoothBanding);
  vec4 smoothColor = vec4(rgb, Color.a);

  if (n > 0.0) {
    n -= 1.0;
    int textureIdx = int(n);

    vec2 uv = fUv.yz;
    vec2 animatedUv = uv + textureOffsets[textureIdx];

    vec4 textureColor = texture(textures, vec3(animatedUv, n));
    vec4 textureColorBrightness = pow(textureColor, vec4(brightness, brightness, brightness, 1.0f));

    FragColor = textureColorBrightness * smoothColor;
  } else {
    FragColor = smoothColor;
  }
}
