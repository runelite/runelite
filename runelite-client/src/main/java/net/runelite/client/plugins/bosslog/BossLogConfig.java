package net.runelite.client.plugins.bosslog;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("bosslog")
public interface BossLogConfig extends Config
{
    @ConfigItem(
            keyName = "zulrahDrops",
            name = "Zulrah drops",
            description = "Stores boss log for Zulrah."
    )
    default String getZulrahDrops()
    {
        return "";
    }

    @ConfigItem(
            keyName = "zulrahDrops",
            name = "",
            description = ""
    )
    void setZulrahDrops(String key);
}