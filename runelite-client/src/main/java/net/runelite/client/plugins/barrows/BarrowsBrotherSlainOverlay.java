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
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.FontManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

class BarrowsBrotherSlainOverlay extends OverlayPanel
{
	private static final DecimalFormat REWARD_POTENTIAL_FORMATTER = new DecimalFormat("##0.00%");

	private final Client client;

	@Inject
	private BarrowsBrotherSlainOverlay(BarrowsPlugin plugin, Client client)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(PRIORITY_LOW);
		this.client = client;
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Barrows overlay");
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Only render the brothers slain overlay if the vanilla interface is loaded
		final Widget barrowsBrothers = client.getWidget(InterfaceID.BarrowsOverlay.BROTHERS);
		if (barrowsBrothers == null)
		{
			return null;
		}

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

		final int rewardPotential = rewardPotential();
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Potential")
			.right(REWARD_POTENTIAL_FORMATTER.format(rewardPotential / 1012f))
			.rightColor(rewardPotential >= 756 && rewardPotential < 881 ? Color.GREEN : rewardPotential < 631 ? Color.WHITE : Color.YELLOW)
			.build());

		return super.render(graphics);
	}

	/**
	 * Compute the barrows reward potential. Potential rewards are based off of the amount of
	 * potential.
	 * <p>
	 * The reward potential thresholds are as follows:
	 * Mind rune - 381
	 * Chaos rune - 506
	 * Death rune - 631
	 * Blood rune - 756
	 * Bolt rack - 881
	 * Half key - 1006
	 * Dragon med - 1012
	 *
	 * @return potential, 0-1012 inclusive
	 * @see <a href="https://twitter.com/jagexkieren/status/705428283509366785?lang=en">source</a>
	 */
	private int rewardPotential()
	{
		// this is from [proc,barrows_overlay_reward]
		int brothers = client.getVarbitValue(VarbitID.BARROWS_KILLED_AHRIM)
			+ client.getVarbitValue(VarbitID.BARROWS_KILLED_DHAROK)
			+ client.getVarbitValue(VarbitID.BARROWS_KILLED_GUTHAN)
			+ client.getVarbitValue(VarbitID.BARROWS_KILLED_KARIL)
			+ client.getVarbitValue(VarbitID.BARROWS_KILLED_TORAG)
			+ client.getVarbitValue(VarbitID.BARROWS_KILLED_VERAC);
		return client.getVarbitValue(VarbitID.BARROWS_KILLED_MONSTER) + brothers * 2;
	}
}
