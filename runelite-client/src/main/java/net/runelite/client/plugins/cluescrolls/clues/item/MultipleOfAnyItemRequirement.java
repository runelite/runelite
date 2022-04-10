package net.runelite.client.plugins.cluescrolls.clues.item;

import net.runelite.api.Client;
import net.runelite.api.Item;

public class MultipleOfAnyItemRequirement implements ItemRequirement
{

	private final String name;
	private final int[] requirements;
	private final int quantity;

	public MultipleOfAnyItemRequirement(String name, int quantity, int... requirements)
	{
		this.name = name;
		this.quantity = quantity;
		this.requirements = requirements;
	}

	@Override
	public boolean fulfilledBy(int itemId)
	{
		for (int item : requirements)
		{
			if (item == itemId)
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean fulfilledBy(Item[] items)
	{
		int quantityFound = 0;

		for (int requirement : requirements)
		{
			for (Item item : items)
			{
				if (requirement == item.getId())
				{
					quantityFound += item.getQuantity();
					if (quantityFound >= quantity)
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public String getCollectiveName(Client client)
	{
		return name;
	}
}
