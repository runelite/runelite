/*
 * Copyright (c) 2026, Swirle13 <https://github.com/swirle13>
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
package net.runelite.client.ui.components;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.dnd.DragSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ColorUtil;

/**
 * A JTabbedPane that supports drag-and-drop reordering of tabs.
 * <p>
 * During a drag, a floating image of the dragged tab follows the cursor
 * and a highlight marks the drop target. The actual tab move only happens
 * once on drop, avoiding expensive intermediate layout passes.
 */
public class DragAndDropTabbedPane extends JTabbedPane
{
	private Point dragStartPoint;
	private int dragIndex = -1;
	private int dropTargetIndex = -1;
	private BufferedImage dragImage;
	private Point currentDragPoint;
	@Getter
	private boolean dragging;
	private boolean potentialDrag;
	private final List<DragListener> dragListeners = new ArrayList<>(0);
	// private MouseAdapter dragMouseAdapter;

	public DragAndDropTabbedPane(int tabPlacement)
	{
		super(tabPlacement);
		MouseAdapter mouseAdapter = new DragAndDropTabMouseAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
		// addMouseListener((ev) ->
		// {
		// 	getUI();
		// });
	}

	/**
	 * Suppress tab selection changes while a drag is in progress or
	 * potentially starting.
	 */
	@Override
	public void setSelectedIndex(int index)
	{
		if (potentialDrag || dragging)
		{
			return;
		}
		super.setSelectedIndex(index);
	}

	/**
	 * Intercept MOUSE_PRESSED to set potentialDrag before the event reaches
	 * the UI delegate's mouse listener.
	 */
	@Override
	protected void processMouseEvent(MouseEvent e)
	{
		if (
			// dragMouseAdapter != null &&
			e.getID() == MouseEvent.MOUSE_PRESSED &&
				SwingUtilities.isLeftMouseButton(e) &&
				getTabCount() > 1)
		{
			int tabIndex = indexAtLocation(e.getX(), e.getY());
			if (tabIndex >= 0)
			{
				potentialDrag = true;
			}
		}
		super.processMouseEvent(e);
	}

	public void addDragListener(DragListener listener)
	{
		dragListeners.add(listener);
	}

	public void removeTabDragListener(DragListener listener)
	{
		dragListeners.remove(listener);
	}

	public void clearTabDragListeners()
	{
		dragListeners.clear();
	}

	private void startDragging(Point point)
	{
		dragIndex = indexAtLocation(dragStartPoint.x, dragStartPoint.y);
		if (dragIndex < 0)
		{
			dragStartPoint = null;
			return;
		}

		dragging = true;
		dropTargetIndex = dragIndex;
		currentDragPoint = point;

		Icon icon = getIconAt(dragIndex);
		if (icon != null)
		{
			int pad = 4;
			int w = icon.getIconWidth() + pad * 2;
			int h = icon.getIconHeight() + pad * 2;
			dragImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = dragImage.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(ColorUtil.colorWithAlpha(ColorScheme.MEDIUM_GRAY_COLOR, 128));
			g.fillRoundRect(0, 0, w, h, 6, 6);
			icon.paintIcon(this, g, pad, pad);
			g.dispose();
		}

		repaint();
	}

	private void drag(Point point)
	{
		currentDragPoint = point;
		int newDropTarget = calculateDropTargetIndex(point);
		if (newDropTarget != dropTargetIndex)
		{
			dropTargetIndex = newDropTarget;
		}
		repaint();
	}

	private void finishDragging()
	{
		potentialDrag = false;
		if (!dragging)
		{
			return;
		}

		int fromIndex = dragIndex;
		int toIndex = dropTargetIndex;

		resetDragState();

		if (fromIndex != toIndex && fromIndex >= 0 && toIndex >= 0)
		{
			moveTab(fromIndex, toIndex);
			for (DragListener listener : dragListeners)
			{
				listener.onDrag(fromIndex, toIndex);
			}
		}

		repaint();
	}

	private void resetDragState()
	{
		dragging = false;
		potentialDrag = false;
		dragStartPoint = null;
		dragIndex = -1;
		dropTargetIndex = -1;
		dragImage = null;
		currentDragPoint = null;
	}

	private int calculateDropTargetIndex(Point point)
	{
		int tabCount = getTabCount();
		if (tabCount == 0)
		{
			return 0;
		}

		for (int i = 0; i < tabCount; i++)
		{
			Rectangle bounds = getBoundsAt(i);
			if (bounds == null)
			{
				continue;
			}
			int midY = bounds.y + bounds.height / 2;
			if (point.y < midY)
			{
				return i;
			}
		}
		return tabCount - 1;
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		if (!dragging)
		{
			return;
		}

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Highlight the dragged tab
		if (dragIndex >= 0 && dragIndex < getTabCount())
		{
			Rectangle dragBounds = getBoundsAt(dragIndex);
			if (dragBounds != null)
			{
				g2d.setColor(ColorScheme.DARKER_GRAY_COLOR);
				g2d.fillRect(dragBounds.x, dragBounds.y, dragBounds.width, dragBounds.height);

				Icon icon = getIconAt(dragIndex);
				if (icon != null)
				{
					int iconX = dragBounds.x + (dragBounds.width - icon.getIconWidth()) / 2;
					int iconY = dragBounds.y + (dragBounds.height - icon.getIconHeight()) / 2;
					icon.paintIcon(this, g2d, iconX, iconY);
				}
			}
		}

		// Draw drop indicator line
		if (dropTargetIndex >= 0 && dropTargetIndex != dragIndex && dropTargetIndex != dragIndex + 1)
		{
			drawDropIndicator(g2d);
		}

		// Draw floating drag image
		if (dragImage != null && currentDragPoint != null)
		{
			int x = currentDragPoint.x - dragImage.getWidth() / 2;
			int y = currentDragPoint.y - dragImage.getHeight() / 2;
			g2d.drawImage(dragImage, x, y, null);
		}

		g2d.dispose();
	}

	private void drawDropIndicator(Graphics2D g)
	{
		int tabPlacement = getTabPlacement();
		boolean vertical = (tabPlacement == LEFT || tabPlacement == RIGHT);

		Rectangle ref;
		int pos;
		if (dropTargetIndex >= getTabCount())
		{
			ref = getBoundsAt(getTabCount() - 1);
			if (ref == null)
			{
				return;
			}
			pos = vertical ? ref.y + ref.height : ref.x + ref.width;
		}
		else
		{
			ref = getBoundsAt(dropTargetIndex);
			if (ref == null)
			{
				return;
			}
			pos = vertical ? ref.y : ref.x;
		}

		g.setColor(ColorScheme.BRAND_ORANGE);
		if (vertical)
		{
			g.fillRect(ref.x + 2, pos - 1, ref.width - 4, 3);
		}
		else
		{
			g.fillRect(pos - 1, ref.y + 2, 3, ref.height - 4);
		}
	}

	private void moveTab(int fromIndex, int toIndex)
	{
		if (fromIndex == toIndex)
		{
			return;
		}

		String title = getTitleAt(fromIndex);
		Icon icon = getIconAt(fromIndex);
		Component component = getComponentAt(fromIndex);
		String tooltip = getToolTipTextAt(fromIndex);
		boolean enabled = isEnabledAt(fromIndex);

		int selectedIndex = super.getSelectedIndex();

		removeTabAt(fromIndex);

		int insertIndex = fromIndex < toIndex ? toIndex - 1 : toIndex;
		insertTab(title, icon, component, tooltip, insertIndex);
		setEnabledAt(insertIndex, enabled);

		if (selectedIndex == fromIndex)
		{
			super.setSelectedIndex(insertIndex);
		}
		else if (selectedIndex > fromIndex && selectedIndex <= toIndex)
		{
			super.setSelectedIndex(selectedIndex - 1);
		}
		else if (selectedIndex < fromIndex && selectedIndex >= toIndex)
		{
			super.setSelectedIndex(selectedIndex + 1);
		}
	}

	@FunctionalInterface
	public interface DragListener
	{
		void onDrag(int fromIndex, int toIndex);
	}

	private class DragAndDropTabMouseAdapter extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			if (SwingUtilities.isLeftMouseButton(e) && getTabCount() > 1)
			{
				dragStartPoint = e.getPoint();
			}
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if (SwingUtilities.isLeftMouseButton(e) && dragStartPoint != null)
			{
				Point point = e.getPoint();
				if (dragging)
				{
					drag(point);
				}
				else if (point.distance(dragStartPoint) > DragSource.getDragThreshold())
				{
					startDragging(point);
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			if (SwingUtilities.isLeftMouseButton(e))
			{
				if (dragging)
				{
					finishDragging();
				}
				else if (potentialDrag)
				{
					potentialDrag = false;
					int tabIndex = indexAtLocation(e.getX(), e.getY());
					if (tabIndex >= 0)
					{
						int current = DragAndDropTabbedPane.super.getSelectedIndex();
						DragAndDropTabbedPane.super.setSelectedIndex(
							current == tabIndex ? -1 : tabIndex);
					}
				}
				dragStartPoint = null;
			}
		}
	}
}
