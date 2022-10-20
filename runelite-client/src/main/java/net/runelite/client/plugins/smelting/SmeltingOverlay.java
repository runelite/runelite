/*
 * Copyright (c) 2019, Stephen <stepzhu@umich.edu>
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
package net.runelite.client.plugins.smelting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.SMITHING_CANNONBALL;
import static net.runelite.api.AnimationID.SMITHING_SMELTING;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class SmeltingOverlay extends OverlayPanel
{
	private static final int SMELT_TIMEOUT = 7;
	static final String SMELTING_RESET = "Reset";

	private final Client client;
	private final SmeltingPlugin plugin;
	private final XpTrackerService xpTrackerService;

	@Inject
	SmeltingOverlay(Client client, SmeltingPlugin plugin, XpTrackerService xpTrackerService)
	{
		super(plugin);
		this.client = client;
		this.plugin = plugin;
		this.xpTrackerService = xpTrackerService;
		setPosition(OverlayPosition.TOP_LEFT);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Smelting overlay"));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, SMELTING_RESET, "Smelting overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		SmeltingSession session = plugin.getSession();
		if (session == null)
		{
			return null;
		}

		if (isSmelting() || Duration.between(session.getLastItemSmelted(), Instant.now()).getSeconds() < SMELT_TIMEOUT)
		{
			panelComponent.getChildren().add(TitleComponent.builder()
					.text("Smelting")
					.color(Color.GREEN)
					.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
					.text("NOT smelting")
					.color(Color.RED)
					.build());
		}

		int actions = xpTrackerService.getActions(Skill.SMITHING);
		if (actions > 0)
		{
			if (plugin.getSession().getBarsSmelted() > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
						.left("Bars:")
						.right(Integer.toString(session.getBarsSmelted()))
						.build());
			}
			if (plugin.getSession().getCannonBallsSmelted() > 0)
			{
				panelComponent.getChildren().add(LineComponent.builder()
						.left("Cannonballs:")
						.right(Integer.toString(session.getCannonBallsSmelted()))
						.build());
			}
			if (actions > 2)
			{
				panelComponent.getChildren().add(LineComponent.builder()
						.left("Actions/hr:")
						.right(Integer.toString(xpTrackerService.getActionsHr(Skill.SMITHING)))
						.build());
			}
		}

		return super.render(graphics);

	}

	private boolean isSmelting()
	{
		switch (client.getLocalPlayer().getAnimation())
		{
			case SMITHING_SMELTING:
			case SMITHING_CANNONBALL:
				return true;
			default:
				return false;
		}
	}
}