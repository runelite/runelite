/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import net.runelite.api.Actor;
import net.runelite.api.Point;
import net.runelite.api.TileObject;


/**
 * Created by Kyle Fricilone on Jun 09, 2017.
 */
public class OverlayUtil
{
	public static void renderPolygon(Graphics2D graphics, Polygon poly, Color color)
	{
		graphics.setColor(color);
		graphics.setStroke(new BasicStroke(2));
		graphics.drawPolygon(poly);
		graphics.setColor(new Color(0, 0, 0, 50));
		graphics.fillPolygon(poly);
	}

	public static void rednerMinimapLocation(Graphics2D graphics, Point mini, Color color)
	{
		graphics.setColor(color);
		graphics.fillOval(mini.getX(), mini.getY(), 5, 5);
		graphics.setColor(Color.WHITE);
		graphics.setStroke(new BasicStroke(1));
		graphics.drawOval(mini.getX(), mini.getY(), 5, 5);
	}

	public static void renderTextLocation(Graphics2D graphics, Point txtLoc, String text, Color color)
	{
		int x = txtLoc.getX();
		int y = txtLoc.getY();

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 1);

		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}

	public static void renderActorOverlay(Graphics2D graphics, Actor actor, String text, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		Point minimapLocation = actor.getMinimapLocation();
		if (minimapLocation != null)
		{
			rednerMinimapLocation(graphics, minimapLocation, color);
		}

		Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getModelHeight() + 40);
		if (textLocation != null)
		{
			renderTextLocation(graphics, textLocation, text, color);
		}
	}

	public static void renderTileOverlay(Graphics2D graphics, TileObject tileObject, String text, Color color)
	{
		Polygon poly = tileObject.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		Point minimapLocation = tileObject.getMinimapLocation();
		if (minimapLocation != null)
		{
			rednerMinimapLocation(graphics, minimapLocation, color);
		}

		Point textLocation = tileObject.getCanvasTextLocation(graphics, text, 0);
		if (textLocation != null)
		{
			renderTextLocation(graphics, textLocation, text, color);
		}
	}

}
