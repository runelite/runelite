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
package net.runelite.client.plugins.devtools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.worldmap.WorldMapAreaManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;
import net.runelite.client.ui.overlay.worldmap.WorldPointToWorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldPointWithWorldMapArea;

public class WorldMapLocationOverlay extends Overlay
{
	private final Client client;
	private final WorldMapOverlay worldMapOverlay;
	private final WorldMapAreaManager worldMapAreaManager;
	private final DevToolsPlugin plugin;

	@Inject
	private WorldMapLocationOverlay(Client client, WorldMapOverlay worldMapOverlay, WorldMapAreaManager worldMapAreaManager, DevToolsPlugin plugin)
	{
		this.client = client;
		this.worldMapOverlay = worldMapOverlay;
		this.worldMapAreaManager = worldMapAreaManager;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(PRIORITY_HIGHEST);
		setLayer(OverlayLayer.MANUAL);
		drawAfterInterface(InterfaceID.WORLD_MAP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getWorldMapLocation().isActive())
		{
			return null;
		}

		WorldMap worldMap = client.getWorldMap();
		Widget worldMapWidget = client.getWidget(ComponentID.WORLD_MAP_MAPVIEW);

		if (worldMap == null || worldMapWidget == null)
		{
			return null;
		}

		Rectangle worldMapRectangle = worldMapWidget.getBounds();

		graphics.setClip(worldMapRectangle);
		graphics.setColor(Color.CYAN);

		WorldPoint mapWorldPointMapFocus = new WorldPoint(worldMap.getWorldMapPosition().getX(), worldMap.getWorldMapPosition().getY(), 0);
		WorldPointWithWorldMapArea realWorldPointOfMapFocus = WorldPointToWorldMapPoint.getRealWorldPointFromMapPoint(mapWorldPointMapFocus, worldMapAreaManager.getWorldMapArea());
		Point focusPoint = worldMapOverlay.mapWorldPointToGraphicsPoint(mapWorldPointMapFocus);

		WorldPoint mapCenterWorldPoint = realWorldPointOfMapFocus.getWorldPoint();
		Point trueFocusPoint = worldMapOverlay.mapWorldPointToGraphicsPointIncludingNonSurfaces(mapCenterWorldPoint);

		if (focusPoint == null)
		{
			return null;
		}

		graphics.drawLine(focusPoint.getX(), worldMapRectangle.y, focusPoint.getX(), worldMapRectangle.y + worldMapRectangle.height);
		graphics.drawLine(worldMapRectangle.x, focusPoint.getY(), worldMapRectangle.x + worldMapRectangle.width, focusPoint.getY());
		if (trueFocusPoint != null)
		{
			graphics.drawRect(trueFocusPoint.getX() - 5, trueFocusPoint.getY() - 5, 10, 10);
		}

		String output = "Center: " + mapCenterWorldPoint.getX() + ", " + mapCenterWorldPoint.getY() + ", " + mapCenterWorldPoint.getPlane();
		graphics.setColor(Color.white);
		FontMetrics fm = graphics.getFontMetrics();
		int height = fm.getHeight();
		int width = fm.stringWidth(output);
		graphics.fillRect((int)worldMapRectangle.getX(), (int) worldMapRectangle.getY() + worldMapRectangle.height - height, (int)worldMapRectangle.getX() + width, (int)worldMapRectangle.getY() + worldMapRectangle.height);

		graphics.setColor(Color.BLACK);
		graphics.drawString(output, (int) worldMapRectangle.getX(), (int) worldMapRectangle.getY() + worldMapRectangle.height);

		return null;
	}
}
