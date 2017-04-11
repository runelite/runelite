/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
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
package net.runelite.client.plugins.devtools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

public class DevToolsOverlay extends Overlay
{

	private static final Client client = RuneLite.getClient();

	public DevToolsOverlay()
	{
		super(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		NPC[] npcs = client.getNpcs();
		if (npcs != null && (npcs.length - 1) > 0)
		{
			for (NPC npc : npcs)
			{
				if (npc != null)
				{
					String text = npc.getName() + " (A: " + npc.getAnimation() + ")";
					if (npc.getCombatLevel() > 1)
					{
						render(graphics, npc, text, new Color(230, 74, 25));
					}
					else
					{
						render(graphics, npc, text, Color.ORANGE);
					}
				}
			}
		}

		Player[] players = client.getPlayers();
		if (players != null && (players.length - 1) > 0)
		{
			for (Player p : players)
			{
				if (p != null)
				{
					if (!p.getName().equals(client.getLocalPlayer().getName()))
					{
						String text = p.getName() + " (A: " + p.getAnimation() + ")";
						render(graphics, p, text, Color.BLUE);
					}
				}
			}
		}

		Player local = client.getLocalPlayer();
		String text = local.getName() + " (A: " + local.getAnimation() + ")";
		render(graphics, local, text, Color.CYAN);

		return null;
	}

	private void render(Graphics2D graphics, Actor actor, String text, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly == null)
		{
			return;
		}

		Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getModelHeight());

		graphics.setColor(color);
		graphics.setStroke(new BasicStroke(2));
		graphics.drawPolygon(poly);
		graphics.setColor(new Color(0, 0, 0, 50));
		graphics.fillPolygon(poly);

		if (textLocation != null)
		{
			graphics.setColor(Color.WHITE);
			graphics.drawString(text, textLocation.getX(), textLocation.getY());
		}
	}

}
