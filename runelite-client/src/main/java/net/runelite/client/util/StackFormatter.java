/*
 * Copyright (c) 2018, arlyon <https://github.com/arlyon>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A set of utility functions to use when
 * formatting numbers for to stack sizes.
 */
public class StackFormatter
{
	/**
	 * A list of suffixes to use when formatting stack sizes.
	 */
	private static final String[] SUFFIXES = {"", "K", "M", "B"};

	/**
	 * A pattern to match a value suffix (K, M etc) in a string.
	 */
	private static final Pattern SUFFIX_PATTERN = Pattern.compile("^-?[0-9,.]+([a-zA-Z]?)$");

	/**
	 * A number formatter
	 */
	private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance(Locale.ENGLISH);

	/**
	 * A decimal number formatter
	 */
	private static final NumberFormat DECIMAL_FORMATTER = new DecimalFormat(
		"#,###.#",
		DecimalFormatSymbols.getInstance(Locale.ENGLISH)
	);

	/**
	 * Convert a quantity to a nicely formatted stack size.
	 * See the StackFormatterTest to see expected output.
	 *
	 * @param quantity The quantity to convert.
	 * @return A condensed version, with commas, K, M or B
	 * as needed to 3 significant figures.
	 */
	public static String quantityToStackSize(long quantity)
	{
		if (quantity < 0)
		{
			// Long.MIN_VALUE = -1 * Long.MIN_VALUE so we need to correct for it.
			return "-" + quantityToStackSize(quantity == Long.MIN_VALUE ? Long.MAX_VALUE : -quantity);
		}
		else if (quantity < 10_000)
		{
			return NUMBER_FORMATTER.format(quantity);
		}

		String suffix = SUFFIXES[0];
		long divideBy = 1;

		// determine correct suffix by iterating backward through the list
		// of suffixes until the suffix results in a value >= 1
		for (int i = (SUFFIXES.length - 1); i >= 0; i--)
		{
			divideBy = (long) Math.pow(10, i * 3);
			if ((double) quantity / divideBy >= 1)
			{
				suffix = SUFFIXES[i];
				break;
			}
		}

		// get locale formatted string
		String formattedString = NUMBER_FORMATTER.format((double) quantity / divideBy);

		// strip down any digits past the 4 first
		formattedString = (formattedString.length() > 4 ? formattedString.substring(0, 4) : formattedString);

		// make sure the last character is not a "."
		return (formattedString.endsWith(".") ? formattedString.substring(0, 3) : formattedString) + suffix;
	}

	/**
	 * Convert a quantity to stack size as it would
	 * appear in RuneScape.
	 *
	 * @param quantity The quantity to convert.
	 * @return The stack size as it would appear in RS,
	 * with K after 100,000 and M after 10,000,000
	 */
	public static String quantityToRSStackSize(int quantity)
	{
		if (quantity == Integer.MIN_VALUE)
		{
			// Integer.MIN_VALUE = Integer.MIN_VALUE * -1 so we need to correct for it.
			return "-" + quantityToRSStackSize(Integer.MAX_VALUE);
		}
		else if (quantity < 0)
		{
			return "-" + quantityToRSStackSize(-quantity);
		}
		else if (quantity < 100_000)
		{
			return Integer.toString(quantity);
		}
		else if (quantity < 10_000_000)
		{
			return quantity / 1_000 + "K";
		}
		else
		{
			return quantity / 1_000_000 + "M";
		}
	}

	/**
	 * Convert a quantity to stack size as it would
	 * appear in RuneScape. (with decimals)
	 * <p>
	 * This differs from quantityToRSStack in that it displays
	 * decimals. Ex: 27100 is 27.1k (not 27k)
	 * <p>
	 *
	 * @param quantity The quantity to convert.
	 * @return The stack size as it would appear in RS, with decimals,
	 * with K after 100,000 and M after 10,000,000
	 */
	public static String quantityToRSDecimalStack(int quantity)
	{
		String quantityStr = String.valueOf(quantity);
		if (quantityStr.length() <= 4)
		{
			return quantityStr;
		}

		int power = (int) Math.log10(quantity);
		return DECIMAL_FORMATTER.format(quantity / (Math.pow(10, (power / 3) * 3))) + SUFFIXES[power / 3];
	}

	/**
	 * Converts a string representation of a stack
	 * back to (close to) it's original value.
	 *
	 * @param string The string to convert.
	 * @return A long representation of it.
	 */
	public static long stackSizeToQuantity(String string) throws ParseException
	{
		int multiplier = getMultiplier(string);
		float parsedValue = NUMBER_FORMATTER.parse(string).floatValue();
		return (long) (parsedValue * multiplier);
	}

	/**
	 * Specialization of format.
	 *
	 * @param number the long number to format
	 * @return the formatted String
	 * @throws ArithmeticException if rounding is needed with rounding
	 *                             mode being set to RoundingMode.UNNECESSARY
	 * @see java.text.Format#format
	 */
	public static String formatNumber(final long number)
	{
		return NUMBER_FORMATTER.format(number);
	}

	/**
	 * Specialization of format.
	 *
	 * @param number the double number to format
	 * @return the formatted String
	 * @throws ArithmeticException if rounding is needed with rounding
	 *                             mode being set to RoundingMode.UNNECESSARY
	 * @see java.text.Format#format
	 */
	public static String formatNumber(double number)
	{
		return NUMBER_FORMATTER.format(number);
	}

	/**
	 * Calculates, given a string with a value denominator (ex. 20K)
	 * the multiplier that the denominator represents (in this case 1000).
	 *
	 * @param string The string to check.
	 * @return The value of the value denominator.
	 * @throws ParseException When the denominator does not match a known value.
	 */
	private static int getMultiplier(String string) throws ParseException
	{
		String suffix;
		Matcher matcher = SUFFIX_PATTERN.matcher(string);
		if (matcher.find())
		{
			suffix = matcher.group(1);
		}
		else
		{
			throw new ParseException(string + " does not resemble a properly formatted stack.", string.length() - 1);
		}

		if (!suffix.equals(""))
		{
			for (int i = 1; i < SUFFIXES.length; i++)
			{
				if (SUFFIXES[i].equals(suffix.toUpperCase()))
				{
					return (int) Math.pow(10, i * 3);
				}
			}

			throw new ParseException("Invalid Suffix: " + suffix, string.length() - 1);
		}
		else
		{
			return 1;
		}
	}
}
