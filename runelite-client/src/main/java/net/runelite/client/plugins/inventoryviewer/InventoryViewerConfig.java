package net.runelite.client.plugins.inventoryviewer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("inventoryviewer")
public interface InventoryViewerConfig extends Config
{
	@ConfigItem(
		keyName = "hideWhenInvOpen",
		name = "Hide when inventory is open",
		description = "Hide the inventory viewer when the player's inventory is open"
	)
	default boolean hideWhenInvOpen()
	{
		return false;
	}
}
