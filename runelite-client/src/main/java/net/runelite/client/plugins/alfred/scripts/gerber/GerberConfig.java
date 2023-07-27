package net.runelite.client.plugins.alfred.scripts.gerber;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(GerberPlugin.CONFIG_GROUP)
public interface GerberConfig extends Config {
    @ConfigSection(
            name = "Settings",
            description = "Settings",
            position = 0,
            closedByDefault = false
    )
    String settingsSection = "settings";

    @ConfigItem(
            keyName = "collectItems",
            name = "Loot Items",
            description = "Loot Items",
            position = 0,
            section = settingsSection
    )
    default boolean collectItems() {
        return true;
    }

    @ConfigItem(
            keyName = "buryBones",
            name = "Bury Bones",
            description = "Bury Bones",
            position = 1,
            section = settingsSection
    )
    default boolean buryBones() {
        return true;
    }

    @ConfigSection(
            name = "Skill Levels",
            description = "Skill Levels",
            position = 1,
            closedByDefault = false
    )
    String skillsSection = "skills";

    @ConfigItem(
            keyName = "attackLevel",
            name = "Attack",
            description = " Attack Level",
            position = 0,
            section = skillsSection
    )
    default int attackLevel() {
        return 0;
    }

    @ConfigItem(
            keyName = "strengthLevel",
            name = "Strength",
            description = " Strength Level",
            position = 1,
            section = skillsSection
    )
    default int strengthLevel() {
        return 0;
    }

    @ConfigItem(
            keyName = "defenseLevel",
            name = "Defense",
            description = " Defense Level",
            position = 2,
            section = skillsSection
    )
    default int defenseLevel() {
        return 0;
    }

    @ConfigItem(
            keyName = "prayerLevel",
            name = "Prayer",
            description = " Prayer Level",
            position = 3,
            section = skillsSection
    )
    default int prayerLevel() {
        return 0;
    }
}
