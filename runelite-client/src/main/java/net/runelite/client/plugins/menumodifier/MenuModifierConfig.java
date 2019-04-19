package net.runelite.client.plugins.menumodifier;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("menumodifier")
public interface MenuModifierConfig extends Config
{
    @ConfigItem(position = 0, keyName = "hideCancel", name = "Hide Cancel", description = "Hides the 'cancel' option from the right click menu")
    default boolean hideCancel() { return true; }

    @ConfigItem(position = 1, keyName = "hideExamine", name = "Hide Examine", description = "Hides the 'examine' option from the right click menu")
    default boolean hideExamine() { return true; }

    @ConfigItem(position = 2, keyName = "hideTradeWith", name = "Hide Trade With", description = "Hides the 'trade with' option from the right click menu")
    default boolean hideTradeWith() { return true; }

    @ConfigItem(position = 3, keyName = "hideReport", name = "Hide Report", description = "Hides the 'report' option from the right click menu")
    default boolean hideReport() { return true; }

    @ConfigItem(position = 4, keyName = "hideLookup", name = "Hide Lookup", description = "Hides the 'lookup' option from the right click menu")
    default boolean hideLookup() { return true; }
}
