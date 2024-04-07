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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.definitions.AreaDefinition;
import net.runelite.cache.definitions.FontDefinition;
import net.runelite.cache.definitions.ObjectDefinition;
import net.runelite.cache.definitions.OverlayDefinition;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.UnderlayDefinition;
import net.runelite.cache.definitions.WorldMapElementDefinition;
import net.runelite.cache.definitions.loaders.OverlayLoader;
import net.runelite.cache.definitions.loaders.SpriteLoader;
import net.runelite.cache.definitions.loaders.UnderlayLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.item.RSTextureProvider;
import net.runelite.cache.models.JagexColor;
import net.runelite.cache.region.Location;
import net.runelite.cache.region.Position;
import net.runelite.cache.region.Region;
import net.runelite.cache.region.RegionLoader;
import net.runelite.cache.util.BigBufferedImage;
import net.runelite.cache.util.KeyProvider;
import net.runelite.cache.util.XteaKeyManager;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

@Slf4j
@Accessors(chain = true)
public class MapImageDumper
{
	private static final int MAP_SCALE = 4; // this squared is the number of pixels per map square
	private static final int BLEND = 5; // number of surrounding tiles for ground blending

	private static int[] colorPalette = JagexColor.createPalette(JagexColor.BRIGHTNESS_MIN);

	private static int[][] TILE_SHAPE_2D = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
	private static int[][] TILE_ROTATION_2D = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};

	private final int wallColor = (238 + (int) (random() * 20.0D) - 10 << 16) + (238 + (int) (random() * 20.0D) - 10 << 8) + (238 + (int) (random() * 20.0D) - 10);
	private final int doorColor = 238 + (int) (random() * 20.0D) - 10 << 16;

	private final Store store;

	private final Map<Integer, UnderlayDefinition> underlays = new HashMap<>();
	private final Map<Integer, OverlayDefinition> overlays = new HashMap<>();
	private SpriteDefinition[] mapDecorations;

	private final RegionLoader regionLoader;
	private final AreaManager areas;
	private final SpriteManager sprites;
	private final FontManager fonts;
	private final WorldMapManager worldMapManager;
	private RSTextureProvider rsTextureProvider;
	private final ObjectManager objectManager;

	@Getter
	@Setter
	private boolean labelRegions;

	@Getter
	@Setter
	private boolean outlineRegions;

	@Getter
	@Setter
	private boolean renderMap = true;

	@Getter
	@Setter
	private boolean renderObjects = true;

	@Getter
	@Setter
	private boolean renderIcons = true;

	@Getter
	@Setter
	private boolean renderLabels = true;

	@Getter
	@Setter
	private boolean transparency = false;

	@Getter
	@Setter
	private boolean lowMemory = true;

	public MapImageDumper(Store store, KeyProvider keyProvider)
	{
		this(store, new RegionLoader(store, keyProvider));
	}

	public MapImageDumper(Store store, RegionLoader regionLoader)
	{
		this.store = store;
		this.regionLoader = regionLoader;
		this.areas = new AreaManager(store);
		this.sprites = new SpriteManager(store);
		this.fonts = new FontManager(store);
		this.worldMapManager = new WorldMapManager(store);
		this.objectManager = new ObjectManager(store);
	}

	public static void main(String[] args) throws IOException
	{
		Options options = new Options();
		options.addOption(Option.builder().longOpt("cachedir").hasArg().required().build());
		options.addOption(Option.builder().longOpt("xteapath").hasArg().required().build());
		options.addOption(Option.builder().longOpt("outputdir").hasArg().required().build());

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd;
		try
		{
			cmd = parser.parse(options, args);
		}
		catch (ParseException ex)
		{
			System.err.println("Error parsing command line options: " + ex.getMessage());
			System.exit(-1);
			return;
		}

		final String cacheDirectory = cmd.getOptionValue("cachedir");
		final String xteaJSONPath = cmd.getOptionValue("xteapath");
		final String outputDirectory = cmd.getOptionValue("outputdir");

		XteaKeyManager xteaKeyManager = new XteaKeyManager();
		try (FileInputStream fin = new FileInputStream(xteaJSONPath))
		{
			xteaKeyManager.loadKeys(fin);
		}

		File base = new File(cacheDirectory);
		File outDir = new File(outputDirectory);
		outDir.mkdirs();

		try (Store store = new Store(base))
		{
			store.load();

			MapImageDumper dumper = new MapImageDumper(store, xteaKeyManager);
			dumper.load();

			for (int i = 0; i < Region.Z; ++i)
			{
				BufferedImage image = dumper.drawMap(i);

				File imageFile = new File(outDir, "img-" + i + ".png");

				ImageIO.write(image, "png", imageFile);
				log.info("Wrote image {}", imageFile);
			}
		}
	}

	protected double random()
	{
		// the client would use a random value here, but we prefer determinism
		return 0.5;
	}

	public MapImageDumper setBrightness(double brightness)
	{
		colorPalette = JagexColor.createPalette(brightness);
		return this;
	}

	public MapImageDumper load() throws IOException
	{
		loadUnderlays(store);
		loadOverlays(store);
		objectManager.load();

		TextureManager textureManager = new TextureManager(store);
		textureManager.load();
		rsTextureProvider = new RSTextureProvider(textureManager, sprites);

		loadRegions();
		areas.load();
		sprites.load();
		loadSprites();
		fonts.load();
		worldMapManager.load();

		return this;
	}

	public BufferedImage drawMap(int z)
	{
		int minX = regionLoader.getLowestX().getBaseX();
		int minY = regionLoader.getLowestY().getBaseY();

		int maxX = regionLoader.getHighestX().getBaseX() + Region.X;
		int maxY = regionLoader.getHighestY().getBaseY() + Region.Y;

		int dimX = maxX - minX;
		int dimY = maxY - minY;

		int pixelsX = dimX * MAP_SCALE;
		int pixelsY = dimY * MAP_SCALE;

		log.info("Map image dimensions: {}px x {}px, {}px per map square ({} MB). Max memory: {}mb", pixelsX, pixelsY,
			MAP_SCALE, (pixelsX * pixelsY * 3 / 1024 / 1024),
			Runtime.getRuntime().maxMemory() / 1024L / 1024L);

		BufferedImage image;
		if (lowMemory)
		{
			image = BigBufferedImage.create(pixelsX, pixelsY, transparency ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);
		}
		else
		{
			image = new BufferedImage(pixelsX, pixelsY, transparency ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);
		}

		drawMap(image, z);
		drawObjects(image, z);
		drawMapIcons(image, z);
		drawMapLabels(image, z);

		return image;
	}

	private void drawNeighborObjects(BufferedImage image, int rx, int ry, int dx, int dy, int z)
	{
		Region neighbor = regionLoader.findRegionForRegionCoordinates(rx + dx, ry + dy);
		if (neighbor == null)
		{
			return;
		}

		drawObjects(image, Region.X * dx, Region.Y * -dy, neighbor, z);
	}

	public BufferedImage drawRegion(Region region, int z)
	{
		int pixelsX = Region.X * MAP_SCALE;
		int pixelsY = Region.Y * MAP_SCALE;

		BufferedImage image = new BufferedImage(pixelsX, pixelsY, transparency ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);

		drawMap(image, 0, 0, z, region);

		drawNeighborObjects(image, region.getRegionX(), region.getRegionY(), -1, -1, z);
		drawNeighborObjects(image, region.getRegionX(), region.getRegionY(), -1, 0, z);
		drawNeighborObjects(image, region.getRegionX(), region.getRegionY(), -1, 1, z);
		drawNeighborObjects(image, region.getRegionX(), region.getRegionY(), 0, -1, z);
		drawObjects(image, 0, 0, region, z);
		drawNeighborObjects(image, region.getRegionX(), region.getRegionY(), 0, 1, z);
		drawNeighborObjects(image, region.getRegionX(), region.getRegionY(), 1, -1, z);
		drawNeighborObjects(image, region.getRegionX(), region.getRegionY(), 1, 0, z);
		drawNeighborObjects(image, region.getRegionX(), region.getRegionY(), 1, 1, z);
		drawMapIcons(image, 0, 0, region, z);

		return image;
	}

	private void drawMap(BufferedImage image, int drawBaseX, int drawBaseY, int z, Region region)
	{
		if (!renderMap)
		{
			return;
		}

		int[][][] map = new int[4][][];

		for (int x = 0; x < Region.X; ++x)
		{
			for (int y = 0; y < Region.Y; ++y)
			{
				boolean isBridge = (region.getTileSetting(1, x, Region.Y - y - 1) & 2) != 0;
				int tileZ = z + (isBridge ? 1 : 0);
				if (tileZ >= Region.Z)
				{
					continue;
				}

				int tileSetting = region.getTileSetting(z, x, Region.Y - y - 1);
				if ((tileSetting & 24) == 0)
				{
					if (z == 0 && isBridge)
					{
						drawTile(image, map, region, drawBaseX, drawBaseY, 0, x, y);
					}
					drawTile(image, map, region, drawBaseX, drawBaseY, tileZ, x, y);
				}

				if (tileZ < 3)
				{
					int upTileSetting = region.getTileSetting(z + 1, x, Region.Y - y - 1);
					if ((upTileSetting & 8) != 0)
					{
						drawTile(image, map, region, drawBaseX, drawBaseY, tileZ + 1, x, y);
					}
				}
			}
		}
	}

	private void drawMap(BufferedImage image, int z)
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

			drawMap(image, drawBaseX, drawBaseY, z, region);
		}
	}

	private void drawTile(BufferedImage to, int[][][] planes, Region region, int drawBaseX, int drawBaseY, int z, int x, int y)
	{
		int[][] pixels = planes[z];

		if (pixels == null)
		{
			pixels = planes[z] = new int[Region.X * MAP_SCALE][Region.Y * MAP_SCALE];
			drawMap(pixels, region, z);
		}

		for (int i = 0; i < MAP_SCALE; ++i)
		{
			for (int j = 0; j < MAP_SCALE; ++j)
			{
				int argb = pixels[x * MAP_SCALE + i][y * MAP_SCALE + j];
				if (argb != 0)
				{
					to.setRGB(drawBaseX * MAP_SCALE + x * MAP_SCALE + i,
						drawBaseY * MAP_SCALE + y * MAP_SCALE + j,
						argb);
				}
			}
		}
	}

	private void drawMap(int[][] pixels, Region region, int z)
	{
		int baseX = region.getBaseX();
		int baseY = region.getBaseY();

		int len = Region.X + BLEND * 2;
		int[] hues = new int[len];
		int[] sats = new int[len];
		int[] light = new int[len];
		int[] mul = new int[len];
		int[] num = new int[len];

		boolean hasLeftRegion = regionLoader.findRegionForWorldCoordinates(baseX - 1, baseY) != null;
		boolean hasRightRegion = regionLoader.findRegionForWorldCoordinates(baseX + Region.X, baseY) != null;
		boolean hasUpRegion = regionLoader.findRegionForWorldCoordinates(baseX, baseY + Region.Y) != null;
		boolean hasDownRegion = regionLoader.findRegionForWorldCoordinates(baseX, baseY - 1) != null;

		for (int xi = (hasLeftRegion ? -BLEND * 2 : -BLEND); xi < Region.X + (hasRightRegion ? BLEND * 2 : BLEND); ++xi)
		{
			for (int yi = (hasDownRegion ? -BLEND : 0); yi < Region.Y + (hasUpRegion ? BLEND : 0); ++yi)
			{
				int xr = xi + BLEND;
				if (xr >= (hasLeftRegion ? -BLEND : 0) && xr < Region.X + (hasRightRegion ? BLEND : 0))
				{
					Region r = regionLoader.findRegionForWorldCoordinates(baseX + xr, baseY + yi);
					if (r != null)
					{
						int underlayId = r.getUnderlayId(z, convert(xr), convert(yi));
						if (underlayId > 0)
						{
							UnderlayDefinition underlay = findUnderlay(underlayId - 1);
							hues[yi + BLEND] += underlay.getHue();
							sats[yi + BLEND] += underlay.getSaturation();
							light[yi + BLEND] += underlay.getLightness();
							mul[yi + BLEND] += underlay.getHueMultiplier();
							num[yi + BLEND]++;
						}
					}
				}

				int xl = xi - BLEND;
				if (xl >= (hasLeftRegion ? -BLEND : 0) && xl < Region.X + (hasRightRegion ? BLEND : 0))
				{
					Region r = regionLoader.findRegionForWorldCoordinates(baseX + xl, baseY + yi);
					if (r != null)
					{
						int underlayId = r.getUnderlayId(z, convert(xl), convert(yi));
						if (underlayId > 0)
						{
							UnderlayDefinition underlay = findUnderlay(underlayId - 1);
							hues[yi + BLEND] -= underlay.getHue();
							sats[yi + BLEND] -= underlay.getSaturation();
							light[yi + BLEND] -= underlay.getLightness();
							mul[yi + BLEND] -= underlay.getHueMultiplier();
							num[yi + BLEND]--;
						}
					}
				}
			}

			if (xi >= 0 && xi < Region.X)
			{
				int runningHues = 0;
				int runningSat = 0;
				int runningLight = 0;
				int runningMultiplier = 0;
				int runningNumber = 0;

				for (int yi = (hasDownRegion ? -BLEND * 2 : -BLEND); yi < Region.Y + (hasUpRegion ? BLEND * 2 : BLEND); ++yi)
				{
					int yu = yi + BLEND;
					if (yu >= (hasDownRegion ? -BLEND : 0) && yu < Region.Y + (hasUpRegion ? BLEND : 0))
					{
						runningHues += hues[yu + BLEND];
						runningSat += sats[yu + BLEND];
						runningLight += light[yu + BLEND];
						runningMultiplier += mul[yu + BLEND];
						runningNumber += num[yu + BLEND];
					}

					int yd = yi - BLEND;
					if (yd >= (hasDownRegion ? -BLEND : 0) && yd < Region.Y + (hasUpRegion ? BLEND : 0))
					{
						runningHues -= hues[yd + BLEND];
						runningSat -= sats[yd + BLEND];
						runningLight -= light[yd + BLEND];
						runningMultiplier -= mul[yd + BLEND];
						runningNumber -= num[yd + BLEND];
					}

					if (yi >= 0 && yi < Region.Y)
					{
						Region r = regionLoader.findRegionForWorldCoordinates(baseX + xi, baseY + yi);
						if (r != null)
						{
							int underlayId = r.getUnderlayId(z, convert(xi), convert(yi));
							int overlayId = r.getOverlayId(z, convert(xi), convert(yi));

							if (underlayId > 0 || overlayId > 0)
							{
								int underlayHsl = -1;
								if (underlayId > 0)
								{
									int avgHue = runningHues * 256 / runningMultiplier;
									int avgSat = runningSat / runningNumber;
									int avgLight = runningLight / runningNumber;
									// randomness is added to avgHue here

									if (avgLight < 0)
									{
										avgLight = 0;
									}
									else if (avgLight > 255)
									{
										avgLight = 255;
									}

									underlayHsl = packHsl(avgHue, avgSat, avgLight);
								}

								int underlayRgb = 0;
								if (underlayHsl != -1)
								{
									int var0 = method1792(underlayHsl, 96);
									underlayRgb = colorPalette[var0] | 0xFF000000;
								}

								int shape, rotation;
								int overlayRgb = 0;
								if (overlayId == 0)
								{
									shape = rotation = 0;
								}
								else
								{
									shape = r.getOverlayPath(z, convert(xi), convert(yi)) + 1;
									rotation = r.getOverlayRotation(z, convert(xi), convert(yi));

									OverlayDefinition overlayDefinition = findOverlay(overlayId - 1);
									int overlayTexture = overlayDefinition.getTexture();
									int hsl;

									if (overlayTexture >= 0)
									{
										hsl = rsTextureProvider.getAverageTextureRGB(overlayTexture);
									}
									else if (overlayDefinition.getRgbColor() == 0xFF_00FF)
									{
										hsl = -2;
									}
									else
									{
										// randomness added here
										int overlayHsl = packHsl(overlayDefinition.getHue(), overlayDefinition.getSaturation(), overlayDefinition.getLightness());
										hsl = overlayHsl;
									}

									if (hsl != -2)
									{
										int var0 = adjustHSLListness0(hsl, 96);
										overlayRgb = colorPalette[var0] | 0xFF000000;
									}

									if (overlayDefinition.getSecondaryRgbColor() != -1)
									{
										int hue = overlayDefinition.getOtherHue();
										int sat = overlayDefinition.getOtherSaturation();
										int olight = overlayDefinition.getOtherLightness();
										hsl = packHsl(hue, sat, olight);
										int var0 = adjustHSLListness0(hsl, 96);
										overlayRgb = colorPalette[var0] | 0xFF000000;
									}
								}

								if (shape == 0)
								{
									int drawX = xi;
									int drawY = Region.Y - 1 - yi;
									if (underlayRgb != 0)
									{
										drawMapSquare(pixels, drawX, drawY, underlayRgb);
									}
								}
								else if (shape == 1)
								{
									int drawX = xi;
									int drawY = Region.Y - 1 - yi;
									drawMapSquare(pixels, drawX, drawY, overlayRgb);
								}
								else
								{
									int drawX = xi * MAP_SCALE;
									int drawY = (Region.Y - 1 - yi) * MAP_SCALE;
									int[] tileShapes = TILE_SHAPE_2D[shape];
									int[] tileRotations = TILE_ROTATION_2D[rotation];
									if (underlayRgb != 0)
									{
										int rotIdx = 0;
										for (int i = 0; i < Region.Z; ++i)
										{
											int p1 = tileShapes[tileRotations[rotIdx++]] == 0 ? underlayRgb : overlayRgb;
											int p2 = tileShapes[tileRotations[rotIdx++]] == 0 ? underlayRgb : overlayRgb;
											int p3 = tileShapes[tileRotations[rotIdx++]] == 0 ? underlayRgb : overlayRgb;
											int p4 = tileShapes[tileRotations[rotIdx++]] == 0 ? underlayRgb : overlayRgb;
											pixels[drawX + 0][drawY + i] = p1;
											pixels[drawX + 1][drawY + i] = p2;
											pixels[drawX + 2][drawY + i] = p3;
											pixels[drawX + 3][drawY + i] = p4;
										}
									}
									else
									{
										int rotIdx = 0;
										for (int i = 0; i < Region.Z; ++i)
										{
											int p1 = tileShapes[tileRotations[rotIdx++]];
											int p2 = tileShapes[tileRotations[rotIdx++]];
											int p3 = tileShapes[tileRotations[rotIdx++]];
											int p4 = tileShapes[tileRotations[rotIdx++]];

											if (p1 != 0)
											{
												pixels[drawX + 0][drawY + i] = overlayRgb;
											}

											if (p2 != 0)
											{
												pixels[drawX + 1][drawY + i] = overlayRgb;
											}

											if (p3 != 0)
											{
												pixels[drawX + 2][drawY + i] = overlayRgb;
											}

											if (p4 != 0)
											{
												pixels[drawX + 3][drawY + i] = overlayRgb;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static int convert(int d)
	{
		if (d >= 0)
		{
			return d % 64;
		}
		else
		{
			return 64 - -(d % 64) - 1;
		}
	}

	private void drawObjects(BufferedImage image, int drawBaseX, int drawBaseY, Region region, int z)
	{
		if (!renderObjects)
		{
			return;
		}

		List<Location> planeLocs = new ArrayList<>();
		List<Location> pushDownLocs = new ArrayList<>();
		List<List<Location>> layers = Arrays.asList(planeLocs, pushDownLocs);
		for (int localX = 0; localX < Region.X; localX++)
		{
			int regionX = localX + region.getBaseX();
			for (int localY = 0; localY < Region.Y; localY++)
			{
				int regionY = localY + region.getBaseY();

				planeLocs.clear();
				pushDownLocs.clear();
				boolean isBridge = (region.getTileSetting(1, localX, localY) & 2) != 0;
				int tileZ = z + (isBridge ? 1 : 0);

				for (Location loc : region.getLocations())
				{
					Position pos = loc.getPosition();
					if (pos.getX() != regionX || pos.getY() != regionY)
					{
						continue;
					}

					if (pos.getZ() == tileZ && (region.getTileSetting(z, localX, localY) & 24) == 0)
					{
						planeLocs.add(loc);
					}
					else if (z < 3 && pos.getZ() == tileZ + 1 && (region.getTileSetting(z + 1, localX, localY) & 8) != 0)
					{
						pushDownLocs.add(loc);
					}
				}

				for (List<Location> locs : layers)
				{
					for (Location location : locs)
					{
						int type = location.getType();
						if (type >= 0 && type <= 3)
						{
							int rotation = location.getOrientation();

							ObjectDefinition object = findObject(location.getId());

							int drawX = (drawBaseX + localX) * MAP_SCALE;
							int drawY = (drawBaseY + (Region.Y - object.getSizeY() - localY)) * MAP_SCALE;

							int rgb = wallColor;
							if (object.getWallOrDoor() != 0)
							{
								rgb = doorColor;
							}
							rgb |= 0xFF000000;

							if (object.getMapSceneID() != -1)
							{
								blitMapDecoration(image, drawX, drawY, object);
							}
							else if (drawX >= 0 && drawY >= 0 && drawX < image.getWidth() && drawY < image.getHeight())
							{
								if (type == 0 || type == 2)
								{
									if (rotation == 0)
									{
										image.setRGB(drawX + 0, drawY + 0, rgb);
										image.setRGB(drawX + 0, drawY + 1, rgb);
										image.setRGB(drawX + 0, drawY + 2, rgb);
										image.setRGB(drawX + 0, drawY + 3, rgb);
									}
									else if (rotation == 1)
									{
										image.setRGB(drawX + 0, drawY + 0, rgb);
										image.setRGB(drawX + 1, drawY + 0, rgb);
										image.setRGB(drawX + 2, drawY + 0, rgb);
										image.setRGB(drawX + 3, drawY + 0, rgb);
									}
									else if (rotation == 2)
									{
										image.setRGB(drawX + 3, drawY + 0, rgb);
										image.setRGB(drawX + 3, drawY + 1, rgb);
										image.setRGB(drawX + 3, drawY + 2, rgb);
										image.setRGB(drawX + 3, drawY + 3, rgb);
									}
									else if (rotation == 3)
									{
										image.setRGB(drawX + 0, drawY + 3, rgb);
										image.setRGB(drawX + 1, drawY + 3, rgb);
										image.setRGB(drawX + 2, drawY + 3, rgb);
										image.setRGB(drawX + 3, drawY + 3, rgb);
									}
								}

								if (type == 3)
								{
									if (rotation == 0)
									{
										image.setRGB(drawX + 0, drawY + 0, rgb);
									}
									else if (rotation == 1)
									{
										image.setRGB(drawX + 3, drawY + 0, rgb);
									}
									else if (rotation == 2)
									{
										image.setRGB(drawX + 3, drawY + 3, rgb);
									}
									else if (rotation == 3)
									{
										image.setRGB(drawX + 0, drawY + 3, rgb);
									}
								}

								if (type == 2)
								{
									if (rotation == 3)
									{
										image.setRGB(drawX + 0, drawY + 0, rgb);
										image.setRGB(drawX + 0, drawY + 1, rgb);
										image.setRGB(drawX + 0, drawY + 2, rgb);
										image.setRGB(drawX + 0, drawY + 3, rgb);
									}
									else if (rotation == 0)
									{
										image.setRGB(drawX + 0, drawY + 0, rgb);
										image.setRGB(drawX + 1, drawY + 0, rgb);
										image.setRGB(drawX + 2, drawY + 0, rgb);
										image.setRGB(drawX + 3, drawY + 0, rgb);
									}
									else if (rotation == 1)
									{
										image.setRGB(drawX + 3, drawY + 0, rgb);
										image.setRGB(drawX + 3, drawY + 1, rgb);
										image.setRGB(drawX + 3, drawY + 2, rgb);
										image.setRGB(drawX + 3, drawY + 3, rgb);
									}
									else if (rotation == 2)
									{
										image.setRGB(drawX + 0, drawY + 3, rgb);
										image.setRGB(drawX + 1, drawY + 3, rgb);
										image.setRGB(drawX + 2, drawY + 3, rgb);
										image.setRGB(drawX + 3, drawY + 3, rgb);
									}
								}
							}
						}
					}

					for (Location location : locs)
					{
						int type = location.getType();
						if (type == 9)
						{
							int rotation = location.getOrientation();

							ObjectDefinition object = findObject(location.getId());

							int drawX = (drawBaseX + localX) * MAP_SCALE;
							int drawY = (drawBaseY + (Region.Y - object.getSizeY() - localY)) * MAP_SCALE;

							if (object.getMapSceneID() != -1)
							{
								blitMapDecoration(image, drawX, drawY, object);
								continue;
							}

							if (drawX >= 0 && drawY >= 0 && drawX < image.getWidth() && drawY < image.getHeight())
							{
								int rgb = 0xFFEE_EEEE;
								if (object.getWallOrDoor() != 0)
								{
									rgb = 0xFFEE_0000;
								}

								if (rotation != 0 && rotation != 2)
								{
									image.setRGB(drawX + 0, drawY + 0, rgb);
									image.setRGB(drawX + 1, drawY + 1, rgb);
									image.setRGB(drawX + 2, drawY + 2, rgb);
									image.setRGB(drawX + 3, drawY + 3, rgb);
								}
								else
								{
									image.setRGB(drawX + 0, drawY + 3, rgb);
									image.setRGB(drawX + 1, drawY + 2, rgb);
									image.setRGB(drawX + 2, drawY + 1, rgb);
									image.setRGB(drawX + 3, drawY + 0, rgb);
								}
							}
						}
					}

					for (Location location : locs)
					{
						int type = location.getType();
						if (type == 22 || (type >= 9 && type <= 11))
						{
							ObjectDefinition object = findObject(location.getId());

							int drawX = (drawBaseX + localX) * MAP_SCALE;
							int drawY = (drawBaseY + (Region.Y - object.getSizeY() - localY)) * MAP_SCALE;

							if (object.getMapSceneID() != -1)
							{
								blitMapDecoration(image, drawX, drawY, object);
							}
						}
					}
				}
			}
		}
	}

	private void drawObjects(BufferedImage image, int z)
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

			drawObjects(image, drawBaseX, drawBaseY, region, z);
		}
	}

	private void drawMapIcons(BufferedImage image, int drawBaseX, int drawBaseY, Region region, int z)
	{
		int baseX = region.getBaseX();
		int baseY = region.getBaseY();

		Graphics2D graphics = image.createGraphics();

		drawMapIcons(image, region, z, drawBaseX, drawBaseY);

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

	private void drawMapIcons(BufferedImage image, int z)
	{
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

			drawMapIcons(image, drawBaseX, drawBaseY, region, z);
		}
	}

	private void drawMapLabels(BufferedImage image, int z)
	{
		if (!renderLabels)
		{
			return;
		}

		FontName[] fontSizes = new FontName[] { FontName.VERDANA_11,  FontName.VERDANA_13,  FontName.VERDANA_15 };
		List<WorldMapElementDefinition> elements = worldMapManager.getElements();
		for (WorldMapElementDefinition element : elements)
		{
			AreaDefinition area = areas.getArea(element.getAreaDefinitionId());
			if (area == null || area.getName() == null || element.getPosition().getZ() != z)
			{
				continue;
			}

			FontName fontSize = fontSizes[area.getTextScale()];
			FontDefinition font = fonts.findFontByName(fontSize.getName());
			String areaLabel = area.getName();
			String[] lines = areaLabel.split("<br>");
			int ascent = 0;

			for (String line : lines)
			{
				int advance = 0;
				int stringWidth = font.stringWidth(line);
				for (int i = 0; i < line.length(); ++i)
				{
					char c = line.charAt(i);
					SpriteDefinition sprite = sprites.findSpriteByArchiveName(fontSize.getName(), c);
					if (sprite.getWidth() != 0 && sprite.getHeight() != 0)
					{
						Position position = element.getPosition();
						int drawX = position.getX() - regionLoader.getLowestX().getBaseX();
						int drawY = regionLoader.getHighestY().getBaseY() - position.getY() + Region.Y - 2;
						blitGlyph(image,
								(drawX * MAP_SCALE) + advance - (stringWidth / 2),
								(drawY * MAP_SCALE) + ascent - (font.getAscent() / 2),
								area.getTextColor(),
								sprite
						);
					}

					advance += font.getAdvances()[c];
				}
				ascent += font.getAscent() / 2;
			}
		}
	}

	private ObjectDefinition findObject(int id)
	{
		return objectManager.getObject(id);
	}

	private int packHsl(int var0, int var1, int var2)
	{
		if (var2 > 179)
		{
			var1 /= 2;
		}

		if (var2 > 192)
		{
			var1 /= 2;
		}

		if (var2 > 217)
		{
			var1 /= 2;
		}

		if (var2 > 243)
		{
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	static int method1792(int var0, int var1)
	{
		if (var0 == -1)
		{
			return 12345678;
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

	private void drawMapSquare(int[][] pixels, int x, int y, int rgb)
	{
		x *= MAP_SCALE;
		y *= MAP_SCALE;

		for (int i = 0; i < MAP_SCALE; ++i)
		{
			for (int j = 0; j < MAP_SCALE; ++j)
			{
				pixels[x + i][y + j] = rgb;
			}
		}
	}

	private void drawMapIcons(BufferedImage img, Region region, int z, int drawBaseX, int drawBaseY)
	{
		if (!renderIcons)
		{
			return;
		}

		for (Location location : region.getLocations())
		{
			int localX = location.getPosition().getX() - region.getBaseX();
			int localY = location.getPosition().getY() - region.getBaseY();
			boolean isBridge = (region.getTileSetting(1, localX, localY) & 2) != 0;

			int tileZ = z + (isBridge ? 1 : 0);
			int localZ = location.getPosition().getZ();
			if (z != 0 && localZ != tileZ)
			{
				// draw all icons on z=0
				continue;
			}

			ObjectDefinition od = findObject(location.getId());

			assert od != null;

			int drawX = drawBaseX + localX;
			int drawY = drawBaseY + (Region.Y - 1 - localY);

			if (od.getMapAreaId() != -1)
			{
				AreaDefinition area = areas.getArea(od.getMapAreaId());
				assert area != null;

				SpriteDefinition sprite = sprites.findSprite(area.spriteId, 0);
				assert sprite != null;

				blitIcon(img,
					2 + (drawX * MAP_SCALE) - (sprite.getMaxWidth() / 2),
					2 + (drawY * MAP_SCALE) - (sprite.getMaxHeight() / 2),
					sprite);
			}
		}
	}

	private void loadRegions() throws IOException
	{
		regionLoader.loadRegions();
		regionLoader.calculateBounds();

		log.debug("North most region: {}", regionLoader.getLowestY().getBaseY());
		log.debug("South most region: {}", regionLoader.getHighestY().getBaseY());
		log.debug("West most region:  {}", regionLoader.getLowestX().getBaseX());
		log.debug("East most region:  {}", regionLoader.getHighestX().getBaseX());
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

			underlays.put(underlay.getId(), underlay);
		}
	}

	private UnderlayDefinition findUnderlay(int id)
	{
		return underlays.get(id);
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
			OverlayDefinition overlay = loader.load(file.getFileId(), file.getContents());

			overlays.put(overlay.getId(), overlay);
		}
	}

	private OverlayDefinition findOverlay(int id)
	{
		return overlays.get(id);
	}

	private void loadSprites() throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.SPRITES);
		Archive a = index.findArchiveByName("mapscene");
		byte[] contents = a.decompress(storage.loadArchive(a));

		SpriteLoader loader = new SpriteLoader();
		mapDecorations = loader.load(a.getArchiveId(), contents);
	}

	private void blitMapDecoration(BufferedImage dst, int x, int y, ObjectDefinition object)
	{
		SpriteDefinition sprite = mapDecorations[object.getMapSceneID()];
		int ox = (object.getSizeX() * MAP_SCALE - sprite.getWidth()) / 2;
		int oy = (object.getSizeY() * MAP_SCALE - sprite.getHeight()) / 2;
		blitIcon(dst, x + ox, y + oy, sprite);
	}

	private void blitIcon(BufferedImage dst, int x, int y, SpriteDefinition sprite)
	{
		x += sprite.getOffsetX();
		y += sprite.getOffsetY();

		int ymin = Math.max(0, -y);
		int ymax = Math.min(sprite.getHeight(), dst.getHeight() - y);

		int xmin = Math.max(0, -x);
		int xmax = Math.min(sprite.getWidth(), dst.getWidth() - x);

		for (int yo = ymin; yo < ymax; yo++)
		{
			for (int xo = xmin; xo < xmax; xo++)
			{
				int rgb = sprite.getPixels()[xo + (yo * sprite.getWidth())];
				if (rgb != 0)
				{
					dst.setRGB(x + xo, y + yo, rgb | 0xFF000000);
				}
			}
		}
	}

	private void blitGlyph(BufferedImage dst, int x, int y, int color, SpriteDefinition glyph)
	{
		int[] pixels = glyph.getPixels();
		int[] shadowPixels = new int[pixels.length];
		for (int i = 0; i < pixels.length; ++i)
		{
			if (pixels[i] != 0)
			{
				pixels[i] = color;
				shadowPixels[i] = 0xFF000000;
			}
		}
		SpriteDefinition shadow = new SpriteDefinition();
		shadow.setPixels(shadowPixels);
		shadow.setOffsetX(glyph.getOffsetX());
		shadow.setOffsetY(glyph.getOffsetY());
		shadow.setWidth(glyph.getWidth());
		shadow.setHeight(glyph.getHeight());

		blitIcon(dst, x + 1, y + 1, shadow);
		blitIcon(dst, x, y, glyph);
	}
}
