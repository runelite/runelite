package net.runelite.client.plugins.safespot;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("safespot")
public interface SafeSpotConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "playerSafeSpots",
		name = "Render for Players",
		description = "Renders 1 way safe spots vs other players"
	)
	default boolean playerSafeSpots()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "npcSafeSpots",
		name = "Render for NPCs",
		description = "Renders 1 way safe spots vs NPCs"
	)
	default boolean npcSafeSpots()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "tileColor",
		name = "Tile Color",
		description = "Color of safe spot tile"
	)
	default Color tileColor()
	{
		return Color.MAGENTA;
	}
}