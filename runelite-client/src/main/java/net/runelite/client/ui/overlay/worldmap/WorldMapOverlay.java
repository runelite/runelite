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

import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.ColorUtil;

@Singleton
public class WorldMapOverlay extends Overlay
{
	private static final String FOCUS_ON = "Focus on";

	private static final int TOOLTIP_OFFSET_HEIGHT = 25;
	private static final int TOOLTIP_OFFSET_WIDTH = 5;
	private static final int TOOLTIP_PADDING_HEIGHT = 1;
	private static final int TOOLTIP_PADDING_WIDTH = 2;
	private static final int TOOLTIP_TEXT_OFFSET_HEIGHT = -2;

	private static final Splitter TOOLTIP_SPLITTER = Splitter.on("<br>").trimResults().omitEmptyStrings();

	private final WorldMapPointManager worldMapPointManager;
	private final Client client;

	private WorldMapPoint hoveredPoint;

	@Inject
	private WorldMapOverlay(
		Client client,
		WorldMapPointManager worldMapPointManager)
	{
		this.client = client;
		this.worldMapPointManager = worldMapPointManager;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(PRIORITY_HIGHEST);
		setLayer(OverlayLayer.MANUAL);
		drawAfterInterface(InterfaceID.WORLDMAP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final List<WorldMapPoint> points = worldMapPointManager.getWorldMapPoints();

		if (points.isEmpty())
		{
			return null;
		}

		Widget widget = client.getWidget(InterfaceID.Worldmap.MAP_CONTAINER);
		Widget bottomBar = client.getWidget(InterfaceID.Worldmap.BOTTOM_GRAPHIC0);
		if (widget == null || bottomBar == null)
		{
			return null;
		}

		bottomBar.setOnTimerListener((JavaScriptCallback) ev ->
		{
			WorldMapPoint worldPoint = hoveredPoint;
			if (client.isMenuOpen() || worldPoint == null)
			{
				return;
			}

			client.createMenuEntry(-1)
				.setTarget(ColorUtil.wrapWithColorTag(worldPoint.getName(), JagexColors.MENU_TARGET))
				.setOption(FOCUS_ON)
				.setType(MenuAction.RUNELITE)
				.onClick(m -> client.getWorldMap().setWorldMapPositionTarget(
					MoreObjects.firstNonNull(worldPoint.getTarget(), worldPoint.getWorldPoint())));
		});
		bottomBar.setHasListener(true);

		final Rectangle worldMapRectangle = widget.getBounds();
		final Shape mapViewArea = getWorldMapClipArea(worldMapRectangle);
		final Rectangle canvasBounds = new Rectangle(0, 0, client.getCanvasWidth(), client.getCanvasHeight());
		final Shape canvasViewArea = getWorldMapClipArea(canvasBounds);
		Shape currentClip = null;

		Point mousePos = client.getMouseCanvasPosition();
		if (!mapViewArea.contains(mousePos.getX(), mousePos.getY()))
		{
			mousePos = null;
		}

		hoveredPoint = null;

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
					// Get a smaller rect for edge-snapped icons so they display correctly at the edge
					final Rectangle snappedRect = widget.getBounds();
					snappedRect.grow(-image.getWidth() / 2, -image.getHeight() / 2);

					final Rectangle unsnappedRect = new Rectangle(snappedRect);
					if (worldPoint.getImagePoint() != null)
					{
						int dx = worldPoint.getImagePoint().getX() - (image.getWidth() / 2);
						int dy = worldPoint.getImagePoint().getY() - (image.getHeight() / 2);
						unsnappedRect.translate(dx, dy);
					}
					// Make the unsnap rect slightly smaller so a smaller snapped image doesn't cause a freak out
					if (worldPoint.isCurrentlyEdgeSnapped())
					{
						unsnappedRect.grow(-image.getWidth(), -image.getHeight());
					}

					if (unsnappedRect.contains(drawPoint.getX(), drawPoint.getY()))
					{
						if (worldPoint.isCurrentlyEdgeSnapped())
						{
							worldPoint.setCurrentlyEdgeSnapped(false);
							worldPoint.onEdgeUnsnap();
						}
					}
					else
					{
						drawPoint = clipToRectangle(drawPoint, snappedRect);
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
				if (mousePos != null && clickbox.contains(mousePos.getX(), mousePos.getY()))
				{
					if (!Strings.isNullOrEmpty(worldPoint.getTooltip()))
					{
						tooltipPoint = worldPoint;
					}

					if (worldPoint.isJumpOnClick())
					{
						assert worldPoint.getName() != null;
						hoveredPoint = worldPoint;
					}
				}
			}
		}

		final Widget rsTooltip = client.getWidget(InterfaceID.Worldmap.TOOLTIP);
		if (rsTooltip != null)
		{
			rsTooltip.setHidden(tooltipPoint != null);
		}

		if (tooltipPoint != null)
		{
			drawTooltip(graphics, tooltipPoint);
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
		WorldMap worldMap = client.getWorldMap();

		if (!worldMap.getWorldMapData().surfaceContainsPosition(worldPoint.getX(), worldPoint.getY()))
		{
			return null;
		}

		float pixelsPerTile = worldMap.getWorldMapZoom();

		Widget map = client.getWidget(InterfaceID.Worldmap.MAP_CONTAINER);
		if (map != null)
		{
			Rectangle worldMapRect = map.getBounds();

			int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
			int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

			Point worldMapPosition = worldMap.getWorldMapPosition();

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
	private Shape getWorldMapClipArea(Rectangle baseRectangle)
	{
		final Widget overview = client.getWidget(InterfaceID.Worldmap.OVERVIEW_CONTAINER);
		final Widget surfaceSelector = client.getWidget(InterfaceID.Worldmap.MAPLIST_BOX_GRAPHIC0);

		Area clipArea = new Area(baseRectangle);
		boolean subtracted = false;

		if (overview != null && !overview.isHidden())
		{
			clipArea.subtract(new Area(overview.getBounds()));
			subtracted = true;
		}

		if (surfaceSelector != null && !surfaceSelector.isHidden())
		{
			clipArea.subtract(new Area(surfaceSelector.getBounds()));
			subtracted = true;
		}

		// The sun g2d implementation is much more efficient at applying clips which are subclasses of rectangle2d,
		// so use that as the clip shape if possible
		return subtracted ? clipArea : baseRectangle;
	}

	private void drawTooltip(Graphics2D graphics, WorldMapPoint worldPoint)
	{
		String tooltip = worldPoint.getTooltip();
		Point drawPoint = mapWorldPointToGraphicsPoint(worldPoint.getWorldPoint());
		if (tooltip == null || tooltip.length() <= 0 || drawPoint == null)
		{
			return;
		}

		List<String> rows = TOOLTIP_SPLITTER.splitToList(tooltip);

		if (rows.isEmpty())
		{
			return;
		}

		drawPoint = new Point(drawPoint.getX() + TOOLTIP_OFFSET_WIDTH, drawPoint.getY() + TOOLTIP_OFFSET_HEIGHT);

		final Rectangle bounds = new Rectangle(0, 0, client.getCanvasWidth(), client.getCanvasHeight());
		final Shape mapArea = getWorldMapClipArea(bounds);
		graphics.setClip(mapArea);
		graphics.setColor(JagexColors.TOOLTIP_BACKGROUND);
		graphics.setFont(FontManager.getRunescapeFont());
		FontMetrics fm = graphics.getFontMetrics();
		int width = rows.stream().map(fm::stringWidth).max(Integer::compareTo).get();
		int height = fm.getHeight();

		Rectangle tooltipRect = new Rectangle(drawPoint.getX() - TOOLTIP_PADDING_WIDTH, drawPoint.getY() - TOOLTIP_PADDING_HEIGHT, width + TOOLTIP_PADDING_WIDTH * 2, height * rows.size() + TOOLTIP_PADDING_HEIGHT * 2);
		graphics.fillRect((int) tooltipRect.getX(), (int) tooltipRect.getY(), (int) tooltipRect.getWidth(), (int) tooltipRect.getHeight());

		graphics.setColor(JagexColors.TOOLTIP_BORDER);
		graphics.drawRect((int) tooltipRect.getX(), (int) tooltipRect.getY(), (int) tooltipRect.getWidth(), (int) tooltipRect.getHeight());

		graphics.setColor(JagexColors.TOOLTIP_TEXT);
		for (int i = 0; i < rows.size(); i++)
		{
			graphics.drawString(rows.get(i), drawPoint.getX(), drawPoint.getY() + TOOLTIP_TEXT_OFFSET_HEIGHT + (i + 1) * height);
		}
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
