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

	@ConfigItem(
		keyName = "FreezeTimers",
		name = "Show Freeze Timers",
		description = "Toggle overlay for Freeze timers",
		position = 3
	)
	default boolean FreezeTimers()
	{
		return true;
	}

	@ConfigItem(
		keyName = "TB",
		name = "Show TB Timers",
		description = "Toggle overlay for TB timers",
		position = 4
	)
	default boolean TB()
	{
		return true;
	}

	@ConfigItem(
		keyName = "Veng",
		name = "Show Veng Timers",
		description = "Toggle overlay for Veng timers",
		position = 5
	)
	default boolean Veng()
	{
		return true;
	}

	@ConfigItem(
		keyName = "noImage",
		name = "Text Timers",
		description = "Remove Images from Timers",
		position = 6
	)
	default boolean noImage()
	{
		return false;
	}
}
