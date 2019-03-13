package net.runelite.client.plugins.windowsnap;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("windowsnap")
public interface WindowSnapConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "enableMouseSnap",
			name = "Mouse Drag Snaps Window",
			description = "The window will snap to the side of the screen with the mouse")
	default boolean mouseEnabled()
	{
		return true;
	}

	@ConfigItem(
			position = 2,
			keyName = "enableKeySnap",
			name = "Keyboard Shortcut Snaps Window",
			description = "The window will snap to the side of the screen with keyboard shortcut")
	default boolean keyboardShortcutEnabled()
	{
		return true;
	}

	@ConfigItem(
			position = 3,
			keyName = "enableCustomSize",
			name = "Enable Custom Size",
			description = "Client will change to this dimension when enabled")
	default boolean enableCustomSize()
	{
		return false;
	}

	@Range(
			min = 773
	)
	@ConfigItem(
			position = 4,
			keyName = "customSizeWidth",
			name = "Custom Snap Width",
			description = "Size client will change to when snapped")
	default int customWidth()
	{
		return 773;
	}

	@Range(
			min = 534
	)
	@ConfigItem(
			position = 5,
			keyName = "customSizeHeight",
			name = "Custom Snap Height",
			description = "Size client will change to when snapped")
	default int customHeight()
	{
		return 534;
	}
}
