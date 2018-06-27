/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import static net.runelite.client.plugins.raids.RaidsPlugin.POINTS_FORMAT;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class RaidsPointsOverlay extends Overlay
{
	@Inject
	private Client client;

	@Inject
	private RaidsPlugin plugin;

	private final RaidsConfig config;
	private final PanelComponent panel = new PanelComponent();

	@Inject
	public RaidsPointsOverlay(RaidsConfig config)
	{
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.HIGH);
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInRaidChambers())
		{
			return null;
		}

		int totalPoints = client.getVar(Varbits.TOTAL_POINTS);
		int personalPoints = client.getVar(Varbits.PERSONAL_POINTS);

		panel.getChildren().clear();
		panel.getChildren().add(LineComponent.builder()
			.left("Total:")
			.right(POINTS_FORMAT.format(totalPoints))
			.build());

		panel.getChildren().add(LineComponent.builder()
			.left(client.getLocalPlayer().getName() + ":")
			.right(POINTS_FORMAT.format(personalPoints))
			.build());

		panel.getChildren().add(LineComponent.builder()
			.left("Party size:")
			.right(String.valueOf(client.getVar(Varbits.RAID_PARTY_SIZE)))
			.build());

		if (config.uniqueChance())
		{
			// The number of points corresponding to a 1% chance
			final double POINTS_PER_PERCENT = 7125.0;
			// The maximum number of unique drops that can be received
			final int MAX_DROPS = 3;
			// The maximum chance of getting a unique drop
			final double MAX_PERCENT = 80.0;
			// Round percentages to one decimal place
			final DecimalFormat df = new DecimalFormat("0.0");

			double percentage = totalPoints / POINTS_PER_PERCENT;
			int numDrops = Math.min(MAX_DROPS, (int) Math.ceil(percentage / MAX_PERCENT));

			// Overlay needs to be a different size if there's more than one drop
			if (numDrops > 1)
			{
				this.panel.setPreferredSize(new Dimension(ComponentConstants.STANDARD_WIDTH + 20, 0));
				for (int i = 1; i <= numDrops; i++)
				{
					double chance = Math.min(percentage - (i - 1) * MAX_PERCENT, MAX_PERCENT);
					panel.getChildren().add(LineComponent.builder()
						.left("Unique Chance " + i + ": ")
						.right(String.valueOf(df.format(chance)) + "%")
						.build());
				}
			}
			else
			{
				double chance = Math.min(percentage, MAX_PERCENT);

				this.panel.setPreferredSize(new Dimension(ComponentConstants.STANDARD_WIDTH + 10, 0));
				panel.getChildren().add(LineComponent.builder()
					.left("Unique Chance:")
					.right(String.valueOf(df.format(chance)) + "%")
					.build());
			}
		}
		else
		{
			this.panel.setPreferredSize(new Dimension(ComponentConstants.STANDARD_WIDTH, 0));
		}

		return panel.render(graphics);
	}
}
