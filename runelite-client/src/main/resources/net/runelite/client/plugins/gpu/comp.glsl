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

shared int totalNum[12]; // number of faces with a given priority
shared int totalDistance[12]; // sum of distances to faces of a given priority

shared int totalMappedNum[18]; // number of faces with a given adjusted priority

shared int min10; // minimum distance to a face of priority 10
shared int dfs[4096]; // packed face id and distance

#include comp_common.glsl

layout(local_size_x = 1024) in;

#include common.glsl
#include priority_render.glsl

void main() {
  uint groupId = gl_WorkGroupID.x;
  uint localId = gl_LocalInvocationID.x * 4;
  modelinfo minfo = ol[groupId];
  ivec4 pos = ivec4(minfo.x, minfo.y, minfo.z, 0);

  if (localId == 0) {
    min10 = 1600;
    for (int i = 0; i < 12; ++i) {
      totalNum[i] = 0;
      totalDistance[i] = 0;
    }
    for (int i = 0; i < 18; ++i) {
      totalMappedNum[i] = 0;
    }
  }

  int prio1, dis1;
  ivec4 vA1, vA2, vA3;

  int prio2, dis2;
  ivec4 vB1, vB2, vB3;

  int prio3, dis3;
  ivec4 vC1, vC2, vC3;

  int prio4, dis4;
  ivec4 vD1, vD2, vD3;

  get_face(localId,     minfo, cameraYaw, cameraPitch, prio1, dis1, vA1, vA2, vA3);
  get_face(localId + 1, minfo, cameraYaw, cameraPitch, prio2, dis2, vB1, vB2, vB3);
  get_face(localId + 2, minfo, cameraYaw, cameraPitch, prio3, dis3, vC1, vC2, vC3);
  get_face(localId + 3, minfo, cameraYaw, cameraPitch, prio4, dis4, vD1, vD2, vD3);

  memoryBarrierShared();
  barrier();

  add_face_prio_distance(localId    , minfo, vA1, vA2, vA3, prio1, dis1, pos);
  add_face_prio_distance(localId + 1, minfo, vB1, vB2, vB3, prio2, dis2, pos);
  add_face_prio_distance(localId + 2, minfo, vC1, vC2, vC3, prio3, dis3, pos);
  add_face_prio_distance(localId + 3, minfo, vD1, vD2, vD3, prio4, dis4, pos);

  memoryBarrierShared();
  barrier();

  int prio1Adj, prio2Adj, prio3Adj, prio4Adj;
  int idx1 = map_face_priority(localId,     minfo, prio1, dis1, prio1Adj);
  int idx2 = map_face_priority(localId + 1, minfo, prio2, dis2, prio2Adj);
  int idx3 = map_face_priority(localId + 2, minfo, prio3, dis3, prio3Adj);
  int idx4 = map_face_priority(localId + 3, minfo, prio4, dis4, prio4Adj);

  memoryBarrierShared();
  barrier();

  insert_dfs(localId    , minfo, prio1Adj, dis1, idx1);
  insert_dfs(localId + 1, minfo, prio2Adj, dis2, idx2);
  insert_dfs(localId + 2, minfo, prio3Adj, dis3, idx3);
  insert_dfs(localId + 3, minfo, prio4Adj, dis4, idx4);

  memoryBarrierShared();
  barrier();

  sort_and_insert(localId    , minfo, prio1Adj, dis1, vA1, vA2, vA3);
  sort_and_insert(localId + 1, minfo, prio2Adj, dis2, vB1, vB2, vB3);
  sort_and_insert(localId + 2, minfo, prio3Adj, dis3, vC1, vC2, vC3);
  sort_and_insert(localId + 3, minfo, prio4Adj, dis4, vD1, vD2, vD3);
}
