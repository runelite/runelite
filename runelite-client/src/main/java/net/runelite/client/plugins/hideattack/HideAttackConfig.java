package net.runelite.client.plugins.hideattack;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("hideattack")
public interface HideAttackConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "shiftWalk",
		name = "Shift Walk here and Loot",
		description = "Removes the Attack option for all players while holding shift. Allows one-click looting"
	)
	default boolean shiftWalk()
	{
		return false;
	}

  @ConfigItem(
    position = 2,
    keyName = "swapAttack",
    name = "Remove/Swap Attack for Clan",
    description = "Swap Attack with Walk here for team. NOTE: Swap doesn't work if more than one person in DD"
  )
  default AttackMode swapAttack()
  {
    return AttackMode.OFF;
  }
}
