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
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
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
public class PluginSorterPlugin extends Plugin
{
	//Cache the hidden plugins
	private static List<PluginListItem> removedPlugins = new ArrayList<>();

	@Inject
	private PluginSorterConfig config;

	@Provides
	PluginSorterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PluginSorterConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateColors();
	}

	@Override
	protected void shutDown() throws Exception
	{

	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			if (config.hidePlugins())
			{
				hidePlugins();
			}
			updateColors();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getKey().equals("hidePlugins"))
		{
			if (config.hidePlugins())
			{
				hidePlugins();
			}
			else
			{
				showPlugins();
			}
		}
		updateColors();
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
						pli.nameLabel.setForeground(config.externalColor());
						break;
					case PVM:
						pli.nameLabel.setForeground(config.pvmColor());
						break;
					case PVP:
						pli.nameLabel.setForeground(config.pvpColor());
						break;
					case SKILLING:
						pli.nameLabel.setForeground(config.skillingColor());
						break;
					case UTILITY:
						pli.nameLabel.setForeground(config.utilityColor());
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
		List<PluginListItem> tempList = new ArrayList<>();
		tempList.addAll(removedPlugins);
		tempList.addAll(ConfigPanel.pluginList);
		ConfigPanel.pluginList = tempList;
	}
}
