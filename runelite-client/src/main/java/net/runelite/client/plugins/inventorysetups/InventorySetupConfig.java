package net.runelite.client.plugins.inventorysetups;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup("inventorysetups")
public interface InventorySetupConfig extends Config
{
	@ConfigItem(
			keyName = "highlightDifferences",
			name = "Highlight Differences",
			description = "Highlight slots that don't match the selected setup",
			position = 0
	)

	default boolean getHighlightDifferences()
	{
		return false;
	}

	@ConfigItem(
			keyName = "highlightDifferenceColor",
			name = "Highlight Color",
			description = "The color used to highlight differences between setups",
			position = 1
	)

	default Color getHighlightColor()
	{
		return Color.RED;
	}

	@ConfigItem(
			keyName = "stackDifference",
			name = "Stack Difference",
			description = "Differences between setups will be highlighted if the stack size is different",
			position = 2
	)

	default boolean getStackDifference()
	{
		return false;
	}

	@ConfigItem(
			keyName = "variationDifference",
			name = "Variation Difference",
			description = "Variations of items (E.g., charged jewellery) will be counted as different",
			position = 2
	)

	default boolean getVariationDifference()
	{
		return false;
	}

	@ConfigItem(
			keyName = "bankHighlight",
			name = "Bank Highlight",
			description = "Highlight setup items in bank",
			position = 4
	)

	default boolean getBankHighlight()
	{
		return false;
	}

	@ConfigItem(
			keyName = "bankHighlightColor",
			name = "Bank Highlight Color",
			description = "The color used to highlight setup items in bank",
			position = 5
	)

	default Color getBankHighlightColor()
	{
		return Color.RED;
	}

}
