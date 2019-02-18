/*
 * Copyright (c) 2018, Lucas <https://github.com/Lucwousin>
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
package net.runelite.client.plugins.hunter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class HunterOverlay extends Overlay
{
	private final Client client;
	private final HunterPlugin plugin;
	private final HunterConfig config;
	private final XpTrackerService xpTrackerService;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	public HunterOverlay(Client client, HunterPlugin plugin, HunterConfig config, XpTrackerService xpTrackerService)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.xpTrackerService = xpTrackerService;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Hunter overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showHunterStats() || plugin.getSession().getLastHunterCatch() == null)
		{
			return null;
		}

		int trapCount = plugin.getTraps().keySet().size();
		panelComponent.getChildren().clear();
		if (trapCount < 1)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("No traps active!")
				.color(Color.RED)
				.build());
		}
		else if (trapCount == 1)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("1 Trap active.")
				.color(Color.YELLOW)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(trapCount + " Traps active.")
				.color(Color.GREEN)
				.build());
		}

		int actions = xpTrackerService.getActions(Skill.HUNTER);
		if (actions > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Caught: ")
				.right(Integer.toString(actions))
				.build());

			if (actions > 2)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Caught/hr:")
					.right(Integer.toString(xpTrackerService.getActionsHr(Skill.HUNTER)))
					.build());
			}
		}

		return panelComponent.render(graphics);
	}
}
