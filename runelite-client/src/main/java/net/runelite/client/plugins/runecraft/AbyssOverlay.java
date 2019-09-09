/*
 * Copyright (c) 2016-2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.runecraft;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import com.google.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.DecorativeObject;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

class AbyssOverlay extends Overlay
{
	private final Client client;
	private final RunecraftPlugin plugin;
	private final RunecraftConfig config;

	@Inject
	AbyssOverlay(Client client, RunecraftPlugin plugin, RunecraftConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showRifts() && config.showClickBox())
		{
			for (DecorativeObject object : plugin.getAbyssObjects())
			{
				renderRift(graphics, object);
			}
		}

		if (config.hightlightDarkMage())
		{
			highlightDarkMage(graphics);
		}

		return null;
	}

	private void highlightDarkMage(Graphics2D graphics)
	{
		if (!plugin.isDegradedPouchInInventory())
		{
			return;
		}

		NPC darkMage = plugin.getDarkMage();
		if (darkMage == null)
		{
			return;
		}

		Polygon tilePoly = darkMage.getCanvasTilePoly();
		if (tilePoly == null)
		{
			return;
		}

		OverlayUtil.renderPolygon(graphics, tilePoly, Color.green);
	}

	private void renderRift(Graphics2D graphics, DecorativeObject object)
	{
		AbyssRifts rift = AbyssRifts.getRift(object.getId());
		if (rift == null || !plugin.getRifts().contains(rift))
		{
			return;
		}

		Point mousePosition = client.getMouseCanvasPosition();
		Shape objectClickbox = object.getClickbox();
		if (objectClickbox != null)
		{
			if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
			{
				graphics.setColor(Color.MAGENTA.darker());
			}
			else
			{
				graphics.setColor(Color.MAGENTA);
			}
			graphics.draw(objectClickbox);
			graphics.setColor(new Color(255, 0, 255, 20));
			graphics.fill(objectClickbox);
		}
	}
}
