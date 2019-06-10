package net.runelite.client.plugins.vorkath;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

/**
 * Created on 6/4/2019.
 */
@ConfigGroup("vorkath")
public interface VorkathConfig extends Config
{
	@ConfigItem(
		keyName = "fireBombNotification",
		name = "Fire Bomb Notification",
		description = "Sends a system notification when Vorkath attack with his fire bomb"
	)
	default boolean shouldNotifyOnFireBomb()
	{
		return false;
	}
}
