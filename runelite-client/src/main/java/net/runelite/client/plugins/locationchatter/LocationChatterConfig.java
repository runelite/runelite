package net.runelite.client.plugins.locationchatter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("locationchatter")
public interface LocationChatterConfig extends Config
{
	@ConfigItem(keyName = "keybind", name = "Send to CC", description = "Configure button to send current location to CC")
	default Keybind keybind()
	{
		return Keybind.NOT_SET;
	}
}
