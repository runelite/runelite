package net.runelite.client.plugins.kitten;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
        keyName = "kittenConfig",
        name = "kitten",
        description = "Configuration for the kitten plugin"
)

public interface kittenConfig extends Config{
    @ConfigItem(
            keyName = "kittenInfoBox",
            name = "Display kitten info box",
            description = "Displays a countdown for your kitten to grow into a cat",
            position = 1
    )
    default boolean kittenInfoBox()
    {
        return true;
    }

    @ConfigItem(
            keyName = "catInfoBox",
            name = "Display cat info box",
            description = "Displays a countdown for your cat to grow into a overgrown cat",
            position = 2
    )
    default boolean catInfoBox()
    {
        return true;
    }

    @ConfigItem(
            keyName = "kittenHungryBox",
            name = "Display kitten hunger",
            description = "Displays a countdown until your kitten leaves you for being underfed",
            position = 3
    )
    default boolean kittenHungryBox()
    {
        return true;
    }

    @ConfigItem(
            keyName = "kittenAttentionBox",
            name = "Display kitten attention",
            description = "Displays a countdown until your kitten leaves you for being neglectful",
            position = 4
    )
    default boolean kittenAttentionBox()
    {
        return true;
    }

    @ConfigItem(
            keyName = "kittenNotifications",
            name = "Display kitten notifications",
            description = "Displays a notification when your kitten is hungry or requires attention",
            position = 5
    )
    default boolean kittenNotifications()
    {
        return true;
    }

    @ConfigItem(
            keyName = "secondsAlive",
            name = "",
            description = "",
            hidden = true
    )
    default int secondsAlive()
    {
        return -1;
    }

    @ConfigItem(
            keyName = "secondsAlive",
            name = "",
            description = ""
    )
    void secondsAlive(int seconds);

    @ConfigItem(
            keyName = "secondsHungry",
            name = "",
            description = "",
            hidden = true
    )
    default int secondsHungry()
    {
        return -1;
    }

    @ConfigItem(
            keyName = "secondsHungry",
            name = "",
            description = ""
    )
    void secondsHungry(int seconds);

    @ConfigItem(
            keyName = "secondsNeglected",
            name = "",
            description = "",
            hidden = true
    )
    default int secondsNeglected()
    {
        return -1;
    }

    @ConfigItem(
            keyName = "secondsNeglected",
            name = "",
            description = ""
    )
    void secondsNeglected(int seconds);

    @ConfigItem(
            keyName = "felineId",
            name = "",
            description = "",
            hidden = true
    )
    default int felineId()
    {
        return -1;
    }

    @ConfigItem(
            keyName = "felineId",
            name = "",
            description = ""
    )
    void felineId(int id);



}
