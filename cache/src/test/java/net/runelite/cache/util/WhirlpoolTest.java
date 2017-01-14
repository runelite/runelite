/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache.util;

import net.runelite.cache.util.Whirlpool;
import org.junit.Assert;
import org.junit.Test;

public class WhirlpoolTest
{
	private static final byte[] result =
	{
		92, -33, 60, 4, -28, 24, 54, -39,
		-11, -85, -123, -74, 6, -107, 32, 36,
		108, 104, -82, 108, 36, -53, -95, 123,
		-84, -86, -13, 107, -110, 27, 35, -78,
		-60, -122, 36, 56, 86, 73, -9, -70,
		-35, 58, -43, 82, -36, -53, -107, -9,
		-21, 6, -43, 14, 109, -26, -115, 67,
		64, 116, 107, 18, 12, 46, -64, 63
	};

	@Test
	public void testGetHash()
	{
		byte[] data = "runelite".getBytes();
		byte[] out = Whirlpool.getHash(data, data.length);

		Assert.assertArrayEquals(out, result);
	}

}
