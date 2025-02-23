package net.runelite.client.plugins.rlbot;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("rlbotrecorder")
public interface RLBotRecorderConfig extends Config {
    @ConfigItem(
        keyName = "recordHotkey",
        name = "Record Hotkey",
        description = "Hotkey to start/stop recording",
        position = 1
    )
    default String recordHotkey() {
        return "F7";
    }

    @ConfigItem(
        keyName = "screenshotInterval",
        name = "Screenshot Interval",
        description = "Number of game ticks between screenshots",
        position = 2
    )
    default int screenshotInterval() {
        return 5;
    }

    @ConfigItem(
        keyName = "recordMouse",
        name = "Record Mouse",
        description = "Record mouse movements and clicks",
        position = 3
    )
    default boolean recordMouse() {
        return true;
    }

    @ConfigItem(
        keyName = "recordKeyboard",
        name = "Record Keyboard",
        description = "Record keyboard inputs",
        position = 4
    )
    default boolean recordKeyboard() {
        return true;
    }

    @ConfigItem(
        keyName = "saveScreenshots",
        name = "Save Screenshots",
        description = "Save screenshots during recording",
        position = 5
    )
    default boolean saveScreenshots() {
        return true;
    }
} 