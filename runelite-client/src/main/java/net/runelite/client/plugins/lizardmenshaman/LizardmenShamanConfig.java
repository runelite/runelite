package net.runelite.client.plugins.lizardmenshaman;

import net.runelite.client.config.Config;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("shaman")
public interface LizardmenShamanConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "showTimer",
			name = "Show timer",
			description = "Display timer till for lizardman shaman spawns."
	)
	default boolean showTimer()
	{
		return true;
	}

	@ConfigItem(
			position = 2,
			keyName = "notifyOnSpawn",
			name = "Notify on spawn",
			description = "Notify user when lizardman summons spawns."
	)
	default boolean notifyOnSpawn()
	{
		return true;
	}
}
