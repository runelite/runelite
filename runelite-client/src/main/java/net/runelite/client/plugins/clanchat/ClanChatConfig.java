package net.runelite.client.plugins.clanchat;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("clanchat")
public interface ClanChatConfig extends Config
{
	@ConfigItem(
		keyName = "showEnterAndLeaveMessages",
		name = "Show member enter and leave messages",
		description = "Configures whether or not to display messages informing who has entered and left the clan chat"
	)
	default boolean showEnterAndLeaveMessages() 
	{
		return false;
	}
}
