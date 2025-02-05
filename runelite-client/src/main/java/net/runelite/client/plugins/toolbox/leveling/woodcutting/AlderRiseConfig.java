package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("toolbox.leveling.woodcutting.alder_rise")
public interface AlderRiseConfig extends Config{

    @ConfigSection(
            name = "General Settings",
            description = "General settings for the plugin",
            position = 0
    )
    String generalSection = "general";

    @ConfigItem(
            keyName = "enablePlugin",
            name = "Enable Plugin",
            description = "Toggle the plugin on or off",
            position = 1,
            section = generalSection
    )
    default boolean enablePlugin() {
        return true;
    }

    @ConfigItem(
            keyName = "customText",
            name = "Custom Label",
            description = "User-defined text for labeling",
            position = 2,
            section = generalSection
    )
    default String customText() {
        return "Default Text";
    }

    @ConfigItem(
            keyName = "notificationSound",
            name = "Enable Notification Sound",
            description = "Play a sound when an event occurs",
            position = 3,
            section = generalSection
    )
    default boolean notificationSound() {
        return false;
    }

    @Range(
            min = 1,
            max = 100
    )
    @ConfigItem(
            keyName = "opacityLevel",
            name = "Overlay Opacity",
            description = "Adjust the opacity of the overlay (1-100%)",
            position = 4,
            section = generalSection
    )
    default int opacityLevel() {
        return 75;
    }

    @ConfigItem(
            keyName = "toggleFeatureX",
            name = "Enable Feature X",
            description = "Turns on Feature X for better performance",
            position = 5,
            section = generalSection
    )
    default boolean toggleFeatureX() {
        return true;
    }

    @ConfigItem(
            keyName = "refreshRate",
            name = "Refresh Rate",
            description = "Adjust how often the plugin updates (in milliseconds)",
            position = 6,
            section = generalSection
    )
    @Units(Units.MILLISECONDS)
    default int refreshRate() {
        return 500;
    }

    @ConfigItem(
            keyName = "highlightColor",
            name = "Highlight Color",
            description = "Choose a color for highlights",
            position = 7,
            section = generalSection
    )

    @Alpha
    default Color highlightColor() {
        return Color.RED;
    }

    @ConfigItem(
            keyName = "logActions",
            name = "Log Actions",
            description = "Enable logging of actions for debugging",
            position = 8,
            section = generalSection
    )
    default boolean logActions() {
        return false;
    }
}