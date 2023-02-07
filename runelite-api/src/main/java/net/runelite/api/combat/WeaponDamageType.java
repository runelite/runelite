/* BSD 2-Clause License
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
 * Copyright (c) 2023, Erishion Games LLC <https://github.com/Erishion-Games-LLC>
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
package net.runelite.api.combat;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import java.util.Map;
import static net.runelite.api.combat.DamageType.*;


public enum WeaponDamageType
{
	UNARMED(0, CRUSH, CRUSH, null, CRUSH),
	AXE(1, SLASH, SLASH, CRUSH, SLASH),
	BLUNT(2, CRUSH, CRUSH, null, CRUSH),
	BOW(3, RANGED, RANGED, null, RANGED),
	CLAWS(4, SLASH, SLASH, STAB, SLASH),
	CROSSBOW(5, RANGED, RANGED, null, RANGED),
	SALAMANDER(6, SLASH, RANGED, MAGIC, null),
	CHINCHOMPA(7, RANGED, RANGED, null, RANGED),
	GUN(8, NONE, CRUSH, null, null),
	SWORD_SLASH(9, SLASH, SLASH, STAB, SLASH),
	SWORD_2H(10, SLASH, SLASH, CRUSH, SLASH),
	PICKAXE(11, STAB, STAB, CRUSH, STAB),
	TWELVE(12, null, null, null, null),
	POLESTAFF(13, CRUSH, CRUSH, null, CRUSH),
	SCYTHE(14, SLASH, SLASH, CRUSH, SLASH),
	SPEAR(15, STAB, SLASH, CRUSH, STAB),
	SPIKED(16, CRUSH, CRUSH, STAB, CRUSH),
	SWORD_STAB(17, STAB, STAB, SLASH, STAB),
	STAFF(18, CRUSH, CRUSH, null, CRUSH, MAGIC, MAGIC),
	THROWN(19, RANGED, RANGED, null, RANGED),
	WHIP(20, SLASH, SLASH, null, SLASH),
	STAFF_BLADED(21, STAB, SLASH, null, CRUSH, MAGIC, MAGIC),
	TWENTY_TWO(22, null, null, null, null),
	STAFF_POWERED(23, MAGIC, MAGIC, null, MAGIC),
	BANNER(24, STAB, SLASH, CRUSH, STAB),
	POLEARM(25, STAB, SLASH, null, STAB),
	BLUDGEON(26, CRUSH, CRUSH, null, CRUSH),
	BULWARK(27, CRUSH, null, null, NONE),
	TWENTYEIGHT(28, null, null, null, null),
	PARTISAN(29, STAB, STAB, CRUSH, STAB);

	@Getter
	private final DamageType[] damageTypes;
	private static final Map<Integer, WeaponDamageType> weaponDamageTypes;

	static
	{
		ImmutableMap.Builder<Integer, WeaponDamageType> builder = new ImmutableMap.Builder<>();

		for (WeaponDamageType weaponDamageType : values())
		{
			builder.put(weaponDamageType.ordinal(), weaponDamageType);
		}

		weaponDamageTypes = builder.build();
	}

	WeaponDamageType(int id, DamageType... damageTypes)
	{
		this.damageTypes = damageTypes;
	}

	public static WeaponDamageType getWeaponDamageType(int id)
	{
		return weaponDamageTypes.get(id);
	}
}
