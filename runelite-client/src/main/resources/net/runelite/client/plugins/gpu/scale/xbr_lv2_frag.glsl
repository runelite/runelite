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

//   PARAMETERS   //
// Uncomment just one of the four params below to choose the corner detection
//#define CORNER_A
//#define CORNER_B
#define CORNER_C
//#define CORNER_D

#define XBR_Y_WEIGHT 50.0           // involved in preserving small details if small_details = 1, otherwise unused
#define XBR_EQ_THRESHOLD 9.0        // equality threshold for comparisons
//#define XBR_LV1_COEFFICIENT 0.5   // unused, probably left over from a previous iteration
#define XBR_LV2_COEFFICIENT 2.0     // moves the step in a step function at one point during blending
#define small_details 1.0           // 0 or 1, switches logic in a few spots to help preserve small details
// END PARAMETERS //

#define mul(a,b) (b*a)
#define lv2_cf XBR_LV2_COEFFICIENT
#ifndef CORNER_A
#define SMOOTH_TIPS
#endif

//const float coef         = 2.0; // unused
const vec3 rgbw          = vec3(14.352, 28.176, 5.472);     // rgb weights
//const vec4 eq_threshold  = vec4(15.0, 15.0, 15.0, 15.0); // unused

const  vec4 Ao = vec4( 1.0, -1.0, -1.0, 1.0 );
const  vec4 Bo = vec4( 1.0,  1.0, -1.0,-1.0 );
const  vec4 Co = vec4( 1.5,  0.5, -0.5, 0.5 );
const  vec4 Ax = vec4( 1.0, -1.0, -1.0, 1.0 );
const  vec4 Bx = vec4( 0.5,  2.0, -0.5,-2.0 );
const  vec4 Cx = vec4( 1.0,  1.0, -0.5, 0.0 );
const  vec4 Ay = vec4( 1.0, -1.0, -1.0, 1.0 );
const  vec4 By = vec4( 2.0,  0.5, -2.0,-0.5 );
const  vec4 Cy = vec4( 2.0,  0.0, -1.0, 0.5 );
const  vec4 Ci = vec4(0.25, 0.25, 0.25, 0.25);

const vec3 Y = vec3(0.2126, 0.7152, 0.0722); // rec.709 luma weights

// Difference between vector components.
vec4 df(vec4 A, vec4 B)
{
    return vec4(abs(A-B));
}

// Compare two vectors and return their components are different.
vec4 diff(vec4 A, vec4 B)
{
    return vec4(notEqual(A, B));
}

// Determine if two vector components are equal based on a threshold.
vec4 eq(vec4 A, vec4 B)
{
    return (step(df(A, B), vec4(XBR_EQ_THRESHOLD)));
}

// Determine if two vector components are NOT equal based on a threshold.
vec4 neq(vec4 A, vec4 B)
{
    return (vec4(1.0, 1.0, 1.0, 1.0) - eq(A, B));
}

// Weighted distance.
vec4 wd(vec4 a, vec4 b, vec4 c, vec4 d, vec4 e, vec4 f, vec4 g, vec4 h)
{
    return (df(a,b) + df(a,c) + df(d,e) + df(d,f) + 4.0*df(g,h));
}

vec4 weighted_distance(vec4 a, vec4 b, vec4 c, vec4 d, vec4 e, vec4 f, vec4 g, vec4 h, vec4 i, vec4 j, vec4 k, vec4 l)
{
    return (df(a,b) + df(a,c) + df(d,e) + df(d,f) + df(i,j) + df(k,l) + 2.0*df(g,h));
}

float c_df(vec3 c1, vec3 c2)
{
    vec3 df = abs(c1 - c2);
    return df.r + df.g + df.b;
}

#include scale/xbr_lv2_common.glsl


// xBR-level2 upscaler. Level 2 means it detects edges in 2 directions, instead of just 1 in the most basic form of the algorithm.
// This improves quality by a good bit without adding too much complexity compared to available level-3 and level-4 algorithms.
vec4 textureXBR(sampler2D image, vec2 texCoord, XBRTable t, float scale)
{
    vec4 delta   = vec4(1.0/scale, 1.0/scale, 1.0/scale, 1.0/scale);
    vec4 delta_l = vec4(0.5/scale, 1.0/scale, 0.5/scale, 1.0/scale);
    vec4 delta_u = delta_l.yxwz;

    vec2 textureDimensions = textureSize(image, 0);

    vec4 edri, edr, edr_l, edr_u, px; // px = pixel, edr = edge detection rule
    vec4 irlv0, irlv1, irlv2l, irlv2u, block_3d;
    vec4 fx, fx_l, fx_u; // inequations of straight lines.

    vec2 fp = fract(texCoord*textureDimensions);

    //    A1 B1 C1
    // A0  A  B  C C4
    // D0  D  E  F F4
    // G0  G  H  I I4
    //    G5 H5 I5
    vec4 A1 = texture(image, t.t1.xw );
    vec4 B1 = texture(image, t.t1.yw );
    vec4 C1 = texture(image, t.t1.zw );
    vec4 A  = texture(image, t.t2.xw );
    vec4 B  = texture(image, t.t2.yw );
    vec4 C  = texture(image, t.t2.zw );
    vec4 D  = texture(image, t.t3.xw );
    vec4 E  = texture(image, t.t3.yw );
    vec4 F  = texture(image, t.t3.zw );
    vec4 G  = texture(image, t.t4.xw );
    vec4 H  = texture(image, t.t4.yw );
    vec4 I  = texture(image, t.t4.zw );
    vec4 G5 = texture(image, t.t5.xw );
    vec4 H5 = texture(image, t.t5.yw );
    vec4 I5 = texture(image, t.t5.zw );
    vec4 A0 = texture(image, t.t6.xy );
    vec4 D0 = texture(image, t.t6.xz );
    vec4 G0 = texture(image, t.t6.xw );
    vec4 C4 = texture(image, t.t7.xy );
    vec4 F4 = texture(image, t.t7.xz );
    vec4 I4 = texture(image, t.t7.xw );

    vec4 b  = vec4(dot(B.xyz ,rgbw), dot(D.xyz ,rgbw), dot(H.xyz ,rgbw), dot(F.xyz ,rgbw));
    vec4 c  = vec4(dot(C.xyz ,rgbw), dot(A.xyz ,rgbw), dot(G.xyz ,rgbw), dot(I.xyz ,rgbw));
    vec4 d  = b.yzwx;
    vec4 e  = vec4(dot(E.xyz,rgbw));
    vec4 f  = b.wxyz;
    vec4 g  = c.zwxy;
    vec4 h  = b.zwxy;
    vec4 i  = c.wxyz;

    vec4 i4, i5, h5, f4;

    float y_weight = XBR_Y_WEIGHT;

    if (small_details < 0.5)
    {
        i4 = vec4(dot(I4.xyz,rgbw), dot(C1.xyz,rgbw), dot(A0.xyz,rgbw), dot(G5.xyz,rgbw));
        i5 = vec4(dot(I5.xyz,rgbw), dot(C4.xyz,rgbw), dot(A1.xyz,rgbw), dot(G0.xyz,rgbw));
        h5 = vec4(dot(H5.xyz,rgbw), dot(F4.xyz,rgbw), dot(B1.xyz,rgbw), dot(D0.xyz,rgbw));
    }
    else
    {
        i4 = mul( mat4x3(I4.xyz, C1.xyz, A0.xyz, G5.xyz), y_weight * Y );
        i5 = mul( mat4x3(I5.xyz, C4.xyz, A1.xyz, G0.xyz), y_weight * Y );
        h5 = mul( mat4x3(H5.xyz, F4.xyz, B1.xyz, D0.xyz), y_weight * Y );
    }

    // These inequations define the line below which interpolation occurs.
    fx   = (Ao*fp.y+Bo*fp.x);
    fx_l = (Ax*fp.y+Bx*fp.x);
    fx_u = (Ay*fp.y+By*fp.x);

    // corner detection
    irlv1 = irlv0 = diff(e,f) * diff(e,h);
    #ifdef CORNER_B
    irlv1      = (irlv0 * ( neq(f,b) * neq(h,d) + eq(e,i) * neq(f,i4) * neq(h,i5) + eq(e,g) + eq(e,c) ) );
    #endif
    #ifdef CORNER_D
    vec4 c1 = i4.yzwx;
    vec4 g0 = i5.wxyz;
    irlv1     = (irlv0  *  ( neq(f,b) * neq(h,d) + eq(e,i) * neq(f,i4) * neq(h,i5) + eq(e,g) + eq(e,c) ) * (diff(f,f4) * diff(f,i) + diff(h,h5) * diff(h,i) + diff(h,g) + diff(f,c) + eq(b,c1) * eq(d,g0)));
    #endif
    #ifdef CORNER_C
    irlv1     = (irlv0  * ( neq(f,b) * neq(f,c) + neq(h,d) * neq(h,g) + eq(e,i) * (neq(f,f4) * neq(f,i4) + neq(h,h5) * neq(h,i5)) + eq(e,g) + eq(e,c)) );
    #endif

    // corner detection in the other direction
    irlv2l = diff(e,g) * diff(d,g);
    irlv2u = diff(e,c) * diff(b,c);

    vec4 fx45i = clamp((fx   + delta   -Co - Ci)/(2.0*delta  ), 0.0, 1.0);
    vec4 fx45  = clamp((fx   + delta   -Co     )/(2.0*delta  ), 0.0, 1.0);
    vec4 fx30  = clamp((fx_l + delta_l -Cx     )/(2.0*delta_l), 0.0, 1.0);
    vec4 fx60  = clamp((fx_u + delta_u -Cy     )/(2.0*delta_u), 0.0, 1.0);

    vec4 wd1, wd2;
    if (small_details < 0.5)
    {
        wd1 = wd( e, c,  g, i, h5, f4, h, f);
        wd2 = wd( h, d, i5, f, i4,  b, e, i);
    }
    else
    {
        wd1 = weighted_distance( e, c, g, i, f4, h5, h, f, b, d, i4, i5);
        wd2 = weighted_distance( h, d, i5, f, b, i4, e, i, g, h5, c, f4);
    }

    edri  = step(wd1, wd2) * irlv0;
    edr   = step(wd1 + vec4(0.1, 0.1, 0.1, 0.1), wd2) * step(vec4(0.5, 0.5, 0.5, 0.5), irlv1);
    edr_l = step( lv2_cf*df(f,g), df(h,c) ) * irlv2l * edr;
    edr_u = step( lv2_cf*df(h,c), df(f,g) ) * irlv2u * edr;

    fx45  = edr   * fx45;
    fx30  = edr_l * fx30;
    fx60  = edr_u * fx60;
    fx45i = edri  * fx45i;

    px = step(df(e,f), df(e,h));

    #ifdef SMOOTH_TIPS
    vec4 maximos = max(max(fx30, fx60), max(fx45, fx45i));
    #endif
    #ifndef SMOOTH_TIPS
    vec4 maximos = max(max(fx30, fx60), fx45);
    #endif

    vec4 res1 = E;
    res1 = mix(res1, mix(H, F, px.x), maximos.x);
    res1 = mix(res1, mix(B, D, px.z), maximos.z);

    vec4 res2 = E;
    res2 = mix(res2, mix(F, B, px.y), maximos.y);
    res2 = mix(res2, mix(D, H, px.w), maximos.w);

    vec4 res = mix(res1, res2, step(c_df(E.xyz, res1.xyz), c_df(E.xyz, res2.xyz)));

    return res;
}