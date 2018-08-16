/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package net.runelite.client.ui.overlay.worldmap;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Line;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.coords.WorldLine;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.input.MouseManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
@Slf4j
public class WorldMapOverlay extends Overlay
{
	private static final Color TOOLTIP_BACKGROUND = new Color(255, 255, 160);
	private static final int TOOLTIP_OFFSET_HEIGHT = 25;
	private static final int TOOLTIP_OFFSET_WIDTH = 5;
	private static final int TOOLTIP_PADDING_HEIGHT = 1;
	private static final int TOOLTIP_PADDING_WIDTH = 2;

	private final WorldMapPointManager worldMapPointManager;
	private final WorldMapLineManager worldMapLineManager;
	private final Client client;

	@Inject
	private WorldMapOverlay(
		Client client,
		WorldMapPointManager worldMapPointManager,
		WorldMapLineManager worldMaplineManager,
		MouseManager mouseManager,
		WorldMapOverlayMouseListener worldMapOverlayMouseListener)
	{
		this.client = client;
		this.worldMapPointManager = worldMapPointManager;

		this.worldMapLineManager = worldMaplineManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		mouseManager.registerMouseListener(worldMapOverlayMouseListener);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<WorldMapPoint> points = worldMapPointManager.getWorldMapPoints();
		final List<WorldMapLine> lines = worldMapLineManager.getWorldMapLines();

		if (points.isEmpty())
		{
			return null;
		}

		Widget widget = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
		if (widget == null)
		{
			return null;
		}

		final Rectangle worldMapRectangle = widget.getBounds();
		WorldMapPoint tooltipPoint = null;
		WorldMapLine tooltipLine = null;

		for (WorldMapLine line : lines)
		{
			Line screenLine = mapWorldLineToGraphicsLine(line.getWorldLine());
			if (screenLine != null)
			{
				graphics.setColor(line.getColor());
				graphics.drawLine(screenLine.getStart().getX(), screenLine.getStart().getY(), screenLine.getEnd().getX(), screenLine.getEnd().getY());
				Rectangle clickbox = screenLine.getScreenRectangle();
				line.setClickbox(clickbox);
			}
			else
			{
				line.setClickbox(null);
			}

			if (line.isTooltipVisible())
			{
				tooltipLine = line;
			}
		}

		for (WorldMapPoint worldPoint : points)
		{
			BufferedImage image = worldPoint.getImage();
			WorldPoint point = worldPoint.getWorldPoint();

			if (image != null && point != null)
			{
				Point drawPoint = mapWorldPointToGraphicsPoint(point);

				if (drawPoint == null)
				{
					worldPoint.setClickbox(null);
					continue;
				}

				if (worldPoint.isSnapToEdge())
				{
					Canvas canvas = client.getCanvas();
					graphics.setClip(0, 0, canvas.getWidth(), canvas.getHeight());

					if (worldMapRectangle.contains(drawPoint.getX(), drawPoint.getY()))
					{
						if (worldPoint.isCurrentlyEdgeSnapped())
						{
							worldPoint.setCurrentlyEdgeSnapped(false);
							worldPoint.onEdgeUnsnap();
						}
					}
					else
					{
						drawPoint = clipToRectangle(drawPoint, worldMapRectangle);
						if (!worldPoint.isCurrentlyEdgeSnapped())
						{
							worldPoint.setCurrentlyEdgeSnapped(true);
							worldPoint.onEdgeSnap();
						}
					}
				}
				else
				{
					graphics.setClip(worldMapRectangle);
				}

				int drawX = drawPoint.getX();
				int drawY = drawPoint.getY();

				if (worldPoint.getImagePoint() == null)
				{
					drawX -= image.getWidth() / 2;
					drawY -= image.getHeight() / 2;
				}
				else
				{
					drawX -= worldPoint.getImagePoint().getX();
					drawY -= worldPoint.getImagePoint().getY();
				}

				graphics.drawImage(image, drawX, drawY, null);
				Rectangle clickbox = new Rectangle(drawX, drawY, image.getWidth(), image.getHeight());
				worldPoint.setClickbox(clickbox);

				if (worldPoint.isTooltipVisible())
				{
					tooltipPoint = worldPoint;
				}
			}
		}

		if (tooltipPoint != null)
		{
			drawTooltip(graphics, tooltipPoint);
		}

		if (tooltipLine != null && tooltipPoint == null)
		{
			drawTooltip(graphics, tooltipLine);
		}

		return null;
	}

	/**
	 * Get the screen coordinates for a WorldPoint on the world map
	 *
	 * @param worldPoint WorldPoint to get screen coordinates of
	 * @return Point of screen coordinates of the center of the world point
	 */
	public Point mapWorldPointToGraphicsPoint(WorldPoint worldPoint)
	{
		RenderOverview ro = client.getRenderOverview();

		if (!ro.getWorldMapData().surfaceContainsPosition(worldPoint.getX(), worldPoint.getY()))
		{
			return null;
		}

		Float pixelsPerTile = ro.getWorldMapZoom();

		Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
		if (map != null)
		{
			Rectangle worldMapRect = map.getBounds();

			int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
			int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

			Point worldMapPosition = ro.getWorldMapPosition();

			//Offset in tiles from anchor sides
			int yTileMax = worldMapPosition.getY() - heightInTiles / 2;
			int yTileOffset = (yTileMax - worldPoint.getY() - 1) * -1;
			int xTileOffset = worldPoint.getX() + widthInTiles / 2 - worldMapPosition.getX();

			int xGraphDiff = ((int) (xTileOffset * pixelsPerTile));
			int yGraphDiff = (int) (yTileOffset * pixelsPerTile);

			//Center on tile.
			yGraphDiff -= pixelsPerTile - Math.ceil(pixelsPerTile / 2);
			xGraphDiff += pixelsPerTile - Math.ceil(pixelsPerTile / 2);

			yGraphDiff = worldMapRect.height - yGraphDiff;
			yGraphDiff += (int) worldMapRect.getY();
			xGraphDiff += (int) worldMapRect.getX();

			return new Point(xGraphDiff, yGraphDiff);
		}
		return null;
	}

	/**
	 * Get the screen coordinates for a WorldPoint on the world map
	 *
	 * @param worldLine WorldPoint to get screen coordinates of
	 * @return Line2D containing points of screen coordinates
	 */
	private Line mapWorldLineToGraphicsLine(WorldLine worldLine)
	{

		RenderOverview ro = client.getRenderOverview();


		Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
		if (map != null)
		{
			Float pixelsPerTile = ro.getWorldMapZoom();

			Rectangle worldMapRect = map.getBounds();


			Point worldMapPosition = ro.getWorldMapPosition();

			int y = worldMapPosition.getY();
			int x = worldMapPosition.getX();

			int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
			int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

			int rx1 = x - widthInTiles / 2;
			int ry1 = y - heightInTiles / 2;
			int rx2 = rx1 + widthInTiles;
			int ry2 = ry1 + heightInTiles;

			WorldLine line = worldLine.liangBarsky(rx1, ry1, rx2, ry2);
			if (line != null)
			{
				return line.toMapLine(worldMapPosition, worldMapRect, pixelsPerTile);
			}
		}

		return null;
	}


	private void drawTooltip(Graphics2D graphics, WorldMapPoint worldPoint)
	{
		String tooltip = worldPoint.getTooltip();
		Point drawPoint = mapWorldPointToGraphicsPoint(worldPoint.getWorldPoint());
		if (tooltip == null || tooltip.length() <= 0 || drawPoint == null)
		{
			return;
		}

		drawPoint = new Point(drawPoint.getX() + TOOLTIP_OFFSET_WIDTH, drawPoint.getY() + TOOLTIP_OFFSET_HEIGHT);

		graphics.setClip(0, 0, client.getCanvas().getWidth(), client.getCanvas().getHeight());
		graphics.setColor(TOOLTIP_BACKGROUND);
		graphics.setFont(FontManager.getRunescapeFont());
		FontMetrics fm = graphics.getFontMetrics();
		int width = fm.stringWidth(tooltip);
		int height = fm.getHeight();

		Rectangle tooltipRect = new Rectangle(drawPoint.getX() - TOOLTIP_PADDING_WIDTH, drawPoint.getY() - TOOLTIP_PADDING_HEIGHT, width + TOOLTIP_PADDING_WIDTH * 2, height + TOOLTIP_PADDING_HEIGHT * 2);
		graphics.fillRect((int) tooltipRect.getX(), (int) tooltipRect.getY(), (int) tooltipRect.getWidth(), (int) tooltipRect.getHeight());

		graphics.setColor(Color.black);
		graphics.drawRect((int) tooltipRect.getX(), (int) tooltipRect.getY(), (int) tooltipRect.getWidth(), (int) tooltipRect.getHeight());
		graphics.drawString(tooltip, drawPoint.getX(), drawPoint.getY() + height);
	}

	private void drawTooltip(Graphics2D graphics, WorldMapLine worldLine)
	{
		String tooltip = worldLine.getTooltip();
		Point drawPoint = client.getMouseCanvasPosition();
		if (tooltip == null || tooltip.length() <= 0 || drawPoint == null)
		{
			return;
		}

		drawPoint = new Point(drawPoint.getX() + TOOLTIP_OFFSET_WIDTH, drawPoint.getY() + TOOLTIP_OFFSET_HEIGHT);

		graphics.setClip(0, 0, client.getCanvas().getWidth(), client.getCanvas().getHeight());
		graphics.setColor(TOOLTIP_BACKGROUND);
		graphics.setFont(FontManager.getRunescapeFont());
		FontMetrics fm = graphics.getFontMetrics();
		int width = fm.stringWidth(tooltip);
		int height = fm.getHeight();

		Rectangle tooltipRect = new Rectangle(drawPoint.getX() - TOOLTIP_PADDING_WIDTH, drawPoint.getY() - TOOLTIP_PADDING_HEIGHT, width + TOOLTIP_PADDING_WIDTH * 2, height + TOOLTIP_PADDING_HEIGHT * 2);
		graphics.fillRect((int) tooltipRect.getX(), (int) tooltipRect.getY(), (int) tooltipRect.getWidth(), (int) tooltipRect.getHeight());

		graphics.setColor(Color.black);
		graphics.drawRect((int) tooltipRect.getX(), (int) tooltipRect.getY(), (int) tooltipRect.getWidth(), (int) tooltipRect.getHeight());
		graphics.drawString(tooltip, drawPoint.getX(), drawPoint.getY() + height);
	}

	private Point clipToRectangle(Point drawPoint, Rectangle mapDisplayRectangle)
	{
		int clippedX = drawPoint.getX();

		if (drawPoint.getX() < mapDisplayRectangle.getX())
		{
			clippedX = (int) mapDisplayRectangle.getX();
		}

		if (drawPoint.getX() > mapDisplayRectangle.getX() + mapDisplayRectangle.getWidth())
		{
			clippedX = (int) (mapDisplayRectangle.getX() + mapDisplayRectangle.getWidth());
		}

		int clippedY = drawPoint.getY();

		if (drawPoint.getY() < mapDisplayRectangle.getY())
		{
			clippedY = (int) mapDisplayRectangle.getY();
		}

		if (drawPoint.getY() > mapDisplayRectangle.getY() + mapDisplayRectangle.getHeight())
		{
			clippedY = (int) (mapDisplayRectangle.getY() + mapDisplayRectangle.getHeight());
		}

		return new Point(clippedX, clippedY);
	}
}
