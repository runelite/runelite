/*
 * Copyright (c) 2019, Matsyir <https://github.com/matsyir>
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
package net.runelite.client.plugins.lmsperformancetracker;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.*;

import javax.inject.Inject;
import java.awt.*;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

public class LmsPerformanceTrackerOverlay extends Overlay
{
	private final PanelComponent panelComponent = new PanelComponent();
	private final LmsPerformanceTrackerPlugin plugin;
	private final LmsPerformanceTrackerConfig config;

	@Inject
	private LmsPerformanceTrackerOverlay(LmsPerformanceTrackerPlugin plugin, LmsPerformanceTrackerConfig config)
	{
		super(plugin);
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		setPriority(OverlayPriority.LOW);
		panelComponent.setWrapping(4);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "LMS Performance overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		FightPerformance currentFight = plugin.getCurrentFight();
		if (currentFight == null || !config.showCurrentFightOverlay() ||
			(config.restrictToLms() && !plugin.isAtLMS()))
		{
			return null;
		}

		panelComponent.getChildren().clear();

		// Only display the title if it's enabled (pointless in my opinion, since you can just see
		// what the panel is displaying, but I can understand the preference of having overlays labelled)
		if (config.showOverlayTitle())
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("LMS Performance")
				.build());
		}

		// First line: Player's stats (you: success rate counters + % value)
		// Would have preferred to have usernames but they are too long.
		String playerName = plugin.getCurrentFight().getPlayerName();
		panelComponent.getChildren().add(LineComponent.builder()
			.left(playerName.substring(0, Math.min(7, playerName.length())))//.left("You:")
			.leftColor(plugin.getCurrentFight().playerWinning() ? Color.GREEN : Color.WHITE)
			.right(currentFight.getPlayerStatsString())
			.build());
		// Second line: Opponent's stats (foe: success rate counters + % value)
		String oppName = plugin.getCurrentFight().getOpponentName();
		panelComponent.getChildren().add(LineComponent.builder()
			.left(oppName.substring(0, Math.min(7, oppName.length())))//.left("Foe:")
			.leftColor(plugin.getCurrentFight().opponentWinning() ? Color.GREEN : Color.WHITE)
			.right(currentFight.getOpponentStatsString())
			.build());

		return panelComponent.render(graphics);
	}
}
