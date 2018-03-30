/*
 * Copyright (c) 2018 Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.coords.WorldPoint;

@Slf4j
public class WorldMapView
{
	private static LoadingCache<Integer, BufferedImage> regions;

	private static final int REGION_GRAPHIC_SIZE = 256;
	private static final int REGION_TILE_SIZE = 64;

	@Getter
	private WorldPoint center;

	@Getter
	private float zoom;

	@Getter
	private int graphicsWidth;

	@Getter
	private int graphicsHeight;


	public void setCenter(WorldPoint center)
	{
		this.center = center;
		updateCalculations();
	}

	public void setZoom(float zoom)
	{
		this.zoom = zoom;
		updateCalculations();
	}

	public void setGraphicsWidth(int graphicsWidth)
	{
		this.graphicsWidth = graphicsWidth;
		updateCalculations();
	}

	public void setGraphicsHeight(int graphicsHeight)
	{
		this.graphicsHeight = graphicsHeight;
		updateCalculations();
	}

	private int regionSizeScaled;
	private Point tileOffset;
	@Getter
	private float pixelsPerTile;
	private Point graphicalOffset;
	private Point graphicalCenter;

	private void updateCalculations()
	{
		//Calculate region graphical size.
		regionSizeScaled = (int) (REGION_GRAPHIC_SIZE * zoom);
		//How far from top left of region this tile is
		tileOffset = new Point(center.getX() % REGION_TILE_SIZE, center.getY() % REGION_TILE_SIZE);
		//Graphical size of tileOffset
		pixelsPerTile = regionSizeScaled / (float)REGION_TILE_SIZE;
		graphicalOffset = new Point((int)(tileOffset.x * pixelsPerTile), (int)(tileOffset.y * pixelsPerTile));
		graphicalCenter = new Point(graphicsWidth / 2, graphicsHeight / 2);
	}


	@Inject
	public WorldMapView()
	{
		if (regions == null)
		{
			regions = CacheBuilder.newBuilder()
				.maximumSize(1685)
				.expireAfterAccess(1, TimeUnit.MINUTES)
				.build(
					new CacheLoader<Integer, BufferedImage>()
					{
						public BufferedImage load(Integer key) throws IOException
						{
							return ImageIO.read(WorldMapView.class.getResourceAsStream("/world_map/img-0-" + key + ".png"));
						}
					});
		}
	}

	private static BufferedImage getMapRegion(Point worldPoint)
	{
		try
		{
			int x = worldPoint.x;
			int y = worldPoint.y;
			int regionX = x >> 6;
			int regionY = y >> 6;
			int regionId = regionX << 8 | regionY;
			return regions.get(regionId);
		}
		catch (ExecutionException e)
		{
			return null;
		}
	}

	public Point[] worldPointsToGraphicsPoint(WorldPoint[] worldPoints)
	{
		Point[] retPoints = new Point[worldPoints.length];
		for (int i = 0; i < worldPoints.length; i++)
		{
			retPoints[i] = worldPointToGraphicsPoint(worldPoints[i]);
		}
		return  retPoints;
	}

	/**
	 *
	 * @param worldPoint A WorldPoint to calculate the graphical position for
	 * @return the graphical coordinates of the specified point.
	 */
	public Point worldPointToGraphicsPoint(WorldPoint worldPoint)
	{
		Point difference = new Point((int) ((worldPoint.getX() - center.getX()) * pixelsPerTile), (int) ((center.getY() - worldPoint.getY()) * pixelsPerTile));
		difference.translate(graphicalCenter.x, graphicalCenter.y);
		return difference;
	}

	public BufferedImage getMapImage()
	{
		BufferedImage mapImage = new BufferedImage(graphicsWidth, graphicsHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = mapImage.createGraphics();

		//Get top left corner of where center region would be drawn.
		Point drawingWorldPoint = new Point(center.getX(), center.getY());
		Rectangle drawingDestionation = new Rectangle(graphicalCenter.x - graphicalOffset.x, graphicalCenter.y - (regionSizeScaled - graphicalOffset.y), regionSizeScaled, regionSizeScaled);

		while (drawingDestionation.x > 0)
		{
			//Go as far left as needed
			drawingDestionation.x -= regionSizeScaled;
			drawingWorldPoint.x -= REGION_TILE_SIZE;
		}

		while (drawingDestionation.y > 0)
		{
			//Go as far up as needed
			drawingDestionation.y -= regionSizeScaled;
			drawingWorldPoint.y += REGION_TILE_SIZE;
		}

		int yGraphicalBound = drawingDestionation.y;
		int yWorldBound = drawingWorldPoint.y;
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		while (drawingDestionation.x < graphicsWidth)
		{

			while (drawingDestionation.y < graphicsHeight)
			{
				BufferedImage image = getMapRegion(drawingWorldPoint);
				graphics.drawImage(image, drawingDestionation.x, drawingDestionation.y, drawingDestionation.width, drawingDestionation.height, null);

				drawingDestionation.translate(0, regionSizeScaled);
				drawingWorldPoint.translate(0, -REGION_TILE_SIZE);
			}
			drawingDestionation.setLocation(drawingDestionation.x + regionSizeScaled, yGraphicalBound);
			drawingWorldPoint.setLocation(drawingWorldPoint.x + REGION_TILE_SIZE, yWorldBound);
		}

		return mapImage;
	}
}
