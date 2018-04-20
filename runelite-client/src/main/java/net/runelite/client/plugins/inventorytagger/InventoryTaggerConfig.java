package net.runelite.client.plugins.inventorytagger;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "Inventory Item Tagging",
		name = "Inventory Item Tagging",
		description = "Inventory Item Tagging"
)
public interface InventoryTaggerConfig extends Config
{

	@ConfigItem(
			keyName = "idk",
			name = "S123",
			description = "123",
			position = 1
	)
	default boolean idk()
	{
		return true;
	}
}
