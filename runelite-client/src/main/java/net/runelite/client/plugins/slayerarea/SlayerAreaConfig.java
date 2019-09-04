package net.runelite.client.plugins.slayerarea;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(SlayerAreaPlugin.CONFIG_KEY)
public interface SlayerAreaConfig extends Config
{
	@ConfigItem(
			keyName = "removeSlayerIcons",
			name = "Draw slayer icons",
			description = "Draw slayer area monster icons on map",
			position = 1
	)
	default boolean removeSlayerIcons()
	{
		return true;
	}

	@ConfigItem(
			keyName = "useLockedShader",
			name = "Use locked shader",
			description = "Use a different shader for locked areas",
			position = 2
	)
	default boolean useLockedShader()
	{
		return true;
	}

	@ConfigItem(
			keyName = "drawLockedMap",
			name = "Draw locked map",
			description = "Use a different color for locked areas on the map",
			position = 3
	)
	default boolean drawLockedMap()
	{
		return true;
	}

	@ConfigItem(
			keyName = "drawRegionId",
			name = "Draw region ID",
			description = "Draw the ID for each region on the map",
			position = 4
	)
	default boolean drawRegionId()
	{
		return true;
	}
}
