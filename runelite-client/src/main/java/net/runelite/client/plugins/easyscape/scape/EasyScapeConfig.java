package net.runelite.client.plugins.easy.scape;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("easyscape")
public interface EasyScapeConfig extends Config {

    @ConfigItem(
            keyName = "removeExamine",
            name = "Remove Examine",
            description = "Removes Examine from the list of options.",
            position = 0
    )

    default boolean getRemoveExamine() {
        return true;
    }

    @ConfigItem(
            keyName = "removeObjects",
            name = "Remove Objects",
            description = "Removes interaction with the listed objects.",
            position = 1
    )

    default boolean getRemoveObjects() {
        return true;
    }

    @ConfigItem(
            keyName = "removedObjects",
            name = "Objects",
            description = "Objects listed here will have all interaction be removed.",
            position = 2
    )

    default String getRemovedObjects() {
        return "";
    }

}
