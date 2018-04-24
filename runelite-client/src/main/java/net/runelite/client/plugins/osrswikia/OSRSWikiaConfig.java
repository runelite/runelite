package net.runelite.client.plugins.osrswikia;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
        keyName = "osrsWikia",
        name = "Old School Runescape Wikia",
        description = "Configuration for the Old School Runescape Wikia plugin"
)
public interface OSRSWikiaConfig extends Config
{
    @ConfigItem(
            keyName = "enableWikiCommand",
            name = "Enable wiki command",
            description = "Configures whether or not to enable the ::wiki search command"
    )
    default boolean allowWikiCommand() {
        return true;
    }
}
