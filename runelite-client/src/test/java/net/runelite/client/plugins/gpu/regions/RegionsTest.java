/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.gpu.regions;

import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.*;
import org.junit.Test;

@Slf4j
public class RegionsTest
{
	@Test
	public void test() throws IOException
	{
		long start;
		Regions regions;
		try (InputStream in = Regions.class.getResourceAsStream("regions.txt"))
		{
			start = System.nanoTime();
			regions = new Regions(in, "regions.txt");
		}
		log.info("Parse took {}ms", (System.nanoTime() - start) / 1_000_000);

		// check areas don't intersect
		for (Region r1 : regions.getRegions())
		{
			for (Region r2 : regions.getRegions())
			{
				if (r1 == r2)
				{
					continue;
				}
				if (intersects(r1, r2))
				{
					fail("regions intersect");
				}
			}
		}

		assertEquals(0, regions.getRegionId(50 * 8, 50 * 8)); // Lumbridge
		assertNotEquals(0, regions.getRegionId(2416 / 8, 4448 / 8)); // Zanaris
	}

	private static boolean intersects(Region r1, Region r2)
	{
		return r1.cx1 <= r2.cx2 && r1.cx2 >= r2.cx1 &&
			r1.cy1 <= r2.cy2 && r1.cy2 >= r2.cy1;
	}
}