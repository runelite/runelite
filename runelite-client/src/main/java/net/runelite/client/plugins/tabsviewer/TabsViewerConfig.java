package net.runelite.client.plugins.tabsviewer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.tabsviewer.config.ViewerMode;

@ConfigGroup("tabsviewer")
public interface TabsViewerConfig extends Config {

    @ConfigItem(
            keyName = "tabsViewMode",
            name = "Viewer Mode",
            description = "Configures whether the inventory, equipped or both tabs are displayed",
            position = 7
    )
    default ViewerMode tabsViewMode()
    {
        return ViewerMode.BOTH;
    }

}
