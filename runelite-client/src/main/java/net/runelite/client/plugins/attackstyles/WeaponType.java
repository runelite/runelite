/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package net.runelite.client.plugins.attackstyles;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import static net.runelite.client.plugins.attackstyles.AttackStyle.ACCURATE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.ACCURATE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.ACCURATE_RANGING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.AGGRESSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.AIM_AND_FIRE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.BLOCK;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CONTROLLED;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.LONGRANGE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.LONGRANGE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.RAPID;

enum WeaponType
{
	UNARMED(ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	AXE(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	BLUNT(ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	BOW(ACCURATE_RANGING, RAPID, null, LONGRANGE),
	CLAWS(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	CROSSBOW(ACCURATE_RANGING, RAPID, null, LONGRANGE),
	SALAMANDER(AGGRESSIVE, RAPID, CASTING, null),
	CHINCHOMPA(ACCURATE_RANGING, RAPID, null, LONGRANGE),
	GUN(AIM_AND_FIRE, AGGRESSIVE, null, null),
	SWORD_SLASH(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	SWORD_2H(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	PICKAXE(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	HALBERD(CONTROLLED, AGGRESSIVE, null, DEFENSIVE),
	POLESTAFF(ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	SCYTHE(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	SPEAR(CONTROLLED, CONTROLLED, CONTROLLED, DEFENSIVE),
	SPIKED(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	SWORD_STAB(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	STAFF(ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING),
	THROWN(ACCURATE_RANGING, RAPID, null, LONGRANGE),
	WHIP(ACCURATE, CONTROLLED, null, DEFENSIVE),
	STAFF_BLADED(ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING),
	GODSWORD(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	STAFF_POWERED(ACCURATE_CASTING, ACCURATE_CASTING, null, LONGRANGE_CASTING),
	BANNER(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	POLEARM(CONTROLLED, AGGRESSIVE, null, DEFENSIVE),
	BLUDGEON(AGGRESSIVE, AGGRESSIVE, null, AGGRESSIVE),
	BULWARK(ACCURATE, null, null, BLOCK);

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

	WeaponType(AttackStyle... attackStyles)
	{
		this.attackStyles = attackStyles;
	}

	public AttackStyle[] getAttackStyles()
	{
		return attackStyles;
	}

	public static WeaponType getWeaponType(int id)
	{
		return weaponTypes.get(id);
	}
}
