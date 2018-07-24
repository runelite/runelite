/*
 * Copyright (c) 2018 Abex
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

import net.runelite.api.Renderable;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Tile;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSDecorativeObject;
import net.runelite.rs.api.RSGroundObject;
import net.runelite.rs.api.RSItemLayer;
import net.runelite.rs.api.RSScene;
import net.runelite.rs.api.RSWallObject;

@Mixin(RSScene.class)
public abstract class RSSceneMixin implements RSScene
{
	private static final int INVALID_HSL_COLOR = 12345678;

	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	static boolean isDrawingScene;

	@Copy("drawScene")
	abstract void rs$drawScene(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane);

	@Replace("drawScene")
	void rl$drawScene(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane)
	{
		try
		{
			isDrawingScene = true;
			rs$drawScene(cameraX, cameraY, cameraZ, cameraPitch, cameraYaw, plane);
			client.getCallbacks().drawScene();
		}
		finally
		{
			isDrawingScene = false;
		}
	}

	@Copy("addBoundaryDecoration")
	abstract public void rs$addBoundaryDecoration(int plane, int x, int y, int floor, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, long hash, int var12);

	@Replace("addBoundaryDecoration")
	public void rl$addBoundaryDecoration(int plane, int x, int y, int floor, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, long hash, int var12)
	{
		rs$addBoundaryDecoration(plane, x, y, floor, var5, var6, var7, var8, var9, var10, hash, var12);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSDecorativeObject object = (RSDecorativeObject) tile.getDecorativeObject();
			if (object != null)
			{
				object.setPlane(plane);
			}
		}
	}

	@Copy("addItemPile")
	abstract public void rs$addItemPile(int plane, int x, int y, int hash, Renderable var5, long var6, Renderable var7, Renderable var8);

	@Replace("addItemPile")
	public void rl$addItemPile(int plane, int x, int y, int hash, Renderable var5, long var6, Renderable var7, Renderable var8)
	{
		rs$addItemPile(plane, x, y, hash, var5, var6, var7, var8);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSItemLayer itemLayer = (RSItemLayer) tile.getItemLayer();
			if (itemLayer != null)
			{
				itemLayer.setPlane(plane);
			}
		}
	}

	@Copy("groundObjectSpawned")
	abstract public void rs$groundObjectSpawned(int plane, int x, int y, int floor, Renderable var5, long hash, int var7);

	@Replace("groundObjectSpawned")
	public void rl$groundObjectSpawned(int plane, int x, int y, int floor, Renderable var5, long hash, int var7)
	{
		rs$groundObjectSpawned(plane, x, y, floor, var5, hash, var7);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSGroundObject groundObject = (RSGroundObject) tile.getGroundObject();
			if (groundObject != null)
			{
				groundObject.setPlane(plane);
			}
		}
	}

	@Copy("addBoundary")
	abstract public void rs$addBoundary(int plane, int x, int y, int floor, Renderable var5, Renderable var6, int var7, int var8, long hash, int var10);

	@Replace("addBoundary")
	public void rl$addBoundary(int plane, int x, int y, int floor, Renderable var5, Renderable var6, int var7, int var8, long hash, int var10)
	{
		rs$addBoundary(plane, x, y, floor, var5, var6, var7, var8, hash, var10);
		Tile tile = getTiles()[plane][x][y];
		if (tile != null)
		{
			RSWallObject wallObject = (RSWallObject) tile.getWallObject();
			if (wallObject != null)
			{
				wallObject.setPlane(plane);
			}
		}
	}

	@Copy("drawTileUnderlay")
	abstract public void rs$drawTileUnderlay(SceneTilePaint tile, int z, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y);

	@Replace("drawTileUnderlay")
	public void rl$drawTileUnderlay(SceneTilePaint tile, int z, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y)
	{
		try
		{
			rs$drawTileUnderlay(tile, z, pitchSin, pitchCos, yawSin, yawCos, x, y);
		}
		catch (Exception ex)
		{
			client.getLogger().warn("error during tile underlay rendering", ex);
		}
	}

	@MethodHook(value = "addTile", end = true)
	@Inject
	public void rl$addTile(int z, int x, int y, int shape, int rotation, int texture, int heightSw, int heightSe,
					int heightNe, int heightNw, int underlaySwColor, int underlaySeColor, int underlayNeColor,
					int underlayNwColor, int overlaySwColor, int overlaySeColor, int overlayNeColor,
					int overlayNwColor, int underlayRgb, int overlayRgb)
	{
		if (shape != 0 && shape != 1)
		{
			Tile tile = getTiles()[z][x][y];
			SceneTileModel sceneTileModel = tile.getSceneTileModel();

			sceneTileModel.setUnderlaySwColor(underlaySwColor);
			sceneTileModel.setUnderlaySeColor(underlaySeColor);
			sceneTileModel.setUnderlayNeColor(underlayNeColor);
			sceneTileModel.setUnderlayNwColor(underlayNwColor);

			sceneTileModel.setOverlaySwColor(overlaySwColor);
			sceneTileModel.setOverlaySeColor(overlaySeColor);
			sceneTileModel.setOverlayNeColor(overlayNeColor);
			sceneTileModel.setOverlayNwColor(overlayNwColor);
		}
	}

	@Copy("drawTile")
	abstract void rs$drawTile(int[] pixels, int pixelOffset, int width, int z, int x, int y);

	@Replace("drawTile")
	public void rl$drawTile(int[] pixels, int pixelOffset, int width, int z, int x, int y)
	{
		if (!client.isHdMinimapEnabled())
		{
			rs$drawTile(pixels, pixelOffset, width, z, x, y);
			return;
		}
		Tile tile = getTiles()[z][x][y];
		if (tile != null)
		{
			SceneTilePaint sceneTilePaint = tile.getSceneTilePaint();
			if (sceneTilePaint != null)
			{
				int rgb = sceneTilePaint.getRBG();
				if (sceneTilePaint.getSwColor() != INVALID_HSL_COLOR)
				{
					int[] colorPalette = client.getColorPalette();

					// hue and saturation
					int hs = sceneTilePaint.getSwColor() & ~0x7f;
					int nwLightness = sceneTilePaint.getNwColor() & 0x7f;
					int neLightness = sceneTilePaint.getNeColor() & 0x7f;
					int deltaSwLightness = (sceneTilePaint.getSwColor() & 0x7f) - nwLightness;
					int deltaSeLightness = (sceneTilePaint.getSeColor() & 0x7f) - neLightness;
					nwLightness <<= 2;
					neLightness <<= 2;
					for (int i = 0; i < 4; i++)
					{
						if (sceneTilePaint.getTexture() == -1)
						{
							pixels[pixelOffset] = colorPalette[hs | nwLightness >> 2];
							pixels[pixelOffset + 1] = colorPalette[hs | nwLightness * 3 + neLightness >> 4];
							pixels[pixelOffset + 2] = colorPalette[hs | nwLightness + neLightness >> 3];
							pixels[pixelOffset + 3] = colorPalette[hs | nwLightness + neLightness * 3 >> 4];
						}
						else
						{
							int lig = 0xff - ((nwLightness >> 1) * (nwLightness >> 1) >> 8);
							pixels[pixelOffset] = ((rgb & 0xff00ff) * lig & ~0xff00ff) + ((rgb & 0xff00) * lig & 0xff0000) >> 8;
							lig = 0xff - ((nwLightness * 3 + neLightness >> 3) * (nwLightness * 3 + neLightness >> 3) >> 8);
							pixels[pixelOffset + 1] = ((rgb & 0xff00ff) * lig & ~0xff00ff) + ((rgb & 0xff00) * lig & 0xff0000) >> 8;
							lig = 0xff - ((nwLightness + neLightness >> 2) * (nwLightness + neLightness >> 2) >> 8);
							pixels[pixelOffset + 2] = ((rgb & 0xff00ff) * lig & ~0xff00ff) + ((rgb & 0xff00) * lig & 0xff0000) >> 8;
							lig = 0xff - ((nwLightness + neLightness * 3 >> 3) * (nwLightness + neLightness * 3 >> 3) >> 8);
							pixels[pixelOffset + 3] = ((rgb & 0xff00ff) * lig & ~0xff00ff) + ((rgb & 0xff00) * lig & 0xff0000) >> 8;
						}
						nwLightness += deltaSwLightness;
						neLightness += deltaSeLightness;

						pixelOffset += width;
					}
				}
				else if (rgb != 0)
				{
					for (int i = 0; i < 4; i++)
					{
						pixels[pixelOffset] = rgb;
						pixels[pixelOffset + 1] = rgb;
						pixels[pixelOffset + 2] = rgb;
						pixels[pixelOffset + 3] = rgb;
						pixelOffset += width;
					}
				}
			}
			else
			{
				SceneTileModel sceneTileModel = tile.getSceneTileModel();
				if (sceneTileModel != null)
				{
					int shape = sceneTileModel.getShape();
					int rotation = sceneTileModel.getRotation();
					int overlayRgb = sceneTileModel.getModelOverlay();
					int underlayRgb = sceneTileModel.getModelUnderlay();
					int[] points = getTileShape2D()[shape];
					int[] indices = getTileRotation2D()[rotation];

					int shapeOffset = 0;

					if (sceneTileModel.getOverlaySwColor() != INVALID_HSL_COLOR)
					{
						int[] colorPalette = client.getColorPalette();

						// hue and saturation
						int hs = sceneTileModel.getOverlaySwColor() & ~0x7f;
						int nwLightness = sceneTileModel.getOverlayNwColor() & 0x7f;
						int neLightness = sceneTileModel.getOverlayNeColor() & 0x7f;
						int deltaSwLightness = (sceneTileModel.getOverlaySwColor() & 0x7f) - nwLightness;
						int deltaSeLightness = (sceneTileModel.getOverlaySeColor() & 0x7f) - neLightness;
						nwLightness <<= 2;
						neLightness <<= 2;
						for (int i = 0; i < 4; i++)
						{
							if (sceneTileModel.getTriangleTextureId() == null)
							{
								if (points[indices[shapeOffset++]] != 0)
								{
									pixels[pixelOffset] = colorPalette[hs | (nwLightness >> 2)];
								}
								if (points[indices[shapeOffset++]] != 0)
								{
									pixels[pixelOffset + 1] = colorPalette[hs | (nwLightness * 3 + neLightness >> 4)];
								}
								if (points[indices[shapeOffset++]] != 0)
								{
									pixels[pixelOffset + 2] = colorPalette[hs | (nwLightness + neLightness >> 3)];
								}
								if (points[indices[shapeOffset++]] != 0)
								{
									pixels[pixelOffset + 3] = colorPalette[hs | (nwLightness + neLightness * 3 >> 4)];
								}
							}
							else
							{
								if (points[indices[shapeOffset++]] != 0)
								{
									int lig = 0xff - ((nwLightness >> 1) * (nwLightness >> 1) >> 8);
									pixels[pixelOffset] = ((overlayRgb & 0xff00ff) * lig & ~0xff00ff) +
											((overlayRgb & 0xff00) * lig & 0xff0000) >> 8;
								}
								if (points[indices[shapeOffset++]] != 0)
								{
									int lig = 0xff - ((nwLightness * 3 + neLightness >> 3) *
											(nwLightness * 3 + neLightness >> 3) >> 8);
									pixels[pixelOffset + 1] = ((overlayRgb & 0xff00ff) * lig & ~0xff00ff) +
											((overlayRgb & 0xff00) * lig & 0xff0000) >> 8;
								}
								if (points[indices[shapeOffset++]] != 0)
								{
									int lig = 0xff - ((nwLightness + neLightness >> 2) *
											(nwLightness + neLightness >> 2) >> 8);
									pixels[pixelOffset + 2] = ((overlayRgb & 0xff00ff) * lig & ~0xff00ff) +
											((overlayRgb & 0xff00) * lig & 0xff0000) >> 8;
								}
								if (points[indices[shapeOffset++]] != 0)
								{
									int lig = 0xff - ((nwLightness + neLightness * 3 >> 3) *
											(nwLightness + neLightness * 3 >> 3) >> 8);
									pixels[pixelOffset + 3] = ((overlayRgb & 0xff00ff) * lig & ~0xff00ff) +
											((overlayRgb & 0xff00) * lig & 0xff0000) >> 8;
								}
							}
							nwLightness += deltaSwLightness;
							neLightness += deltaSeLightness;

							pixelOffset += width;
						}
						if (underlayRgb != 0 && sceneTileModel.getUnderlaySwColor() != INVALID_HSL_COLOR)
						{
							pixelOffset -= width << 2;
							shapeOffset -= 16;
							hs = sceneTileModel.getUnderlaySwColor() & ~0x7f;
							nwLightness = sceneTileModel.getUnderlayNwColor() & 0x7f;
							neLightness = sceneTileModel.getUnderlayNeColor() & 0x7f;
							deltaSwLightness = (sceneTileModel.getUnderlaySwColor() & 0x7f) - nwLightness;
							deltaSeLightness = (sceneTileModel.getUnderlaySeColor() & 0x7f) - neLightness;
							nwLightness <<= 2;
							neLightness <<= 2;
							for (int i = 0; i < 4; i++)
							{
								if (points[indices[shapeOffset++]] == 0)
								{
									pixels[pixelOffset] = colorPalette[hs | (nwLightness >> 2)];
								}
								if (points[indices[shapeOffset++]] == 0)
								{
									pixels[pixelOffset + 1] = colorPalette[hs | (nwLightness * 3 + neLightness >> 4)];
								}
								if (points[indices[shapeOffset++]] == 0)
								{
									pixels[pixelOffset + 2] = colorPalette[hs | (nwLightness + neLightness >> 3)];
								}
								if (points[indices[shapeOffset++]] == 0)
								{
									pixels[pixelOffset + 3] = colorPalette[hs | (nwLightness + neLightness * 3 >> 4)];
								}
								nwLightness += deltaSwLightness;
								neLightness += deltaSeLightness;

								pixelOffset += width;
							}
						}
					}
					else if (underlayRgb != 0)
					{
						for (int i = 0; i < 4; i++)
						{
							pixels[pixelOffset] = points[indices[shapeOffset++]] != 0 ? overlayRgb : underlayRgb;
							pixels[pixelOffset + 1] =
									points[indices[shapeOffset++]] != 0 ? overlayRgb : underlayRgb;
							pixels[pixelOffset + 2] =
									points[indices[shapeOffset++]] != 0 ? overlayRgb : underlayRgb;
							pixels[pixelOffset + 3] =
									points[indices[shapeOffset++]] != 0 ? overlayRgb : underlayRgb;
							pixelOffset += width;
						}
					}
					else
					{
						for (int i = 0; i < 4; i++)
						{
							if (points[indices[shapeOffset++]] != 0)
							{
								pixels[pixelOffset] = overlayRgb;
							}
							if (points[indices[shapeOffset++]] != 0)
							{
								pixels[pixelOffset + 1] = overlayRgb;
							}
							if (points[indices[shapeOffset++]] != 0)
							{
								pixels[pixelOffset + 2] = overlayRgb;
							}
							if (points[indices[shapeOffset++]] != 0)
							{
								pixels[pixelOffset + 3] = overlayRgb;
							}
							pixelOffset += width;
						}
					}
				}
			}
		}

	}
}
