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
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.timetracking.farming.FarmingTracker;
import net.runelite.client.plugins.timetracking.hunter.BirdHouseTracker;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Time Tracking",
	description = "Enable the Time Tracking panel, which contains farming and bird house trackers",
	tags = {"birdhouse", "farming", "hunter", "notifications", "skilling", "panel"}
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
	private BirdHouseTracker birdHouseTracker;

	@Inject
	private ItemManager itemManager;

	@Inject
	private TimeTrackingConfig config;

	private TimeTrackingPanel panel;

	private NavigationButton navButton;

	private WorldPoint lastTickLocation;
	private boolean lastTickPostLogin;

	@Provides
	TimeTrackingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TimeTrackingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		birdHouseTracker.loadFromConfig();

		final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "watch.png");

		panel = new TimeTrackingPanel(itemManager, config, farmingTracker, birdHouseTracker);

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
		lastTickPostLogin = false;
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

		// bird house data is only sent after exiting the post-login screen
		Widget motd = client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN_MESSAGE_OF_THE_DAY);
		if (motd != null && !motd.isHidden())
		{
			lastTickPostLogin = true;
			return;
		}

		if (lastTickPostLogin)
		{
			lastTickPostLogin = false;
			return;
		}

		WorldPoint loc = lastTickLocation;
		lastTickLocation = client.getLocalPlayer().getWorldLocation();

		if (loc == null || loc.getPlane() != 0 || loc.getRegionID() != lastTickLocation.getRegionID())
		{
			return;
		}

		boolean birdHouseDataChanged = birdHouseTracker.updateData(loc);
		boolean farmingDataChanged = farmingTracker.updateData(loc);

		if (birdHouseDataChanged || farmingDataChanged)
		{
			updatePanel();
		}
	}

	@Subscribe
	public void onUsernameChanged(UsernameChanged e)
	{
		farmingTracker.migrateConfiguration();
		birdHouseTracker.loadFromConfig();
		updatePanel();
	}

	@Schedule(period = 10, unit = ChronoUnit.SECONDS)
	public void checkCompletion()
	{
		boolean birdHouseDataChanged = birdHouseTracker.checkCompletion();

		if (birdHouseDataChanged)
		{
			updatePanel();
		}
	}

	@Schedule(period = 10, unit = ChronoUnit.SECONDS)
	public void updatePanel()
	{
		SwingUtilities.invokeLater(panel::update);
	}
}
