/*
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Shaun Dreclin <shaundreclin@gmail.com>
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
package net.runelite.client.plugins.slayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class TargetClickboxOverlay extends Overlay
{
	private final SlayerConfig config;
	private final SlayerPlugin plugin;
	private final Client client;

	@Inject
	TargetClickboxOverlay(SlayerConfig config, SlayerPlugin plugin, Client client)
	{
		this.config = config;
		this.plugin = plugin;
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.highlightStyle() == RenderStyle.OFF)
		{
			return null;
		}

		List<NPC> targets = plugin.getHighlightedTargets();
		Color color = config.getTargetColor();

		if (config.highlightStyle() == RenderStyle.TILE)
		{
			for (NPC target : targets)
			{
				renderSlayerTargetTiles(graphics, target, color);
			}
		}
		else
		{
			for (NPC target : targets)
			{
				renderSlayerTargetHull(graphics, target, color);
			}
		}
		return null;
	}
	private void renderSlayerTargetTiles(Graphics2D graphics, NPC slayerTarget, Color highlightColor)
	{
		int slayerTargetSize = 1;
		NPCComposition slayerTargetComposition = slayerTarget.getTransformedComposition();

		if ( slayerTargetComposition != null)
		{
			slayerTargetSize = slayerTargetComposition.getSize();
		}

		LocalPoint slayerTargetPoint = slayerTarget.getLocalLocation();
		Polygon tilePolygon = Perspective.getCanvasTileAreaPoly(client, slayerTargetPoint, slayerTargetSize);

		if (tilePolygon != null)
		{
			graphics.setColor(highlightColor);
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(tilePolygon);
			Color tileFill = new Color(highlightColor.getRed(), highlightColor.getGreen(), highlightColor.getBlue(), 20);
			graphics.setColor(tileFill);
			graphics.fill(tilePolygon);
		}
	}

	private void renderSlayerTargetHull(Graphics2D graphics, NPC slayerTarget, Color highlightColor)
	{
		Polygon slayerTargetClickbox = slayerTarget.getConvexHull();

		if (slayerTargetClickbox != null)
		{
			graphics.setColor(highlightColor);
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(slayerTargetClickbox);
			Color hullFill = new Color(highlightColor.getRed(), highlightColor.getGreen(), highlightColor.getBlue(), 20);
			graphics.setColor(hullFill);
			graphics.fill(slayerTargetClickbox);
		}
	}
}
