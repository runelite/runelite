package net.runelite.client.plugins.bank;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(keyName = "Bank Value", name = "Bank Value plugin", description = "Shows the value of your bank and/or current tab")
public interface BankConfig extends Config
{
	@ConfigItem(keyName = "isEnabled", name = "Enabled", description = "Toggles the bank value indicator on or off")
	default boolean isEnabled()
	{
		return true;
	}

	@ConfigItem(keyName = "showHA", name = "Show HA", description = "Show high alchemy price total")
	default boolean showHA()
	{
		return true;
	}

	@ConfigItem(keyName = "includeUntradeable", name = "Include untradeables", description = "Include the untradeable item prices into the GE value")
	default boolean includeUntradeable()
	{
		return true;
	}

	@ConfigItem(keyName = "customName", name = "Bank name", description = "Set a custom bank name")
	default String customName()
	{
		return "The Bank of RuneScape";
	}
}
