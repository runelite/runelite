/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.cluescrolls;

import net.runelite.api.coords.WorldPoint;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class PrifddinasWorldPointConversionTest
{
	@Test
	public void testOverworldPoints()
	{
		// Brugsen Bursen, Grand Exchange
		final WorldPoint ge = new WorldPoint(3165, 3477, 0);
		WorldPoint converted = ClueScrollPlugin.convertLocation(ge);
		assertEquals(ge.distanceTo2D(converted), 0);

		// Entrance to Chambers of Xeric
		final WorldPoint raids = new WorldPoint(1234, 3572, 0);
		converted = ClueScrollPlugin.convertLocation(raids);
		assertEquals(raids.distanceTo2D(converted), 0);

		// The 4 corners around Prifddinas

		// Around the area of the Elite coordinate clue
		final WorldPoint sw = new WorldPoint(2185, 3280, 0);
		converted = ClueScrollPlugin.convertLocation(sw);
		assertEquals(sw.distanceTo2D(converted), 0);

		// The path south west of Gwenith, towards the cenotaph
		final WorldPoint nw = new WorldPoint(2183, 3384, 0);
		converted = ClueScrollPlugin.convertLocation(nw);
		assertEquals(nw.distanceTo2D(converted), 0);

		// Lenny's camp, by the chinchompa hunting spot
		final WorldPoint ne = new WorldPoint(2302, 3380, 0);
		converted = ClueScrollPlugin.convertLocation(ne);
		assertEquals(ne.distanceTo2D(converted), 0);

		// East of the southern entrance to Prif
		final WorldPoint se = new WorldPoint(2290, 3275, 0);
		converted = ClueScrollPlugin.convertLocation(se);
		assertEquals(se.distanceTo2D(converted), 0);

		// North of the southern entrance, in the overworld
		final WorldPoint inside = new WorldPoint(2240, 3280, 0);
		converted = ClueScrollPlugin.convertLocation(inside);
		assertNotEquals(inside.distanceTo2D(converted), 0);
	}

	@Test
	public void testRealPrifPoints()
	{
		// Zalcano's entrance portal
		final WorldPoint point = new WorldPoint(3282, 6058, 0);
		final WorldPoint converted = ClueScrollPlugin.convertLocation(point);
		assertNotEquals(point.distanceTo2D(converted), 0);

		// Elven Crystal Chest, which is upstairs
		final WorldPoint initial = new WorldPoint(3273, 6082, 2);
		final WorldPoint post = ClueScrollPlugin.convertLocation(initial);
		assertNotEquals(initial.distanceTo2D(post), 0);
	}
}
