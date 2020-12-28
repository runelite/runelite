package net.runelite.client.plugins.inferno;

import java.awt.Color;
import java.awt.Font;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.plugins.inferno.displaymodes.InfernoNamingDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoPrayerDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoSafespotDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoWaveDisplayMode;
import net.runelite.client.plugins.inferno.displaymodes.InfernoZukShieldDisplayMode;

@ConfigGroup("inferno")
public interface InfernoConfig extends Config
{

    @ConfigSection(
            name = "Prayer",
            description = "Configuration options for Prayer",
            position = 0
    )
    String prayerSection = "PrayerSection";
    @ConfigSection(
            name = "Safespots",
            description = "Configuration options for Safespots",
            position = 1
    )
    String safespotsSection = "SafespotsSection";
    @ConfigSection(
            name = "Waves",
            description = "Configuration options for Waves",
            position = 2
    )
    String wavesSection = "WavesSection";
    @ConfigSection(
            name = "ExtraSection",
            description = "Configuration options for Extras",
            position = 3
    )
    String extraSection = "ExtraSection";
    @ConfigSection(
            name = "Nibblers",
            description = "Configuration options for Nibblers",
            position = 4
    )
    String nibblersSection = "NibblersSection";
    @ConfigSection(
            name = "Bats",
            description = "Configuration options for Bats",
            position = 5
    )
    String batsSection = "BatsSection";
    @ConfigSection(
            name = "Blobs",
            description = "Configuration options for Blobs",
            position = 6
    )
    String blobsSection = "BlobsSection";
    @ConfigSection(
            name = "Meleers",
            description = "Configuration options for Meleers",
            position = 7
    )
    String meleersSection = "MeleersSection";
    @ConfigSection(
            name = "Rangers",
            description = "Configuration options for Rangers",
            position = 8
    )
    String rangersSection = "RangersSection";
    @ConfigSection(
            name = "Magers",
            description = "Configuration options for Magers",
            position = 9
    )
    String magersSection = "MagersSection";
    @ConfigSection(
            name = "Jad",
            description = "Configuration options for Jad",
            position = 10
    )
    String jadSection = "JadSection";
    @ConfigSection(
            name = "Jad Healers",
            description = "Configuration options for Jad Healers",
            position = 11
    )
    String jadHealersSection = "JadHealersSection";
    @ConfigSection(
            name = "Zuk",
            description = "Configuration options for  Zuk",
            position = 12
    )
    String zukSection = "ZukSection";
    @ConfigSection(
            name = "Zuk Healers",
            description = "Configuration options for Zuk Healers",
            position = 13
    )
    String zukHealersSection = "ZukHealersSection";


    @ConfigItem(
            position = 0,
            keyName = "prayerDisplayMode",
            name = "Prayer Display Mode",
            description = "Display prayer indicator in the prayer tab or in the bottom right corner of the screen",
            section = prayerSection
    )
    default InfernoPrayerDisplayMode prayerDisplayMode()
    {
        return InfernoPrayerDisplayMode.BOTH;
    }

    @ConfigItem(
            position = 1,
            keyName = "indicateWhenPrayingCorrectly",
            name = "Indicate When Praying Correctly",
            description = "Indicate the correct prayer, even if you are already praying that prayer",
            section = prayerSection
    )
    default boolean indicateWhenPrayingCorrectly()
    {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "descendingBoxes",
            name = "Descending Boxes",
            description = "Draws timing boxes above the prayer icons, as if you were playing Piano Tiles",
            section = prayerSection
    )
    default boolean descendingBoxes()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "indicateNonPriorityDescendingBoxes",
            name = "Indicate Non-Priority Boxes",
            description = "Render descending boxes for prayers that are not the priority prayer for that tick",
            section = prayerSection
    )
    default boolean indicateNonPriorityDescendingBoxes()
    {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "safespotDisplayMode",
            name = "Tile Safespots",
            description = "Indicate safespots on the ground: safespot (white), pray melee (red), pray range (green), pray magic (blue) and combinations of those",
            section = safespotsSection
    )
    default InfernoSafespotDisplayMode safespotDisplayMode()
    {
        return InfernoSafespotDisplayMode.AREA;
    }

    @ConfigItem(
            position = 5,
            keyName = "safespotsCheckSize",
            name = "Tile Safespots Check Size",
            description = "The size of the area around the player that should be checked for safespots (SIZE x SIZE area)",
            section = safespotsSection
    )
    default int safespotsCheckSize()
    {
        return 6;
    }

    @ConfigItem(
            position = 6,
            keyName = "indicateNonSafespotted",
            name = "Non-safespotted NPC's Overlay",
            description = "Red overlay for NPC's that can attack you",
            section = safespotsSection
    )
    default boolean indicateNonSafespotted()
    {
        return false;
    }

    @ConfigItem(
            position = 7,
            keyName = "indicateTemporarySafespotted",
            name = "Temporary safespotted NPC's Overlay",
            description = "Orange overlay for NPC's that have to move to attack you",
            section = safespotsSection
    )
    default boolean indicateTemporarySafespotted()
    {
        return false;
    }

    @ConfigItem(
            position = 8,
            keyName = "indicateSafespotted",
            name = "Safespotted NPC's Overlay",
            description = "Green overlay for NPC's that are safespotted (can't attack you)",
            section = safespotsSection
    )
    default boolean indicateSafespotted()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "waveDisplay",
            name = "Wave Display",
            description = "Shows monsters that will spawn on the selected wave(s).",
            section = wavesSection
    )
    default InfernoWaveDisplayMode waveDisplay()
    {
        return InfernoWaveDisplayMode.BOTH;
    }

    @ConfigItem(
            position = 1,
            keyName = "npcNaming",
            name = "NPC Naming",
            description = "Simple (ex: Bat) or Complex (ex: Jal-MejRah) NPC naming",
            section = wavesSection
    )
    default InfernoNamingDisplayMode npcNaming()
    {
        return InfernoNamingDisplayMode.SIMPLE;
    }

    @ConfigItem(
            position = 2,
            keyName = "npcLevels",
            name = "NPC Levels",
            description = "Show the combat level of the NPC next to their name",
            section = wavesSection
    )
    default boolean npcLevels()
    {
        return false;
    }

    @ConfigItem(
            position = 3,
            keyName = "getWaveOverlayHeaderColor",
            name = "Wave Header",
            description = "Color for Wave Header",
            section = wavesSection
    )
    default Color getWaveOverlayHeaderColor()
    {
        return Color.ORANGE;
    }

    @ConfigItem(
            position = 4,
            keyName = "getWaveTextColor",
            name = "Wave Text Color",
            description = "Color for Wave Texts",
            section = wavesSection
    )
    default Color getWaveTextColor()
    {
        return Color.WHITE;
    }

    @ConfigItem(
            position = 0,
            keyName = "indicateObstacles",
            name = "Obstacles",
            description = "Indicate obstacles that NPC's cannot pass through",
            section = extraSection
    )
    default boolean indicateObstacles()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "indicateNibblers",
            name = "Indicate Nibblers",
            description = "Indicate's nibblers that are alive",
            section = nibblersSection
    )
    default boolean indicateNibblers()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "hideJalNibDeath",
            name = "Hide On Death",
            description = "Hide Nibblers on death animation",
            section = nibblersSection
    )
    default boolean hideNibblerDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 2,
            keyName = "indicateCentralNibbler",
            name = "Indicate Central Nibbler",
            description = "Indicate the most central nibbler. If multiple nibblers will freeze the same amount of other nibblers, " +
                    "the nibbler closest to the player's location is chosen.",
            section = nibblersSection
    )
    default boolean indicateCentralNibbler()
    {
        return true;
    }

    @ConfigItem(
            position = 0,
            keyName = "prayerBat",
            name = "Prayer Helper",
            description = "Indicate the correct prayer when this NPC attacks",
            section = batsSection
    )
    default boolean prayerBat()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "ticksOnNpcBat",
            name = "Ticks on NPC",
            description = "Draws the amount of ticks before an NPC is going to attack on the NPC",
            section = batsSection
    )
    default boolean ticksOnNpcBat()
    {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "safespotsBat",
            name = "Safespots",
            description = "Enable or disable safespot calculation for this specific NPC. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = batsSection
    )
    default boolean safespotsBat()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "indicateNpcPositionBat",
            name = "Indicate Main Tile",
            description = "Indicate the main tile for multi-tile NPC's. This tile is used for and pathfinding.",
            section = batsSection
    )
    default boolean indicateNpcPositionBat()
    {
        return false;
    }

    @ConfigItem(
            position = 4,
            keyName = "hideJalMejRahDeath",
            name = "Hide On Death",
            description = "Hide Jal-MejRah on death animation",
            section = batsSection
    )
    default boolean hideBatDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "prayerBlob",
            name = "Prayer Helper",
            description = "Indicate the correct prayer when this NPC attacks",
            section = blobsSection
    )
    default boolean prayerBlob()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "indicateBlobDetectionTick",
            name = "Indicate Blob Dection Tick",
            description = "Show a prayer indicator (default: magic) for the tick on which the blob will detect prayer",
            section = blobsSection
    )
    default boolean indicateBlobDetectionTick()
    {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "ticksOnNpcBlob",
            name = "Ticks on NPC",
            description = "Draws the amount of ticks before an NPC is going to attack on the NPC",
            section = blobsSection
    )
    default boolean ticksOnNpcBlob()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "safespotsBlob",
            name = "Safespots",
            description = "Enable or disable safespot calculation for this specific NPC. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = blobsSection
    )
    default boolean safespotsBlob()
    {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "indicateNpcPositionBlob",
            name = "Indicate Main Tile",
            description = "Indicate the main tile for multi-tile NPC's. This tile is used for pathfinding.",
            section = blobsSection
    )
    default boolean indicateNpcPositionBlob()
    {
        return false;
    }

    @ConfigItem(
            position = 5,
            keyName = "hideJalAkDeath",
            name = "Hide Blob On Death",
            description = "Hide Jal-Ak on death animation",
            section = blobsSection
    )
    default boolean hideBlobDeath()
    {
        return false;
    }


    @ConfigItem(
            position = 6,
            keyName = "hideJalAkRekXilDeath",
            name = "Hide Small Range Blob On Death",
            description = "Hide Jal-AkRek-Xil on death animation",
            section = blobsSection
    )
    default boolean hideBlobSmallRangedDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 7,
            keyName = "hideJalAkRekMejDeath",
            name = "Hide Small Magic Blob On Death",
            description = "Hide Jal-AkRek-Mej on death animation",
            section = blobsSection
    )
    default boolean hideBlobSmallMagicDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 8,
            keyName = "hideJalAkRekKetDeath",
            name = "Hide Small Melee Blob On Death",
            description = "Hide Jal-AkRek-Ket on death animation",
            section = blobsSection
    )
    default boolean hideBlobSmallMeleeDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "prayerMeleer",
            name = "Prayer Helper",
            description = "Indicate the correct prayer when this NPC attacks",
            section = meleersSection
    )
    default boolean prayerMeleer()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "ticksOnNpcMeleer",
            name = "Ticks on NPC",
            description = "Draws the amount of ticks before an NPC is going to attack on the NPC",
            section = meleersSection
    )
    default boolean ticksOnNpcMeleer()
    {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "safespotsMeleer",
            name = "Safespots",
            description = "Enable or disable safespot calculation for this specific NPC. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = meleersSection
    )
    default boolean safespotsMeleer()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "indicateNpcPositionMeleer",
            name = "Indicate Main Tile",
            description = "Indicate the main tile for multi-tile NPC's. This tile is used for pathfinding.",
            section = meleersSection
    )
    default boolean indicateNpcPositionMeleer()
    {
        return false;
    }

    @ConfigItem(
            position = 4,
            keyName = "hideJalImKotDeath",
            name = "Hide On Death",
            description = "Hide Jal-ImKot on death animation",
            section = meleersSection
    )
    default boolean hideMeleerDeath()
    {
        return false;
    }


    @ConfigItem(
            position = 0,
            keyName = "prayerRanger",
            name = "Prayer Helper",
            description = "Indicate the correct prayer when this NPC attacks",
            section = rangersSection
    )
    default boolean prayerRanger()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "ticksOnNpcRanger",
            name = "Ticks on NPC",
            description = "Draws the amount of ticks before an NPC is going to attack on the NPC",
            section = rangersSection
    )
    default boolean ticksOnNpcRanger()
    {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "safespotsRanger",
            name = "Safespots",
            description = "Enable or disable safespot calculation for this specific NPC. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = rangersSection
    )
    default boolean safespotsRanger()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "indicateNpcPositionRanger",
            name = "Indicate Main Tile",
            description = "Indicate the main tile for multi-tile NPC's. This tile is used for pathfinding.",
            section = rangersSection
    )
    default boolean indicateNpcPositionRanger()
    {
        return false;
    }

    @ConfigItem(
            position = 4,
            keyName = "hideJalXilDeath",
            name = "Hide On Death",
            description = "Hide Jal-Xil on death animation",
            section = rangersSection
    )
    default boolean hideRangerDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "prayerMage",
            name = "Prayer Helper",
            description = "Indicate the correct prayer when this NPC attacks",
            section = magersSection
    )
    default boolean prayerMage()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "ticksOnNpcMage",
            name = "Ticks on NPC",
            description = "Draws the amount of ticks before an NPC is going to attack on the NPC",
            section = magersSection
    )
    default boolean ticksOnNpcMage()
    {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "safespotsMage",
            name = "Safespots",
            description = "Enable or disable safespot calculation for this specific NPC. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = magersSection
    )
    default boolean safespotsMage()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "indicateNpcPositionMage",
            name = "Indicate Main Tile",
            description = "Indicate the main tile for multi-tile NPC's. This tile is used for pathfinding.",
            section = magersSection
    )
    default boolean indicateNpcPositionMage()
    {
        return false;
    }

    @ConfigItem(
            position = 4,
            keyName = "hideJalZekDeath",
            name = "Hide On Death",
            description = "Hide Jal-Zek on death animation",
            section = magersSection
    )
    default boolean hideMagerDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "prayerHealersJad",
            name = "Prayer Helper",
            description = "Indicate the correct prayer when this NPC attacks",
            section = jadHealersSection
    )
    default boolean prayerHealerJad()
    {
        return false;
    }

    @ConfigItem(
            position = 1,
            keyName = "ticksOnNpcHealersJad",
            name = "Ticks on NPC",
            description = "Draws the amount of ticks before an NPC is going to attack on the NPC",
            section = jadHealersSection
    )
    default boolean ticksOnNpcHealerJad()
    {
        return false;
    }

    @ConfigItem(
            position = 2,
            keyName = "safespotsHealersJad",
            name = "Safespots",
            description = "Enable or disable safespot calculation for this specific NPC. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = jadHealersSection
    )
    default boolean safespotsHealerJad()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "indicateActiveHealersJad",
            name = "Indicate Active Healers",
            description = "Indicate healers that are still healing Jad",
            section = jadHealersSection
    )
    default boolean indicateActiveHealerJad()
    {
        return true;
    }

    @ConfigItem(
            position = 4,
            keyName = "hideYtHurKotDeath",
            name = "Hide On Death",
            description = "Hide Yt-HurKot on death animation",
            section = jadHealersSection
    )
    default boolean hideHealerJadDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "prayerJad",
            name = "Prayer Helper",
            description = "Indicate the correct prayer when this NPC attacks",
            section = jadSection
    )
    default boolean prayerJad()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "ticksOnNpcJad",
            name = "Ticks on NPC",
            description = "Draws the amount of ticks before an NPC is going to attack on the NPC",
            section = jadSection
    )
    default boolean ticksOnNpcJad()
    {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "safespotsJad",
            name = "Safespots (Melee Range Only)",
            description = "Enable or disable safespot calculation for this specific NPC. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = jadSection
    )
    default boolean safespotsJad()
    {
        return true;
    }

    @ConfigItem(
            position = 3,
            keyName = "hideJalTokJadDeath",
            name = "Hide On Death",
            description = "Hide JalTok-Jad on death animation",
            section = jadSection
    )
    default boolean hideJadDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "indicateActiveHealersZuk",
            name = "Indicate Active Healers (UNTESTED)",
            description = "Indicate healers that are still healing Zuk",
            section = zukHealersSection
    )
    default boolean indicateActiveHealerZuk()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "hideJalMejJakDeath",
            name = "Hide On Death",
            description = "Hide Jal-MejJak on death animation",
            section = zukHealersSection
    )
    default boolean hideHealerZukDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 0,
            keyName = "ticksOnNpcZuk",
            name = "Ticks on NPC",
            description = "Draws the amount of ticks before an NPC is going to attack on the NPC",
            section = zukSection
    )
    default boolean ticksOnNpcZuk()
    {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "safespotsZukShieldBeforeHealers",
            name = "Safespots (Before Healers)",
            description = "Indicate the zuk shield safespots. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = zukSection
    )
    default InfernoZukShieldDisplayMode safespotsZukShieldBeforeHealers()
    {
        return InfernoZukShieldDisplayMode.PREDICT;
    }

    @ConfigItem(
            position = 2,
            keyName = "safespotsZukShieldAfterHealers",
            name = "Safespots (After Healers)",
            description = "Indicate the zuk shield safespots. 'Tile Safespots' in the 'Safespots' category needs to be turned on for this to take effect.",
            section = zukSection
    )
    default InfernoZukShieldDisplayMode safespotsZukShieldAfterHealers()
    {
        return InfernoZukShieldDisplayMode.LIVE;
    }

    @ConfigItem(
            position = 3,
            keyName = "hideTzKalZukDeath",
            name = "Hide On Death",
            description = "Hide TzKal-Zuk on death animation",
            section = zukSection
    )
    default boolean hideZukDeath()
    {
        return false;
    }

    @ConfigItem(
            position = 4,
            keyName = "ticksOnNpcZukShield",
            name = "Ticks on Zuk Shield",
            description = "Draws the amount of ticks before Zuk attacks on the floating shield",
            section = zukSection
    )
    default boolean ticksOnNpcZukShield()
    {
        return false;
    }

    @Getter
    @AllArgsConstructor
    enum FontStyle
    {
        BOLD("Bold", Font.BOLD),
        ITALIC("Italic", Font.ITALIC),
        PLAIN("Plain", Font.PLAIN);

        private String name;
        private int font;

        @Override
        public String toString()
        {
            return getName();
        }
    }
}
