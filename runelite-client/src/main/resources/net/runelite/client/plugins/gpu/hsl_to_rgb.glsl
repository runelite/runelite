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

vec3 hslToRgb(vec3 hsl) {
  float hue = hsl.x / 64.0f + 0.0078125f;
  float sat = hsl.y / 8.0f + 0.0625f;
  float lum = hsl.z;

  float var11 = lum / 128.0f;
  float r = var11;
  float g = var11;
  float b = var11;

  float var19;
  if (var11 < 0.5f) {
    var19 = var11 * (1.0f + sat);
  } else {
    var19 = var11 + sat - var11 * sat;
  }

  float var21 = 2.0f * var11 - var19;
  float var23 = hue + 0.3333333333333333f;
  if (var23 > 1.0f) {
    var23 -= 1.f;
  }

  float var27 = hue - 0.3333333333333333f;
  if (var27 < 0.0f) {
    var27 += 1.f;
  }

  if (6.0f * var23 < 1.0f) {
    r = var21 + (var19 - var21) * 6.0f * var23;
  } else if (2.0f * var23 < 1.0f) {
    r = var19;
  } else if (3.0f * var23 < 2.0f) {
    r = var21 + (var19 - var21) * (0.6666666666666666f - var23) * 6.0f;
  } else {
    r = var21;
  }

  if (6.0f * hue < 1.0f) {
    g = var21 + (var19 - var21) * 6.0f * hue;
  } else if (2.0f * hue < 1.0f) {
    g = var19;
  } else if (3.0f * hue < 2.0f) {
    g = var21 + (var19 - var21) * (0.6666666666666666f - hue) * 6.0f;
  } else {
    g = var21;
  }

  if (6.0f * var27 < 1.0f) {
    b = var21 + (var19 - var21) * 6.0f * var27;
  } else if (2.0f * var27 < 1.0f) {
    b = var19;
  } else if (3.0f * var27 < 2.0f) {
    b = var21 + (var19 - var21) * (0.6666666666666666f - var27) * 6.0f;
  } else {
    b = var21;
  }

  return vec3(pow(r, brightness), pow(g, brightness), pow(b, brightness));
}