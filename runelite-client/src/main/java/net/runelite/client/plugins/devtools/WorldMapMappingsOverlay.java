/*
 * Copyright (c) 2024, Zoinkwiz <https://github.com/Zoinkwiz>
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
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.worldmap.*;

class WorldMapMappingsOverlay extends Overlay
{
	private static final Color RED_TRANSLUCENT = new Color(255, 0, 0, 127);
	private static final int LABEL_PADDING = 4;
	private static final int REGION_SIZE = 1 << 6;
	// Bitmask to return first coordinate in region
	private static final int REGION_TRUNCATE = ~((1 << 6) - 1);
	private final Client client;
	private final WorldMapAreaManager worldMapAreaManager;
	private final DevToolsPlugin plugin;

	@Inject
	private WorldMapMappingsOverlay(Client client, WorldMapAreaManager worldMapAreaManager, DevToolsPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(PRIORITY_HIGH);
		setLayer(OverlayLayer.MANUAL);
		drawAfterInterface(InterfaceID.WORLD_MAP);
		this.client = client;
		this.worldMapAreaManager = worldMapAreaManager;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getWorldMapMapping().isActive())
		{
			return null;
		}

		drawRegionOverlay(graphics);
		return null;
	}

	private void drawRegionOverlay(Graphics2D graphics)
	{
		WorldMap worldMap = client.getWorldMap();
		Widget map = client.getWidget(ComponentID.WORLD_MAP_MAPVIEW);
		float pixelsPerTile = worldMap.getWorldMapZoom();

		if (map == null)
		{
			return;
		}

		Rectangle worldMapRect = map.getBounds();
		graphics.setClip(worldMapRect);

		int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
		int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

		Point worldMapPosition = worldMap.getWorldMapPosition();

		// Offset in tiles from anchor sides
		int yTileMin = worldMapPosition.getY() - heightInTiles / 2;
		int xRegionMin = (worldMapPosition.getX() - widthInTiles / 2) & REGION_TRUNCATE;
		int xRegionMax = ((worldMapPosition.getX() + widthInTiles / 2) & REGION_TRUNCATE) + REGION_SIZE;
		int yRegionMin = (yTileMin & REGION_TRUNCATE);
		int yRegionMax = ((worldMapPosition.getY() + heightInTiles / 2) & REGION_TRUNCATE) + REGION_SIZE;

		for (int x = xRegionMin; x < xRegionMax; x += REGION_SIZE)
		{
			for (int y = yRegionMin; y < yRegionMax; y += REGION_SIZE)
			{
				int yTileOffset = -(yTileMin - y);
				int xTileOffset = x + widthInTiles / 2 - worldMapPosition.getX();

				int regionId = ((x >> 6) << 8) | (y >> 6);

				List<WorldMapPointMapping> mappings = WorldPointMapper.getMappingsInRegion(regionId);
				if (mappings != null)
				{
					drawMappedRegion(graphics, regionId, pixelsPerTile, xTileOffset, yTileOffset, worldMapRect);
				}
			}
		}
	}

	private void drawMappedRegion(Graphics2D graphics, int regionId, float pixelsPerTile, int xTileOffset, int yTileOffset, Rectangle worldMapRect)
	{
		List<WorldMapPointMapping> mappings = WorldPointMapper.getMappingsInRegion(regionId);

		for (WorldMapPointMapping mapping : mappings)
		{
			if (mapping.getArea() != worldMapAreaManager.getWorldMapArea())
			{
				continue;
			}

			graphics.setColor(RED_TRANSLUCENT);

			int pixelShiftMinX = (int) (mapping.getMinChunkXMap() * pixelsPerTile);
			int pixelShiftMaxX = (int) (mapping.getMaxChunkXMap() * pixelsPerTile);
			int pixelShiftMinY = (int) (mapping.getMinChunkYMap() * pixelsPerTile);
			int pixelShiftMaxY = (int) (mapping.getMaxChunkYMap() * pixelsPerTile);

			int rectX = ((int) (xTileOffset * pixelsPerTile)) + pixelShiftMinX + (int) worldMapRect.getX();
			int rectY = (worldMapRect.height - (int) (yTileOffset * pixelsPerTile)) - pixelShiftMaxY + (int) worldMapRect.getY();

			int rectWidth = pixelShiftMaxX - pixelShiftMinX;
			int rectHeight = pixelShiftMaxY - pixelShiftMinY;

			graphics.drawRect(rectX, rectY, rectWidth, rectHeight);

			String mappingLabel = String.valueOf(WorldPointMapper.getWorldRegionIDFromMapRegionID(regionId, mapping));
			drawRegionText(graphics, mappingLabel, rectX, rectY);
		}
	}

	private void drawRegionText(Graphics2D graphics, String regionText, int x, int y)
	{
		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(regionText, graphics);
		int labelWidth = (int) textBounds.getWidth() + 2 * LABEL_PADDING;
		int labelHeight = (int) textBounds.getHeight() + 2 * LABEL_PADDING;
		graphics.fillRect(x, y, labelWidth, labelHeight);
		graphics.setColor(Color.BLACK);
		graphics.drawString(regionText, x + LABEL_PADDING, y + (int) textBounds.getHeight() + LABEL_PADDING);
	}
}
