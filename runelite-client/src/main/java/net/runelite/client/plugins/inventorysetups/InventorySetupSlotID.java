package net.runelite.client.plugins.inventorysetups;

public enum InventorySetupSlotID
{
	INVENTORY(0),
	EQUIPMENT(1),
	RUNE_POUCH(2),
	SPELL_BOOK(3);

	private final int id;

	InventorySetupSlotID(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
