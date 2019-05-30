package net.runelite.client.plugins.combatcounter;

import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("combatcounter")
public interface CombatCounterConfig extends Config
{

	@ConfigItem(
		keyName = "Show Tick Counter",
		name = "Show Tick Counter",
		description = "Turn the tick counter on",
		position = 1
	)
	default boolean showTickCounter()
	{
		return false;
	}

	@ConfigItem(
		keyName = "Show Damage Counter",
		name = "Show Damage Counter",
		description = "Turn the damage counter on",
		position = 2
	)
	default boolean showDamageCounter()
	{
		return false;
	}


	@ConfigItem(
		keyName = "Reset on New Instance",
		name = "Reset On New Instance",
		description = "Resets counter when entering a new instance",
		position = 4
	)
	default boolean resetOnNewInstance()
	{
		return false;
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