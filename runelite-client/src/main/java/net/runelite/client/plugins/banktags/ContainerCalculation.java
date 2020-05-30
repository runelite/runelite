package net.runelite.client.plugins.banktags;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Constants;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;

class ContainerCalculation
{
	private final ItemManager itemManager;

	private int hash;
	private ContainerPrices containerPrices;

	@Inject
	private ContainerCalculation(ItemManager itemManager)
	{
		this.itemManager = itemManager;
	}

	@Nullable
	ContainerPrices calculate(Item[] items)
	{
		// Returns last calculation if inventory hasn't changed
		final int newHash =  hashItems(items);
		if (containerPrices != null && hash == newHash)
		{
			return containerPrices;
		}

		hash = newHash;

		long ge = 0;
		long alch = 0;

		for (final Item item : items)
		{
			final int qty = item.getQuantity();
			final int id = item.getId();

			if (id <= 0 || qty == 0)
			{
				continue;
			}

			switch (id)
			{
				case ItemID.COINS_995:
					ge += qty;
					alch += qty;
					break;
				case ItemID.PLATINUM_TOKEN:
					ge += qty * 1000L;
					alch += qty * 1000L;
					break;
				default:
					final long storePrice = itemManager.getItemComposition(id).getPrice();
					final long alchPrice = (long) (storePrice * Constants.HIGH_ALCHEMY_MULTIPLIER);
					alch += alchPrice * qty;
					ge += (long) itemManager.getItemPrice(id) * qty;
					break;
			}

		}

		ContainerPrices prices = new ContainerPrices(ge, alch);
		containerPrices = prices;

		return prices;
	}

	private int hashItems(final Item[] items)
	{
		final Map<Integer, Integer> mapCheck = new HashMap<>(items.length);
		for (Item item : items)
		{
			mapCheck.put(item.getId(), item.getQuantity());
		}

		return mapCheck.hashCode();
	}
}
