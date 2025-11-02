/*
 * Copyright (c) 2024, Private Server Multiboxing
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
package net.runelite.client.plugins.privateserver;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class PrivateServerOverlay extends Overlay
{
	private final Client client;
	private final PrivateServerPlugin plugin;
	private final PrivateServerConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private PrivateServerOverlay(Client client, PrivateServerPlugin plugin, PrivateServerConfig config)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.LOW);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.showMultiboxOverlay())
		{
			return null;
		}

		panelComponent.getChildren().clear();

		// Title
		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Private Server")
			.color(Color.CYAN)
			.build());

		// Multiboxing status
		String multiboxStatus = plugin.isMultiboxingEnabled() ? "ACTIVE" : "INACTIVE";
		Color multiboxColor = plugin.isMultiboxingEnabled() ? Color.GREEN : Color.RED;

		panelComponent.getChildren().add(LineComponent.builder()
			.left("Multiboxing:")
			.right(multiboxStatus)
			.rightColor(multiboxColor)
			.build());

		// Click sync status
		if (plugin.isMultiboxingEnabled())
		{
			String clickSyncStatus = plugin.isClickSyncEnabled() ? "ON" : "OFF";
			Color clickSyncColor = plugin.isClickSyncEnabled() ? Color.GREEN : Color.GRAY;

			panelComponent.getChildren().add(LineComponent.builder()
				.left("Click Sync:")
				.right(clickSyncStatus)
				.rightColor(clickSyncColor)
				.build());
		}

		// Features status
		if (plugin.isMultiboxingEnabled())
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Prayer Sync:")
				.right(config.quickPrayerSync() ? "ON" : "OFF")
				.rightColor(config.quickPrayerSync() ? Color.GREEN : Color.GRAY)
				.build());

			panelComponent.getChildren().add(LineComponent.builder()
				.left("Spec Sync:")
				.right(config.quickSpecSync() ? "ON" : "OFF")
				.rightColor(config.quickSpecSync() ? Color.GREEN : Color.GRAY)
				.build());
		}

		return panelComponent.render(graphics);
	}
}
