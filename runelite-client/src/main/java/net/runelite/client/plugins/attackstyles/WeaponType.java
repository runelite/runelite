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
import static net.runelite.client.plugins.attackstyles.AttackStyle.ACCURATE_RANGING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.AGGRESSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.AIM_AND_FIRE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.BLOCK;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CONTROLLED;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.LONGRANGE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.RANGING;

enum WeaponType
{
	TYPE_0(ACCURATE, AGGRESSIVE, null, DEFENSIVE), //Unarmed
	TYPE_1(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //Axe
	TYPE_2(ACCURATE, AGGRESSIVE, null, DEFENSIVE), //Blunt
	TYPE_3(ACCURATE_RANGING, RANGING, null, LONGRANGE), //Bow
	TYPE_4(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //Claws
	TYPE_5(ACCURATE_RANGING, RANGING, null, LONGRANGE), //Crossbow
	TYPE_6(AGGRESSIVE, RANGING, CASTING, null), //Salamander
	TYPE_7(ACCURATE_RANGING, RANGING, null, LONGRANGE), //Chinchompa
	TYPE_8(AIM_AND_FIRE, AGGRESSIVE, null, null), //Gun
	TYPE_9(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //Slash sword
	TYPE_10(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //2h sword
	TYPE_11(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //Pickaxe
	TYPE_12(CONTROLLED, AGGRESSIVE, null, DEFENSIVE), //Gauntlet halberd
	TYPE_13(ACCURATE, AGGRESSIVE, null, DEFENSIVE), //Polestaff
	TYPE_14(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //Scythe
	TYPE_15(CONTROLLED, CONTROLLED, CONTROLLED, DEFENSIVE), //Spear/Hasta
	TYPE_16(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //Spiked
	TYPE_17(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //Stab sword
	TYPE_18(ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING), //Staff/Wand
	TYPE_19(ACCURATE_RANGING, RANGING, null, LONGRANGE), //Thrown weapon
	TYPE_20(ACCURATE, CONTROLLED, null, DEFENSIVE), //Whip
	TYPE_21(ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING), //Bladed staff
	TYPE_22(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //2h sword(Godsword)
	TYPE_23(CASTING, CASTING, null, DEFENSIVE_CASTING), //Powered staff
	TYPE_24(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //Banner
	TYPE_25(CONTROLLED, AGGRESSIVE, null, DEFENSIVE), //Polearm
	TYPE_26(AGGRESSIVE, AGGRESSIVE, null, AGGRESSIVE), //Bludgeon
	TYPE_27(ACCURATE, null, null, BLOCK); //Bulwark

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
