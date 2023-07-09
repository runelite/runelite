/*
 * Copyright (c) 2023, Jordan Atwood <nightfirecat@nightfirec.at>
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
package net.runelite.client.plugins.specialcounter;

import static net.runelite.client.plugins.specialcounter.SpecialWeapon.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SpecialWeaponTest
{
	@Test
	public void verifyMeleeWeaponHitDelay()
	{
		assertRangeDelayEquals(1, DRAGON_WARHAMMER, 1);
		assertRangeDelayEquals(1, ARCLIGHT, 1);
		assertRangeDelayEquals(1, DARKLIGHT, 1);
		assertRangeDelayEquals(1, BANDOS_GODSWORD, 1);
		assertRangeDelayEquals(1, BARRELCHEST_ANCHOR, 1);
		assertRangeDelayEquals(1, BONE_DAGGER, 1);
		assertRangeDelayEquals(1, BULWARK, 1);
	}

	@Test
	public void verifyDorgeshuunCrossbowHitDelay()
	{
		assertRangeDelayEquals(3, DORGESHUUN_CROSSBOW, 1);
		assertRangeDelayEquals(3, DORGESHUUN_CROSSBOW, 2);
		assertRangeDelayEquals(3, DORGESHUUN_CROSSBOW, 3);
		assertRangeDelayEquals(3, DORGESHUUN_CROSSBOW, 4);
		assertRangeDelayEquals(3, DORGESHUUN_CROSSBOW, 5);
		assertRangeDelayEquals(3, DORGESHUUN_CROSSBOW, 6);
		assertRangeDelayEquals(3, DORGESHUUN_CROSSBOW, 7);
	}

	@Test
	public void verifyAccursedSceptreHitDelay()
	{
		assertRangeDelayEquals(2, ACCURSED_SCEPTRE, 1);
		assertRangeDelayEquals(3, ACCURSED_SCEPTRE, 2);
		assertRangeDelayEquals(3, ACCURSED_SCEPTRE, 3);
		assertRangeDelayEquals(3, ACCURSED_SCEPTRE, 4);
		assertRangeDelayEquals(4, ACCURSED_SCEPTRE, 5);
		assertRangeDelayEquals(4, ACCURSED_SCEPTRE, 6);
		assertRangeDelayEquals(4, ACCURSED_SCEPTRE, 7);
		assertRangeDelayEquals(5, ACCURSED_SCEPTRE, 8);
		assertRangeDelayEquals(5, ACCURSED_SCEPTRE, 9);
	}

	private static void assertRangeDelayEquals(final int expected, final SpecialWeapon specialWeapon, final int range)
	{
		assertEquals(expected, specialWeapon.getHitDelay(range));
	}
}
