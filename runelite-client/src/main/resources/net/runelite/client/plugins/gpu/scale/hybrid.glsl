/*
 * Written in 2025 by Casey Zwicker <caseypzwicker@gmail.com>
 * To the extent possible under law, the author(s) have dedicated all copyright and related and neighboring rights
 * to this software to the public domain worldwide. This software is distributed without any warranty.
 * You should have received a copy of the CC0 Public Domain Dedication along with this software.
 * If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

// Anti-aliased UI scaling that respects pixel sharpness
// Approach taken from https://colececil.dev/blog/2017/scaling-pixel-art-without-destroying-it/
vec4 textureHybrid(sampler2D tex, vec2 uv) {
  uv *= sourceDimensions;
  vec2 texelUv = fract(uv);
  vec2 pixelsPerTexel = vec2(targetDimensions) / vec2(sourceDimensions);
  vec2 interpolationAmount = min(texelUv * pixelsPerTexel, .5) - min((1 - texelUv) * pixelsPerTexel, .5);
  return texture(tex, (floor(uv) + .5 + interpolationAmount) / sourceDimensions);
}