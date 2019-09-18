package net.runelite.client.menus;

import net.runelite.api.Client;
import net.runelite.client.plugins.menuentryswapper.comparables.BankComparableEntry;

public interface ComparableEntries
{
	/**
	 * BaseComparableEntries should only be used if there's
	 * no better ComparableEntry available.
	 *
	 * @param option has to equal entry option
	 * @param target has to equal entry option
	 *
	 * @return a new BaseComparableEntry
	 */
	static BaseComparableEntry newBaseComparableEntry(String option, String target)
	{
		return new BaseComparableEntry(option, target, -1, -1, true, true);
	}

	/**
	 * BaseComparableEntries should only be used if there's
	 * no better ComparableEntry available.
	 *
	 * @param option has to equal option
	 * @param target equal or contains depending on strictTarget
	 * @param strictTarget read up one line
	 *
	 * @return a new BaseComparableEntry
	 */
	static BaseComparableEntry newBaseComparableEntry(String option, String target, boolean strictTarget)
	{
		return new BaseComparableEntry(option, target, -1, -1, true, strictTarget);
	}

	/**
	 * BaseComparableEntries should only be used if there's
	 * no better ComparableEntry available.
	 *
	 * @param option equal or contains depending on strictOption
	 * @param target equal or contains depending on strictTarget
	 * @param id has to be the same, or -1 to skip checking
	 * @param type has to be the same, or -1 to skip checking
	 * @param strictOption strict option or nah
	 * @param strictTarget strict target or nah
	 *
	 * @return a new BaseComparableEntry
	 */
	static BaseComparableEntry newBaseComparableEntry(String option, String target, int id, int type, boolean strictOption, boolean strictTarget)
	{
		return new BaseComparableEntry(option, target, id, type, strictOption, strictTarget);
	}

	/**
	 * This comparable finds all items with itemName
	 * in their name. It then checks the ItemDefinition
	 * for each of them, to see if it's possible for
	 * the item to have option as one of their options.
	 *
	 * This has to be ran on the clientthread!
	 */
	static ItemComparableEntry newInvItemComparableEntry(Client client, String option, String itemName)
	{
		return new ItemComparableEntry.InvItemComparableEntry(client, option, itemName);
	}

	/**
	 * This will only match items in the bank or in
	 * your inventory if the bank is open. Withdraw-x anyone?
	 */
	static BankComparableEntry newBankComparableEntry(String option, String itemName)
	{
		return new BankComparableEntry(option, itemName, false);
	}
}
