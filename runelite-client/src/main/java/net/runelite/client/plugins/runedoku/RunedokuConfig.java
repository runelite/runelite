package net.runelite.client.plugins.runedoku;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("runedoku")
public interface RunedokuConfig extends Config
{

	@ConfigItem(
		position = 0,
		keyName = "mindRuneColor",
		name = "Mind Rune Color",
		description = "Color used to highlight Mind runes."
	)
	default Color mindRuneColor()
	{
		return Color.PINK;
	}

	@ConfigItem(
		position = 1,
		keyName = "fireRuneColor",
		name = "Fire Rune Color",
		description = "Color used to highlight Fire runes."
	)
	default Color fireRuneColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 2,
		keyName = "bodyRuneColor",
		name = "Body Rune Color",
		description = "Color used to highlight Body runes."
	)
	default Color bodyRuneColor()
	{
		return Color.MAGENTA;
	}

	@ConfigItem(
		position = 3,
		keyName = "airRuneColor",
		name = "Air Rune Color",
		description = "Color used to highlight Air runes."
	)
	default Color airRuneColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		position = 4,
		keyName = "deathRuneColor",
		name = "Death Rune Color",
		description = "Color used to highlight Death runes."
	)
	default Color deathRuneColor()
	{
		return Color.BLACK;
	}

	@ConfigItem(
		position = 5,
		keyName = "waterRuneColor",
		name = "Water Rune Color",
		description = "Color used to highlight Water runes."
	)
	default Color waterRuneColor()
	{
		return Color.BLUE;
	}

	@ConfigItem(
		position = 6,
		keyName = "chaosRuneColor",
		name = "Chaos Rune Color",
		description = "Color used to highlight Chaos runes."
	)
	default Color chaosRuneColor()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
		position = 7,
		keyName = "earthRuneColor",
		name = "Earth Rune Color",
		description = "Color used to highlight Earth runes."
	)
	default Color earthRuneColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		position = 8,
		keyName = "lawRuneColor",
		name = "Law Rune Color",
		description = "Color used to highlight Law runes."
	)
	default Color lawRuneColor()
	{
		return Color.CYAN;
	}

}
