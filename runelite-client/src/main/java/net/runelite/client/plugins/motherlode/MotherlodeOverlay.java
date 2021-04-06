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
package net.runelite.client.plugins.motherlode;

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import javax.inject.Inject;
import static net.runelite.api.AnimationID.*;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class MotherlodeOverlay extends OverlayPanel
{
	private static final Set<Integer> MINING_ANIMATION_IDS = ImmutableSet.of(
		MINING_MOTHERLODE_BRONZE, MINING_MOTHERLODE_IRON, MINING_MOTHERLODE_STEEL,
		MINING_MOTHERLODE_BLACK, MINING_MOTHERLODE_MITHRIL, MINING_MOTHERLODE_ADAMANT,
		MINING_MOTHERLODE_RUNE, MINING_MOTHERLODE_GILDED, MINING_MOTHERLODE_DRAGON,
		MINING_MOTHERLODE_DRAGON_UPGRADED, MINING_MOTHERLODE_DRAGON_OR, MINING_MOTHERLODE_DRAGON_OR_TRAILBLAZER,
		MINING_MOTHERLODE_INFERNAL, MINING_MOTHERLODE_3A, MINING_MOTHERLODE_CRYSTAL,
		MINING_MOTHERLODE_TRAILBLAZER
	);
	static final String MINING_RESET = "Reset";

	private final Client client;
	private final MotherlodePlugin plugin;
	private final MotherlodeSession motherlodeSession;
	private final MotherlodeConfig config;

	@Inject
	MotherlodeOverlay(Client client, MotherlodePlugin plugin, MotherlodeSession motherlodeSession, MotherlodeConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.motherlodeSession = motherlodeSession;
		this.config = config;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY, MINING_RESET, "Motherlode mine overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInMlm() || !config.showMiningStats())
		{
			return null;
		}

		MotherlodeSession session = motherlodeSession;

		if (session.getLastPayDirtMined() == null)
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceLastPayDirt = Duration.between(session.getLastPayDirtMined(), Instant.now());

		if (sinceLastPayDirt.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		if (config.showMiningState())
		{
			if (MINING_ANIMATION_IDS.contains(client.getLocalPlayer().getAnimation()))
			{
				panelComponent.getChildren().add(TitleComponent.builder()
					.text("Mining")
					.color(Color.GREEN)
					.build());
			}
			else
			{
				panelComponent.getChildren().add(TitleComponent.builder()
					.text("NOT mining")
					.color(Color.RED)
					.build());
			}
		}

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Pay-dirt mined:")
			.right(Integer.toString(session.getTotalMined()))
			.build());

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Pay-dirt/hr:")
			.right(session.getRecentMined() > 2 ? Integer.toString(session.getPerHour()) : "")
			.build());

		return super.render(graphics);
	}
}
