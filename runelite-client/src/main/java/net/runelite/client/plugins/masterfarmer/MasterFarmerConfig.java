package net.runelite.client.plugins.masterfarmer;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tithefarmplugin")
public interface MasterFarmerConfig extends Config
{
	@ConfigItem(
		keyName = "showOverlay",
		name = "Show timer over the master farmer",
		description = "Configures whether or not to have a timer over the master farmer"
	)
	default boolean showOverlay()
	{
		return true;
	}
}
