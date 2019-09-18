package net.runelite.client.plugins.menuentryswapper.comparables;

import java.util.List;
import net.runelite.api.MenuEntry;
import net.runelite.api.util.Text;
import net.runelite.client.menus.AbstractComparableEntry;

public class ShopComparableEntry extends AbstractComparableEntry
{
	private ShopComparableEntry(final boolean buy, final int amount, final String item)
	{
		assert amount == 1 || amount == 5 || amount == 10 || amount == 50 : "Only 1, 5, 10, or 50 are valid amounts";

		this.setOption((buy ? "Buy " : "Sell ") + amount);
		this.setTarget(Text.standardize(item));
	}

	@Override
	public boolean matches(final MenuEntry entry)
	{
		return entry.getOption().equals(this.getOption()) && Text.standardize(entry.getTarget()).equals(this.getTarget());
	}

	@Override
	public int getPriority()
	{
		return 100;
	}

	@Override
	public boolean equals(Object other)
	{
		return other instanceof ShopComparableEntry && super.equals(other);
	}

	/**
	 * Fills the array with ShopComparableEntries, getting the items from the fed list
	 */
	public static void populateArray(final AbstractComparableEntry[] array, final List<String> items, final boolean buy, final int amount)
	{
		for (int i = 0; i < array.length; i++)
		{
			array[i] = new ShopComparableEntry(buy, amount, items.get(i));
		}
	}
}
