/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import static java.lang.Math.floor;
import static java.lang.Math.max;

public class Experience
{
	/**
	 * Maximum level under 200m xp
	 */
	public static final int MAX_VIRT_LEVEL = 126;

	private static final int[] XP_FOR_LEVEL = new int[MAX_VIRT_LEVEL];

	static
	{
		int xp = 0;

		for (int level = 1; level <= MAX_VIRT_LEVEL; ++level)
		{
			XP_FOR_LEVEL[level - 1] = xp / 4;

			int difference = (int) ((double) level + 300.0 * Math.pow(2.0, (double) level / 7.0));
			xp += difference;
		}
	}

	public static int getXpForLevel(int level)
	{
		if (level < 1 || level > MAX_VIRT_LEVEL)
		{
			throw new IllegalArgumentException(level + " is not a valid level");
		}

		// XP_FOR_LEVEL[0] is XP for level 1
		return XP_FOR_LEVEL[level - 1];
	}

	public static int getLevelForXp(int xp)
	{
		if (xp < 0)
		{
			throw new IllegalArgumentException("XP must not be negative");
		}

		int low = 0;
		int high = XP_FOR_LEVEL.length - 1;

		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			int xpForLevel = XP_FOR_LEVEL[mid];

			if (xp < xpForLevel)
			{
				high = mid - 1;
			}
			else if (xp > xpForLevel)
			{
				low = mid + 1;
			}
			else
			{
				return mid + 1;
			}
		}

		return high + 1;
	}

	public static double getCombatLevelPrecise(int attackLevel, int strengthLevel,
		int defenceLevel, int hitpointsLevel, int magicLevel,
		int rangeLevel, int prayerLevel)
	{
		double base = 0.25 * (defenceLevel + hitpointsLevel + floor(prayerLevel / 2));

		double melee = 0.325 * (attackLevel + strengthLevel);
		double range = 0.325 * (floor(rangeLevel / 2) + rangeLevel);
		double magic = 0.325 * (floor(magicLevel / 2) + magicLevel);

		return base + max(melee, max(range, magic));
	}

	public static int getCombatLevel(int attackLevel, int strengthLevel,
		int defenceLevel, int hitpointsLevel, int magicLevel,
		int rangeLevel, int prayerLevel)
	{
		return (int) getCombatLevelPrecise(attackLevel, strengthLevel, defenceLevel, hitpointsLevel, magicLevel, rangeLevel, prayerLevel);
	}
}
