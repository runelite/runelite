package net.runelite.client.plugins.playerinfo;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("playerinfo")
public interface PlayerInfoConfig extends Config
{
    @ConfigItem(
            keyName = "enableHealth",
            name = "Enable Health Display",
            description = "Configures whether or not to display health information",
            position = 1
    )
    default boolean enableHealth()
    {
        return true;
    }

    @ConfigItem(
            keyName = "enablePrayer",
            name = "Enable Prayer Display",
            description = "Configures whether or not to display prayer information",
            position = 2
    )
    default boolean enablePrayer()
    {
        return true;
    }

    @ConfigItem(
            keyName = "enableEnergy",
            name = "Enable Run Energy Display",
            description = "Configures whether or not to display run energy information",
            position = 3
    )
    default boolean enableEnergy()
    {
        return true;
    }

    @ConfigItem(
            keyName = "enableSpec",
            name = "Enable Special Attack Display",
            description = "Configures whether or not to display special attack information",
            position = 4
    )
    default boolean enableSpec()
    {
        return true;
    }

    @ConfigItem(
            keyName = "colorHigh",
            name = "Color High",
            description = "The color displayed for high values.",
            position = 5
    )
    default Color colorHigh()
    {
        return Color.GREEN;
    }

    @ConfigItem(
            keyName = "colorMed",
            name = "Color Medium",
            description = "The color displayed for medium values.",
            position = 6
    )
    default Color colorMed()
    {
        return Color.YELLOW;
    }

    @ConfigItem(
            keyName = "colorLow",
            name = "Color Low",
            description = "The color displayed for low values.",
            position = 7
    )
    default Color colorLow()
    {
        return Color.RED;
    }
}
