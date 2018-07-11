/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.bosslogger;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup("bosslogger")
public interface BossLoggerConfig extends Config
{
	@ConfigItem(
		keyName = "recordBarrowsChest",
		name = "Barrows Chest Loot",
		description = "Configures whether or not loot from Barrows Chests is recorded",
		position = 0
	)

	default boolean recordBarrowsChest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordRaidsChest",
		name = "Raids Chest Loot",
		description = "Configures whether or not loot from Raids is recorded",
		position = 1
	)

	default boolean recordRaidsChest()
	{
		return true;
	}

	@ConfigItem(
			keyName = "recordTobChest",
			name = "Theater of Blood Loot",
			description = "Configures whether or not loot from Theater of Blood is recorded",
			position = 2
	)

	default boolean recordTobChest()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordZulrahKills",
		name = "Zulrah Loot",
		description = "Configures whether or not loot from Zulrah is recorded",
		position = 2
	)

	default boolean recordZulrahKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordVorkathKills",
		name = "Vorkath Loot",
		description = "Configures whether or not loot from Vorkath is recorded",
		position = 3
	)

	default boolean recordVorkathKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordArmadylKills",
		name = "Kree'arra Loot",
		description = "Configures whether or not loot from Kree'arra is recorded",
		position = 4
	)

	default boolean recordArmadylKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordBandosKills",
		name = "General Graardor Loot",
		description = "Configures whether or not loot from General Graardor is recorded",
		position = 5
	)

	default boolean recordBandosKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordSaradominKills",
		name = "Commander Zilyana Loot",
		description = "Configures whether or not loot from Commander Zilyana is recorded",
		position = 6
	)

	default boolean recordSaradominKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordZammyKills",
		name = "K'ril Tsutsaroth Loot",
		description = "Configures whether or not loot from K'ril Tsutsaroth is recorded",
		position = 7
	)

	default boolean recordZammyKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordVetionKills",
		name = "Vet'ion Loot",
		description = "Configures whether or not loot from Vet'ion is recorded",
		position = 8
	)

	default boolean recordVetionKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordVenenatisKills",
		name = "Venenatis Loot",
		description = "Configures whether or not loot from Venenatis is recorded",
		position = 9
	)

	default boolean recordVenenatisKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordCallistoKills",
		name = "Callisto Loot",
		description = "Configures whether or not loot from Callisto is recorded",
		position = 10
	)

	default boolean recordCallistoKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordChaosElementalKills",
		name = "Chaos Elemental Loot",
		description = "Configures whether or not loot from Chaos Elemental is recorded",
		position = 11
	)

	default boolean recordChaosElementalKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordChaosFanaticKills",
		name = "Chaos Fanatic Loot",
		description = "Configures whether or not loot from Chaos Fanatic is recorded",
		position = 12
	)

	default boolean recordScorpiaKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordKbdKills",
		name = "King Black Dragon Loot",
		description = "Configures whether or not loot from King Black Dragon is recorded",
		position = 13
	)

	default boolean recordChaosFanaticKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordCrazyArchaeologistKills",
		name = "Crazy Archaeologist Loot",
		description = "Configures whether or not loot from Crazy Archaeologist is recorded",
		position = 14
	)

	default boolean recordCrazyArchaeologistKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordScorpiaKills",
		name = "Scorpia Loot",
		description = "Configures whether or not loot from Scorpia is recorded",
		position = 15
	)

	default boolean recordKbdKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordSkotizoKills",
		name = "Skotizo Loot",
		description = "Configures whether or not loot from Skotizo is recorded",
		position = 16
	)

	default boolean recordSkotizoKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordGrotesqueGuardiansKills",
		name = "Grotesque Guardians Loot",
		description = "Configures whether or not loot from Grotesque Guardians is recorded",
		position = 17
	)

	default boolean recordGrotesqueGuardiansKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordAbyssalSireKills",
		name = "Abyssal Sire Loot",
		description = "Configures whether or not loot from Abyssal Sire is recorded",
		position = 18
	)

	default boolean recordAbyssalSireKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordKrakenKills",
		name = "Kraken Loot",
		description = "Configures whether or not loot from Kraken is recorded",
		position = 19
	)

	default boolean recordKrakenKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordCerberusKills",
		name = "Cerberus Loot",
		description = "Configures whether or not loot from Cerberus is recorded",
		position = 20
	)

	default boolean recordCerberusKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordThermonuclearSmokeDevilKills",
		name = "Thermonuclear Smoke Devil Loot",
		description = "Configures whether or not loot from Thermonuclear Smoke Devil is recorded",
		position = 21
	)

	default boolean recordThermonuclearSmokeDevilKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordGiantMoleKills",
		name = "Giant Mole Loot",
		description = "Configures whether or not loot from Giant Mole is recorded",
		position = 22
	)

	default boolean recordGiantMoleKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordKalphiteQueenKills",
		name = "Kalphite Queen Loot",
		description = "Configures whether or not loot from Kalphite Queen is recorded",
		position = 23
	)

	default boolean recordKalphiteQueenKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordCorporealBeastKills",
		name = "Corporeal Beast Loot",
		description = "Configures whether or not loot from Corporeal Beast is recorded",
		position = 24
	)

	default boolean recordCorporealBeastKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordDagannothRexKills",
		name = "Dagannoth Rex Loot",
		description = "Configures whether or not loot from Dagannoth Rex is recorded",
		position = 25
	)

	default boolean recordDagannothRexKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordDagannothPrimeKills",
		name = "Dagannoth Prime Loot",
		description = "Configures whether or not loot from Dagannoth Prime is recorded",
		position = 26
	)

	default boolean recordDagannothPrimeKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordDagannothSupremeKills",
		name = "Dagannoth Supreme Loot",
		description = "Configures whether or not loot from Dagannoth Supreme is recorded",
		position = 27
	)

	default boolean recordDagannothSupremeKills()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordEasyClues",
		name = "Easy Clue Scroll Loot",
		description = "Configures whether or not loot from Easy clue scrolls is recorded",
		position = 28
	)

	default boolean recordEasyClues()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordMediumClues",
		name = "Medium Clue Scroll Loot",
		description = "Configures whether or not loot from Medium clue scrolls is recorded",
		position = 29
	)

	default boolean recordMediumClues()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordHardClues",
		name = "Hard Clue Scroll Loot",
		description = "Configures whether or not loot from Hard clue scrolls is recorded",
		position = 30
	)

	default boolean recordHardClues()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordEliteClues",
		name = "Elite Clue Scroll Loot",
		description = "Configures whether or not loot from Elite clue scrolls is recorded",
		position = 31
	)

	default boolean recordEliteClues()
	{
		return true;
	}

	@ConfigItem(
		keyName = "recordMasterClues",
		name = "Master Clue Scroll Loot",
		description = "Configures whether or not loot from Master clue scrolls is recorded",
		position = 32
	)

	default boolean recordMasterClues()
	{
		return true;
	}


	@ConfigItem(
		keyName = "showChatMessages",
		name = "In-game Chat Message Alerts",
		description = "In-Game Chat Messages when Loot Recorded",
		position = 96
	)

	default boolean showChatMessages()
	{
		return true;
	}

	@ConfigItem(
		keyName = "chatMessageColor",
		name = "Chat Message Color",
		description = "Color of the Chat Message alerts",
		position = 97
	)

	default Color chatMessageColor()
	{
		return new Color(0, 75, 255);
	}


	@ConfigItem(
		keyName = "showTrayAlerts",
		name = "Notification Tray Alerts",
		description = "Create Notification Tray alerts when Loot Recorded?",
		position = 98
	)

	default boolean showTrayAlerts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLootTotals",
		name = "Show Recorded Loots Panel",
		description = "Configures whether or not the Recorded Loots Panel is shown",
		position = 99
	)

	default boolean showLootTotals()
	{
		return true;
	}
}
