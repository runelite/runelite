package net.runelite.client.plugins.wintertodt;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup(
		keyName = "wintertodt",
		name = "Wintertodt Plugin",
		description = "Configuration for the Wintertodt UI"
)
public interface WintertodtConfig extends Config {

	@ConfigItem(
			keyName = "highColor",
			name = "High Color",
			description = "The color for high Energy and Points.",
			position = 1
	)
	default Color highColor()
	{
		return Color.GREEN;
	}

	@ConfigItem(
			keyName = "medColor",
			name = "Medium Color",
			description = "The color for medium Energy.",
			position = 2
	)
	default Color medColor()
	{
		return Color.YELLOW;
	}

	@ConfigItem(
			keyName = "lowColor",
			name = "Low Color",
			description = "The color for low Energy and Points.",
			position = 3
	)
	default Color lowColor()
	{
		return Color.RED;
	}
}
