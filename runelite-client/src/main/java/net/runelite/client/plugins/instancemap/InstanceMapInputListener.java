/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.instancemap;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.MouseAdapter;
import net.runelite.client.input.MouseWheelListener;

public class InstanceMapInputListener extends MouseAdapter implements KeyListener, MouseWheelListener
{
	@Inject
	private InstanceMapPlugin plugin;

	@Inject
	private InstanceMapOverlay overlay;

	@Override
	public void keyTyped(KeyEvent event)
	{

	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if (!overlay.isMapShown())
		{
			return;
		}

		if (event.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			plugin.closeMap();
			event.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent event)
	{

	}

	@Override
	public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
	{
		if (!overlay.isMapShown() || isNotWithinOverlay(event.getPoint()))
		{
			return event;
		}

		int direction = event.getWheelRotation();

		if (direction > 0)
		{
			plugin.ascendMap();
		}
		else
		{
			plugin.descendMap();
		}

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent event)
	{
		if (!overlay.isMapShown() || isNotWithinOverlay(event.getPoint()))
		{
			return event;
		}

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent event)
	{
		if (!overlay.isMapShown() || isNotWithinOverlay(event.getPoint()))
		{
			return event;
		}

		if (SwingUtilities.isLeftMouseButton(event) && isWithinCloseButton(event.getPoint()))
		{
			plugin.closeMap();
		}

		event.consume();
		return event;
	}

	@Override
	public MouseEvent mouseMoved(MouseEvent event)
	{
		if (overlay.isMapShown())
		{
			overlay.setCloseButtonHovered(isWithinCloseButton(event.getPoint()));
		}

		return event;
	}

	private boolean isNotWithinOverlay(final Point point)
	{
		return !overlay.getBounds().contains(point);
	}

	private boolean isWithinCloseButton(final Point point)
	{
		Point overlayPoint = new Point(point.x - (int) overlay.getBounds().getX(),
			point.y - (int) overlay.getBounds().getY());

		return overlay.getCloseButtonBounds() != null
			&& overlay.getCloseButtonBounds().contains(overlayPoint);
	}
}
