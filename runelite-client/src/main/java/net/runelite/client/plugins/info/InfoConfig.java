package net.runelite.client.plugins.info;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("info")
public interface InfoConfig extends Config
{
	@ConfigItem(
		keyName = "showGithub",
		name = "Show the OpenOSRS Github",
		description = "Configures if you want to show the OpenOSRS Github or not.",
		position = 0
	)
	default boolean showGithub()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLauncher",
		name = "Show the Launcher download",
		description = "Configures if you want to show the OpenOSRS Launcher download or not.",
		position = 1
	)
	default boolean showLauncher()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLogDir",
		name = "Show Log Directory",
		description = "Configures if you want to show the Log Directory or not.",
		position = 2
	)
	default boolean showLogDir()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRuneliteDir",
		name = "Show Runelite Directory",
		description = "Configures if you want to show the Runelite directory or not.",
		position = 3
	)
	default boolean showRuneliteDir()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPluginsDir",
		name = "Show Plugins Directory",
		description = "Configures if you want to show the Plugins Directory or not.",
		position = 4
	)
	default boolean showPluginsDir()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showScreenshotsDir",
		name = "Show Screenshots Directory",
		description = "Configures if you want to show the Screenshots Directory or not.",
		position = 5
	)
	default boolean showScreenshotsDir()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPhysicalDir",
		name = "Show Physical Locations",
		description = "Configures if you want to show the Physical Directory Locations or not.",
		position = 6
	)
	default boolean showPhysicalDir()
	{
		return true;
	}

}
