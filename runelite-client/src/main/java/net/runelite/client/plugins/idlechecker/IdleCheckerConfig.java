
package net.runelite.client.plugins.idlechecker;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("idlechecker")
public interface IdleCheckerConfig extends Config
{
	@ConfigSection(
		name = "Appearance",
		description = "Settings for the overlay's appearance",
		position = 0
	)
	String appearanceSection = "appearance";

	@ConfigSection(
		name = "Logic",
		description = "Settings for the plugin's logic",
		position = 1
	)
	String logicSection = "logic";

	@Alpha
	@ConfigItem(
		keyName = "activeColor",
		name = "Active Color",
		description = "The color of the overlay when you are active.",
		section = appearanceSection,
		position = 0
	)
	default Color getActiveColor()
	{
		return Color.GREEN;
	}

	@Alpha
	@ConfigItem(
		keyName = "idleColor",
		name = "Idle Color",
		description = "The color of the overlay when you are idle.",
		section = appearanceSection,
		position = 1
	)
	default Color getIdleColor()
	{
		return Color.RED;
	}

	@Alpha
	@ConfigItem(
		keyName = "fullInventoryColor",
		name = "Full Inventory Color",
		description = "The color of the overlay when your inventory is full.",
		section = appearanceSection,
		position = 2
	)
	default Color getFullInventoryColor()
	{
		return Color.BLUE;
	}

	@ConfigItem(
		keyName = "overlayShape",
		name = "Overlay Shape",
		description = "The shape of the overlay.",
		section = appearanceSection,
		position = 3
	)
	default IdleCheckerShape getOverlayShape()
	{
		return IdleCheckerShape.SQUARE;
	}

	@ConfigItem(
		keyName = "overlaySize",
		name = "Overlay Size",
		description = "The size of the overlay.",
		section = appearanceSection,
		position = 4
	)
	default int getOverlaySize()
	{
		return 20;
	}

	@ConfigItem(
		keyName = "flashOnFull",
		name = "Flash on Full",
		description = "Make the overlay flash when the inventory is full.",
		section = appearanceSection,
		position = 5
	)
	default boolean flashOnFull()
	{
		return false;
	}

	@ConfigItem(
		keyName = "idleTimeout",
		name = "Idle Timeout (ms)",
		description = "The time in milliseconds before you are considered idle.",
		section = logicSection
	)
	default int getIdleTimeout()
	{
		return 1200;
	}

	@ConfigItem(
		keyName = "flashWindowOnFull",
		name = "Flash Window on Full",
		description = "Flash the client window when the inventory is full.",
		section = logicSection
	)
	default boolean flashWindowOnFull()
	{
		return false;
	}
}
