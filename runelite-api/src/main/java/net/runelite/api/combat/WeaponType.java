/*
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

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import static net.runelite.api.combat.AttackStyle.*;

public enum WeaponType
{
	UNARMED(0, ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	AXE(1, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	BLUNT(2, ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	BOW(3, RANGING, RANGING, null, LONGRANGE),
	CLAWS(4, ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	CROSSBOW(5, RANGING, RANGING, null, LONGRANGE),
	SALAMANDER(6, AGGRESSIVE, RANGING, CASTING, null),
	CHINCHOMPA(7, RANGING, RANGING, null, LONGRANGE),
	GUN(8, OTHER, AGGRESSIVE, null, null),
	SWORD_SLASH(9, ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	SWORD_2H(10, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	PICKAXE(11, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	TWELVE(12, CONTROLLED, AGGRESSIVE, null, DEFENSIVE),
	POLESTAFF(13, ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	SCYTHE(14, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	SPEAR(15, CONTROLLED, CONTROLLED, CONTROLLED, DEFENSIVE),
	SPIKED(16, ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	SWORD_STAB(17, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	STAFF(18, ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING),
	THROWN(19, RANGING, RANGING, null, LONGRANGE),
	WHIP(20, ACCURATE, CONTROLLED, null, DEFENSIVE),
	STAFF_BLADED(21, ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING),
	TWENTY_TWO(22, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	STAFF_POWERED(23, CASTING, CASTING, null, DEFENSIVE_CASTING),
	BANNER(24, ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	POLEARM(25, CONTROLLED, AGGRESSIVE, null, DEFENSIVE),
	BLUDGEON(26, AGGRESSIVE, AGGRESSIVE, null, AGGRESSIVE),
	BULWARK(27, ACCURATE, null, null, OTHER),
	TWENTY_EIGHT(28, ACCURATE, ACCURATE, null, LONGRANGE),
	PARTISAN(29, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE);

	@Getter
	private final AttackStyle[] attackStyles;

	private static final Map<Integer, WeaponType> weaponTypes;

	static
	{
		ImmutableMap.Builder<Integer, WeaponType> builder = new ImmutableMap.Builder<>();

		for (WeaponType weaponType : values())
		{
			builder.put(weaponType.ordinal(), weaponType);
		}

		weaponTypes = builder.build();
	}

	WeaponType(int id, AttackStyle... attackStyles)
	{
		Preconditions.checkArgument(attackStyles.length == 4 || attackStyles.length == 6,
			"WeaponType " + this + " does not have exactly 4 or 6 attack style arguments");
		this.attackStyles = attackStyles;
	}

	public static WeaponType getWeaponType(int id)
	{
		return weaponTypes.get(id);
	}
}
