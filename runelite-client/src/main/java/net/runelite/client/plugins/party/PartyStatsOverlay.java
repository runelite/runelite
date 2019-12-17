/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.party;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import net.runelite.api.MenuAction;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ws.PartyService;

public class PartyStatsOverlay extends Overlay
{
	private static final Color HP_FG = new Color(0, 146, 54, 230);
	private static final Color HP_BG = new Color(102, 15, 16, 230);
	private static final Color PRAY_FG = new Color(0, 149, 151);
	private static final Color PRAY_BG = Color.black;

	private final PartyPlugin plugin;
	private final PartyService party;
	private final PartyConfig config;
	private final PanelComponent body = new PanelComponent();

	@Inject
	private PartyStatsOverlay(final PartyPlugin plugin, final PartyService party, final PartyConfig config)
	{
		super(plugin);
		this.plugin = plugin;
		this.party = party;
		this.config = config;
		body.setBorder(new Rectangle());
		body.setGap(new Point(0, ComponentConstants.STANDARD_BORDER / 2));
		getMenuEntries().add(new OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY, "Leave", "Party"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.stats())
		{
			return null;
		}

		final Map<UUID, PartyData> partyDataMap = plugin.getPartyDataMap();
		if (partyDataMap.isEmpty())
		{
			return null;
		}

		body.getChildren().clear();
		body.setBackgroundColor(null);

		boolean only1 = plugin.getPartyDataMap().size() == 1;

		synchronized (plugin.getPartyDataMap())
		{
			partyDataMap.forEach((k, v) ->
			{
				if (party.getLocalMember() != null && party.getLocalMember().getMemberId().equals(k))
				{
					if (only1)
					{
						body.getChildren().add(TitleComponent.builder()
							.text("No other party members")
							.color(Color.RED)
							.build());
					}

					return;
				}

				final PanelComponent panel = v.getPanel();
				panel.getChildren().clear();

				final TitleComponent name = TitleComponent.builder()
					.text(v.getName())
					.color(config.recolorNames() ? v.getColor() : Color.WHITE)
					.build();

				panel.getChildren().add(name);

				if (v.getMaxHitpoints() > 0)
				{
					final ProgressBarComponent hpBar = new ProgressBarComponent();
					hpBar.setBackgroundColor(HP_BG);
					hpBar.setForegroundColor(HP_FG);
					hpBar.setMaximum(v.getMaxHitpoints());
					hpBar.setValue(v.getHitpoints());
					hpBar.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.FULL);
					panel.getChildren().add(hpBar);
				}

				if (v.getMaxPrayer() > 0)
				{
					final ProgressBarComponent prayBar = new ProgressBarComponent();
					prayBar.setBackgroundColor(PRAY_BG);
					prayBar.setForegroundColor(PRAY_FG);
					prayBar.setMaximum(v.getMaxPrayer());
					prayBar.setValue(v.getPrayer());
					prayBar.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.FULL);
					panel.getChildren().add(prayBar);
				}

				body.getChildren().add(panel);
			});
		}

		return body.render(graphics);
	}
}
