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
#version 330

uniform sampler2D tex;

// Modes:
// 0 - default sampling, either GL_LINEAR or GL_NEAREST depending on texture attributes
// 1 - bicubic sampling with Catmull-Rom spline values
uniform int samplingMode;

in vec2 TexCoord;

out vec4 FragColor;

// Cubic filter with Catmull-Rom parameters
float catmull_rom(float x)
{
    /* A generalized cubic filter as described by Mitchell and Netravali is defined by the piecewise equation:
     * if abs(x) < 1
     *  y = 1/6 * ( (12 - 9b - 6c) * abs(x)^3 + (-18 + 12b + 6c) * abs(x)^2 + (6 - 2b) )
     * if abs(x) >= 1 and < 2
     *  y = 1/6 * ( (-1b - 6c) * abs(x)^3 + (6b + 30c) * abs(x)^2 + (-12b - 48c) * abs(x) + (8b + 24c) )
     * otherwise
     *  y = 0
     * Generally favorable results in image upscaling are given by the values b = 0 and c = 0.5.
     * This is known as the Catmull-Rom filter.
     * Placing these values into the piecewise equations gives us a more compact representation of:
     *  y = 1.5 * abs(x)^3 - 2.5 * abs(x)^2 + 1                 // abs(x) < 1
     *  y = -0.5 * abs(x)^3 + 2.5 * abs(x)^2 - 4 * abs(x) + 2   // 1 <= abs(x) < 2
     */

    float t = abs(x);       // absolute value of the x coordinate
    float t2 = t * t;       // t squared
    float t3 = t * t * t;   // t cubed

    if (t < 1)
        return 1.5 * t3 - 2.5 * t2 + 1;
    else if (t < 2)
        return -0.5 * t3 + 2.5 * t2 - 4 * t + 2;
    else
        return 0;
}

// Samples a texture using a 4x4 filtering kernel.
vec4 textureFiltered(sampler2D sampler, vec2 texCoords){
    vec2 texSize = textureSize(tex, 0);
    vec2 texelSize = 1.0 / texSize;
    texCoords *= texSize;
    texCoords -= 0.5;

    vec4 nSum = vec4( 0.0, 0.0, 0.0, 0.0 );
    vec4 nDenom = vec4( 0.0, 0.0, 0.0, 0.0 );

    ivec2 texelCoords = ivec2(floor(texCoords));
    vec2 coordFract = fract(texCoords);

    if (samplingMode == 1)
    {
        for (int m = -1; m <= 2; m++)
        {
            for (int n = -1; n <= 2; n++)
            {
                // get the raw texel, bypassing any other filters
                vec4 vecData = texelFetch(sampler, texelCoords + ivec2(m, n), 0);

                // calculate weights based on distance of the current texel offset from the sub-texel position of the sampling location
                float cx = catmull_rom( m - coordFract.x );
                float cy = catmull_rom( n - coordFract.y );

                // build the weighted average
                nSum += vecData * cx * cy;
                nDenom += cx * cy;
            }
        }
    }
    else
    {
        // Undefined sampling mode, fall back to default sampler
        return texture(sampler, texCoords);
    }

    // calculate and return the weighted average
    return nSum / nDenom;
}

void main() {
    vec4 c;

    if (samplingMode == 0)
        c = texture(tex, TexCoord);
    else
        c = textureFiltered(tex, TexCoord);

    FragColor = c;
}
