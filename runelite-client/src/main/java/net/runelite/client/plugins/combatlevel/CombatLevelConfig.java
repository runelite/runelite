package net.runelite.client.plugins.combatlevel;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "combatLevel",
	name = "Combat Level",
	description = "Configure the combat level plugin"
)
public interface CombatLevelConfig extends Config
{
	@ConfigItem(
		keyName = "showLevelsUntil",
		name = "Calculate next level",
		description = "Mouse over the combat level when activated to show how many levels until the next combat level"
	)
	default boolean showLevelsUntil()
	{
		return false;
	}
}
