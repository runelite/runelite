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

import net.runelite.api.annotations.Varbit;
import net.runelite.api.gameval.VarbitID;

/**
 * An enumeration of prayers.
 */
public enum Prayer
{
	/**
	 * Thick Skin (Level 1, Defence).
	 */
	THICK_SKIN(VarbitID.PRAYER_THICKSKIN),
	/**
	 * Burst of Strength (Level 4, Strength).
	 */
	BURST_OF_STRENGTH(VarbitID.PRAYER_BURSTOFSTRENGTH),
	/**
	 * Clarity of Thought (Level 7, Attack).
	 */
	CLARITY_OF_THOUGHT(VarbitID.PRAYER_CLARITYOFTHOUGHT),
	/**
	 * Sharp Eye (Level 8, Ranging).
	 */
	SHARP_EYE(VarbitID.PRAYER_SHARPEYE),
	/**
	 * Mystic Will (Level 9, Magic).
	 */
	MYSTIC_WILL(VarbitID.PRAYER_MYSTICWILL),
	/**
	 * Rock Skin (Level 10, Defence).
	 */
	ROCK_SKIN(VarbitID.PRAYER_ROCKSKIN),
	/**
	 * Superhuman Strength (Level 13, Strength).
	 */
	SUPERHUMAN_STRENGTH(VarbitID.PRAYER_SUPERHUMANSTRENGTH),
	/**
	 * Improved Reflexes (Level 16, Attack).
	 */
	IMPROVED_REFLEXES(VarbitID.PRAYER_IMPROVEDREFLEXES),
	/**
	 * Rapid Restore (Level 19, Stats).
	 */
	RAPID_RESTORE(VarbitID.PRAYER_RAPIDRESTORE),
	/**
	 * Rapid Heal (Level 22, Hitpoints).
	 */
	RAPID_HEAL(VarbitID.PRAYER_RAPIDHEAL),
	/**
	 * Protect Item (Level 25).
	 */
	PROTECT_ITEM(VarbitID.PRAYER_PROTECTITEM),
	/**
	 * Hawk Eye (Level 26, Ranging).
	 */
	HAWK_EYE(VarbitID.PRAYER_HAWKEYE),
	/**
	 * Mystic Lore (Level 27, Magic).
	 */
	MYSTIC_LORE(VarbitID.PRAYER_MYSTICLORE),
	/**
	 * Steel Skin (Level 28, Defence).
	 */
	STEEL_SKIN(VarbitID.PRAYER_STEELSKIN),
	/**
	 * Ultimate Strength (Level 31, Strength).
	 */
	ULTIMATE_STRENGTH(VarbitID.PRAYER_ULTIMATESTRENGTH),
	/**
	 * Incredible Reflexes (Level 34, Attack).
	 */
	INCREDIBLE_REFLEXES(VarbitID.PRAYER_INCREDIBLEREFLEXES),
	/**
	 * Protect from Magic (Level 37).
	 */
	PROTECT_FROM_MAGIC(VarbitID.PRAYER_PROTECTFROMMAGIC),
	/**
	 * Protect from Missiles (Level 40).
	 */
	PROTECT_FROM_MISSILES(VarbitID.PRAYER_PROTECTFROMMISSILES),
	/**
	 * Protect from Melee (Level 43).
	 */
	PROTECT_FROM_MELEE(VarbitID.PRAYER_PROTECTFROMMELEE),
	/**
	 * Eagle Eye (Level 44, Ranging).
	 */
	EAGLE_EYE(VarbitID.PRAYER_EAGLEEYE),
	/**
	 * Mystic Might (Level 45, Magic).
	 */
	MYSTIC_MIGHT(VarbitID.PRAYER_MYSTICMIGHT),
	/**
	 * Retribution (Level 46).
	 */
	RETRIBUTION(VarbitID.PRAYER_RETRIBUTION),
	/**
	 * Redemption (Level 49).
	 */
	REDEMPTION(VarbitID.PRAYER_REDEMPTION),
	/**
	 * Smite (Level 52).
	 */
	SMITE(VarbitID.PRAYER_SMITE),
	/**
	 * Chivalry (Level 60, Defence/Strength/Attack).
	 */
	CHIVALRY(VarbitID.PRAYER_CHIVALRY),
	/**
	 * Deadeye (Level 62, Ranging/Damage/Defence).
	 */
	DEADEYE(VarbitID.PRAYER_DEADEYE),
	/**
	 * Mystic Vigour (Level 63, Magic/Magic Def./Defence).
	 */
	MYSTIC_VIGOUR(VarbitID.PRAYER_MYSTICVIGOUR),
	/**
	 * Piety (Level 70, Defence/Strength/Attack).
	 */
	PIETY(VarbitID.PRAYER_PIETY),
	/**
	 * Preserve (Level 55).
	 */
	PRESERVE(VarbitID.PRAYER_PRESERVE),
	/**
	 * Rigour (Level 74, Ranging/Damage/Defence).
	 */
	RIGOUR(VarbitID.PRAYER_RIGOUR),
	/**
	 * Augury (Level 77, Magic/Magic Def./Defence).
	 */
	AUGURY(VarbitID.PRAYER_AUGURY),

	/**
	 * Ruinous Powers Rejuvenation (Level 60).
	 */
	RP_REJUVENATION(VarbitID.PRAYER_REJUVENATION),
	/**
	 * Ruinous Powers Ancient Strength (Level 61).
	 */
	RP_ANCIENT_STRENGTH(VarbitID.PRAYER_ANCIENT_STRENGTH),
	/**
	 * Ruinous Powers Ancient Sight (Level 62).
	 */
	RP_ANCIENT_SIGHT(VarbitID.PRAYER_ANCIENT_SIGHT),
	/**
	 * Ruinous Powers Ancient Will (Level 63).
	 */
	RP_ANCIENT_WILL(VarbitID.PRAYER_ANCIENT_WILL),
	/**
	 * Ruinous Powers Protect Item (Level 65).
	 */
	RP_PROTECT_ITEM(VarbitID.PRAYER_PROTECT_ITEM_R),
	/**
	 * Ruinous Powers Ruinous Grace (Level 66).
	 */
	RP_RUINOUS_GRACE(VarbitID.PRAYER_RUINOUS_GRACE),
	/**
	 * Ruinous Powers Dampen Magic (Level 67).
	 */
	RP_DAMPEN_MAGIC(VarbitID.PRAYER_DAMPEN_MAGIC),
	/**
	 * Ruinous Powers Dampen Ranged (Level 69).
	 */
	RP_DAMPEN_RANGED(VarbitID.PRAYER_DAMPEN_RANGED),
	/**
	 * Ruinous Powers Dampen Melee (Level 71).
	 */
	RP_DAMPEN_MELEE(VarbitID.PRAYER_DAMPEN_MELEE),
	/**
	 * Ruinous Powers Trinitas (Level 72).
	 */
	RP_TRINITAS(VarbitID.PRAYER_TRINITAS),
	/**
	 * Ruinous Powers Berserker (Level 74).
	 */
	RP_BERSERKER(VarbitID.PRAYER_BERSERKER),
	/**
	 * Ruinous Powers Purge (Level 75).
	 */
	RP_PURGE(VarbitID.PRAYER_PURGE),
	/**
	 * Ruinous Powers Metabolise (Level 77).
	 */
	RP_METABOLISE(VarbitID.PRAYER_METABOLISE),
	/**
	 * Ruinous Powers Rebuke (Level 78).
	 */
	RP_REBUKE(VarbitID.PRAYER_REBUKE),
	/**
	 * Ruinous Powers Vindication (Level 80).
	 */
	RP_VINDICATION(VarbitID.PRAYER_VINDICATION),
	/**
	 * Ruinous Powers Decimate (Level 82).
	 */
	RP_DECIMATE(VarbitID.PRAYER_DECIMATE),
	/**
	 * Ruinous Powers Annihilate (Level 84).
	 */
	RP_ANNIHILATE(VarbitID.PRAYER_ANNIHILATE),
	/**
	 * Ruinous Powers Vaporise (Level 86).
	 */
	RP_VAPORISE(VarbitID.PRAYER_VAPORISE),
	/**
	 * Ruinous Powers Fumus' Vow (Level 87).
	 */
	RP_FUMUS_VOW(VarbitID.PRAYER_FUMUS_VOW),
	/**
	 * Ruinous Powers Umbra's Vow (Level 88).
	 */
	RP_UMBRA_VOW(VarbitID.PRAYER_UMBRAS_VOW),
	/**
	 * Ruinous Powers Cruor's Vow (Level 89).
	 */
	RP_CRUORS_VOW(VarbitID.PRAYER_CRUORS_VOW),
	/**
	 * Ruinous Powers Glacies' Vow (Level 90).
	 */
	RP_GLACIES_VOW(VarbitID.PRAYER_GLACIES_VOW),
	/**
	 * Ruinous Powers Wrath (Level 91).
	 */
	RP_WRATH(VarbitID.PRAYER_WRATH),
	/**
	 * Ruinous Powers Intensify (Level 92).
	 */
	RP_INTENSIFY(VarbitID.PRAYER_INTENSIFY),
	;

	private final int varbit;

	Prayer(@Varbit int varbit)
	{
		this.varbit = varbit;
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
