/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package net.runelite.client.plugins.world;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import java.util.EnumSet;
import lombok.extern.slf4j.Slf4j;

import net.runelite.api.Client;
import net.runelite.api.WorldType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Slf4j
class WorldOverlay extends Overlay
{
	private final WorldConfig config;
	private final Client client;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private WorldOverlay(WorldConfig config, Client client)
	{
		setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
		this.config = config;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		boolean showWorld = config.showWorld();

		if (showWorld)
		{
			final String world = Integer.toString(client.getWorld());
			EnumSet<WorldType> currentWorldTypes = client.getWorldType();
			final Color c;


			if (currentWorldTypes.contains(WorldType.PVP))
			{
				c = Color.RED;
			}
			else if (currentWorldTypes.contains(WorldType.BOUNTY))
			{
				c = Color.ORANGE;
			}
			else
			{
				c = Color.WHITE;
			}

			panelComponent.getChildren().add(TitleComponent.builder()
				.text(world)
				.color(c)
				.build());

			panelComponent.setPreferredSize(new Dimension(
				graphics.getFontMetrics().stringWidth(world) + 10,
				5));

			return panelComponent.render(graphics);
		}

		return null;
	}
}
