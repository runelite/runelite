package net.runelite.client.plugins.vorkath;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("vorkath")
public interface VorkathConfig extends Config {
	@ConfigItem(
		position = 0,
		keyName = "Vorkathenable",
		name = "Enable Vorkath Helper",
		description = "Configures whether or not to enable Vorkath Helper."
	)
	default boolean EnableVorkath() { return true; }

	@ConfigItem(
			position = 1,
			keyName = "countercolor",
			name = "Indicator color",
			description = "Configures color of text displaying Vorkath hits left to special attack."
	)
	default Color CounterColor() { return Color.YELLOW; }

	@ConfigItem(
			position = 2,
			keyName = "countersize",
			name = "Bold indicator",
			description = "Configures if text indicator is bold or not."
	)
	default boolean BoldText() { return true; }

	@ConfigItem(
			position = 3,
			keyName = "enumConfig",
			name = "Fireball Tile Highlight",
			description = "Select how to apply tile highlighting for Vorkath's fireball attack"
	)
	default TileHighlight TileHighlight() { return TileHighlight.All; }

	@ConfigItem(
			position = 4,
			keyName = "overlayindicators",
			name = "Overlay Indicators",
			description = "Configures if an overlay box displaying vorkath information should be displayed."
	)
	default boolean VorkathBox() { return false; }

}
