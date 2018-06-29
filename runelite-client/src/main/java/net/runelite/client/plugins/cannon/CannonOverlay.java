/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.cannon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import static net.runelite.api.Perspective.LOCAL_TILE_SIZE;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.TextComponent;

class CannonOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2500;

	private final Client client;
	private final CannonConfig config;
	private final CannonPlugin plugin;
	private final TextComponent textComponent = new TextComponent();

	@Inject
	CannonOverlay(Client client, CannonConfig config, CannonPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isCannonPlaced() || plugin.getCannonPosition() == null)
		{
			return null;
		}

		LocalPoint cannonPoint = LocalPoint.fromWorld(client, plugin.getCannonPosition());

		if (cannonPoint == null)
		{
			return null;
		}

		LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();

		if (localLocation.distanceTo(cannonPoint) <= MAX_DISTANCE)
		{
			Point cannonLoc = Perspective.getCanvasTextLocation(client,
				graphics,
				cannonPoint,
				String.valueOf(plugin.getCballsLeft()), 150);

			if (cannonLoc != null)
			{
				textComponent.setText(String.valueOf(plugin.getCballsLeft()));
				textComponent.setPosition(new java.awt.Point(cannonLoc.getX(), cannonLoc.getY()));
				textComponent.setColor(plugin.getStateColor());
				textComponent.render(graphics);
			}

			if (config.showDoubleHitSpot())
			{
				Color color = config.highlightDoubleHitColor();
				drawDoubleHitSpots(graphics, cannonPoint, color);
			}
		}

		return null;
	}


	/**
	 * Draw the double hit spots on a 6 by 6 grid around the cannon
	 * @param startTile The position of the cannon
	 */
	private void drawDoubleHitSpots(Graphics2D graphics, LocalPoint startTile, Color color)
	{
		for (int x = -3; x <= 3; x++)
		{
			for (int y = -3; y <= 3; y++)
			{
				if (y != 1 && x != 1 && y != -1 && x != -1)
				{
					continue;
				}

				//Ignore center square
				if (y >= -1 && y <= 1 && x >= -1 && x <= 1)
				{
					continue;
				}

				int xPos = startTile.getX() - (x * LOCAL_TILE_SIZE);
				int yPos = startTile.getY() - (y * LOCAL_TILE_SIZE);

				LocalPoint marker = new LocalPoint(xPos, yPos);
				Polygon poly = Perspective.getCanvasTilePoly(client, marker);

				if (poly == null)
				{
					continue;
				}

				OverlayUtil.renderPolygon(graphics, poly, color);
			}
		}
	}
}