package net.runelite.client.plugins.Flinching;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("flinchingplugin")
public interface FlinchingConfig extends Config
{
    @ConfigItem(

            position = 0,
            keyName = "hexColorFlinch",
            name = "Overlay Color",
            description = "Color of flinching overlay"
    )
    default Color getFlinchOverlayColor()
    {
        return Color.CYAN;
    }

    @ConfigItem(

            position = 1,
            keyName = "flinchOverlaySize",
            name = "Overlay Diameter",
            description = "Flinch overlay diameter"
    )
    default int getFlinchOverlaySize()
    {
        return 30;
    }

    @ConfigItem(

            position = 2,
            keyName = "flinchDelay",
            name = "Flinch Delay",
            description = "Flinch Delay in milliseconds"
    )
    default int getFlinchDelay()
    {
        return 5400;
    }

    @ConfigItem(

            position = 3,
            keyName = "flinchOnHitReceivedDelay",
            name = "Flinch Hit Received Delay",
            description = "Flinch Delay in milliseconds after being hit"
    )
    default int getFlinchAttackedDelay()
    {
        return 6600;
    }

    @ConfigItem(

            position = 4,
            keyName = "flinchResetOnHit",
            name = "Reset on Hit",
            description = "Whether to reset the timer when you hit"
    )
    default boolean getFlinchResetOnHit()
    {
        return true;
    }

    @ConfigItem(

            position = 5,
            keyName = "flinchResetOnHitReceived",
            name = "Reset on Hit Received",
            description = "Whether to reset the timer when you are hit"
    )
    default boolean getFlinchResetOnHitReceived()
    {
        return true;
    }
}