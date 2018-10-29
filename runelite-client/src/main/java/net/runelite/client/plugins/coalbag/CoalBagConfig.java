package net.runelite.client.plugins.coalbag;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("coalbag")
public interface CoalBagConfig extends Config
{
	@ConfigItem(
			keyName = "amount",
			name = "",
			description = "",
			hidden = true
	)
	default int amount()
	{
		return 0;
	}

	@ConfigItem(
			keyName = "amount",
			name = "",
			description = ""
	)
	void amount(int amount);
}