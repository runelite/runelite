/*
   Hyllian's xBR-lv2 Shader

   Copyright (C) 2011-2016 Hyllian - sergiogdb@gmail.com

   Permission is hereby granted, free of charge, to any person obtaining a copy
   of this software and associated documentation files (the "Software"), to deal
   in the Software without restriction, including without limitation the rights
   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
   copies of the Software, and to permit persons to whom the Software is
   furnished to do so, subject to the following conditions:

   The above copyright notice and this permission notice shall be included in
   all copies or substantial portions of the Software.

   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
   THE SOFTWARE.

   Incorporates some of the ideas from SABR shader. Thanks to Joshua Street.
*/

#include "scale/xbr_lv2_common.glsl"

XBRTable xbr_vert(vec2 texCoord, ivec2 sourceDimensions) {
  float dx = (1.0 / sourceDimensions.x);
  float dy = (1.0 / sourceDimensions.y);

  // Define coordinates to optimize later fetching of adjacent pixels
  //    A1 B1 C1
  // A0  A  B  C C4
  // D0  D  E  F F4
  // G0  G  H  I I4
  //    G5 H5 I5
  XBRTable tab = XBRTable(texCoord, texCoord.xxxy + vec4(-dx, 0, dx, -2.0 * dy),  // A1 B1 C1
                          texCoord.xxxy + vec4(-dx, 0, dx, -dy),                  //  A  B  C
                          texCoord.xxxy + vec4(-dx, 0, dx, 0),                    //  D  E  F
                          texCoord.xxxy + vec4(-dx, 0, dx, dy),                   //  G  H  I
                          texCoord.xxxy + vec4(-dx, 0, dx, 2.0 * dy),             // G5 H5 I5
                          texCoord.xyyy + vec4(-2.0 * dx, -dy, 0, dy),            // A0 D0 G0
                          texCoord.xyyy + vec4(2.0 * dx, -dy, 0, dy)              // C4 F4 I4
  );

  tab.texCoord.x *= 1.00000001;

  return tab;
}