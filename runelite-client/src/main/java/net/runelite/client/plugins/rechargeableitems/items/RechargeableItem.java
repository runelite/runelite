package net.runelite.client.plugins.rechargeableitems.items;

import java.util.Formatter;
import java.util.List;

public abstract class RechargeableItem
{
	protected int currentAmountOfCharges;

	public abstract void setupValues(String message);

	public abstract String getRechargeMessage();

	/**
	 * Build a string with a given formatting template and a variable amount of integer paramters.
	 *
	 * @param template  String containing the format.
	 * @param variables Variable amount of parameters that need to be displayed in the string.
	 * @return String containing the formatted message
	 */
	protected String formatRechargeMessage(String template, Integer... variables)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		final Formatter formatter = new Formatter(stringBuilder);
		Object[] args = new Object[variables.length];

		System.arraycopy(variables, 0, args, 0, variables.length);
		formatter.format(template, args);

		return stringBuilder.toString();
	}

	/**
	 * Find a word in front of a given word.
	 * This is because the standard API does not provide a way to get the current amount of charges.
	 * When the word is found it is parsed into an integer to be used in the recharge caluclations.
	 *
	 * @param words List of Strings containing all the words
	 * @param word  String of a given word to find within the List
	 * @return int containing the amount of charges
	 */
	protected int findCurrentChargeValue(List<String> words, String word)
	{
		int result = 0;

		try
		{
			result = Integer.parseInt(words.get(words.indexOf(word) - 1).trim());
		}
		catch (NumberFormatException e)
		{
			System.err.println(e.getMessage());
		}

		return result;
	}
}
