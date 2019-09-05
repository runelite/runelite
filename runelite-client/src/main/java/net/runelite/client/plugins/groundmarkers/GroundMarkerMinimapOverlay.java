/*
 * Copyright (c) 2019, Benjamin <https://github.com/genetic-soybean>
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
package net.runelite.client.plugins.groundmarkers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import static java.lang.Math.floor;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
class GroundMarkerMinimapOverlay extends Overlay
{
	private static final int TILE_WIDTH = 4;
	private static final int TILE_HEIGHT = 4;

	private final Client client;
	private final GroundMarkerPlugin plugin;

	@Inject
	private GroundMarkerMinimapOverlay(final Client client, final GroundMarkerPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isShowMinimap())
		{
			return null;
		}

		final List<GroundMarkerWorldPoint> points = plugin.getPoints();
		for (final GroundMarkerWorldPoint point : points)
		{
			WorldPoint worldPoint = point.getWorldPoint();
			if (worldPoint.getPlane() != client.getPlane())
			{
				continue;
			}

			Color color = plugin.getMarkerColor();
			switch (point.getGroundMarkerPoint().getGroup())
			{
				case 2:
					color = plugin.getMarkerColor2();
					break;
				case 3:
					color = plugin.getMarkerColor3();
					break;
				case 4:
					color = plugin.getMarkerColor4();
					break;
				case 5:
					color = plugin.getMarkerColor5();
					break;
				case 6:
					color = plugin.getMarkerColor6();
					break;
				case 7:
					color = plugin.getMarkerColor7();
					break;
				case 8:
					color = plugin.getMarkerColor8();
					break;
				case 9:
					color = plugin.getMarkerColor9();
					break;
				case 10:
					color = plugin.getMarkerColor10();
					break;
				case 11:
					color = plugin.getMarkerColor11();
					break;
				case 12:
					color = plugin.getMarkerColor12();
			}

			int opacity = (int) floor(plugin.getMinimapOverlayOpacity() * 2.55);
			Color tileColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity);

			drawOnMinimap(graphics, worldPoint, tileColor);
		}

		return null;
	}

	private void drawOnMinimap(Graphics2D graphics, WorldPoint point, Color color)
	{

		LocalPoint lp = LocalPoint.fromWorld(client, point);
		if (lp == null)
		{
			return;
		}

		Point posOnMinimap = Perspective.localToMinimap(client, lp);
		if (posOnMinimap == null)
		{
			return;
		}

		OverlayUtil.renderMinimapRect(client, graphics, posOnMinimap, TILE_WIDTH, TILE_HEIGHT, color);
	}
}