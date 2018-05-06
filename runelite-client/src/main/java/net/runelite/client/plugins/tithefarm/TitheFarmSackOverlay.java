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
package net.runelite.client.plugins.tithefarm;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

class TitheFarmSackOverlay extends Overlay
{
	private final Client client;
	private final TitheFarmPluginConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	TitheFarmSackOverlay(Client client, TitheFarmPluginConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Widget sack = client.getWidget(WidgetInfo.TITHE_FARM);
		if (sack == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		sack.setHidden(true);

		if (config.showSack())
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Fruits in sack:")
				.right(String.valueOf(client.getVar(Varbits.TITHE_FARM_SACK_AMOUNT)))
				.build());

			panelComponent.getChildren().add(LineComponent.builder()
				.left("Points:")
				.right(String.valueOf(client.getVar(Varbits.TITHE_FARM_POINTS)))
				.build());
		}

		return panelComponent.render(graphics);
	}
}
