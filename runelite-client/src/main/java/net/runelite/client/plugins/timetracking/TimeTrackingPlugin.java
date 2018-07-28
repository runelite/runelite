/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.timetracking;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.UsernameChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.timetracking.farming.FarmingTracker;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Time Tracking",
	description = "Enable the Time Tracking panel, which contains farming trackers",
	tags = {"farming", "skilling", "panel"}
)
@Slf4j
public class TimeTrackingPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Client client;

	@Inject
	private FarmingTracker farmingTracker;

	@Inject
	private ItemManager itemManager;

	@Inject
	private TimeTrackingConfig config;

	private TimeTrackingPanel panel;

	private NavigationButton navButton;

	private WorldPoint lastTickLocation;

	@Provides
	TimeTrackingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TimeTrackingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "watch.png");

		panel = new TimeTrackingPanel(itemManager, config, farmingTracker);

		navButton = NavigationButton.builder()
			.tooltip("Time Tracking")
			.icon(icon)
			.panel(panel)
			.priority(4)
			.build();

		clientToolbar.addNavigation(navButton);

		updatePanel();
	}

	@Override
	protected void shutDown() throws Exception
	{
		lastTickLocation = null;
		clientToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onGameTick(GameTick t)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			lastTickLocation = null;
			return;
		}

		WorldPoint loc = lastTickLocation;
		lastTickLocation = client.getLocalPlayer().getWorldLocation();

		if (loc == null || loc.getRegionID() != lastTickLocation.getRegionID())
		{
			return;
		}

		boolean farmingDataChanged = farmingTracker.updateData(loc);

		if (farmingDataChanged)
		{
			updatePanel();
		}
	}

	@Subscribe
	public void onUsernameChanged(UsernameChanged e)
	{
		farmingTracker.migrateConfiguration();
		updatePanel();
	}

	@Schedule(period = 10, unit = ChronoUnit.SECONDS)
	public void updatePanel()
	{
		SwingUtilities.invokeLater(panel::update);
	}
}
