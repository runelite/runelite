/*
 * Copyright (c) 2018, arlyon <https://github.com/arlyon>
 * Copyright (c) 2020, winterdaze <https://github.com/winterdaze>
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
 * A set of utility functions to use when formatting quantities
 */
public class QuantityFormatter
{
	/**
	 * A list of suffixes to use when formatting stack sizes.
	 */
	private static final String[] SUFFIXES = {"", "K", "M", "B"};

	/**
	 * A pattern to match a value suffix (K, M etc) in a string.
	 */
	private static final Pattern SUFFIX_PATTERN = Pattern.compile("^-?[0-9,.]+([a-zA-Z]?)$");

	private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance(Locale.ENGLISH);

	/**
	 * Converts a quantity to a short SI-prefix style string,
	 * with at most thousandth place decimal precision for numbers greater than 1 million
	 * and at most tenth place decimal precision otherwise,
	 * with K after 10_000, M after 1_000_000, and B after 1_000_000_000.
	 *
	 * <br>Example:
	 * <br>{@code 9450 -> 9450}
	 * <br>{@code 100_100 -> 100.1K}
	 * <br>{@code 2_147_000_000 -> 2.147B}
	 *
	 * @see #quantityToSIStack(long, int)
	 */
	public static synchronized String quantityToPreciseSIStack(long quantity)
	{
		return quantityToSIStack(quantity, 3);
	}

	/**
	 * Converts a quantity to a short SI-prefix style string, with at most tenth place decimal precision for all numbers,
	 * with K after 10_000, M after 1_000_000, and B after 1_000_000_000.
	 * 
	 * <br>Example:
	 * <br>{@code 9450 -> 9450}
	 * <br>{@code 99_999 -> 99.9K}
	 * <br>{@code 8_411_000 -> 8.4M}
	 * <br>{@code 2_147_000_000 -> 2.1B}
	 * 
	 * @see #quantityToSIStack(long, int)
	 */
	public static String quantityToSIStack(long quantity)
	{
		return quantityToSIStack(quantity, 1);
	}

	/**
	 * Converts a quantity to a short SI-prefix style string, with decimal precision specified by numDecimalPlaces,
	 * with K after 10_000, M after 1_000_000, and B after 1_000_000_000.
	 *
	 * <br>Example with {@code numDecimalPlaces = 0}:
	 * <br>{@code 9450 -> 9450}
	 * <br>{@code 99_999 -> 99.9K}
	 * <br>{@code 8_400_000 -> 8M}
	 * <br>{@code 2_100_000_000 -> 2B}
	 *
	 * <br><br>Example with {@code numDecimalPlaces = 1}:
	 * <br>{@code 9450 -> 9450}
	 * <br>{@code 99_999 -> 99.9K}
	 * <br>{@code 8_411_000 -> 8.4M}
	 * <br>{@code 2_147_000_000 -> 2.1B}
	 *
	 * <br><br>Example with {@code numDecimalPlaces = 3}:
	 * <br>{@code 9450 -> 9450}
	 * <br>{@code 99_999 -> 99.9K}
	 * <br>{@code 811_000 -> 811K}
	 * <br>{@code 811_111 -> 811.1K}
	 * <br>{@code 8_411_000 -> 8.411M}
	 * <br>{@code 2_147_000_000 -> 2.147B}
	 *
	 * @param numDecimalPlaces Number of decimal places (0-3) to include for numbers greater than 1 million. Otherwise have at most a single decimal.
	 * <br>Example: 0 for no decimals, 1  for tenth place precision, 2 for hundredth, etc.
	 */
	public static synchronized String quantityToSIStack(long quantity, int numDecimalPlaces)
	{
		String quantityStr = String.valueOf(quantity);
		if (quantityStr.length() <= 4)
		{
			return quantityStr;
		}

		int power = (int) Math.log10(quantity);

		NumberFormat format;
		if (power >= 6)
		{
			switch (numDecimalPlaces)
			{
				case 0:
					format = new DecimalFormat("#,###", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
					break;
				case 1:
					format = new DecimalFormat("#,###.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
					break;
				case 2:
					format = new DecimalFormat("#,###.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
					break;
				case 3:
					format = new DecimalFormat("#,###.###", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
					break;
				default:
					throw new IllegalArgumentException("numDecimalPlaces must be between 0 and 3");
			}
		}
		else
		{
			format = new DecimalFormat("#,###.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		}

		return format.format(quantity / (Math.pow(10, (power / 3) * 3))) + SUFFIXES[power / 3];
	}

	/**
	 * Converts a quantity to the RS representation of it (no decimal precision).
	 *
	 * <br>Example:
	 * <br>{@code 10_000 -> 10_000}
	 * <br>{@code 100_000 -> 100K}
	 * <br>{@code 1_000_000 -> 1000K} (instead of 1M)
	 * <br>{@code 2_147_483_647 -> 2147M} (instead of 2.147B)
	 *
	 * @param quantity The value to convert.
	 * @return A RS string representation of it.
	 */
	public static String quantityToRSStack(long quantity)
	{
		if (quantity >= 10_000_000)
		{
			return Long.toString(quantity / 1_000_000) + 'M';
		}
		else if (quantity >= 100_000)
		{
			return Long.toString(quantity / 1_000) + 'K';
		}
		return Long.toString(quantity);
	}

	/**
	 * Converts a string representation of a stack (with "", "K", "M", or "B" suffixes)
	 * back to its long value.
	 *
	 * @param string The string of the stack to convert.
	 * @return A long representation of it.
	 */
	public static synchronized long parseQuantity(String string) throws ParseException
	{
		int multiplier = getMultiplier(string);
		double parsedValue = NUMBER_FORMATTER.parse(string).doubleValue();
		return (long) (parsedValue * multiplier);
	}

	/**
	 * Formats a number to be comma delimited. No suffixes are given.
	 *
	 * <br>Example:
	 * <br>{@code 10_123_351 -> 10,123,351}
	 * <br>{@code 5 -> 5}
	 */
	public static synchronized String formatNumber(final long number)
	{
		return NUMBER_FORMATTER.format(number);
	}


	/**
	 * Formats a number to be comma delimited. No suffixes are given. Has at
	 * most 3 decimal places.
	 *
	 * <br>Example:
	 * <br>{@code 10_123_351 -> 10,123,351}
	 * <br>{@code 1005.612 -> 1,005.612}
	 */
	public static synchronized String formatNumber(double number)
	{
		return NUMBER_FORMATTER.format(number);
	}

	/**
	 * Calculates, given a string with a value suffix ("", "K", "M", "B"),
	 * the multiplier that the denominator represents (ex. 1000 for "K", 1 if no suffix).
	 *
	 * @param string The string to check.
	 * @return The multiplier value of the value suffix.
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
