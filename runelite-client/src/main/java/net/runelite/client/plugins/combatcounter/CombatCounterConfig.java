package net.runelite.client.plugins.combatcounter;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("combatcounter")
public interface CombatCounterConfig extends Config
{
	@ConfigTitleSection(
		keyName = "counterTitle",
		name = "Counters",
		description = "",
		position = 1
	)
	default Title counterTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "Show Tick Counter",
		name = "Show Tick Counter",
		description = "Turn the tick counter on",
		position = 2,
		titleSection = "counterTitle"
	)
	default boolean showTickCounter()
	{
		return false;
	}

	@ConfigItem(
		keyName = "Show Damage Counter",
		name = "Show Damage Counter",
		description = "Turn the damage counter on",
		position = 3,
		titleSection = "counterTitle"
	)
	default boolean showDamageCounter()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "colorsTitle",
		name = "Colors",
		description = "",
		position = 4
	)
	default Title colorsTitle()
	{
		return new Title();
	}

	@Alpha
	@ConfigItem(
		keyName = "selfColor",
		name = "Your color",
		description = "",
		position = 5,
		titleSection = "colorsTitle"
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
		position = 6,
		titleSection = "colorsTitle"
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
		position = 7,
		titleSection = "colorsTitle"
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
		position = 8,
		titleSection = "colorsTitle"
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
		position = 9,
		titleSection = "colorsTitle"
	)
	default Color titleColor()
	{
		return Color.white;
	}

	@ConfigTitleSection(
		keyName = "miscTitle",
		name = "Miscellaneous",
		description = "",
		position = 10
	)
	default Title miscTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "Reset on New Instance",
		name = "Reset On New Instance",
		description = "Resets counter when entering a new instance",
		position = 11
	)
	default boolean resetOnNewInstance()
	{
		return false;
	}
}