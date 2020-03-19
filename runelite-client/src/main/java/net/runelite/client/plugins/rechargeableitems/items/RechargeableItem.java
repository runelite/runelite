package net.runelite.client.plugins.rechargeableitems.items;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RechargeableItem
{
	protected int currentAmountOfCharges = 0;

	public abstract String getRechargeMessage(String message);

	/**
	 * Get, if there are any numbers in the string, one or more matches.
	 * <p>
	 * Regex used is found on https://stackoverflow.com/a/5917250/9050460 below the header "Embedded numbers"
	 * `((?!\S)|(?=\.))|(?=%)` is added at the end of the regex to get numbers with a literal . and % attached, such as the end of a sentence.
	 *
	 * @param message Game message containing the current amount of charges on an item
	 * @return a list of strings matching the regex (any number, included with comma's)
	 */
	protected List<String> getNumbersFromString(String message)
	{
		Pattern pattern = Pattern.compile("(?<!\\S)(\\d*\\.?\\d+|\\d{1,3}(,\\d{3})*(\\.\\d+)?)((?!\\S)|(?=\\.)|(?=%))");
		Matcher matcher = pattern.matcher(message);
		List<String> result = new ArrayList<>();

		while (matcher.find())
		{
			result.add(matcher.group());
		}

		return result;
	}

	/**
	 * Build a string with a given formatting template and a variable amount of integer parameters.
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

	protected int parseNumber(String number)
	{
		int result = 0;

		try
		{
			result = Integer.parseInt(number.replace(",", "").trim());
		}
		catch (NumberFormatException e)
		{
			System.err.println(e.getMessage());
		}

		return result;
	}
}
