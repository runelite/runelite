package net.runelite.client.plugins.raids.shortcuts;

import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("shortcut")
public interface ShortcutConfig
{
	@ConfigItem(
		keyName = "highlightShortcuts",
		name = "Highlight shortcuts",
		description = "Displays which shortcut it is"
	)
	default boolean highlightShortcuts()
	{
		return true;
	}
}
