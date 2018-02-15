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
package net.runelite.client.plugins.attackindicator;

import java.util.HashMap;
import java.util.Map;
import static net.runelite.client.plugins.attackindicator.AttackStyle.*;

public enum WeaponType
{
	TYPE_0(ACCURATE, AGGRESSIVE, null, DEFENSIVE), //fists
	TYPE_1(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //battleaxe
	TYPE_2(ACCURATE, AGGRESSIVE, null, DEFENSIVE), //granite hammer, granite maul
	TYPE_3(RANGING, RANGING, null, LONGRANGE), //shortbow, twisted bow
	TYPE_4(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //claws
	TYPE_5(RANGING, RANGING, null, LONGRANGE), //crossbow
	TYPE_6(AGGRESSIVE, RANGING, DEFENSIVE_CASTING, null),
	TYPE_7(RANGING, RANGING, null, LONGRANGE),
	TYPE_8(OTHER, AGGRESSIVE, null, null),
	TYPE_9(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //scimitar
	TYPE_10(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //d2h
	TYPE_11(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	TYPE_12(CONTROLLED, AGGRESSIVE, null, DEFENSIVE),
	TYPE_13(ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	TYPE_14(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	TYPE_15(CONTROLLED, CONTROLLED, CONTROLLED, DEFENSIVE), //spear
	TYPE_16(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //barrelchest anchor, dragon mace
	TYPE_17(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //abyssal dagger, leaf bladed sword, dragon dagger
	TYPE_18(ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING), //staff
	TYPE_19(RANGING, RANGING, null, LONGRANGE), //darts, blowpipe
	TYPE_20(ACCURATE, CONTROLLED, null, DEFENSIVE), //whip
	TYPE_21(ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING), //sol, sotd
	TYPE_22(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //saradomin sword, godsword
	TYPE_23(CASTING, CASTING, null, DEFENSIVE_CASTING), //trident
	TYPE_24(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	TYPE_25(CONTROLLED, AGGRESSIVE, null, DEFENSIVE), //crystal halberd
	TYPE_26(AGGRESSIVE, AGGRESSIVE, null, AGGRESSIVE), //bludgeon
	TYPE_27(ACCURATE, null, null, OTHER); //bulwark

	private static final Map<Integer, WeaponType> weaponTypes = new HashMap<>();

	private final AttackStyle[] attackStyles;

	static
	{
		for (WeaponType weaponType : values())
		{
			weaponTypes.put(weaponType.ordinal(), weaponType);
		}
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
