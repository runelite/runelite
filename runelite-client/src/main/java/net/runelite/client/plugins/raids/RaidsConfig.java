package net.runelite.client.plugins.raids;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "raids",
		name = "Raids",
		description = "Configuration for the raids plugin"
)
public interface RaidsConfig extends Config
{
	@ConfigItem(
			keyName = "enabled",
			name = "Enable",
			description = "Configures whether or not the raids plugin is enabled"
	)
	default boolean enabled()
	{
		return true;
	}

	@ConfigItem(
			keyName = "pointsMessage",
			name = "Display points in chatbox after raid",
			description = "Display a message with total points, individual points and percentage at the end of a raid"
	)
	default boolean pointsMessage()
	{
		return true;
	}
}
