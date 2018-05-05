/*
 * Copyright (c) 2018, Not Noob
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
package net.runelite.client.plugins.lightbox;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class LightBoxSolverOverlay extends Overlay
{
	private final Client client;
	private final LightBoxSolverPlugin plugin;

	@Inject
	public LightBoxSolverOverlay(Client client, LightBoxSolverPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		this.plugin = plugin;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getWidget(322, 3) != null)
		{
			if (!plugin.isSolving())
			{
				graphics.setColor(Color.ORANGE);
				Rectangle childBounds = client.getWidget(322, plugin.getCount() + 8).getBounds();
				graphics.draw(childBounds);
			}
			else if (plugin.getCount() > 0)
			{
				if (plugin.getSolution() != null)
				{
					graphics.setColor(Color.ORANGE);
					Rectangle childBounds = client.getWidget(322, plugin.getSolution()[plugin.getCount() - 1] + 8).getBounds();
					graphics.draw(childBounds);
				}
				else
				{
					graphics.setColor(Color.RED);
					FontMetrics metrics = graphics.getFontMetrics();
					String text = "Reopen the light box and try again";
					graphics.drawString( text,
							(int) (client.getWidget(322, 2).getBounds().getX() + (int) client.getWidget(322, 2).getBounds().getWidth() / 2 - metrics.stringWidth(text) / 2),
							(int) client.getWidget(322, 2).getBounds().getY() + metrics.getHeight());
				}
			}
		}
		return null;
	}
}
