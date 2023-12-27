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

#include "to_screen.glsl"

/*
 * Rotate a vertex by a given orientation in JAU
 */
vec4 rotate(vec4 vertex, int orientation) {
  float rad = orientation * UNIT;
  float s = sin(rad);
  float c = cos(rad);
  mat4 m = mat4(c, 0, s, 0, 0, 1, 0, 0, -s, 0, c, 0, 0, 0, 0, 1);
  return vertex * m;
}

/*
 * Calculate the distance to a vertex given the camera angle
 */
float distance(vec4 vertex, float cameraYaw, float cameraPitch) {
  float rotxz = vertex.z * cos(cameraYaw) - vertex.x * sin(cameraYaw);
  float rotyz = rotxz * cos(cameraPitch) + vertex.y * sin(cameraPitch);
  return rotyz;
}

/*
 * Calculate the distance to a face
 */
int face_distance(vec4 vA, vec4 vB, vec4 vC, float cameraYaw, float cameraPitch) {
  float dvA = distance(vA, cameraYaw, cameraPitch);
  float dvB = distance(vB, cameraYaw, cameraPitch);
  float dvC = distance(vC, cameraYaw, cameraPitch);
  float faceDistance = (dvA + dvB + dvC) / 3;
  return int(faceDistance);
}

/*
 * Test if a face is visible (not backward facing)
 */
bool face_visible(vec4 vA, vec4 vB, vec4 vC, ivec4 position) {
  // Move model to scene location, and account for camera offset
  vec4 cameraPos = vec4(cameraX, cameraY, cameraZ, 0);

  vec4 lA = vA + position - cameraPos;
  vec4 lB = vB + position - cameraPos;
  vec4 lC = vC + position - cameraPos;

  vec3 sA = toScreen(lA.xyz, cameraYaw, cameraPitch, centerX, centerY, zoom);
  vec3 sB = toScreen(lB.xyz, cameraYaw, cameraPitch, centerX, centerY, zoom);
  vec3 sC = toScreen(lC.xyz, cameraYaw, cameraPitch, centerX, centerY, zoom);

  return (sA.x - sB.x) * (sC.y - sB.y) - (sC.x - sB.x) * (sA.y - sB.y) > 0;
}
