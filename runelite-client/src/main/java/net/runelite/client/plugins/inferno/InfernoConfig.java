/*
 * Copyright (c) 2019, Jacky <liangj97@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
		description = "Configuration options forPprayer",
		position = 0,
		keyName = "PrayerSection"
	)
	default boolean prayerSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Safespots",
		description = "Configuration options for Safespots",
		position = 1,
		keyName = "SafespotsSection"
	)
	default boolean safespotsSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Waves",
		description = "Configuration options for Waves",
		position = 2,
		keyName = "WavesSection"
	)
	default boolean wavesSection()
	{
		return false;
	}

	@ConfigSection(
		name = "ExtraSection",
		description = "Configuration options for Extras",
		position = 3,
		keyName = "ExtraSection"
	)
	default boolean extraSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Nibblers",
		description = "Configuration options for Nibblers",
		position = 4,
		keyName = "NibblersSection"
	)
	default boolean nibblersSection()
	{
		return false;
	}
	
	@ConfigSection(
		name = "Bats",
		description = "Configuration options for Bats",
		position = 5,
		keyName = "BatsSection"
	)
	default boolean batsSection()
	{
		return false;
	}
	
	@ConfigSection(
		name = "Blobs",
		description = "Configuration options for Blobs",
		position = 6,
		keyName = "BlobsSection"
	)
	default boolean blobsSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Meleers",
		description = "Configuration options for Meleers",
		position = 7,
		keyName = "MeleersSection"
	)
	default boolean meleersSection()
	{
		return false;
	}
	
	@ConfigSection(
		name = "Rangers",
		description = "Configuration options for Rangers",
		position = 8,
		keyName = "RangersSection"
	)
	default boolean rangersSection()
	{
		return false;
	}
	
	@ConfigSection(
		name = "Magers",
		description = "Configuration options for Magers",
		position = 9,
		keyName = "MagersSection"
	)
	default boolean magersSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Jad",
		description = "Configuration options for Jad",
		position = 10,
		keyName = "JadSection"
	)
	default boolean jadSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Jad Healers",
		description = "Configuration options for Jad Healers",
		position = 11,
		keyName = "JadHealersSection"
	)
	default boolean jadHealersSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Zuk",
		description = "Configuration options for  Zuk",
		position = 12,
		keyName = "ZukSection"
	)
	default boolean zukSection()
	{
		return false;
	}

	@ConfigSection(
		name = "Zuk Healers",
		description = "Configuration options for Zuk Healers",
		position = 13,
		keyName = "ZukHealersSection"
	)
	default boolean zukHealersSection()
	{
		return false;
	}

	
	@ConfigItem(
		position = 0,
		keyName = "prayerDisplayMode",
		name = "Prayer Display Mode",
		description = "Display prayer indicator in the prayer tab or in the bottom right corner of the screen",
		section = "PrayerSection"
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
		section = "PrayerSection"
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
		section = "PrayerSection"
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
		section = "PrayerSection"
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
		section = "SafespotsSection"
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
		section = "SafespotsSection"
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
		section = "SafespotsSection"
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
		section = "SafespotsSection"
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
		section = "SafespotsSection"
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
		section = "WavesSection"
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
		section = "WavesSection"
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
		section = "WavesSection"
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
		section = "WavesSection"
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
		section = "WavesSection"
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
		section = "ExtraSection"
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
		section = "NibblersSection"
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
		section = "NibblersSection"
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
		section = "NibblersSection"
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
		section = "BatsSection"
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
		section = "BatsSection"
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
		section = "BatsSection"
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
		section = "BatsSection"
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
		section = "BatsSection"
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
		section = "BlobsSection"
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
		section = "BlobsSection"
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
		section = "BlobsSection"
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
		section = "BlobsSection"
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
		section = "BlobsSection"
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
		section = "BlobsSection"
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
		section = "BlobsSection"
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
		section = "BlobsSection"
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
		section = "BlobsSection"
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
		section = "MeleersSection"
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
		section = "MeleersSection"
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
		section = "MeleersSection"
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
		section = "MeleersSection"
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
		section = "MeleersSection"
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
		section = "RangersSection"
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
		section = "RangersSection"
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
		section = "RangersSection"
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
		section = "RangersSection"
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
		section = "RangersSection"
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
		section = "MagersSection"
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
		section = "MagersSection"
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
		section = "MagersSection"
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
		section = "MagersSection"
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
		section = "MagersSection"
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
		section = "JadHealersSection"
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
		section = "JadHealersSection"
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
		section = "JadHealersSection"
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
		section = "JadHealersSection"
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
		section = "JadHealersSection"
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
		section = "JadSection"
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
		section = "JadSection"
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
		section = "JadSection"
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
		section = "JadSection"
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
		section = "ZukHealersSection"
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
		section = "ZukHealersSection"
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
		section = "ZukSection"
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
		section = "ZukSection"
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
		section = "ZukSection"
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
		section = "ZukSection"
	)
	default boolean hideZukDeath()
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
