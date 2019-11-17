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
	public void quantityToRSDecimalStackSize()
	{
		assertEquals("0", QuantityFormatter.quantityToRSDecimalStack(0));
		assertEquals("8500", QuantityFormatter.quantityToRSDecimalStack(8_500));
		assertEquals("10K", QuantityFormatter.quantityToRSDecimalStack(10_000));
		assertEquals("21.7K", QuantityFormatter.quantityToRSDecimalStack(21_700));
		assertEquals("100K", QuantityFormatter.quantityToRSDecimalStack(100_000));
		assertEquals("100.3K", QuantityFormatter.quantityToRSDecimalStack(100_300));
		assertEquals("1M", QuantityFormatter.quantityToRSDecimalStack(1_000_000));
		assertEquals("8.4M", QuantityFormatter.quantityToRSDecimalStack(8_450_000));
		assertEquals("10M", QuantityFormatter.quantityToRSDecimalStack(10_000_000));
		assertEquals("12.8M", QuantityFormatter.quantityToRSDecimalStack(12_800_000));
		assertEquals("100M", QuantityFormatter.quantityToRSDecimalStack(100_000_000));
		assertEquals("250.1M", QuantityFormatter.quantityToRSDecimalStack(250_100_000));
		assertEquals("1B", QuantityFormatter.quantityToRSDecimalStack(1_000_000_000));
		assertEquals("1.5B", QuantityFormatter.quantityToRSDecimalStack(1500_000_000));
		assertEquals("2.1B", QuantityFormatter.quantityToRSDecimalStack(Integer.MAX_VALUE));
	}

	@Test
	public void quantityToStackSize()
	{
		assertEquals("0", QuantityFormatter.quantityToStackSize(0));
		assertEquals("999", QuantityFormatter.quantityToStackSize(999));
		assertEquals("1,000", QuantityFormatter.quantityToStackSize(1000));
		assertEquals("9,450", QuantityFormatter.quantityToStackSize(9450));
		assertEquals("14.5K", QuantityFormatter.quantityToStackSize(14_500));
		assertEquals("99.9K", QuantityFormatter.quantityToStackSize(99_920));
		assertEquals("100K", QuantityFormatter.quantityToStackSize(100_000));
		assertEquals("10M", QuantityFormatter.quantityToStackSize(10_000_000));
		assertEquals("2.14B", QuantityFormatter.quantityToStackSize(Integer.MAX_VALUE));
		assertEquals("100B", QuantityFormatter.quantityToStackSize(100_000_000_000L));

		assertEquals("0", QuantityFormatter.quantityToStackSize(-0));
		assertEquals("-400", QuantityFormatter.quantityToStackSize(-400));
		assertEquals("-400K", QuantityFormatter.quantityToStackSize(-400_000));
		assertEquals("-40M", QuantityFormatter.quantityToStackSize(-40_000_000));
		assertEquals("-2.14B", QuantityFormatter.quantityToStackSize(Integer.MIN_VALUE));
		assertEquals("-400B", QuantityFormatter.quantityToStackSize(-400_000_000_000L));
	}

	@Test
	public void quantityToPreciseStackSize()
	{
		assertEquals("0", QuantityFormatter.quantityToRSDecimalStack(0));
		assertEquals("8500", QuantityFormatter.quantityToRSDecimalStack(8_500, true));
		assertEquals("10K", QuantityFormatter.quantityToRSDecimalStack(10_000, true));
		assertEquals("21.7K", QuantityFormatter.quantityToRSDecimalStack(21_710, true));
		assertEquals("100K", QuantityFormatter.quantityToRSDecimalStack(100_000, true));
		assertEquals("100.3K", QuantityFormatter.quantityToRSDecimalStack(100_310, true));
		assertEquals("1M", QuantityFormatter.quantityToRSDecimalStack(1_000_000, true));
		assertEquals("8.45M", QuantityFormatter.quantityToRSDecimalStack(8_450_000, true));
		assertEquals("8.451M", QuantityFormatter.quantityToRSDecimalStack(8_451_000, true));
		assertEquals("10M", QuantityFormatter.quantityToRSDecimalStack(10_000_000, true));
		assertEquals("12.8M", QuantityFormatter.quantityToRSDecimalStack(12_800_000, true));
		assertEquals("12.85M", QuantityFormatter.quantityToRSDecimalStack(12_850_000, true));
		assertEquals("12.851M", QuantityFormatter.quantityToRSDecimalStack(12_851_000, true));
		assertEquals("100M", QuantityFormatter.quantityToRSDecimalStack(100_000_000, true));
		assertEquals("250.1M", QuantityFormatter.quantityToRSDecimalStack(250_100_000, true));
		assertEquals("250.151M", QuantityFormatter.quantityToRSDecimalStack(250_151_000, true));
		assertEquals("1B", QuantityFormatter.quantityToRSDecimalStack(1_000_000_000, true));
		assertEquals("1.5B", QuantityFormatter.quantityToRSDecimalStack(1500_000_000, true));
		assertEquals("1.55B", QuantityFormatter.quantityToRSDecimalStack(1550_000_000, true));
		assertEquals("2.147B", QuantityFormatter.quantityToRSDecimalStack(Integer.MAX_VALUE, true));
	}

	@Test
	public void stackSizeToQuantity() throws ParseException
	{
		assertEquals(0, QuantityFormatter.parseQuantity("0"));
		assertEquals(907, QuantityFormatter.parseQuantity("907"));
		assertEquals(1200, QuantityFormatter.parseQuantity("1200"));
		assertEquals(10_500, QuantityFormatter.parseQuantity("10,500"));
		assertEquals(10_500, QuantityFormatter.parseQuantity("10.5K"));
		assertEquals(33_560_000, QuantityFormatter.parseQuantity("33.56M"));
		assertEquals(2_000_000_000, QuantityFormatter.parseQuantity("2B"));

		assertEquals(0, QuantityFormatter.parseQuantity("-0"));
		assertEquals(-400, QuantityFormatter.parseQuantity("-400"));
		assertEquals(-400_000, QuantityFormatter.parseQuantity("-400k"));
		assertEquals(-40_543_000, QuantityFormatter.parseQuantity("-40.543M"));

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
