/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.farmingtracker;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.UsernameChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;

@PluginDescriptor(
	name = "Farming Tracker"
)
@Slf4j
public class FarmingTrackerPlugin extends Plugin
{
	@Inject
	private PluginToolbar pluginToolbar;

	@Inject
	private ConfigManager configManager;

	@Inject
	private Client client;

	@Inject
	private FarmingWorld farmingWorld;

	@Inject
	private ItemManager itemManager;

	@Inject
	private FarmingTrackerConfig config;

	private FarmingTrackerPanel panel;

	private NavigationButton navButton;

	private WorldPoint lastTickLoc;

	@Provides
	FarmingTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FarmingTrackerConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(getClass().getResourceAsStream("farming.png"));
		}

		panel = new FarmingTrackerPanel(client, itemManager, configManager, config, farmingWorld);

		navButton = NavigationButton.builder()
			.name("Farming Tracker")
			.icon(icon)
			.panel(panel)
			.build();

		pluginToolbar.addNavigation(navButton);

		updatePanel();
	}

	@Subscribe
	public void onUsernameChanged(UsernameChanged e)
	{
		updatePanel();
	}

	@Override
	protected void shutDown() throws Exception
	{
		pluginToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onGameTick(GameTick t)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			lastTickLoc = null;
			return;
		}

		WorldPoint loc = lastTickLoc;
		lastTickLoc = client.getLocalPlayer().getWorldLocation();
		if (loc == null || loc.getRegionID() != lastTickLoc.getRegionID())
		{
			return;
		}

		boolean changed = false;

		{
			String group = FarmingTrackerConfig.KEY_NAME + "." + client.getUsername();
			String autoweed = Integer.toString(client.getVar(Varbits.AUTOWEED));
			if (!autoweed.equals(configManager.getConfiguration(group, FarmingTrackerConfig.AUTOWEED)))
			{
				configManager.setConfiguration(group, FarmingTrackerConfig.AUTOWEED, autoweed);
				changed = true;
			}
		}

		FarmingRegion region = farmingWorld.getRegions().get(loc.getRegionID());
		if (region != null && region.isInBounds(loc))
		{
			// Write config with new varbits
			// farmingTracker.<login-username>.<regionID>.<VarbitID>=<varbitValue>:<unix time>
			String group = FarmingTrackerConfig.KEY_NAME + "." + client.getUsername() + "." + region.getRegionID();
			long unixNow = Instant.now().getEpochSecond();
			for (Varbits varbit : region.getVarbits())
			{
				// Write the config value if it doesn't match what is current, or it is more than 5 minutes old
				String key = Integer.toString(varbit.getId());
				String strVarbit = Integer.toString(client.getVar(varbit));
				String storedValue = configManager.getConfiguration(group, key);
				if (storedValue != null)
				{
					String[] parts = storedValue.split(":");
					if (parts.length == 2 && parts[0].equals(strVarbit))
					{
						long unixTime = 0;
						try
						{
							unixTime = Long.parseLong(parts[1]);
						}
						catch (NumberFormatException e)
						{
						}
						if (unixTime + (5 * 60) > unixNow && unixNow + 30 > unixTime)
						{
							continue;
						}
					}
				}
				String value = strVarbit + ":" + unixNow;
				configManager.setConfiguration(group, key, value);
				changed = true;
			}
		}

		if (changed)
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
