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
package net.runelite.client.plugins.pluginsorter;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.config.ConfigPanel;
import net.runelite.client.plugins.config.PluginListItem;

@PluginDescriptor(
	name = "Plugin Organizer",
	description = "Hides and colors 3rd party plugins for better control",
	tags = {"plugins", "organizer"},
	type = PluginType.PLUGIN_ORGANIZER
)
@Singleton
public class PluginSorterPlugin extends Plugin
{
	//Cache the hidden plugins
	private static final List<PluginListItem> removedPlugins = new ArrayList<>();

	@Inject
	private PluginSorterConfig config;

	@Inject
	private EventBus eventBus;

	private boolean hidePlugins;
	private Color externalColor;
	private Color pvmColor;
	private Color pvpColor;
	private Color skillingColor;
	private Color utilityColor;

	@Provides
	PluginSorterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PluginSorterConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		updateColors();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(PluginChanged.class, this, this::onPluginChanged);
	}

	private void onPluginChanged(PluginChanged pluginChanged)
	{
		validatePlugins();
	}

	private void validatePlugins()
	{
		if (this.hidePlugins)
		{
			hidePlugins();
		}
		else
		{
			showPlugins();
		}

		updateColors();
	}

	private void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("pluginsorter"))
		{
			return;
		}

		updateConfig();

		if (configChanged.getKey().equals("hidePlugins"))
		{
			validatePlugins();
		}
	}

	private void updateColors()
	{
		for (PluginListItem pli : ConfigPanel.pluginList)
		{
			if (pli.getPlugin() != null)
			{
				switch (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type())
				{
					case EXTERNAL:
						pli.nameLabel.setForeground(this.externalColor);
						break;
					case PVM:
						pli.nameLabel.setForeground(this.pvmColor);
						break;
					case PVP:
						pli.nameLabel.setForeground(this.pvpColor);
						break;
					case SKILLING:
						pli.nameLabel.setForeground(this.skillingColor);
						break;
					case UTILITY:
						pli.nameLabel.setForeground(this.utilityColor);
						break;
					default:
						pli.nameLabel.setForeground(Color.WHITE);
						break;
				}
			}
		}
	}

	private void hidePlugins()
	{
		Iterator<PluginListItem> iter = ConfigPanel.pluginList.iterator();
		while (iter.hasNext())
		{
			PluginListItem pli = iter.next();
			if (pli.getPlugin() != null)
			{
				switch (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type())
				{
					case PVM:
					case PVP:
					case SKILLING:
					case UTILITY:
					case EXTERNAL:
						iter.remove();
						removedPlugins.add(pli);
						break;
					case GENERAL_USE:
					default:
						break;
				}
			}
		}
	}

	private void showPlugins()
	{
		List<PluginListItem> tempList = new ArrayList<>(ConfigPanel.pluginList);
		if (tempList.size() > 0)
		{
			tempList.addAll(1, removedPlugins);
		}
		else
		{
			tempList.addAll(removedPlugins);
		}
		ConfigPanel.pluginList = tempList;
	}

	private void updateConfig()
	{
		this.hidePlugins = config.hidePlugins();
		this.externalColor = config.externalColor();
		this.pvmColor = config.pvmColor();
		this.pvpColor = config.pvpColor();
		this.skillingColor = config.skillingColor();
		this.utilityColor = config.utilityColor();
	}
}
