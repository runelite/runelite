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

import com.google.common.base.Preconditions;
import lombok.Getter;
import static net.runelite.client.plugins.attackstyles.AttackStyle.ACCURATE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.AGGRESSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.CONTROLLED;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.attackstyles.AttackStyle.LONGRANGE;
import static net.runelite.client.plugins.attackstyles.AttackStyle.OTHER;
import static net.runelite.client.plugins.attackstyles.AttackStyle.RANGING;

/**
 * A collection of all known weapon types listed by index (with {@code ordinal() = id}) and the associated
 * {@link AttackStyle attack styles} of that weapon.
 *
 * @see net.runelite.api.Varbits#EQUIPPED_WEAPON_TYPE
 * @see <a href="https://oldschool.runescape.wiki/w/Weapons/Types">Weapons/Types - OSRS Wiki</a>
 */
enum WeaponType
{
	UNARMED(0, ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	AXE(1, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	BLUNT(2, ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	BOW(3, RANGING, RANGING, null, LONGRANGE),
	CLAW(4, ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	CROSSBOW(5, RANGING, RANGING, null, LONGRANGE),
	SALAMANDER(6, AGGRESSIVE, RANGING, CASTING, null),
	CHINCHOMPA(7, RANGING, RANGING, null, LONGRANGE),
	GUN(8, OTHER, AGGRESSIVE, null, null),
	SLASH_SWORD(9, ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	TWO_HANDED_SWORD(10, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	PICKAXE(11, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	POLEARM(12, CONTROLLED, AGGRESSIVE, null, DEFENSIVE),
	POLESTAFF(13, ACCURATE, AGGRESSIVE, null, DEFENSIVE),
	SCYTHE(14, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	SPEAR(15, CONTROLLED, CONTROLLED, CONTROLLED, DEFENSIVE),
	SPIKED(16, ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	STAB_SWORD(17, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	STAFF(18, ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING),
	THROWN(19, RANGING, RANGING, null, LONGRANGE),
	WHIP(20, ACCURATE, CONTROLLED, null, DEFENSIVE),
	BLADED_STAFF(21, ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING),
	/**
	 * The displayed category is "2h sword", the same as {@link #TWO_HANDED_SWORD}, but uses a different var value than
	 * other two-handed swords. At present, the five godswords are the only weapons known to use this type.
	 */
	TWO_HANDED_SWORD_GODSWORD(22, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE),
	POWERED_STAFF(23, CASTING, CASTING, null, DEFENSIVE_CASTING),
	BANNER(24, ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE),
	/**
	 * The displayed category is "Polearm", the same as {@link #POLEARM}, but uses a different var value than other
	 * polearms. At present, the crystal halberd is the only weapon known to use this type.
	 */
	POLEARM_CRYSTAL_HALBERD(25, CONTROLLED, AGGRESSIVE, null, DEFENSIVE),
	BLUDGEON(26, AGGRESSIVE, AGGRESSIVE, null, AGGRESSIVE),
	BULWARK(27, ACCURATE, null, null, OTHER),
	/**
	 * This weapon type is unused outside of the Tumeken's heka, which was only available in beta testing.
	 */
	POWERED_WAND(28, ACCURATE, ACCURATE, null, LONGRANGE),
	PARTISAN(29, ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE);

	@Getter
	private final AttackStyle[] attackStyles;

	WeaponType(int id, AttackStyle... attackStyles)
	{
		Preconditions.checkArgument(id == ordinal());
		Preconditions.checkArgument(attackStyles.length == 4 || attackStyles.length == 6,
			"WeaponType " + this + " does not have exactly 4 or 6 attack style arguments");
		this.attackStyles = attackStyles;
	}

	public static WeaponType getWeaponType(int id)
	{
		if (id < 0 || id > values().length)
		{
			return null;
		}

		return values()[id];
	}
}
