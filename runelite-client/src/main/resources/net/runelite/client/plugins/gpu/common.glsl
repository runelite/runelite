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

#include to_screen.glsl

/*
 * Rotate a vertex by a given orientation in JAU
 */
ivec4 rotate(ivec4 vertex, int orientation) {
  int s = int(65536.0f * sin(orientation * UNIT));
  int c = int(65536.0f * cos(orientation * UNIT));
  int x = vertex.z * s + vertex.x * c >> 16;
  int z = vertex.z * c - vertex.x * s >> 16;
  return ivec4(x, vertex.y, z, vertex.w);
}

/*
 * Calculate the distance to a vertex given the camera angle
 */
int distance(ivec4 vertex, int cameraYaw, int cameraPitch) {
  int yawSin = int(65536.0f * sin(cameraYaw * UNIT));
  int yawCos = int(65536.0f * cos(cameraYaw * UNIT));

  int pitchSin = int(65536.0f * sin(cameraPitch * UNIT));
  int pitchCos = int(65536.0f * cos(cameraPitch * UNIT));

  int j = vertex.z * yawCos - vertex.x * yawSin >> 16;
  int l = vertex.y * pitchSin + j * pitchCos >> 16;

  return l;
}

/*
 * Calculate the distance to a face
 */
int face_distance(ivec4 vA, ivec4 vB, ivec4 vC, int cameraYaw, int cameraPitch) {
  int dvA = distance(vA, cameraYaw, cameraPitch);
  int dvB = distance(vB, cameraYaw, cameraPitch);
  int dvC = distance(vC, cameraYaw, cameraPitch);
  int faceDistance = (dvA + dvB + dvC) / 3;
  return faceDistance;
}

/*
 * Test if a face is visible (not backward facing)
 */
bool face_visible(ivec4 vA, ivec4 vB, ivec4 vC, ivec4 position, int cameraYaw, int cameraPitch, int centerX, int centerY, int zoom) {
  vA += position;
  vB += position;
  vC += position;

  ivec3 sA = toScreen(vA.xyz, cameraYaw, cameraPitch, centerX, centerY, zoom);
  ivec3 sB = toScreen(vB.xyz, cameraYaw, cameraPitch, centerX, centerY, zoom);
  ivec3 sC = toScreen(vC.xyz, cameraYaw, cameraPitch, centerX, centerY, zoom);

  return (sA.x - sB.x) * (sC.y - sB.y) - (sC.x - sB.x) * (sA.y - sB.y) > 0;
}

// Calculate adjusted priority for a face with a given priority, distance, and
// model global min10 and face distance averages. This allows positioning faces
// with priorities 10/11 into the correct 'slots' resulting in 18 possible
// adjusted priorities
int priority_map(int p, int distance, int _min10, int avg1, int avg2, int avg3) {
  // (10, 11)  0  1  2  (10, 11)  3  4  (10, 11)  5  6  7  8  9  (10, 11)
  //   0   1   2  3  4    5   6   7  8    9  10  11 12 13 14 15   16  17
  switch (p) {
    case 0: return 2;
    case 1: return 3;
    case 2: return 4;
    case 3: return 7;
    case 4: return 8;
    case 5: return 11;
    case 6: return 12;
    case 7: return 13;
    case 8: return 14;
    case 9: return 15;
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
      return -1;
  }
}

// calculate the number of faces with a lower adjusted priority than
// the given adjusted priority
int count_prio_offset(int priority) {
  int total = 0;
  switch (priority) {
    case 17:
      total += totalMappedNum[16];
    case 16:
      total += totalMappedNum[15];
    case 15:
      total += totalMappedNum[14];
    case 14:
      total += totalMappedNum[13];
    case 13:
      total += totalMappedNum[12];
    case 12:
      total += totalMappedNum[11];
    case 11:
      total += totalMappedNum[10];
    case 10:
      total += totalMappedNum[9];
    case 9:
      total += totalMappedNum[8];
    case 8:
      total += totalMappedNum[7];
    case 7:
      total += totalMappedNum[6];
    case 6:
      total += totalMappedNum[5];
    case 5:
      total += totalMappedNum[4];
    case 4:
      total += totalMappedNum[3];
    case 3:
      total += totalMappedNum[2];
    case 2:
      total += totalMappedNum[1];
    case 1:
      total += totalMappedNum[0];
    case 0:
      return total;
  }
}
