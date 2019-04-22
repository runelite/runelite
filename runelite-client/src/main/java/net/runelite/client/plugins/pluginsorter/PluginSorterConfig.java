package net.runelite.client.plugins.pluginsorter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("pluginsorter")
public interface PluginSorterConfig extends Config {

    Color rlDefault = new Color(250, 155, 23);

    boolean pluginsHidden = false;

    @ConfigItem(
            position = 0,
            keyName = "hidePlugins",
            name = "Hide Plugins",
            description = "Hides all 3rd party plugins if checked"
    )
    default boolean hidePlugins()
    {
        return pluginsHidden;
    }

    @ConfigItem(
            position = 1,
            keyName = "externalColor",
            name = "External color",
            description = "Configure the color of external plugins"
    )
    default Color externalColor()
    {
        return Color.MAGENTA;
    }

    @ConfigItem(
            position = 2,
            keyName = "pvmColor",
            name = "PVM color",
            description = "Configure the color of PVM related plugins"
    )
    default Color pvmColor()
    {
        return Color.GREEN;
    }

    @ConfigItem(
            position = 3,
            keyName = "pvpColor",
            name = "PVP color",
            description = "Configure the color of PVP related plugins"
    )
    default Color pvpColor()
    {
        return Color.RED;
    }

    @ConfigItem(
            position = 4,
            keyName = "utilityColor",
            name = "Utility color",
            description = "Configure the color of utility related plugins"
    )
    default Color utilityColor()
    {
        return Color.CYAN;
    }

}
