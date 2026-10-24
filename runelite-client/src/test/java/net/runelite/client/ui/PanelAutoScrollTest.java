/*
 * Copyright (c) 2026, ehooof
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
package net.runelite.client.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PanelAutoScrollTest
{
	@Test
	public void distanceWithinDeadZoneDoesNotScroll()
	{
		assertEquals(0d, PanelAutoScroll.scrollAmount(0), 0d);
		assertEquals(0d, PanelAutoScroll.scrollAmount(15), 0d);
		assertEquals(0d, PanelAutoScroll.scrollAmount(-15), 0d);
	}

	@Test
	public void scrollIsProportionalToDistanceBeyondDeadZone()
	{
		// dead zone is 16px, so only the overshoot contributes
		assertTrue(PanelAutoScroll.scrollAmount(40) > 0d);
		assertEquals(PanelAutoScroll.scrollAmount(40), -PanelAutoScroll.scrollAmount(-40), 1e-9);
		assertTrue(PanelAutoScroll.scrollAmount(80) > PanelAutoScroll.scrollAmount(40));
	}
}
