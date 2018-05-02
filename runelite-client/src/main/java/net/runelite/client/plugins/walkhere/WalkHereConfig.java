package net.runelite.client.plugins.walkhere;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "walkhere",
	name = "Walk here always",
	description = "Makes walk here the default left click while holding a hotkey."
)
public interface WalkHereConfig extends Config
{

	@ConfigItem(
		position = 0,
		keyName = "hotkey",
		name = "Hotkey",
		description = "Which hotkey that needs to pressed to change to only walk here"
	)
	default WalkHereHotkey hotkey()
	{
		return WalkHereHotkey.ALT;
	}
}
