/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

#include "cl_types.cl"

__kernel __attribute__((reqd_work_group_size(6, 1, 1))) void computeUnordered(__global const struct modelinfo *ol, __global const struct vert *vb,
                                                                              __global const struct vert *tempvb, __global const float4 *texb,
                                                                              __global const float4 *temptexb, __global struct vert *vout,
                                                                              __global float4 *uvout) {
  size_t groupId = get_group_id(0);
  size_t localId = get_local_id(0);
  struct modelinfo minfo = ol[groupId];

  int offset = minfo.offset;
  int size = minfo.size;
  int outOffset = minfo.idx;
  int toffset = minfo.toffset;
  int flags = minfo.flags;

  if (localId >= size) {
    return;
  }

  uint ssboOffset = localId;
  struct vert thisA, thisB, thisC;

  // Grab triangle vertices from the correct buffer
  if (flags < 0) {
    thisA = vb[offset + ssboOffset * 3];
    thisB = vb[offset + ssboOffset * 3 + 1];
    thisC = vb[offset + ssboOffset * 3 + 2];
  } else {
    thisA = tempvb[offset + ssboOffset * 3];
    thisB = tempvb[offset + ssboOffset * 3 + 1];
    thisC = tempvb[offset + ssboOffset * 3 + 2];
  }

  uint myOffset = localId;
  float3 pos = convert_float3((int3)(minfo.x, minfo.y, minfo.z));
  float4 texPos = (float4)(0, minfo.x, minfo.y, minfo.z);

  float3 vertA = (float3)(thisA.x, thisA.y, thisA.z) + pos;
  float3 vertB = (float3)(thisB.x, thisB.y, thisB.z) + pos;
  float3 vertC = (float3)(thisC.x, thisC.y, thisC.z) + pos;

  // position vertices in scene and write to out buffer
  vout[outOffset + myOffset * 3] = (struct vert){vertA.x, vertA.y, vertA.z, thisA.ahsl};
  vout[outOffset + myOffset * 3 + 1] = (struct vert){vertB.x, vertB.y, vertB.z, thisB.ahsl};
  vout[outOffset + myOffset * 3 + 2] = (struct vert){vertC.x, vertC.y, vertC.z, thisC.ahsl};

  if (toffset < 0) {
    uvout[outOffset + myOffset * 3] = (float4)(0.0f, 0.0f, 0.0f, 0.0f);
    uvout[outOffset + myOffset * 3 + 1] = (float4)(0.0f, 0.0f, 0.0f, 0.0f);
    uvout[outOffset + myOffset * 3 + 2] = (float4)(0.0f, 0.0f, 0.0f, 0.0f);
  } else if (flags >= 0) {
    uvout[outOffset + myOffset * 3] = texPos + temptexb[toffset + localId * 3];
    uvout[outOffset + myOffset * 3 + 1] = texPos + temptexb[toffset + localId * 3 + 1];
    uvout[outOffset + myOffset * 3 + 2] = texPos + temptexb[toffset + localId * 3 + 2];
  } else {
    uvout[outOffset + myOffset * 3] = texPos + texb[toffset + localId * 3];
    uvout[outOffset + myOffset * 3 + 1] = texPos + texb[toffset + localId * 3 + 1];
    uvout[outOffset + myOffset * 3 + 2] = texPos + texb[toffset + localId * 3 + 2];
  }
}
