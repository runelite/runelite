/*
 * Copyright (c) 2019 Abex
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
package net.runelite.client.plugins.config;

import java.util.List;
import javax.annotation.Nullable;
import javax.swing.JMenuItem;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.util.LinkBrowser;

@Value
@RequiredArgsConstructor
class PluginConfigurationDescriptor
{
	private final String name;
	private final String description;
	private final String[] tags;

	// Can be null if its not an actual plugin (RuneLite / ChatColors)
	@Nullable
	private final Plugin plugin;

	// Can be null if it has no more configuration than the on/off toggle
	@Nullable
	private final Config config;

	@Nullable
	private final ConfigDescriptor configDescriptor;

	@Nullable
	private final List<String> conflicts;

	PluginConfigurationDescriptor(String name, String description, String[] tags, Config config, ConfigDescriptor configDescriptor)
	{
		this(name, description, tags, null, config, configDescriptor, null);
	}

	/**
	 * Creates a menu item for linking to a support page for the plugin
	 *
	 * @return A {@link JMenuItem} which opens the plugin's wiki page URL in the browser when clicked
	 */
	@Nullable
	JMenuItem createSupportMenuItem()
	{
		String iname = getInternalPluginHubName();
		if (iname != null)
		{
			JMenuItem menuItem = new JMenuItem("Support");
			menuItem.addActionListener(e -> LinkBrowser.browse("https://runelite.net/plugin-hub/show/" + iname));
			return menuItem;
		}

		JMenuItem menuItem = new JMenuItem("Wiki");
		menuItem.addActionListener(e -> LinkBrowser.browse("https://github.com/runelite/runelite/wiki/" + name.replace(' ', '-')));
		return menuItem;
	}

	@Nullable
	String getInternalPluginHubName()
	{
		if (plugin == null)
		{
			return null;
		}

		return ExternalPluginManager.getInternalName(plugin.getClass());
	}
}
