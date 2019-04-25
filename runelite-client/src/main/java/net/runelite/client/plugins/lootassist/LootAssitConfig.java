package net.runelite.client.plugins.lootassist;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("lootassist")
public interface LootAssitConfig extends Config
{
	@ConfigItem(
		keyName = "color",
		name = "Color",
		description = "The Color of the tile and name overlay that indicates where loot will appear"
	)
	default Color color()
	{
		return Color.WHITE;
	}
}
