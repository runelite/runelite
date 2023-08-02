/*
 * Copyright (c) 2023, Moshe Ben-Zacharia <moshebenzacharia@gmail.com>
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
package net.runelite.client.plugins.timetracking.farming;

import java.time.Instant;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__({@Inject}))
@Singleton
public class GeomancyManager
{
	private final Client client;
	private final ConfigManager configManager;
	private final FarmingWorld farmingWorld;
	private final TimeTrackingConfig config;
	private final PaymentTracker paymentTracker;
	private final CompostTracker compostTracker;
	private final FarmingTracker farmingTracker;

	@Inject
	private Notifier notifier;
	private boolean isDirty;
	private boolean enableVerboseLogging = false;

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired)
	{
		if (scriptPreFired.getScriptId() == 1119)
		{
			//args[0] is script ID
			Object[] args = scriptPreFired.getScriptEvent().getArguments();
			int jagexPatchID = (int) args[1];
			int cropItemID = (int) args[2];
			int coords = (int) args[3];
			int flags = (int) args[4];

			GeomancyData data = new GeomancyData(coords);

			FarmingPatch fp = farmingWorld.getPatchByJagexID(jagexPatchID);
			if (fp == null)
			{
				log.warn("Couldn't find farming patch to match Jagex patch ID {}", jagexPatchID);
				return;
			}

			//Protection
			boolean gardenerProtection = testBit(flags, 2);
			boolean flowerProtection = testBit(flags, 3);
			boolean hosidiusProtection = testBit(flags, 8);
			boolean isProtected = gardenerProtection || flowerProtection || hosidiusProtection;
			boolean wasProtected = paymentTracker.getProtectedState(fp);
			if (wasProtected != isProtected)
			{
				isDirty = true;
				paymentTracker.setProtectedState(fp, isProtected);
			}

			//Compost
			CompostState compostState = null;
			if (testBit(flags, 7))
			{
				compostState = CompostState.ULTRACOMPOST;
			}
			else if (testBit(flags, 6))
			{
				compostState = CompostState.SUPERCOMPOST;
			}
			else if (testBit(flags, 5))
			{
				compostState = CompostState.COMPOST;
			}
			CompostState previousCompostState = compostTracker.getCompostState(fp);
			if (previousCompostState != compostState)
			{
				isDirty = true;
				compostTracker.setCompostState(fp, compostState);
			}

			//Compost bins have very different states so let's not try to update them via Geomancy
			if (fp.getImplementation() == PatchImplementation.COMPOST || fp.getImplementation() == PatchImplementation.GIANT_COMPOST)
			{
				return;
			}

			//Patch State
			PatchState patchState = FarmingTracker.GeneratePatchState(cropItemID, data.currentStage, data.maxStage, flags);
			String storedValue = configManager.getConfiguration(TimeTrackingConfig.CONFIG_GROUP, configManager.getRSProfileKey(), fp.configKey());
			PatchState previousPatchState = null;
			if (storedValue != null)
			{
				previousPatchState = farmingTracker.convertStoredValueToPatchStateAndTime(fp, storedValue).patchState;
			}
			//Don't overwrite stage when it was already harvestable since we don't get data on harvest stages via Geomancy
			if (previousPatchState != null && previousPatchState.getCropState() == CropState.HARVESTABLE && patchState.getCropState() == CropState.HARVESTABLE)
			{
				patchState = new PatchState(patchState.getProduce(), patchState.getCropState(), previousPatchState.getStage());
			}
			if (previousPatchState == null || !previousPatchState.equals(patchState))
			{
				if (enableVerboseLogging)
				{
					log.info("Found difference, overwriting patch state.\nOld State: " + previousPatchState + " \n New State:" + patchState);
				}
				if (patchState.getCropState() == CropState.DISEASED && config.notifyOnDisease())
				{
					StringBuilder stringBuilder = new StringBuilder();
					farmingTracker.AppendCropInfo(stringBuilder, patchState.getCropState(), patchState.getProduce(), fp);
					notifier.notify(stringBuilder.toString());
				}
				isDirty = true;
				farmingTracker.loadCompletionTimes();
				long unixNow = Instant.now().getEpochSecond();
				String value = jagexPatchID + ":" + cropItemID + ":" + flags + ":" + coords + ":" + unixNow;
				configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, fp.configKey(), value);
			}
		}
	}

	public boolean hasDataChanged()
	{
		if (isDirty)
		{
			isDirty = false;
			return true;
		}
		return false;
	}

	static boolean testBit(int value, int position)
	{
		int mask = 1 << position;
		return (value & mask) != 0;
	}
}
