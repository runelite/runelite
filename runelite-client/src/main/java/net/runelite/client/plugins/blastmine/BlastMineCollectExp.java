/*
 * Copyright (c) 2017, Jacky Liang <liangj97@gmail.com>
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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.text.NumberFormat;
import java.util.Locale;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

class BlastMineCollectExp extends Overlay
{
	private final Client client;
	private final BlastMinePluginConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	private static final int COAL_EXP = 30;
	private static final int GOLD_EXP = 60;
	private static final int MITHRIL_EXP = 110;
	private static final int ADAMANT_EXP = 170;
	private static final int RUNITE_EXP = 240;

	@Inject
	public BlastMineCollectExp(Client client, BlastMinePluginConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget blastMineWidget = client.getWidget(WidgetInfo.BLAST_MINE);

		if (blastMineWidget == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		if (config.showCollectionExp())
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Exp")
				.right(NumberFormat.getIntegerInstance(Locale.getDefault()).format(calculateExp()))
				.build());
		}
		return panelComponent.render(graphics);
	}

	private int calculateExp()
	{
		int coal = client.getVar(Varbits.BLAST_MINE_COAL);
		int gold = client.getVar(Varbits.BLAST_MINE_GOLD);
		int mithril = client.getVar(Varbits.BLAST_MINE_MITHRIL);
		int adamant = client.getVar(Varbits.BLAST_MINE_ADAMANTITE);
		int rune = client.getVar(Varbits.BLAST_MINE_RUNITE);
		int exp = COAL_EXP * coal + GOLD_EXP * gold + MITHRIL_EXP * mithril + ADAMANT_EXP * adamant + RUNITE_EXP * rune;

		if (config.isWearingFullProspector())
		{
			return (int) Math.round(exp * 1.025);
		}

		return exp;
	}
}
