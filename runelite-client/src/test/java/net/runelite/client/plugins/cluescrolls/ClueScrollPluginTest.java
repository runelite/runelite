/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2019 Adam <Adam@sigterm.info>
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

public class ClueScrollPluginTest
{
	@Test
	public void getGetMirrorPoint()
	{
		WorldPoint point, converted;

		// Zalcano's entrance portal
		point = new WorldPoint(3282, 6058, 0);
		converted = ClueScrollPlugin.getMirrorPoint(point, true);
		assertNotEquals(point, converted);

		// Elven Crystal Chest, which is upstairs
		point = new WorldPoint(3273, 6082, 2);
		converted = ClueScrollPlugin.getMirrorPoint(point, true);
		assertNotEquals(point, converted);

		// Around the area of the Elite coordinate clue
		point = new WorldPoint(2185, 3280, 0);
		// To overworld
		converted = ClueScrollPlugin.getMirrorPoint(point, true);
		assertEquals(point, converted);
		// To real
		converted = ClueScrollPlugin.getMirrorPoint(point, false);
		assertNotEquals(point, converted);

		// Brugsen Bursen, Grand Exchange
		point = new WorldPoint(3165, 3477, 0);
		converted = ClueScrollPlugin.getMirrorPoint(point, false);
		assertEquals(point, converted);
	}
}