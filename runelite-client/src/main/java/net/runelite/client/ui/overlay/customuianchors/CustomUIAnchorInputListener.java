/*
 * Copyright (c) 2024, Car_role
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
package net.runelite.client.ui.overlay.customuianchors;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.KeyCode;
import net.runelite.client.input.MouseListener;

/**
 * Handles mouse input for custom UI anchor manipulation (move, resize).
 */
@Singleton
public class CustomUIAnchorInputListener implements MouseListener
{
	private static final int RESIZE_HANDLE_SIZE = 10;

	private static final int NORTH = 1;
	private static final int SOUTH = 2;
	private static final int EAST = 4;
	private static final int WEST = 8;

	private final Client client;
	private final CustomUIAnchorManager customUIAnchorManager;

	private boolean isDragging = false;
	private CustomUIAnchor draggedAnchor = null;
	private Point dragStartPoint = null;
	private Rectangle originalBounds = null;
	private boolean isResizing = false;
	private int resizeDirection = 0;

	private CustomUIAnchorSelectedCallback selectionCallback;

	@Inject
	public CustomUIAnchorInputListener(Client client, CustomUIAnchorManager customUIAnchorManager)
	{
		this.client = client;
		this.customUIAnchorManager = customUIAnchorManager;
	}

	public void setSelectionCallback(CustomUIAnchorSelectedCallback callback)
	{
		this.selectionCallback = callback;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent e)
	{
		if (!customUIAnchorManager.isManagementModeActive())
		{
			return e;
		}

		if (!client.isKeyPressed(KeyCode.KC_ALT) || SwingUtilities.isRightMouseButton(e))
		{
			return e;
		}

		Point mousePos = e.getPoint();

		for (CustomUIAnchor anchor : customUIAnchorManager.getAnchors())
		{
			Rectangle bounds = anchor.getBounds();
			if (bounds.contains(mousePos) || isNearResizeHandle(bounds, mousePos))
			{
				isDragging = true;
				draggedAnchor = anchor;
				dragStartPoint = mousePos;
				originalBounds = new Rectangle(bounds);

				resizeDirection = getResizeDirection(bounds, mousePos);
				isResizing = resizeDirection != 0;

				customUIAnchorManager.setAnchorDragging(true, anchor);

				e.consume();
				return e;
			}
		}

		return e;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent e)
	{
		if (!customUIAnchorManager.isManagementModeActive())
		{
			return e;
		}

		if (!isDragging || draggedAnchor == null)
		{
			return e;
		}

		Point currentPos = e.getPoint();
		int dx = currentPos.x - dragStartPoint.x;
		int dy = currentPos.y - dragStartPoint.y;

		if (isResizing)
		{
			handleResize(dx, dy);
		}
		else
		{
			handleMove(dx, dy);
		}

		if (selectionCallback != null)
		{
			selectionCallback.onAnchorSelected(draggedAnchor);
		}

		e.consume();
		return e;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent e)
	{
		// Always reset cursor on mouse release to prevent stuck cursor
		client.getCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		if (!customUIAnchorManager.isManagementModeActive() && !isDragging)
		{
			return e;
		}

		if (isDragging)
		{
			customUIAnchorManager.saveAnchors();
			customUIAnchorManager.setAnchorDragging(false, null);
			isDragging = false;
			draggedAnchor = null;
			isResizing = false;
			resizeDirection = 0;
			e.consume();
		}
		return e;
	}

	@Override
	public MouseEvent mouseClicked(MouseEvent e)
	{
		if (!customUIAnchorManager.isManagementModeActive())
		{
			return e;
		}

		Point mousePos = e.getPoint();
		boolean found = false;

		for (CustomUIAnchor anchor : customUIAnchorManager.getAnchors())
		{
			if (anchor.getBounds().contains(mousePos))
			{
				if (selectionCallback != null)
				{
					selectionCallback.onAnchorSelected(anchor);
				}
				found = true;
				break;
			}
		}

		if (found && client.isKeyPressed(KeyCode.KC_ALT))
		{
			e.consume();
		}
		else if (!found && client.isKeyPressed(KeyCode.KC_ALT) && selectionCallback != null)
		{
			selectionCallback.onAnchorSelected(null);
		}

		return e;
	}

	@Override
	public MouseEvent mouseEntered(MouseEvent e)
	{
		return e;
	}

	@Override
	public MouseEvent mouseExited(MouseEvent e)
	{
		return e;
	}

	@Override
	public MouseEvent mouseMoved(MouseEvent e)
	{
		// Only change cursor when hovering over an anchor with Alt held
		if (!client.isKeyPressed(KeyCode.KC_ALT))
		{
			return e;
		}

		for (CustomUIAnchor anchor : customUIAnchorManager.getAnchors())
		{
			Rectangle bounds = anchor.getBounds();
			if (bounds.contains(e.getPoint()) || isNearResizeHandle(bounds, e.getPoint()))
			{
				int dir = getResizeDirection(bounds, e.getPoint());
				client.getCanvas().setCursor(getCursorForDirection(dir));
				return e;
			}
		}

		return e;
	}

	private void handleMove(int dx, int dy)
	{
		draggedAnchor.setX(originalBounds.x + dx);
		draggedAnchor.setY(originalBounds.y + dy);
	}

	private void handleResize(int dx, int dy)
	{
		int x = originalBounds.x;
		int y = originalBounds.y;
		int w = originalBounds.width;
		int h = originalBounds.height;

		if ((resizeDirection & WEST) != 0)
		{
			x += dx;
			w -= dx;
		}
		if ((resizeDirection & EAST) != 0)
		{
			w += dx;
		}
		if ((resizeDirection & NORTH) != 0)
		{
			y += dy;
			h -= dy;
		}
		if ((resizeDirection & SOUTH) != 0)
		{
			h += dy;
		}

		if (w < 10)
		{
			if ((resizeDirection & WEST) != 0)
			{
				x = originalBounds.x + originalBounds.width - 10;
			}
			w = 10;
		}
		if (h < 10)
		{
			if ((resizeDirection & NORTH) != 0)
			{
				y = originalBounds.y + originalBounds.height - 10;
			}
			h = 10;
		}

		draggedAnchor.setX(x);
		draggedAnchor.setY(y);
		draggedAnchor.setWidth(w);
		draggedAnchor.setHeight(h);
	}

	private boolean isNearResizeHandle(Rectangle bounds, Point p)
	{
		Rectangle expanded = new Rectangle(
			bounds.x - RESIZE_HANDLE_SIZE / 2,
			bounds.y - RESIZE_HANDLE_SIZE / 2,
			bounds.width + RESIZE_HANDLE_SIZE,
			bounds.height + RESIZE_HANDLE_SIZE);
		return expanded.contains(p) && !new Rectangle(
			bounds.x + RESIZE_HANDLE_SIZE,
			bounds.y + RESIZE_HANDLE_SIZE,
			bounds.width - 2 * RESIZE_HANDLE_SIZE,
			bounds.height - 2 * RESIZE_HANDLE_SIZE).contains(p);
	}

	private int getResizeDirection(Rectangle bounds, Point p)
	{
		int dir = 0;
		int buffer = RESIZE_HANDLE_SIZE;

		boolean nearTop = p.y >= bounds.y - buffer && p.y <= bounds.y + buffer;
		boolean nearBottom = p.y >= bounds.y + bounds.height - buffer && p.y <= bounds.y + bounds.height + buffer;
		boolean nearLeft = p.x >= bounds.x - buffer && p.x <= bounds.x + buffer;
		boolean nearRight = p.x >= bounds.x + bounds.width - buffer && p.x <= bounds.x + bounds.width + buffer;

		if (nearTop)
		{
			dir |= NORTH;
		}
		if (nearBottom)
		{
			dir |= SOUTH;
		}
		if (nearLeft)
		{
			dir |= WEST;
		}
		if (nearRight)
		{
			dir |= EAST;
		}

		return dir;
	}

	private Cursor getCursorForDirection(int dir)
	{
		switch (dir)
		{
			case NORTH:
				return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
			case SOUTH:
				return Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
			case EAST:
				return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
			case WEST:
				return Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
			case NORTH | WEST:
				return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
			case NORTH | EAST:
				return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
			case SOUTH | WEST:
				return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
			case SOUTH | EAST:
				return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
			default:
				return Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
		}
	}

	/**
	 * Callback interface for anchor selection events.
	 */
	public interface CustomUIAnchorSelectedCallback
	{
		void onAnchorSelected(CustomUIAnchor anchor);
	}
}
