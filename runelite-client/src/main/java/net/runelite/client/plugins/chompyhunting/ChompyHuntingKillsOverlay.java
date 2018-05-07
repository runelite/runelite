/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.chompyhunting;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;

public class ChompyHuntingKillsOverlay extends Overlay
{
	private final Client client;
	private final ChompyHuntingConfig config;
	private final ChompyHuntingPlugin plugin;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	ChompyHuntingKillsOverlay(Client client, ChompyHuntingConfig config, ChompyHuntingPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.displaySessionKillCount() &&
			!config.displayLifetimeKillCount() &&
			!config.displayKillsPerHour())
		{
			return null;
		}

		ChompyHuntingSession session = plugin.getSession();

		if (session.getLastChompyKilled() == null)
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastChompyKilled(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		panelComponent.getChildren().clear();

		int numLiveChompies = plugin.numLiveChompies();

		if (numLiveChompies == 0)
		{
			panelComponent.setTitle("Waiting for chompies...");
			panelComponent.setTitleColor(Color.GREEN);
		}
		else if (numLiveChompies == 1)
		{
			panelComponent.setTitle(Integer.toString(numLiveChompies) +
				" chompy to kill");
			panelComponent.setTitleColor(Color.RED);
		}
		else
		{
			panelComponent.setTitle(Integer.toString(numLiveChompies) +
				" chompies to kill");
			panelComponent.setTitleColor(Color.RED);
		}

		if (config.displaySessionKillCount())
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Session kills:")
				.right(Integer.toString(session.getRecentKilled()))
				.build());
		}

		if (config.displayLifetimeKillCount())
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Lifetime kills:")
				.right(Integer.toString(session.getLifetimeKilled()))
				.build());
		}

		if (config.displayKillsPerHour())
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Kills/hr:")
				.right(Integer.toString(session.getPerHour()))
				.build());
		}

		return panelComponent.render(graphics);
	}
}
