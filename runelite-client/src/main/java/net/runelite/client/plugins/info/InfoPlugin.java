/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.info;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Info Panel",
	description = "Enable the Info panel",
	tags = {"info", "github", "patreon", "dir", "discord"},
	loadWhenOutdated = true,
	type = PluginType.MISCELLANEOUS
)
@Singleton
public class InfoPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private boolean showLogDir;
	@Getter(AccessLevel.PACKAGE)
	private boolean showRuneliteDir;
	@Getter(AccessLevel.PACKAGE)
	private boolean showPluginsDir;
	@Getter(AccessLevel.PACKAGE)
	private boolean showScreenshotsDir;
	@Getter(AccessLevel.PACKAGE)
	private boolean showGithub;
	@Getter(AccessLevel.PACKAGE)
	private boolean showLauncher;
	@Getter(AccessLevel.PACKAGE)
	private boolean showPhysicalDir;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private InfoConfig config;

	private NavigationButton navButton;

	@Provides
	InfoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InfoConfig.class);
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("info"))
		{
			return;
		}

		updateConfig();
	}

	@Override
	protected void startUp()
	{
		updateConfig();

		InfoPanel panel = injector.getInstance(InfoPanel.class);

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "info_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Info")
			.icon(icon)
			.priority(9)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
	}

	private void updateConfig()
	{
		this.showGithub = config.showGithub();
		this.showLauncher = config.showLauncher();
		this.showLogDir = config.showLogDir();
		this.showRuneliteDir = config.showRuneliteDir();
		this.showPluginsDir = config.showPluginsDir();
		this.showScreenshotsDir = config.showScreenshotsDir();
		this.showPhysicalDir = config.showPhysicalDir();
	}
}