/*
 * Copyright (c) 2019, Hexagon <hexagon@fking.work>
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
package net.runelite.client.plugins.zalcano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

class ZalcanoOverlay extends Overlay
{
	private final Client client;
	private final ZalcanoPlugin zalcanoPlugin;

	@Inject
	private ZalcanoOverlay(Client client, ZalcanoPlugin zalcanoPlugin)
	{
		this.client = client;
		this.zalcanoPlugin = zalcanoPlugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		List<GraphicsObject> rocks = zalcanoPlugin.getRocks();
		if (!rocks.isEmpty())
		{
			rocks.removeIf(GraphicsObject::finished);

			for (GraphicsObject graphicsObject : rocks)
			{
				final Player localPlayer = client.getLocalPlayer();
				final LocalPoint graphicsObjectLocation = graphicsObject.getLocation();
				final Polygon polygon = Perspective.getCanvasTilePoly(client, graphicsObjectLocation);

				if (polygon != null)
				{
					OverlayUtil.renderPolygon(graphics, polygon, localPlayer.getLocalLocation().equals(graphicsObjectLocation) ? Color.RED : Color.ORANGE);
				}
			}
		}

		LocalPoint targetedGlowingRock = zalcanoPlugin.getTargetedGlowingRock();
		if (targetedGlowingRock != null && client.getGameCycle() < zalcanoPlugin.getTargetedGlowingRockEndCycle())
		{
			final Polygon polygon = Perspective.getCanvasTileAreaPoly(client, targetedGlowingRock, 3);

			if (polygon != null)
			{
				OverlayUtil.renderPolygon(graphics, polygon, Color.RED);
			}
		}
		return null;
	}
}
