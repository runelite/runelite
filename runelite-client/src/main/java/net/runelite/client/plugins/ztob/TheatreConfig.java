/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.ztob;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("Theatre")

public interface TheatreConfig extends Config {
    @ConfigItem(
            position = 0,
            keyName = "MaidenBlood",
            name = "Maiden blood attack",
            description = ""
    )
    default boolean MaidenBlood() {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "MaidenSpawns",
            name = "Maiden blood spawns",
            description = ""
    )
    default boolean MaidenSpawns() {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "BloatIndicator",
            name = "Bloat Indicator",
            description = ""
    )
    default boolean BloatIndicator() {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "bloat Timer",
            name = "Bloat Timer",
            description = ""
    )
    default boolean bloatTimer() {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "bloatFeet",
            name = "Bloat Feet",
            description = ""
    )
    default boolean bloatFeetIndicator() {
        return true;
    }

    @ConfigItem(
            position = 5,
            keyName = "NyloPillars",
            name = "Nylocas pillar health",
            description = ""
    )
    default boolean NyloPillars() {
        return true;
    }


    @ConfigItem(
            position = 6,
            keyName = "NyloBlasts",
            name = "Nylocas explosions",
            description = ""
    )
    default boolean NyloBlasts() {
        return true;
    }

    @ConfigItem(
            position = 7,
            keyName = "NyloMenu",
            name = "Hide Attack options for Nylocas",
            description = ""
    )

    default boolean NyloMenu() {
        return true;
    }

    @ConfigItem(
            position = 8,
            keyName = "SotetsegMaze1",
            name = "Sotetseg maze",
            description = ""
    )
    default boolean SotetsegMaze1() {
        return true;
    }

    @ConfigItem(
            position = 9,
            keyName = "SotetsegMaze2",
            name = "Sotetseg maze (solo mode)",
            description = ""
    )
    default boolean SotetsegMaze2() {
        return true;
    }

    @ConfigItem(
            position = 10,
            keyName = "XarpusExhumed",
            name = "Xarpus Exhumed",
            description = ""
    )
    default boolean XarpusExhumed() {
        return true;
    }

    @ConfigItem(
            position = 11,
            keyName = "XarpusTick",
            name = "Xarpus Tick",
            description = ""
    )
    default boolean XarpusTick() {
        return false;
    }

    @ConfigItem(
            position = 12,
            keyName = "xarpusExhumes",
            name = "Xarpus Exhume Counter",
            description = ""
    )
    default boolean XarpusExhumeOverlay() {
        return false;
    }

    @ConfigItem(
            position = 13,
            keyName = "VerzikCupcakes",
            name = "Verzik Projectile Markers",
            description = ""
    )
    default boolean VerzikCupcakes() {
        return false;
    }

    @ConfigItem(
            position = 14,
            keyName = "VerzikTick",
            name = "Verzik P3 Tick",
            description = ""
    )
    default boolean VerzikTick() {
        return false;
    }

    @ConfigItem(
            position = 15,
            keyName = "VerzikMelee",
            name = "Verzik P3 Melee Range",
            description = ""
    )
    default boolean VerzikMelee() {
        return false;
    }

    @ConfigItem(
            position = 16,
            keyName = "VerzikYellow",
            name = "Verzik Yellow Timing",
            description = ""
    )
    default boolean VerzikYellow() {
        return false;
    }

    @ConfigItem(
            position = 17,
            keyName = "Verzik Nylo",
            name = "Verzik Nylo Overlay",
            description = ""
    )
    default boolean NyloTargetOverlay() {
        return false;
    }

    @ConfigItem(
            position = 18,
            keyName = "VerzikTankTile",
            name = "Verzik P3 Tile Overlay",
            description = ""
    )
    default boolean verzikTankTile() {
        return true;
    }


}