package net.runelite.client.plugins.wiki;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("wiki")
public interface WikiConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "orbEnable",
		name = "Enable Wiki Minimap Orb",
		description = "Enable the Wiki Minimap Orb to appear"
	)
	default boolean orbEnable()
	{
		return true;
	}
}
