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
		BOS("Burst of Strength"),
		SS("Superhuman Strength"),
		US("Ultimate Strength"),
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
		SE("Sharp Eye"),
		HE("Hawk Eye"),
		EE("Eagle Eye"),
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
		keyName = "potion",
		name = "Stat Boost",
		description = "Simulates drinking a ranging and super strength potion, and using imbued hearth"
	)
	default boolean potion()
	{
		return false;
	}

}