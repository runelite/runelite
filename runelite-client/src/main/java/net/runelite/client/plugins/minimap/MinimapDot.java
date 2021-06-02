/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.client.plugins.minimap;

import java.awt.Color;
import net.runelite.api.Client;
import net.runelite.api.SpritePixels;

class MinimapDot
{
	private static final int MAP_DOT_WIDTH = 4;
	private static final int MAP_DOT_HEIGHT = 5;

	private static int[] createPixels(Color color)
	{
		int rgb = color.getRGB();

		int[] pixels = new int[MAP_DOT_HEIGHT * MAP_DOT_WIDTH];

		pixels[0] = 0;
		pixels[1] = rgb;
		pixels[2] = rgb;
		pixels[3] = 0;

		pixels[4] = rgb;
		pixels[5] = rgb;
		pixels[6] = rgb;
		pixels[7] = rgb;

		pixels[8] = rgb;
		pixels[9] = rgb;
		pixels[10] = rgb;
		pixels[11] = rgb;

		pixels[12] = 1;
		pixels[13] = rgb;
		pixels[14] = rgb;
		pixels[15] = 1;

		pixels[16] = 0;
		pixels[17] = 1;
		pixels[18] = 1;
		pixels[19] = 0;

		return pixels;
	}

	static SpritePixels create(Client client, Color color)
	{
		int[] pixels = createPixels(color);
		return client.createSpritePixels(pixels, MAP_DOT_WIDTH, MAP_DOT_HEIGHT);
	}
}
