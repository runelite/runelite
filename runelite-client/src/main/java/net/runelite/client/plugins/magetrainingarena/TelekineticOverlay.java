/*
 * Copyright (c) 2018, Toocanzs <https://github.com/Toocanzs>
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
package net.runelite.client.plugins.magetrainingarena;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class TelekineticOverlay extends Overlay
{
	private final Client client;
	private final MageTrainingArenaPlugin plugin;

	private final Color currentTargetColor = new Color(255, 223, 0, 50);
	private final Color nextTargetColor = new Color(160, 232, 175, 255);

	private final Color guardianTargetColor = currentTargetColor.darker();
	private final Color guardianNextTargetColor = nextTargetColor.darker();

	TelekineticOverlay(Client client, MageTrainingArenaPlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.LOW);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Tile[] playerTargetTiles = plugin.getPlayerTargetTiles();
		final Tile[] guardianTargetTiles = plugin.getGuardianTargetTiles();

		if (playerTargetTiles[0] != null)
		{
			renderTile(graphics, playerTargetTiles[0].getLocalLocation(), currentTargetColor, true);
		}
		if (playerTargetTiles[1] != null)
		{
			renderTile(graphics, playerTargetTiles[1].getLocalLocation(), nextTargetColor, false);
		}

		if (guardianTargetTiles[0] != null)
		{
			renderTile(graphics, guardianTargetTiles[0].getLocalLocation(), guardianTargetColor, true);
		}
		if (guardianTargetTiles[1] != null)
		{
			renderTile(graphics, guardianTargetTiles[1].getLocalLocation(), guardianNextTargetColor, false);
		}

		return null;
	}

	private void renderTile(Graphics2D graphics, LocalPoint localPoint, Color color, boolean fill)
	{
		Polygon poly = Perspective.getCanvasTilePoly(client, localPoint);
		if (poly == null)
		{
			return;
		}

		graphics.setColor(color);
		if (fill)
		{
			graphics.fillPolygon(poly);
		}

		graphics.drawPolygon(poly);
	}

}
