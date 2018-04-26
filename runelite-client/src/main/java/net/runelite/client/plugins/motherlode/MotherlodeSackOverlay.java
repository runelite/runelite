/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.BackgroundComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

class MotherlodeSackOverlay extends Overlay
{
	private static final Color DANGER = new Color(150, 0, 0, 150);
	private final Client client;
	private final MotherlodeConfig config;
	private final MotherlodePlugin plugin;

	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MotherlodeSackOverlay(Client client, MotherlodeConfig config, MotherlodePlugin plugin)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInMlm())
		{
			return null;
		}

		Widget sack = client.getWidget(WidgetInfo.MOTHERLODE_MINE);

		panelComponent.getLines().clear();
		panelComponent.setBackgroundColor(BackgroundComponent.DEFAULT_BACKGROUND_COLOR);

		if (sack != null)
		{
			sack.setHidden(true);

			if (config.showSack())
			{
				if (plugin.getCurSackSize() >= plugin.getMaxSackSize())
				{
					panelComponent.setBackgroundColor(DANGER);
				}

				panelComponent.getLines().add(new PanelComponent.Line(
					"Pay-dirt in sack:",
					Color.WHITE,
					String.valueOf(client.getSetting(Varbits.SACK_NUMBER)),
					Color.WHITE
				));
			}

			if (config.showDepositsLeft())
			{
				final Integer depositsLeft = plugin.getDepositsLeft();
				final PanelComponent.Line line = new PanelComponent.Line(
					"Deposits left:",
					Color.WHITE,
					depositsLeft == null ? "N/A" : String.valueOf(depositsLeft),
					Color.WHITE
				);

				if (depositsLeft != null)
				{
					if (depositsLeft == 0)
					{
						panelComponent.setBackgroundColor(DANGER);
					}
					else if (depositsLeft == 1)
					{
						line.setLeftColor(Color.RED);
						line.setRightColor(Color.RED);
					}
				}

				panelComponent.getLines().add(line);
			}
		}

		return panelComponent.render(graphics);
	}
}
