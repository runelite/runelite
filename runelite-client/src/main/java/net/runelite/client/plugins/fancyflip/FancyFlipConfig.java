package net.runelite.client.plugins.fancyflip;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("fancyflip")
public interface FancyFlipConfig extends Config
{
    @ConfigItem(
            keyName = "taxRate",
            name = "Tax Rate (%)",
            description = "Grand Exchange tax percentage"
    )
    default int taxRatePct() { return 2; }

    @ConfigItem(
            keyName = "maxAlloc",
            name = "Max % per item",
            description = "Max percent of bank per item"
    )
    default int maxAllocationPct() { return 40; }
}
