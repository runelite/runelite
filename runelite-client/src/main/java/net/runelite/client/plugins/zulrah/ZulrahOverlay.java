/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.zulrah;

import java.awt.*;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class ZulrahOverlay extends Overlay {
	private final ZulrahConfig config;
	private final ZulrahPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();


	@Inject
	private Client client;

	@Inject
	private ZulrahOverlay(ZulrahConfig config, ZulrahPlugin plugin) {
		this.config = config;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
		panelComponent.setPreferredSize(new Dimension(150, 0));
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if (!config.EnableZulrahPrayerHelper()) {
			return null;
		}
		NPC Zulrah = plugin.Zulrah;
		if (Zulrah != null) {
			if (plugin.prayerconserve && plugin.nextprayerendticks == 0) {
				Player player = client.getLocalPlayer();
				HeadIcon icon = player.getOverheadIcon();
				if (icon != null) {
					final String text = "Disable Overhead Prayer";
					final int textWidth = graphics.getFontMetrics().stringWidth(text);
					final int textHeight = graphics.getFontMetrics().getAscent() - graphics.getFontMetrics().getDescent();
					final int width = (int) client.getRealDimensions().getWidth();
					java.awt.Point jpoint = new java.awt.Point((width / 2) - textWidth, textHeight + 75);
					panelComponent.getChildren().clear();
					panelComponent.getChildren().add(TitleComponent.builder().text(text).color(Color.RED).build());
					panelComponent.setPreferredLocation(jpoint);
					panelComponent.render(graphics);
				}
			} else if (plugin.nextprayerendticks != 0) {
				Player player = client.getLocalPlayer();
				HeadIcon icon = player.getOverheadIcon();
				if (icon == null) {
					final String text = "Protect from MAGIC: " + (plugin.nextprayerendticks - plugin.ticks);
					final int textWidth = graphics.getFontMetrics().stringWidth(text);
					final int textHeight = graphics.getFontMetrics().getAscent() - graphics.getFontMetrics().getDescent();
					final int width = (int) client.getRealDimensions().getWidth();
					java.awt.Point jpoint = new java.awt.Point((width / 2) - textWidth, textHeight + 75);
					panelComponent.getChildren().clear();
					panelComponent.getChildren().add(TitleComponent.builder().text(text).color(Color.GREEN).build());
					panelComponent.setPreferredLocation(jpoint);
					panelComponent.render(graphics);
				}
			}
		}
		return null;
	}
}
