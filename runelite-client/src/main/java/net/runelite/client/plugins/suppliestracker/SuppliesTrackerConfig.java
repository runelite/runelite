package net.runelite.client.plugins.suppliestracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("suppliestracker")
public interface SuppliesTrackerConfig extends Config
{
	@ConfigItem(
			keyName = "blowpipeAmmo",
			name = "Ammo used in your blowpipe",
			description = "What type of dart are you using in your toxic blowpipe"
	)
	default BlowpipeDartTypeEnum blowpipeAmmo()
	{
		return BlowpipeDartTypeEnum.MITHRIL;
	}
}
