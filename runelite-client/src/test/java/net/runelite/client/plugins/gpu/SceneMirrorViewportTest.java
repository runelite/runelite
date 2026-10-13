/*
 * Copyright (c) 2026, RuneLite scene mirror prototype contributors
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
package net.runelite.client.plugins.gpu;

import net.runelite.client.game.SceneMirrorViewport;
import org.junit.Test;
import static org.junit.Assert.*;

public class SceneMirrorViewportTest
{
	@Test
	public void reflectsOnlyOffsetViewport()
	{
		SceneMirrorViewport v = SceneMirrorViewport.capture(10, 20, 100, 80, 300, 200);
		assertEquals(110, v.sourceX0);
		assertEquals(10, v.sourceX1);
		assertEquals(10, v.destinationX0);
		assertEquals(110, v.destinationX1);
		assertEquals(20, v.y0);
		assertEquals(100, v.y1);
	}

	@Test
	public void clipsPaddingWithoutMovingReflectionAxis()
	{
		// Original axis is x=-2..10, hence x0+x1=8, not framebuffer center=10.
		SceneMirrorViewport v = SceneMirrorViewport.capture(-2, -1, 12, 7, 10, 5);
		assertEquals(8, v.sourceX0);
		assertEquals(0, v.sourceX1);
		assertEquals(0, v.destinationX0);
		assertEquals(8, v.destinationX1);
		assertEquals(0, v.y0);
		assertEquals(5, v.y1);
	}

	@Test
	public void supportsSymmetricStretchedPadding()
	{
		SceneMirrorViewport v = SceneMirrorViewport.capture(-1, -1, 602, 402, 600, 400);
		assertEquals(600, v.sourceX0);
		assertEquals(0, v.sourceX1);
		assertEquals(0, v.destinationX0);
		assertEquals(600, v.destinationX1);
	}

	@Test
	public void preservesOddWidthAndOnePixel()
	{
		SceneMirrorViewport odd = SceneMirrorViewport.capture(4, 8, 511, 334, 800, 500);
		assertEquals(515, odd.sourceX0);
		assertEquals(4, odd.sourceX1);
		SceneMirrorViewport one = SceneMirrorViewport.capture(4, 8, 1, 1, 10, 10);
		assertEquals(5, one.sourceX0);
		assertEquals(4, one.sourceX1);
	}

	@Test
	public void refusesInvalidOrUnpairedBounds()
	{
		assertNull(SceneMirrorViewport.capture(0, 0, 0, 10, 20, 20));
		assertNull(SceneMirrorViewport.capture(0, 0, 10, 10, 0, 20));
		assertNull(SceneMirrorViewport.capture(50, 0, 10, 10, 20, 20));
		assertNull(SceneMirrorViewport.capture(0, 50, 10, 10, 20, 20));
	}

	@Test
	public void resolveDoesNotScaleAndStaysWithinFramebuffer()
	{
		for (int width : new int[]{1, 511, 512, 765, 1001})
		{
			SceneMirrorViewport v = SceneMirrorViewport.capture(4, 8, width, 334, width + 200, 500);
			assertEquals(v.sourceX0 - v.sourceX1, v.destinationX1 - v.destinationX0);
			assertTrue(v.sourceX0 <= v.framebufferWidth);
			assertTrue(v.sourceX1 >= 0);
			assertTrue(v.y0 >= 0 && v.y1 <= v.framebufferHeight);
		}
	}
}
