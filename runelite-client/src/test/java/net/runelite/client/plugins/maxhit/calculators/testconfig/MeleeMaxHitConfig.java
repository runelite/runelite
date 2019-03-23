package net.runelite.client.plugins.maxhit.calculators.testconfig;

import net.runelite.api.*;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.maxhit.attackstyle.WeaponType;
import net.runelite.client.plugins.maxhit.calculators.MeleeMaxHitCalculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public enum MeleeMaxHitConfig implements MaxHitConfig
{

	DRAGON_SCIMITAR(new int[] {75, 83, 99}, 66, WeaponType.TYPE_9, 1, new Item[]
		{
			mockItem(ItemID.IRON_FULL_HELM),
			mockItem(ItemID.BLACK_CAPE),
			mockItem(ItemID.GOLD_NECKLACE),
			mockItem(ItemID.DRAGON_SCIMITAR),
			mockItem(ItemID.IRON_PLATEBODY),
			mockItem(ItemID.IRON_KITESHIELD),
			null,
			mockItem(ItemID.IRON_PLATELEGS),
			null,
			mockItem(ItemID.LEATHER_GLOVES),
			mockItem(ItemID.LEATHER_BOOTS),
			mockItem(ItemID.GOLD_RING)
		}, new int[] {17, 19, 22}),

	DRAGON_SCIMITAR_DEFENDER(new int[] {75, 83, 99}, 76, WeaponType.TYPE_9, 1, new Item[]
		{
			mockItem(ItemID.IRON_FULL_HELM),
			mockItem(ItemID.BLACK_CAPE),
			mockItem(ItemID.GOLD_NECKLACE),
			mockItem(ItemID.DRAGON_SCIMITAR),
			mockItem(ItemID.IRON_PLATEBODY),
			mockItem(ItemID.DRAGON_DEFENDER),
			null,
			mockItem(ItemID.IRON_PLATELEGS),
			null,
			mockItem(ItemID.LEATHER_GLOVES),
			mockItem(ItemID.LEATHER_BOOTS),
			mockItem(ItemID.GOLD_RING)
		}, new int[] {19, 21, 24}),

	DRAGON_SCIMITAR_COMPLETE(new int[] {75, 83, 99}, 108, WeaponType.TYPE_9, 1, new Item[]
		{
			mockItem(ItemID.SLAYER_HELMET),
			mockItem(ItemID.FIRE_CAPE),
			mockItem(ItemID.AMULET_OF_FURY),
			mockItem(ItemID.DRAGON_SCIMITAR),
			mockItem(ItemID.FIGHTER_TORSO),
			mockItem(ItemID.DRAGON_DEFENDER),
			null,
			mockItem(ItemID.IRON_PLATELEGS),
			null,
			mockItem(ItemID.BARROWS_GLOVES),
			mockItem(ItemID.DRAGON_BOOTS),
			mockItem(ItemID.BERSERKER_RING)
		}, new int[] {26, 29, 35}),

	OBSIDIAN_SET(new int[] {75, 83, 99}, 61, WeaponType.TYPE_17, 2, new Item[]
		{
			mockItem(ItemID.OBSIDIAN_HELMET),
			mockItem(ItemID.OBSIDIAN_CAPE),
			mockItem(ItemID.GOLD_NECKLACE),
			mockItem(ItemID.TOKTZXILAK),
			mockItem(ItemID.OBSIDIAN_PLATEBODY),
			mockItem(ItemID.TOKTZKETXIL),
			null,
			mockItem(ItemID.OBSIDIAN_PLATELEGS),
			null,
			mockItem(ItemID.LEATHER_GLOVES),
			mockItem(ItemID.LEATHER_BOOTS),
			mockItem(ItemID.GOLD_RING)
		}, new int[] {18, 19, 23}),

	DHAROK_SET(new int[] {75, 75, 75, 83, 83, 83, 99, 99, 99}, 105, WeaponType.TYPE_1, 1,
		new int[][]{{99, 99}, {1, 99}, {32, 75}, {99, 99}, {1, 99}, {32, 75}, {99, 99}, {1, 99}, {32, 75}},
		new Item[]
		{
			mockItem(ItemID.DHAROKS_HELM_100),
			mockItem(ItemID.BLACK_CAPE),
			mockItem(ItemID.GOLD_NECKLACE),
			mockItem(ItemID.DHAROKS_GREATAXE_100),
			mockItem(ItemID.DHAROKS_PLATEBODY_100),
			null,
			null,
			mockItem(ItemID.DHAROKS_PLATELEGS_100),
			null,
			mockItem(ItemID.LEATHER_GLOVES),
			mockItem(ItemID.LEATHER_BOOTS),
			mockItem(ItemID.GOLD_RING)
		}, new int[] {23, 45, 30, 25, 49, 33, 29, 57, 38}),
	;


	private final int[] strengthLevels;
	private int[][] hitpoints = new int[][] {{99, 99}};
	private int meleeEquipmentStrength;
	private final WeaponType weaponType;
	private final int attackStyleId;
	private final Item[] equipedItems;
	private final int[] expectedMaxHits;

	MeleeMaxHitConfig(int strengthLevel, int meleeEquipmentStrength, WeaponType weaponType, int attackStyleId, Item[] equipedItems, int expectedMaxHit)
	{
		this.strengthLevels = new int[] {strengthLevel};
		this.meleeEquipmentStrength = meleeEquipmentStrength;
		this.weaponType = weaponType;
		this.attackStyleId = attackStyleId;
		this.equipedItems = equipedItems;
		this.expectedMaxHits = new int[] {expectedMaxHit};
	}

	MeleeMaxHitConfig(int[] strengthLevels, int meleeEquipmentStrength, WeaponType weaponType, int attackStyleId, int[][] hitpoints, Item[] equipedItems, int[] expectedMaxHits)
	{
		this.strengthLevels = strengthLevels;
		this.meleeEquipmentStrength = meleeEquipmentStrength;
		this.weaponType = weaponType;
		this.attackStyleId = attackStyleId;
		this.hitpoints = hitpoints;
		this.equipedItems = equipedItems;
		this.expectedMaxHits = expectedMaxHits;
	}

	MeleeMaxHitConfig(int[] strengthLevels, int meleeEquipmentStrength, WeaponType weaponType, int attackStyleId, Item[] equipedItems, int[] expectedMaxHits)
	{
		this.strengthLevels = strengthLevels;
		this.hitpoints = new int[strengthLevels.length][2];
		this.meleeEquipmentStrength = meleeEquipmentStrength;
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
		int[] strengthLevels = this.strengthLevels;
		for (int i = 0, strengthLevelsLength = strengthLevels.length; i < strengthLevelsLength; i++)
		{
			int strengthLevel = strengthLevels[i];
			int[] hitpoints = this.hitpoints[i];
			int expectedMaxHit = this.expectedMaxHits[i];

			// Mock equipment container
			ItemContainer equipmentContainer = mock(ItemContainer.class);
			when(equipmentContainer.getItems())
				.thenReturn(this.equipedItems);
			when(client.getItemContainer(InventoryID.EQUIPMENT)).thenReturn(equipmentContainer);

			// Mock equipment strength
			Widget equipmentWidget = mock(Widget.class);
			when(client.getWidget(WidgetInfo.EQUIPMENT_MELEE_STRENGTH)).thenReturn(equipmentWidget);
			when(equipmentWidget.getText()).thenReturn("Melee strength: " + this.meleeEquipmentStrength);

			// Mock Varbits
			when(client.getVar(Varbits.EQUIPPED_WEAPON_TYPE)).thenReturn(this.weaponType.ordinal());
			when(client.getVar(VarPlayer.ATTACK_STYLE)).thenReturn(this.attackStyleId);

			// Mock strength
			when(client.getRealSkillLevel(Skill.STRENGTH)).thenReturn(strengthLevel);

			// Mock hitpoints
			when(client.getBoostedSkillLevel(Skill.HITPOINTS)).thenReturn(hitpoints[0]);
			when(client.getRealSkillLevel(Skill.HITPOINTS)).thenReturn(hitpoints[1]);

			// Test
			MeleeMaxHitCalculator maxHitCalculator = new MeleeMaxHitCalculator(client, this.equipedItems);
			assertEquals(this.toString(), expectedMaxHit, maxHitCalculator.calculate(), 0);

		}

	}

}
