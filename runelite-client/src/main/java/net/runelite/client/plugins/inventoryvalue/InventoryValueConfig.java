package net.runelite.client.plugins.inventoryvalue;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("inventoryValue")
public interface InventoryValueConfig extends Config
{
	@ConfigItem(
			keyName = "useHaValue",
			name = "Use High Alchemy Value",
			description = "Calculate inventory value with High Alchemy. By default, the inventory value is calculated using GE price."
	)
	default boolean useHighAlchemyValue() {
		return false;
	}

	@ConfigItem(
			keyName = "ignoreCoins",
			name = "Ignore Coins",
			description = "Ignore coins in inventory. By default, the inventory value includes coins."
	)
	default boolean ignoreCoins() {
		return false;
	}

	@ConfigItem(
			keyName = "ignoreItems",
			name = "Ignore Items",
			description = "Ignore particular items in inventory. By default, no items are ignored."
	)
	default String ignoreItems() { return ""; }
}
