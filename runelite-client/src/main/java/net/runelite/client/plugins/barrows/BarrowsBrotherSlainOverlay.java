/*
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.FontManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LineComponent;

class BarrowsBrotherSlainOverlay extends OverlayPanel
{
	private static final DecimalFormat REWARD_POTENTIAL_FORMATTER = new DecimalFormat("##0.00%");
	private final Client client;
	private final BarrowsPlugin plugin;
	private final BarrowsConfig config;
	private final BarrowsPotentialProgressBar progressBar = new BarrowsPotentialProgressBar();
	private int cachedPotential = -1;
	private int cachedSlainBrothers = -1;
	private int cachedPotentialGoal = -1;
	private List<String> cachedRecommendations;

	@Inject
	private BarrowsBrotherSlainOverlay(BarrowsPlugin plugin, Client client, BarrowsConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(PRIORITY_LOW);
		this.plugin = plugin;
		this.client = client;
		this.config = config;
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Barrows overlay");
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget barrowsBrothers = client.getWidget(InterfaceID.BarrowsOverlay.BROTHERS);
		if (barrowsBrothers == null)
		{
			return null;
		}

		boolean extended = config.showPotentialKillRecommendations() && plugin.shouldShowPotentialKillRecommendations();
		panelComponent.setPreferredSize(new Dimension(extended ? 350 : ComponentConstants.STANDARD_WIDTH, 0));

		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			final boolean brotherSlain = client.getVarbitValue(brother.getKilledVarbit()) > 0;
			String slain = brotherSlain ? "\u2713" : "\u2717";
			panelComponent.getChildren().add(LineComponent.builder()
				.left(brother.getName())
				.right(slain)
				.rightFont(FontManager.getDefaultFont())
				.rightColor(brotherSlain ? Color.GREEN : Color.RED)
				.build());
		}

		final int rewardPotential = plugin.getRewardPotential();
		if (config.showPotentialProgressBar())
		{
			panelComponent.getChildren().add(LineComponent.builder().left("Potential:").build());
			progressBar.setRewardPotential(rewardPotential);
			progressBar.setGoalPercent(config.potentialGoal());
			panelComponent.getChildren().add(progressBar);
		}
		else
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Potential")
				.right(REWARD_POTENTIAL_FORMATTER.format(rewardPotential / 1012f))
				.rightColor(rewardPotential >= 756 && rewardPotential < 881 ? Color.GREEN : rewardPotential < 631 ? Color.WHITE : Color.YELLOW)
				.build());
		}

		if (config.showPotentialKillRecommendations() && plugin.shouldShowPotentialKillRecommendations())
		{
			addPotentialKillRecommendations(rewardPotential);
		}

		return super.render(graphics);
	}

	private void addPotentialKillRecommendations(int rewardPotential)
	{
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Recommended kills, including remaining brothers:")
			.build());

		Set<BarrowsBrothers> slainBrothers = EnumSet.noneOf(BarrowsBrothers.class);
		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			if (client.getVarbitValue(brother.getKilledVarbit()) > 0)
			{
				slainBrothers.add(brother);
			}
		}

		int slainMask = 0;
		for (BarrowsBrothers brother : slainBrothers)
		{
			slainMask |= 1 << brother.ordinal();
		}
		int potentialGoal = config.potentialGoal();
		if (cachedPotential != rewardPotential || cachedSlainBrothers != slainMask || cachedPotentialGoal != potentialGoal)
		{
			cachedPotential = rewardPotential;
			cachedSlainBrothers = slainMask;
			cachedPotentialGoal = potentialGoal;
			cachedRecommendations = BarrowsPotentialPlan.findClosestPlans(rewardPotential, slainBrothers, potentialGoal);
		}

		for (String recommendation : cachedRecommendations)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("• " + recommendation)
				.build());
		}
	}
}
