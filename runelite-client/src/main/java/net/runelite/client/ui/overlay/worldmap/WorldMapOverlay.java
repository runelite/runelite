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

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.input.MouseManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

@Singleton
public class WorldMapOverlay extends Overlay
{
	private static final int TOOLTIP_OFFSET_HEIGHT = 25;
	private static final int TOOLTIP_OFFSET_WIDTH = 5;
	private static final int TOOLTIP_PADDING_HEIGHT = 1;
	private static final int TOOLTIP_PADDING_WIDTH = 2;

	private final WorldMapPointManager worldMapPointManager;
	private final Client client;

	@Inject
	private WorldMapOverlay(
		Client client,
		WorldMapPointManager worldMapPointManager,
		MouseManager mouseManager,
		WorldMapOverlayMouseListener worldMapOverlayMouseListener)
	{
		this.client = client;
		this.worldMapPointManager = worldMapPointManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ABOVE_MAP);
		mouseManager.registerMouseListener(worldMapOverlayMouseListener);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<WorldMapPoint> points = worldMapPointManager.getWorldMapPoints();

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
		final Area mapViewArea = getWorldMapClipArea(worldMapRectangle);
		final Rectangle canvasBounds = client.getCanvas().getBounds();
		// in fixed, the bounds are offset by the size of the black borders outside the canvas
		canvasBounds.setLocation(0, 0);
		final Area canvasViewArea = getWorldMapClipArea(canvasBounds);
		Area currentClip = null;

		WorldMapPoint tooltipPoint = null;

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

				if (worldPoint.isSnapToEdge() && canvasViewArea != currentClip)
				{
					graphics.setClip(canvasViewArea);
					currentClip = canvasViewArea;
				}
				else if (!worldPoint.isSnapToEdge() && mapViewArea != currentClip)
				{
					graphics.setClip(mapViewArea);
					currentClip = mapViewArea;
				}

				if (worldPoint.isSnapToEdge())
				{
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

		return null;
	}

	/**
	 * Get the screen coordinates for a WorldPoint on the world map
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
	 * Gets a clip area which excludes the area of widgets which overlay the world map.
	 *
	 * @param baseRectangle The base area to clip from
	 * @return              An {@link Area} representing <code>baseRectangle</code>, with the area
	 *                      of visible widgets overlaying the world map clipped from it.
	 */
	private Area getWorldMapClipArea(Rectangle baseRectangle)
	{
		final Widget overview = client.getWidget(WidgetInfo.WORLD_MAP_OVERVIEW_MAP);
		final Widget surfaceSelector = client.getWidget(WidgetInfo.WORLD_MAP_SURFACE_SELECTOR);

		Area clipArea = new Area(baseRectangle);

		if (overview != null && !overview.isHidden())
		{
			clipArea.subtract(new Area(overview.getBounds()));
		}

		if (surfaceSelector != null && !surfaceSelector.isHidden())
		{
			clipArea.subtract(new Area(surfaceSelector.getBounds()));
		}

		return clipArea;
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

		graphics.setClip(client.getCanvas().getBounds());
		graphics.setColor(JagexColors.TOOLTIP_BACKGROUND);
		graphics.setFont(FontManager.getRunescapeFont());
		FontMetrics fm = graphics.getFontMetrics();
		int width = fm.stringWidth(tooltip);
		int height = fm.getHeight();

		Rectangle tooltipRect = new Rectangle(drawPoint.getX() - TOOLTIP_PADDING_WIDTH, drawPoint.getY() - TOOLTIP_PADDING_HEIGHT, width + TOOLTIP_PADDING_WIDTH * 2, height + TOOLTIP_PADDING_HEIGHT * 2);
		graphics.fillRect((int) tooltipRect.getX(), (int) tooltipRect.getY(), (int) tooltipRect.getWidth(), (int) tooltipRect.getHeight());

		graphics.setColor(JagexColors.TOOLTIP_BORDER);
		graphics.drawRect((int) tooltipRect.getX(), (int) tooltipRect.getY(), (int) tooltipRect.getWidth(), (int) tooltipRect.getHeight());
		graphics.setColor(JagexColors.TOOLTIP_TEXT);
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
