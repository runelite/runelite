package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import net.runelite.client.config.*;
import ch.qos.logback.classic.Level;
import net.runelite.client.plugins.toolbox.core.LogLevel;

import java.awt.*;

@ConfigGroup("toolbox.leveling.woodcutting.alder_rise")
public interface AlderRiseConfig extends Config{

    //https://www.osrsbox.com/blog/2018/08/18/writing-runelite-plugins-part-3-config/

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
    default boolean enablePlugin() { return false; }

    @ConfigItem(
            keyName = "logLevel",
            name = "Log Level",
            description = "Enable logging Level",
            position = 2,
            section = generalSection
    )
    default LogLevel logLevel() { return LogLevel.INFO; }


    @ConfigSection(
            name = "TimberTool",
            description = "General settings TimberTools",
            position = 1
    )
    String generalTimberToolSection = "generalTimberToolSection";

    @ConfigItem(
            keyName = "enableRegularTree",
            name = "Enable Regular Tree",
            description = "Toggle the plugin to turn on Regular Tree Felling",
            position = 1,
            section = generalTimberToolSection
    )
    default boolean enableRegularTree() { return false; }
}