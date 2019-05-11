package net.runelite.client.plugins.dpscounter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("dpscounter")
public interface DpsConfig extends Config
{
	@ConfigItem(
		position = 0,
		name = "Show Damage",
		keyName = "showDamage",
		description = "Show total damage instead of DPS"
	)
	default boolean showDamage()
	{
		return false;
	}
}
