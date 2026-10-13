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

import net.runelite.api.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SceneMirrorPickingTest
{
	@Before
	public void resetBefore()
	{
		SceneMirrorPicking.clear();
	}

	@After
	public void resetAfter()
	{
		SceneMirrorPicking.clear();
	}

	@Test
	public void mirrorsNativeRelativePixelsAboutOffsetViewport()
	{
		SceneMirrorPicking.Frame frame = standardFrame();
		assertEquals(79, frame.mapX(20, 30));
		assertEquals(20, frame.mapX(79, 30));
		assertEquals(99, frame.mapX(0, 0));
		assertEquals(0, frame.mapX(99, 79));
	}

	@Test
	public void oddViewportKeepsItsCenterPixel()
	{
		SceneMirrorPicking.Frame frame = new SceneMirrorPicking.Frame(2, 1, 5, 5,
			2, 5, 1, 1, SceneMirrorViewport.capture(2, 2, 5, 5, 12, 8));
		assertEquals(4, frame.mapX(0, 0));
		assertEquals(2, frame.mapX(2, 2));
		assertEquals(0, frame.mapX(4, 4));
	}

	@Test
	public void onePixelViewportMapsToItself()
	{
		SceneMirrorPicking.Frame frame = new SceneMirrorPicking.Frame(4, 8, 1, 1,
			4, 1, 1, 1, SceneMirrorViewport.capture(4, 1, 1, 1, 10, 10));
		assertEquals(0, frame.mapX(0, 0));
	}

	@Test
	public void nativeOutsideCoordinatesRemainUnchanged()
	{
		SceneMirrorPicking.Frame frame = standardFrame();
		assertEquals(-1, frame.mapX(-1, 30));
		assertEquals(100, frame.mapX(100, 30));
		assertEquals(20, frame.mapX(20, -1));
		assertEquals(20, frame.mapX(20, 80));
		assertEquals(Integer.MIN_VALUE, frame.mapX(Integer.MIN_VALUE, 30));
	}

	@Test
	public void physicalViewportRoundingControlsFractionalInverse()
	{
		SceneMirrorPicking.Frame frame = fractionalFrame();
		// Physical viewport is [11,138), axis 149, not logical [10,110).
		// Logical event x=30 centers at 38.125 physical; inverse native x is 78.6417.
		assertEquals(78, frame.mapX(20, 30));
		assertEquals(98, frame.mapX(0, 30));
		assertEquals(0, frame.mapX(99, 30));
	}

	@Test
	public void displayedFractionalPixelRecoversOriginalNativeTarget()
	{
		SceneMirrorPicking.Frame frame = fractionalFrame();
		// Native center 20.5 renders at 37.035, then reflects to 111.965 physical.
		// This is logical canvas event x=89, hence viewport-relative input x=79.
		assertEquals(20, frame.mapX(79, 30));
		// Native center 78.5 renders at 110.695 and reflects to 38.305 physical.
		// This is logical canvas event x=30, hence viewport-relative input x=20.
		assertEquals(78, frame.mapX(20, 30));
	}

	@Test
	public void consistentDpiScalingDoesNotChangeNativeTarget()
	{
		SceneMirrorPicking.Frame doubled = new SceneMirrorPicking.Frame(10, 20, 100, 80,
			22, 254, 2.5, 3, SceneMirrorViewport.capture(22, 300, 254, 240, 800, 600));
		assertEquals(78, doubled.mapX(20, 30));
		assertEquals(20, doubled.mapX(79, 30));
		assertEquals(98, doubled.mapX(0, 0));
		assertEquals(0, doubled.mapX(99, 79));
	}

	@Test
	public void asymmetricPaddingUsesOriginalAxisAndPairedClip()
	{
		SceneMirrorPicking.Frame frame = new SceneMirrorPicking.Frame(0, 0, 10, 5,
			-2, 12, 1, 1, SceneMirrorViewport.capture(-2, 0, 12, 5, 10, 5));
		// Only displayed columns [0,8) have both sides of their reflected pair.
		assertEquals(7, frame.mapX(0, 2));
		assertEquals(2, frame.mapX(7, 2));
		assertEquals(8, frame.mapX(8, 2));
		assertEquals(9, frame.mapX(9, 2));
	}

	@Test
	public void physicalUpperClipBoundaryIsExcluded()
	{
		SceneMirrorPicking.Frame frame = new SceneMirrorPicking.Frame(0, 0, 5, 5,
			0, 9, 2, 1, SceneMirrorViewport.capture(0, 0, 9, 5, 10, 5));
		assertEquals(1, frame.mapX(3, 2));
		// Input center 2*(4+.5)=9 is exactly the excluded physical right edge.
		assertEquals(4, frame.mapX(4, 2));
	}

	@Test
	public void verticalClipUsesOpenGlBottomOrigin()
	{
		SceneMirrorPicking.Frame frame = new SceneMirrorPicking.Frame(0, 0, 10, 10,
			0, 10, 1, 1, SceneMirrorViewport.capture(0, -5, 10, 10, 10, 5));
		assertEquals(7, frame.mapX(2, 0));
		assertEquals(7, frame.mapX(2, 4));
		assertEquals(2, frame.mapX(2, 5));
		assertEquals(2, frame.mapX(2, 9));
	}

	@Test
	public void invalidSnapshotGeometryDoesNotRemap()
	{
		SceneMirrorViewport viewport = SceneMirrorViewport.capture(10, 100, 100, 80, 300, 200);
		assertEquals(20, new SceneMirrorPicking.Frame(10, 20, 100, 80,
			10, 100, 1, 1, null).mapX(20, 30));
		assertEquals(20, new SceneMirrorPicking.Frame(10, 20, 0, 80,
			10, 100, 1, 1, viewport).mapX(20, 30));
		assertEquals(20, new SceneMirrorPicking.Frame(10, 20, 100, 80,
			10, 0, 1, 1, viewport).mapX(20, 30));
		assertEquals(20, new SceneMirrorPicking.Frame(10, 20, 100, 80,
			10, 100, Double.NaN, 1, viewport).mapX(20, 30));
		assertEquals(20, new SceneMirrorPicking.Frame(10, 20, 100, 80,
			10, 100, 1, 0, viewport).mapX(20, 30));
	}

	@Test
	public void unpublishedAndClearedBridgeRemainIdentity()
	{
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
		SceneMirrorPicking.publish(clientWithViewport(10, 20, 100, 80), standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		SceneMirrorPicking.clear();
		assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
	}

	@Test
	public void bridgeRejectsEveryChangedLogicalViewportField()
	{
		Client client = clientWithViewport(10, 20, 100, 80);
		SceneMirrorPicking.publish(client, standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		int[][] staleViewports = {{11, 20, 100, 80}, {10, 21, 100, 80},
			{10, 20, 101, 80}, {10, 20, 100, 81}};
		for (int[] stale : staleViewports)
		{
			setViewport(client, stale[0], stale[1], stale[2], stale[3]);
			assertEquals(20, SceneMirrorPicking.mapSceneX(20, 30));
		}
	}

	@Test
	public void capturedProjectionUsesTruncatedFramebufferRatio()
	{
		Client client = clientWithViewport(7, 20, 511, 200);
		when(client.getCanvasWidth()).thenReturn(765);
		when(client.getCanvasHeight()).thenReturn(400);
		SceneMirrorViewport viewport = SceneMirrorViewport.capture(8, 250, 638, 250, 956, 500);
		SceneMirrorPicking.publish(client, SceneMirrorPicking.Frame.capture(client, 8, 638, viewport));
		// DPI1.25 yields physical width956 rather than956.25; UI texture scales765->956.
		assertEquals(445, SceneMirrorPicking.mapWorldCanvasX(client, 79, 50));
	}

	@Test
	public void projectedAnchorsFollowTheWorldWithoutReflectingGlyphs()
	{
		Client client = clientWithViewport(10, 20, 100, 80);
		SceneMirrorPicking.publish(client, standardFrame());
		assertTrue(SceneMirrorPicking.isMirrored(client));
		assertEquals(80, SceneMirrorPicking.mapWorldAnchorX(20));
		assertEquals(90, SceneMirrorPicking.mapWorldCanvasX(client, 30, 50));
		// Offscreen world vertices still need reflection to preserve crossing polygons.
		assertEquals(120, SceneMirrorPicking.mapWorldAnchorX(-20));
		assertEquals(130, SceneMirrorPicking.mapWorldCanvasX(client, -10, 50));
		assertEquals(Integer.MIN_VALUE, SceneMirrorPicking.mapWorldCanvasX(client, Integer.MIN_VALUE, Integer.MIN_VALUE));
		SceneMirrorPicking.clear();
		assertFalse(SceneMirrorPicking.isMirrored(client));
		assertEquals(30, SceneMirrorPicking.mapWorldCanvasX(client, 30, 50));
	}

	@Test
	public void fractionalGeometryAndRasterPixelsUseTheirOwnCenters()
	{
		Client client = clientWithViewport(10, 20, 100, 80);
		SceneMirrorPicking.publish(client, fractionalFrame());
		assertEquals(80, SceneMirrorPicking.mapWorldAnchorX(20));
		assertEquals(90, SceneMirrorPicking.mapWorldCanvasX(client, 30, 50));
		// Geometric vertices are continuous; picking maps displayed raster pixel centers.
		assertEquals(20, SceneMirrorPicking.mapSceneX(79, 30));
	}

	@Test
	public void newlyPublishedFrameReplacesPreviousViewport()
	{
		Client client = clientWithViewport(10, 20, 100, 80);
		SceneMirrorPicking.publish(client, standardFrame());
		assertEquals(79, SceneMirrorPicking.mapSceneX(20, 30));
		setViewport(client, 2, 1, 5, 5);
		SceneMirrorPicking.publish(client, new SceneMirrorPicking.Frame(2, 1, 5, 5,
			2, 5, 1, 1, SceneMirrorViewport.capture(2, 2, 5, 5, 12, 8)));
		assertEquals(4, SceneMirrorPicking.mapSceneX(0, 0));
	}

	private static SceneMirrorPicking.Frame standardFrame()
	{
		return new SceneMirrorPicking.Frame(10, 20, 100, 80,
			10, 100, 1, 1, SceneMirrorViewport.capture(10, 100, 100, 80, 300, 200));
	}

	private static SceneMirrorPicking.Frame fractionalFrame()
	{
		return new SceneMirrorPicking.Frame(10, 20, 100, 80,
			11, 127, 1.25, 1.5, SceneMirrorViewport.capture(11, 150, 127, 120, 400, 300));
	}

	private static Client clientWithViewport(int x, int y, int width, int height)
	{
		Client client = mock(Client.class);
		setViewport(client, x, y, width, height);
		return client;
	}

	private static void setViewport(Client client, int x, int y, int width, int height)
	{
		when(client.getViewportXOffset()).thenReturn(x);
		when(client.getViewportYOffset()).thenReturn(y);
		when(client.getViewportWidth()).thenReturn(width);
		when(client.getViewportHeight()).thenReturn(height);
	}
}
