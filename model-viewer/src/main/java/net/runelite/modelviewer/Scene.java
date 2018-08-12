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
package net.runelite.modelviewer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.cache.ObjectManager;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.definitions.OverlayDefinition;
import net.runelite.cache.definitions.UnderlayDefinition;
import net.runelite.cache.definitions.providers.OverlayProvider;
import net.runelite.cache.definitions.providers.UnderlayProvider;
import net.runelite.cache.item.ColorPalette;
import net.runelite.cache.region.Location;
import net.runelite.cache.region.Region;

@AllArgsConstructor
public class Scene
{
	private static final int REGION_SIZE = 64;
	private static final int BLEND = 5;

	private static final ColorPalette colorPalette = new ColorPalette(0.9d, 0, 512);

	static
	{
		assert Region.X == Region.Y;
	}

	private final int[] hues = new int[REGION_SIZE];
	private final int[] sats = new int[REGION_SIZE];
	private final int[] light = new int[REGION_SIZE];
	private final int[] mul = new int[REGION_SIZE];
	private final int[] num = new int[REGION_SIZE];

	private final UnderlayProvider underlayProvider;
	private final OverlayProvider overlayProvider;

	@Getter
	private final SceneTileModel[][][] sceneTiles = new SceneTileModel[Region.Z][Region.X][Region.Y];

	@Getter
	private final SceneTilePaint[][][] sceneTilePaint = new SceneTilePaint[Region.Z][Region.X][Region.Y];

	private byte[][] createShadows(Region region, ObjectManager manager)
	{
		byte[][] shadow = new byte[Region.X + 8][Region.Y + 8];
		for (Location location : region.getLocations())
		{
			int id = location.getId();
			ObjectDefinition object = manager.getObject(id);

			if (object == null || object.getObjectModels() == null)
			{
				continue;
			}
			if (!object.isABool2097())
			{
				continue;
			}
			int regionX = location.getPosition().getX() - region.getBaseX();
			int regionY = location.getPosition().getY() - region.getBaseY();
			if (location.getType() == 0)
			{
				if (location.getOrientation() == 0)
				{
					shadow[regionX][regionY] = 50;
					shadow[regionX][regionY + 1] = 50;
				}
				else if (location.getOrientation() == 1)
				{
					shadow[regionX][regionY + 1] = 50;
					shadow[regionX + 1][regionY + 1] = 50;
				}
				else if (location.getOrientation() == 2)
				{
					shadow[regionX + 1][regionY] = 50;
					shadow[regionX + 1][regionY + 1] = 50;
				}
				else if (location.getOrientation() == 3)
				{
					shadow[regionX][regionY] = 50;
					shadow[regionX + 1][regionY] = 50;
				}
			}
			else if (location.getType() == 1 || location.getType() == 3)
			{
				if (location.getOrientation() == 0)
				{
					shadow[regionX][regionY + 1] = 50;
				}
				else if (location.getOrientation() == 1)
				{
					shadow[regionX + 1][regionY + 1] = 50;
				}
				else if (location.getOrientation() == 2)
				{
					shadow[regionX + 1][regionY] = 50;
				}
				else if (location.getOrientation() == 3)
				{
					shadow[regionX][regionY] = 50;
				}
			}
			else if (location.getType() == 10 || location.getType() == 11)
			{
				int width;
				int length;
				if (location.getOrientation() != 1 && location.getOrientation() != 3)
				{
					width = object.getSizeX();
					length = object.getSizeY();
				}
				else
				{
					width = object.getSizeY();
					length = object.getSizeX();
				}
				int var23 = 15;
				for (int x = 0; x <= width; x++)
				{
					int xOff = x + regionX;
					for (int y = 0; y <= length; y++)
					{
						int yOff = y + regionY;
						if (var23 > shadow[xOff][yOff])
						{
							shadow[xOff][yOff] = (byte) var23;
						}
					}
				}
			}
		}
		return shadow;
	}

	public void loadRegion(Region region, ObjectManager manager)
	{
		byte[][] shadow = createShadows(region, manager);

		int[][] field3834 = new int[Region.X][Region.Y];
		int var11 = (int) Math.sqrt(5100.0D);
		int var63 = var11 * 768 >> 8;

		for (int z = 0; z < Region.Z; ++z)
		{
			for (int x = 1; x < Region.X - 1; ++x)
			{
				for (int y = 1; y < Region.Y - 1; ++y)
				{
					int dx = region.getTileHeight(z, x + 1, y) - region.getTileHeight(z, x - 1, y);
					int dy = region.getTileHeight(z, x, y + 1) - region.getTileHeight(z, x, y - 1);
					int var17 = (int) Math.sqrt((double) (dx * dx + dy * dy + 65536));
					int var18 = (dx << 8) / var17;
					int var50 = 65536 / var17;
					int var20 = (dy << 8) / var17;
					int var21 = (var20 * -50 + var18 * -50 + var50 * -10) / var63 + 96;
					int var22 = (shadow[y - 1][x] >> 2) + (shadow[y][x - 1] >> 2) + (shadow[y + 1][x] >> 3) + (shadow[y][x + 1] >> 3) + (shadow[y][x] >> 1);
					field3834[y][x] = var21 - var22;
				}
			}

			for (int i = 0; i < REGION_SIZE; ++i)
			{
				hues[i] = 0;
				sats[i] = 0;
				light[i] = 0;
				mul[i] = 0;
				num[i] = 0;
			}

			for (int x = -BLEND; x < Region.X + BLEND; ++x)
			{
				for (int y = 0; y < Region.Y; ++y)
				{
					int xr = x + BLEND;
					if (xr >= 0 && xr < Region.X)
					{
						int underlayId = region.getUnderlayId(z, xr, y);
						if (underlayId > 0)
						{
							UnderlayDefinition underlay = underlayProvider.provide(underlayId - 1);
							hues[y] += underlay.getHue();
							sats[y] += underlay.getSaturation();
							light[y] += underlay.getLightness();
							mul[y] += underlay.getHueMultiplier();
							num[y]++;
						}
					}

					int xl = x - BLEND;
					if (xl >= 0 && xl < Region.X)
					{
						int underlayId = region.getUnderlayId(z, xl, y);
						if (underlayId > 0)
						{
							UnderlayDefinition underlay = underlayProvider.provide(underlayId - 1);
							hues[y] -= underlay.getHue();
							sats[y] -= underlay.getSaturation();
							light[y] -= underlay.getLightness();
							mul[y] -= underlay.getHueMultiplier();
							num[y]--;
						}
					}
				}

				if (x >= 1 && x < Region.X - 1)
				{
					int runningHues = 0;
					int runningSat = 0;
					int runningLight = 0;
					int runningMultiplier = 0;
					int runningNumber = 0;

					for (int y = -BLEND; y < Region.Y + BLEND; ++y)
					{
						int yu = y + BLEND;
						if (yu >= 0 && yu < Region.Y)
						{
							runningHues += hues[yu];
							runningSat += sats[yu];
							runningLight += light[yu];
							runningMultiplier += mul[yu];
							runningNumber += num[yu];
						}

						int yd = y - BLEND;
						if (yd >= 0 && yd < Region.Y)
						{
							runningHues -= hues[yd];
							runningSat -= sats[yd];
							runningLight -= light[yd];
							runningMultiplier -= mul[yd];
							runningNumber -= num[yd];
						}

						if (y >= 1 && y < Region.Y - 1)
						{
							int underlayId = region.getUnderlayId(z, x, y);
							int overlayId = region.getOverlayId(z, x, y);

							if (underlayId > 0 || overlayId > 0)
							{
								int tileHeight = region.getTileHeight(z, x, y);
								int tileHeightX1 = region.getTileHeight(z, x + 1, y);
								int tileHeightX1Y1 = region.getTileHeight(z, x + 1, y + 1);
								int tileHeightY1 = region.getTileHeight(z, x, y + 1);

								int m1 = field3834[x][y];
								int m2 = field3834[x + 1][y];
								int m3 = field3834[x + 1][y + 1];
								int m4 = field3834[x][y + 1];

								int underlayHsl = -1;
								if (underlayId > 0)
								{
									int avgHue = runningHues * 256 / runningMultiplier;
									int avgSat = runningSat / runningNumber;
									int avgLight = runningLight / runningNumber;

									underlayHsl = packHsl(avgHue, avgSat, avgLight);
								}

								int underlayColor = 0;
								if (underlayHsl != -1)
								{
									underlayColor = colorPalette.getColorPalette()[method2115(underlayHsl, 96)];
								}

								if (overlayId == 0)
								{
									addTile(z, x, y, 0, 0, -1,
										tileHeight, tileHeightX1, tileHeightX1Y1, tileHeightY1,
										method2115(underlayHsl, m1), method2115(underlayHsl, m2), method2115(underlayHsl, m3), method2115(underlayHsl, m4),
										0, 0, 0, 0,
										underlayColor, 0);
								}
								else
								{
									int shape = region.getOverlayPath(z, x, y) + 1;
									int rotation = region.getOverlayRotation(z, x, y);
									OverlayDefinition overlay = overlayProvider.provide(overlayId - 1);
									int textureId = overlay.getTexture();
									int overlayHsl;
									if (textureId >= 0)
									{
										overlayHsl = -2;
									}
									else if (overlay.getRgbColor() == 0xFF_00FF)
									{
										overlayHsl = -2;
										textureId = -1;
									}
									else
									{
										int hue = overlay.getHue();
										int sat = overlay.getSaturation();
										int light = overlay.getLightness();
										overlayHsl = packHsl(hue, sat, light);
									}
									int overlayColor = 0;
									if (overlayHsl != -2)
									{
										int var0 = adjustHSLListness0(overlayHsl, 96);
										overlayColor = colorPalette.getColorPalette()[var0];
									}

									if (overlay.getSecondaryRgbColor() != -1)
									{
										int hue = overlay.getOtherHue();
										int sat = overlay.getOtherSaturation();
										int olight = overlay.getOtherLightness();
										int hsl = packHsl(hue, sat, olight);
										int var0 = adjustHSLListness0(hsl, 96);
										overlayColor = colorPalette.getColorPalette()[var0];
									}

									addTile(z, x, y, shape, rotation, textureId,
										tileHeight, tileHeightX1, tileHeightX1Y1, tileHeightY1,
										method2115(underlayHsl, m1), method2115(underlayHsl, m2), method2115(underlayHsl, m3), method2115(underlayHsl, m4),
										adjustHSLListness0(overlayHsl, m1), adjustHSLListness0(overlayHsl, m2), adjustHSLListness0(overlayHsl, m3), adjustHSLListness0(overlayHsl, m4),
										underlayColor, overlayColor);
								}
							}
						}
					}
				}
			}
		}
	}

	private void addTile(int z, int x, int y, int shape, int overlayRot, int texture,
		int tileHeight, int tileHeightX1, int tileHeightX1Y1, int tileHeightY1,
		int underlayColor, int underlayColorX1, int underlayColorX1Y1, int underlayColorY1,
		int overlayColor, int overlayColorX1, int overlayColorX1Y1, int overlayColorY1,
		int underlayColorRgb, int overlayColorRgb) // for the map
	{
		if (shape == 0)
		{
			SceneTilePaint sceneTilePaint = new SceneTilePaint(underlayColor, underlayColorX1, underlayColorX1Y1, underlayColorY1, -1, underlayColorRgb, false);
			this.sceneTilePaint[z][x][y] = sceneTilePaint;
		}
		else if (shape == 1)
		{
			SceneTilePaint sceneTilePaint = new SceneTilePaint(overlayColor, overlayColorX1, overlayColorX1Y1, overlayColorY1, texture, underlayColorRgb, tileHeightX1 == tileHeight && tileHeight == tileHeightX1Y1 && tileHeightY1 == tileHeight);
			this.sceneTilePaint[z][x][y] = sceneTilePaint;
		}
		else
		{
			SceneTileModel sceneTileModel = new SceneTileModel(shape, overlayRot, texture, x, y,
				tileHeight, tileHeightX1, tileHeightX1Y1, tileHeightY1,
				underlayColor, underlayColorX1, underlayColorX1Y1, underlayColorY1,
				overlayColor, overlayColorX1, overlayColorX1Y1, overlayColorY1,
				underlayColorRgb, overlayColorRgb);
			sceneTiles[z][x][y] = sceneTileModel;
		}
	}

	private static int packHsl(int h, int s, int l)
	{
		if (l > 179)
		{
			s /= 2;
		}

		if (l > 192)
		{
			s /= 2;
		}

		if (l > 217)
		{
			s /= 2;
		}

		if (l > 243)
		{
			s /= 2;
		}

		int hsl = (s / 32 << 7) + (h / 4 << 10) + l / 2;
		return hsl;
	}

	private static int method2115(int hsl, int var1)
	{
		if (hsl == -1)
		{
			return 12345678;
		}
		else
		{
			var1 = (hsl & 127) * var1 / 128;
			if (var1 < 2)
			{
				var1 = 2;
			}
			else if (var1 > 126)
			{
				var1 = 126;
			}

			return (hsl & 65408) + var1;
		}
	}

	static final int adjustHSLListness0(int var0, int var1)
	{
		if (var0 == -2)
		{
			return 12345678;
		}
		else if (var0 == -1)
		{
			if (var1 < 2)
			{
				var1 = 2;
			}
			else if (var1 > 126)
			{
				var1 = 126;
			}

			return var1;
		}
		else
		{
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2)
			{
				var1 = 2;
			}
			else if (var1 > 126)
			{
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}
}
