package net.runelite.client.plugins.massdigger;

import java.util.Arrays;
import lombok.Value;

@Value
public class DigGroup
{
	private InventoryItem[] items;

	public DigGroup(InventoryItem[] items)
	{
		this.items = Arrays.stream(items).sorted((i1, i2) -> i1.getId() - i2.getId()).toArray(InventoryItem[]::new);
	}

	@Override
	public int hashCode()
	{
		int code = 0;
		for (InventoryItem item : items)
		{
			code += item.getId() ^ item.getQuantity();
		}
		return code;
	}

	@Override
	public boolean equals(Object object)
	{
		if (object == null || object.getClass() != this.getClass())
		{
			return false;
		}

		DigGroup o = (DigGroup)object;

		if (items.length != o.items.length)
		{
			return false;
		}

		for (int i = 0; i < items.length; i++)
		{
			if (items[i].getId() != o.items[i].getId() ||
				items[i].getQuantity() != o.items[i].getQuantity())
			{
				return false;
			}
		}

		return true;
	}
}
