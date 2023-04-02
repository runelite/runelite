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

__kernel __attribute__((reqd_work_group_size(6, 1, 1))) void computeUnordered(__global const struct modelinfo *ol, __global const int4 *vb,
                                                                              __global const int4 *tempvb, __global const float4 *texb,
                                                                              __global const float4 *temptexb, __global int4 *vout, __global float4 *uvout) {
  size_t groupId = get_group_id(0);
  size_t localId = get_local_id(0);
  struct modelinfo minfo = ol[groupId];

  int offset = minfo.offset;
  int size = minfo.size;
  int outOffset = minfo.idx;
  int toffset = minfo.toffset;
  int flags = minfo.flags;
  int4 pos = (int4)(minfo.x, minfo.y, minfo.z, 0);

  if (localId >= size) {
    return;
  }

  uint ssboOffset = localId;
  int4 thisA, thisB, thisC;

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

  // position vertices in scene and write to out buffer
  vout[outOffset + myOffset * 3] = pos + thisA;
  vout[outOffset + myOffset * 3 + 1] = pos + thisB;
  vout[outOffset + myOffset * 3 + 2] = pos + thisC;

  if (toffset < 0) {
    uvout[outOffset + myOffset * 3] = (float4)(0.0f, 0.0f, 0.0f, 0.0f);
    uvout[outOffset + myOffset * 3 + 1] = (float4)(0.0f, 0.0f, 0.0f, 0.0f);
    uvout[outOffset + myOffset * 3 + 2] = (float4)(0.0f, 0.0f, 0.0f, 0.0f);
  } else if (flags >= 0) {
    uvout[outOffset + myOffset * 3] = temptexb[toffset + localId * 3];
    uvout[outOffset + myOffset * 3 + 1] = temptexb[toffset + localId * 3 + 1];
    uvout[outOffset + myOffset * 3 + 2] = temptexb[toffset + localId * 3 + 2];
  } else {
    uvout[outOffset + myOffset * 3] = texb[toffset + localId * 3];
    uvout[outOffset + myOffset * 3 + 1] = texb[toffset + localId * 3 + 1];
    uvout[outOffset + myOffset * 3 + 2] = texb[toffset + localId * 3 + 2];
  }
}
