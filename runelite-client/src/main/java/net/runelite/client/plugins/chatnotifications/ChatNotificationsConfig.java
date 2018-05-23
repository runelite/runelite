package net.runelite.client.plugins.chatnotifications;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
		keyName = "chatnotifications",
		name = "Chat Notifications",
		description = "Configuration for the Chat Notifications plugin"
)
public interface ChatNotificationsConfig extends Config
{
	@ConfigItem(
			keyName = "tradeNotif",
			name = "Trade Request",
			description = "Send a notification when a trade request is received",
			position = 0
	)
	default boolean tradeNotifEnabled()
	{
		return false;
	}

	@ConfigItem(
			keyName = "dualNotif",
			name = "Dual Request",
			description = "Send a notification when a dual request is received",
			position = 1
	)
	default boolean dualNotifEnabled() { return false; }
}