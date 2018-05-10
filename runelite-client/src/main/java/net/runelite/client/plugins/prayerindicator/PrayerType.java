/*
 * Copyright (c) 2018, Raqes <j.raqes@gmail.com>
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
package net.runelite.client.plugins.prayerindicator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;

@AllArgsConstructor
@Slf4j
@Getter
enum PrayerType
{
	THICK_SKIN("Thick Skin", Prayer.THICK_SKIN, "+5% Defence", SpriteID.PRAYER_THICK_SKIN),
	BURST_OF_STRENGTH("Burst of Strength", Prayer.BURST_OF_STRENGTH, "+5% Strenth", SpriteID.PRAYER_BURST_OF_STRENGTH),
	CLARITY_OF_THOUGHT("Clarity of Thought", Prayer.CLARITY_OF_THOUGHT, "+5% Attack", SpriteID.PRAYER_CLARITY_OF_THOUGHT),
	SHARP_EYE("Sharp Eye", Prayer.SHARP_EYE, "+5% Ranged", SpriteID.PRAYER_SHARP_EYE),
	MYSTIC_WILL("Mystic Will", Prayer.MYSTIC_WILL, "+5% Magical attack and defence", SpriteID.PRAYER_MYSTIC_WILL),
	ROCK_SKIN("Rock Skin", Prayer.ROCK_SKIN, "+10% Defence", SpriteID.PRAYER_ROCK_SKIN),
	SUPERHUMAN_STRENGTH("Superhuman Strength", Prayer.SUPERHUMAN_STRENGTH, "+10% Strength", SpriteID.PRAYER_SUPERHUMAN_STRENGTH),
	IMPROVED_REFLEXES("Improved Reflexes", Prayer.IMPROVED_REFLEXES, "+10% Attack", SpriteID.PRAYER_IMPROVED_REFLEXES),
	RAPID_RESTORE("Rapid Restore", Prayer.RAPID_RESTORE, "2 x Restore rate for all skills except Hitpoints and Prayer", SpriteID.PRAYER_RAPID_RESTORE),
	RAPID_HEAL("Rapid Heal", Prayer.RAPID_HEAL, "2 x Restore rate for Hitpoints", SpriteID.PRAYER_RAPID_HEAL),
	PROTECT_ITEM("Protect Item", Prayer.PROTECT_ITEM, "Player keeps 1 extra item when they die", SpriteID.PRAYER_PROTECT_ITEM),
	HAWK_EYE("Hawk Eye", Prayer.HAWK_EYE, "+10% Ranged", SpriteID.PRAYER_HAWK_EYE),
	MYSTIC_LORE("Mystic Lore", Prayer.MYSTIC_LORE, "+10% Magical attack and defence", SpriteID.PRAYER_MYSTIC_LORE),
	STEEL_SKIN("Steel Skin", Prayer.STEEL_SKIN, "+15% Defence", SpriteID.PRAYER_STEEL_SKIN),
	ULTIMATE_STRENGTH("Ultimate Strength", Prayer.ULTIMATE_STRENGTH, "+15% Strength", SpriteID.PRAYER_ULTIMATE_STRENGTH),
	INCREDIBLE_REFLEXES("Incredible reflexes", Prayer.INCREDIBLE_REFLEXES, "+15% Attack", SpriteID.PRAYER_INCREDIBLE_REFLEXES),
	PROTECT_FROM_MAGIC("protect from magic", Prayer.PROTECT_FROM_MAGIC, "Protects against magic attacks", SpriteID.PRAYER_PROTECT_FROM_MAGIC),
	PROTECT_FROM_MISSILES("Protect from missiles", Prayer.PROTECT_FROM_MISSILES, "Protects against ranged attacks", SpriteID.PRAYER_PROTECT_FROM_MISSILES),
	PROTECT_FROM_MELEE("Protect from melee", Prayer.PROTECT_FROM_MELEE, "Protects against melee attacks", SpriteID.PRAYER_PROTECT_FROM_MELEE),
	EAGLE_EYE("Eagle Eye", Prayer.EAGLE_EYE, "+15% Ranged", SpriteID.PRAYER_EAGLE_EYE),
	MYSTIC_MIGHT("Mystic Might", Prayer.MYSTIC_MIGHT, "+15% Magical attack and defence", SpriteID.PRAYER_MYSTIC_MIGHT),
	RETRIBUTION("Retribution", Prayer.RETRIBUTION, "Deals damage up to 25% of your Prayer level to nearby targets upon the user's death", SpriteID.PRAYER_RETRIBUTION),
	REDEMPTION("Redemption", Prayer.REDEMPTION, "Heals the player if they fall below 10% health", SpriteID.PRAYER_REDEMPTION),
	SMITE("Smite", Prayer.SMITE, "Removes 1 Prayer point from an enemy for every 4 damage inflicted on the enemy", SpriteID.PRAYER_SMITE),
	PRESERVE("Preserve", Prayer.PRESERVE, "Boosted stats last 50% longer", SpriteID.PRAYER_PRESERVE),
	CHIVALRY("Chivalry", Prayer.CHIVALRY, "+15% Attack, +18% Strength, +20% Defence", SpriteID.PRAYER_CHIVALRY),
	PIETY("Piety", Prayer.PIETY, "+20% Attack, +23% Strength, +25% Defence", SpriteID.PRAYER_PIETY),
	RIGOUR("Rigour", Prayer.RIGOUR, "+20% Ranged attack, +23% Ranged strength, +25% Defence", SpriteID.PRAYER_RIGOUR),
	AUGURY("Augury", Prayer.AUGURY, "+25% Magical attack and defence, +25% Defence", SpriteID.PRAYER_AUGURY);

	private String name;
	private Prayer prayer;
	private String description;
	private int spriteID;

	public static PrayerType getPrayerType(Prayer prayer)
	{
		for  (PrayerType prayerType : values())
		{
			if (prayerType.prayer == prayer)
			{
				return prayerType;
			}
		}
		return null;
	}
}