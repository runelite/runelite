package net.runelite.client.plugins.test;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import java.awt.event.MouseEvent;
import java.awt.event.InputEvent;
import net.runelite.client.config.Mousebind;
import net.runelite.client.config.ModifierlessMousebind;

@ConfigGroup("mousebindtest")
public interface MousebindTestConfig extends Config
{
    @ConfigItem(
            keyName = "regularBind",
            name = "Regular Mousebind",
            description = "Test Mousebind with modifiers",
            position = 0
    )
    default Mousebind regularBind()
    {
        return new Mousebind(MouseEvent.BUTTON3, InputEvent.CTRL_DOWN_MASK); // Ctrl + Right Click
    }

    @ConfigItem(
            keyName = "modlessBind",
            name = "Modifierless Mousebind",
            description = "Test ModifierlessMousebind",
            position = 1
    )
    default ModifierlessMousebind modlessBind()
    {
        return new ModifierlessMousebind(4, 0); // Mouse Button 4
    }
}
