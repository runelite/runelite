package net.runelite.client.plugins.tickcounter;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tickcounter")
public interface TickCounterConfig extends Config
{
	@ConfigItem(
		keyName = "resetInstance",
		name = "Reset on new instances",
		description = "",
		position = 1
	)
	default boolean instance()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "selfColor",
		name = "Your color",
		description = "",
		position = 4
	)
	default Color selfColor()
	{
		return Color.green;
	}

	@Alpha
	@ConfigItem(
		keyName = "totalColor",
		name = "Total color",
		description = "",
		position = 6
	)
	default Color totalColor()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		keyName = "otherColor",
		name = "Other players color",
		description = "",
		position = 5
	)
	default Color otherColor()
	{
		return Color.white;
	}

	@Alpha
	@ConfigItem(
		keyName = "bgColor",
		name = "Background color",
		description = "",
		position = 3
	)
	default Color bgColor()
	{
		return new Color(70, 61, 50, 156);
	}

	@Alpha
	@ConfigItem(
		keyName = "titleColor",
		name = "Title color",
		description = "",
		position = 2
	)
	default Color titleColor()
	{
		return Color.white;
	}
}
