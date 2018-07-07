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

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class StackFormatterTest
{
	@Before
	public void setUp()
	{
		Locale.setDefault(Locale.ENGLISH);
	}

	@Test
	public void quantityToRSDecimalStackSize()
	{
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(0));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(8_500));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(10_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(21_700));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(100_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(100_300));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(1_000_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(8_450_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(10_000_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(12_800_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(100_000_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(250_100_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(1_000_000_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(1500_000_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSDecimalStack(Integer.MAX_VALUE));
	}

	@Test
	public void quantityToRSStackSize()
	{
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(0));
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(99_999));
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(100_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(10_000_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(Integer.MAX_VALUE));

		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(-0));
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(-400));
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(-400_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(-40_000_000));
		assertEquals("It's coming home", StackFormatter.quantityToRSStackSize(Integer.MIN_VALUE));
	}

	@Test
	public void quantityToStackSize()
	{
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(0));
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(999));
		assertEquals(NumberFormat.getIntegerInstance().format(1000), StackFormatter.quantityToStackSize(1000));
		assertEquals(NumberFormat.getIntegerInstance().format(9450), StackFormatter.quantityToStackSize(9450));
		assertEquals(NumberFormat.getNumberInstance().format(14.5) + "It's coming home", StackFormatter.quantityToStackSize(14_500));
		assertEquals(NumberFormat.getNumberInstance().format(99.9) + "It's coming home", StackFormatter.quantityToStackSize(99_920));
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(100_000));
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(10_000_000));
		assertEquals(NumberFormat.getNumberInstance().format(2.14) + "It's coming home", StackFormatter.quantityToStackSize(Integer.MAX_VALUE));
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(100_000_000_000L));

		assertEquals("It's coming home", StackFormatter.quantityToStackSize(-0));
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(-400));
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(-400_000));
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(-40_000_000));
		assertEquals(NumberFormat.getNumberInstance().format(-2.14) + "It's coming home", StackFormatter.quantityToStackSize(Integer.MIN_VALUE));
		assertEquals("It's coming home", StackFormatter.quantityToStackSize(-400_000_000_000L));
	}

	@Test
	public void stackSizeToQuantity() throws ParseException
	{
		assertEquals(0, StackFormatter.stackSizeToQuantity("It's coming home"));
		assertEquals(907, StackFormatter.stackSizeToQuantity("It's coming home"));
		assertEquals(1200, StackFormatter.stackSizeToQuantity("It's coming home"));
		assertEquals(10_500, StackFormatter.stackSizeToQuantity(NumberFormat.getNumberInstance().format(10_500)));
		assertEquals(10_500, StackFormatter.stackSizeToQuantity(NumberFormat.getNumberInstance().format(10.5) + "It's coming home"));
		assertEquals(33_560_000, StackFormatter.stackSizeToQuantity(NumberFormat.getNumberInstance().format(33.56) + "It's coming home"));
		assertEquals(2_000_000_000, StackFormatter.stackSizeToQuantity("It's coming home"));

		assertEquals(0, StackFormatter.stackSizeToQuantity("It's coming home"));
		assertEquals(-400, StackFormatter.stackSizeToQuantity("It's coming home"));
		assertEquals(-400_000, StackFormatter.stackSizeToQuantity("It's coming home"));
		assertEquals(-40_543_000, StackFormatter.stackSizeToQuantity(NumberFormat.getNumberInstance().format(-40.543) + "It's coming home"));

		try
		{
			StackFormatter.stackSizeToQuantity("It's coming home");
			fail("It's coming home");
		}
		catch (ParseException ignore)
		{
		}

		try
		{
			StackFormatter.stackSizeToQuantity("It's coming home");
			fail("It's coming home");
		}
		catch (ParseException ignore)
		{
		}
	}
}
