/*
 * Copyright (c) 2020, Jordan <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.timersandbuffs;

import java.time.Instant;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ElapsedTimerTest
{
	@Test
	public void testGetText()
	{
		final Instant now = Instant.now();
		final Instant fiveSecondsAgo = now.minusSeconds(5);
		final Instant fiveMinutesAgo = now.minusSeconds(5 * 60);
		final Instant oneHourAgo = now.minusSeconds(60 * 60);
		final Instant fiveHoursAgo = now.minusSeconds(5 * 60 * 60);

		assertEquals("00:00", timerText(now, now));
		assertEquals("00:00", timerText(now, null));
		assertEquals("00:05", timerText(fiveSecondsAgo, now));
		assertEquals("00:05", timerText(fiveSecondsAgo, null));
		assertEquals("04:55", timerText(fiveMinutesAgo, fiveSecondsAgo));
		assertEquals("05:00", timerText(fiveMinutesAgo, now));
		assertEquals("05:00", timerText(fiveMinutesAgo, null));
		assertEquals("55:00", timerText(oneHourAgo, fiveMinutesAgo));
		assertEquals("59:55", timerText(oneHourAgo, fiveSecondsAgo));
		assertEquals("60:00", timerText(oneHourAgo, now));
		assertEquals("60:00", timerText(oneHourAgo, null));
		assertEquals("240:00", timerText(fiveHoursAgo, oneHourAgo));
		assertEquals("295:00", timerText(fiveHoursAgo, fiveMinutesAgo));
		assertEquals("299:55", timerText(fiveHoursAgo, fiveSecondsAgo));
		assertEquals("300:00", timerText(fiveHoursAgo, now));
		assertEquals("300:00", timerText(fiveHoursAgo, null));
	}

	private static String timerText(final Instant startTime, final Instant lastTime)
	{
		return new ElapsedTimer(null, null, startTime, lastTime).getText();
	}
}
