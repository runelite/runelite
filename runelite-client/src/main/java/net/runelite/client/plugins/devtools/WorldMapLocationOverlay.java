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
import net.runelite.api.RenderOverview;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;

public class WorldMapLocationOverlay extends Overlay
{
	private final Client client;
	private final WorldMapOverlay worldMapOverlay;
	private final DevToolsPlugin plugin;

	@Inject
	private WorldMapLocationOverlay(Client client, WorldMapOverlay worldMapOverlay, DevToolsPlugin plugin)
	{
		this.client = client;
		this.worldMapOverlay = worldMapOverlay;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.MANUAL);
		drawAfterInterface(WidgetID.WORLD_MAP_GROUP_ID);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getWorldMapLocation().isActive())
		{
			return null;
		}

		RenderOverview ro = client.getRenderOverview();
		Widget worldMapWidget = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);

		if (ro == null || worldMapWidget == null)
		{
			return null;
		}

		Rectangle worldMapRectangle = worldMapWidget.getBounds();

		graphics.setClip(worldMapRectangle);
		graphics.setColor(Color.CYAN);

		WorldPoint mapCenterPoint = new WorldPoint(ro.getWorldMapPosition().getX(), ro.getWorldMapPosition().getY(), 0);
		Point middle = worldMapOverlay.mapWorldPointToGraphicsPoint(mapCenterPoint);

		if (middle == null)
		{
			return null;
		}

		graphics.drawLine(middle.getX(), worldMapRectangle.y, middle.getX(), worldMapRectangle.y + worldMapRectangle.height);
		graphics.drawLine(worldMapRectangle.x, middle.getY(), worldMapRectangle.x + worldMapRectangle.width, middle.getY());

		String output = "Center: " + mapCenterPoint.getX() + ", " + mapCenterPoint.getY();
		graphics.setColor(Color.white);
		FontMetrics fm = graphics.getFontMetrics();
		int height = fm.getHeight();
		int width = fm.stringWidth(output);
		graphics.fillRect((int)worldMapRectangle.getX(), (int)worldMapRectangle.getY() + worldMapRectangle.height - height, (int)worldMapRectangle.getX() + width, (int)worldMapRectangle.getY() + worldMapRectangle.height);

		graphics.setColor(Color.BLACK);
		graphics.drawString(output, (int) worldMapRectangle.getX(), (int) worldMapRectangle.getY() + worldMapRectangle.height);

		return null;
	}
}
