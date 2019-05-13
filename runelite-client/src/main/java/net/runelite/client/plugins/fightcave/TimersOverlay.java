/*
 * Copyright (c) 2019, Ganom <https://github.com/Ganom>
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

package net.runelite.client.plugins.fightcave;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class TimersOverlay extends Overlay
{
	private FightCavePlugin plugin;
	private Client client;
	private Color tickcolor = new Color(255, 255, 255, 255);

	@Inject
	TimersOverlay(FightCavePlugin plugin, Client client)
	{
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGHEST);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		for (NPCContainer npc : plugin.getDrainers().values())
		{
			renderNpcOverlay(graphics, npc.getNpc(), new Color(255, 0, 0, 255), 2, 255, 20);
			String str = "drainer";
			Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, str, 0);
			renderTextLocation(graphics, str, 12, Font.BOLD, new Color(255, 255, 255, 255), canvasPoint);
		}

		for (NPCContainer npc : plugin.getIgnore().values())
		{
			renderNpcOverlay(graphics, npc.getNpc(), new Color(0, 0, 0, 255), 2, 50, 5);
			String str = "ignore";
			Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, str, 0);
			renderTextLocation(graphics, str, 10, Font.BOLD, new Color(255, 255, 255, 255), canvasPoint);
		}

		for (NPCContainer npc : plugin.getRangers().values())
		{
			renderNpcOverlay(graphics, npc.getNpc(), new Color(0, 255, 0, 255), 2, 100, 10);
			final int ticksLeft = npc.getTicksUntilAttack();
			if (ticksLeft > 0)
			{
				if (ticksLeft == 1)
				{
					tickcolor = new Color(0, 255, 0, 255);
				}
				else
				{

					tickcolor = new Color(255, 255, 255, 255);
				}
				final String ticksLeftStr = String.valueOf(ticksLeft);
				Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, ticksLeftStr, 0);
				renderTextLocation(graphics, ticksLeftStr, 32, Font.BOLD, tickcolor, canvasPoint);
			}
		}

		for (NPCContainer npc : plugin.getMagers().values())
		{
			renderNpcOverlay(graphics, npc.getNpc(), new Color(0, 255, 255, 255), 2, 100, 10);
			final int ticksLeft = npc.getTicksUntilAttack();
			if (ticksLeft > 0)
			{
				if (ticksLeft == 1)
				{
					tickcolor = new Color(0, 255, 255, 255);
				}
				else
				{

					tickcolor = new Color(255, 255, 255, 255);
				}
				final String ticksLeftStr = String.valueOf(ticksLeft);
				Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, ticksLeftStr, 0);
				renderTextLocation(graphics, ticksLeftStr, 32, Font.BOLD, tickcolor, canvasPoint);
			}
		}

		for (NPCContainer npc : plugin.getMeleers().values())
		{
			renderNpcOverlay(graphics, npc.getNpc(), new Color(255, 0, 0, 255), 2, 100, 10);
			final int ticksLeft = npc.getTicksUntilAttack();
			if (ticksLeft > 0)
			{
				if (ticksLeft == 1)
				{
					tickcolor = new Color(255, 0, 0, 255);
				}
				else
				{

					tickcolor = new Color(255, 255, 255, 255);
				}
				final String ticksLeftStr = String.valueOf(ticksLeft);
				Point canvasPoint = npc.getNpc().getCanvasTextLocation(graphics, ticksLeftStr, 0);
				renderTextLocation(graphics, ticksLeftStr, 32, Font.BOLD, tickcolor, canvasPoint);
			}
		}

		return null;
	}

	private void renderNpcOverlay(Graphics2D graphics, NPC actor, Color color, int outlineWidth, int outlineAlpha, int fillAlpha)
	{
		int size = 1;
		NPCComposition composition = actor.getTransformedComposition();
		if (composition != null)
		{
			size = composition.getSize();
		}
		LocalPoint lp = actor.getLocalLocation();
		Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size);

		if (tilePoly != null)
		{
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
			graphics.setStroke(new BasicStroke(outlineWidth));
			graphics.draw(tilePoly);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
			graphics.fill(tilePoly);
		}
	}

	private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
	{
		graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(
				canvasPoint.getX(),
				canvasPoint.getY());
			final Point canvasCenterPoint_shadow = new Point(
				canvasPoint.getX() + 1,
				canvasPoint.getY() + 1);
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}
}
