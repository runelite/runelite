package net.runelite.client.plugins.alwaysontop;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@ConfigGroup(AlwaysOnTopConfig.GROUP)
public interface AlwaysOnTopConfig extends Config
{
    String GROUP = "alwaysontop";

    @ConfigItem(
            keyName = "hotkey",
            name = "Toggle Always on Top",
            description = "Pressing this key will enable/disable the Runelite client showing over all other windows",
            position = 0
    )
    default Keybind hotkey()
    {
        return new Keybind(KeyEvent.VK_SPACE, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
    }
}
