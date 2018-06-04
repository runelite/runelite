package net.runelite.client.plugins.skillcalculator;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "skillCalculator",
		name = "Skill Calculators",
		description = "Skill Calculator Panel configuration")

public interface  SkillCalculatorConfig extends Config
{
	@ConfigItem(
			keyName = "showBankedXp",
			name = "Show Banked xp",
			description = "Shows banked xp assuming all raw skill items are used")
	default boolean showBankedXp()
	{
		return true;
	}
}