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

#include version_header

#include "comp_common.glsl"

layout(local_size_x = 6) in;

void main() {
  uint groupId = gl_WorkGroupID.x;
  uint localId = gl_LocalInvocationID.x;
  modelinfo minfo = ol[groupId];

  int offset = minfo.offset;
  int size = minfo.size;
  int outOffset = minfo.idx;
  int toffset = minfo.toffset;
  int flags = minfo.flags;

  if (localId >= size) {
    return;
  }

  uint ssboOffset = localId;
  vec4 vertA, vertB, vertC;

  // Grab triangle vertices from the correct buffer
  if (flags < 0) {
    vertA = vb[offset + ssboOffset * 3];
    vertB = vb[offset + ssboOffset * 3 + 1];
    vertC = vb[offset + ssboOffset * 3 + 2];
  } else {
    vertA = tempvb[offset + ssboOffset * 3];
    vertB = tempvb[offset + ssboOffset * 3 + 1];
    vertC = tempvb[offset + ssboOffset * 3 + 2];
  }

  uint myOffset = localId;
  vec4 pos = vec4(minfo.x, minfo.y, minfo.z, 0);
  vec4 texPos = pos.wxyz;

  // position vertices in scene and write to out buffer
  vout[outOffset + myOffset * 3] = pos + vertA;
  vout[outOffset + myOffset * 3 + 1] = pos + vertB;
  vout[outOffset + myOffset * 3 + 2] = pos + vertC;

  if (toffset < 0) {
    uvout[outOffset + myOffset * 3] = vec4(0);
    uvout[outOffset + myOffset * 3 + 1] = vec4(0);
    uvout[outOffset + myOffset * 3 + 2] = vec4(0);
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
