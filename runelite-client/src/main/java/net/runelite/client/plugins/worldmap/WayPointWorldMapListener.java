/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
package net.runelite.client.plugins.worldmap;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.input.MouseAdapter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

@Singleton
public class WayPointWorldMapListener extends MouseAdapter
{

	private final Client client;

	private final WorldMapConfig config;
	private final WorldMapPlugin plugin;

	@Inject
	private WayPointWorldMapListener(Client client, WorldMapPlugin plugin, WorldMapConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent e)
	{
		if (!SwingUtilities.isLeftMouseButton(e))
		{
			return e;
		}

		if (!config.isWaypointEnabled())
		{
			return e;
		}

		if (e.getClickCount() % 2 != 0)
		{
			return e;
		}

		Widget mapWidget = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);

		if (mapWidget == null)
		{
			return e;
		}

		Rectangle worldMapRect = mapWidget.getBounds();
		Point mousePos = client.getMouseCanvasPosition();

		if (!worldMapRect.contains(mousePos.getX(), mousePos.getY()))
		{
			return e;
		}

		if (plugin.hasWayPoint())
		{
			plugin.removeWayPoint();
			return e;
		}

		RenderOverview ro = client.getRenderOverview();
		Float pixelsPerTile = ro.getWorldMapZoom();

		// Get mouse location in world map window
		int xMouseInBounds = mousePos.getX() - (int) worldMapRect.getX();
		int yMouseInBounds = mousePos.getY() - (int) worldMapRect.getY();

		// Get center pixel because that's where we calculate the offset from
		int xCenterPixel = (int) (worldMapRect.getWidth() / 2);
		int yCenterPixel = (int) (worldMapRect.getHeight() / 2);

		// Get offset in amount of pixels and tiles
		int xOffset = xMouseInBounds - xCenterPixel;
		int yOffset = yCenterPixel - yMouseInBounds;
		int xTileOffset = (int) (xOffset / pixelsPerTile);
		int yTileOffset = (int) (yOffset / pixelsPerTile);

		// Get actual tile position
		int xPos = ro.getWorldMapPosition().getX() + xTileOffset;
		int yPos = ro.getWorldMapPosition().getY() + yTileOffset;

		plugin.setWayPoint(new WorldPoint(xPos, yPos, 0));

		return e;
	}
}