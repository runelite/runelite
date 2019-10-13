/*
 * Copyright (c) 2018, https://openosrs.com
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

import com.google.common.collect.ImmutableList;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Comparator;
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
	@Inject
	private PluginSorterConfig config;

	@Inject
	private EventBus eventBus;

	private PluginSorterConfig.SortStyle pluginSortMode;
	private Color externalColor;
	private Color pvmColor;
	private Color pvpColor;
	private Color skillingColor;
	private Color utilityColor;

	private final ImmutableList<PluginType> definedOrder = ImmutableList.of(PluginType.IMPORTANT, PluginType.EXTERNAL, PluginType.PVM, PluginType.SKILLING, PluginType.PVP, PluginType.UTILITY, PluginType.GENERAL_USE, PluginType.PLUGIN_ORGANIZER);
	private final Comparator<PluginListItem> pluginTypeComparator = Comparator.comparing(plugin ->
	{
		PluginType type = PluginType.GENERAL_USE;
		Plugin sortPlugin = plugin.getPlugin();
		if (sortPlugin != null)
		{
			type = sortPlugin.getClass().getAnnotation(PluginDescriptor.class).type();
		}
		else if (plugin.configDescriptor.getGroup().value().equals("openosrs") || plugin.configDescriptor.getGroup().value().equals("runelite"))
		{
			type = PluginType.IMPORTANT;
		}

		return definedOrder.indexOf(type);
	});

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

		updatePlugins();
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
		updatePlugins();
	}

	private void onConfigChanged(ConfigChanged configChanged)
	{
		if (!configChanged.getGroup().equals("pluginsorter"))
		{
			return;
		}

		updateConfig();
		updatePlugins();
	}

	private void updatePlugins()
	{
		boolean hidePlugins = config.hidePlugins();
		boolean hidePvmPlugins = config.hidePvmPlugins();
		boolean hidePvpPlugins = config.hidePvpPlugins();
		boolean hideSkillingPlugins = config.hideSkillingPlugins();
		boolean hideUtilityPlugins = config.hideUtilityPlugins();
		boolean hideExternalPlugins = config.hideExternalPlugins();

		for (PluginListItem pli : ConfigPanel.pluginList)
		{
			if (pli.getPlugin() != null)
			{
				switch (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type())
				{
					case EXTERNAL:
						pli.nameLabel.setForeground(this.externalColor);
						pli.setHidden(hidePlugins || hideExternalPlugins);
						break;
					case PVM:
						pli.nameLabel.setForeground(this.pvmColor);
						pli.setHidden(hidePlugins || hidePvmPlugins);
						break;
					case PVP:
						pli.nameLabel.setForeground(this.pvpColor);
						pli.setHidden(hidePlugins || hidePvpPlugins);
						break;
					case SKILLING:
						pli.nameLabel.setForeground(this.skillingColor);
						pli.setHidden(hidePlugins || hideSkillingPlugins);
						break;
					case UTILITY:
						pli.nameLabel.setForeground(this.utilityColor);
						pli.setHidden(hidePlugins || hideUtilityPlugins);
						break;
					default:
						pli.nameLabel.setForeground(Color.WHITE);
						break;
				}
			}
		}

		if (this.pluginSortMode == PluginSorterConfig.SortStyle.CATEGORY)
		{
			ConfigPanel.pluginList.sort(pluginTypeComparator.thenComparing(PluginListItem::getName));
		}
		else
		{
			ConfigPanel.pluginList.sort(Comparator.comparing(PluginListItem::getName));
		}
	}

	private void updateConfig()
	{
		this.pluginSortMode = config.pluginSortMode();
		this.externalColor = config.externalColor();
		this.pvmColor = config.pvmColor();
		this.pvpColor = config.pvpColor();
		this.skillingColor = config.skillingColor();
		this.utilityColor = config.utilityColor();
	}
}
