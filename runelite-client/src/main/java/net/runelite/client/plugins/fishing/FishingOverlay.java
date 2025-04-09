/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.fishing;

import com.google.common.collect.ImmutableSet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Skill;
import net.runelite.api.gameval.AnimationID;
import net.runelite.api.gameval.SpotanimID;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class FishingOverlay extends OverlayPanel
{
	private static final String FISHING_SPOT = "Fishing spot";
	private static final String FISHING_RESET = "Reset";

	private static final Set<Integer> FISHING_ANIMATIONS = ImmutableSet.of(
		AnimationID.HUMAN_HARPOON_BARBED,
		AnimationID.BRUT_PLAYER_HAND_FISHING_END_BLANK,
		AnimationID.BRUT_PLAYER_HAND_FISHING_END_SHARK_2,
		AnimationID.BRUT_PLAYER_HAND_FISHING_END_SHARK_1,
		AnimationID.BRUT_PLAYER_HAND_FISHING_END_SWORDFISH_1,
		AnimationID.BRUT_PLAYER_HAND_FISHING_END_SWORDFISH_2,
		AnimationID.BRUT_PLAYER_HAND_FISHING_END_TUNA_1,
		AnimationID.BRUT_PLAYER_HAND_FISHING_END_TUNA_2,
		AnimationID.BRUT_PLAYER_HAND_FISHING_START,
		AnimationID.BRUT_PLAYER_HAND_FISHING_READY,
		AnimationID.HUMAN_LARGENET,
		AnimationID.HUMAN_LOBSTER,
		AnimationID.HUMAN_HARPOON_CRYSTAL,
		AnimationID.HUMAN_HARPOON_DRAGON,
		AnimationID.HUMAN_HARPOON_TRAILBLAZER_NO_INFERNAL,
		AnimationID.HUMAN_HARPOON,
		AnimationID.HUMAN_HARPOON_INFERNAL,
		AnimationID.HUMAN_HARPOON_LEAGUE_TRAILBLAZER,
		AnimationID.HUMAN_OCTOPUS_POT,
		AnimationID.HUMAN_SMALLNET,
		AnimationID.HUMAN_FISHING_CASTING,
		AnimationID.HUMAN_FISH_ONSPOT,
		AnimationID.HUMAN_FISHING_CASTING_PEARL,
		AnimationID.HUMAN_FISHING_CASTING_PEARL_FLY,
		AnimationID.HUMAN_FISHING_CASTING_PEARL_BRUT,
		AnimationID.HUMAN_FISH_ONSPOT_PEARL,
		AnimationID.HUMAN_FISH_ONSPOT_PEARL_FLY,
		AnimationID.HUMAN_FISH_ONSPOT_PEARL_BRUT,
		AnimationID.HUMAN_FISHING_CASTING_PEARL_OILY,
		AnimationID.HUMAN_FISHING_ONSPOT_BRUT);

	private final Client client;
	private final FishingPlugin plugin;
	private final FishingConfig config;
	private final XpTrackerService xpTrackerService;

	@Inject
	public FishingOverlay(Client client, FishingPlugin plugin, FishingConfig config, XpTrackerService xpTrackerService)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.xpTrackerService = xpTrackerService;
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Fishing overlay");
		addMenuEntry(RUNELITE_OVERLAY, FISHING_RESET, "Fishing overlay", e -> plugin.reset());
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showFishingStats() || plugin.getSession().getLastFishCaught() == null)
		{
			return null;
		}

		if (client.getLocalPlayer().getInteracting() != null
			&& client.getLocalPlayer().getInteracting().getName().contains(FISHING_SPOT)
			&& client.getLocalPlayer().getInteracting().getGraphic() != SpotanimID.MINNOW_FISHING_FLYINGFISH
			&& FISHING_ANIMATIONS.contains(client.getLocalPlayer().getAnimation()))
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("Fishing")
				.color(Color.GREEN)
				.build());
		}
		else
		{
			panelComponent.getChildren().add(TitleComponent.builder()
				.text("NOT fishing")
				.color(Color.RED)
				.build());
		}

		int actions = xpTrackerService.getActions(Skill.FISHING);
		if (actions > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Caught fish:")
				.right(Integer.toString(actions))
				.build());

			if (actions > 2)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Fish/hr:")
					.right(Integer.toString(xpTrackerService.getActionsHr(Skill.FISHING)))
					.build());
			}
		}

		return super.render(graphics);
	}
}
