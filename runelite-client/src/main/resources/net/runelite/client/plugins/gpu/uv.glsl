/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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

void compute_uv(vec3 cameraPos, vec3 f1, vec3 f2, vec3 f3, vec3 t1, vec3 t2, vec3 t3, out vec2 uv1, out vec2 uv2, out vec2 uv3) {
  vec3 tangent = t2 - t1;
  vec3 bitangent = t3 - t1;

  vec3 texNormal = cross(tangent, bitangent);
  vec3 vertexToCamera;

  // Set the tri vertex position to the intersection point on the tex tri plane
  // along the vector from the tri vertex to the camera.
  // Point of intersection p, from https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection#Algebraic_form:
  // d = ((p_0 - l_0) ⋅ n) / (l ⋅ n)
  // p = l_0 + l * d
  // where p_0 = point on tex tri plane
  //       l_0 = point being projected
  //         n = normal of tex tri plane
  //         l = vector from vertex to camera
  vertexToCamera = cameraPos - f1;
  f1 += vertexToCamera * dot(t1 - f1, texNormal) / dot(vertexToCamera, texNormal);

  vertexToCamera = cameraPos - f2;
  f2 += vertexToCamera * dot(t2 - f2, texNormal) / dot(vertexToCamera, texNormal);

  vertexToCamera = cameraPos - f3;
  f3 += vertexToCamera * dot(t3 - f3, texNormal) / dot(vertexToCamera, texNormal);

  vec3 v4 = f1 - t1;
  vec3 v5 = f2 - t1;
  vec3 v6 = f3 - t1;

  vec3 v8 = cross(bitangent, texNormal);
  float d = 1.0f / dot(v8, tangent);

  float u1 = dot(v8, v4) * d;
  float u2 = dot(v8, v5) * d;
  float u3 = dot(v8, v6) * d;

  v8 = cross(tangent, texNormal);
  d = 1.0f / dot(v8, bitangent);

  float v1 = dot(v8, v4) * d;
  float v2 = dot(v8, v5) * d;
  float v3 = dot(v8, v6) * d;

  uv1 = vec2(u1, v1);
  uv2 = vec2(u2, v2);
  uv3 = vec2(u3, v3);
}