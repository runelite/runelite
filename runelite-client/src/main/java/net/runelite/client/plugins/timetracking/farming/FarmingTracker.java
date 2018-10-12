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
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.SummaryState;
import net.runelite.client.plugins.timetracking.Tab;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;

@Singleton
public class FarmingTracker
{
	private final Client client;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final TimeTrackingConfig config;
	private final FarmingWorld farmingWorld;

	private final Map<Tab, SummaryState> summaries = new EnumMap<>(Tab.class);

	/**
	 * The time at which all patches of a particular type will be ready to be harvested,
	 * or {@code -1} if we have no data about any patch of the given type.
	 */
	private final Map<Tab, Long> completionTimes = new EnumMap<>(Tab.class);

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
			String group = TimeTrackingConfig.CONFIG_GROUP + "." + client.getUsername();
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
			String group = TimeTrackingConfig.CONFIG_GROUP + "." + client.getUsername() + "." + region.getRegionID();
			long unixNow = Instant.now().getEpochSecond();
			for (FarmingPatch patch : region.getPatches())
			{
				// Write the config value if it doesn't match what is current, or it is more than 5 minutes old
				Varbits varbit = patch.getVarbit();
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

		if (changed)
		{
			updateCompletionTime();
		}

		return changed;
	}

	public void loadCompletionTimes()
	{
		summaries.clear();
		completionTimes.clear();
		updateCompletionTime();
	}

	public SummaryState getSummary(Tab patchType)
	{
		SummaryState summary = summaries.get(patchType);
		return summary == null ? SummaryState.UNKNOWN : summary;
	}

	/**
	 * Gets the overall completion time for the given patch type.
	 *
	 * @see #completionTimes
	 */
	public long getCompletionTime(Tab patchType)
	{
		Long completionTime = completionTimes.get(patchType);
		return completionTime == null ? -1 : completionTime;
	}

	/**
	 * Updates the overall completion time for the given patch type.
	 *
	 * @see #completionTimes
	 */
	private void updateCompletionTime()
	{
		for (Map.Entry<Tab, Set<FarmingPatch>> tab : farmingWorld.getTabs().entrySet())
		{
			long maxCompletionTime = 0;
			boolean allUnknown = true;
			boolean allEmpty = true;

			for (FarmingPatch patch : tab.getValue())
			{
				String group = TimeTrackingConfig.CONFIG_GROUP + "." + client.getUsername() + "." + patch.getRegion().getRegionID();
				String key = Integer.toString(patch.getVarbit().getId());
				String storedValue = configManager.getConfiguration(group, key);
				long unixTime = 0;
				int value = 0;

				if (storedValue != null)
				{
					String[] parts = storedValue.split(":");
					if (parts.length == 2)
					{
						try
						{
							value = Integer.parseInt(parts[0]);
							unixTime = Long.parseLong(parts[1]);
						}
						catch (NumberFormatException e)
						{
							// ignored
						}
					}
				}

				PatchState state = unixTime <= 0 ? null : patch.getImplementation().forVarbitValue(value);
				if (state == null || state.getProduce().getItemID() < 0)
				{
					continue; // unknown state
				}

				int tickrate = state.getTickRate() * 60;
				int stage = state.getStage();
				int stages = state.getStages();

				if (state.getProduce() != Produce.WEEDS && state.getProduce() != Produce.SCARECROW)
				{
					allEmpty = false;

					// update max duration if this patch takes longer to grow
					if (tickrate > 0)
					{
						long tickTime = unixTime / tickrate;
						long doneEstimate = ((stages - 1 - stage) + tickTime) * tickrate;
						maxCompletionTime = Math.max(maxCompletionTime, doneEstimate);
					}
					else if (state.getCropState() == CropState.GROWING && stage != stages - 1)
					{
						continue; // unknown state
					}
				}

				allUnknown = false;
			}

			final SummaryState state;
			final long completionTime;

			if (allUnknown)
			{
				state = SummaryState.UNKNOWN;
				completionTime = -1L;
			}
			else if (allEmpty)
			{
				state = SummaryState.EMPTY;
				completionTime = -1L;
			}
			else if (maxCompletionTime <= Instant.now().getEpochSecond())
			{
				state = SummaryState.COMPLETED;
				completionTime = 0;
			}
			else
			{
				state = SummaryState.IN_PROGRESS;
				completionTime = maxCompletionTime;
			}
			summaries.put(tab.getKey(), state);
			completionTimes.put(tab.getKey(), completionTime);
		}
	}
}
