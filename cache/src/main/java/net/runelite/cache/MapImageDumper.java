/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.cache.definitions.AreaDefinition;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.definitions.OverlayDefinition;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.TextureDefinition;
import net.runelite.cache.definitions.UnderlayDefinition;
import net.runelite.cache.definitions.loaders.OverlayLoader;
import net.runelite.cache.definitions.loaders.SpriteLoader;
import net.runelite.cache.definitions.loaders.TextureLoader;
import net.runelite.cache.definitions.loaders.UnderlayLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.region.Location;
import net.runelite.cache.region.Region;
import net.runelite.cache.region.RegionLoader;
import net.runelite.cache.util.Djb2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapImageDumper
{
	private static final Logger logger = LoggerFactory.getLogger(MapImageDumper.class);

	private static final int MAP_SCALE = 2; // this squared is the number of pixels per map square
	private static final int MAPICON_MAX_WIDTH = 5; // scale minimap icons down to this size so they fit..
	private static final int MAPICON_MAX_HEIGHT = 6;

	private final Store store;

	private final List<UnderlayDefinition> underlays = new ArrayList<>();
	private final List<OverlayDefinition> overlays = new ArrayList<>();
	private final List<TextureDefinition> textures = new ArrayList<>();
	private final Map<SpriteDefinition, Integer> averageColors = new HashMap<>();
	private final Map<Integer, Image> scaledMapIcons = new HashMap<>();
	private final Map<Integer, ObjectDefinition> objects = new HashMap<>();

	private RegionLoader regionLoader;
	private final AreaManager areas;
	private final SpriteManager sprites;

	private boolean labelRegions;
	private boolean outlineRegions;

	public MapImageDumper(Store store)
	{
		this.store = store;
		this.areas = new AreaManager(store);
		this.sprites = new SpriteManager(store);
	}

	public void load() throws IOException
	{
		loadUnderlays(store);
		loadOverlays(store);
		loadTextures(store);
		loadObjects(store);

		loadRegions(store);
		areas.load();
		sprites.load();
		loadSprites();
	}

	public BufferedImage drawMap(int z) throws IOException
	{
		int minX = regionLoader.getLowestX().getBaseX();
		int minY = regionLoader.getLowestY().getBaseY();

		int maxX = regionLoader.getHighestX().getBaseX() + Region.X;
		int maxY = regionLoader.getHighestY().getBaseY() + Region.Y;

		int dimX = maxX - minX;
		int dimY = maxY - minY;

		dimX *= MAP_SCALE;
		dimY *= MAP_SCALE;

		logger.info("Map image dimensions: {}px x {}px, {}px per map square ({} MB)", dimX, dimY, MAP_SCALE, (dimX * dimY / 1024 / 1024));

		BufferedImage image = new BufferedImage(dimX, dimY, BufferedImage.TYPE_INT_RGB);

		drawUnderlay(image, z);
		drawOverlay(image, z);

		// objects
		for (Region region : regionLoader.getRegions())
		{
			int baseX = region.getBaseX();
			int baseY = region.getBaseY();

			// to pixel X
			int drawBaseX = baseX - regionLoader.getLowestX().getBaseX();

			// to pixel Y. top most y is 0, but the top most
			// region has the greatest y, so invert
			int drawBaseY = regionLoader.getHighestY().getBaseY() - baseY;

			Graphics2D graphics = image.createGraphics();

			drawObjects(graphics, region, z, drawBaseX, drawBaseY);

			graphics.dispose();
		}

		// map icons
		for (Region region : regionLoader.getRegions())
		{
			int baseX = region.getBaseX();
			int baseY = region.getBaseY();

			// to pixel X
			int drawBaseX = baseX - regionLoader.getLowestX().getBaseX();

			// to pixel Y. top most y is 0, but the top most
			// region has the greatest y, so invert
			int drawBaseY = regionLoader.getHighestY().getBaseY() - baseY;

			Graphics2D graphics = image.createGraphics();

			drawMapIcons(graphics, region, z, drawBaseX, drawBaseY);

			if (labelRegions)
			{
				graphics.setColor(Color.WHITE);
				String str = baseX + "," + baseY + " (" + region.getRegionX() + "," + region.getRegionY() + ")";
				graphics.drawString(str, drawBaseX * MAP_SCALE, drawBaseY * MAP_SCALE + graphics.getFontMetrics().getHeight());
			}

			if (outlineRegions)
			{
				graphics.setColor(Color.WHITE);
				graphics.drawRect(drawBaseX * MAP_SCALE, drawBaseY * MAP_SCALE, Region.X * MAP_SCALE, Region.Y * MAP_SCALE);
			}

			graphics.dispose();
		}

		return image;
	}

	private void drawUnderlay(BufferedImage image, int z)
	{
		// pass 1
		for (Region region : regionLoader.getRegions())
		{
			int baseX = region.getBaseX();
			int baseY = region.getBaseY();

			// to pixel X
			int drawBaseX = baseX - regionLoader.getLowestX().getBaseX();

			// to pixel Y. top most y is 0, but the top most
			// region has the greatest y, so invert
			int drawBaseY = regionLoader.getHighestY().getBaseY() - baseY;

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
					}
					else if (underlayId > -1)
					{
						UnderlayDefinition underlay = findUnderlay(underlayId);
						rgb = underlay.getColor();
					}

					drawMapSquare(image, drawX, drawY, rgb);
				}
			}
		}
	}

	private void drawOverlay(BufferedImage image, int z)
	{
		for (Region region : regionLoader.getRegions())
		{
			int baseX = region.getBaseX();
			int baseY = region.getBaseY();

			// to pixel X
			int drawBaseX = baseX - regionLoader.getLowestX().getBaseX();

			// to pixel Y. top most y is 0, but the top most
			// region has the greatest y, so invert
			int drawBaseY = regionLoader.getHighestY().getBaseY() - baseY;

			for (int x = 0; x < Region.X; ++x)
			{
				int drawX = drawBaseX + x;

				for (int y = 0; y < Region.Y; ++y)
				{
					int drawY = drawBaseY + (Region.Y - 1 - y);

					int overlayId = region.getOverlayId(z, x, y) - 1;

					if (overlayId > -1)
					{
						OverlayDefinition overlay = findOverlay(overlayId);

						int rgb = 0;
						if (overlay.isHideUnderlay())
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

							SpriteDefinition sprite = sprites.findSprite(texture.getFileIds()[0], 0);
							assert sprite != null;

							rgb = averageColors.get(sprite);
						}

						drawMapSquare(image, drawX, drawY, rgb);
					}
				}
			}
		}
	}

	private void drawMapSquare(BufferedImage image, int x, int y, int rgb)
	{
		x *= MAP_SCALE;
		y *= MAP_SCALE;

		for (int i = 0; i < MAP_SCALE; ++i)
		{
			for (int j = 0; j < MAP_SCALE; ++j)
			{
				image.setRGB(x + i, y + j, rgb);
			}
		}
	}

	private void drawObjects(Graphics2D graphics, Region region, int z, int drawBaseX, int drawBaseY)
	{
		for (Location location : region.getLocations())
		{
			// regions include locations on all planes, so check
			if (location.getPosition().getZ() != z)
			{
				continue;
			}

			ObjectDefinition od = findObject(location.getId());

			assert od != null;

			int localX = location.getPosition().getX() - region.getBaseX();
			int localY = location.getPosition().getY() - region.getBaseY();

			int drawX = drawBaseX + localX;
			int drawY = drawBaseY + (Region.Y - 1 - localY);

			if (od.getMapSceneID() != -1)
			{
				Image spriteImage = scaledMapIcons.get(od.getMapSceneID());
				graphics.drawImage(spriteImage, drawX * MAP_SCALE, drawY * MAP_SCALE, null);
			}
		}
	}

	private void drawMapIcons(Graphics2D graphics, Region region, int z, int drawBaseX, int drawBaseY)
	{
		for (Location location : region.getLocations())
		{
			// draw map icons from all planes

			ObjectDefinition od = findObject(location.getId());

			assert od != null;

			int localX = location.getPosition().getX() - region.getBaseX();
			int localY = location.getPosition().getY() - region.getBaseY();

			int drawX = drawBaseX + localX;
			int drawY = drawBaseY + (Region.Y - 1 - localY);

			if (od.getMapAreaId() != -1)
			{
				AreaDefinition area = areas.getArea(od.getMapAreaId());
				assert area != null;

				int spriteId = area.spriteId;

				SpriteDefinition sprite = sprites.findSprite(spriteId, 0);
				assert sprite != null;

				BufferedImage iconImage = sprites.getSpriteImage(sprite);
				graphics.drawImage(iconImage, drawX * MAP_SCALE, drawY * MAP_SCALE, null);
			}
		}
	}

	private void loadRegions(Store store) throws IOException
	{
		regionLoader = new RegionLoader(store);
		regionLoader.loadRegions();
		regionLoader.calculateBounds();

		logger.info("North most region: {}", regionLoader.getLowestY().getBaseY());
		logger.info("South most region: {}", regionLoader.getHighestY().getBaseY());
		logger.info("West most region:  {}", regionLoader.getLowestX().getBaseX());
		logger.info("East most region:  {}", regionLoader.getHighestX().getBaseX());
	}

	private void loadUnderlays(Store store) throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.CONFIGS);
		Archive archive = index.getArchive(ConfigType.UNDERLAY.getId());

		byte[] archiveData = storage.loadArchive(archive);
		ArchiveFiles files = archive.getFiles(archiveData);

		for (FSFile file : files.getFiles())
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

	private void loadOverlays(Store store) throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.CONFIGS);
		Archive archive = index.getArchive(ConfigType.OVERLAY.getId());

		byte[] archiveData = storage.loadArchive(archive);
		ArchiveFiles files = archive.getFiles(archiveData);

		for (FSFile file : files.getFiles())
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

	private void loadTextures(Store store) throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.TEXTURES);
		Archive archive = index.getArchive(0);

		byte[] archiveData = storage.loadArchive(archive);
		ArchiveFiles files = archive.getFiles(archiveData);

		for (FSFile file : files.getFiles())
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

	private void loadSprites() throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.SPRITES);
		final int mapsceneHash = Djb2.hash("mapscene");

		for (Archive a : index.getArchives())
		{
			byte[] contents = a.decompress(storage.loadArchive(a));

			SpriteLoader loader = new SpriteLoader();
			SpriteDefinition[] sprites = loader.load(a.getArchiveId(), contents);

			for (SpriteDefinition sprite : sprites)
			{
				if (sprite.getHeight() <= 0 || sprite.getWidth() <= 0)
				{
					continue;
				}

				averageColors.put(sprite, getAverageColor(sprite.getPixels()));

				if (a.getNameHash() == mapsceneHash)
				{
					BufferedImage spriteImage = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);
					spriteImage.setRGB(0, 0, sprite.getWidth(), sprite.getHeight(), sprite.getPixels(), 0, sprite.getWidth());

					// scale image down so it fits
					Image scaledImage = spriteImage.getScaledInstance(MAPICON_MAX_WIDTH, MAPICON_MAX_HEIGHT, 0);

					assert scaledMapIcons.containsKey(sprite.getFrame()) == false;
					scaledMapIcons.put(sprite.getFrame(), scaledImage);
				}
			}
		}
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

	private void loadObjects(Store store) throws IOException
	{
		ObjectManager manager = new ObjectManager(store);
		manager.load();
		for (ObjectDefinition def : manager.getObjects())
		{
			objects.put(def.getId(), def);
		}
	}

	private ObjectDefinition findObject(int id)
	{
		return objects.get(id);
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
