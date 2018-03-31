package net.runelite.client.plugins.itemcharges;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "itemCharges",
		name = "Item Charges",
		description = "Show charge counts remaining on inventory items"
)
public interface ItemChargesConfig extends Config
{
	@ConfigItem(
			keyName = "showTeleportCharges",
			name = "Show teleport charges",
			description = "Show number of teleports remaining on applicable items",
			position = 1
	)
	default boolean showTeleportCharges()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showDrinkablePotionDoses",
			name = "Show potion doses",
			description = "Show number of doses remaining in drinkable potions",
			position = 2
	)
	default boolean showDrinkablePotionDoses()
	{
		return false;
	}

	@ConfigItem(
			keyName = "showUndrinkablePotionDoses",
			name = "Show undrinkable potion doses",
			description = "Show number of doses remaining in undrinkable potions (eg. Compost potion)",
			position = 3
	)
	default boolean showUndrinkablePotionDoses()
	{
		return false;
	}

	@ConfigItem(
			keyName = "showBasketAndSackCounts",
			name = "Show basket & sack counts",
			description = "Show number of items remaining in fruit baskets and vegetable sacks",
			position = 4
	)
	default boolean showBasketAndSackCounts()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showMiscItemCharges",
			name = "Show miscellaneous item charges",
			description = "Show number of \"charges\" remaining on other types of items (eg. Waterskin, Ogre bellows, Imp-in-a-box)",
			position = 5
	)
	default boolean showMiscItemCharges()
	{
		return true;
	}
}
