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

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;

@Mixin(RSClient.class)
public abstract class Rasterizer2DMixin implements RSClient
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	private static void drawAlpha(int[] pixels, int index, int value, int color, int alpha)
	{
		if (!client.isGpu() || pixels != client.getBufferProvider().getPixels())
		{
			pixels[index] = value;
			return;
		}

		if (alpha == 0)
		{
			return;
		}

		int prevColor = pixels[index];

		if ((prevColor & 0xFF000000) == 0 || alpha == 255)
		{
			// No transparency, so we can cheat to save CPU resources
			pixels[index] = (color & 0xFFFFFF) | (alpha << 24);
			return;
		}

		if ((prevColor & 0xFF000000) == 0xFF000000)
		{
			// When the background is opaque, the result will also be opaque,
			// so we can simply use the value calculated by Jagex.
			pixels[index] = value | 0xFF000000;
			return;
		}

		int prevAlpha = (prevColor >>> 24) * (255 - alpha) >>> 8;
		int finalAlpha = alpha + prevAlpha;

		// Scale alphas so (relativeAlpha >>> 8) is approximately equal to (alpha / finalAlpha).
		// Avoiding extra divisions increase performance by quite a bit.
		// And with divisions we get a problems if dividing a number where
		// the last bit is 1 (as it will become negative).
		int relativeAlpha1 = (alpha << 8) / finalAlpha;
		int relativeAlpha2 = (prevAlpha << 8) / finalAlpha;

		// Red and blue are calculated at the same time to save CPU cycles
		int finalColor =
			(((color & 0xFF00FF) * relativeAlpha1 + (prevColor & 0xFF00FF) * relativeAlpha2 & 0xFF00FF00) |
			((color & 0x00FF00) * relativeAlpha1 + (prevColor & 0x00FF00) * relativeAlpha2 & 0x00FF0000)) >>> 8;

		pixels[index] = finalColor | (finalAlpha << 24);
	}

	@Copy("drawGradientAlpha")
	private static void rs$raster2d6(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7)
	{
		throw new RuntimeException();
	}

	@Replace("drawGradientAlpha")
	private static void rl$drawGradientAlpha(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7)
	{
		final int width = client.getGraphicsPixelsWidth();
		final int startX = client.getStartX();
		final int startY = client.getStartY();
		final int endX = client.getEndX();
		final int endY = client.getEndY();
		final int[] pixels = client.getGraphicsPixels();

		if (!client.isGpu())
		{
			rs$raster2d6(var0, var1, var2, var3, var4, var5, var6, var7);
			return;
		}

		if (var2 > 0 && var3 > 0)
		{
			int var8 = 0;
			int var9 = 65536 / var3;
			if (var0 < startX)
			{
				var2 -= startX - var0;
				var0 = startX;
			}

			if (var1 < startY)
			{
				var8 += (startY - var1) * var9;
				var3 -= startY - var1;
				var1 = startY;
			}

			if (var0 + var2 > endX)
			{
				var2 = endX - var0;
			}

			if (var3 + var1 > endY)
			{
				var3 = endY - var1;
			}

			int var10 = width - var2;
			int var11 = var0 + width * var1;

			for (int var12 = -var3; var12 < 0; ++var12)
			{
				int var13 = 65536 - var8 >> 8;
				int var14 = var8 >> 8;
				int var15 = (var13 * var6 + var14 * var7 & 65280) >>> 8;
				if (var15 == 0)
				{
					var11 += width;
					var8 += var9;
				}
				else
				{
					int var16 = (var14 * (var5 & 16711935) + var13 * (var4 & 16711935) & -16711936) + (var14 * (var5 & 65280) + var13 * (var4 & 65280) & 16711680) >>> 8;
					int var17 = 255 - var15;
					int var18 = ((var16 & 16711935) * var15 >> 8 & 16711935) + (var15 * (var16 & 65280) >> 8 & 65280);

					for (int var19 = -var2; var19 < 0; ++var19)
					{
						int var20 = pixels[var11];
						var20 = ((var20 & 16711935) * var17 >> 8 & 16711935) + (var17 * (var20 & 65280) >> 8 & 65280);
						drawAlpha(pixels, var11++, var18 + var20, var16, var15);
					}

					var11 += var10;
					var8 += var9;
				}
			}
		}
	}

	@Copy("raster2d7")
	public static void rs$raster2d7(int var0, int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7)
	{
		throw new RuntimeException();
	}

	@Replace("raster2d7")
	public static void rl$raster2d7(int var0, int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7)
	{
		final int width = client.getGraphicsPixelsWidth();
		final int height = client.getGraphicsPixelsHeight();
		final int[] pixels = client.getGraphicsPixels();

		if (!client.isGpu())
		{
			rs$raster2d7(var0, var1, var2, var3, var4, var5, var6, var7);
			return;
		}

		if (var0 + var2 >= 0 && var3 + var1 >= 0)
		{
			if (var0 < width && var1 < height)
			{
				int var8 = 0;
				int var9 = 0;
				if (var0 < 0)
				{
					var8 -= var0;
					var2 += var0;
				}

				if (var1 < 0)
				{
					var9 -= var1;
					var3 += var1;
				}

				if (var0 + var2 > width)
				{
					var2 = width - var0;
				}

				if (var3 + var1 > height)
				{
					var3 = height - var1;
				}

				int var10 = var6.length / var7;
				int var11 = width - var2;
				int var12 = var4 >>> 24;
				int var13 = var5 >>> 24;
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				if (var12 == 255 && var13 == 255)
				{
					var14 = var0 + var8 + (var9 + var1) * width;

					for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15)
					{
						for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16)
						{
							var17 = (var15 - var1) % var10;
							var18 = (var16 - var0) % var7;
							if (var6[var18 + var17 * var7] != 0)
							{
								pixels[var14++] = var5;
							}
							else
							{
								pixels[var14++] = var4;
							}
						}

						var14 += var11;
					}
				}
				else
				{
					var14 = var0 + var8 + (var9 + var1) * width;

					for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15)
					{
						for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16)
						{
							var17 = (var15 - var1) % var10;
							var18 = (var16 - var0) % var7;
							int var19 = var4;
							if (var6[var18 + var17 * var7] != 0)
							{
								var19 = var5;
							}

							int var20 = var19 >>> 24;
							int var21 = 255 - var20;
							int var22 = pixels[var14];
							int var23 = ((var19 & 16711935) * var20 + (var22 & 16711935) * var21 & -16711936) + (var20 * (var19 & 65280) + var21 * (var22 & 65280) & 16711680) >> 8;
							drawAlpha(pixels, var14++, var23, var19, var20);
						}

						var14 += var11;
					}
				}
			}
		}
	}
}
