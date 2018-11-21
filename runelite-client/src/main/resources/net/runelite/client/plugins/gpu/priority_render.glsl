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

void get_face(uint localId, modelinfo minfo, int cameraYaw, int cameraPitch, int centerX, int centerY, int zoom,
    out int prio, out int dis, out ivec4 o1, out ivec4 o2, out ivec4 o3) {
  int offset = minfo.offset;
  int length = minfo.length;
  int flags = minfo.flags;
  int radius = (flags & 0x7fffffff) >> 12;
  int orientation = flags & 0x7ff;
  ivec4 pos = ivec4(minfo.x, minfo.y, minfo.z, 0);

  uint ssboOffset;

  if (localId < length) {
    ssboOffset = localId;
  } else {
    ssboOffset = 0;
  }

  ivec4 thisA;
  ivec4 thisB;
  ivec4 thisC;

  // Grab triangle vertices from the correct buffer
  if (flags < 0) {
    thisA = vb[offset + ssboOffset * 3    ];
    thisB = vb[offset + ssboOffset * 3 + 1];
    thisC = vb[offset + ssboOffset * 3 + 2];
  } else {
    thisA = tempvb[offset + ssboOffset * 3    ];
    thisB = tempvb[offset + ssboOffset * 3 + 1];
    thisC = tempvb[offset + ssboOffset * 3 + 2];
  }

  ivec4 thisrvA;
  ivec4 thisrvB;
  ivec4 thisrvC;

  int thisPriority, thisDistance;

  if (localId < length) {
    // rotate for model orientation
    thisrvA = rotate(thisA, orientation);
    thisrvB = rotate(thisB, orientation);
    thisrvC = rotate(thisC, orientation);

    // calculate distance to face
    thisPriority = (thisA.w >> 16) & 0xff; // all vertices on the face have the same priority
    if (radius == 0) {
      thisDistance = 0;
    } else {
      thisDistance = face_distance(thisrvA, thisrvB, thisrvC, cameraYaw, cameraPitch) + radius;
    }

    // if the face is not culled, it is calculated into priority distance averages
    if (face_visible(thisrvA, thisrvB, thisrvC, pos, cameraYaw, cameraPitch, centerX, centerY, zoom)) {
      atomicAdd(totalNum[thisPriority], 1);
      atomicAdd(totalDistance[thisPriority], thisDistance);

      // calculate minimum distance to any face of priority 10 for positioning the 11 faces later
      if (thisPriority == 10) {
        atomicMin(min10, thisDistance);
      }
    }

    o1 = thisrvA;
    o2 = thisrvB;
    o3 = thisrvC;

    prio = thisPriority;
    dis = thisDistance;
  } else {
    prio = 0;
    dis = 0;
  }
}

int map_face_priority(uint localId, modelinfo minfo, int thisPriority, int thisDistance, out int prio) {
  int length = minfo.length;

  // Compute average distances for 0/2, 3/4, and 6/8

  int adjPrio;
  int prioIdx;

  if (localId < length) {
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

    int _min10 = min10;
    adjPrio = priority_map(thisPriority, thisDistance, _min10, avg1, avg2, avg3);

    int prioIdx = atomicAdd(totalMappedNum[adjPrio], 1);

    prio = adjPrio;

    return prioIdx;
  }

  return 0;
}

void insert_dfs(uint localId, modelinfo minfo, int adjPrio, int distance, int prioIdx) {
  int length = minfo.length;

  if (localId < length) {
    // calculate base offset into dfs based on number of faces with a lower priority
    int baseOff = count_prio_offset(adjPrio);
    // store into face array offset array by unique index
    dfs[baseOff + prioIdx] = (int(localId) << 16) | distance;
  }
}

void sort_and_insert(uint localId, modelinfo minfo, int thisPriority, int thisDistance, ivec4 thisrvA, ivec4 thisrvB, ivec4 thisrvC) {
  /* compute face distance */
  int length = minfo.length;
  int outOffset = minfo.idx;
  int uvOffset = minfo.uvOffset;
  int flags = minfo.flags;
  ivec4 pos = ivec4(minfo.x, minfo.y, minfo.z, 0);

  int start, end, myOffset;
  if (localId < length) {
    const int priorityOffset = count_prio_offset(thisPriority);
    const int numOfPriority = totalMappedNum[thisPriority];
    start = priorityOffset; // index of first face with this priority
    end = priorityOffset + numOfPriority; // index of last face with this priority
    myOffset = priorityOffset;
  } else {
    start = end = myOffset = 0;
  }

  if (localId < length) {
    // we only have to order faces against others of the same priority
    // calculate position this face will be in
    for (int i = start; i < end; ++i) {
      int d1 = dfs[i];
      int theirId = d1 >> 16;
      int theirDistance = d1 & 0xffff;

      // the closest faces draw last, so have the highest index
      // if two faces have the same distance, the one with the
      // higher id draws last
      if ((theirDistance > thisDistance)
        || (theirDistance == thisDistance && theirId < localId)) {
        ++myOffset;
      }
    }

    // position vertices in scene and write to out buffer
    vout[outOffset + myOffset * 3]     = pos + thisrvA;
    vout[outOffset + myOffset * 3 + 1] = pos + thisrvB;
    vout[outOffset + myOffset * 3 + 2] = pos + thisrvC;

    if (uvOffset < 0) {
      uvout[outOffset + myOffset * 3]     = vec4(0, 0, 0, 0);
      uvout[outOffset + myOffset * 3 + 1] = vec4(0, 0, 0, 0);
      uvout[outOffset + myOffset * 3 + 2] = vec4(0, 0, 0, 0);
    } else if (flags >= 0) {
      uvout[outOffset + myOffset * 3]     = tempuv[uvOffset + localId * 3];
      uvout[outOffset + myOffset * 3 + 1] = tempuv[uvOffset + localId * 3 + 1];
      uvout[outOffset + myOffset * 3 + 2] = tempuv[uvOffset + localId * 3 + 2];
    } else {
      uvout[outOffset + myOffset * 3]     = uv[uvOffset + localId * 3];
      uvout[outOffset + myOffset * 3 + 1] = uv[uvOffset + localId * 3 + 1];
      uvout[outOffset + myOffset * 3 + 2] = uv[uvOffset + localId * 3 + 2];
    }
  }
}
