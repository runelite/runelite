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

#include FACE_COUNT

#include "cl_types.cl"
#include "common.cl"
#include "priority_render.cl"

__kernel __attribute__((work_group_size_hint(256, 1, 1))) void computeLarge(__local struct shared_data *shared, __global const struct modelinfo *ol,
                                                                            __global const struct vert *vb, __global const struct vert *tempvb,
                                                                            __global const float4 *texb, __global const float4 *temptexb,
                                                                            __global struct vert *vout, __global float4 *uvout, __constant struct uniform *uni,
                                                                            read_only image3d_t tileHeightImage) {
  size_t groupId = get_group_id(0);
  size_t localId = get_local_id(0) * FACE_COUNT;
  struct modelinfo minfo = ol[groupId];
  int4 pos = (int4)(minfo.x, minfo.y, minfo.z, 0);

  if (localId == 0) {
    shared->min10 = 6000;
    for (int i = 0; i < 12; ++i) {
      shared->totalNum[i] = 0;
      shared->totalDistance[i] = 0;
    }
    for (int i = 0; i < 18; ++i) {
      shared->totalMappedNum[i] = 0;
    }
  }

  int prio[FACE_COUNT];
  int dis[FACE_COUNT];
  struct vert v1[FACE_COUNT];
  struct vert v2[FACE_COUNT];
  struct vert v3[FACE_COUNT];

  for (int i = 0; i < FACE_COUNT; i++) {
    get_face(shared, vb, tempvb, localId + i, minfo, uni->cameraYaw, uni->cameraPitch, &prio[i], &dis[i], &v1[i], &v2[i], &v3[i]);
  }

  barrier(CLK_LOCAL_MEM_FENCE);

  for (int i = 0; i < FACE_COUNT; i++) {
    add_face_prio_distance(shared, uni, localId + i, minfo, v1[i], v2[i], v3[i], prio[i], dis[i], pos);
  }

  barrier(CLK_LOCAL_MEM_FENCE);

  int prioAdj[FACE_COUNT];
  int idx[FACE_COUNT];
  for (int i = 0; i < FACE_COUNT; i++) {
    idx[i] = map_face_priority(shared, localId + i, minfo, prio[i], dis[i], &prioAdj[i]);
  }

  barrier(CLK_LOCAL_MEM_FENCE);

  for (int i = 0; i < FACE_COUNT; i++) {
    insert_face(shared, localId + i, minfo, prioAdj[i], dis[i], idx[i]);
  }

  barrier(CLK_LOCAL_MEM_FENCE);

  for (int i = 0; i < FACE_COUNT; i++) {
    sort_and_insert(shared, uni, texb, temptexb, vout, uvout, localId + i, minfo, prioAdj[i], dis[i], v1[i], v2[i], v3[i], tileHeightImage);
  }
}
