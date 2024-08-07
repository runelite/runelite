/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.timersandbuffs;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import java.time.Instant;

@ConfigGroup(TimersAndBuffsConfig.GROUP)
public interface TimersAndBuffsConfig extends Config
{
	String GROUP = "timers";

	@ConfigSection(
		name = "Bosses",
		description = "Timers and buffs related to bosses",
		position = 0
	)
	String bossesSection = "bossesSection";

	@ConfigSection(
		name = "Potions & Consumables",
		description = "Timers and buffs related to potions/consumables/boosts",
		position = 1
	)
	String consumablesSection = "consumablesSection";

	@ConfigSection(
		name = "Spells",
		description = "Timers and buffs related to spells you cast",
		position = 2
	)
	String spellsSection = "spellsSection";

	@ConfigSection(
		name = "Miscellaneous",
		description = "Timers and buffs related to miscellaneous items or activities",
		position = 3
	)
	String miscellaneousSection = "miscellaneousSection";

	@ConfigItem(
		keyName = "showHomeMinigameTeleports",
		name = "Teleport cooldown timers",
		description = "Configures whether timers for home and minigame teleport cooldowns are displayed",
		section = miscellaneousSection
	)
	default boolean showHomeMinigameTeleports()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAntipoison",
		name = "Antipoison/Venom timers",
		description = "Configures whether timers for poison and venom protection are displayed",
		section = consumablesSection
	)
	default boolean showAntiPoison()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAntiFire",
		name = "Antifire timer",
		description = "Configures whether antifire timer is displayed",
		section = consumablesSection
	)
	default boolean showAntiFire()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showStamina",
		name = "Stamina timer",
		description = "Configures whether stamina timer is displayed",
		section = consumablesSection
	)
	default boolean showStamina()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showOverload",
		name = "Overload timer",
		description = "Configures whether overload timer is displayed",
		section = consumablesSection
	)
	default boolean showOverload()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showLiquidAdrenaline",
		name = "Liquid adrenaline timer",
		description = "Configures whether liquid adrenaline timer is displayed",
		section = consumablesSection
	)
	default boolean showLiquidAdrenaline()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMenaphiteRemedy",
		name = "Menaphite remedy timer",
		description = "Configures whether Menaphite remedy timer is displayed",
		section = consumablesSection
	)
	default boolean showMenaphiteRemedy()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSilkDressing",
		name = "Silk dressing timer",
		description = "Configures whether silk dressing timer is displayed",
		section = consumablesSection
	)
	default boolean showSilkDressing()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBlessedCrystalScarab",
		name = "Blessed crystal scarab timer",
		description = "Configures whether blessed crystal scarab timer is displayed",
		section = consumablesSection
	)
	default boolean showBlessedCrystalScarab()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showPrayerEnhance",
		name = "Prayer enhance timer",
		description = "Configures whether prayer enhance timer is displayed",
		section = consumablesSection
	)
	default boolean showPrayerEnhance()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDivine",
		name = "Divine potion timer",
		description = "Configures whether divine potion timer is displayed",
		section = consumablesSection
	)
	default boolean showDivine()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCannon",
		name = "Cannon timer",
		description = "Configures whether cannon timer is displayed",
		section = miscellaneousSection
	)
	default boolean showCannon()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMagicImbue",
		name = "Magic imbue timer",
		description = "Configures whether magic imbue timer is displayed",
		section = spellsSection
	)
	default boolean showMagicImbue()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCharge",
		name = "Charge timer",
		description = "Configures whether to show a timer for the Charge spell",
		section = spellsSection
	)
	default boolean showCharge()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showImbuedHeart",
		name = "Imbued heart timer",
		description = "Configures whether imbued heart timer is displayed",
		section = consumablesSection
	)
	default boolean showImbuedHeart()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showVengeance",
		name = "Vengeance timer",
		description = "Configures whether vengeance and vengeance other timer is displayed",
		section = spellsSection
	)
	default boolean showVengeance()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showVengeanceActive",
		name = "Vengeance active",
		description = "Configures whether an indicator for vengeance being active is displayed",
		section = spellsSection
	)
	default boolean showVengeanceActive()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showHealGroup",
		name = "Heal Group timer",
		description = "Configures whether heal group timer is displayed",
		section = spellsSection
	)
	default boolean showHealGroup()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTeleblock",
		name = "Teleblock timer",
		description = "Configures whether teleblock timer is displayed",
		section = miscellaneousSection
	)
	default boolean showTeleblock()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFreezes",
		name = "Freeze timer",
		description = "Configures whether freeze timer is displayed",
		section = miscellaneousSection
	)
	default boolean showFreezes()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showGodWarsAltar",
		name = "God wars altar timer",
		description = "Configures whether god wars altar timer is displayed",
		section = bossesSection
	)
	default boolean showGodWarsAltar()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTzhaarTimers",
		name = "Fight Caves and Inferno timers",
		description = "Display elapsed time in the Fight Caves and Inferno",
		section = bossesSection
	)
	default boolean showTzhaarTimers()
	{
		return true;
	}

	@ConfigItem(
		keyName = "tzhaarStartTime",
		name = "",
		description = "",
		hidden = true
	)
	Instant tzhaarStartTime();

	@ConfigItem(
		keyName = "tzhaarStartTime",
		name = "",
		description = ""
	)
	void tzhaarStartTime(Instant tzhaarStartTime);

	@ConfigItem(
		keyName = "tzhaarLastTime",
		name = "",
		description = "",
		hidden = true
	)
	Instant tzhaarLastTime();

	@ConfigItem(
		keyName = "tzhaarLastTime",
		name = "",
		description = ""
	)
	void tzhaarLastTime(Instant tzhaarLastTime);

	@ConfigItem(
		keyName = "showStaffOfTheDead",
		name = "Staff of the Dead timer",
		description = "Configures whether staff of the dead timer is displayed",
		section = miscellaneousSection
	)
	default boolean showStaffOfTheDead()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showAbyssalSireStun",
		name = "Abyssal Sire stun timer",
		description = "Configures whether Abyssal Sire stun timer is displayed",
		section = bossesSection
	)
	default boolean showAbyssalSireStun()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showDfsSpecial",
		name = "Dragonfire Shield special timer",
		description = "Configures whether the special attack cooldown timer for the Dragonfire Shield is displayed",
		section = miscellaneousSection
	)
	default boolean showDFSSpecial()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showArceuus",
		name = "Arceuus spells duration",
		description = "Whether to show Arceuus spellbook spell timers",
		section = spellsSection
	)
	default boolean showArceuus()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showArceuusCooldown",
		name = "Arceuus spells cooldown",
		description = "Whether to show cooldown timers for Arceuus spellbook spells",
		section = spellsSection
	)
	default boolean showArceuusCooldown()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showPickpocketStun",
		name = "Pickpocket stun timer",
		description = "Configures whether pickpocket stun timer is displayed",
		section = miscellaneousSection
	)
	default boolean showPickpocketStun()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showFarmersAffinity",
		name = "Farmer's Affinity",
		description = "Configures whether Farmer's Affinity (Puro-Puro) timer is displayed",
		section = miscellaneousSection
	)
	default boolean showFarmersAffinity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSpellbookSwap",
		name = "Spellbook Swap timer",
		description = "Configures whether Spellbook Swap timer is displayed",
		section = spellsSection
	)
	default boolean showSpellbookSwap()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showCurseOfTheMoons",
		name = "Curse of the Moons buff",
		description = "Configures whether Curse of the Moons buff is displayed",
		section = bossesSection
	)
	default boolean showCurseOfTheMoons()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showColosseumDoom",
		name = "Colosseum Doom buff",
		description = "Configures whether Fortis Colosseum Doom buff is displayed",
		section = bossesSection
	)
	default boolean showColosseumDoom()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMoonlightPotion",
		name = "Moonlight potion timer",
		description = "Configures whether Moonlight potion timer is displayed",
		section = consumablesSection
	)
	default boolean showMoonlightPotion()
	{
		return true;
	}
}
