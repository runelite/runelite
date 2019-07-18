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

import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.api.MenuAction;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ChatColorConfig;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.config.RuneLitePlusConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Configuration",
	loadWhenOutdated = true,
	hidden = true // prevent users from disabling
)
@Singleton
public class ConfigPlugin extends Plugin
{

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ConfigManager configManager;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private ScheduledExecutorService executorService;

	@Inject
	private RuneLiteConfig runeLiteConfig;

	@Inject
	private RuneLitePlusConfig runeLitePlusConfig;

	@Inject
	private ChatColorConfig chatColorConfig;

	@Inject
	private ColorPickerManager colorPickerManager;

	@Inject
	private EventBus eventBus;

	private ConfigPanel configPanel;
	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		configPanel = new ConfigPanel(pluginManager, configManager, executorService, runeLiteConfig, runeLitePlusConfig, chatColorConfig, colorPickerManager);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "config_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Configuration")
			.icon(icon)
			.priority(0)
			.panel(configPanel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	public void shutDown() throws Exception
	{
		eventBus.unregister(this);

		clientToolbar.removeNavigation(navButton);
		RuneLite.getInjector().getInstance(ClientThread.class).invokeLater(() ->
		{
			try
			{
				ConfigPanel.pluginList.clear();
				pluginManager.setPluginEnabled(this, true);
				pluginManager.startPlugin(this);
				Method expand = ClientUI.class.getDeclaredMethod("expand", NavigationButton.class);
				expand.setAccessible(true);
				expand.invoke(RuneLite.getInjector().getInstance(ClientUI.class), navButton);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		});
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(PluginChanged.class, this, this::onPluginChanged);
		eventBus.subscribe(OverlayMenuClicked.class, this, this::onOverlayMenuClicked);
	}

	private void onPluginChanged(PluginChanged event)
	{
		SwingUtilities.invokeLater(configPanel::refreshPluginList);
	}

	private void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
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
			PluginDescriptor descriptor = plugin.getClass().getAnnotation(PluginDescriptor.class);
			SwingUtilities.invokeLater(() ->
			{
				if (!navButton.isSelected())
				{
					navButton.getOnSelect().run();
				}
				configPanel.openConfigurationPanel(descriptor.name());
			});
		}
	}
}
