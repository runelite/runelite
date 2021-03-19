/*
 * Copyright (c) 2018, Alex Kolpa <https://github.com/AlexKolpa>
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
package net.runelite.client.plugins.devtools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class WorldMapRegionOverlay extends Overlay
{
	private static final Color WHITE_TRANSLUCENT = new Color(255, 255, 255, 127);
	private static final int LABEL_PADDING = 4;
	private static final int REGION_SIZE = 1 << 6;
	// Bitmask to return first coordinate in region
	private static final int REGION_TRUNCATE = ~((1 << 6) - 1);
	private final Client client;
	private final DevToolsPlugin plugin;

	@Inject
	private WorldMapRegionOverlay(Client client, DevToolsPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.MANUAL);
		drawAfterInterface(WidgetID.WORLD_MAP_GROUP_ID);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getWorldMapLocation().isActive())
		{
			return null;
		}

		drawRegionOverlay(graphics);
		return null;
	}

	private void drawRegionOverlay(Graphics2D graphics)
	{
		RenderOverview ro = client.getRenderOverview();
		Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
		Float pixelsPerTile = ro.getWorldMapZoom();

		if (map == null)
		{
			return;
		}

		Rectangle worldMapRect = map.getBounds();
		graphics.setClip(worldMapRect);

		int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
		int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

		Point worldMapPosition = ro.getWorldMapPosition();

		// Offset in tiles from anchor sides
		int yTileMin = worldMapPosition.getY() - heightInTiles / 2;
		int xRegionMin = (worldMapPosition.getX() - widthInTiles / 2) & REGION_TRUNCATE;
		int xRegionMax = ((worldMapPosition.getX() + widthInTiles / 2) & REGION_TRUNCATE) + REGION_SIZE;
		int yRegionMin = (yTileMin & REGION_TRUNCATE);
		int yRegionMax = ((worldMapPosition.getY() + heightInTiles / 2) & REGION_TRUNCATE) + REGION_SIZE;
		int regionPixelSize = (int) Math.ceil(REGION_SIZE * pixelsPerTile);

		for (int x = xRegionMin; x < xRegionMax; x += REGION_SIZE)
		{
			for (int y = yRegionMin; y < yRegionMax; y += REGION_SIZE)
			{
				graphics.setColor(WHITE_TRANSLUCENT);

				int yTileOffset = -(yTileMin - y);
				int xTileOffset = x + widthInTiles / 2 - worldMapPosition.getX();

				int xPos = ((int) (xTileOffset * pixelsPerTile)) + (int) worldMapRect.getX();
				int yPos = (worldMapRect.height - (int) (yTileOffset * pixelsPerTile)) + (int) worldMapRect.getY();
				// Offset y-position by a single region to correct for drawRect starting from the top
				yPos -= regionPixelSize;

				graphics.drawRect(xPos, yPos, regionPixelSize, regionPixelSize);

				int regionId = ((x >> 6) << 8) | (y >> 6);
				String regionText = String.valueOf(regionId);
				FontMetrics fm = graphics.getFontMetrics();
				Rectangle2D textBounds = fm.getStringBounds(regionText, graphics);
				int labelWidth = (int) textBounds.getWidth() + 2 * LABEL_PADDING;
				int labelHeight = (int) textBounds.getHeight() + 2 * LABEL_PADDING;
				graphics.fillRect(xPos, yPos, labelWidth, labelHeight);
				graphics.setColor(Color.BLACK);
				graphics.drawString(regionText, xPos + LABEL_PADDING, yPos + (int) textBounds.getHeight() + LABEL_PADDING);
			}
		}
	}
}
