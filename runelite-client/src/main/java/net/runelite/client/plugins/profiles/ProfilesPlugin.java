/*
 * Copyright (c) 2019, Spedwards <https://github.com/Spedwards>
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
package net.runelite.client.plugins.profiles;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import java.util.concurrent.ScheduledExecutorService;

@PluginDescriptor(
	name = "Account Switcher",
	description = "Allow for a allows you to easily switch between multiple OSRS Accounts",
	tags = {"profile", "account", "login", "log in", "pklite"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class ProfilesPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ProfilesConfig config;

	@Inject
	private EventBus eventBus;

	@Inject
	private ScheduledExecutorService executorService;

	private ProfilesPanel panel;
	private NavigationButton navButton;
	private boolean switchToPanel;


	@Provides
	ProfilesConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ProfilesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		if (this.switchToPanel)
		{
			eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		}

		panel = injector.getInstance(ProfilesPanel.class);
		panel.init();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "profiles_icon.png");

		navButton = NavigationButton.builder()
			.tooltip("Profiles")
			.icon(icon)
			.priority(8)
			.panel(panel)
			.onReady(() -> executorService.submit(() -> OpenPanel(true)))
			.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

		clientToolbar.removeNavigation(navButton);
	}

	private void onGameStateChanged(GameStateChanged event)
	{
		if (!this.switchToPanel)
		{
			return;
		}
		if (event.getGameState().equals(GameState.LOGIN_SCREEN))
		{
			if (!navButton.isSelected())
			{
				OpenPanel(true);
			}
		}
	}

	private void onConfigChanged(ConfigChanged event) throws Exception
	{
		if (event.getGroup().equals("profiles") && event.getKey().equals("rememberPassword"))
		{
			panel = injector.getInstance(ProfilesPanel.class);
			this.shutDown();
			this.startUp();
			updateConfig();
		}
		if (event.getGroup().equals("profiles") && event.getKey().equals("switchPanel"))
		{
			updateConfig();
		}
	}

	private void OpenPanel(boolean openPanel)
	{
		if (openPanel && this.switchToPanel)
		{
			// If we haven't seen the latest feed item,
			// open the feed panel.
			navButton.getOnSelect().run();
		}
	}

	private void updateConfig()
	{
		this.switchToPanel = config.switchPanel();
	}

}
