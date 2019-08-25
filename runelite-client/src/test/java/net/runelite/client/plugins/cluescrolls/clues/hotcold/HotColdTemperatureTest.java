/*
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.cluescrolls.clues.hotcold;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class HotColdTemperatureTest
{
	private static final String[] VALID_MESSAGES = {
		"The device is warm, and warmer than last time.",
		"The device is visibly shaking and burns to the touch. This must be the spot.",
		"The device is cold.",
		"The device is ice cold.",
		"The device is very cold.",
		"The device is hot.",
		"The device is incredibly hot.",
	};
	private static final String[] INVALID_MESSAGES = {
		"The device is an octopus, and is wetter than last time.",
		"foobar",
		"a q p w",
		"My feet are cold, I should put them in some lukewarm water, or run hot water over them.",
	};

	@Test
	public void testValidTemperatureMessages()
	{
		for (final String message : VALID_MESSAGES)
		{
			assertNotNull(message, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.BEGINNER_HOT_COLD_TEMPERATURES, message));
			assertNotNull(message, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES, message));
		}
	}

	@Test
	public void testInvalidTemperatureMessages()
	{
		for (final String message : INVALID_MESSAGES)
		{
			assertNull(message, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.BEGINNER_HOT_COLD_TEMPERATURES, message));
			assertNull(message, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES, message));
		}
	}

	@Test
	public void testAmbiguousTemperatureMessages()
	{
		assertEquals(HotColdTemperature.ICE_COLD, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES, "The device is ice cold."));
		assertEquals(HotColdTemperature.VERY_COLD, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES, "The device is very cold."));
		assertEquals(HotColdTemperature.VERY_HOT, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES, "The device is very hot."));
		assertEquals(HotColdTemperature.COLD, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.BEGINNER_HOT_COLD_TEMPERATURES, "The device is cold, and warmer than last time."));
		assertEquals(HotColdTemperature.WARM, HotColdTemperature.getFromTemperatureSet(HotColdTemperature.BEGINNER_HOT_COLD_TEMPERATURES, "The device is warm, but colder than last time."));
	}
}