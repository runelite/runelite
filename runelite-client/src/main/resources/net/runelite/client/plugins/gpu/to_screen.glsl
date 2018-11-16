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

/*
 * Convert a vertex to screen space
 */
ivec3 toScreen(ivec3 vertex, int cameraYaw, int cameraPitch, int centerX, int centerY, int zoom) {
  int yawSin = int(65536.0f * sin(cameraYaw * UNIT));
  int yawCos = int(65536.0f * cos(cameraYaw * UNIT));

  int pitchSin = int(65536.0f * sin(cameraPitch * UNIT));
  int pitchCos = int(65536.0f * cos(cameraPitch * UNIT));

  int rotatedX = ((vertex.z * yawSin) + (vertex.x * yawCos)) >> 16;
  int rotatedZ = ((vertex.z * yawCos) - (vertex.x * yawSin)) >> 16;

  int var13 = ((vertex.y * pitchCos) - (rotatedZ * pitchSin)) >> 16;
  int var12 = ((vertex.y * pitchSin) + (rotatedZ * pitchCos)) >> 16;

  int x = rotatedX * zoom / var12 + centerX;
  int y = var13 * zoom / var12 + centerY;
  int z = -var12; // in OpenGL depth is negative

  return ivec3(x, y, z);
}
