/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.configsubmenudemo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

/**
 * Renders the current state of every config value so you can see live that
 * toggling items in the config panel (including the submenu sub-panel) takes
 * effect immediately.
 * <p>
 * Note that the submenu items (Option C–F) are <em>automatically</em> gated by
 * the submenu header's checkbox: callers don't AND against the toggle, the
 * config proxy short-circuits to {@code false} when the submenu is off.
 */
class ConfigSubmenuDemoOverlay extends OverlayPanel
{
	private final ConfigSubmenuDemoConfig config;

	@Inject
	private ConfigSubmenuDemoOverlay(ConfigSubmenuDemoPlugin plugin, ConfigSubmenuDemoConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_LEFT);
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!config.topLevelEnabled())
		{
			return null;
		}

		panelComponent.getChildren().add(TitleComponent.builder()
			.text("Submenu Demo")
			.build());

		addRow("Option A", config.optionA());
		addRow("Option B", config.optionB());
		addRow("Option C", config.optionC());
		addRow("Option D", config.optionD());
		addRow("Option E", config.optionE());
		addRow("Option F", config.optionF());

		return super.render(graphics);
	}

	private void addRow(String label, boolean value)
	{
		panelComponent.getChildren().add(LineComponent.builder()
			.left(label)
			.right(value ? "on" : "off")
			.rightColor(value ? Color.GREEN : Color.RED)
			.build());
	}
}
