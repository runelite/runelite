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

in vec2 TexCoord;

out vec4 FragColor;

float CatmullRom( float x )
{
    const float B = 0.0;
    const float C = 0.5;

    float f = abs(x);
    float f2 = f * f;
    float f3 = f * f * f;

    if (f >= 2) {
        return 0.0;
    }

    if ( f < 1.0 ) {
        return (
            ( 12 - 9 * B - 6 * C ) * f3 +
            ( -18 + 12 * B + 6 *C ) * f2 +
            ( 6 - 2 * B )
        ) / 6.0;
    }
    else {
        return (
            ( -B - 6 * C ) * f3 +
            ( 6 * B + 30 * C ) * f2 +
            ( - ( 12 * B ) - 48 * C  ) * f +
            8 * B + 24 * C
        ) / 6.0;
    }
}

vec4 textureBicubic(sampler2D sampler, vec2 texCoords){
    vec2 texSize = textureSize(tex, 0);
    vec2 texelSize = 1.0 / texSize;
    texCoords *= texSize;
    texCoords -= 0.5;

    vec4 nSum = vec4( 0.0, 0.0, 0.0, 0.0 );
    vec4 nDenom = vec4( 0.0, 0.0, 0.0, 0.0 );

    ivec2 texelCoords = ivec2(floor(texCoords));
    vec2 fxy = fract(texCoords);

    for (int m = -1; m <= 2; m++)
    {
        for (int n = -1; n <= 2; n++)
        {
            vec4 vecData = texelFetch(
                sampler,
                texelCoords + ivec2(m, n),
                0
            );

            float cx = CatmullRom( m - fxy.x );
            float cy = CatmullRom( n - fxy.y );

            nSum += vecData * cx * cy;
            nDenom += cx * cy;
        }
    }
    return nSum / nDenom;
}

void main() {
    vec4 c = textureBicubic(tex, TexCoord);
    FragColor = c;
}