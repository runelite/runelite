/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.tileindicators;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class TileIndicatorsOverlay extends Overlay
{
	private final Client client;
	private final TileIndicatorsPlugin plugin;

	@Inject
	private TileIndicatorsOverlay(final Client client, final TileIndicatorsPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isHighlightHoveredTile() &&
			// If we have tile "selected" render it
			client.getSelectedSceneTile() != null)
		{
			if (plugin.isThinHoveredTile())
			{
				renderTileThin(graphics, client.getSelectedSceneTile().getLocalLocation(), plugin.getHighlightHoveredColor());
			}
			else
			{
				renderTile(graphics, client.getSelectedSceneTile().getLocalLocation(), plugin.getHighlightHoveredColor());
			}
		}

		if (plugin.isHighlightDestinationTile())
		{
			if (plugin.isThinDestinationTile())
			{
				renderTileThin(graphics, client.getLocalDestinationLocation(), plugin.getHighlightDestinationColor());
			}
			else
			{
				renderTile(graphics, client.getLocalDestinationLocation(), plugin.getHighlightDestinationColor());
			}
		}

		if (plugin.isHighlightCurrentTile())
		{
			final WorldPoint playerPos = client.getLocalPlayer().getWorldLocation();
			if (playerPos == null)
			{
				return null;
			}

			final LocalPoint playerPosLocal = LocalPoint.fromWorld(client, client.getLocalPlayer().getWorldLocation());
			if (playerPosLocal == null)
			{
				return null;
			}

			if (plugin.isThinCurrentTile())
			{
				renderTileThin(graphics, playerPosLocal, plugin.getHighlightCurrentColor());
			}
			else
			{
				renderTile(graphics, playerPosLocal, plugin.getHighlightCurrentColor());
			}
		}

		return null;
	}

	private void renderTile(final Graphics2D graphics, final LocalPoint dest, final Color color)
	{
		if (dest == null)
		{
			return;
		}

		final Polygon poly = Perspective.getCanvasTilePoly(client, dest);

		if (poly == null)
		{
			return;
		}

		OverlayUtil.renderPolygon(graphics, poly, color);
	}

	private void renderTileThin(final Graphics2D graphics, final LocalPoint dest, final Color color)
	{
		if (dest == null)
		{
			return;
		}

		final Polygon poly = Perspective.getCanvasTilePoly(client, dest);

		if (poly == null)
		{
			return;
		}

		OverlayUtil.renderPolygonThin(graphics, poly, color);
	}
}
