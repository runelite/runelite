package net.runelite.client.plugins.synthetickeytest;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.config.Keybind;
import java.awt.event.MouseEvent;

@ConfigGroup("synthetickeytest")
public interface SyntheticKeyTestConfig extends Config
{
    @ConfigSection(
            name = "Bind Test",
            description = "Key remapping option for testing.",
            position = 0
    )
    String bindTestSection = "bindTest";

    @ConfigItem(
            name = "F1",
            keyName = "f1",
            description = "The button that will replace F1.",
            section = bindTestSection
    )
    default ModifierlessKeybind f1()
    {
        return new ModifierlessKeybind(Keybind.Type.MOUSE, MouseEvent.BUTTON2);
    }
}
