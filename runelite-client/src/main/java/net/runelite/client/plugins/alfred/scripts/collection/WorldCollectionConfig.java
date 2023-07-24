package net.runelite.client.plugins.alfred.scripts.collection;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(WorldCollectionPlugin.CONFIG_GROUP)
public interface WorldCollectionConfig extends Config {
    @ConfigSection(
            name = "General",
            description = "General",
            position = 0,
            closedByDefault = false
    )
    String generalSection = "general";
}


