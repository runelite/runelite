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
package net.runelite.client.plugins.farmingtracker;

import java.time.Instant;

public class FarmingTimer
{
	static int getEpochTime()
	{
		return (int) Instant.now().getEpochSecond() - 1475251210;
	}

	static boolean isFarmingTick(int epoch, int farmingTick)
	{
		int[] timeLeft = calculate(epoch, farmingTick, 0);

		return timeLeft[0] == 0 && timeLeft[1] == 0 && timeLeft[2] == 1;
	}

	public static String getGrowthTimeLeft(int epoch, int farmingTick, int stagesLeft)
	{
		int totalGrowthTime = stagesLeft * farmingTick * 60;
		int[] timeLeft = calculate(epoch, farmingTick, totalGrowthTime);

		int hours = timeLeft[0];
		int minutes = timeLeft[1];

		String hour = "";
		if (hours > 0)
		{
			hour = hours + getPlural(hours, " hour") + " and ";
		}

		String minute;
		if (hours == 0 && minutes == 0)
		{
			return "Less than a minute left";
		}
		else
		{
			minute = minutes + getPlural(minutes, " minute");
		}

		return hour + minute + " left";
	}

	private static int[] calculate(int startEpoch, int farmingTick, int growthTime)
	{
		Instant instant = Instant.EPOCH.plusSeconds(growthTime);
		int epoch = startEpoch - (int) instant.getEpochSecond();

		int tick = farmingTick * 60;
		int bigTime = (epoch / tick) * tick + tick - epoch + growthTime;
		int smallTime = bigTime % 3600;

		int hours = bigTime / 3600;
		int minutes = smallTime / 60;
		int seconds = smallTime % 60;

		return new int[]{hours, minutes, seconds};
	}

	private static String getPlural(int value, String word)
	{
		if (value > 1 || value == 0)
		{
			return word + "s";
		}

		return word;
	}
}
