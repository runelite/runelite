/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
 * Copyright (c) 2018, Lasse <cronick@zytex.dk>
 * Copyright (c) 2019, ermalsh <github.com/ermalsh>
 * Copyright (c) 2019, Deadeye <github.com/DeadeyeOo>
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
package net.runelite.client.plugins.thieving;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.PICKPOCKET_FAIL_1;
import static net.runelite.api.AnimationID.PICKPOCKET_FAIL_2;
import static net.runelite.api.AnimationID.PICKPOCKET_FAIL_3;
import static net.runelite.api.AnimationID.PICKPOCKET_SUCCESS;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class ThievingOverlay extends Overlay
{
	private final Client client;
	private final ThievingPlugin plugin;
	private final ThievingConfig config;
	private final XpTrackerService xpTrackerService;
	private final InfoBoxManager infoBoxManager;
	private final ItemManager itemManager;
	private final PanelComponent panelComponent = new PanelComponent();

	private static final int STUN_DURATION = 5;
	private static final int STUN_ICON = ItemID.STARFACE;
	private static final DecimalFormat FORMAT = new DecimalFormat("#.#");

	private StunTimer stunTimer;

	private enum ThievingState
	{
		IDLE,
		THIEVING,
		STUNNED
	}

	@Inject
	private ThievingOverlay(Client client,
							ThievingPlugin plugin,
							ThievingConfig config,
							XpTrackerService xpTrackerService,
							InfoBoxManager infoBoxManager,
							ItemManager itemManager)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.xpTrackerService = xpTrackerService;
		this.infoBoxManager = infoBoxManager;
		this.itemManager = itemManager;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ThievingSession session = plugin.getSession();
		if (session == null)
		{
			return null;
		}

		// Clean up previous render
		panelComponent.setPreferredSize(new Dimension(145, 0));
		panelComponent.getChildren().clear();

		if(stunTimer != null)
		{
			if(stunTimer.isExpired())
			{
				removeStunTimer();
			}
		}

		// Build Timer
		ThievingState thievingState = getThievingState();

		if(stunTimer == null && thievingState == ThievingState.STUNNED)
		{
			addStunTimer();
		}

		//Build Panel
		switch(thievingState)
		{
            case THIEVING:
				panelComponent.getChildren().add(TitleComponent.builder()
						.text("Thieving")
						.color(Color.GREEN)
						.build());
				break;

            case STUNNED:
				panelComponent.getChildren().add(TitleComponent.builder()
						.text("Stunned")
						.color(Color.ORANGE)
						.build());
				break;

            case IDLE:
			default:
				panelComponent.getChildren().add(TitleComponent.builder()
						.text("Not Thieving")
						.color(Color.RED)
						.build());
				break;
		}

		if(config.totalAttempts())
		{
			panelComponent.getChildren().add(LineComponent.builder()
					.left("Total:")
					.right("" + session.getTotal())
					.build());
		}

		if(config.successRate())
		{
			panelComponent.getChildren().add(LineComponent.builder()
					.left("Success Rate:")
					.right(FORMAT.format(session.getSuccessRate()) + "%")
					.build());
		}

		if(config.skillPerHour())
		{
			panelComponent.getChildren().add(LineComponent.builder()
					.right(xpTrackerService.getActionsHr(Skill.THIEVING) + "/hr")
					.build());
		}

		return panelComponent.render(graphics);
	}

	private ThievingState getThievingState()
	{
		if(isThieving())
		{
			return ThievingState.THIEVING;
		}
		else if(isStunned() || stunTimer != null)
		{
			return ThievingState.STUNNED;
		}
		else
		{
			return ThievingState.IDLE;
		}
	}

	private boolean isThieving()
	{
		switch (client.getLocalPlayer().getAnimation())
		{
			case PICKPOCKET_SUCCESS:
				return true;
			default:
				return false;
		}
	}

	private boolean isStunned()
	{
		switch (client.getLocalPlayer().getAnimation())
		{
			case PICKPOCKET_FAIL_1:
			case PICKPOCKET_FAIL_2:
			case PICKPOCKET_FAIL_3:
				return true;
			default:
				return false;
		}
	}

	private void addStunTimer()
	{
		if(config.stunedTimer())
		{
			stunTimer = new StunTimer(plugin, STUN_DURATION, itemManager.getImage(STUN_ICON));
			infoBoxManager.addInfoBox(stunTimer);
		}
	}

	private void removeStunTimer()
	{
		infoBoxManager.removeInfoBox(stunTimer);
		stunTimer = null;
	}
}