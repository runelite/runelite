/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.gauntlet;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("Gauntlet")

public interface GauntletConfig extends Config {

    @ConfigItem(
            position = 0,
            keyName = "highlightResourcesColor",
            name = "Highlight Resources (Color)",
            description = "Highlights all the resources in each room with a color."
    )
    default boolean highlightResourcesColor() {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "highlightResourcesIcons",
            name = "Highlight Resources (Icon)",
            description = "Highlights all the icons in each room with an icon."
    )
    default boolean highlightResourcesIcons() {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "countBossAttacks",
            name = "Count Boss Attacks",
            description = "Count the attacks until the boss switches their style."
    )
    default boolean countBossAttacks() {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "countPlayerAttacks",
            name = "Count Player Attacks",
            description = "Count the player attacks until the boss switches their prayer."
    )
    default boolean countPlayerAttacks() {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "uniquePrayerAudio",
            name = "Unique Prayer Audio",
            description = "Plays a unique sound whenever the boss is about to shut down your prayer."
    )
    default boolean uniquePrayerAudio() {
        return true;
    }

    @ConfigItem(
            position = 5,
            keyName = "uniquePrayerVisual",
            name = "Unique Prayer Visual",
            description = "Prayer attacks will have a unique overlay visual."
    )
    default boolean uniquePrayerVisual() {
        return true;
    }

    @ConfigItem(
            position = 6,
            keyName = "uniqueAttackVisual",
            name = "Unique Magic & Range Visuals",
            description = "Magic and Range attacks will have a unique overlay visual."
    )
    default boolean uniqueAttackVisual() {
        return false;
    }

    @ConfigItem(
            position = 7,
            keyName = "overlayBoss",
            name = "Overlay the Boss (Color)",
            description = "Overlay the boss with an color denoting it's current attack style."
    )
    default boolean overlayBoss() {
        return true;
    }

    @ConfigItem(
            position = 8,
            keyName = "overlayBossPrayer",
            name = "Overlay the Boss (Icon)",
            description = "Overlay the boss with an icon denoting it's current attack style."
    )
    default boolean overlayBossPrayer() {
        return false;
    }

    @ConfigItem(
            position = 9,
            keyName = "overlayTornadoes",
            name = "Show Tornado Decay",
            description = "Display the amount of ticks left until the tornadoes decay."
    )
    default boolean overlayTornadoes() {
        return true;
    }

    @ConfigItem(
            position = 10,
            keyName = "displayTimerWidget",
            name = "Show Custom Timer (Widget)",
            description = "Display a timer widget that tracks your gauntlet progress."
    )
    default boolean displayTimerWidget() {
        return true;
    }

    @ConfigItem(
            position = 11,
            keyName = "displayTimerChat",
            name = "Show Custom Timer (Chat)",
            description = "Display a chat message that tracks your gauntlet progress."
    )
    default boolean displayTimerChat() {
        return true;
    }

    @Range(
            min = 1,
            max = 50
    )
    @ConfigItem(
            position = 12,
            keyName = "iconSize",
            name = "Global Icon Size",
            description = "Globally change the size of icons. { Range: 1 to 50 }"
    )
    default int iconSize() {
        return 20;
    }
}
