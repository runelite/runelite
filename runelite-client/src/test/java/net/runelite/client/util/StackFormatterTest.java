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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class StackFormatterTest
{

	@Test
	public void quantityToRSStackSize()
	{
		assertEquals("0", StackFormatter.quantityToRSStackSize(0));
		assertEquals("99999", StackFormatter.quantityToRSStackSize(99_999));
		assertEquals("100K", StackFormatter.quantityToRSStackSize(100_000));
		assertEquals("10M", StackFormatter.quantityToRSStackSize(10_000_000));
		assertEquals("2147M", StackFormatter.quantityToRSStackSize(Integer.MAX_VALUE));

		assertEquals("0", StackFormatter.quantityToRSStackSize(-0));
		assertEquals("-400", StackFormatter.quantityToRSStackSize(-400));
		assertEquals("-400K", StackFormatter.quantityToRSStackSize(-400_000));
		assertEquals("-40M", StackFormatter.quantityToRSStackSize(-40_000_000));
		assertEquals("-2147M", StackFormatter.quantityToRSStackSize(Integer.MIN_VALUE));
	}

	@Test
	public void quantityToStackSize()
	{
		assertEquals("0", StackFormatter.quantityToStackSize(0));
		assertEquals("999", StackFormatter.quantityToStackSize(999));
		assertEquals(NumberFormat.getIntegerInstance().format(1000), StackFormatter.quantityToStackSize(1000));
		assertEquals(NumberFormat.getIntegerInstance().format(9450), StackFormatter.quantityToStackSize(9450));
		assertEquals(NumberFormat.getNumberInstance().format(14.5) + "K", StackFormatter.quantityToStackSize(14_500));
		assertEquals(NumberFormat.getNumberInstance().format(99.9) + "K", StackFormatter.quantityToStackSize(99_920));
		assertEquals("100K", StackFormatter.quantityToStackSize(100_000));
		assertEquals("10M", StackFormatter.quantityToStackSize(10_000_000));
		assertEquals(NumberFormat.getNumberInstance().format(2.14) + "B", StackFormatter.quantityToStackSize(Integer.MAX_VALUE));
		assertEquals("100B", StackFormatter.quantityToStackSize(100_000_000_000L));

		assertEquals("0", StackFormatter.quantityToStackSize(-0));
		assertEquals("-400", StackFormatter.quantityToStackSize(-400));
		assertEquals("-400K", StackFormatter.quantityToStackSize(-400_000));
		assertEquals("-40M", StackFormatter.quantityToStackSize(-40_000_000));
		assertEquals(NumberFormat.getNumberInstance().format(-2.14) + "B", StackFormatter.quantityToStackSize(Integer.MIN_VALUE));
		assertEquals("-400B", StackFormatter.quantityToStackSize(-400_000_000_000L));
	}

	@Test
	public void stackSizeToQuantity() throws ParseException
	{
		assertEquals(0, StackFormatter.stackSizeToQuantity("0"));
		assertEquals(907, StackFormatter.stackSizeToQuantity("907"));
		assertEquals(1200, StackFormatter.stackSizeToQuantity("1200"));
		assertEquals(10_500, StackFormatter.stackSizeToQuantity(NumberFormat.getNumberInstance().format(10_500)));
		assertEquals(10_500, StackFormatter.stackSizeToQuantity(NumberFormat.getNumberInstance().format(10.5) + "K"));
		assertEquals(33_560_000, StackFormatter.stackSizeToQuantity(NumberFormat.getNumberInstance().format(33.56) + "M"));
		assertEquals(2_000_000_000, StackFormatter.stackSizeToQuantity("2B"));

		assertEquals(0, StackFormatter.stackSizeToQuantity("-0"));
		assertEquals(-400, StackFormatter.stackSizeToQuantity("-400"));
		assertEquals(-400_000, StackFormatter.stackSizeToQuantity("-400k"));
		assertEquals(-40_543_000, StackFormatter.stackSizeToQuantity(NumberFormat.getNumberInstance().format(-40.543) + "M"));

		try
		{
			StackFormatter.stackSizeToQuantity("0L");
			fail("Should have thrown an exception for invalid suffix.");
		}
		catch (ParseException ignore)
		{
		}

		try
		{
			StackFormatter.stackSizeToQuantity("badstack");
			fail("Should have thrown an exception for improperly formatted stack.");
		}
		catch (ParseException ignore)
		{
		}
	}
}
