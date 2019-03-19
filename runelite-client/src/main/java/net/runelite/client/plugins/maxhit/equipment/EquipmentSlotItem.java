package net.runelite.client.plugins.maxhit.equipment;

public class EquipmentSlotItem
{
	private final EquipmentSlot equipmentSlot;
	private final String item;

	public EquipmentSlotItem(EquipmentSlot equipmentSlot, String item)
	{
		this.equipmentSlot = equipmentSlot;
		this.item = item;
	}

	public String getItem()
	{
		return item;
	}

	public EquipmentSlot getEquipmentSlot()
	{
		return equipmentSlot;
	}
}
