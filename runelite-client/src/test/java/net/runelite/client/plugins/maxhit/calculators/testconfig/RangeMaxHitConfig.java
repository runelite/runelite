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
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.attackstyle.WeaponType;
import net.runelite.client.plugins.maxhit.calculators.RangeMaxHitCalculator;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public enum RangeMaxHitConfig implements MaxHitConfig
{

	MAGIC_SHORTBOW(new int[]{75, 83, 99}, 49, WeaponType.TYPE_3, 1, new Item[]
		{
			mockItem(ItemID.IRON_FULL_HELM),
			mockItem(ItemID.BLACK_CAPE),
			mockItem(ItemID.GOLD_NECKLACE),
			mockItem(ItemID.MAGIC_SHORTBOW),
			mockItem(ItemID.IRON_PLATEBODY),
			null,
			null,
			mockItem(ItemID.IRON_PLATELEGS),
			null,
			mockItem(ItemID.LEATHER_GLOVES),
			mockItem(ItemID.LEATHER_BOOTS),
			mockItem(ItemID.GOLD_RING),
			mockItem(ItemID.RUNE_ARROW)
		}, new int[]{15, 16, 19}),

	RUNE_CROSSBOW(new int[]{75, 83, 99}, 115, WeaponType.TYPE_5, 0, new Item[]
		{
			mockItem(ItemID.IRON_FULL_HELM),
			mockItem(ItemID.BLACK_CAPE),
			mockItem(ItemID.GOLD_NECKLACE),
			mockItem(ItemID.RUNE_CROSSBOW),
			mockItem(ItemID.IRON_PLATEBODY),
			null,
			null,
			mockItem(ItemID.IRON_PLATELEGS),
			null,
			mockItem(ItemID.LEATHER_GLOVES),
			mockItem(ItemID.LEATHER_BOOTS),
			mockItem(ItemID.GOLD_RING),
			mockItem(ItemID.RUNITE_BOLTS)
		}, new int[]{24, 26, 31}),

	BLOwPIPE(new int[]{75, 83, 99}, 50, WeaponType.TYPE_19, 1, new Item[]
		{
			mockItem(ItemID.IRON_FULL_HELM),
			mockItem(ItemID.BLACK_CAPE),
			mockItem(ItemID.GOLD_NECKLACE),
			mockItem(ItemID.TOXIC_BLOWPIPE),
			mockItem(ItemID.IRON_PLATEBODY),
			null,
			null,
			mockItem(ItemID.IRON_PLATELEGS),
			null,
			mockItem(ItemID.LEATHER_GLOVES),
			mockItem(ItemID.LEATHER_BOOTS),
			mockItem(ItemID.GOLD_RING)
		}, new int[]{15, 16, 19}),

	VOID_SET(new int[]{75, 83, 99}, 115, WeaponType.TYPE_5, 1, new Item[]
		{
			mockItem(ItemID.VOID_RANGER_HELM),
			mockItem(ItemID.BLACK_CAPE),
			mockItem(ItemID.GOLD_NECKLACE),
			mockItem(ItemID.RUNE_CROSSBOW),
			mockItem(ItemID.VOID_KNIGHT_TOP),
			mockItem(ItemID.IRON_KITESHIELD),
			null,
			mockItem(ItemID.VOID_KNIGHT_ROBE),
			null,
			mockItem(ItemID.VOID_KNIGHT_GLOVES),
			mockItem(ItemID.LEATHER_BOOTS),
			mockItem(ItemID.GOLD_RING)
		}, new int[]{26, 28, 33}),

	;

	private final int[] rangeLevels;
	private final WeaponType weaponType;
	private final int attackStyleId;
	private final Item[] equipedItems;
	private final int[] expectedMaxHits;
	private final int ammoEquipmentStrength;

	RangeMaxHitConfig(int[] rangeLevels, int ammoEquipmentStrength, WeaponType weaponType, int attackStyleId, Item[] equipedItems, int[] expectedMaxHits)
	{
		this.rangeLevels = rangeLevels;
		this.ammoEquipmentStrength = ammoEquipmentStrength;
		this.weaponType = weaponType;
		this.attackStyleId = attackStyleId;
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
		int[] rangeLevels = this.rangeLevels;
		for (int i = 0, rangeLevelsLength = rangeLevels.length; i < rangeLevelsLength; i++)
		{
			int rangeLevel = rangeLevels[i];
			int expectedMaxHit = this.expectedMaxHits[i];

			// Mock equipment container
			ItemContainer equipmentContainer = mock(ItemContainer.class);
			when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipmentContainer);

			// Mock equipment strength
			Widget equipmentWidget = mock(Widget.class);
			when(client.getWidget(WidgetInfo.EQUIPMENT_RANGED_STRENGTH)).thenReturn(equipmentWidget);
			when(equipmentWidget.getText()).thenReturn("Ranged strength: " + this.ammoEquipmentStrength);

			// Mock Varbits
			when(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE)).thenReturn(this.weaponType.ordinal());
			when(client.getVar(VarPlayer.ATTACK_STYLE)).thenReturn(this.attackStyleId);

			// Mock strength
			when(client.getBoostedSkillLevel(Skill.RANGED)).thenReturn(rangeLevel);

			// Test
			RangeMaxHitCalculator maxHitCalculator = new RangeMaxHitCalculator(client, this.equipedItems);
			assertEquals(this.toString(), expectedMaxHit, maxHitCalculator.getMaxHit(), 0);

		}

	}

}
