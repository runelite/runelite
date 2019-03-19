package net.runelite.client.plugins.maxhit.equipment;

@SuppressWarnings("unused")
public enum EquipmentSlot
{
	HELM_SLOT(0),
	CAPE_SLOT(1),
	NECK_SLOT(2),
	WEAPON_SLOT(3),
	CHEST_SLOT(4),
	SHIELD_SLOT(5),
	LEG_SLOT(7),
	GLOVE_SLOT(9),
	BOOT_SLOT(10),
	RING_SLOT(12);

	private final int id;

	EquipmentSlot(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}

