/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

class BlastMineOreCountOverlay extends Overlay
{
	private final Client client;
	private final BlastMinePluginConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	BlastMineOreCountOverlay(Client client, BlastMinePluginConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (!config.enabled())
		{
			return null;
		}

		Widget blastMineWidget = client.getWidget(WidgetInfo.BLAST_MINE);

		panelComponent.getLines().clear();

		if (blastMineWidget != null)
		{
			blastMineWidget.setHidden(true);
			if (config.showOreOverlay())
			{
				panelComponent.getLines().add(new PanelComponent.Line(
						"Coal:",
						String.valueOf(client.getSetting(Varbits.BLAST_MINE_COAL))
				));
				panelComponent.getLines().add(new PanelComponent.Line(
						"Gold ore:",
						String.valueOf(client.getSetting(Varbits.BLAST_MINE_GOLD))
				));
				panelComponent.getLines().add(new PanelComponent.Line(
						"Mithril ore:",
						String.valueOf(client.getSetting(Varbits.BLAST_MINE_MITHRIL))
				));
				panelComponent.getLines().add(new PanelComponent.Line(
						"Adamantite ore:",
						String.valueOf(client.getSetting(Varbits.BLAST_MINE_ADAMANTITE))
				));
				panelComponent.getLines().add(new PanelComponent.Line(
						"Runite ore:",
						String.valueOf(client.getSetting(Varbits.BLAST_MINE_RUNITE))
				));
			}
		}
		return panelComponent.render(graphics, parent);
	}
}
