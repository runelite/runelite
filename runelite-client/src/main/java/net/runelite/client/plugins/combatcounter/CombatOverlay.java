/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.combatcounter;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

class CombatOverlay extends Overlay
{

	private final Client client;
	private final CombatCounter plugin;
	private final PanelComponent panelComponent = new PanelComponent();
	private final CombatCounterConfig config;
	private HashMap<String, Long> ticks = new HashMap<>();

	@Inject
	public CombatOverlay(Client client, CombatCounter plugin, CombatCounterConfig config)
	{
		super(plugin);

		setPosition(OverlayPosition.DYNAMIC);
		setPosition(OverlayPosition.DETACHED);
		setPosition(OverlayPosition.BOTTOM_RIGHT);

		this.config = config;
		this.client = client;
		this.plugin = plugin;

		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Tick Counter"));
	}



	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.showTickCounter())
		{
			panelComponent.getChildren().clear();

			Player local = client.getLocalPlayer();
			if (local == null || local.getName() == null)
				return null;
			panelComponent.setBackgroundColor(config.bgColor());
			panelComponent.getChildren().add(TitleComponent.builder().text("Tick Counter").color(config.titleColor()).build());
			int total = 0;
			if (plugin.getCounter().isEmpty())
			{
				panelComponent.getChildren().add(LineComponent.builder().left(local.getName()).right("0").build());
			}
			else
			{
				Map<String, Long> map = this.plugin.getCounter();
				if (map == null)
					return null;

				for (String name : map.keySet())
				{
					if (client.getLocalPlayer().getName().contains(name))
					{
						panelComponent.getChildren().add(1, LineComponent.builder().left(name).right(Long.toString(map.get(name))).leftColor(config.selfColor()).rightColor(config.selfColor()).build());
					}
					else
					{
						panelComponent.getChildren().add(1, LineComponent.builder().left(name).right(Long.toString(map.get(name))).leftColor(config.otherColor()).rightColor(config.otherColor()).build());
					}
					total += map.get(name);
				}

				if (!map.containsKey(local.getName()))
				{
					panelComponent.getChildren().add(LineComponent.builder().left(local.getName()).right("0").leftColor(config.selfColor()).rightColor(config.selfColor()).build());
				}
			}
			panelComponent.getChildren().add(LineComponent.builder().left("Total").leftColor(config.totalColor()).rightColor(config.totalColor()).right(String.valueOf(total)).build());
			return panelComponent.render(graphics);
		}
		else
		{
			return null;
		}
	}
}