/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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

#define PI 3.1415926535897932384626433832795f
#define UNIT PI / 1024.0f

float3 toScreen(float3 vertex, float cameraYaw, float cameraPitch, int centerX, int centerY, int zoom) {
  float yawSin = sin(cameraYaw);
  float yawCos = cos(cameraYaw);

  float pitchSin = sin(cameraPitch);
  float pitchCos = cos(cameraPitch);

  float rotatedX = (vertex.z * yawSin) + (vertex.x * yawCos);
  float rotatedZ = (vertex.z * yawCos) - (vertex.x * yawSin);

  float var13 = (vertex.y * pitchCos) - (rotatedZ * pitchSin);
  float var12 = (vertex.y * pitchSin) + (rotatedZ * pitchCos);

  float x = rotatedX * zoom / var12 + centerX;
  float y = var13 * zoom / var12 + centerY;
  float z = -var12;  // in OpenGL depth is negative

  return (float3)(x, y, z);
}

/*
 * Rotate a vertex by a given orientation in JAU
 */
float4 rotate_vertex(float4 vertex, int orientation) {
  float rad = orientation * UNIT;
  float s = sin(rad);
  float c = cos(rad);
  float x = vertex.z * s + vertex.x * c;
  float z = vertex.z * c - vertex.x * s;
  return (float4)(x, vertex.y, z, vertex.w);
}

/*
 * Calculate the distance to a vertex given the camera angle
 */
float vertex_distance(float4 vertex, float cameraYaw, float cameraPitch) {
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
float face_distance(float4 vA, float4 vB, float4 vC, float cameraYaw, float cameraPitch) {
  float dvA = vertex_distance(vA, cameraYaw, cameraPitch);
  float dvB = vertex_distance(vB, cameraYaw, cameraPitch);
  float dvC = vertex_distance(vC, cameraYaw, cameraPitch);
  float faceDistance = (dvA + dvB + dvC) / 3;
  return (int)faceDistance;
}

/*
 * Test if a face is visible (not backward facing)
 */
bool face_visible(__constant struct uniform *uni, float3 vA, float3 vB, float3 vC, int4 position) {
  // Move model to scene location, and account for camera offset
  float3 cameraPos = (float3)(uni->cameraX, uni->cameraY, uni->cameraZ);
  float3 modelPos = convert_float3(position.xyz);

  float3 lA = vA + modelPos - cameraPos;
  float3 lB = vB + modelPos - cameraPos;
  float3 lC = vC + modelPos - cameraPos;

  float3 sA = toScreen(lA, uni->cameraYaw, uni->cameraPitch, uni->centerX, uni->centerY, uni->zoom);
  float3 sB = toScreen(lB, uni->cameraYaw, uni->cameraPitch, uni->centerX, uni->centerY, uni->zoom);
  float3 sC = toScreen(lC, uni->cameraYaw, uni->cameraPitch, uni->centerX, uni->centerY, uni->zoom);

  return (sA.x - sB.x) * (sC.y - sB.y) - (sC.x - sB.x) * (sA.y - sB.y) > 0;
}
