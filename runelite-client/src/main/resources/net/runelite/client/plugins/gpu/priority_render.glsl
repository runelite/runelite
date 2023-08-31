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
int count_prio_offset(int priority) {
  // this shouldn't ever be outside of (0, 17) because it is the return value from priority_map
  priority = clamp(priority, 0, 17);
  int total = 0;
  for (int i = 0; i < priority; i++) {
    total += totalMappedNum[i];
  }
  return total;
}

void get_face(uint localId, modelinfo minfo, int cameraYaw, int cameraPitch, out int prio, out int dis, out ivec4 o1, out ivec4 o2, out ivec4 o3) {
  int size = minfo.size;
  int offset = minfo.offset;
  int flags = minfo.flags;
  uint ssboOffset;

  if (localId < size) {
    ssboOffset = localId;
  } else {
    ssboOffset = 0;
  }

  ivec4 thisA;
  ivec4 thisB;
  ivec4 thisC;

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
    int radius = (flags & 0x7fffffff) >> 12;
    int orientation = flags & 0x7ff;

    // rotate for model orientation
    ivec4 thisrvA = rotate(thisA, orientation);
    ivec4 thisrvB = rotate(thisB, orientation);
    ivec4 thisrvC = rotate(thisC, orientation);

    // calculate distance to face
    int thisPriority = (thisA.w >> 16) & 0xff;  // all vertices on the face have the same priority
    int thisDistance;
    if (radius == 0) {
      thisDistance = 0;
    } else {
      thisDistance = face_distance(thisrvA, thisrvB, thisrvC, cameraYaw, cameraPitch) + radius;
    }

    o1 = thisrvA;
    o2 = thisrvB;
    o3 = thisrvC;

    prio = thisPriority;
    dis = thisDistance;
  } else {
    o1 = ivec4(0);
    o2 = ivec4(0);
    o3 = ivec4(0);
    prio = 0;
    dis = 0;
  }
}

void add_face_prio_distance(uint localId, modelinfo minfo, ivec4 thisrvA, ivec4 thisrvB, ivec4 thisrvC, int thisPriority, int thisDistance, ivec4 pos) {
  if (localId < minfo.size) {
    // if the face is not culled, it is calculated into priority distance averages
    if (face_visible(thisrvA, thisrvB, thisrvC, pos)) {
      atomicAdd(totalNum[thisPriority], 1);
      atomicAdd(totalDistance[thisPriority], thisDistance);

      // calculate minimum distance to any face of priority 10 for positioning the 11 faces later
      if (thisPriority == 10) {
        atomicMin(min10, thisDistance);
      }
    }
  }
}

int map_face_priority(uint localId, modelinfo minfo, int thisPriority, int thisDistance, out int prio) {
  int size = minfo.size;

  // Compute average distances for 0/2, 3/4, and 6/8

  if (localId < size) {
    int avg1 = 0;
    int avg2 = 0;
    int avg3 = 0;

    if (totalNum[1] > 0 || totalNum[2] > 0) {
      avg1 = (totalDistance[1] + totalDistance[2]) / (totalNum[1] + totalNum[2]);
    }

    if (totalNum[3] > 0 || totalNum[4] > 0) {
      avg2 = (totalDistance[3] + totalDistance[4]) / (totalNum[3] + totalNum[4]);
    }

    if (totalNum[6] > 0 || totalNum[8] > 0) {
      avg3 = (totalDistance[6] + totalDistance[8]) / (totalNum[6] + totalNum[8]);
    }

    int adjPrio = priority_map(thisPriority, thisDistance, min10, avg1, avg2, avg3);
    int prioIdx = atomicAdd(totalMappedNum[adjPrio], 1);

    prio = adjPrio;
    return prioIdx;
  }

  prio = 0;
  return 0;
}

void insert_face(uint localId, modelinfo minfo, int adjPrio, int distance, int prioIdx) {
  int size = minfo.size;

  if (localId < size) {
    // calculate base offset into renderPris based on number of faces with a lower priority
    int baseOff = count_prio_offset(adjPrio);
    // the furthest faces draw first, and have the highest value
    // if two faces have the same distance, the one with the
    // lower id draws first
    renderPris[baseOff + prioIdx] = uint(distance << 16) | (~localId & 0xffffu);
  }
}

void sort_and_insert(uint localId, modelinfo minfo, int thisPriority, int thisDistance, ivec4 thisrvA, ivec4 thisrvB, ivec4 thisrvC) {
  int size = minfo.size;

  if (localId < size) {
    int outOffset = minfo.idx;
    int toffset = minfo.toffset;
    int flags = minfo.flags;

    // we only have to order faces against others of the same priority
    const int priorityOffset = count_prio_offset(thisPriority);
    const int numOfPriority = totalMappedNum[thisPriority];
    const int start = priorityOffset;                // index of first face with this priority
    const int end = priorityOffset + numOfPriority;  // index of last face with this priority
    const uint renderPriority = uint(thisDistance << 16) | (~localId & 0xffffu);
    int myOffset = priorityOffset;

    // calculate position this face will be in
    for (int i = start; i < end; ++i) {
      if (renderPriority < renderPris[i]) {
        ++myOffset;
      }
    }

    ivec4 pos = ivec4(minfo.x, minfo.y, minfo.z, 0);
    int orientation = flags & 0x7ff;

    // position vertices in scene and write to out buffer
    vout[outOffset + myOffset * 3] = pos + thisrvA;
    vout[outOffset + myOffset * 3 + 1] = pos + thisrvB;
    vout[outOffset + myOffset * 3 + 2] = pos + thisrvC;

    if (toffset < 0) {
      uvout[outOffset + myOffset * 3] = vec4(0);
      uvout[outOffset + myOffset * 3 + 1] = vec4(0);
      uvout[outOffset + myOffset * 3 + 2] = vec4(0);
    } else {
      vec4 texA, texB, texC;

      if (flags >= 0) {
        texA = temptexb[toffset + localId * 3];
        texB = temptexb[toffset + localId * 3 + 1];
        texC = temptexb[toffset + localId * 3 + 2];
      } else {
        texA = texb[toffset + localId * 3];
        texB = texb[toffset + localId * 3 + 1];
        texC = texb[toffset + localId * 3 + 2];
      }

      uvout[outOffset + myOffset * 3] = vec4(texA.x, rotatef(texA.yzw, orientation) + pos.xyz);
      uvout[outOffset + myOffset * 3 + 1] = vec4(texB.x, rotatef(texB.yzw, orientation) + pos.xyz);
      uvout[outOffset + myOffset * 3 + 2] = vec4(texC.x, rotatef(texC.yzw, orientation) + pos.xyz);
    }
  }
}
