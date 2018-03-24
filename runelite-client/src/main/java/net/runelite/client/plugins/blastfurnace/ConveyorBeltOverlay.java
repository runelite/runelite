/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.blastfurnace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

class ConveyorBeltOverlay extends Overlay
{
	private static final int MAX_DISTANCE = 2350;

	private final Client client;
	private final BlastFurnacePlugin plugin;
	private final BlastFurnaceConfig config;

	@Inject
	ConveyorBeltOverlay(Client client, BlastFurnacePlugin plugin, BlastFurnaceConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showConveyorBelt() || plugin.getConveyorBelt() == null)
		{
			return null;
		}

		LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();
		Point mousePosition = client.getMouseCanvasPosition();

		GameObject object = plugin.getConveyorBelt();

		LocalPoint location = object.getLocalLocation();
		if (localLocation.distanceTo(location) <= MAX_DISTANCE)
		{
			Area objectClickbox = object.getClickbox();
			if (objectClickbox != null)
			{
				if (objectClickbox.contains(mousePosition.getX(), mousePosition.getY()))
				{
					graphics.setColor(Color.RED.darker());
				}
				else
				{
					graphics.setColor(Color.RED);
				}
				graphics.draw(objectClickbox);
				graphics.setColor(new Color(0xFF, 0, 0, 20));
				graphics.fill(objectClickbox);
			}
		}
		return null;
	}
}
