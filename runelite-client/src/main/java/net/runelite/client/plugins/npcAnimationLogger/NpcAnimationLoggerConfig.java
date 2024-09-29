package net.runelite.client.plugins.npcAnimationLogger;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("npcAnimationLogger")  // This matches the config group in the plugin
public interface NpcAnimationLoggerConfig extends Config
{
  @ConfigItem(
      keyName = "enableLogging",
      name = "Enable NPC Animation Logging",
      description = "Toggle whether NPC animations should be logged",
      position = 0
  )
  default boolean enableLogging()
  {
    return true;
  }

  @ConfigItem(
      keyName = "logTargetingOnly",
      name = "Log Targeting NPCs Only",
      description = "Log animations only for NPCs that are targeting the player",
      position = 1
  )
  default boolean logTargetingOnly()
  {
    return false;
  }
}
