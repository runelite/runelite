/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.dynamicmaxhit;

import net.runelite.api.Player;
import net.runelite.api.Prayer;

class Utils
{
	static Prayer iconToPrayer(Player player)
	{
		if (player.getOverheadIcon() != null)
		{
			switch (player.getOverheadIcon())
			{
				case RANGED:
					return Prayer.PROTECT_FROM_MISSILES;
				case MAGIC:
					return Prayer.PROTECT_FROM_MAGIC;
				case MELEE:
					return Prayer.PROTECT_FROM_MELEE;
				case SMITE:
					return Prayer.SMITE;
				case REDEMPTION:
					return Prayer.REDEMPTION;
				case RETRIBUTION:
					return Prayer.RETRIBUTION;
				default:
					return null;
			}
		}
		return null;
	}

	static Prayer predictOffensivePrayer(int prayerLevel, AttackStyle attackStyle)
	{
		switch (attackStyle)
		{
			case MELEE:
				if (prayerLevel <= 12 && prayerLevel >= 1)
				{
					return Prayer.BURST_OF_STRENGTH;
				}
				else if (prayerLevel <= 30 && prayerLevel >= 13)
				{
					return Prayer.SUPERHUMAN_STRENGTH;
				}
				else if (prayerLevel <= 59 && prayerLevel >= 31)
				{
					return Prayer.ULTIMATE_STRENGTH;
				}
				else if (prayerLevel <= 69 && prayerLevel >= 60)
				{
					return Prayer.CHIVALRY;
				}
				else if (prayerLevel >= 70)
				{
					return Prayer.PIETY;
				}
			case RANGE:
				if (prayerLevel <= 25 && prayerLevel >= 8)
				{
					return Prayer.SHARP_EYE;
				}
				else if (prayerLevel <= 43 && prayerLevel >= 26)
				{
					return Prayer.HAWK_EYE;
				}
				else if (prayerLevel <= 73 && prayerLevel >= 44)
				{
					return Prayer.EAGLE_EYE;
				}
				else if (prayerLevel >= 74)
				{
					return Prayer.RIGOUR;
				}
			case MAGE:
				if (prayerLevel <= 26 && prayerLevel >= 9)
				{
					return Prayer.MYSTIC_WILL;
				}
				else if (prayerLevel <= 44 && prayerLevel >= 27)
				{
					return Prayer.MYSTIC_LORE;
				}
				else if (prayerLevel <= 76 && prayerLevel >= 45)
				{
					return Prayer.MYSTIC_MIGHT;
				}
				else if (prayerLevel >= 77)
				{
					return Prayer.AUGURY;
				}
			default:
				return null;
		}
	}

	static int getTrueHp(Player player, int hitpoints)
	{
		int scale = player.getHealth();
		int ratio = player.getHealthRatio();

		if (hitpoints == -1)
		{
			return -1;
		}

		if (ratio > 0)
		{
			int minHealth = 1;
			int maxHealth;
			if (scale > 1)
			{
				if (ratio > 1)
				{
					minHealth = (hitpoints * (ratio - 1) + scale - 2) / (scale - 1);
				}

				maxHealth = (hitpoints * ratio - 1) / (scale - 1);

				if (maxHealth > hitpoints)
				{
					maxHealth = hitpoints;
				}
			}
			else
			{
				maxHealth = hitpoints;
			}
			return (minHealth + maxHealth + 1) / 2;
		}
		return -1;
	}
}
