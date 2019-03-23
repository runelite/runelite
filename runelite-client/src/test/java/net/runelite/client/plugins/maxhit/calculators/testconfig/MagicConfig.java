package net.runelite.client.plugins.maxhit.calculators.testconfig;

import net.runelite.api.Item;
import net.runelite.api.ItemID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public enum MagicConfig
{

	TRIDENT_SLAYER(new int[]{75, 83, 99}, 0, new Item[]
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
	}, new int[]{25, 27, 34}),

	TRIDENT_OF_SEAS(new int[]{75, 83, 99}, 0, new Item[]
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
	}, new int[]{20, 22, 28}),

	TRIDENT_OF_SWAMP(new int[]{75, 83, 99}, 0, new Item[]
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
	}, new int[]{23, 25, 31}),

	MAGIC_DART(new int[]{75, 83, 99}, 18, new Item[]
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
	}, new int[]{17, 18, 19}),


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

	FLAMES_OF_ZAMORAK(75, 18, new Item[]
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



	;



	private final int[] magicLevels;
	private final int spellId;
	private final Item[] equipedItems;
	private final int[] expectedMaxHits;

	MagicConfig(int magicLevel, int spellId, Item[] equipedItems, int expectedMaxHit)
	{
		this.magicLevels = new int[]{magicLevel};
		this.spellId = spellId;
		this.equipedItems = equipedItems;
		this.expectedMaxHits = new int[]{expectedMaxHit};
	}

	MagicConfig(int[] magicLevels, int spellId, Item[] equipedItems, int[] expectedMaxHits)
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

	public int[] getMagicLevels()
	{
		return magicLevels;
	}

	public int getSpellId()
	{
		return spellId;
	}

	public Item[] getEquipedItems()
	{
		return equipedItems;
	}

	public int[] getExpectedMaxHits()
	{
		return expectedMaxHits;
	}
}
