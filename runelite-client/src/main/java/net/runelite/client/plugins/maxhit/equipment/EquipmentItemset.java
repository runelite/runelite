package net.runelite.client.plugins.maxhit.equipment;

import java.util.List;

public class EquipmentItemset
{
	private final List<EquipmentSlotItem> items;

	public EquipmentItemset(List<EquipmentSlotItem> items)
	{
		this.items = items;
	}

	public List<EquipmentSlotItem> getItems()
	{
		return items;
	}
}
