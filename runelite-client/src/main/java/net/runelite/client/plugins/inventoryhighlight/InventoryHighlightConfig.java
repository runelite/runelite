package net.runelite.client.plugins.inventoryhighlight;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("inventoryHighlight")
public interface InventoryHighlightConfig extends Config
{
	@ConfigItem(
		keyName = "showItem",
		name = "Show the item",
		description = "Show a preview of the item in the new slot"
	)
	default boolean showItem()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGrid",
		name = "Show a grid",
		description = "Show a grid on the inventory while dragging"
	)
	default boolean showGrid()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showHighlight",
		name = "Show background highlight",
		description = "Show a green background highlight in the new slot"
	)
	default boolean showHighlight()
	{
		return false;
	}
}
