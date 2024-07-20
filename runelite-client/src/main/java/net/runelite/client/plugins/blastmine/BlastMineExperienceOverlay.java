/*
 * Copyright (c) 2024, lunchbox
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
package net.runelite.client.plugins.blastmine;

import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

import javax.inject.Inject;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

class BlastMineExperienceOverlay extends OverlayPanel
{
	private final Client client;
	private final BlastMinePluginConfig config;

	@Inject
	private BlastMineExperienceOverlay(Client client, BlastMinePluginConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget blastMineWidget = client.getWidget(ComponentID.BLAST_MINE_CONTAINER);

		if (blastMineWidget == null)
		{
			return null;
		}

		if (config.showExperienceOverlay())
		{
			int coal = client.getVarbitValue(Varbits.BLAST_MINE_COAL) * 33;
			int gold = client.getVarbitValue(Varbits.BLAST_MINE_GOLD) * 66;
			int mithril = client.getVarbitValue(Varbits.BLAST_MINE_MITHRIL) * 120;
			int adamantite = client.getVarbitValue(Varbits.BLAST_MINE_ADAMANTITE) * 190;
			int runite = client.getVarbitValue(Varbits.BLAST_MINE_RUNITE) * 260;
			int total = coal + gold + mithril + adamantite + runite;
			double multiplier = config.experienceMultiplier();
			int totalWithMultiplier = ((int) Math.round(total + (total * (multiplier / 100))));

			panelComponent.getChildren().add(LineComponent.builder()
					.left("Stored XP")
					.right(NumberFormat.getIntegerInstance(Locale.getDefault()).format(totalWithMultiplier))
					.build());

		}

		return super.render(graphics);
	}
}
