/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import org.junit.Assert;
import org.junit.Test;

public class VarbitsTest
{
	@Test
	public void testGet()
	{
		//              28   24   20   16   12    8    4    0
		int value = 0b1101_1110_1010_1101_1011_1110_1110_1111;

		// Bit indexes are inclusive
		// Small pouch is bits 0-2
		// Medium pouch is bits 3-8
		// Large pouch is bits 9-17
		// Giant pouch is bits 18-29
		Varbits small = Varbits.POUCH_SMALL;
		Varbits med = Varbits.POUCH_MEDIUM;
		Varbits large = Varbits.POUCH_LARGE;
		Varbits giant = Varbits.POUCH_GIANT;

		Assert.assertEquals(7, small.get(value));
		Assert.assertEquals(29, med.get(value));
		Assert.assertEquals(223, large.get(value));
		Assert.assertEquals(1963, giant.get(value));
	}

	@Test
	public void testSet()
	{
		//              28   24   20   16   12    8    4    0
		int value = 0b1101_1110_1010_1101_1011_1110_1110_1111;
		int mask = 0b0000_0000_0000_0011_1111_1110_0000_0000; // mask for large pouch

		Varbits large = Varbits.POUCH_LARGE;

		int newValue = large.set(value, 42);
		int expect = (value & ~mask) | (42 << large.getLeastSignificantBit());
		Assert.assertEquals(expect, newValue);
	}
}
