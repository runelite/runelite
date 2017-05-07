/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.zulrah;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.zulrah.patterns.ZulrahPattern;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

public class TileOverlay extends Overlay
{
	private final Zulrah plugin;
	private final Client client = RuneLite.getClient();

	public TileOverlay(Zulrah plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ZulrahPattern pattern;
		Point startLocationWorld;
		int stage;

		synchronized (plugin)
		{
			Fight fight = plugin.getFight();

			if (client.getGameState() != GameState.LOGGED_IN || fight == null)
			{
				return null;
			}

			pattern = fight.getPattern();
			if (pattern == null)
			{
				return null;
			}

			startLocationWorld = fight.getStartLocationWorld();
			stage = fight.getStage();
		}

		ZulrahInstance current = pattern.get(stage);
		if (current == null)
		{
			return null;
		}

		renderTileOverlay(graphics, current.getStandLoc(startLocationWorld), Color.GREEN); // Maybe change this to getZulrahColor too? It is current, might be pretty obvious.
		renderTileOverlay(graphics, current.getZulrahLoc(startLocationWorld), current.getZulrahColor());

		ZulrahInstance next = pattern.get(stage + 1);
		if (next == null)
		{
			return null;
		}

		String str;

		if (next.isJad())
		{
			str = "Next is JAD: " + next.getType();
		}
		else
		{
			str = "Next: " + next.getType();
		}

		Point location = next.getZulrahLoc(startLocationWorld);
		location = Perspective.worldToLocal(client, location);
		location = Perspective.getCanvasTextLocation(client, graphics, location, str, 0);

		if (location != null)
		{
			graphics.setColor(Color.WHITE);
			graphics.drawString(str, location.getX(), location.getY());
		}

		renderTileOverlay(graphics, next.getStandLoc(startLocationWorld), next.getZulrahColor(true));
		renderTileOverlay(graphics, next.getZulrahLoc(startLocationWorld), next.getZulrahColor(true));

		return null;
	}

	private void renderTileOverlay(Graphics2D graphics, Point tile, Color outlineColor)
	{
		Point localTile = Perspective.worldToLocal(client, tile);

		//to make the centre of the tile on the point, rather than the tile the point resides in
		localTile = new Point(localTile.getX() + Perspective.LOCAL_TILE_SIZE / 2, localTile.getY() + Perspective.LOCAL_TILE_SIZE / 2);
		
		Polygon poly = Perspective.getCanvasTilePoly(client, localTile);
		if (poly != null)
		{
			graphics.setColor(outlineColor);
			graphics.setStroke(new BasicStroke(2));
			graphics.drawPolygon(poly);
			graphics.setColor(new Color(0, 0, 0, 50));
			graphics.fillPolygon(poly);
		}
	}

}
