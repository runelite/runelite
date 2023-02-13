/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.NavigationButtonAdded;
import net.runelite.client.events.NavigationButtonRemoved;
import net.runelite.client.events.PluginConfigClicked;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.externalplugins.ExternalPluginManifest;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.util.LinkBrowser;

/**
 * Plugin toolbar buttons holder.
 */
@Singleton
@Slf4j
public class ClientToolbar
{
	public static final String CONFIGURATION = "Configuration";
	public static final String SUPPORT = "Support";
	public static final String WIKI = "Wiki";

	private final EventBus eventBus;
	private final Set<NavigationButton> buttons = new HashSet<>();

	@Inject
	private ClientToolbar(final EventBus eventBus)
	{
		this.eventBus = eventBus;
	}

	/**
	 * Add navigation.
	 *
	 * @param button the button
	 */
	public void addNavigation(final NavigationButton button)
	{
		if (buttons.contains(button))
		{
			return;
		}

		if (buttons.add(button))
		{
			addDefaultOptions(button);
			eventBus.post(new NavigationButtonAdded(button));
		}
	}

	/**
	 * Remove navigation.
	 *
	 * @param button the button
	 */
	public void removeNavigation(final NavigationButton button)
	{
		if (buttons.remove(button))
		{
			eventBus.post(new NavigationButtonRemoved(button));
		}
	}

	/**
	 * Add default options to navigation button popup menu
	 * Current options are Configuration and Support/Wiki
	 *
	 * @param button the button
	 */
	public void addDefaultOptions(NavigationButton button)
	{
		Map<String, Runnable> navigationButtonPopup = button.getPopup() != null ? new HashMap<>(button.getPopup()) : new HashMap<>();
		addConfigurationOption(navigationButtonPopup, button.getPlugin(), button.getPanel());
		addSupportOption(navigationButtonPopup, button.getPlugin(), button.getPanel());
		button.setPopup(navigationButtonPopup);
	}

	/**
	 * Add configuration shortcut to popup
	 * Uses the Plugin in button if possible
	 * If it is an external plugin, get the plugin via the plugin manifest
	 *
	 * @param popup map of options
	 */
	public void addConfigurationOption(Map<String, Runnable> popup, Plugin plugin, PluginPanel panel)
	{
		if (plugin != null)
		{
			popup.put(CONFIGURATION, () -> eventBus.post(new PluginConfigClicked(plugin.getClass())));
		}
		else if (panel != null)
		{
			Class<? extends Plugin> externalPluginClass = ExternalPluginManager.getExternalPluginClass(panel.getClass());
			if (externalPluginClass != null)
			{
				popup.put(CONFIGURATION, () -> eventBus.post(new PluginConfigClicked(externalPluginClass)));
			}
		}
	}

	/**
	 * Add support link to options
	 * If it is an external plugin, get the support link via the plugin manifest
	 * Else use the plugin name to link to the runelite wiki
	 *
	 * @param popup map of options
	 */
	public void addSupportOption(Map<String, Runnable> popup, Plugin plugin, PluginPanel panel)
	{
		ExternalPluginManifest mf = panel != null ? ExternalPluginManager.getExternalPluginManifest(panel.getClass()) : null;
		if (mf != null)
		{
			if (mf.getSupport() != null)
			{
				popup.put(SUPPORT, () -> LinkBrowser.browse(mf.getSupport().toString()));
			}
			return;
		}
		if (plugin != null)
		{
			popup.put(WIKI, () -> LinkBrowser.browse("https://github.com/runelite/runelite/wiki/" + plugin.getName().replace(' ', '-')));
		}
	}


}
