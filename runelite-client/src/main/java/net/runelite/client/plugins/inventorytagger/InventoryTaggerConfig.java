package net.runelite.client.plugins.inventorytagger;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup(
		keyName = "inventoryitemtagging",
		name = "Inventory Item Tagging",
		description = "Configuration for the Inventory Item Tagging"
)
public interface InventoryTaggerConfig extends Config
{
	@ConfigItem(
			position = 0,
			keyName = "groupColor1",
			name = "Group 1 Color",
			description = "Color of the Tag"
	)
	default Color getGroup1Color()
	{
		return new Color(255, 0, 0);
	}

	@ConfigItem(
			position = 1,
			keyName = "groupColor2",
			name = "Group 2 Color",
			description = "Color of the Tag"
	)
	default Color getGroup2Color()
	{
		return new Color(0, 255, 0);
	}
	@ConfigItem(
			position = 2,
			keyName = "groupColor3",
			name = "Group 3 Color",
			description = "Color of the Tag"
	)
	default Color getGroup3Color()
	{
		return new Color(0, 0, 255);
	}
	@ConfigItem(
			position = 3,
			keyName = "groupColor4",
			name = "Group 4 Color",
			description = "Color of the Tag"
	)
	default Color getGroup4Color()
	{
		return new Color(255, 0, 255);
	}
	@ConfigItem(
			position = 4,
			keyName = "groupColor5",
			name = "Group 5 Color",
			description = "Color of the Tag"
	)
	default Color getGroup5Color()
	{
		return new Color(255, 255, 0);
	}
	@ConfigItem(
			position = 5,
			keyName = "groupColor6",
			name = "Group 6 Color",
			description = "Color of the Tag"
	)
	default Color getGroup6Color()
	{
		return new Color(0, 255, 255);
	}
	@ConfigItem(
			keyName = "taggeditems",
			name = "",
			description = "",
			hidden = true
	)
	default String getTaggedItems()
	{
		return "";
	}
	@ConfigItem(
			keyName = "taggeditems",
			name = "",
			description = "",
			hidden = true
	)
	void setTaggedItems(String t);
}
