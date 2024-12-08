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

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Singleton;
import java.time.Instant;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.WidgetNode;
import net.runelite.api.WorldType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.WidgetModalMode;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneScapeProfile;
import net.runelite.client.config.RuneScapeProfileType;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.SummaryState;
import net.runelite.client.plugins.timetracking.Tab;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.util.Text;

@Slf4j
@Singleton
@RequiredArgsConstructor(
	access = AccessLevel.PRIVATE,
	onConstructor = @__({@Inject})
)
public class FarmingTracker
{
	private final Client client;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final TimeTrackingConfig config;
	private final FarmingWorld farmingWorld;
	private final Notifier notifier;
	private final CompostTracker compostTracker;
	private final PaymentTracker paymentTracker;

	private final Map<Tab, SummaryState> summaries = new EnumMap<>(Tab.class);

	/**
	 * The time at which all patches of a particular type will be ready to be harvested,
	 * or {@code -1} if we have no data about any patch of the given type.
	 */
	private final Map<Tab, Long> completionTimes = new EnumMap<>(Tab.class);
	Map<ProfilePatch, Boolean> wasNotified = new HashMap<>();

	private boolean newRegionLoaded;
	private Collection<FarmingRegion> lastRegions;
	private boolean firstNotifyCheck = true;

	public FarmingTabPanel createTabPanel(Tab tab, FarmingContractManager farmingContractManager)
	{
		return new FarmingTabPanel(this, compostTracker, paymentTracker, itemManager, configManager, config, farmingWorld.getTabs().get(tab), farmingContractManager);
	}

	/**
	 * Updates tracker data for the current region. Returns true if any data was changed.
	 */
	public boolean updateData(WorldPoint location, int timeSinceModalClose)
	{
		boolean changed = false;

		//Varbits don't get sent when a modal widget is open so just return
		for (WidgetNode widgetNode : client.getComponentTable())
		{
			if (widgetNode.getModalMode() != WidgetModalMode.NON_MODAL)
			{
				return false;
			}
		}

		{
			String autoweed = Integer.toString(client.getVarbitValue(Varbits.AUTOWEED));
			if (!autoweed.equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.AUTOWEED)))
			{
				configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, TimeTrackingConfig.AUTOWEED, autoweed);
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
				int varbit = patch.getVarbit();
				String key = patch.configKey();
				String strVarbit = Integer.toString(client.getVarbitValue(varbit));
				String storedValue = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, key);

				PatchState currentPatchState = patch.getImplementation().forVarbitValue(client.getVarbitValue(varbit));
				if (currentPatchState == null)
				{
					continue;
				}

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

							if (previousPatchState == null)
							{
								continue;
							}

							int patchTickRate = previousPatchState.getTickRate();

							// Farming ticks on leagues worlds are 1 minute instead of 5
							if (isLeaguesWorld())
							{
								patchTickRate = patchTickRate / 5;
							}

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
							if (currentPatchState.getTickRate() != 0
								// Don't set wasNotified to false if witnessing a check-health action
								&& !(previousPatchState.getCropState() == CropState.GROWING && currentPatchState.getCropState() == CropState.HARVESTABLE && currentPatchState.getProduce().getPatchImplementation().isHealthCheckRequired()))
							{
								wasNotified.put(new ProfilePatch(patch, configManager.getRSProfileKey()), false);
							}
						}
						else
						{
							log.debug("ignoring growth tick for offset calculation; newRegionLoaded={} timeSinceModalClose={}", newRegionLoaded, timeSinceModalClose);
						}
					}
				}

				if (currentPatchState.getCropState() == CropState.DEAD ||
					currentPatchState.getCropState() == CropState.HARVESTABLE ||
					currentPatchState.getCropState() == CropState.EMPTY)
				{
					compostTracker.setCompostState(patch, null);
					paymentTracker.setProtectedState(patch, false);
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

		// Farming ticks on leagues worlds are 1 minute instead of 5
		if (isLeaguesWorld())
		{
			patchTickRate = patchTickRate / 5;
		}

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
		return predictPatch(patch, configManager.getRSProfileKey());
	}

	@Nullable
	public PatchPrediction predictPatch(FarmingPatch patch, String profile)
	{
		long unixNow = Instant.now().getEpochSecond();

		boolean autoweed = Integer.toString(Autoweed.ON.ordinal())
			.equals(configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, profile, TimeTrackingConfig.AUTOWEED));

		String key = patch.configKey();
		String storedValue = configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, profile, key);

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

		// Farming ticks on leagues worlds are 1 minute instead of 5
		if (isLeaguesWorld())
		{
			tickrate = tickrate / 5;
		}

		if (autoweed && state.getProduce() == Produce.WEEDS)
		{
			stage = 0;
			stages = 1;
			tickrate = 0;
		}

		long doneEstimate = 0;
		if (tickrate > 0)
		{
			long tickNow = getTickTime(tickrate, 0, unixNow, profile);
			long tickTime = getTickTime(tickrate, 0, unixTime, profile);
			int delta = (int) (tickNow - tickTime) / (tickrate * 60);

			doneEstimate = getTickTime(tickrate, stages - 1 - stage, tickTime, profile);

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
		return getTickTime(tickRate, ticks, Instant.now().getEpochSecond(), configManager.getRSProfileKey());
	}

	public long getTickTime(int tickRate, int ticks, long requestedTime, String profile)
	{
		Integer offsetPrecisionMins = configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, profile, TimeTrackingConfig.FARM_TICK_OFFSET_PRECISION, int.class);
		Integer offsetTimeMins = configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, profile, TimeTrackingConfig.FARM_TICK_OFFSET, int.class);

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
			long extremumCompletionTime = config.preferSoonest() ? Long.MAX_VALUE : 0;
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
					if (config.preferSoonest())
					{
						extremumCompletionTime = Math.min(extremumCompletionTime, prediction.getDoneEstimate());
					}
					else
					{
						extremumCompletionTime = Math.max(extremumCompletionTime, prediction.getDoneEstimate());
					}

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
			else if (extremumCompletionTime <= Instant.now().getEpochSecond())
			{
				state = SummaryState.COMPLETED;
				completionTime = 0;
			}
			else
			{
				state = SummaryState.IN_PROGRESS;
				completionTime = extremumCompletionTime;
			}
			summaries.put(tab.getKey(), state);
			completionTimes.put(tab.getKey(), completionTime);
		}
	}

	public void checkCompletion()
	{
		List<RuneScapeProfile> rsProfiles = configManager.getRSProfiles();
		long unixNow = Instant.now().getEpochSecond();

		for (RuneScapeProfile profile : rsProfiles)
		{
			Integer offsetPrecisionMins = configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, profile.getKey(), TimeTrackingConfig.FARM_TICK_OFFSET_PRECISION, int.class);
			Integer offsetTimeMins = configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, profile.getKey(), TimeTrackingConfig.FARM_TICK_OFFSET, int.class);

			for (Map.Entry<Tab, Set<FarmingPatch>> tab : farmingWorld.getTabs().entrySet())
			{
				for (FarmingPatch patch : tab.getValue())
				{
					ProfilePatch profilePatch = new ProfilePatch(patch, profile.getKey());
					boolean patchNotified = wasNotified.getOrDefault(profilePatch, false);
					String configKey = patch.notifyConfigKey();
					boolean shouldNotify = Boolean.TRUE
						.equals(configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, profile.getKey(), configKey, Boolean.class));
					PatchPrediction prediction = predictPatch(patch, profile.getKey());

					if (prediction == null)
					{
						continue;
					}

					int tickRate = prediction.getProduce().getTickrate();

					// Farming ticks on leagues worlds are 1 minute instead of 5
					if (isLeaguesWorld())
					{
						tickRate = tickRate / 5;
					}

					if (offsetPrecisionMins == null || offsetTimeMins == null || (offsetPrecisionMins < tickRate && offsetPrecisionMins < 40) || prediction.getProduce() == Produce.WEEDS
						|| unixNow <= prediction.getDoneEstimate() || patchNotified || prediction.getCropState() == CropState.FILLING || prediction.getCropState() == CropState.EMPTY)
					{
						continue;
					}

					wasNotified.put(profilePatch, true);

					if (!firstNotifyCheck && shouldNotify)
					{
						sendNotification(profile, prediction, patch);
					}
				}
			}
		}
		firstNotifyCheck = false;
	}

	private boolean isLeaguesWorld()
	{
		final EnumSet<WorldType> worldTypes = client.getWorldType();
		return (worldTypes.contains(WorldType.SEASONAL) && !worldTypes.contains(WorldType.DEADMAN));
	}

	@VisibleForTesting
	void sendNotification(RuneScapeProfile profile, PatchPrediction prediction, FarmingPatch patch)
	{
		final RuneScapeProfileType profileType = profile.getType();

		final StringBuilder stringBuilder = new StringBuilder();
		// Same RS account
		if (client.getGameState() == GameState.LOGGED_IN && profile.getDisplayName().equals(client.getLocalPlayer().getName()))
		{
			// Same RS account but different profile type
			if (profileType != RuneScapeProfileType.getCurrent(client))
			{
				stringBuilder.append('(')
					.append(Text.titleCase(profile.getType()))
					.append(") ");
			}
			// Same RS account AND profile falls through here so no bracketed prefix is added
		}
		else
		{
			// Different RS account AND profile type
			if (profileType != RuneScapeProfileType.getCurrent(client) || client.getGameState() == GameState.LOGIN_SCREEN)
			{
				//Don't print profile type when logged out if is STANDARD
				if (client.getGameState() == GameState.LOGIN_SCREEN && profileType == RuneScapeProfileType.STANDARD)
				{
					stringBuilder.append('(')
						.append(profile.getDisplayName())
						.append(") ");
				}
				else
				{
					stringBuilder.append('(')
						.append(profile.getDisplayName())
						.append(" - ")
						.append(Text.titleCase(profile.getType()))
						.append(") ");
				}
			}
			// Different RS account but same profile type
			else
			{
				stringBuilder.append('(')
					.append(profile.getDisplayName())
					.append(") ");
			}
		}

		stringBuilder
			.append("Your ")
			.append(prediction.getProduce().getName());

		switch (prediction.getCropState())
		{
			case HARVESTABLE:
			case GROWING:
				if (prediction.getProduce().getName().toLowerCase(Locale.ENGLISH).contains("compost"))
				{
					stringBuilder.append(" is ready to collect in ");
				}
				else
				{
					stringBuilder.append(" is ready to harvest in ");
				}
				break;
			case DISEASED:
				stringBuilder.append(" has become diseased in ");
				break;
			case DEAD:
				stringBuilder.append(" has died in ");
				break;
			default:
				// EMPTY and FILLING are caught above
				throw new IllegalStateException();
		}

		stringBuilder.append(patch.getRegion().isDefinite() ? "the " : "")
			.append(patch.getRegion().getName())
			.append('.');

		notifier.notify(stringBuilder.toString());
	}
}
