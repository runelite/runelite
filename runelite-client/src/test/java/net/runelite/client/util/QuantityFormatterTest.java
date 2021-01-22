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

import java.text.ParseException;
import java.util.Locale;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class QuantityFormatterTest
{
	@Before
	public void setUp()
	{
		Locale.setDefault(Locale.ENGLISH);
	}

	@Test
	public void quantityToPreciseSISize()
	{
		assertEquals("0", QuantityFormatter.quantityToPreciseSIStack(0));
		assertEquals("999", QuantityFormatter.quantityToPreciseSIStack(999));
		assertEquals("1000", QuantityFormatter.quantityToPreciseSIStack(1000));
		assertEquals("9450", QuantityFormatter.quantityToPreciseSIStack(9450));
		assertEquals("14.5K", QuantityFormatter.quantityToPreciseSIStack(14_500));
		assertEquals("99.9K", QuantityFormatter.quantityToPreciseSIStack(99_920));
		assertEquals("100K", QuantityFormatter.quantityToPreciseSIStack(100_000));
		assertEquals("10M", QuantityFormatter.quantityToPreciseSIStack(10_000_000));
		assertEquals("2.147B", QuantityFormatter.quantityToPreciseSIStack(Integer.MAX_VALUE));
		assertEquals("100B", QuantityFormatter.quantityToPreciseSIStack(100_000_000_000L));
	}

	@Test
	public void quantityToSIStackSize()
	{
		assertEquals("0", QuantityFormatter.quantityToSIStack(0));
		assertEquals("8500", QuantityFormatter.quantityToSIStack(8_500, 0));
		assertEquals("8500", QuantityFormatter.quantityToSIStack(8_500, 1));
		assertEquals("10K", QuantityFormatter.quantityToSIStack(10_000, 1));
		assertEquals("10K", QuantityFormatter.quantityToSIStack(10_000, 2));
		assertEquals("10.1K", QuantityFormatter.quantityToSIStack(10_100, 1));
		assertEquals("10.1K", QuantityFormatter.quantityToSIStack(10_100, 2));
		assertEquals("21.7K", QuantityFormatter.quantityToSIStack(21_700, 0));
		assertEquals("21.7K", QuantityFormatter.quantityToSIStack(21_700, 3));
		assertEquals("100K", QuantityFormatter.quantityToSIStack(100_000, 1));
		assertEquals("100.3K", QuantityFormatter.quantityToSIStack(100_310, 1));
		assertEquals("1M", QuantityFormatter.quantityToSIStack(1_000_000, 0));
		assertEquals("1M", QuantityFormatter.quantityToSIStack(1_000_000, 1));
		assertEquals("1M", QuantityFormatter.quantityToSIStack(1_000_000, 2));
		assertEquals("8.45M", QuantityFormatter.quantityToSIStack(8_450_000, 2));
		assertEquals("8.451M", QuantityFormatter.quantityToSIStack(8_451_000, 3));
		assertEquals("10M", QuantityFormatter.quantityToSIStack(10_000_000, 0));
		assertEquals("10M", QuantityFormatter.quantityToSIStack(10_000_000, 1));
		assertEquals("10M", QuantityFormatter.quantityToSIStack(10_000_000, 2));
		assertEquals("12.8M", QuantityFormatter.quantityToSIStack(12_800_000, 1));
		assertEquals("12.85M", QuantityFormatter.quantityToSIStack(12_850_000, 2));
		assertEquals("12.851M", QuantityFormatter.quantityToSIStack(12_851_000, 3));
		assertEquals("100M", QuantityFormatter.quantityToSIStack(100_000_000, 0));
		assertEquals("100M", QuantityFormatter.quantityToSIStack(100_000_000, 1));
		assertEquals("100M", QuantityFormatter.quantityToSIStack(100_000_000, 2));
		assertEquals("250.1M", QuantityFormatter.quantityToSIStack(250_100_000, 1));
		assertEquals("250.1M", QuantityFormatter.quantityToSIStack(250_100_000, 3));
		assertEquals("250.151M", QuantityFormatter.quantityToSIStack(250_151_000, 3));
		assertEquals("1B", QuantityFormatter.quantityToSIStack(1_000_000_000, 1));
		assertEquals("1.5B", QuantityFormatter.quantityToSIStack(1500_000_000, 1));
		assertEquals("1.5B", QuantityFormatter.quantityToSIStack(1500_000_000, 2));
		assertEquals("1.55B", QuantityFormatter.quantityToSIStack(1550_000_000, 2));
		assertEquals("1.55B", QuantityFormatter.quantityToSIStack(1550_000_000, 3));
		assertEquals("2.147B", QuantityFormatter.quantityToSIStack(Integer.MAX_VALUE, 3));
	}

	@Test
	public void quantityToRSStackSize()
	{
		assertEquals("0", QuantityFormatter.quantityToRSStack(0));
		assertEquals("1111", QuantityFormatter.quantityToRSStack(1111));
		assertEquals("101K", QuantityFormatter.quantityToRSStack(101_000));
		assertEquals("1011K", QuantityFormatter.quantityToRSStack(1_011_000));
		assertEquals("9999K", QuantityFormatter.quantityToRSStack(9_999_999));
		assertEquals("10M", QuantityFormatter.quantityToRSStack(10_000_000));
		assertEquals("100M", QuantityFormatter.quantityToRSStack(100_000_000));
		assertEquals("100M", QuantityFormatter.quantityToRSStack(100_111_111));
		assertEquals("2147M", QuantityFormatter.quantityToRSStack(Integer.MAX_VALUE));
	}

	@Test
	public void stackToQuantity() throws ParseException
	{
		assertEquals(0, QuantityFormatter.parseQuantity("0"));
		assertEquals(907, QuantityFormatter.parseQuantity("907"));
		assertEquals(1200, QuantityFormatter.parseQuantity("1200"));
		assertEquals(10_500, QuantityFormatter.parseQuantity("10,500"));
		assertEquals(10_500, QuantityFormatter.parseQuantity("10.5K"));
		assertEquals(33_560_000, QuantityFormatter.parseQuantity("33.56M"));
		assertEquals(2_000_000_000, QuantityFormatter.parseQuantity("2B"));

		try
		{
			QuantityFormatter.parseQuantity("0L");
			fail("Should have thrown an exception for invalid suffix.");
		}
		catch (ParseException ignore)
		{
		}

		try
		{
			QuantityFormatter.parseQuantity("badstack");
			fail("Should have thrown an exception for improperly formatted stack.");
		}
		catch (ParseException ignore)
		{
		}
	}
}
