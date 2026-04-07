package net.runelite.client.plugins.miningbuddy;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("miningbuddy")
public interface MiningBuddyConfig extends Config
{
    // ── Motherload Mine ────────────────────────────────────────────────────
    @ConfigSection(
            name = "Motherload Mine",
            description = "Settings for Motherload Mine",
            position = 0
    )
    String motherloadSection = "motherload";

    @ConfigItem(
            keyName = "motherloadEnabled",
            name = "Enable Motherload Mine",
            description = "Enable or disable the Motherload Mine module",
            section = "motherload",
            position = 0
    )
    default boolean motherloadEnabled()
    {
        return false;
    }

    // ── Amethyst ───────────────────────────────────────────────────────────
    @ConfigSection(
            name = "Amethyst",
            description = "Settings for Amethyst mining",
            position = 1
    )
    String amethystSection = "amethyst";

    @ConfigItem(
            keyName = "amethystEnabled",
            name = "Enable Amethyst",
            description = "Enable or disable the Amethyst module",
            section = "amethyst",
            position = 0
    )
    default boolean amethystEnabled()
    {
        return false;
    }

    // ── 3-tick Sandstone ───────────────────────────────────────────────────
    @ConfigSection(
            name = "3-tick Sandstone",
            description = "Settings for 3-tick Sandstone mining",
            position = 2
    )
    String sandstoneSection = "sandstone";

    @ConfigItem(
            keyName = "sandstoneEnabled",
            name = "Enable 3-tick Sandstone",
            description = "Enable or disable the 3-tick Sandstone module",
            section = "sandstone",
            position = 0
    )
    default boolean sandstoneEnabled()
    {
        return false;
    }
}