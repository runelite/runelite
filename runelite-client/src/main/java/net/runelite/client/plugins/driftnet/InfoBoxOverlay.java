/*
 * Copyright (c) 2019, Abiyaz C <chowdh2@cooper.edu>
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
package net.runelite.client.plugins.driftnet;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class InfoBoxOverlay extends Overlay
{
	private final DriftNetConfig config;
	private final DriftNetPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	InfoBoxOverlay(DriftNetConfig config, DriftNetPlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		setPosition(OverlayPosition.TOP_CENTER);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();
		if (!config.infoBox() || !plugin.isInDriftNetArea())
		{
			return null;
		}
		DriftNet[] nets = {plugin.northNet, plugin.southNet};
		for (int i = 0; i < nets.length; i++)
		{
			DriftNet net = nets[i];
			String text1 = (i == 0) ? "North Net:" : "South Net:";
			String text2 = "";
			switch (net.getNetStatus())
			{
				case FULL:
					text2 = "FULL";
					break;
				case SET:
					text2 = (net.getNumFish() + "/10");
					break;
				case UNSET:
					text2 = "UNSET";
					break;
				default:
					break;
			}
			Color color = DriftNetOverlay.getColor(net);
			if (color != null)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.rightColor(color)
					.preferredSize(new Dimension(ComponentConstants.STANDARD_WIDTH - 15, 0))
					.left(text1)
					.right(text2)
					.build());
			}
		}
		return panelComponent.render(graphics);
	}
}
