/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.gameval.VarbitID;

/**
 * An enumeration of prayers.
 */
@AllArgsConstructor
@Getter
public enum Prayer
{
	/**
	 * Thick Skin (Level 1, Defence).
	 */
	THICK_SKIN(VarbitID.PRAYER_THICKSKIN, 20803),
	/**
	 * Burst of Strength (Level 4, Strength).
	 */
	BURST_OF_STRENGTH(VarbitID.PRAYER_BURSTOFSTRENGTH, 20804),
	/**
	 * Clarity of Thought (Level 7, Attack).
	 */
	CLARITY_OF_THOUGHT(VarbitID.PRAYER_CLARITYOFTHOUGHT, 20805),
	/**
	 * Sharp Eye (Level 8, Ranging).
	 */
	SHARP_EYE(VarbitID.PRAYER_SHARPEYE, 20821),
	/**
	 * Mystic Will (Level 9, Magic).
	 */
	MYSTIC_WILL(VarbitID.PRAYER_MYSTICWILL, 20822),
	/**
	 * Rock Skin (Level 10, Defence).
	 */
	ROCK_SKIN(VarbitID.PRAYER_ROCKSKIN, 20806),
	/**
	 * Superhuman Strength (Level 13, Strength).
	 */
	SUPERHUMAN_STRENGTH(VarbitID.PRAYER_SUPERHUMANSTRENGTH, 20807),
	/**
	 * Improved Reflexes (Level 16, Attack).
	 */
	IMPROVED_REFLEXES(VarbitID.PRAYER_IMPROVEDREFLEXES, 20808),
	/**
	 * Rapid Restore (Level 19, Stats).
	 */
	RAPID_RESTORE(VarbitID.PRAYER_RAPIDRESTORE, 20809),
	/**
	 * Rapid Heal (Level 22, Hitpoints).
	 */
	RAPID_HEAL(VarbitID.PRAYER_RAPIDHEAL, 20810),
	/**
	 * Protect Item (Level 25).
	 */
	PROTECT_ITEM(VarbitID.PRAYER_PROTECTITEM, 20811),
	/**
	 * Hawk Eye (Level 26, Ranging).
	 */
	HAWK_EYE(VarbitID.PRAYER_HAWKEYE, 20823),
	/**
	 * Mystic Lore (Level 27, Magic).
	 */
	MYSTIC_LORE(VarbitID.PRAYER_MYSTICLORE, 20824),
	/**
	 * Steel Skin (Level 28, Defence).
	 */
	STEEL_SKIN(VarbitID.PRAYER_STEELSKIN, 20812),
	/**
	 * Ultimate Strength (Level 31, Strength).
	 */
	ULTIMATE_STRENGTH(VarbitID.PRAYER_ULTIMATESTRENGTH, 20813),
	/**
	 * Incredible Reflexes (Level 34, Attack).
	 */
	INCREDIBLE_REFLEXES(VarbitID.PRAYER_INCREDIBLEREFLEXES, 20814),
	/**
	 * Protect from Magic (Level 37).
	 */
	PROTECT_FROM_MAGIC(VarbitID.PRAYER_PROTECTFROMMAGIC, 20815),
	/**
	 * Protect from Missiles (Level 40).
	 */
	PROTECT_FROM_MISSILES(VarbitID.PRAYER_PROTECTFROMMISSILES, 20816),
	/**
	 * Protect from Melee (Level 43).
	 */
	PROTECT_FROM_MELEE(VarbitID.PRAYER_PROTECTFROMMELEE, 20817),
	/**
	 * Eagle Eye (Level 44, Ranging).
	 */
	EAGLE_EYE(VarbitID.PRAYER_EAGLEEYE, 20825),
	/**
	 * Mystic Might (Level 45, Magic).
	 */
	MYSTIC_MIGHT(VarbitID.PRAYER_MYSTICMIGHT, 20826),
	/**
	 * Retribution (Level 46).
	 */
	RETRIBUTION(VarbitID.PRAYER_RETRIBUTION, 20818),
	/**
	 * Redemption (Level 49).
	 */
	REDEMPTION(VarbitID.PRAYER_REDEMPTION, 20819),
	/**
	 * Smite (Level 52).
	 */
	SMITE(VarbitID.PRAYER_SMITE, 20820),
	/**
	 * Chivalry (Level 60, Defence/Strength/Attack).
	 */
	CHIVALRY(VarbitID.PRAYER_CHIVALRY, 20828),
	/**
	 * Deadeye (Level 62, Ranging/Damage/Defence).
	 */
	DEADEYE(VarbitID.PRAYER_DEADEYE, 25939),
	/**
	 * Mystic Vigour (Level 63, Magic/Magic Def./Defence).
	 */
	MYSTIC_VIGOUR(VarbitID.PRAYER_MYSTICVIGOUR, 27034),
	/**
	 * Piety (Level 70, Defence/Strength/Attack).
	 */
	PIETY(VarbitID.PRAYER_PIETY, 20829),
	/**
	 * Preserve (Level 55).
	 */
	PRESERVE(VarbitID.PRAYER_PRESERVE, 20831),
	/**
	 * Rigour (Level 74, Ranging/Damage/Defence).
	 */
	RIGOUR(VarbitID.PRAYER_RIGOUR, 20827),
	/**
	 * Augury (Level 77, Magic/Magic Def./Defence).
	 */
	AUGURY(VarbitID.PRAYER_AUGURY, 20830),

	/**
	 * Ruinous Powers Rejuvenation (Level 60).
	 */
	RP_REJUVENATION(VarbitID.PRAYER_REJUVENATION, 25983, 1),
	/**
	 * Ruinous Powers Ancient Strength (Level 61).
	 */
	RP_ANCIENT_STRENGTH(VarbitID.PRAYER_ANCIENT_STRENGTH, 26218, 1),
	/**
	 * Ruinous Powers Ancient Sight (Level 62).
	 */
	RP_ANCIENT_SIGHT(VarbitID.PRAYER_ANCIENT_SIGHT, 26217, 1),
	/**
	 * Ruinous Powers Ancient Will (Level 63).
	 */
	RP_ANCIENT_WILL(VarbitID.PRAYER_ANCIENT_WILL, 25972, 1),
	/**
	 * Ruinous Powers Protect Item (Level 65).
	 */
	RP_PROTECT_ITEM(VarbitID.PRAYER_PROTECT_ITEM_R, 25942, 1),
	/**
	 * Ruinous Powers Ruinous Grace (Level 66).
	 */
	RP_RUINOUS_GRACE(VarbitID.PRAYER_RUINOUS_GRACE, 25974, 1),
	/**
	 * Ruinous Powers Dampen Magic (Level 67).
	 */
	RP_DAMPEN_MAGIC(VarbitID.PRAYER_DAMPEN_MAGIC, 15297, 1),
	/**
	 * Ruinous Powers Dampen Ranged (Level 69).
	 */
	RP_DAMPEN_RANGED(VarbitID.PRAYER_DAMPEN_RANGED, 25987, 1),
	/**
	 * Ruinous Powers Dampen Melee (Level 71).
	 */
	RP_DAMPEN_MELEE(VarbitID.PRAYER_DAMPEN_MELEE, 25988, 1),
	/**
	 * Ruinous Powers Trinitas (Level 72).
	 */
	RP_TRINITAS(VarbitID.PRAYER_TRINITAS, 25971, 1),
	/**
	 * Ruinous Powers Berserker (Level 74).
	 */
	RP_BERSERKER(VarbitID.PRAYER_BERSERKER, 26982, 1),
	/**
	 * Ruinous Powers Purge (Level 75).
	 */
	RP_PURGE(VarbitID.PRAYER_PURGE, 25984, 1),
	/**
	 * Ruinous Powers Metabolise (Level 77).
	 */
	RP_METABOLISE(VarbitID.PRAYER_METABOLISE, 26983, 1),
	/**
	 * Ruinous Powers Rebuke (Level 78).
	 */
	RP_REBUKE(VarbitID.PRAYER_REBUKE, 25948, 1),
	/**
	 * Ruinous Powers Vindication (Level 80).
	 */
	RP_VINDICATION(VarbitID.PRAYER_VINDICATION, 25945, 1),
	/**
	 * Ruinous Powers Decimate (Level 82).
	 */
	RP_DECIMATE(VarbitID.PRAYER_DECIMATE, 25970, 1),
	/**
	 * Ruinous Powers Annihilate (Level 84).
	 */
	RP_ANNIHILATE(VarbitID.PRAYER_ANNIHILATE, 25969, 1),
	/**
	 * Ruinous Powers Vaporise (Level 86).
	 */
	RP_VAPORISE(VarbitID.PRAYER_VAPORISE, 25989, 1),
	/**
	 * Ruinous Powers Fumus' Vow (Level 87).
	 */
	RP_FUMUS_VOW(VarbitID.PRAYER_FUMUS_VOW, 26981, 1),
	/**
	 * Ruinous Powers Umbra's Vow (Level 88).
	 */
	RP_UMBRA_VOW(VarbitID.PRAYER_UMBRAS_VOW, 25977, 1),
	/**
	 * Ruinous Powers Cruor's Vow (Level 89).
	 */
	RP_CRUORS_VOW(VarbitID.PRAYER_CRUORS_VOW, 25978, 1),
	/**
	 * Ruinous Powers Glacies' Vow (Level 90).
	 */
	RP_GLACIES_VOW(VarbitID.PRAYER_GLACIES_VOW, 25954, 1),
	/**
	 * Ruinous Powers Wrath (Level 91).
	 */
	RP_WRATH(VarbitID.PRAYER_WRATH, 25973, 1),
	/**
	 * Ruinous Powers Intensify (Level 92).
	 */
	RP_INTENSIFY(VarbitID.PRAYER_INTENSIFY, 25951, 1),
	;

	private final int varbit;

	// Technically each prayer uses an item ID to run against the `PRAYER_ISAVAILABLE` script
	// However, Jagex can repurpose these IDs for discontinued holiday items so using the ItemID gameval enum would be confusing
	private final int itemID;
	private final int prayerBookID;

	Prayer(@Varbit int varbit, int itemID)
	{
		// Normal prayers
		this(varbit, itemID, 0);
	}

	/**
	 * Gets the varbit that stores whether the prayer is active or not.
	 *
	 * @return the prayer active varbit
	 */
	@Varbit
	public int getVarbit()
	{
		return varbit;
	}
}
