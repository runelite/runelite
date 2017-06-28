package net.runelite.client.plugins.mousehighlight;

import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
        keyName = "mousehighlight",
        name = "Mouse Highlighting",
        description = "Configuration for the Mouse Highlight plugin"
)
public interface MouseHighlightConfig
{
    @ConfigItem(
            keyName = "enabled",
            name = "Enabled",
            description = "Configures whether or not mouse hover info is displayed"
    )
    default boolean enabled()
    {
        return true;
    }
}
