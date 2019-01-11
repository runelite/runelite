/*
 * Copyright (c) 2018, Craftiii4 <Craftiii4@gmail.com>
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
package net.runelite.client.plugins.mining;

import com.google.common.collect.ImmutableSet;
import static net.runelite.api.AnimationID.MINING_3A_PICKAXE;
import static net.runelite.api.AnimationID.MINING_ADAMANT_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BLACK_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BRONZE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE_ORN;
import static net.runelite.api.AnimationID.MINING_INFERNAL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_IRON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_MITHRIL_PICKAXE;
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
import static net.runelite.api.AnimationID.MINING_RUNE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_STEEL_PICKAXE;
import net.runelite.api.Client;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

/**
 * Displays information about the players current mining state and rocks mined
 */
public class MiningOverlay extends Overlay
{

	private static final Set<Integer> MINING_ANIMATION_IDS = ImmutableSet.of(
		MINING_3A_PICKAXE, MINING_ADAMANT_PICKAXE, MINING_BLACK_PICKAXE,
		MINING_BRONZE_PICKAXE, MINING_DRAGON_PICKAXE, MINING_DRAGON_PICKAXE_ORN,
		MINING_INFERNAL_PICKAXE, MINING_IRON_PICKAXE, MINING_MITHRIL_PICKAXE,
		MINING_RUNE_PICKAXE, MINING_STEEL_PICKAXE, MINING_MOTHERLODE_BRONZE,
		MINING_MOTHERLODE_IRON, MINING_MOTHERLODE_STEEL, MINING_MOTHERLODE_BLACK,
		MINING_MOTHERLODE_MITHRIL, MINING_MOTHERLODE_ADAMANT, MINING_MOTHERLODE_RUNE,
		MINING_MOTHERLODE_DRAGON, MINING_MOTHERLODE_DRAGON_ORN, MINING_MOTHERLODE_INFERNAL
	);

	private final MiningConfig config;
	private final Client client;
	private final MiningPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MiningOverlay(Client client, MiningPlugin plugin, MiningConfig config, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Prevents conflicts with the motherloade plugin
		if (config.disableInMLM() && plugin.isInMlm())
		{
			return null;
		}

		panelComponent.getChildren().clear();

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

		MiningSession session = plugin.getSession();
		if (session.getLastMined() != null)
		{
			Duration statTimeout = Duration.ofMinutes(config.statTimeout());
			Duration sinceCut = Duration.between(session.getLastMined(), Instant.now());
			if (sinceCut.compareTo(statTimeout) < 0)
			{
				if (config.showMiningStats())
				{
					for (MiningRockType rock : MiningRockType.values())
					{
						if (session.showRockRespawnTimes(rock))
						{
							panelComponent.getChildren().add(LineComponent.builder()
									.left(rock.getName() + " mined:")
									.right(Integer.toString(session.getSessionStats().get(rock).getTotalMined()))
									.build());
							panelComponent.getChildren().add(LineComponent.builder()
									.left(rock.getName() + "/hr:")
									.right(session.getSessionStats().get(rock).getRecentMined() > 2 ? Integer.toString(session.getSessionStats().get(rock).getPerHour()) : "")
									.build());
						}
					}
				}
				if (panelComponent.getChildren().size() > 0)
				{
					return panelComponent.render(graphics);
				}
			}
		}
		return null;
	}

}
