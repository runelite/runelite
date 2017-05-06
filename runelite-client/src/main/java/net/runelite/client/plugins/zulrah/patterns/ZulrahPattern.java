/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.zulrah.patterns;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.plugins.zulrah.StandLocation;
import net.runelite.client.plugins.zulrah.ZulrahInstance;
import net.runelite.client.plugins.zulrah.ZulrahLocation;
import net.runelite.client.plugins.zulrah.ZulrahType;

public abstract class ZulrahPattern implements ZulrahPatternPaintListener
{
	private final List<ZulrahInstance> pattern = new ArrayList<>();

	protected final void add(ZulrahLocation loc, ZulrahType type, StandLocation standLoc)
	{
		add(loc, type, standLoc, false);
	}

	protected final void addJad(ZulrahLocation loc, ZulrahType type, StandLocation standLoc)
	{
		add(loc, type, standLoc, true);
	}

	private void add(ZulrahLocation loc, ZulrahType type, StandLocation standLoc, boolean jad)
	{
		pattern.add(new ZulrahInstance(loc, type, jad, standLoc));
	}

	public ZulrahInstance get(int index)
	{
		if (index >= pattern.size())
		{
			return null;
		}

		return pattern.get(index);
	}

	public boolean accept(int index, ZulrahInstance instance)
	{
		ZulrahInstance patternInstance = get(index);
		return patternInstance != null && patternInstance.equals(instance);
	}

	public boolean canReset(int index)
	{
		return index >= pattern.size();
	}

	@Override
	public void render(Client client, Graphics2D graphics, Point startTile, int index)
	{
		ZulrahInstance current = get(index);
		if (current == null)
		{
			return;
		}
		graphics.setColor(Color.WHITE);
		graphics.drawString("startTile: " + startTile, 270, 200);
		graphics.drawString("current: " + current, 200, 215);

		renderTileOverlay(client, graphics, current.getStandLoc(startTile), Color.GREEN);

		Point zulrah = current.getZulrahLoc(startTile);
		ZulrahInstance next = get(index + 1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("next: " + next, 200, 230);
		String c = "c: " + current.getType() + " JAD: " + current.isJad();
		zulrah = Perspective.worldToLocal(client, zulrah);
		zulrah = Perspective.getCanvasTextLocation(client, graphics, zulrah, c, 0);
		if (zulrah == null)
		{
			return;
		}
		graphics.drawString(c, zulrah.getX(), zulrah.getY());
		if (next != null)
		{
			zulrah = next.getZulrahLoc(startTile);
			c = "n: " + next.getType() + " JAD: " + next.isJad();
			zulrah = Perspective.worldToLocal(client, zulrah);
			zulrah = Perspective.getCanvasTextLocation(client, graphics, zulrah, c, 0);
			if (zulrah == null)
			{
				return;
			}
			if (next.getLoc().equals(current.getLoc()))
			{
				zulrah = new Point(zulrah.getX(), zulrah.getY() + 15);
			}
			graphics.drawString(c, zulrah.getX(), zulrah.getY());

			renderTileOverlay(client, graphics, next.getStandLoc(startTile), new Color(255, 0, 0, 150));

		}
		graphics.setColor(Color.WHITE);
	}

	private void renderTileOverlay(Client client, Graphics2D graphics, Point tile, Color color)
	{

		Point adjusted = Perspective.worldToLocal(client, tile);
		//+65 to make the centre of the tile on the point, rather than the tile the point resides in
		adjusted = new Point(adjusted.getX() + 65, adjusted.getY() + 65);
		Polygon poly = Perspective.getCanvasTilePoly(client, adjusted);
		if (poly != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.drawPolygon(poly);
			graphics.setColor(new Color(0, 0, 0, 50));
			graphics.fillPolygon(poly);
		}
	}
}
