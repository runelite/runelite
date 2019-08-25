/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.prayagainstplayer;

import net.runelite.api.Client;
import net.runelite.api.ItemDefinition;
import net.runelite.api.Player;
import net.runelite.api.kit.KitType;

enum WeaponType
{

	WEAPON_MELEE,
	WEAPON_RANGED,
	WEAPON_MAGIC,
	WEAPON_UNKNOWN;

	/**
	 * im fully aware this could of been done better!!!
	 *
	 * @param client
	 * @param attacker
	 * @return
	 */
	public static WeaponType checkWeaponOnPlayer(Client client, Player attacker)
	{
		int itemId = attacker.getPlayerAppearance().getEquipmentId(KitType.WEAPON);
		ItemDefinition itemComposition = client.getItemDefinition(itemId);
		String weaponNameGivenLowerCase = itemComposition.getName().toLowerCase();

		if (itemId == -1)
		{
			return WEAPON_MELEE;
		}
		if (weaponNameGivenLowerCase.toLowerCase().contains("null"))
		{
			return WEAPON_MELEE;
		}

		for (String meleeWeaponName : meleeWeaponNames)
		{
			if (weaponNameGivenLowerCase.contains(meleeWeaponName) && !weaponNameGivenLowerCase.contains("thrownaxe"))
			{
				return WEAPON_MELEE;
			}
		}

		for (String rangedWeaponName : rangedWeaponNames)
		{
			if (weaponNameGivenLowerCase.contains(rangedWeaponName))
			{
				return WEAPON_RANGED;
			}
		}

		for (String magicWeaponName : magicWeaponNames)
		{
			if (weaponNameGivenLowerCase.contains(magicWeaponName))
			{
				return WEAPON_MAGIC;
			}
		}

		return WEAPON_UNKNOWN;

	}

	private static final String[] meleeWeaponNames = {
		"sword",
		"scimitar",
		"dagger",
		"spear",
		"mace",
		"axe",
		"whip",
		"tentacle",
		"-ket-",
		"-xil-",
		"warhammer",
		"halberd",
		"claws",
		"hasta",
		"scythe",
		"maul",
		"anchor",
		"sabre",
		"excalibur",
		"machete",
		"dragon hunter lance",
		"event rpg",
		"silverlight",
		"darklight",
		"arclight",
		"flail",
		"granite hammer",
		"rapier",
		"bulwark"
	};

	private static final String[] rangedWeaponNames = {
		"bow",
		"blowpipe",
		"xil-ul",
		"knife",
		"dart",
		"thrownaxe",
		"chinchompa",
		"ballista"
	};

	private static final String[] magicWeaponNames = {
		"staff",
		"trident",
		"wand",
		"dawnbringer"
	};

}
