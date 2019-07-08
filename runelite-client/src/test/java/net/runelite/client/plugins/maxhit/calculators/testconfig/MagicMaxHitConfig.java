/*
 * Copyright (c) 2019, Bartvollebregt <https://github.com/Bartvollebregt>
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
package net.runelite.client.plugins.maxhit.calculators.testconfig;

import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.maxhit.calculators.MagicMaxHitCalculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public enum MagicMaxHitConfig implements MaxHitConfig
{

	TRIDENT_SLAYER(new int[] {75, 83, 99}, 0, new Item[]
		{
			mockItem(ItemID.SLAYER_HELMET_I),
			mockItem(ItemID.SARADOMIN_CAPE),
			mockItem(ItemID.OCCULT_NECKLACE),
			mockItem(ItemID.TRIDENT_OF_THE_SEAS),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.BROODOO_SHIELD),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.MYSTIC_GLOVES),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, new int[] {25, 27, 34}),

	TRIDENT_OF_SEAS(new int[] {75, 83, 99}, 0, new Item[]
		{
			mockItem(ItemID.MYSTIC_HAT),
			mockItem(ItemID.SARADOMIN_CAPE),
			mockItem(ItemID.AMULET_OF_GLORY),
			mockItem(ItemID.TRIDENT_OF_THE_SEAS),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.BROODOO_SHIELD),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.MYSTIC_GLOVES),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, new int[] {20, 22, 28}),

	TRIDENT_OF_SWAMP(new int[] {75, 83, 99}, 0, new Item[]
		{
			mockItem(ItemID.MYSTIC_HAT),
			mockItem(ItemID.SARADOMIN_CAPE),
			mockItem(ItemID.AMULET_OF_GLORY),
			mockItem(ItemID.TRIDENT_OF_THE_SWAMP),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.BROODOO_SHIELD),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.MYSTIC_GLOVES),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, new int[] {23, 25, 31}),

	MAGIC_DART(new int[] {75, 83, 99}, 18, new Item[]
		{
			mockItem(ItemID.MYSTIC_HAT),
			mockItem(ItemID.SARADOMIN_CAPE),
			mockItem(ItemID.AMULET_OF_GLORY),
			mockItem(ItemID.SLAYERS_STAFF),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.BROODOO_SHIELD),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.MYSTIC_GLOVES),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, new int[] {17, 18, 19}),


	FIRE_BOLT(75, 8, new Item[]
		{
			mockItem(ItemID.SLAYER_HELMET_I),
			mockItem(ItemID.IMBUED_SARADOMIN_CAPE),
			mockItem(ItemID.OCCULT_NECKLACE),
			mockItem(ItemID.STAFF_OF_THE_DEAD),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.TOME_OF_FIRE),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.CHAOS_GAUNTLETS),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, 31),


	WIND_BLAST(75, 9, new Item[]
		{
			mockItem(ItemID.MYSTIC_HAT),
			mockItem(ItemID.SARADOMIN_CAPE),
			mockItem(ItemID.AMULET_OF_GLORY),
			mockItem(ItemID.STAFF_OF_AIR),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.BROODOO_SHIELD),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.MYSTIC_GLOVES),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, 13),


	EARTH_WAVE(75, 15, new Item[]
		{
			mockItem(ItemID.MYSTIC_HAT),
			mockItem(ItemID.SARADOMIN_CAPE),
			mockItem(ItemID.OCCULT_NECKLACE),
			mockItem(ItemID.STAFF_OF_EARTH),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.TOME_OF_FIRE),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.MYSTIC_GLOVES),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, 20),

	FLAMES_OF_ZAMORAK(75, 20, new Item[]
		{
			mockItem(ItemID.MYSTIC_HAT),
			mockItem(ItemID.SARADOMIN_CAPE),
			mockItem(ItemID.AMULET_OF_GLORY),
			mockItem(ItemID.STAFF_OF_THE_DEAD),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.BROODOO_SHIELD),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.MYSTIC_GLOVES),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, 23),

	SARADOMIN_STRIKE(75, 52, new Item[]
		{
			mockItem(ItemID.MYSTIC_HAT),
			mockItem(ItemID.SARADOMIN_CAPE),
			mockItem(ItemID.AMULET_OF_GLORY),
			mockItem(ItemID.STAFF_OF_LIGHT),
			mockItem(ItemID.MYSTIC_ROBE_TOP),
			mockItem(ItemID.BROODOO_SHIELD),
			null,
			mockItem(ItemID.MYSTIC_ROBE_BOTTOM),
			null,
			mockItem(ItemID.MYSTIC_GLOVES),
			mockItem(ItemID.WIZARD_BOOTS),
			mockItem(ItemID.RING_OF_WEALTH)
		}, 23),


	;


	private final int[] magicLevels;
	private final int spellId;
	private final Item[] equipedItems;
	private final int[] expectedMaxHits;

	MagicMaxHitConfig(int magicLevel, int spellId, Item[] equipedItems, int expectedMaxHit)
	{
		this.magicLevels = new int[] {magicLevel};
		this.spellId = spellId;
		this.equipedItems = equipedItems;
		this.expectedMaxHits = new int[] {expectedMaxHit};
	}

	MagicMaxHitConfig(int[] magicLevels, int spellId, Item[] equipedItems, int[] expectedMaxHits)
	{
		this.magicLevels = magicLevels;
		this.spellId = spellId;
		this.equipedItems = equipedItems;
		this.expectedMaxHits = expectedMaxHits;
	}


	private static Item mockItem(int itemId)
	{
		Item item = mock(Item.class);
		when(item.getId()).thenReturn(itemId);
		return item;
	}

	public void test(Client client)
	{
		int[] magicLevels = this.magicLevels;
		for (int i = 0, magicLevelsLength = magicLevels.length; i < magicLevelsLength; i++)
		{
			int magicLevel = magicLevels[i];
			int expectedMaxHit = this.expectedMaxHits[i];

			// Mock equipment container
			ItemContainer equipmentContainer = mock(ItemContainer.class);
			when(equipmentContainer.getItems())
				.thenReturn(this.equipedItems);
			when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipmentContainer);

			// Mock Varbits
			when(client.getBoostedSkillLevel(Skill.MAGIC)).thenReturn(magicLevel);
			when(client.getVar(Varbits.AUTO_CAST_SPELL)).thenReturn(this.spellId);

			// Test
			MagicMaxHitCalculator maxHitCalculator = new MagicMaxHitCalculator(client, this.equipedItems);
			assertEquals(this.toString(), expectedMaxHit, maxHitCalculator.getMaxHit(), 0);

		}

	}

}
