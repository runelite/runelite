/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
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
package net.runelite.client.plugins.timetracking.hunter;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.SummaryState;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;

@Singleton
public class BirdHouseTracker
{
	// average time taken to harvest 10 birds, in seconds
	static final int BIRD_HOUSE_DURATION = (int) Duration.ofMinutes(50).getSeconds();

	private static final ImmutableSet<Integer> FOSSIL_ISLAND_REGIONS = ImmutableSet.of(14650, 14651, 14652, 14906, 14907, 15162, 15163);

	private final Client client;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final TimeTrackingConfig config;
	private final Notifier notifier;

	@Getter(AccessLevel.PACKAGE)
	private final ConcurrentMap<BirdHouseSpace, BirdHouseData> birdHouseData = new ConcurrentHashMap<>();

	@Getter
	private SummaryState summary = SummaryState.UNKNOWN;

	/**
	 * The time at which all the bird houses will be ready to be dismantled,
	 * or {@code -1} if we have no data about any of the bird house spaces.
	 */
	@Getter
	private long completionTime = -1;

	@Inject
	private BirdHouseTracker(Client client, ItemManager itemManager, ConfigManager configManager,
							TimeTrackingConfig config, Notifier notifier)
	{
		this.client = client;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.config = config;
		this.notifier = notifier;
	}

	public BirdHouseTabPanel createBirdHouseTabPanel()
	{
		return new BirdHouseTabPanel(itemManager, this, config);
	}

	public void loadFromConfig()
	{
		birdHouseData.clear();

		final String group = TimeTrackingConfig.CONFIG_GROUP + "." + client.getUsername() + "." + TimeTrackingConfig.BIRD_HOUSE;

		for (BirdHouseSpace space : BirdHouseSpace.values())
		{
			String key = Integer.toString(space.getVarp().getId());
			String storedValue = configManager.getConfiguration(group, key);

			if (storedValue != null)
			{
				String[] parts = storedValue.split(":");
				if (parts.length == 2)
				{
					try
					{
						int varp = Integer.parseInt(parts[0]);
						long timestamp = Long.parseLong(parts[1]);
						birdHouseData.put(space, new BirdHouseData(space, varp, timestamp));
					}
					catch (NumberFormatException e)
					{
						// ignored
					}
				}
			}
		}

		updateCompletionTime();
	}

	/**
	 * Updates tracker data if player is within range of any bird house. Returns true if any data was changed.
	 */
	public boolean updateData(WorldPoint location)
	{
		boolean changed = false;

		if (FOSSIL_ISLAND_REGIONS.contains(location.getRegionID()) && location.getPlane() == 0)
		{
			final Map<BirdHouseSpace, BirdHouseData> newData = new HashMap<>();
			final long currentTime = Instant.now().getEpochSecond();
			int removalCount = 0;

			for (BirdHouseSpace space : BirdHouseSpace.values())
			{
				int varp = client.getVar(space.getVarp());
				BirdHouseData oldData = birdHouseData.get(space);
				int oldVarp = oldData == null ? -1 : oldData.getVarp();

				// update data if there isn't one, or if the varp doesn't match
				if (varp != oldVarp)
				{
					newData.put(space, new BirdHouseData(space, varp, currentTime));
					changed = true;
				}

				if (varp <= 0 && oldVarp > 0)
				{
					removalCount++;
				}
			}

			// Prevent the resetting of bird house data that could occur if the varps have not been updated yet
			// after the player enters the region. We assume that players would generally have 3 or 4 bird houses
			// built at any time, and that dropping from 3/4 to 0 built bird houses is not normally possible.
			if (removalCount > 2)
			{
				return false;
			}

			if (changed)
			{
				birdHouseData.putAll(newData);
				updateCompletionTime();
				saveToConfig(newData);
			}
		}

		return changed;
	}

	/**
	 * Checks if the bird houses have become ready to be dismantled,
	 * and sends a notification if required.
	 */
	public boolean checkCompletion()
	{
		if (summary == SummaryState.IN_PROGRESS && completionTime < Instant.now().getEpochSecond())
		{
			summary = SummaryState.COMPLETED;
			completionTime = 0;

			if (config.birdHouseNotification())
			{
				notifier.notify("Your bird houses are ready to be dismantled.");
			}

			return true;
		}

		return false;
	}

	/**
	 * Updates the overall completion time of the bird houses.
	 *
	 * @see #completionTime
	 */
	private void updateCompletionTime()
	{
		if (birdHouseData.isEmpty())
		{
			summary = SummaryState.UNKNOWN;
			completionTime = -1;
			return;
		}

		boolean allEmpty = true;
		long maxCompletionTime = 0;
		for (BirdHouseData data : birdHouseData.values())
		{
			final BirdHouseState state = BirdHouseState.fromVarpValue(data.getVarp());

			if (state != BirdHouseState.EMPTY)
			{
				allEmpty = false;
			}

			if (state == BirdHouseState.SEEDED)
			{
				maxCompletionTime = Math.max(maxCompletionTime, data.getTimestamp() + BIRD_HOUSE_DURATION);
			}
		}

		if (allEmpty)
		{
			summary = SummaryState.EMPTY;
			completionTime = 0;
		}
		else if (maxCompletionTime <= Instant.now().getEpochSecond())
		{
			summary = SummaryState.COMPLETED;
			completionTime = 0;
		}
		else
		{
			summary = SummaryState.IN_PROGRESS;
			completionTime = maxCompletionTime;
		}
	}

	private void saveToConfig(Map<BirdHouseSpace, BirdHouseData> updatedData)
	{
		final String group = TimeTrackingConfig.CONFIG_GROUP + "." + client.getUsername() + "." + TimeTrackingConfig.BIRD_HOUSE;

		for (BirdHouseData data : updatedData.values())
		{
			String key = Integer.toString(data.getSpace().getVarp().getId());
			configManager.setConfiguration(group, key, data.getVarp() + ":" + data.getTimestamp());
		}
	}
}
