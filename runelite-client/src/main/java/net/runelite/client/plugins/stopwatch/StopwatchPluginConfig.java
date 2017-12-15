package net.runelite.client.plugins.stopwatch;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
        keyName = "stopwatch",
        name = "Stopwatch",
        description = "Configuration for the stopwatch plugin"
)
public interface StopwatchPluginConfig extends Config
{
	@ConfigItem(
		keyName = "enabled",
		name = "Enabled",
		description = "Configuration for toggling the plugin",
		position = 0
	)
	default boolean enabled()
	{
		return true;
	}

	@ConfigItem(
		keyName = "ingameOnly",
		name = "Ingame Time Only",
		description = "Configuration for ingame time only",
		position = 1
	)
	default boolean ingameOnly()
	{
		return true;
	}
}
