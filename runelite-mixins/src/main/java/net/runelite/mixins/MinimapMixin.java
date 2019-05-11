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
package net.runelite.mixins;

import static net.runelite.api.Perspective.SCENE_SIZE;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSScene;
import net.runelite.rs.api.RSSpritePixels;

@Mixin(RSClient.class)
public abstract class MinimapMixin implements RSClient
{
	@Inject
	@Override
	public RSSpritePixels drawInstanceMap(int z)
	{
		RSSpritePixels ourSprite = createSpritePixels(new int[512 * 512], 512, 512);
		RSSpritePixels theirSprite = getMinimapSprite();

		RSScene scene = getScene();
		int[] pixels = ourSprite.getPixels();
		byte[][][] tileSettings = getTileSettings();

		try
		{
			setMinimapSprite(ourSprite);

			int var4;
			for (int x = 1; x < SCENE_SIZE - 1; ++x)
			{
				var4 = (103 - x) * 2048 + 24628;

				for (int y = 1; y < SCENE_SIZE - 1; ++y)
				{
					if ((tileSettings[z][y][x] & 24) == 0)
					{
						scene.drawTile(pixels, var4, 512, z, y, x);
					}

					if (z < 3 && (tileSettings[z + 1][y][x] & 8) != 0)
					{
						scene.drawTile(pixels, var4, 512, z + 1, y, x);
					}

					var4 += 4;
				}
			}

			int color1 = (238 + (int) (Math.random() * 20.0D) - 10 << 16) + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + (238 + (int) (Math.random() * 20.0D) - 10);
			int color2 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
			ourSprite.setRaster();

			for (int y = 1; y < SCENE_SIZE - 1; ++y)
			{
				for (int x = 1; x < SCENE_SIZE - 1; ++x)
				{
					if ((tileSettings[z][x][y] & 24) == 0)
					{
						drawObject(z, x, y, color1, color2);
					}

					if (z < 3 && (tileSettings[z + 1][x][y] & 8) != 0)
					{
						drawObject(z + 1, x, y, color1, color2);
					}
				}
			}
		}
		finally
		{
			getBufferProvider().setRaster();
			setMinimapSprite(theirSprite);
		}

		return ourSprite;
	}
}
