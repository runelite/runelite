package net.runelite.client.plugins.freezetimers;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("freezetimers")
public interface FreezeTimersConfig extends Config
{
	
	@ConfigItem(
			keyName = "showOverlay",
			name = "Show Players",
			description = "Configure if the player overlay should be shown",
			position = 1
	)
	default boolean showPlayers()
	{
		return true;
	}
	
	@ConfigItem(
			keyName = "showNpcs",
			name = "Show NPCs",
			description = "Configure if the npc overlay should be shown",
			position = 2
	)
	default boolean showNpcs()
	{
		return false;
	}
}
