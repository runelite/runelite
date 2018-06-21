package net.runelite.client.plugins.specialcounter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "specialAttack",
	name = "Special Attack",
	description = "Configuration for special attack options"
)
public interface SpecialCounterConfig extends Config
{
	@ConfigItem(
		keyName = "specialAttackCounter",
		name = "Special Attack Boss Counter",
		description = "Track successful defence reducing special attacks on bosses",
		position = 1
	)
	default boolean enableSpecialAttackCounter()
	{
		return true;
	}

	@ConfigItem(
		keyName = "specialPercentageNotifier",
		name = "Special Attack Percentage Notification",
		description = "Get notified when special attack reaches 100%",
		position = 2
	)
	default boolean enableSpecialAttackNotification()
	{
		return true;
	}
}
