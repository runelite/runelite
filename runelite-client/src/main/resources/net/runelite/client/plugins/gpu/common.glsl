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
vec4 rotate_vertex(vec4 vertex, int orientation) {
  float rad = orientation * UNIT;
  float s = sin(rad);
  float c = cos(rad);
  // clang-format off
  mat4 m = mat4(
    c, 0, s, 0,
    0, 1, 0, 0,
   -s, 0, c, 0,
    0, 0, 0, 1
  );
  // clang-format on
  return vertex * m;
}

/*
 * Calculate the distance to a vertex given the camera angle
 */
float distance(vec4 vertex, float cameraYaw, float cameraPitch) {
  float yawSin = sin(cameraYaw);
  float yawCos = cos(cameraYaw);

  float pitchSin = sin(cameraPitch);
  float pitchCos = cos(cameraPitch);

  float j = vertex.z * yawCos - vertex.x * yawSin;
  float l = vertex.y * pitchSin + j * pitchCos;

  return l;
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
bool face_visible(vec3 vA, vec3 vB, vec3 vC, ivec4 position) {
  // Move model to scene location, and account for camera offset
  vec3 cameraPos = vec3(cameraX, cameraY, cameraZ);

  vec3 lA = vA + position.xyz - cameraPos;
  vec3 lB = vB + position.xyz - cameraPos;
  vec3 lC = vC + position.xyz - cameraPos;

  vec3 sA = toScreen(lA, cameraYaw, cameraPitch, centerX, centerY, zoom);
  vec3 sB = toScreen(lB, cameraYaw, cameraPitch, centerX, centerY, zoom);
  vec3 sC = toScreen(lC, cameraYaw, cameraPitch, centerX, centerY, zoom);

  return (sA.x - sB.x) * (sC.y - sB.y) - (sC.x - sB.x) * (sA.y - sB.y) > 0;
}
