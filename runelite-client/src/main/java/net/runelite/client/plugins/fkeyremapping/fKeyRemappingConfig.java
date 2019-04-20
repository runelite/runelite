package net.runelite.client.plugins.fkeyremapping;

import net.runelite.client.config.Config;

import java.awt.event.KeyEvent;

import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("fkeyremapping")
public interface fKeyRemappingConfig extends Config {
    @ConfigItem(
            position = 1,
            keyName = "F1",
            name = "F1 Key",
            description = "The key which will replace F1."
    )
    default Keybind f1()
    {
        return new Keybind(KeyEvent.VK_Q, 0);
    }

    @ConfigItem(
            position = 2,
            keyName = "F2",
            name = "F2 key",
            description = "The key which will replace F2."
    )
    default Keybind f2()
    {
        return new Keybind(KeyEvent.VK_W, 0);
    }

    @ConfigItem(
            position = 3,
            keyName = "F3",
            name = "F3 key",
            description = "The key which will replace F3."
    )
    default Keybind f3()
    {
        return new Keybind(KeyEvent.VK_E, 0);
    }

    @ConfigItem(
            position = 4,
            keyName = "F4",
            name = "F4 Key key",
            description = "The key which will replace F4."
    )
    default Keybind f4()
    {
        return new Keybind(KeyEvent.VK_R, 0);
    }


}
