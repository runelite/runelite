package net.runelite.client.plugins.protectitemreminder;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("protectitemreminder")
public interface ProtectItemReminderConfig extends Config
{
    @ConfigItem(position = 0, keyName = "skulledOnly", name = "Only when skulled", description = "Only show the reminder when you are skulled")
    default boolean skulledOnly() { return false; }

    @ConfigItem(position = 1, keyName = "getHeight", name = "Text Height", description = "Sets the reminder text height")
    default int getHeight() { return 60; }
}
