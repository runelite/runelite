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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import net.runelite.api.CanvasTransform;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.client.game.SceneMirrorPicking;
import net.runelite.client.game.SceneMirrorViewport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SceneMirrorProjectionIntegrationTest
{
	private final SceneMirrorPicking sceneMirrorPicking = new SceneMirrorPicking();

	@Before
	@After
	public void clearTransforms()
	{
		sceneMirrorPicking.clear();
	}

	@Test
	public void geometricAnchorUsesContinuousReflectionWhilePointerUsesPixelCenters()
	{
		Client client = fixture(true);
		install(client, standardFrame());
		assertEquals(80, sceneMirrorPicking.mapWorldAnchorX(20));
		assertEquals(90, sceneMirrorPicking.mapWorldCanvasX(client, 30, 60));
		assertEquals(79, sceneMirrorPicking.mapSceneX(20, 30));
	}

	@Test
	public void rootGpuProjectionUsesTheProductionBridgeExactlyOnce()
	{
		Client client = fixture(true);
		assertEquals(new Point(30, 60), Perspective.localToCanvas(client, 128, 256, 0));
		install(client, standardFrame());
		assertEquals(new Point(90, 60), Perspective.localToCanvas(client, 128, 256, 0));
	}

	@Test
	public void rootCpuProjectionUsesTheProductionBridgeExactlyOnce()
	{
		Client client = fixture(false);
		assertEquals(new Point(30, 60), Perspective.localToCanvas(client, 128, 256, 0));
		install(client, standardFrame());
		assertEquals(new Point(90, 60), Perspective.localToCanvas(client, 128, 256, 0));
	}

	@Test
	public void modelVerticesUseContinuousGeometryIncludingOffscreenVertices()
	{
		for (boolean gpu : new boolean[]{false, true})
		{
			clearTransforms();
			Client client = fixture(gpu);
			int[] x = new int[4];
			int[] y = new int[4];
			Perspective.modelToCanvas(client, 4, 128, 256, 0, 0,
				new float[]{0, 128, -128, 0}, new float[]{0, 0, 0, -256},
				new float[4], x, y);
			// CPU model projection truncates the float sum; GPU model projection rounds.
			// 50 - 7700/256 is 19.921875: native canvas x=29 on CPU, x=30 on GPU.
			assertArrayEquals(gpu ? new int[]{30, 80, -20, Integer.MIN_VALUE}
				: new int[]{29, 79, -20, Integer.MIN_VALUE}, x);
			assertArrayEquals(new int[]{60, 60, 60, Integer.MIN_VALUE}, y);
			install(client, standardFrame());
			Perspective.modelToCanvas(client, 4, 128, 256, 0, 0,
				new float[]{0, 128, -128, 0}, new float[]{0, 0, 0, -256},
				new float[4], x, y);
			assertArrayEquals(gpu ? new int[]{90, 40, 140, Integer.MIN_VALUE}
				: new int[]{91, 41, 140, Integer.MIN_VALUE}, x);
			assertArrayEquals(new int[]{60, 60, 60, Integer.MIN_VALUE}, y);
		}
	}

	@Test
	public void fractionalGeometryAndPointerCellsUseDistinctConventions()
	{
		Client client = fixture(true);
		install(client, new SceneMirrorPicking.Frame(10, 20, 100, 80,
			11, 127, 1.25, 1.5, SceneMirrorViewport.capture(11, 150, 127, 120, 400, 300)));
		// Native vertex x=20 projects to physical 36.4, reflects to 112.6,
		// then occupies canvas x=floor(112.6/1.25)=90 (relative x=80).
		assertEquals(80, sceneMirrorPicking.mapWorldAnchorX(20));
		assertEquals(new Point(90, 60), Perspective.localToCanvas(client, 128, 256, 0));
		// The center of canvas pixel 90 is a different physical point (113.125).
		// Its inverse native coordinate is 19.5876, which belongs to pixel 19.
		assertEquals(19, sceneMirrorPicking.mapSceneX(80, 30));
	}

	@Test
	public void glyphsAndImagesCenterAfterTheActualWorldAnchorMoves()
	{
		Client client = fixture(true);
		install(client, standardFrame());
		Graphics2D graphics = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB).createGraphics();
		try
		{
			String text = "RuneLite";
			int halfWidth = (int) (graphics.getFontMetrics().getStringBounds(text, graphics).getWidth() / 2);
			assertEquals(new Point(90 - halfWidth, 60),
				Perspective.getCanvasTextLocation(client, graphics, new LocalPoint(128, 256), text, 0));
			assertEquals(new AffineTransform(), graphics.getTransform());
			assertEquals(new Point(80, 55), Perspective.getCanvasImageLocation(client,
				new LocalPoint(128, 256), new BufferedImage(20, 10, BufferedImage.TYPE_INT_ARGB), 0));
		}
		finally
		{
			graphics.dispose();
		}
	}

	@Test
	public void clearingPublishedStateRestoresProjectionWithAdapterStillInstalled()
	{
		Client client = fixture(true);
		install(client, standardFrame());
		assertEquals(new Point(90, 60), Perspective.localToCanvas(client, 128, 256, 0));
		sceneMirrorPicking.clear();
		assertEquals(new Point(30, 60), Perspective.localToCanvas(client, 128, 256, 0));
		assertFalse(Perspective.isCanvasMirrored(client));
	}

	@Test
	public void anotherRenderersShutdownDoesNotClearThisClientsProjection()
	{
		Client first = fixture(true);
		Client second = fixture(true);
		install(first, standardFrame());
		SceneMirrorProjectionIntegrationTest other = new SceneMirrorProjectionIntegrationTest();
		other.install(second, standardFrame());
		assertEquals(new Point(90, 60), Perspective.localToCanvas(first, 128, 256, 0));
		assertEquals(new Point(90, 60), Perspective.localToCanvas(second, 128, 256, 0));
		other.sceneMirrorPicking.clear();
		when(second.getDrawCallbacks()).thenReturn(null);
		assertEquals(new Point(90, 60), Perspective.localToCanvas(first, 128, 256, 0));
		assertEquals(new Point(30, 60), Perspective.localToCanvas(second, 128, 256, 0));
	}

	private static SceneMirrorPicking.Frame standardFrame()
	{
		return new SceneMirrorPicking.Frame(10, 20, 100, 80,
			10, 100, 1, 1, SceneMirrorViewport.capture(10, 100, 100, 80, 300, 200));
	}

	private void install(Client client, SceneMirrorPicking.Frame frame)
	{
		sceneMirrorPicking.publish(client, frame);
		DrawCallbacks renderer = mock(DrawCallbacks.class);
		when(client.getDrawCallbacks()).thenReturn(renderer);
		when(renderer.getCanvasTransform()).thenReturn(new CanvasTransform()
		{
			@Override
			public int mapX(Client mappedClient, int x, int y)
			{
				return sceneMirrorPicking.mapWorldCanvasX(mappedClient, x, y);
			}

			@Override
			public boolean isMirrored(Client mappedClient)
			{
				return sceneMirrorPicking.isMirrored(mappedClient);
			}
		});
	}

	private static Client fixture(boolean gpu)
	{
		Client client = mock(Client.class);
		when(client.isGpu()).thenReturn(gpu);
		when(client.getScale()).thenReturn(100);
		when(client.getViewportXOffset()).thenReturn(10);
		when(client.getViewportYOffset()).thenReturn(20);
		when(client.getViewportWidth()).thenReturn(100);
		when(client.getViewportHeight()).thenReturn(80);
		when(client.getCanvasWidth()).thenReturn(300);
		when(client.getCanvasHeight()).thenReturn(200);
		when(client.getStretchedDimensions()).thenReturn(new Dimension(300, 200));
		when(client.getCameraX()).thenReturn(205);
		when(client.getCameraFpX()).thenReturn(205f);
		WorldView root = mock(WorldView.class);
		when(root.isTopLevel()).thenReturn(true);
		when(client.getTopLevelWorldView()).thenReturn(root);
		when(client.getWorldView(WorldView.TOPLEVEL)).thenReturn(root);
		return client;
	}
}
