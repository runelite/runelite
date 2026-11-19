/*
 * Copyright (c) 2026, MoonBoi9001 <https://github.com/MoonBoi9001>
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
package net.runelite.client.plugins.worldmap;

import java.awt.Canvas;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ClientTick;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.events.MagnificationGesture;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorldMapTrackpadTest
{
	@Mock
	private Client client;

	@Mock
	private ClientThread clientThread;

	@Mock
	private WorldMapConfig config;

	@Mock
	private WorldMap worldMap;

	@Mock
	private Widget map;

	private WorldMapTrackpad trackpad;

	@Before
	public void before()
	{
		lenient().when(config.swipeToMove()).thenReturn(true);
		lenient().when(client.getWorldMap()).thenReturn(worldMap);
		lenient().when(client.getWidget(InterfaceID.Worldmap.MAP_CONTAINER)).thenReturn(map);
		lenient().when(map.getBounds()).thenReturn(new Rectangle(0, 0, 500, 400));
		lenient().when(client.getMouseCanvasPosition()).thenReturn(new Point(250, 200));
		lenient().when(worldMap.getWorldMapPosition()).thenReturn(new Point(3200, 3200));
		// 4 pixels per tile, so 1 unit of scrolling moves the map 2.5 tiles
		lenient().when(worldMap.getWorldMapZoom()).thenReturn(4f);
		doAnswer(inv ->
		{
			inv.<Runnable>getArgument(0).run();
			return null;
		}).when(clientThread).invokeLater(any(Runnable.class));

		trackpad = spy(new WorldMapTrackpad(client, clientThread, config));
		lenient().doNothing().when(trackpad).sendZoomScroll(anyInt());
		trackpad.macOS = true;
		// Notices the mouse is over the map
		trackpad.onClientTick(new ClientTick());
	}

	private static MouseWheelEvent swipe(boolean sideways, double amount)
	{
		return new MouseWheelEvent(new Canvas(), MouseEvent.MOUSE_WHEEL, 0, sideways ? InputEvent.SHIFT_DOWN_MASK : 0,
			100, 100, 100, 100, 0, false, MouseWheelEvent.WHEEL_UNIT_SCROLL, 1, 0, amount);
	}

	@Test
	public void testSwipesMoveTheMap()
	{
		MouseWheelEvent down = swipe(false, 2);
		trackpad.mouseWheelMoved(down);
		trackpad.onClientTick(new ClientTick());
		verify(worldMap).setWorldMapPositionTarget(new WorldPoint(3200, 3195, 0));
		// Otherwise the game zooms the map
		assertTrue(down.isConsumed());

		trackpad.mouseWheelMoved(swipe(true, 2));
		trackpad.onClientTick(new ClientTick());
		verify(worldMap).setWorldMapPositionTarget(new WorldPoint(3205, 3195, 0));
	}

	@Test
	public void testSwipesBuildOnTheirOwnTargetUntilIdle()
	{
		// The map glides, so its reported position still lags behind where the swipes sent it
		trackpad.mouseWheelMoved(swipe(false, 2));
		trackpad.onClientTick(new ClientTick());
		trackpad.mouseWheelMoved(swipe(false, 2));
		trackpad.onClientTick(new ClientTick());
		verify(worldMap).setWorldMapPositionTarget(new WorldPoint(3200, 3190, 0));

		for (int i = 0; i < 30; i++)
		{
			trackpad.onClientTick(new ClientTick());
		}
		trackpad.mouseWheelMoved(swipe(false, 2));
		trackpad.onClientTick(new ClientTick());
		verify(worldMap, times(2)).setWorldMapPositionTarget(new WorldPoint(3200, 3195, 0));
	}

	@Test
	public void testSwipesAwayFromMapPassThrough()
	{
		lenient().when(client.getMouseCanvasPosition()).thenReturn(new Point(600, 200));
		trackpad.onClientTick(new ClientTick());

		MouseWheelEvent event = swipe(false, 2);
		trackpad.mouseWheelMoved(event);
		trackpad.onClientTick(new ClientTick());

		assertFalse(event.isConsumed());
		verify(worldMap, never()).setWorldMapPositionTarget(any());
	}

	@Test
	public void testSwipesWhileOptionOffPassThrough()
	{
		lenient().when(config.swipeToMove()).thenReturn(false);

		MouseWheelEvent event = swipe(false, 2);
		trackpad.mouseWheelMoved(event);
		trackpad.onClientTick(new ClientTick());

		assertFalse(event.isConsumed());
		verify(worldMap, never()).setWorldMapPositionTarget(any());
	}

	@Test
	public void testPinchZoomsInSteps()
	{
		// Each spreads the fingers by 10%, and 3 of them pass the 25% that makes 1 zoom step
		trackpad.onMagnificationGesture(new MagnificationGesture(0.1));
		trackpad.onMagnificationGesture(new MagnificationGesture(0.1));
		verify(trackpad, never()).sendZoomScroll(anyInt());
		trackpad.onMagnificationGesture(new MagnificationGesture(0.1));
		verify(trackpad).sendZoomScroll(-1);

		trackpad.onMagnificationGesture(new MagnificationGesture(-0.3));
		verify(trackpad).sendZoomScroll(1);
	}

	@Test
	public void testZoomScrollReachesTheGame() throws Exception
	{
		final WorldMapTrackpad sender = new WorldMapTrackpad(client, clientThread, config);
		sender.macOS = true;
		sender.onClientTick(new ClientTick());
		final Canvas canvas = new Canvas()
		{
			@Override
			public java.awt.Point getMousePosition()
			{
				return new java.awt.Point(250, 200);
			}
		};
		when(client.getCanvas()).thenReturn(canvas);
		// Another wheel listener before this one may hand on a copy of the event
		final List<MouseWheelEvent> reachedGame = new ArrayList<>();
		canvas.addMouseWheelListener(e ->
		{
			final MouseWheelEvent copy = new MouseWheelEvent(canvas, e.getID(), e.getWhen(), e.getModifiersEx(), e.getX(),
				e.getY(), 0, false, e.getScrollType(), e.getScrollAmount(), e.getWheelRotation());
			if (!sender.mouseWheelMoved(copy).isConsumed())
			{
				reachedGame.add(copy);
			}
		});

		sender.sendZoomScroll(-1);
		SwingUtilities.invokeAndWait(() ->
		{
		});

		assertEquals(1, reachedGame.size());
		assertEquals(-1, reachedGame.get(0).getWheelRotation());
	}

	@Test
	public void testSwipeOverKeyPanelPassesThrough()
	{
		// The Key list sits over the map and scrolls by itself
		final Widget key = mock(Widget.class);
		when(key.getBounds()).thenReturn(new Rectangle(200, 100, 100, 200));
		when(client.getWidget(InterfaceID.Worldmap.KEY_CONTAINER)).thenReturn(key);
		trackpad.onClientTick(new ClientTick());

		MouseWheelEvent event = swipe(false, 2);
		trackpad.mouseWheelMoved(event);
		trackpad.onClientTick(new ClientTick());

		assertFalse(event.isConsumed());
		verify(worldMap, never()).setWorldMapPositionTarget(any());
	}

	@Test
	public void testScrollsOffMacPassThrough()
	{
		// Elsewhere there is no pinch to zoom with instead, so scrolling must keep zooming the map
		trackpad.macOS = false;
		trackpad.onClientTick(new ClientTick());

		MouseWheelEvent event = swipe(false, 2);
		trackpad.mouseWheelMoved(event);
		trackpad.onClientTick(new ClientTick());

		assertFalse(event.isConsumed());
		verify(worldMap, never()).setWorldMapPositionTarget(any());
	}

	@Test(timeout = 2000)
	public void testPinchClosingFullyInOneEventIsIgnored()
	{
		trackpad.onMagnificationGesture(new MagnificationGesture(-1));
		trackpad.onMagnificationGesture(new MagnificationGesture(0.3));

		verify(trackpad).sendZoomScroll(-1);
	}
}
