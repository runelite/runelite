/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@AllArgsConstructor
@Getter
public enum HerbloreAction implements SkillAction
{
	ATTACK_POTION_3("Attack potion (3)", 3, 25, ItemID.ATTACK_POTION3),
	GUAM_LEAF("Guam leaf", 3, 2.5f, ItemID.GUAM_LEAF),
	MARRENTILL("Marrentill", 5, 3.8f, ItemID.MARRENTILL),
	ANTIPOISON_3("Antipoison (3)", 5, 37.5f, ItemID.ANTIPOISON3),
	RELICYMS_BALM_3("Relicym's balm (3)", 8, 40, ItemID.RELICYMS_BALM3),
	TARROMIN("Tarromin", 11, 5, ItemID.TARROMIN),
	STRENGTH_POTION_3("Strength potion (3)", 12, 50, ItemID.STRENGTH_POTION3),
	SERUM_207_3("Serum 207 (3)", 15, 50, ItemID.SERUM_207_3),
	GUTHIX_REST_3("Guthix rest (3)", 18, 59, ItemID.GUTHIX_REST3),
	GUAM_TAR("Guam tar", 19, 30, ItemID.GUAM_TAR),
	HARRALANDER("Harralander", 20, 6.3f, ItemID.HARRALANDER),
	COMPOST_POTION_3("Compost potion (3)", 22, 60, ItemID.COMPOST_POTION3),
	RESTORE_POTION_3("Restore potion (3)", 22, 62.5f, ItemID.RESTORE_POTION3),
	RANARR_WEED("Ranarr weed", 25, 7.5f, ItemID.RANARR_WEED),
	ENERGY_POTION_3("Energy potion (3)", 26, 67.5f, ItemID.ENERGY_POTION3),
	TOADFLAX("Toadflax", 30, 8, ItemID.TOADFLAX),
	DEFENCE_POTION_3("Defence potion (3)", 30, 75, ItemID.DEFENCE_POTION3),
	MARRENTILL_TAR("Marrentill tar", 31, 42.5f, ItemID.MARRENTILL_TAR),
	AGILITY_POTION_3("Agility potion (3)", 34, 80, ItemID.AGILITY_POTION3),
	COMBAT_POTION_3("Combat potion (3)", 36, 84, ItemID.COMBAT_POTION3),
	PRAYER_POTION_3("Prayer potion (3)", 38, 87.5f, ItemID.PRAYER_POTION3),
	TARROMIN_TAR("Tarromin tar", 39, 55, ItemID.TARROMIN_TAR),
	IRIT_LEAF("Irit leaf", 40, 8.8f, ItemID.IRIT_LEAF),
	HARRALANDER_TAR("Harralander tar", 44, 72.5f, ItemID.HARRALANDER_TAR),
	SUPER_ATTACK_3("Super attack (3)", 45, 100, ItemID.SUPER_ATTACK3),
	SUPERANTIPOISON_3("Superantipoison (3)", 48, 106.3f, ItemID.SUPERANTIPOISON3),
	AVANTOE("Avantoe", 48, 10, ItemID.AVANTOE),
	FISHING_POTION_3("Fishing potion (3)", 50, 112.5f, ItemID.FISHING_POTION3),
	SUPER_ENERGY_3("Super energy (3)", 52, 117.5f, ItemID.SUPER_ENERGY3),
	HUNTER_POTION_3("Hunter potion (3)", 53, 120, ItemID.HUNTER_POTION3),
	KWUARM("Kwuarm", 54, 11.3f, ItemID.KWUARM),
	SUPER_STRENGTH_3("Super strength (3)", 55, 125, ItemID.SUPER_STRENGTH3),
	MAGIC_ESSENCE_POTION_3("Magic essence potion (3)", 57, 130, ItemID.MAGIC_ESSENCE3),
	SNAPDRAGON("Snapdragon", 59, 11.8f, ItemID.SNAPDRAGON),
	WEAPON_POISON("Weapon poison", 60, 137.5f, ItemID.WEAPON_POISON),
	SUPER_RESTORE_3("Super restore (3)", 63, 142.5f, ItemID.SUPER_RESTORE3),
	CADANTINE("Cadantine", 65, 12.5f, ItemID.CADANTINE),
	SANFEW_SERUM_3("Sanfew serum (3)", 65, 160, ItemID.SANFEW_SERUM3),
	SUPER_DEFENCE_3("Super defence (3)", 66, 150, ItemID.SUPER_DEFENCE3),
	LANTADYME("Lantadyme", 67, 13.1f, ItemID.LANTADYME),
	ANTIDOTE_PLUS_3("Antidote+ (3)", 68, 155, ItemID.ANTIDOTE3),
	ANTIFIRE_POTION_3("Antifire potion (3)", 69, 157.5f, ItemID.ANTIFIRE_POTION3),
	DIVINE_SUPER_ATTACK_POTION_4("Divine super attack potion(4)", 70, 2, ItemID.DIVINE_SUPER_ATTACK_POTION4),
	DIVINE_SUPER_DEFENCE_POTION_4("Divine super defence potion(4)", 70, 2, ItemID.DIVINE_SUPER_DEFENCE_POTION4),
	DIVINE_SUPER_STRENGTH_POTION_4("Divine super strength potion(4)", 70, 2, ItemID.DIVINE_SUPER_STRENGTH_POTION4),
	DWARF_WEED("Dwarf weed", 70, 13.8f, ItemID.DWARF_WEED),
	RANGING_POTION_3("Ranging potion (3)", 72, 162.5f, ItemID.RANGING_POTION3),
	WEAPON_POISON_PLUS("Weapon poison (+)", 73, 165, ItemID.WEAPON_POISON_5937),
	DIVINE_RANGING_POTION_4("Divine ranging potion(4)", 74, 2, ItemID.DIVINE_RANGING_POTION4),
	TORSTOL("Torstol", 75, 15, ItemID.TORSTOL),
	MAGIC_POTION_3("Magic potion (3)", 76, 172.5f, ItemID.MAGIC_POTION3),
	STAMINA_POTION_3("Stamina potion (3)", 77, 76.5f, ItemID.STAMINA_POTION3),
	STAMINA_POTION_4("Stamina potion (4)", 77, 102, ItemID.STAMINA_POTION4),
	DIVINE_MAGIC_POTION_4("Divine magic potion(4)", 78, 2, ItemID.DIVINE_MAGIC_POTION4),
	ZAMORAK_BREW_3("Zamorak brew (3)", 78, 175, ItemID.ZAMORAK_BREW3),
	ANTIDOTE_PLUS_PLUS_3("Antidote++ (3)", 79, 177.5f, ItemID.ANTIDOTE3_5954),
	BASTION_POTION_3("Bastion potion (3)", 80, 155, ItemID.BASTION_POTION3),
	BATTLEMAGE_POTION_3("Battlemage potion (3)", 80, 155, ItemID.BATTLEMAGE_POTION3),
	SARADOMIN_BREW_3("Saradomin brew (3)", 81, 180, ItemID.SARADOMIN_BREW3),
	WEAPON_POISON_PLUS_PLUS("Weapon poison (++)", 82, 190, ItemID.WEAPON_POISON_5940),
	EXTENDED_ANTIFIRE_3("Extended antifire (3)", 84, 82.5f, ItemID.EXTENDED_ANTIFIRE3),
	EXTENDED_ANTIFIRE_4("Extended antifire (4)", 84, 110, ItemID.EXTENDED_ANTIFIRE4),
	DIVINE_BASTION_POTION_4("Divine bastion potion(4)", 86, 2, ItemID.DIVINE_BASTION_POTION4),
	DIVINE_BATTLEMAGE_POTION_4("Divine battlemage potion(4)", 86, 2, ItemID.DIVINE_BATTLEMAGE_POTION4),
	ANTIVENOM_3("Anti-venom(3)", 87, 90, ItemID.ANTIVENOM3),
	ANTIVENOM_4("Anti-venom(4)", 87, 120, ItemID.ANTIVENOM4),
	SUPER_COMBAT_POTION_4("Super combat potion(4)", 90, 150, ItemID.SUPER_COMBAT_POTION4),
	SUPER_ANTIFIRE_4("Super antifire (4)", 92, 130, ItemID.SUPER_ANTIFIRE_POTION4),
	ANTIVENOM_PLUS_4("Anti-venom+(4)", 94, 125, ItemID.ANTIVENOM4_12913),
	DIVINE_SUPER_COMBAT_POTION_4("Divine super combat potion(4)", 97, 2, ItemID.DIVINE_SUPER_COMBAT_POTION4),
	EXTENDED_SUPER_ANTIFIRE_3("Extended super antifire (3)", 98, 120, ItemID.SUPER_ANTIFIRE_POTION3),
	EXTENDED_SUPER_ANTIFIRE_4("Extended super antifire (4)", 98, 160, ItemID.SUPER_ANTIFIRE_POTION4),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
}
