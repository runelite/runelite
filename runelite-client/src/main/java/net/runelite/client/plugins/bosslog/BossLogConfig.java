package net.runelite.client.plugins.bosslog;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("bosslog")
public interface BossLogConfig extends Config
{
    @ConfigItem(
            keyName = "ignoredItems",
            name = "Ignored items",
            description = "Configures which items should be ignored when calculating loot prices."
    )
    default String getIgnoredItems()
    {
        return "";
    }

    @ConfigItem(
            keyName = "ignoredItems",
            name = "",
            description = ""
    )
    void setIgnoredItems(String key);
}