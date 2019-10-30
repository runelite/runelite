/*
 * Copyright (c) 2019, Abiyaz C <chowdh2@cooper.edu>
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
package net.runelite.client.plugins.driftnet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import net.runelite.api.Actor;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.geometry.SimplePolygon;
import net.runelite.client.ui.overlay.Overlay;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class DriftNetOverlay extends Overlay
{
	private final DriftNetConfig config;
	private final DriftNetPlugin plugin;

	@Inject
	DriftNetOverlay(DriftNetConfig config, DriftNetPlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInDriftNetArea())
		{
			return null;
		}
		if (config.netOverlay())
		{
			renderNet(graphics);
		}
		if (config.highlightFish())
		{
			renderFishes(graphics);
		}
		return null;
	}

	static Color getColor(DriftNet net)
	{
		Color color = null;
		if (net.getDriftNet() != null)
		{
			switch (net.getNetStatus())
			{
				case FULL:
					color = Color.RED;
					break;
				case SET:
					color = Color.GREEN;
					break;
				case UNSET:
					color = Color.YELLOW;
					break;
				default:
					break;
			}
		}
		return color;
	}

	private void renderNet(Graphics2D graphics)
	{
		DriftNet[] nets = {plugin.southNet, plugin.northNet};
		for (DriftNet net : nets)
		{
			Color color = getColor(net);
			if (color != null && net.getDriftNet() != null)
			{
				renderObject(graphics, color, net.getDriftNet());
			}
		}
	}

	private void renderFishes(Graphics2D graphics)
	{
		for (Map.Entry<NPC, Long> entry : plugin.getFishes().entrySet())
		{
			Color color;
			if (entry.getValue() < 0)
			{
				color = Color.RED;
			}
			else
			{
				color = Color.GREEN;
			}
			renderActor(graphics, color, entry.getKey());
		}
	}

	private void renderObject(Graphics2D graphics, Color color, GameObject object)
	{
		SimplePolygon objectClickbox = (SimplePolygon) object.getConvexHull();
		drawPolygon(graphics, objectClickbox, color);
	}

	private void renderActor(Graphics2D graphics, Color color, Actor actor)
	{
		SimplePolygon objectClickbox = (SimplePolygon) actor.getConvexHull();
		drawPolygon(graphics, objectClickbox, color);
	}

	private void drawPolygon(Graphics2D graphics, SimplePolygon polygon, Color color)
	{
		if (polygon != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.draw(polygon);
			graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
			graphics.fill(polygon);
		}
	}
}