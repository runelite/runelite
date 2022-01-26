/*
 * Copyright (c) 2018, Jamy C <https://github.com/jamyc>
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
package net.runelite.client.plugins.timetracking.clocks;

import java.time.format.DateTimeParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ClockPanelTest
{
	@Test
	public void properColonSeparatedTimeStringShouldReturnCorrectSeconds()
	{
		assertEquals(5, ClockPanel.stringToSeconds("5"));
		assertEquals(50, ClockPanel.stringToSeconds("50"));
		assertEquals(120, ClockPanel.stringToSeconds("2:00"));
		assertEquals(120, ClockPanel.stringToSeconds("0:120"));
		assertEquals(120, ClockPanel.stringToSeconds("0:0:120"));
		assertEquals(1200, ClockPanel.stringToSeconds("20:00"));

		assertEquals(50, ClockPanel.stringToSeconds("00:00:50"));
		assertEquals(121, ClockPanel.stringToSeconds("00:02:01"));
		assertEquals(3660, ClockPanel.stringToSeconds("01:01:00"));
		assertEquals(9000, ClockPanel.stringToSeconds("2:30:00"));
		assertEquals(9033, ClockPanel.stringToSeconds("02:30:33"));
		assertEquals(82800, ClockPanel.stringToSeconds("23:00:00"));
		assertEquals(400271, ClockPanel.stringToSeconds("111:11:11"));
	}

	@Test
	public void properIntuitiveTimeStringShouldReturnCorrectSeconds()
	{
		assertEquals(5, ClockPanel.stringToSeconds("5s"));
		assertEquals(50, ClockPanel.stringToSeconds("50s"));
		assertEquals(120, ClockPanel.stringToSeconds("2m"));
		assertEquals(120, ClockPanel.stringToSeconds("120s"));
		assertEquals(1200, ClockPanel.stringToSeconds("20m"));

		assertEquals(121, ClockPanel.stringToSeconds("2m1s"));
		assertEquals(121, ClockPanel.stringToSeconds("2m     1s"));
		assertEquals(3660, ClockPanel.stringToSeconds("1h 1m"));
		assertEquals(3660, ClockPanel.stringToSeconds("61m"));
		assertEquals(3660, ClockPanel.stringToSeconds("3660s"));
		assertEquals(9000, ClockPanel.stringToSeconds("2h 30m"));
		assertEquals(9033, ClockPanel.stringToSeconds("2h 30m 33s"));
		assertEquals(82800, ClockPanel.stringToSeconds("23h"));
		assertEquals(400271, ClockPanel.stringToSeconds("111h 11m 11s"));
	}

	@Test
	public void incorrectTimeStringShouldThrowException()
	{
		Class numberEx = NumberFormatException.class;
		Class dateTimeEx = DateTimeParseException.class;

		tryFail("a", numberEx);
		tryFail("abc", numberEx);
		tryFail("aa:bb:cc", numberEx);
		tryFail("01:12=", numberEx);

		tryFail("s", dateTimeEx);
		tryFail("1s 1m", dateTimeEx);
		tryFail("20m:10s", dateTimeEx);
		tryFail("20hh10m10s", dateTimeEx);
	}

	private void tryFail(String input, Class<?> expectedException)
	{
		try
		{
			ClockPanel.stringToSeconds(input);
			fail("Should have thrown " + expectedException.getSimpleName());
		}
		catch (Exception exception)
		{
			assertEquals(expectedException, exception.getClass());
		}
	}
}
