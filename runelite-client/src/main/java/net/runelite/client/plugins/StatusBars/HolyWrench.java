package net.runelite.client.plugins.StatusBars;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;


public class HolyWrench
{
	private static final int RING_SLOT = 12;
	private static final int CAPE_SLOT = 1;

	public HolyWrench()
	{

	}

	public boolean hasWrench(Client client)
	{
		boolean hasHolyWrench = false;

		ItemContainer equipContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipContainer != null)
		{
			Item[] equip = equipContainer.getItems();

			hasHolyWrench |= equip.length > RING_SLOT && equip[RING_SLOT].getId() == ItemID.RING_OF_THE_GODS_I;
			if (equip.length > CAPE_SLOT)
			{
				int cape = equip[CAPE_SLOT].getId();
				hasHolyWrench |= cape == ItemID.PRAYER_CAPE;
				hasHolyWrench |= cape == ItemID.PRAYER_CAPET;
				hasHolyWrench |= cape == ItemID.PRAYER_CAPE_10643; // No idea what this is
				hasHolyWrench |= cape == ItemID.MAX_CAPE;
				hasHolyWrench |= cape == ItemID.MAX_CAPE_13282; // Or these
				hasHolyWrench |= cape == ItemID.MAX_CAPE_13342;
			}
		}

		if (!hasHolyWrench)
		{
			ItemContainer invContainer = client.getItemContainer(InventoryID.INVENTORY);
			if (invContainer != null)
			{
				for (Item itemStack : invContainer.getItems())
				{
					int item = itemStack.getId();
					hasHolyWrench |= item == ItemID.HOLY_WRENCH;
					hasHolyWrench |= item == ItemID.PRAYER_CAPE;
					hasHolyWrench |= item == ItemID.PRAYER_CAPET;
					hasHolyWrench |= item == ItemID.PRAYER_CAPE_10643;
					hasHolyWrench |= item == ItemID.MAX_CAPE;
					hasHolyWrench |= item == ItemID.MAX_CAPE_13282;
					hasHolyWrench |= item == ItemID.MAX_CAPE_13342;

					if (hasHolyWrench)
					{
						break;
					}
				}
			}
		}
		return hasHolyWrench;
	}
}