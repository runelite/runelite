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
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class BarrowsBrotherSlainOverlay extends Overlay
{
	private final Client client;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private BarrowsBrotherSlainOverlay(BarrowsPlugin plugin, Client client)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		this.client = client;
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Barrows overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Do not display overlay if potential is null/hidden
		final Widget potential = client.getWidget(WidgetInfo.BARROWS_POTENTIAL);
		if (potential == null || potential.isHidden())
		{
			return null;
		}

		// Hide original overlay
		final Widget barrowsBrothers = client.getWidget(WidgetInfo.BARROWS_BROTHERS);
		if (barrowsBrothers != null)
		{
			barrowsBrothers.setHidden(true);
			potential.setHidden(true);
		}

		panelComponent.getChildren().clear();

		for (BarrowsBrothers brother : BarrowsBrothers.values())
		{
			final boolean brotherSlain = client.getVar(brother.getKilledVarbit()) > 0;
			String slain = brotherSlain ? "\u2713" : "\u2717";
			panelComponent.getChildren().add(LineComponent.builder()
				.left(brother.getName())
				.right(slain)
				.rightColor(brotherSlain ? Color.GREEN : Color.RED)
				.build());
		}

		float rewardPercent = client.getVar(Varbits.BARROWS_REWARD_POTENTIAL) / 10.0f;
		panelComponent.getChildren().add(LineComponent.builder()
				.left("Potential")
				.right(rewardPercent != 0 ? rewardPercent + "%" : "0%")
				.rightColor(rewardPercent >= 73.0f && rewardPercent <= 88.0f ? Color.GREEN : rewardPercent < 65.6f ? Color.WHITE : Color.YELLOW)
				.build());

		return panelComponent.render(graphics);
	}
}
