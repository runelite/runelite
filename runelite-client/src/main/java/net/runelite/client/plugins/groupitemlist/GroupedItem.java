package net.runelite.client.plugins.groupitemlist;

import net.runelite.api.MenuEntry;
import net.runelite.client.plugins.groupitemlist.GroupItemListConfig.*;

/**
 * Object used to store a MenuEntry and the quantity. Updates the entry target if necessary
 * e.g Shark to Shark [4].
 */
public class GroupedItem
{

	private int count;
	private MenuEntry entry;
	private styleOption style;
	private positionOption pos;
	private boolean includeX;

	/**
	 * Constructor for GroupedItem.
	 *
	 * @param entry The menu entry to be tracked for duplicates
	 */
	GroupedItem(MenuEntry entry, positionOption pos, styleOption style, boolean includeX)
	{
		this.entry = entry;
		this.pos = pos;
		this.style = style;
		this.count = 1;
		this.includeX = includeX;
	}

	/**
	 * Getter for the count.
	 *
	 * @return count
	 */
	public int getCount()
	{
		return count;
	}

	/**
	 * Getter for the menu entry, updates the target to reflect the quantity if more than 1
	 * was found.
	 *
	 * @return Updated MenuEntry containing quantity
	 */
	MenuEntry getEntry()
	{
		if (count > 1)
		{
			updateTarget();
		}
		return entry;
	}

	/**
	 * Updates the target of the menu entry to contain the quantity found in the desired style.
	 */
	private void updateTarget()
	{
		String target = entry.getTarget();
		String quantity = "";

		if (includeX)
		{
			quantity = "x";
		}

		quantity += count;

		switch (style)
		{
			case SQUARE:
				quantity = "[" + quantity + "]";
				break;
			case PARENTHESES:
				quantity = "(" + quantity + ")";
				break;
			case CURLY:
				quantity = "{" + quantity + "}";
				break;
		}

		switch (pos)
		{
			case APPEND:
				target = target + " " + quantity;
				break;
			case PREPEND:
				target = quantity + " " + target;
				break;
		}
		entry.setTarget(target);
	}

	/**
	 * Increment count when duplicate entries are found.
	 */
	void incrementCount()
	{
		count += 1;
	}
}
