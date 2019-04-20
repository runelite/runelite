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

public interface TheatreConfig extends Config
{
    @ConfigItem(
            position = 0,
            keyName = "MaidenBlood",
            name = "Maiden blood attack",
            description = ""
    )
    default boolean MaidenBlood(){ return false; }

    @ConfigItem(
            position = 1,
            keyName = "MaidenSpawns",
            name = "Maiden blood spawns",
            description = ""
    )
    default boolean MaidenSpawns(){ return false; }

    @ConfigItem(
            position = 2,
            keyName = "BloatIndicator",
            name = "Bloat indicator",
            description = ""
    )
    default boolean BloatIndicator(){ return false; }

    @ConfigItem(
            position = 3,
            keyName = "BloatHands",
            name = "Bloat Falling Hands",
            description = ""
    )
    default boolean BloatHands(){ return false; }

    @ConfigItem(
            position = 4,
            keyName = "NyloPillars",
            name = "Nylocas pillar health",
            description = ""
    )
    default boolean NyloPillars(){ return false; }

    @ConfigItem(
            position = 5,
            keyName = "NyloBlasts",
            name = "Nylocas explosions",
            description = ""
    )
    default boolean NyloBlasts(){ return false; }

    @ConfigItem(
            position = 6,
            keyName = "SotetsegMaze1",
            name = "Sotetseg maze",
            description = ""
    )
    default boolean SotetsegMaze1(){ return false; }

    @ConfigItem(
            position = 7,
            keyName = "SotetsegMaze2",
            name = "Sotetseg maze (solo mode)",
            description = ""
    )
    default boolean SotetsegMaze2(){ return false; }

    @ConfigItem(
            position = 8,
            keyName = "SotetsegTick",
            name = "Sotetseg tick eat",
            description = ""
    )
    default boolean SotetsegTick(){ return false; }

    @ConfigItem(
            position = 9,
            keyName = "XarpusExhumed",
            name = "Xarpus exhumed",
            description = ""
    )
    default boolean XarpusExhumed(){ return false; }

    @ConfigItem(
            position = 10,
            keyName = "XarpusTick",
            name = "Xarpus tick",
            description = ""
    )
    default boolean XarpusTick(){ return false; }

    @ConfigItem(
            position = 11,
            keyName = "VerzikCupcakes",
            name = "Verzik cupcakes",
            description = " "
    )
    default boolean VerzikCupcakes(){ return false; }

    @ConfigItem(
            position = 12,
            keyName = "VerzikTick",
            name = "Verzik p3 tick",
            description = ""
    )
    default boolean VerzikTick(){ return false; }

    @ConfigItem(
            position = 13,
            keyName = "VerzikMelee",
            name = "Verzik p3 melee range",
            description = ""
    )
    default boolean VerzikMelee(){ return false; }

    @ConfigItem(
            position = 14,
            keyName = "VerzikYellow",
            name = "Verzik yellow timing",
            description = ""
    )
    default boolean VerzikYellow(){ return false; }
}
