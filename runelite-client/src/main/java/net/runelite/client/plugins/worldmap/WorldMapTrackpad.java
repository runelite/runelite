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

import com.google.common.annotations.VisibleForTesting;
import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ClientTick;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.worldmap.WorldMap;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.MagnificationGesture;
import net.runelite.client.input.MouseWheelListener;
import net.runelite.client.util.OSType;

/**
 * Moves the world map with 2-finger trackpad swipes and zooms it with pinches. The game zooms the map when
 * scrolling over it, so with this on those scrolls move it instead and a pinch is sent on as a zoom scroll.
 */
class WorldMapTrackpad implements MouseWheelListener
{
	// Screen pixels per unit of scrolling, as Java on macOS reports a trackpad scroll
	private static final double PIXELS_PER_SCROLL = 10;
	// Panels drawn over the map that scroll by themselves
	private static final int[] MAP_PANELS = {
		InterfaceID.Worldmap.OVERVIEW_CONTAINER,
		InterfaceID.Worldmap.KEY_CONTAINER,
		InterfaceID.Worldmap.MAPLIST_CONTAINER,
	};
	// How far the fingers must spread or close, as a scale, to zoom the map 1 step
	private static final double ZOOM_STEP_SCALE = 1.25;
	// Client ticks after the last swipe or pinch before starting afresh, as the map may have been
	// dragged with the mouse in the meantime
	private static final int IDLE_TICKS = 25;

	// Only Java on macOS reports trackpad pinches and sideways swipes
	@VisibleForTesting
	boolean macOS = OSType.getOSType() == OSType.MacOS;

	private final Client client;
	private final ClientThread clientThread;
	private final WorldMapConfig config;

	// Set on the client thread each tick and read on the AWT thread, which can't look at widgets
	private volatile boolean mouseOverMap;
	private double pendingX;
	private double pendingY;
	// Where swipes have moved the map to. The map glides towards its target, so its own position lags behind.
	private double targetX;
	private double targetY;
	private int ticksSinceSwipe = IDLE_TICKS;
	private double pinchLogScale;
	private int ticksSincePinch = IDLE_TICKS;
	// Whether a zoom scroll is being sent to the game, which must reach it untouched. It is checked by flag
	// rather than by the event itself, as other wheel listeners may hand on a copy. Only used on the AWT thread.
	private boolean sendingZoomScroll;

	@Inject
	WorldMapTrackpad(Client client, ClientThread clientThread, WorldMapConfig config)
	{
		this.client = client;
		this.clientThread = clientThread;
		this.config = config;
	}

	void reset()
	{
		mouseOverMap = false;
		pendingX = 0;
		pendingY = 0;
		ticksSinceSwipe = IDLE_TICKS;
		pinchLogScale = 0;
		ticksSincePinch = IDLE_TICKS;
	}

	@Override
	public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
	{
		if (!macOS || sendingZoomScroll || !mouseOverMap || !config.swipeToMove())
		{
			return event;
		}

		// Otherwise the game zooms the map
		event.consume();
		final double amount = event.getPreciseWheelRotation();
		// Java on macOS reports a sideways trackpad scroll as a scroll with shift held
		final boolean sideways = event.isShiftDown();
		clientThread.invokeLater(() ->
		{
			if (sideways)
			{
				pendingX += amount;
			}
			else
			{
				pendingY += amount;
			}
		});
		return event;
	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		if (!macOS || !config.swipeToMove())
		{
			mouseOverMap = false;
			pendingX = 0;
			pendingY = 0;
			return;
		}

		mouseOverMap = isMouseOverMap();
		ticksSinceSwipe = Math.min(ticksSinceSwipe + 1, IDLE_TICKS);
		ticksSincePinch = Math.min(ticksSincePinch + 1, IDLE_TICKS);
		if (ticksSincePinch == IDLE_TICKS)
		{
			pinchLogScale = 0;
		}

		if (pendingX == 0 && pendingY == 0)
		{
			return;
		}
		if (!mouseOverMap)
		{
			pendingX = 0;
			pendingY = 0;
			return;
		}

		final WorldMap worldMap = client.getWorldMap();
		if (ticksSinceSwipe == IDLE_TICKS)
		{
			final Point position = worldMap.getWorldMapPosition();
			targetX = position.getX();
			targetY = position.getY();
		}
		ticksSinceSwipe = 0;

		// Scrolling down or right moves the view that way, as on any page, and the map's y grows northwards
		final double tilesPerScroll = PIXELS_PER_SCROLL / worldMap.getWorldMapZoom();
		targetX += pendingX * tilesPerScroll;
		targetY -= pendingY * tilesPerScroll;
		pendingX = 0;
		pendingY = 0;
		worldMap.setWorldMapPositionTarget(new WorldPoint((int) Math.round(targetX), (int) Math.round(targetY), 0));
	}

	@Subscribe
	public void onMagnificationGesture(MagnificationGesture event)
	{
		// A full close in 1 event would make the scale infinite
		if (!mouseOverMap || !(event.getMagnification() > -1))
		{
			return;
		}

		ticksSincePinch = 0;
		pinchLogScale += Math.log1p(event.getMagnification());
		final double step = Math.log(ZOOM_STEP_SCALE);
		while (Math.abs(pinchLogScale) >= step)
		{
			final boolean zoomIn = pinchLogScale > 0;
			pinchLogScale += zoomIn ? -step : step;
			// Scrolling up zooms the map in
			sendZoomScroll(zoomIn ? -1 : 1);
		}
	}

	@VisibleForTesting
	void sendZoomScroll(int rotation)
	{
		SwingUtilities.invokeLater(() ->
		{
			final Canvas canvas = client.getCanvas();
			final java.awt.Point mouse = canvas.getMousePosition();
			if (mouse == null)
			{
				return;
			}

			sendingZoomScroll = true;
			try
			{
				canvas.dispatchEvent(new MouseWheelEvent(canvas, MouseEvent.MOUSE_WHEEL, System.currentTimeMillis(), 0,
					mouse.x, mouse.y, 0, false, MouseWheelEvent.WHEEL_UNIT_SCROLL, 1, rotation));
			}
			finally
			{
				sendingZoomScroll = false;
			}
		});
	}

	private boolean isMouseOverMap()
	{
		final Widget map = client.getWidget(InterfaceID.Worldmap.MAP_CONTAINER);
		if (map == null || map.isHidden())
		{
			return false;
		}

		final Point mouse = client.getMouseCanvasPosition();
		if (!map.getBounds().contains(mouse.getX(), mouse.getY()))
		{
			return false;
		}

		for (int id : MAP_PANELS)
		{
			final Widget panel = client.getWidget(id);
			if (panel != null && !panel.isHidden() && panel.getBounds().contains(mouse.getX(), mouse.getY()))
			{
				return false;
			}
		}
		return true;
	}
}
