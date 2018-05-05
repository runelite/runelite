/*
 * Copyright (c) 2018, magic fTail
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
package net.runelite.client.plugins.maxhit;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "maxhitplugin",
	name = "Max Hit Calculator",
	description = "Configure boosts for Max Hit"
)

public interface MaxHitConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "meleePrayer",
		name = "Melee Prayer",
		description = "Choose active prayer when calculating max hit"
	)
	default meleePrayer meleeprayer()
	{
		return meleePrayer.DEFAULT;
	}

	enum meleePrayer
	{
		DEFAULT("No Prayer"),
		BURST_OF_STRENGTH("Burst of Strength"),
		SUPERHUMAN_STRENGTH("Superhuman Strength"),
		ULTIMATE_STRENGTH("Ultimate Strength"),
		CHIVALRY("Chivalry"),
		PIETY("Piety");

		private final String name;

		meleePrayer(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}

		public boolean isSet()
		{
			return this != DEFAULT;
		}
	}

	@ConfigItem(
		position = 2,
		keyName = "rangedPrayer",
		name = "Ranged Prayer",
		description = "Choose active prayer when calculating max hit"
	)
	default rangedPrayer rangedprayer()
	{
		return rangedPrayer.DEFAULT;
	}

	enum rangedPrayer
	{
		DEFAULT("No Prayer"),
		SHARP_EYE("Sharp Eye"),
		HAWK_EYE("Hawk Eye"),
		EAGLE_EYE("Eagle Eye"),
		RIGOUR("Rigour");

		private final String name;

		rangedPrayer(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return name;
		}

		public boolean isSet()
		{
			return this != DEFAULT;
		}
	}

	@ConfigItem(
		position = 3,
		keyName = "statBoost",
		name = "Stat Boost",
		description = "Simulates drinking a ranging and super strength potion, and using imbued hearth"
	)
	default boolean potion()
	{
		return false;
	}

}