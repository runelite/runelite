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
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.vars.Autoweed;
import net.runelite.api.widgets.WidgetModalMode;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.SummaryState;
import net.runelite.client.plugins.timetracking.Tab;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;

@Slf4j
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

	private boolean newRegionLoaded;
	private Collection<FarmingRegion> lastRegions;

	@Inject
	private FarmingTracker(Client client, ItemManager itemManager, ConfigManager configManager, TimeTrackingConfig config, FarmingWorld farmingWorld)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.config = config;
		this.farmingWorld = farmingWorld;
	}

	public FarmingTabPanel createTabPanel(Tab tab, FarmingContractManager farmingContractManager)
	{
		return new FarmingTabPanel(this, itemManager, config, farmingWorld.getTabs().get(tab), farmingContractManager);
	}

	/**
	 * Updates tracker data for the current region. Returns true if any data was changed.
	 */
	public boolean updateData(WorldPoint location, int timeSinceModalClose)
	{
		boolean changed = false;

		//Varbits don't get sent when a modal widget is open so just return
		if (client.getComponentTable().getNodes()
			.stream()
			.anyMatch(widgetNode -> widgetNode.getModalMode() != WidgetModalMode.NON_MODAL))
		{
			return false;
		}

		{
			String autoweed = Integer.toString(client.getVar(Varbits.AUTOWEED));
			if (!autoweed.equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.AUTOWEED)))
			{
				configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.AUTOWEED, autoweed);
				changed = true;
			}
		}

		{
			boolean botanist = client.getVar(Varbits.LEAGUE_RELIC_5) == 1;
			if (!Boolean.valueOf(botanist).equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.BOTANIST, Boolean.class)))
			{
				configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.BOTANIST, botanist);
				changed = true;
			}
		}

		Collection<FarmingRegion> newRegions = farmingWorld.getRegionsForLocation(location);

		if (!newRegions.equals(lastRegions))
		{
			newRegionLoaded = true;
			log.debug("New region loaded. {} at {} ticks", newRegions.toString(), client.getTickCount());
		}

		for (FarmingRegion region : newRegions)
		{
			// Write config with new varbits
			// timetracking.<rsprofile>.<regionID>.<VarbitID>=<varbitValue>:<unix time>
			long unixNow = Instant.now().getEpochSecond();
			for (FarmingPatch patch : region.getPatches())
			{
				// Write the config value if it doesn't match what is current, or it is more than 5 minutes old
				Varbits varbit = patch.getVarbit();
				String key = region.getRegionID() + "." + varbit.getId();
				String strVarbit = Integer.toString(client.getVar(varbit));
				String storedValue = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, key);

				if (storedValue != null)
				{
					String[] parts = storedValue.split(":");
					if (parts.length == 2)
					{
						if (parts[0].equals(strVarbit))
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
						else if (!newRegionLoaded && timeSinceModalClose > 1)
						{
							PatchState previousPatchState = patch.getImplementation().forVarbitValue(Integer.parseInt(parts[0]));
							PatchState currentPatchState = patch.getImplementation().forVarbitValue(client.getVar(varbit));

							if (previousPatchState == null || currentPatchState == null)
							{
								continue;
							}

							int patchTickRate = previousPatchState.getTickRate();

							if (isObservedGrowthTick(previousPatchState, currentPatchState))
							{
								Integer storedOffsetPrecision = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.FARM_TICK_OFFSET_PRECISION, int.class);
								Integer storedOffsetMins = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.FARM_TICK_OFFSET, int.class);

								int offsetMins = (int) Math.abs(((Instant.now().getEpochSecond() / 60) % patchTickRate) - patchTickRate);
								log.debug("Observed an exact growth tick. Offset is: {} from a {} minute tick", offsetMins, patchTickRate);

								if (storedOffsetMins != null && storedOffsetMins != 0 && offsetMins != storedOffsetMins % patchTickRate)
								{
									WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
									log.error("Offset error! Observed new offset of {}, previous observed offset was {} ({}) Player Loc:{}", offsetMins, storedOffsetMins, storedOffsetMins % patchTickRate, playerLocation);
								}

								if (storedOffsetPrecision == null || patchTickRate >= storedOffsetPrecision)
								{
									log.debug("Found a longer growth tick {}, saving new offset", patchTickRate);

									configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.FARM_TICK_OFFSET_PRECISION, patchTickRate);
									configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.FARM_TICK_OFFSET, offsetMins);
								}
							}
						}
						else
						{
							log.debug("ignoring growth tick for offset calculation; newRegionLoaded={} timeSinceModalClose={}", newRegionLoaded, timeSinceModalClose);
						}
					}
				}

				String value = strVarbit + ":" + unixNow;
				configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, key, value);
				changed = true;
			}
		}

		//Do one scan after loading a new region before possibly updating tick offsets
		newRegionLoaded = false;
		lastRegions = newRegions;

		if (changed)
		{
			updateCompletionTime();
		}

		return changed;
	}

	private boolean isObservedGrowthTick(PatchState previous, PatchState current)
	{
		//Check the previous state so it will still calculate during the final growth tick
		int patchTickRate = previous.getTickRate();
		CropState previousCropState = previous.getCropState();
		CropState currentCropState = current.getCropState();
		Produce previousProduce = previous.getProduce();

		//Ignore weeds growing or being cleared.
		if (previousProduce == Produce.WEEDS || current.getProduce() == Produce.WEEDS
			|| current.getProduce() != previousProduce
			|| patchTickRate <= 0)
		{
			return false;
		}

		if (previousCropState == CropState.GROWING)
		{
			if ((currentCropState == CropState.GROWING && current.getStage() - previous.getStage() == 1)
				|| currentCropState == CropState.DISEASED)
			{
				log.debug("Found GROWING -> GROWING or GROWING -> DISEASED");
				return true;
			}

			if (currentCropState == CropState.HARVESTABLE && !previousProduce.getPatchImplementation().isHealthCheckRequired())
			{
				log.debug("Found GROWING -> HARVESTABLE");
				return true;
			}
		}

		if (previousCropState == CropState.DISEASED && currentCropState == CropState.DEAD)
		{
			log.debug("Found DISEASED -> DEAD");
			return true;
		}

		return false;
	}

	@Nullable
	public PatchPrediction predictPatch(FarmingPatch patch)
	{
		long unixNow = Instant.now().getEpochSecond();

		boolean autoweed = Integer.toString(Autoweed.ON.ordinal())
			.equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.AUTOWEED));

		boolean botanist = Boolean.TRUE
			.equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.BOTANIST, Boolean.class));

		String key = patch.getRegion().getRegionID() + "." + patch.getVarbit().getId();
		String storedValue = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, key);

		if (storedValue == null)
		{
			return null;
		}

		long unixTime = 0;
		int value = 0;
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
				}
			}
		}

		if (unixTime <= 0)
		{
			return null;
		}

		PatchState state = patch.getImplementation().forVarbitValue(value);

		if (state == null)
		{
			return null;
		}

		int stage = state.getStage();
		int stages = state.getStages();
		int tickrate = state.getTickRate();

		if (autoweed && state.getProduce() == Produce.WEEDS)
		{
			stage = 0;
			stages = 1;
			tickrate = 0;
		}

		if (botanist)
		{
			tickrate /= 5;
		}

		long doneEstimate = 0;
		if (tickrate > 0)
		{
			long tickNow = getTickTime(tickrate, 0, unixNow);
			long tickTime = getTickTime(tickrate, 0, unixTime);
			int delta = (int) (tickNow - tickTime) / (tickrate * 60);

			doneEstimate = getTickTime(tickrate, stages - 1 - stage, tickTime);

			stage += delta;
			if (stage >= stages)
			{
				stage = stages - 1;
			}
		}

		return new PatchPrediction(
			state.getProduce(),
			state.getCropState(),
			doneEstimate,
			stage,
			stages
		);
	}

	public long getTickTime(int tickRate, int ticks)
	{
		return getTickTime(tickRate, ticks, Instant.now().getEpochSecond());
	}

	public long getTickTime(int tickRate, int ticks, long requestedTime)
	{
		Integer offsetPrecisionMins = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.FARM_TICK_OFFSET_PRECISION, int.class);
		Integer offsetTimeMins = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.FARM_TICK_OFFSET, int.class);

		//All offsets are negative but are stored as positive
		long calculatedOffsetTime = 0L;
		if (offsetPrecisionMins != null && offsetTimeMins != null && (offsetPrecisionMins >= tickRate || offsetPrecisionMins >= 40))
		{
			calculatedOffsetTime = (offsetTimeMins % tickRate) * 60;
		}

		//Calculate "now" as +offset seconds in the future so we calculate the correct ticks
		long unixNow = requestedTime + calculatedOffsetTime;

		//The time that the tick requested will happen
		long timeOfCurrentTick = (unixNow - (unixNow % (tickRate * 60)));
		long timeOfGoalTick = timeOfCurrentTick + (ticks * tickRate * 60);

		//Move ourselves back to real time
		return timeOfGoalTick - calculatedOffsetTime;
	}

	public void loadCompletionTimes()
	{
		summaries.clear();
		completionTimes.clear();
		lastRegions = null;
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
				PatchPrediction prediction = predictPatch(patch);
				if (prediction == null || prediction.getProduce().getItemID() < 0)
				{
					continue; // unknown state
				}

				allUnknown = false;

				if (prediction.getProduce() != Produce.WEEDS && prediction.getProduce() != Produce.SCARECROW)
				{
					allEmpty = false;

					// update max duration if this patch takes longer to grow
					maxCompletionTime = Math.max(maxCompletionTime, prediction.getDoneEstimate());
				}
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
