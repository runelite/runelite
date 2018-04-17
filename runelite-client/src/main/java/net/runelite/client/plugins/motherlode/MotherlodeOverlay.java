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
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_ADAMANT;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_BLACK;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_BRONZE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_DRAGON;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_DRAGON_ORN;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_INFERNAL;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_IRON;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_MITHRIL;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_RUNE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_STEEL;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

class MotherlodeOverlay extends Overlay
{
	private static final Set<Integer> MINING_ANIMATION_IDS = ImmutableSet.of(
		MINING_MOTHERLODE_BRONZE, MINING_MOTHERLODE_IRON, MINING_MOTHERLODE_STEEL,
		MINING_MOTHERLODE_BLACK, MINING_MOTHERLODE_MITHRIL, MINING_MOTHERLODE_ADAMANT,
		MINING_MOTHERLODE_RUNE, MINING_MOTHERLODE_DRAGON, MINING_MOTHERLODE_DRAGON_ORN,
		MINING_MOTHERLODE_INFERNAL
	);

	private final Client client;
	private final MotherlodePlugin plugin;
	private final MotherlodeConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MotherlodeOverlay(Client client, MotherlodePlugin plugin, MotherlodeConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInMlm() || !config.showMiningStats())
		{
			return null;
		}

		MotherlodeSession session = plugin.getSession();

		if (session.getLastPayDirtMined() == null)
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastPayDirtMined(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		panelComponent.getLines().clear();

		if (config.showMiningState())
		{
			if (MINING_ANIMATION_IDS.contains(client.getLocalPlayer().getAnimation()))
			{
				panelComponent.setTitle("You are mining");
				panelComponent.setTitleColor(Color.GREEN);
			}
			else
			{
				panelComponent.setTitle("You are NOT mining");
				panelComponent.setTitleColor(Color.RED);
			}
		}
		else
		{
			panelComponent.setTitle(null);
		}

		panelComponent.getLines().add(new PanelComponent.Line(
			"Pay-dirt mined:",
			Integer.toString(session.getTotalMined())
		));

		panelComponent.getLines().add(new PanelComponent.Line(
			"Pay-dirt/hr:",
			session.getRecentMined() > 2
			? Integer.toString(session.getPerHour())
			: ""
		));

		return panelComponent.render(graphics);
	}
}
