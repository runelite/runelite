/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.grotesqueguardians;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.TextComponent;

public class GrotesqueGuardiansTextOverlay extends Overlay
{
	private final Client client;
	private final GrotesqueGuardiansPlugin plugin;

	@Inject
	private GrotesqueGuardiansTextOverlay(Client client, GrotesqueGuardiansPlugin plugin, SpriteManager spriteManager)
	{
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
	}

	public Dimension render(Graphics2D graphics)
	{
		if ((plugin.isInGargs()) && (plugin.isNeedingToRun()))
		{
			if ((plugin.getDusk() != null) && (plugin.getDusk().getLocalLocation() != null))
			{
				TextComponent textComponent = new TextComponent();
				LocalPoint duskPoint;

				duskPoint = new LocalPoint(plugin.getDusk().getLocalLocation().getX() + 128 * (plugin.getDusk().getTransformedDefinition().getSize() - 1) / 2, plugin.getDusk().getLocalLocation().getY() + 128 * (plugin.getDusk().getTransformedDefinition().getSize() - 1) / 2);
				net.runelite.api.Point duskLoc = Perspective.getCanvasTextLocation(client, graphics, duskPoint, "RUN AWAY", 500);
				if (duskLoc != null)
				{
					textComponent.setText("RUN AWAY");
					textComponent.setPosition(new java.awt.Point(duskLoc.getX(), duskLoc.getY()));
					textComponent.setColor(Color.red);
					textComponent.render(graphics);
				}
			}
		}
		return null;
	}
}
