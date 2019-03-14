package net.runelite.client.plugins.combatRange;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("combatRange")
public interface combatRangeConfig extends Config
{
		@ConfigItem(
			position = 1,
			keyName = "enablePlugin",
			name = "Enable Combat Range",
			description = "Shows the combat range that can attack you in the wilderness."
		)
		default boolean enablePlugin()
		{
			return true;
		}


}
