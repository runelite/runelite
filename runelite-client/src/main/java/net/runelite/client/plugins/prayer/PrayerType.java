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
package net.runelite.client.plugins.prayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Prayer;
import net.runelite.api.gameval.SpriteID;
import net.runelite.api.gameval.VarbitID;

@AllArgsConstructor
@Getter
enum PrayerType
{
	THICK_SKIN("Thick Skin", Prayer.THICK_SKIN, "+5% Defence", SpriteID.Prayeron.THICK_SKIN, false, 1),
	BURST_OF_STRENGTH("Burst of Strength", Prayer.BURST_OF_STRENGTH, "+5% Strength", SpriteID.Prayeron.BURST_OF_STRENGTH, false, 1),
	CLARITY_OF_THOUGHT("Clarity of Thought", Prayer.CLARITY_OF_THOUGHT, "+5% Attack", SpriteID.Prayeron.CLARITY_OF_THOUGHT, false, 1),
	SHARP_EYE("Sharp Eye", Prayer.SHARP_EYE, "+5% Ranged", SpriteID.Prayeron.SHARP_EYE, false, 1),
	MYSTIC_WILL("Mystic Will", Prayer.MYSTIC_WILL, "+5% Magical attack and defence", SpriteID.Prayeron.MYSTIC_WILL, false, 1),
	ROCK_SKIN("Rock Skin", Prayer.ROCK_SKIN, "+10% Defence", SpriteID.Prayeron.ROCK_SKIN, false, 6),
	SUPERHUMAN_STRENGTH("Superhuman Strength", Prayer.SUPERHUMAN_STRENGTH, "+10% Strength", SpriteID.Prayeron.SUPERHUMAN_STRENGTH, false, 6),
	IMPROVED_REFLEXES("Improved Reflexes", Prayer.IMPROVED_REFLEXES, "+10% Attack", SpriteID.Prayeron.IMPROVED_REFLEXES, false, 6),
	RAPID_RESTORE("Rapid Restore", Prayer.RAPID_RESTORE, "2 x Restore rate for all skills except Hitpoints and Prayer", SpriteID.Prayeron.RAPID_RESTORE, false, 1),
	RAPID_HEAL("Rapid Heal", Prayer.RAPID_HEAL, "2 x Restore rate for Hitpoints", SpriteID.Prayeron.RAPID_HEAL, false, 2),
	PROTECT_ITEM("Protect Item", Prayer.PROTECT_ITEM, "Player keeps 1 extra item when they die", SpriteID.Prayeron.PROTECT_ITEM, false, 2),
	HAWK_EYE("Hawk Eye", Prayer.HAWK_EYE, "+10% Ranged", SpriteID.Prayeron.HAWK_EYE, false, 6),
	MYSTIC_LORE("Mystic Lore", Prayer.MYSTIC_LORE, "+10% Magical attack and defence", SpriteID.Prayeron.MYSTIC_LORE, false, 6),
	STEEL_SKIN("Steel Skin", Prayer.STEEL_SKIN, "+15% Defence", SpriteID.Prayeron.STEEL_SKIN, false, 12),
	ULTIMATE_STRENGTH("Ultimate Strength", Prayer.ULTIMATE_STRENGTH, "+15% Strength", SpriteID.Prayeron.ULTIMATE_STRENGTH, false, 12),
	INCREDIBLE_REFLEXES("Incredible reflexes", Prayer.INCREDIBLE_REFLEXES, "+15% Attack", SpriteID.Prayeron.INCREDIBLE_REFLEXES, false, 12),
	PROTECT_FROM_MAGIC("protect from magic", Prayer.PROTECT_FROM_MAGIC, "Protects against magic attacks", SpriteID.Prayeron.PROTECT_FROM_MAGIC, true, 12),
	PROTECT_FROM_MISSILES("Protect from missiles", Prayer.PROTECT_FROM_MISSILES, "Protects against ranged attacks", SpriteID.Prayeron.PROTECT_FROM_MISSILES, true, 12),
	PROTECT_FROM_MELEE("Protect from melee", Prayer.PROTECT_FROM_MELEE, "Protects against melee attacks", SpriteID.Prayeron.PROTECT_FROM_MELEE, true, 12),
	EAGLE_EYE("Eagle Eye", Prayer.EAGLE_EYE, "+15% Ranged", SpriteID.Prayeron.EAGLE_EYE, false, 12)
	{
		@Override
		boolean isEnabled(Client client)
		{
			return !DEADEYE.isEnabled(client);
		}
	},
	MYSTIC_MIGHT("Mystic Might", Prayer.MYSTIC_MIGHT, "+15% Magical attack and defence", SpriteID.Prayeron.MYSTIC_MIGHT, false, 12)
	{
		@Override
		boolean isEnabled(Client client)
		{
			return !MYSTIC_VIGOUR.isEnabled(client);
		}
	},
	RETRIBUTION("Retribution", Prayer.RETRIBUTION, "Deals damage up to 25% of your Prayer level to nearby targets upon the user's death", SpriteID.Prayeron.RETRIBUTION, true, 3),
	REDEMPTION("Redemption", Prayer.REDEMPTION, "Heals the player if they fall below 10% health", SpriteID.Prayeron.REDEMPTION, true, 6),
	SMITE("Smite", Prayer.SMITE, "Removes 1 Prayer point from an enemy for every 4 damage inflicted on the enemy", SpriteID.Prayeron.SMITE, true, 18),
	PRESERVE("Preserve", Prayer.PRESERVE, "Boosted stats last 50% longer", SpriteID.Prayeron.PRESERVE, false, 2),
	CHIVALRY("Chivalry", Prayer.CHIVALRY, "+15% Attack, +18% Strength, +20% Defence", SpriteID.Prayeron.CHIVALRY, false, 24),
	DEADEYE("Deadeye", Prayer.DEADEYE, "+18% Ranged attack, +18% Ranged strength, +5% Defence", SpriteID.Prayeron.DEADEYE, false, 12)
	{
		@Override
		boolean isEnabled(Client client)
		{
			boolean inLms = client.getVarbitValue(VarbitID.BR_INGAME) != 0;
			boolean deadeye = client.getVarbitValue(VarbitID.PRAYER_DEADEYE_UNLOCKED) != 0;
			return deadeye && !inLms;
		}
	},
	MYSTIC_VIGOUR("Mystic Vigour", Prayer.MYSTIC_VIGOUR, "+18% Magical attack and defence, +3% Magic damage, +5% Defence", SpriteID.Prayeron.MYSTIC_VIGOUR, false, 12)
	{
		@Override
		boolean isEnabled(Client client)
		{
			boolean inLms = client.getVarbitValue(VarbitID.BR_INGAME) != 0;
			boolean vigour = client.getVarbitValue(VarbitID.PRAYER_MYSTIC_VIGOUR_UNLOCKED) != 0;
			return vigour && !inLms;
		}
	},
	PIETY("Piety", Prayer.PIETY, "+20% Attack, +23% Strength, +25% Defence", SpriteID.Prayeron.PIETY, false, 24),
	RIGOUR("Rigour", Prayer.RIGOUR, "+20% Ranged attack, +23% Ranged strength, +25% Defence", SpriteID.Prayeron.RIGOUR, false, 24),
	AUGURY("Augury", Prayer.AUGURY, "+25% Magical attack and defence, +25% Defence", SpriteID.Prayeron.AUGURY, false, 24),

	RP_REJUVENATION("Rejuvenation", Prayer.RP_REJUVENATION, "3x Restore rate for Hitpoints", SpriteID.IconPrayerZaros01_30x30.REJUVENATION, false, 4),
	RP_ANCIENT_STRENGTH("Ancient Strength", Prayer.RP_ANCIENT_STRENGTH, "+20% Attack and Strength", SpriteID.IconPrayerZaros01_30x30.ANCIENT_STRENGTH, false, 18),
	RP_ANCIENT_SIGHT("Ancient Sight", Prayer.RP_ANCIENT_SIGHT, "+20% Ranged Attack & Strength", SpriteID.IconPrayerZaros01_30x30.ANCIENT_SIGHT, false, 18),
	RP_ANCIENT_WILL("Ancient Will", Prayer.RP_ANCIENT_WILL, "+20% Magic Attack", SpriteID.IconPrayerZaros01_30x30.ANCIENT_WILL, false, 18),
	RP_PROTECT_ITEM("Protect Item", Prayer.RP_PROTECT_ITEM, "Keep one extra item upon death", SpriteID.IconPrayerZaros01_30x30.PROTECT_ITEM, false, 18),
	RP_RUINOUS_GRACE("Ruinous Grace", Prayer.RP_RUINOUS_GRACE, "Prayer points are drained in place of run energy whilst running", SpriteID.IconPrayerZaros01_30x30.RUINOUS_GRACE, false, 1),
	RP_DAMPEN_MAGIC("Dampen Magic", Prayer.RP_DAMPEN_MAGIC, "100% protection from magic attacks (40% in PvP), but increases damage taken by 10%", SpriteID.IconPrayerZaros01_30x30.DAMPEN_MAGIC, true, 14),
	RP_DAMPEN_RANGE("Dampen Ranged", Prayer.RP_DAMPEN_RANGED, "100% protection from ranged attacks (40% in PvP), but increases damage taken by 10%", SpriteID.IconPrayerZaros01_30x30.DAMPEN_RANGED, true, 14),
	RP_DAMPEN_MELEE("Dampen Melee", Prayer.RP_DAMPEN_MELEE, "100% protection from melee attacks (40% in PvP), but increases damage taken by 10%", SpriteID.IconPrayerZaros01_30x30.DAMPEN_MELEE, true, 14),
	RP_TRINITAS("Trinitas", Prayer.RP_TRINITAS, "+15% Melee Attack and Strength, +15% Ranged Attack and Strength, and +15% Magic Attack", SpriteID.IconPrayerZaros01_30x30.TRINITAS, false, 22),
	RP_BERSERKER("Berserker", Prayer.RP_BERSERKER, "Boosted combat stats last 50% longer", SpriteID.IconPrayerZaros01_30x30.BERSERKER, false, 2),
	RP_PURGE("Purge", Prayer.RP_PURGE, "Reduces the player's and opponent's prayer points by 33% of damage dealt", SpriteID.IconPrayerZaros01_30x30.PURGE, true, 18),
	RP_METABOLISE("Metabolise", Prayer.RP_METABOLISE, "25 ticks (15 seconds) after activation, allows players to attack 1 tick earlier after eating a piece of food", SpriteID.IconPrayerZaros01_30x30.METABOLISE, false, 12),
	RP_REBUKE("Rebuke", Prayer.RP_REBUKE, "Increases recoil damage by 50%", SpriteID.IconPrayerZaros01_30x30.REBUKE, true, 12),
	RP_VINDICATION("Vindication", Prayer.RP_VINDICATION, "Heals the player by 25% of their base Prayer level if they fall below 10% health, draining their prayer points fully", SpriteID.IconPrayerZaros01_30x30.VINDICATION, true, 9),
	RP_DECIMATE("Decimate", Prayer.RP_DECIMATE, "+25% Attack, +27% Strength", SpriteID.IconPrayerZaros01_30x30.DECIMATE, false, 28),
	RP_ANNIHILATE("Annihilate", Prayer.RP_ANNIHILATE, "+25% Ranged Attack, +27% Ranged Strength", SpriteID.IconPrayerZaros01_30x30.ANNIHILATE, false, 28),
	RP_VAPORISE("Vaporise", Prayer.RP_VAPORISE, "+25% Magic Attack, +4% Magic Damage", SpriteID.IconPrayerZaros01_30x30.VAPORISE, false, 28),
	RP_FUMUS_VOW("Fumus' Vow", Prayer.RP_FUMUS_VOW, "Attacks that inflict poison will deal poison damage instantly", SpriteID.IconPrayerZaros01_30x30.FUMUS_VOW, false, 14),
	RP_UMBRAS_VOW("Umbra's Vow", Prayer.RP_UMBRA_VOW, "Attacks drain 5% of the opponent's Defence, up to 15% of their base level", SpriteID.IconPrayerZaros01_30x30.UMBRAS_VOW, false, 14),
	RP_CRUORS_VOW("Cruor's Vow", Prayer.RP_CRUORS_VOW, "Heals 3 Hitpoints and drains 3 Prayer points upon killing a target", SpriteID.IconPrayerZaros01_30x30.CRUORS_VOW, false, 14),
	RP_GLACIES_VOW("Glacies' Vow", Prayer.RP_GLACIES_VOW, "Attacks drain 5% of the opponent's Magic, up to 15% of their base level", SpriteID.IconPrayerZaros01_30x30.GLACIES_VOW, false, 14),
	RP_WRATH("Wrath", Prayer.RP_WRATH, "Upon death, deals damage up to 25% of the player's base Prayer level to targets in a 5x5 radius", SpriteID.IconPrayerZaros01_30x30.WRATH, false, 3),
	RP_INTENSIFY("Intensify", Prayer.RP_INTENSIFY, "+40% accuracy in all attack styles", SpriteID.IconPrayerZaros01_30x30.INTENSIFY, false, 28),
	;

	private final String name;
	private final Prayer prayer;
	private final String description;
	private final int spriteID;
	private final boolean overhead;
	private final int drainEffect;

	boolean isEnabled(Client client)
	{
		return true;
	}

	boolean isActive(Client client)
	{
		return client.isPrayerActive(prayer) && isEnabled(client);
	}
}
