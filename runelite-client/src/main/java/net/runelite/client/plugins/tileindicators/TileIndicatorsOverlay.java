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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ColorUtil;

public class TileIndicatorsOverlay extends Overlay
{
	private final Client client;
	private final TileIndicatorsConfig config;

	@Setter
	private WorldPoint lastPlayerPosition;
	private int lastTickPlayerMoved;
	private long lastTimePlayerStoppedMoving;

	@Inject
	private TileIndicatorsOverlay(Client client, TileIndicatorsConfig config)
	{
		this.client = client;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(PRIORITY_MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.highlightHoveredTile())
		{
			WorldView wv = client.getLocalPlayer().getWorldView();
			Tile tile = wv.getSelectedSceneTile();
			// If we have tile "selected" render it
			if (tile != null)
			{
				renderTile(graphics, tile.getLocalLocation(), config.highlightHoveredColor(), config.hoveredTileBorderWidth(), config.hoveredTileFillColor());
			}
		}

		if (config.highlightDestinationTile())
		{
			renderTile(graphics, client.getLocalDestinationLocation(), config.highlightDestinationColor(), config.destinationTileBorderWidth(), config.destinationTileFillColor());
		}

		if (config.highlightCurrentTile())
		{
			final WorldPoint playerPos = client.getLocalPlayer().getWorldLocation();

			if (lastPlayerPosition != null)
			{
				if (!playerPos.equals(lastPlayerPosition))
				{
					lastTickPlayerMoved = client.getTickCount();
				}
				else if (lastTickPlayerMoved + 1 == client.getTickCount())
				{
					lastTimePlayerStoppedMoving = System.nanoTime();
				}
			}

			lastPlayerPosition = playerPos;

			final LocalPoint playerPosLocal = LocalPoint.fromWorld(client, lastPlayerPosition);
			if (playerPosLocal == null)
			{
				return null;
			}

			Color color = config.highlightCurrentColor();
			Color fillColor = config.currentTileFillColor();
			// When not fading out the current tile, or when it has been 1 game tick or less since the player last
			// moved, draw the tile at full opacity. When using fadeout, drawing the indicator at full opacity for 1
			// game tick prevents it from fading out when moving on consecutive ticks.
			if (!config.trueTileFadeout() || client.getTickCount() - lastTickPlayerMoved <= 1)
			{
				renderTile(graphics, playerPosLocal, color, config.currentTileBorderWidth(), fillColor);
			}
			else
			{
				// It is 1 game tick after the player has stopped moving, so fade out the tile.
				long timeSinceLastMove = (System.nanoTime() - lastTimePlayerStoppedMoving) / 1_000_000;
				// The fadeout does not begin for 1 game tick, so subtract that.
				int fadeoutTime = config.trueTileFadeoutTime() - Constants.GAME_TICK_LENGTH;
				if (fadeoutTime != 0 && timeSinceLastMove < fadeoutTime)
				{
					double opacity = 1.0d - Math.pow(timeSinceLastMove / (double) fadeoutTime, 2);
					renderTile(graphics, playerPosLocal, ColorUtil.colorWithAlpha(color, (int) (opacity * color.getAlpha())), config.currentTileBorderWidth(), ColorUtil.colorWithAlpha(fillColor, (int) (opacity * fillColor.getAlpha())));
				}
			}
		}

		return null;
	}

	private void renderTile(final Graphics2D graphics, final LocalPoint dest, final Color color, final double borderWidth, final Color fillColor)
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

		OverlayUtil.renderPolygon(graphics, poly, color, fillColor, new BasicStroke((float) borderWidth));
	}
}
