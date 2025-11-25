/*
 * Copyright (c) 2024, Jordan Atwood <nightfirecat@nightfirec.at>
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
package net.runelite.client.plugins.skillcalculator;

import static net.runelite.client.plugins.skillcalculator.SkillCalculator.formatBonusPercentage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SkillCalculatorTest
{
	@Test
	public void testFormatBonusPercentage()
	{
		assertEquals("33.33", formatBonusPercentage(0.33333333f));
		assertEquals("50", formatBonusPercentage(0.5f));
		assertEquals("102.5", formatBonusPercentage(1.025f));
		assertEquals("105", formatBonusPercentage(1.05f));
		assertEquals("110", formatBonusPercentage(1.1f));
		assertEquals("115", formatBonusPercentage(1.15f));
		assertEquals("120", formatBonusPercentage(1.2f));
		assertEquals("150", formatBonusPercentage(1.5f));
		assertEquals("250", formatBonusPercentage(2.5f));
		assertEquals("300", formatBonusPercentage(3f));
		assertEquals("350", formatBonusPercentage(3.5f));
		assertEquals("400", formatBonusPercentage(4f));
		assertEquals("700", formatBonusPercentage(7f));
	}
}
