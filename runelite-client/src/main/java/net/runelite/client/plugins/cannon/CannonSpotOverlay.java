/*
 * Copyright (c) 2018, Seth <https://github.com/sethtroll>
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
import java.awt.image.BufferedImage;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import static net.runelite.client.plugins.cannon.CannonPlugin.MAX_OVERLAY_DISTANCE;

class CannonSpotOverlay extends Overlay
{
	private final Client client;
	private final CannonPlugin plugin;
	private final CannonConfig config;

	@Inject
	private ItemManager itemManager;

	@Setter(AccessLevel.PACKAGE)
	private boolean hidden;

	@Inject
	CannonSpotOverlay(Client client, CannonPlugin plugin, CannonConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		List<WorldPoint> spotPoints = plugin.getSpotPoints();

		if (hidden || spotPoints.isEmpty() || !config.showCannonSpots() || plugin.isCannonPlaced())
		{
			return null;
		}

		for (WorldPoint spot : spotPoints)
		{
			if (spot.getPlane() != client.getPlane())
			{
				continue;
			}

			LocalPoint spotPoint = LocalPoint.fromWorld(client, spot);
			LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();

			if (spotPoint != null && localLocation.distanceTo(spotPoint) <= MAX_OVERLAY_DISTANCE)
			{
				renderCannonSpot(graphics, client, spotPoint, itemManager.getImage(ItemID.MCANNONBALL), Color.RED);
			}
		}

		return null;
	}

	private void renderCannonSpot(Graphics2D graphics, Client client, LocalPoint point, BufferedImage image, Color color)
	{
		//Render tile
		Polygon poly = Perspective.getCanvasTilePoly(client, point);

		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, color);
		}

		//Render icon
		Point imageLoc = Perspective.getCanvasImageLocation(client, point, image, 0);

		if (imageLoc != null)
		{
			OverlayUtil.renderImageLocation(graphics, imageLoc, image);
		}
	}
}
