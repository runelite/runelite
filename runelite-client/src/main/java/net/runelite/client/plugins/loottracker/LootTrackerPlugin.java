/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.loottracker;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;

@PluginDescriptor(
	name = "Loot Tracker",
	description = "", //TODO write plugin description
	tags = {"loot", "drops"}, //TODO write plugin tags
	loadWhenOutdated = true
)
@Slf4j
public class LootTrackerPlugin extends Plugin
{
	@Inject
	private PluginToolbar pluginToolbar;

	private LootTrackerPanel panel;
	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception
	{
		panel = injector.getInstance(LootTrackerPanel.class);
		panel.init();

		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(LootTrackerPanel.class.getResourceAsStream("reset.png"));
		}

		navButton = NavigationButton.builder()
			.tooltip("Loot Tracker")
			.icon(icon)
			.priority(7)
			.panel(panel)
			.build();

		pluginToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		pluginToolbar.removeNavigation(navButton);
	}
}
