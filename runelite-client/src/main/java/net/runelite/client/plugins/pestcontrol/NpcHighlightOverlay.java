/*
 * Copyright (c) 2019, Yani <yani@xenokore.com>
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
package net.runelite.client.plugins.pestcontrol;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.plugins.pestcontrol.config.NpcHighlightStyle;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

@Slf4j
@Singleton
public class NpcHighlightOverlay extends Overlay
{
	private final PestControlPlugin plugin;
	private final Client client;

	@Inject
	NpcHighlightOverlay(final PestControlPlugin plugin, final Client client)
	{
		this.plugin = plugin;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getGame() == null)
		{
			return null;
		}

		HashMap highlightedNpcList = plugin.getHighlightedNpcList();

		for (NPC npc : client.getNpcs())
		{
			if (!highlightedNpcList.containsKey(npc.getId()))
			{
				continue;
			}

			NpcHighlightContext npcHighlightContext = plugin.getHighlightedNpcList().get(npc.getId());

			String name = npcHighlightContext.isShowNpcName() ? npc.getName() : null;
			Color color = npcHighlightContext.getColor();
			NpcHighlightStyle highlightStyle = npcHighlightContext.getNpcRenderStyle();

			switch (highlightStyle)
			{
				case HULL:
				{
					renderHullOverlay(graphics, npc, color);
					break;
				}
				case TILE:
				{
					renderTileOverlay(graphics, npc, color);
					break;
				}
				case BOTH:
				{
					renderHullOverlay(graphics, npc, color);
					renderTileOverlay(graphics, npc, color);
					break;
				}
			}

			if (name != null)
			{
				renderTextOverlay(graphics, npc, name, color);
			}
		}

		return null;
	}

	private void renderTileOverlay(Graphics2D graphics, NPC npc, Color color)
	{
		Polygon polygon;
		Color fillColor;

		// Double the polygon size if it's a Brawler
		if (PestControlNpc.isBrawlerId(npc.getId()))
		{
			polygon = Perspective.getCanvasTileAreaPoly(client, npc.getLocalLocation(), 2);
			fillColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), 35);
		}
		else
		{
			polygon = npc.getCanvasTilePoly();
			fillColor = new Color(0, 0, 0, 50);
		}

		if (polygon != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.drawPolygon(polygon);
			graphics.setColor(fillColor);
			graphics.fillPolygon(polygon);
		}
	}

	private void renderHullOverlay(Graphics2D graphics, NPC npc, Color color)
	{
		Shape objectClickbox = npc.getConvexHull();
		if (objectClickbox != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(objectClickbox);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
			graphics.fill(objectClickbox);
		}
	}

	private void renderTextOverlay(Graphics2D graphics, NPC npc, String text, Color color)
	{
		Point textLocation = npc.getCanvasTextLocation(graphics, text, npc.getLogicalHeight() + 40);
		if (textLocation != null)
		{
			OverlayUtil.renderTextLocation(graphics, textLocation, text, color);
		}
	}
}
