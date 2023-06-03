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

#define PI 3.1415926535897932384626433832795f
#define UNIT PI / 1024.0f

layout(std140) uniform uniforms {
  int cameraYaw;
  int cameraPitch;
  int centerX;
  int centerY;
  int zoom;
  int cameraX;
  int cameraY;
  int cameraZ;
  ivec2 sinCosTable[2048];
};

struct modelinfo {
  int offset;   // offset into vertex buffer
  int toffset;  // offset into texture buffer
  int size;     // length in faces
  int idx;      // write idx in target buffer
  int flags;    // buffer, radius, orientation
  int x;        // scene position x
  int y;        // scene position y
  int z;        // scene position z
};

layout(std430, binding = 0) readonly buffer modelbuffer_in {
  modelinfo ol[];
};

layout(std430, binding = 1) readonly buffer vertexbuffer_in {
  ivec4 vb[];
};

layout(std430, binding = 2) readonly buffer tempvertexbuffer_in {
  ivec4 tempvb[];
};

layout(std430, binding = 3) writeonly buffer vertex_out {
  ivec4 vout[];
};

layout(std430, binding = 4) writeonly buffer uv_out {
  vec4 uvout[];
};

layout(std430, binding = 5) readonly buffer texturebuffer_in {
  vec4 texb[];
};

layout(std430, binding = 6) readonly buffer temptexturebuffer_in {
  vec4 temptexb[];
};