/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.cache;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.cache.definitions.OverlayDefinition;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.TextureDefinition;
import net.runelite.cache.definitions.UnderlayDefinition;
import net.runelite.cache.definitions.loaders.OverlayLoader;
import net.runelite.cache.definitions.loaders.SpriteLoader;
import net.runelite.cache.definitions.loaders.TextureLoader;
import net.runelite.cache.definitions.loaders.UnderlayLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.File;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapImageDumper
{
	private static final Logger logger = LoggerFactory.getLogger(MapImageDumper.class);

	private static final int MAX_REGION = 32768;

	private final Store store;

	private final List<UnderlayDefinition> underlays = new ArrayList<>();
	private final List<OverlayDefinition> overlays = new ArrayList<>();
	private final List<TextureDefinition> textures = new ArrayList<>();
	private final List<SpriteDefinition> sprites = new ArrayList<>();
	private final Map<SpriteDefinition, Integer> averageColors = new HashMap<>();

	private final List<Region> regions = new ArrayList<>();
	private Region lowestX = null, lowestY = null;
	private Region highestX = null, highestY = null;

	private boolean labelRegions;
	private boolean outlineRegions;

	public MapImageDumper(Store store)
	{
		this.store = store;
	}

	public BufferedImage[] buildImages() throws IOException
	{
		BufferedImage[] images = new BufferedImage[Region.Z];

		loadUnderlays(store);
		loadOverlays(store);
		loadTextures(store);
		loadSprites(store);

		loadRegions(store);

		int minX = lowestX.getBaseX();
		int minY = lowestY.getBaseY();

		int maxX = highestX.getBaseX() + Region.X;
		int maxY = highestY.getBaseY() + Region.Y;

		int dimX = maxX - minX;
		int dimY = maxY - minY;

		logger.info("Map image dimensions: {}px x {}px", dimX, dimY);

		for (int i = 0; i < images.length; ++i)
		{
			images[i] = new BufferedImage(dimX, dimY, BufferedImage.TYPE_INT_RGB);
		}

		for (Region region : regions)
		{
			int baseX = region.getBaseX();
			int baseY = region.getBaseY();

			// to pixel X
			int drawBaseX = baseX - lowestX.getBaseX();

			// to pixel Y. top most y is 0, but the top most
			// region has the greaters y, so invert
			int drawBaseY = highestY.getBaseY() - baseY;

			for (int z = 0; z < Region.Z; ++z)
			{
				BufferedImage image = images[z];
				Graphics2D graphics = image.createGraphics();

				for (int x = 0; x < Region.X; ++x)
				{
					int drawX = drawBaseX + x;

					for (int y = 0; y < Region.Y; ++y)
					{
						int drawY = drawBaseY + (Region.Y - 1 - y);

						int overlayId = region.getOverlayId(z, x, y) - 1;
						int underlayId = region.getUnderlayId(z, x, y) - 1;
						int rgb = 0;

						if (overlayId > -1)
						{
							OverlayDefinition overlay = findOverlay(overlayId);
							if (!overlay.isHideUnderlay() && underlayId > -1)
							{
								UnderlayDefinition underlay = findUnderlay(underlayId);
								rgb = underlay.getColor();
							}
							else
							{
								rgb = overlay.getRgbColor();
							}

							if (overlay.getSecondaryRgbColor() > -1)
							{
								rgb = overlay.getSecondaryRgbColor();
							}

							if (overlay.getTexture() > -1)
							{
								TextureDefinition texture = findTexture(overlay.getTexture());
								assert texture.getFileIds().length == 1;

								SpriteDefinition sprite = findSprite(texture.getFileIds()[0], 0);
								assert sprite != null;

								rgb = averageColors.get(sprite);
							}
						}
						else if (underlayId > -1)
						{
							UnderlayDefinition underlay = findUnderlay(underlayId);
							rgb = underlay.getColor();
						}

						image.setRGB(drawX, drawY, rgb);
					}
				}

				if (labelRegions)
				{
					graphics.setColor(Color.WHITE);
					graphics.drawString(baseX + "," + baseY, drawBaseX, drawBaseY + graphics.getFontMetrics().getHeight());
				}

				if (outlineRegions)
				{
					graphics.setColor(Color.WHITE);
					graphics.drawRect(drawBaseX, drawBaseY, Region.X, Region.Y);
				}

				graphics.dispose();
			}
		}

		return images;
	}

	private void loadRegions(Store store) throws IOException
	{
		Index index = store.getIndex(IndexType.MAPS);

		for (int i = 0; i < MAX_REGION; ++i)
		{
			Region region = new Region(i);

			Archive map = index.findArchiveByName("m" + (i >> 8) + "_" + (i & 0xFF));
			if (map == null)
			{
				continue;
			}

			assert map.getFiles().size() == 1;

			map.decompressAndLoad(null);

			byte[] data = map.getFiles().get(0).getContents();
			region.loadTerrain(data);

			regions.add(region);

			if (lowestX == null || region.getBaseX() < lowestX.getBaseX())
			{
				lowestX = region;
			}

			if (highestX == null || region.getBaseX() > highestX.getBaseX())
			{
				highestX = region;
			}

			if (lowestY == null || region.getBaseY() < lowestY.getBaseY())
			{
				lowestY = region;
			}

			if (highestY == null || region.getBaseY() > highestY.getBaseY())
			{
				highestY = region;
			}
		}

		assert lowestX != null;
		assert lowestY != null;

		assert highestX != null;
		assert highestY != null;

		logger.info("North most region: {}", lowestY.getBaseY());
		logger.info("South most region: {}", highestY.getBaseY());
		logger.info("West most region:  {}", lowestX.getBaseX());
		logger.info("East most region:  {}", highestX.getBaseX());
	}

	private void loadUnderlays(Store store)
	{
		Index index = store.getIndex(IndexType.CONFIGS);
		Archive archive = index.getArchive(ConfigType.UNDERLAY.getId());

		for (File file : archive.getFiles())
		{
			UnderlayLoader loader = new UnderlayLoader();
			UnderlayDefinition underlay = loader.load(file.getFileId(), file.getContents());

			underlays.add(underlay);
		}
	}

	private UnderlayDefinition findUnderlay(int id)
	{
		for (UnderlayDefinition u : underlays)
		{
			if (u.getId() == id)
			{
				return u;
			}
		}
		return null;
	}

	private void loadOverlays(Store store)
	{
		Index index = store.getIndex(IndexType.CONFIGS);
		Archive archive = index.getArchive(ConfigType.OVERLAY.getId());

		for (File file : archive.getFiles())
		{
			OverlayLoader loader = new OverlayLoader();
			OverlayDefinition underlay = loader.load(file.getFileId(), file.getContents());

			overlays.add(underlay);
		}
	}

	private OverlayDefinition findOverlay(int id)
	{
		for (OverlayDefinition u : overlays)
		{
			if (u.getId() == id)
			{
				return u;
			}
		}
		return null;
	}

	private void loadTextures(Store store)
	{
		Index index = store.getIndex(IndexType.TEXTURES);
		Archive archive = index.getArchive(0);

		for (File file : archive.getFiles())
		{
			TextureLoader loader = new TextureLoader();
			TextureDefinition texture = loader.load(file.getFileId(), file.getContents());

			textures.add(texture);
		}
	}

	private TextureDefinition findTexture(int id)
	{
		for (TextureDefinition t : textures)
		{
			if (t.getId() == id)
			{
				return t;
			}
		}

		return null;
	}

	private void loadSprites(Store store)
	{
		Index index = store.getIndex(IndexType.SPRITES);

		for (Archive a : index.getArchives())
		{
			List<File> files = a.getFiles();

			assert files.size() == 1;

			File file = files.get(0);
			byte[] contents = file.getContents();

			SpriteLoader loader = new SpriteLoader();
			SpriteDefinition[] sprites = loader.load(a.getArchiveId(), new InputStream(contents));

			for (SpriteDefinition sprite : sprites)
			{
				this.sprites.add(sprite);

				averageColors.put(sprite, getAverageColor(sprite.getPixels()));
			}
		}
	}

	private SpriteDefinition findSprite(int id, int frame)
	{
		for (SpriteDefinition def : sprites)
		{
			if (def.getId() == id && def.getFrame() == frame)
			{
				return def;
			}
		}
		return null;
	}

	private int getAverageColor(int[] pixels)
	{
		int redTotal = 0;
		int greenTotal = 0;
		int blueTotal = 0;

		if (pixels.length == 0)
		{
			return 0;
		}

		for (int pixel : pixels)
		{
			Color color = new Color(pixel);

			redTotal += color.getRed();
			greenTotal += color.getGreen();
			blueTotal += color.getBlue();
		}

		int averageRed = redTotal / pixels.length;
		int averageGreen = greenTotal / pixels.length;
		int averageBlue = blueTotal / pixels.length;

		Color color = new Color(averageRed, averageGreen, averageBlue);
		return color.getRGB();
	}

	public boolean isLabelRegions()
	{
		return labelRegions;
	}

	public void setLabelRegions(boolean labelRegions)
	{
		this.labelRegions = labelRegions;
	}

	public boolean isOutlineRegions()
	{
		return outlineRegions;
	}

	public void setOutlineRegions(boolean outlineRegions)
	{
		this.outlineRegions = outlineRegions;
	}
}
