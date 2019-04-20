/*
 * Decompiled with CFR 0.139.
 */
package net.runelite.client.plugins.pvptools;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup(value="pvptools")
public interface PvpToolsConfig
extends Config {
    @ConfigItem(keyName="countPlayers", name="Count Players", description="When in PvP zones, counts the attackable players in and not in player's CC", position=3)
    default public boolean countPlayers() {
        return true;
    }

    @ConfigItem(keyName="countOverHeads", name="Count Enemy Overheads", description="Counts the number of each protection prayer attackable targets not in your CC are currently using", position=4)
    default public boolean countOverHeads() {
        return true;
    }

    @ConfigItem(keyName="fallInHelper", name="Fall In Helper", description="Hides all non-friendly player entities other than the one that is attacking you.", position=5)
    default public boolean fallInHelper() {
        return true;
    }

    @ConfigItem(keyName="hotkey", name="Fall In Hotkey", description="Turns the fall in helper on or off when you press this hotkey", position=6)
    default public Keybind hotkey() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName="attackOptionsClan", name="Hide CC Attack Option", description="Hides the attack option for people in the same CC", position=7)
    default public boolean attackOptionsClan() {
        return false;
    }

    @ConfigItem(keyName="attackOptionsFriend", name="Hide Friend Attack Options", description="Hides the attack option for people on your friends list", position=8)
    default public boolean attackOptionsFriend() {
        return false;
    }

    @ConfigItem(keyName="attackOptionsHotkey", name="Attack Option Hotkey", description="Enables a hotkey for attack options to disable or enable hiding quickly", position=10)
    default public Keybind attackOptionsHotkey() {
        return Keybind.CTRL;
    }

    @ConfigItem(keyName="levelRangeAttackOptions", name="Hide Other Attack Options", description="Hides the attack option for people that are outside your level range", position=9)
    default public boolean levelRangeAttackOptions() {
        return false;
    }

    @ConfigItem(keyName="riskCalculator", name="Risk Calculator", description="Enables a panel in the PvP Tools Panel that shows the players current risk", position=13)
    default public boolean riskCalculatorEnabled() {
        return true;
    }

    @ConfigItem(keyName="missingPlayers", name="Missing CC Players", description="Adds a button to the PvP Tools panel that opens a window showing which CC members are not at the current players location", position=14)
    default public boolean missingPlayersEnabled() {
        return true;
    }

    @ConfigItem(keyName="currentPlayers", name="Current CC Players", description="Adds a button to the PvP Tools panel that opens a window showing which CC members currently at the players location", position=15)
    default public boolean currentPlayersEnabled() {
        return true;
    }
}

