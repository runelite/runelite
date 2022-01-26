/*
 * Copyright (c) 2019 logarrhythmic <https://github.com/logarrhythmic>
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

/* Bicubic sampling takes neighboring pixels into account using a cubic filter for pixel weights.
 *
 * A generalized cubic filter as described by Mitchell and Netravali is defined by the piecewise equation:
 * if abs(x) < 1
 *  y = 1/6 * ( (12 - 9b - 6c) * abs(x)^3 + (-18 + 12b + 6c) * abs(x)^2 + (6 - 2b) )
 * if abs(x) >= 1 and < 2
 *  y = 1/6 * ( (-1b - 6c) * abs(x)^3 + (6b + 30c) * abs(x)^2 + (-12b - 48c) * abs(x) + (8b + 24c) )
 * otherwise
 *  y = 0
 * This produces a bell curve centered on 0 with a width of 2.
 *
 * The 2 functions below are specific cases of the cubic filter with particular values of a and b.
 */

// Cubic filter with Catmull-Rom parameters
float catmull_rom(float x)
{
    /*
     * Generally favorable results in image upscaling are given by a cubic filter with the values b = 0 and c = 0.5.
     * This is known as the Catmull-Rom filter, and it closely approximates Jinc upscaling with Lanczos input values.
     * Placing these values into the piecewise equation gives us a more compact representation of:
     *  y = 1.5 * abs(x)^3 - 2.5 * abs(x)^2 + 1                 // abs(x) < 1
     *  y = -0.5 * abs(x)^3 + 2.5 * abs(x)^2 - 4 * abs(x) + 2   // 1 <= abs(x) < 2
     */

    float t = abs(x);
    float t2 = t * t;
    float t3 = t * t * t;

    if (t < 1)
        return 1.5 * t3 - 2.5 * t2 + 1.0;
    else if (t < 2)
        return -0.5 * t3 + 2.5 * t2 - 4.0 * t + 2.0;
    else
        return 0.0;
}

float mitchell(float x)
{
    /*
     * This is another cubic filter with less aggressive sharpening than Catmull-Rom, which some users may prefer.
     * B = 1/3, C = 1/3.
     */

    float t = abs(x);
    float t2 = t * t;
    float t3 = t * t * t;

    if (t < 1)
        return 7.0/6.0 * t3 + -2.0 * t2 + 8.0/9.0;
    else if (t < 2)
        return -7.0/18.0 * t3 + 2.0 * t2 - 10.0/3.0 * t + 16.0/9.0;
    else
        return 0.0;
}

#define CR_AR_STRENGTH 0.9

#define FLT_MAX 3.402823466e+38
#define FLT_MIN 1.175494351e-38

// Calculates the distance between two points
float d(vec2 pt1, vec2 pt2)
{
    vec2 v = pt2 - pt1;
    return sqrt(dot(v,v));
}

// Samples a texture using a 4x4 kernel.
vec4 textureCubic(sampler2D sampler, vec2 texCoords, int mode)
{
    vec2 texSize = textureSize(sampler, 0);
    vec2 texelSize = 1.0 / texSize;
    vec2 texelFCoords = texCoords * texSize;
    texelFCoords -= 0.5;

    vec4 nSum = vec4( 0.0, 0.0, 0.0, 0.0 );
    vec4 nDenom = vec4( 0.0, 0.0, 0.0, 0.0 );

    vec2 coordFract = fract(texelFCoords);
    texCoords -= coordFract * texelSize;

    vec4 c;

    if (mode == SAMPLING_CATROM)
    {
        // catrom benefits from anti-ringing, which requires knowledge of the minimum and maximum samples in the kernel
        vec4 min_sample = vec4(FLT_MAX);
        vec4 max_sample = vec4(FLT_MIN);
        for (int m = -1; m <= 2; m++)
        {
            for (int n = -1; n <= 2; n++)
            {
                // this would use texelFetch, but that would require manual implementation of texture wrapping
                vec4 vecData = texture(sampler, texCoords + vec2(m, n) * texelSize);

                // update min and max as we go
                min_sample = min(min_sample, vecData);
                max_sample = max(max_sample, vecData);

                // calculate weight based on distance of the current texel offset from the sub-texel position of the sampling location
                float w = catmull_rom( d(vec2(m, n), coordFract) );

                // build the weighted average
                nSum += vecData * w;
                nDenom += w;
            }
        }
        // calculate weighted average
        c = nSum / nDenom;

        // store value before anti-ringing
        vec4 aux = c;
        // anti-ringing: clamp the color value so that it cannot exceed values already present in the kernel area
        c = clamp(c, min_sample, max_sample);
        // mix according to anti-ringing strength
        c = mix(aux, c, CR_AR_STRENGTH);
    }
    else if (mode == SAMPLING_MITCHELL)
    {
        for (int m = -1; m <= 2; m++)
        {
            for (int n = -1; n <= 2; n++)
            {
                // this would use texelFetch, but that would require manual implementation of texture wrapping
                vec4 vecData = texture(sampler, texCoords + vec2(m, n) * texelSize);

                // calculate weight based on distance of the current texel offset from the sub-texel position of the sampling location
                float w = mitchell( d(vec2(m, n), coordFract) );

                // build the weighted average
                nSum += vecData * w;
                nDenom += w;
            }
        }
        // calculate weighted average
        c = nSum / nDenom;
    }

    // return the weighted average
    return c;
}
