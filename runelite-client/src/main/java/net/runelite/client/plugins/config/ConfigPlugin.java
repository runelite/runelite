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
package net.runelite.client.plugins.config;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.MenuAction;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.externalplugins.ExternalPluginManifest;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

@PluginDescriptor(
	name = "Configuration",
	loadWhenOutdated = true,
	hidden = true // prevent users from disabling
)
@Slf4j
public class ConfigPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Provider<PluginListPanel> pluginListPanelProvider;

	@Inject
	private ConfigManager configManager;

	@Inject
	private RuneLiteConfig runeLiteConfig;

	@Inject
	private ChatColorConfig chatColorConfig;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private ExternalPluginManager externalPluginManager;

	private PluginListPanel pluginListPanel;

	private NavigationButton navButton;

	private Set<Plugin> previousEnabledPlugins = new HashSet<>();

	@Override
	protected void startUp() throws Exception
	{
		pluginListPanel = pluginListPanelProvider.get();
		pluginListPanel.addFakePlugin(new PluginConfigurationDescriptor(
				"RuneLite", "RuneLite client settings",
				new String[]{"client", "notification", "size", "position", "window", "chrome", "focus", "font", "overlay", "tooltip", "infobox"},
				null, runeLiteConfig, configManager.getConfigDescriptor(runeLiteConfig)
			),
			new PluginConfigurationDescriptor(
				"Chat Color", "Recolor chat text", new String[]{"colour", "messages"},
				null, chatColorConfig, configManager.getConfigDescriptor(chatColorConfig)
			));
		pluginListPanel.rebuildPluginList();

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "config_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Configuration")
			.icon(icon)
			.priority(0)
			.panel(pluginListPanel.getMuxer())
			.popup(ImmutableMap
					.<String, Runnable>builder()
					.put("Restore default plugins", () ->
					{
						previousEnabledPlugins.clear();
						for (Plugin plugin : pluginManager.getPlugins())
						{
							if (pluginManager.isPluginEnabled(plugin))
							{
								previousEnabledPlugins.add(plugin);
							}
							PluginDescriptor pluginDescriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
							boolean stopPlugin = !pluginDescriptor.enabledByDefault();
							ExternalPluginManifest manifest = ExternalPluginManager.getExternalPluginManifest(plugin.getClass());
							if (manifest != null)
							{
								if (externalPluginManager.getInstalledExternalPlugins().contains(manifest.getInternalName()))
								{
									stopPlugin = true;
								}
							}
							if (stopPlugin)
							{
								try
								{
									pluginManager.setPluginEnabled(plugin, false);
									pluginManager.stopPlugin(plugin);
								} catch (PluginInstantiationException e)
								{
									log.warn("Unable to stop {}", plugin.getClass().getSimpleName());
								}
							} else if (!pluginManager.isPluginEnabled(plugin))
							{
								try
								{
									pluginManager.setPluginEnabled(plugin, true);
									pluginManager.startPlugin(plugin);
								} catch (PluginInstantiationException e)
								{
									log.warn("Unable to start {}", plugin.getClass().getSimpleName());
								}
							}
						}
					})
					.put("Disable all plugins", () ->
					{
						previousEnabledPlugins.clear();
						for (Plugin plugin : pluginManager.getPlugins())
						{
							if (pluginManager.isPluginEnabled(plugin))
							{
								previousEnabledPlugins.add(plugin);
							}
							PluginDescriptor pluginDescriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
							if (!pluginManager.isPluginEnabled(plugin) || plugin.getName().equalsIgnoreCase("Configuration") || pluginDescriptor.developerPlugin())
							{
								continue;
							}
							try
							{
								pluginManager.setPluginEnabled(plugin, false);
								pluginManager.stopPlugin(plugin);
							} catch (PluginInstantiationException e)
							{
								log.warn("Unable to stop {}", plugin.getClass().getSimpleName());
							}
						}
						log.debug("Disabled all plugins");
					})
					.put("Enable all plugins", () ->
					{
						for (Plugin plugin : pluginManager.getPlugins())
						{
							if (pluginManager.isPluginEnabled(plugin))
							{
								previousEnabledPlugins.add(plugin);
								continue;
							}
							if (plugin.getName().toLowerCase().contains("gpu"))
							{
								continue;
							}
							try
							{
								pluginManager.setPluginEnabled(plugin, true);
								pluginManager.startPlugin(plugin);
							} catch (PluginInstantiationException e)
							{
								log.warn("Unable to start {}", plugin.getClass().getSimpleName());
							}
						}
						log.debug("Enabled all plugins");
					})
					.put("Revert changes", () ->
					{
						if (previousEnabledPlugins.isEmpty())
						{
							return;
						}
						for (Plugin plugin : pluginManager.getPlugins())
						{
							if (previousEnabledPlugins.contains(plugin))
							{
								if (pluginManager.isPluginEnabled(plugin))
								{
									continue;
								}
								try
								{
									pluginManager.setPluginEnabled(plugin, true);
									pluginManager.startPlugin(plugin);
								} catch (PluginInstantiationException e)
								{
									log.warn("Unable to start {}", plugin.getClass().getSimpleName());
								}
							} else if (pluginManager.isPluginEnabled(plugin))
							{
								try
								{
									pluginManager.setPluginEnabled(plugin, false);
									pluginManager.stopPlugin(plugin);
								} catch (PluginInstantiationException e)
								{
									log.warn("Unable to stop {}", plugin.getClass().getSimpleName());
								}
							}
						}
						previousEnabledPlugins.clear();
						log.debug("Revert changes applied");
					})
					.build())
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(navButton);
	}
	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
	{
		OverlayMenuEntry overlayMenuEntry = overlayMenuClicked.getEntry();
		if (overlayMenuEntry.getMenuAction() == MenuAction.RUNELITE_OVERLAY_CONFIG)
		{
			Overlay overlay = overlayMenuClicked.getOverlay();
			Plugin plugin = overlay.getPlugin();
			if (plugin == null)
			{
				return;
			}

			// Expand config panel for plugin
			SwingUtilities.invokeLater(() ->
			{
				if (!navButton.isSelected())
				{
					navButton.getOnSelect().run();
				}
				pluginListPanel.openConfigurationPanel(plugin.getName());
			});
		}
	}
}
