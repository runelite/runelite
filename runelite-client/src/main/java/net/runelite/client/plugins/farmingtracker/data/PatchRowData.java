/*
 * Copyright (c) 2018, NotFoxtrot <https://github.com/NotFoxtrot>
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
package net.runelite.client.plugins.farmingtracker.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.farmingtracker.FarmingTimer;

@Slf4j
@Data
@AllArgsConstructor
public class PatchRowData
{
	private Seed seed;
	private SeedStatus seedStatus;
	private int currentStage;
	private String timeLeft;

	public void applyFarmingTick()
	{
		if (!seedStatus.equals(SeedStatus.ALIVE))
		{
			return;
		}

		if (currentStage == seed.getTotalStages())
		{
			seedStatus = SeedStatus.FINISHED;
			timeLeft = seedStatus.getStageName();
		}
		else if (currentStage < seed.getTotalStages())
		{
			currentStage++;
		}
	}

	public int getStagesLeft()
	{
		return seed.getTotalStages() - currentStage;
	}

	public String objectToConfigString(int timePlanted)
	{
		return seed.name() + "," + seedStatus.name() + "," + timePlanted;
	}

	public static PatchRowData configStringToObject(String configValue)
	{
		String[] values = configValue.split(",");

		if (values.length != 3)
		{
			log.warn("The config values are incomplete {}", configValue);
			return null;
		}

		Seed seed = getEnumFromString(Seed.class, values[0]);
		SeedStatus seedStatus = getEnumFromString(SeedStatus.class, values[1]);

		if (seed == null || seedStatus == null)
		{
			return null;
		}

		int stage;
		String timeLeft = "Calculating...";

		if (seedStatus.equals(SeedStatus.FINISHED))
		{
			stage = seed.getTotalStages();
			timeLeft = SeedStatus.FINISHED.getStageName();
		}
		else
		{
			stage = calculateCurrentStage(Integer.parseInt(values[2]), seed);

			if (stage == seed.getTotalStages())
			{
				seedStatus = SeedStatus.FINISHED;
				timeLeft = SeedStatus.FINISHED.getStageName();
			}
		}

		return new PatchRowData(seed, seedStatus, stage, timeLeft);
	}

	private static int calculateCurrentStage(int plantedEpoch, Seed seed)
	{
		int timePerTick = seed.getFarmingTick().getTick() * 60;
		int timeElapsedSincePlanting = (FarmingTimer.getEpochTime() - plantedEpoch) + (plantedEpoch % timePerTick);
		int farmingTicksPassed = (timeElapsedSincePlanting / timePerTick) + 1;

		if (farmingTicksPassed >= seed.getTotalStages())
		{
			return seed.getTotalStages();
		}

		return farmingTicksPassed;
	}

	private static <T extends Enum<T>> T getEnumFromString(Class<T> enumClass, String enumName)
	{
		if (enumClass != null && enumName != null)
		{
			try
			{
				return Enum.valueOf(enumClass, enumName.trim().toUpperCase());
			}
			catch (IllegalArgumentException ex)
			{
				log.warn("Unable to convert the string {} to the enum {}. Error: {}", enumName, enumClass, ex);
			}
		}

		return null;
	}
}
