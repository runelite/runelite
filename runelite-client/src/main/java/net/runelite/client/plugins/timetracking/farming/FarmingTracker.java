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
package net.runelite.client.plugins.timetracking.farming;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.time.Instant;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.Tab;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;

@Singleton
public class FarmingTracker
{
	@Deprecated
	private static final String OLD_KEY_NAME = "farmingTracker";

	private final Client client;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final TimeTrackingConfig config;
	private final FarmingWorld farmingWorld;

	@Inject
	private FarmingTracker(Client client, ItemManager itemManager, ConfigManager configManager,
		TimeTrackingConfig config, FarmingWorld farmingWorld)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.config = config;
		this.farmingWorld = farmingWorld;
	}


	public FarmingTabPanel createTabPanel(Tab tab)
	{
		return new FarmingTabPanel(client, itemManager, configManager, config, farmingWorld.getTabs().get(tab));
	}

	/**
	 * Updates tracker data for the current region. Returns true if any data was changed.
	 */
	public boolean updateData(WorldPoint location)
	{
		boolean changed = false;

		{
			String group = TimeTrackingConfig.KEY_NAME + "." + client.getUsername();
			String autoweed = Integer.toString(client.getVar(Varbits.AUTOWEED));
			if (!autoweed.equals(configManager.getConfiguration(group, TimeTrackingConfig.AUTOWEED)))
			{
				configManager.setConfiguration(group, TimeTrackingConfig.AUTOWEED, autoweed);
				changed = true;
			}
		}

		FarmingRegion region = farmingWorld.getRegions().get(location.getRegionID());
		if (region != null && region.isInBounds(location))
		{
			// Write config with new varbits
			// timetracking.<login-username>.<regionID>.<VarbitID>=<varbitValue>:<unix time>
			String group = TimeTrackingConfig.KEY_NAME + "." + client.getUsername() + "." + region.getRegionID();
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
							// ignored
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

		return changed;
	}

	/**
	 * Migrates configuration data from {@code "farmingTracker"} key to {@code "timetracking"} key.
	 * This method should be removed after a reasonable amount of time.
	 */
	@Deprecated
	public void migrateConfiguration()
	{
		String username = client.getUsername();

		// migrate autoweed config
		{
			String oldGroup = OLD_KEY_NAME + "." + username;
			String newGroup = TimeTrackingConfig.KEY_NAME + "." + username;
			String storedValue = configManager.getConfiguration(oldGroup, TimeTrackingConfig.AUTOWEED);

			if (storedValue != null)
			{
				configManager.setConfiguration(newGroup, TimeTrackingConfig.AUTOWEED, storedValue);
				configManager.unsetConfiguration(oldGroup, TimeTrackingConfig.AUTOWEED);
			}
		}

		// migrate all saved data in all regions
		for (FarmingRegion region : farmingWorld.getRegions().values())
		{
			String oldGroup = OLD_KEY_NAME + "." + username + "." + region.getRegionID();
			String newGroup = TimeTrackingConfig.KEY_NAME + "." + username + "." + region.getRegionID();

			for (Varbits varbit : region.getVarbits())
			{
				String key = Integer.toString(varbit.getId());
				String storedValue = configManager.getConfiguration(oldGroup, key);

				if (storedValue != null)
				{
					configManager.setConfiguration(newGroup, key, storedValue);
					configManager.unsetConfiguration(oldGroup, key);
				}
			}
		}
	}
}
