/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.multiindicators;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import javax.inject.Inject;

import net.runelite.api.geometry.Geometry;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

public class MultiIndicatorsMinimapOverlay extends Overlay
{
	private final static int MAX_LOCAL_DRAW_LENGTH = 20 * Perspective.LOCAL_TILE_SIZE;

	@Inject
	private Client client;

	@Inject
	private MultiIndicatorsPlugin plugin;

	@Inject
	private MultiIndicatorsConfig config;

	@Inject
	public MultiIndicatorsMinimapOverlay()
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		setPriority(OverlayPriority.LOW);
	}

	private Color getTransparentColorVersion(Color c)
	{
		return new Color(c.getRed(), c.getGreen(), c.getBlue(), 192);
	}

	private void renderPath(Graphics2D graphics, GeneralPath path, Color color)
	{
		LocalPoint playerLp = client.getLocalPlayer().getLocalLocation();
		Rectangle viewArea = new Rectangle(
			playerLp.getX() - MAX_LOCAL_DRAW_LENGTH,
			playerLp.getY() - MAX_LOCAL_DRAW_LENGTH,
			MAX_LOCAL_DRAW_LENGTH * 2,
			MAX_LOCAL_DRAW_LENGTH * 2);

		graphics.setColor(color);

		path = Geometry.clipPath(path, viewArea);
		path = Geometry.filterPath(path, (p1, p2) ->
			Perspective.localToMinimap(client, new LocalPoint((int) p1[0], (int) p1[1])) != null &&
				Perspective.localToMinimap(client, new LocalPoint((int) p2[0], (int) p2[1])) != null);
		path = Geometry.transformPath(path, coords ->
		{
			Point point = Perspective.localToMinimap(client, new LocalPoint((int) coords[0], (int) coords[1]));
			coords[0] = point.getX();
			coords[1] = point.getY();
		});

		graphics.draw(path);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showMinimapLines())
		{
			return null;
		}

		GeneralPath multicombatPath = plugin.getMulticombatPathToDisplay()[client.getPlane()];
		GeneralPath pvpPath = plugin.getPvpPathToDisplay()[client.getPlane()];

		if (config.multicombatZoneVisibility() != ZoneVisibility.HIDE && multicombatPath != null)
		{
			renderPath(graphics, multicombatPath, getTransparentColorVersion(config.multicombatColor()));
		}
		if ((config.showPvpSafeZones() || config.showDeadmanSafeZones()) && pvpPath != null)
		{
			renderPath(graphics, pvpPath, getTransparentColorVersion(config.safeZoneColor()));
		}

		return null;
	}
}