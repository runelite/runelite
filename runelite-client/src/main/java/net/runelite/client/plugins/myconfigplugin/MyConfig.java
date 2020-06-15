package net.runelite.client.plugins.myconfigplugin;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("myconfig")
public interface MyConfig extends Config
{
	@ConfigItem(
		keyName = "nickname",
		name="Nickname",
		description="The user's nickname",
		position = 1
	)

	default String nickname() {return "John";}

	@ConfigItem(
		keyName = "goalLevel",
		name="Goal Level",
		description = "The user's goal level",
		position = 2
	)
	default int goalLevel() { return 99;}
}
