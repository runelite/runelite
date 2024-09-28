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

// Calculate adjusted priority for a face with a given priority, distance, and
// model global min10 and face distance averages. This allows positioning faces
// with priorities 10/11 into the correct 'slots' resulting in 18 possible
// adjusted priorities
int priority_map(int p, int distance, int _min10, int avg1, int avg2, int avg3) {
  // (10, 11)  0  1  2  (10, 11)  3  4  (10, 11)  5  6  7  8  9  (10, 11)
  //   0   1   2  3  4    5   6   7  8    9  10  11 12 13 14 15   16  17
  switch (p) {
    case 0:
      return 2;
    case 1:
      return 3;
    case 2:
      return 4;
    case 3:
      return 7;
    case 4:
      return 8;
    case 5:
      return 11;
    case 6:
      return 12;
    case 7:
      return 13;
    case 8:
      return 14;
    case 9:
      return 15;
    case 10:
      if (distance > avg1) {
        return 0;
      } else if (distance > avg2) {
        return 5;
      } else if (distance > avg3) {
        return 9;
      } else {
        return 16;
      }
    case 11:
      if (distance > avg1 && _min10 > avg1) {
        return 1;
      } else if (distance > avg2 && (_min10 > avg1 || _min10 > avg2)) {
        return 6;
      } else if (distance > avg3 && (_min10 > avg1 || _min10 > avg2 || _min10 > avg3)) {
        return 10;
      } else {
        return 17;
      }
    default:
      // this can't happen unless an invalid priority is sent. just assume 0.
      return 0;
  }
}

// calculate the number of faces with a lower adjusted priority than
// the given adjusted priority
int count_prio_offset(__local struct shared_data *shared, int priority) {
  // this shouldn't ever be outside of (0, 17) because it is the return value from priority_map
  priority = clamp(priority, 0, 17);
  int total = 0;
  for (int i = 0; i < priority; i++) {
    total += shared->totalMappedNum[i];
  }
  return total;
}

void get_face(__local struct shared_data *shared, __global const struct vert *vb, __global const struct vert *tempvb, uint localId, struct modelinfo minfo,
              float cameraYaw, float cameraPitch,
              /* out */ int *prio, int *dis, struct vert *o1, struct vert *o2, struct vert *o3) {
  int size = minfo.size;
  int offset = minfo.offset;
  int flags = minfo.flags;
  uint ssboOffset;

  if (localId < size) {
    ssboOffset = localId;
  } else {
    ssboOffset = 0;
  }

  struct vert thisA;
  struct vert thisB;
  struct vert thisC;

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

  if (localId < size) {
    int orientation = flags & 0x7ff;

    // rotate for model orientation
    float4 thisrvA = rotate_vertex((float4)(thisA.x, thisA.y, thisA.z, 0), orientation);
    float4 thisrvB = rotate_vertex((float4)(thisB.x, thisB.y, thisB.z, 0), orientation);
    float4 thisrvC = rotate_vertex((float4)(thisC.x, thisC.y, thisC.z, 0), orientation);

    // calculate distance to face
    int thisPriority = (thisA.ahsl >> 16) & 0xff;  // all vertices on the face have the same priority
    int thisDistance = face_distance(thisrvA, thisrvB, thisrvC, cameraYaw, cameraPitch);

    *o1 = (struct vert){thisrvA.x, thisrvA.y, thisrvA.z, thisA.ahsl};
    *o2 = (struct vert){thisrvB.x, thisrvB.y, thisrvB.z, thisB.ahsl};
    *o3 = (struct vert){thisrvC.x, thisrvC.y, thisrvC.z, thisC.ahsl};

    *prio = thisPriority;
    *dis = thisDistance;
  } else {
    *o1 = (struct vert){0, 0, 0, 0};
    *o2 = (struct vert){0, 0, 0, 0};
    *o3 = (struct vert){0, 0, 0, 0};
    *prio = 0;
    *dis = 0;
  }
}

void add_face_prio_distance(__local struct shared_data *shared, __constant struct uniform *uni, uint localId, struct modelinfo minfo, struct vert thisrvA,
                            struct vert thisrvB, struct vert thisrvC, int thisPriority, int thisDistance, int4 pos) {
  if (localId < minfo.size) {
    // if the face is not culled, it is calculated into priority distance averages
    float3 posA = (float3)(thisrvA.x, thisrvA.y, thisrvA.z);
    float3 posB = (float3)(thisrvB.x, thisrvB.y, thisrvB.z);
    float3 posC = (float3)(thisrvC.x, thisrvC.y, thisrvC.z);
    if (face_visible(uni, posA, posB, posC, pos)) {
      atomic_add(&shared->totalNum[thisPriority], 1);
      atomic_add(&shared->totalDistance[thisPriority], thisDistance);

      // calculate minimum distance to any face of priority 10 for positioning the 11 faces later
      if (thisPriority == 10) {
        atomic_min(&shared->min10, thisDistance);
      }
    }
  }
}

int map_face_priority(__local struct shared_data *shared, uint localId, struct modelinfo minfo, int thisPriority, int thisDistance, int *prio) {
  int size = minfo.size;

  // Compute average distances for 0/2, 3/4, and 6/8

  if (localId < size) {
    int avg1 = -6000;
    int avg2 = -6000;
    int avg3 = -6000;

    if (shared->totalNum[1] > 0 || shared->totalNum[2] > 0) {
      avg1 = (shared->totalDistance[1] + shared->totalDistance[2]) / (shared->totalNum[1] + shared->totalNum[2]);
    }

    if (shared->totalNum[3] > 0 || shared->totalNum[4] > 0) {
      avg2 = (shared->totalDistance[3] + shared->totalDistance[4]) / (shared->totalNum[3] + shared->totalNum[4]);
    }

    if (shared->totalNum[6] > 0 || shared->totalNum[8] > 0) {
      avg3 = (shared->totalDistance[6] + shared->totalDistance[8]) / (shared->totalNum[6] + shared->totalNum[8]);
    }

    int adjPrio = priority_map(thisPriority, thisDistance, shared->min10, avg1, avg2, avg3);
    int prioIdx = atomic_add(&shared->totalMappedNum[adjPrio], 1);

    *prio = adjPrio;
    return prioIdx;
  }

  *prio = 0;
  return 0;
}

void insert_face(__local struct shared_data *shared, uint localId, struct modelinfo minfo, int adjPrio, int distance, int prioIdx) {
  int size = minfo.size;

  if (localId < size) {
    // calculate base offset into renderPris based on number of faces with a lower priority
    int baseOff = count_prio_offset(shared, adjPrio);
    // the furthest faces draw first, and have the highest priority.
    // if two faces have the same distance, the one with the
    // lower id draws first.
    shared->renderPris[baseOff + prioIdx] = distance << 16 | (int)(~localId & 0xffffu);
  }
}

int tile_height(read_only image3d_t tileHeightImage, int z, int x, int y) {
#define ESCENE_OFFSET 40  // (184-104)/2
  const sampler_t tileHeightSampler = CLK_NORMALIZED_COORDS_FALSE | CLK_ADDRESS_CLAMP_TO_EDGE;
  int4 coord = (int4)(x + ESCENE_OFFSET, y + ESCENE_OFFSET, z, 0);
  return read_imagei(tileHeightImage, tileHeightSampler, coord).x << 3;
}

float4 hillskew_vertexf(read_only image3d_t tileHeightImage, float4 v, int hillskew, int y, int plane) {
  if (hillskew == 1) {
    float fx = v.x / 128;
    float fz = v.z / 128;
    int sx = (int)(floor(fx));
    int sz = (int)(floor(fz));
    float it;
    float h1 = mix((float)tile_height(tileHeightImage, plane, sx, sz), (float)tile_height(tileHeightImage, plane, sx + 1, sz), fract(fx, &it));
    float h2 = mix((float)tile_height(tileHeightImage, plane, sx, sz + 1), (float)tile_height(tileHeightImage, plane, sx + 1, sz + 1), fract(fx, &it));
    float h3 = mix(h1, h2, fract(fz, &it));
    return (float4)(v.x, v.y + h3 - y, v.z, v.w);
  } else {
    return v;
  }
}

void sort_and_insert(__local struct shared_data *shared, __constant struct uniform *uni, __global const float4 *texb, __global const float4 *temptexb,
                     __global struct vert *vout, __global float4 *uvout, uint localId, struct modelinfo minfo, int thisPriority, int thisDistance,
                     struct vert thisrvA, struct vert thisrvB, struct vert thisrvC, read_only image3d_t tileHeightImage) {
  int size = minfo.size;

  if (localId < size) {
    int outOffset = minfo.idx;
    int toffset = minfo.toffset;
    int flags = minfo.flags;

    // we only have to order faces against others of the same priority
    const int priorityOffset = count_prio_offset(shared, thisPriority);
    const int numOfPriority = shared->totalMappedNum[thisPriority];
    const int start = priorityOffset;                // index of first face with this priority
    const int end = priorityOffset + numOfPriority;  // index of last face with this priority
    const int renderPriority = thisDistance << 16 | (int)(~localId & 0xffffu);
    int myOffset = priorityOffset;

    // calculate position this face will be in
    for (int i = start; i < end; ++i) {
      if (renderPriority < shared->renderPris[i]) {
        ++myOffset;
      }
    }

    // position into scene
    float4 pos = (float4)(minfo.x, minfo.y, minfo.z, 0);
    float4 vertA = (float4)(thisrvA.x, thisrvA.y, thisrvA.z, 0) + pos;
    float4 vertB = (float4)(thisrvB.x, thisrvB.y, thisrvB.z, 0) + pos;
    float4 vertC = (float4)(thisrvC.x, thisrvC.y, thisrvC.z, 0) + pos;

    // apply hillskew
    int plane = (flags >> 24) & 3;
    int hillskew = (flags >> 26) & 1;
    vertA = hillskew_vertexf(tileHeightImage, vertA, hillskew, minfo.y, plane);
    vertB = hillskew_vertexf(tileHeightImage, vertB, hillskew, minfo.y, plane);
    vertC = hillskew_vertexf(tileHeightImage, vertC, hillskew, minfo.y, plane);

    // write to out buffer
    vout[outOffset + myOffset * 3] = (struct vert){vertA.x, vertA.y, vertA.z, thisrvA.ahsl};
    vout[outOffset + myOffset * 3 + 1] = (struct vert){vertB.x, vertB.y, vertB.z, thisrvB.ahsl};
    vout[outOffset + myOffset * 3 + 2] = (struct vert){vertC.x, vertC.y, vertC.z, thisrvC.ahsl};

    if (toffset < 0) {
      uvout[outOffset + myOffset * 3] = (float4)(0, 0, 0, 0);
      uvout[outOffset + myOffset * 3 + 1] = (float4)(0, 0, 0, 0);
      uvout[outOffset + myOffset * 3 + 2] = (float4)(0, 0, 0, 0);
    } else {
      float4 texA, texB, texC;

      if (flags >= 0) {
        texA = temptexb[toffset + localId * 3];
        texB = temptexb[toffset + localId * 3 + 1];
        texC = temptexb[toffset + localId * 3 + 2];
      } else {
        texA = texb[toffset + localId * 3];
        texB = texb[toffset + localId * 3 + 1];
        texC = texb[toffset + localId * 3 + 2];
      }

      int orientation = flags & 0x7ff;
      // swizzle from (tex,x,y,z) to (x,y,z,tex) for rotate and hillskew
      texA = texA.yzwx;
      texB = texB.yzwx;
      texC = texC.yzwx;
      // rotate
      texA = rotate_vertex(texA, orientation);
      texB = rotate_vertex(texB, orientation);
      texC = rotate_vertex(texC, orientation);
      // position
      texA += pos;
      texB += pos;
      texC += pos;
      // hillskew
      texA = hillskew_vertexf(tileHeightImage, texA, hillskew, minfo.y, plane);
      texB = hillskew_vertexf(tileHeightImage, texB, hillskew, minfo.y, plane);
      texC = hillskew_vertexf(tileHeightImage, texC, hillskew, minfo.y, plane);
      uvout[outOffset + myOffset * 3] = texA.wxyz;
      uvout[outOffset + myOffset * 3 + 1] = texB.wxyz;
      uvout[outOffset + myOffset * 3 + 2] = texC.wxyz;
    }
  }
}
