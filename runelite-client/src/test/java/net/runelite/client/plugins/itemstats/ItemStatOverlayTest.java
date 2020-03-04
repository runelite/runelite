/*
 * Copyright (c) 2020 Jordan <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.itemstats;

import net.runelite.api.EquipmentInventorySlot;
import net.runelite.http.api.item.ItemEquipmentStats;
import net.runelite.http.api.item.ItemStats;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ItemStatOverlayTest
{
	// Weapon definitions
	private static final ItemStats ABYSSAL_DAGGER = new ItemStats(false, true, 0.453, 8,
		ItemEquipmentStats.builder()
			.slot(EquipmentInventorySlot.WEAPON.getSlotIdx())
			.astab(75)
			.aslash(40)
			.acrush(-4)
			.amagic(1)
			.dmagic(1)
			.str(75)
			.aspeed(4)
			.build());
	private static final ItemStats KATANA = new ItemStats(false, true, 0, 8,
		ItemEquipmentStats.builder()
			.slot(EquipmentInventorySlot.WEAPON.getSlotIdx())
			.astab(7)
			.aslash(45)
			.dstab(3)
			.dslash(7)
			.dcrush(7)
			.drange(-3)
			.str(40)
			.aspeed(4)
			.build());
	private static final ItemStats BLOWPIPE = new ItemStats(false, true, 0, 0,
		ItemEquipmentStats.builder()
			.slot(EquipmentInventorySlot.WEAPON.getSlotIdx())
			.arange(60)
			.rstr(40)
			.aspeed(3)
			.build());
	private static final ItemStats HEAVY_BALLISTA = new ItemStats(false, true, 4, 8,
		ItemEquipmentStats.builder()
			.slot(EquipmentInventorySlot.WEAPON.getSlotIdx())
			.arange(110)
			.aspeed(7)
			.build());

	@Test
	public void testUnarmedAttackSpeed()
	{
		assertEquals(ItemStatOverlay.UNARMED.getEquipment().getAspeed(), ABYSSAL_DAGGER.getEquipment().getAspeed());
		assertEquals(ItemStatOverlay.UNARMED.getEquipment().getAspeed(), KATANA.getEquipment().getAspeed());
		assertEquals(-1, BLOWPIPE.getEquipment().getAspeed() - ItemStatOverlay.UNARMED.getEquipment().getAspeed());
		assertEquals(3, HEAVY_BALLISTA.getEquipment().getAspeed() - ItemStatOverlay.UNARMED.getEquipment().getAspeed());
	}
}
