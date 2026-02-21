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
import java.util.function.Supplier;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ColorUtil;

/**
 * A JTabbedPane that supports drag-and-drop reordering of tabs.
 * <p>
 * During a drag, a floating image of the dragged tab follows the cursor
 * and a highlight marks the drop target. The actual tab move only happens
 * once on drop, avoiding expensive intermediate layout passes.
 */
@Slf4j
public class DragAndDropTabbedPane extends JTabbedPane
{
	private Point dragStartPoint;
	private int pressedTabIndex = -1;

	/**
	 * The index of the tab being dragged (fixed at drag start).
	 */
	private int dragIndex = -1;

	/**
	 * The index where the tab would be inserted if dropped now.
	 */
	private int dropTargetIndex = -1;

	/**
	 * Floating image of the dragged tab's icon.
	 */
	private BufferedImage dragImage;

	/**
	 * Current mouse position during drag.
	 */
	private Point currentDragPoint;

	@Getter
	private boolean dragging;

	/**
	 * True between mousePressed on a draggable tab and either the drag
	 * starting or mouseReleased. Used to suppress tab selection changes
	 * that would toggle the plugin panel during a potential drag.
	 */
	private boolean potentialDrag;

	@Setter
	private boolean dragEnabled = true;

	/**
	 * Optional supplier that determines if dragging is currently allowed.
	 * If set, dragging is only allowed when this returns true.
	 */
	@Setter
	private Supplier<Boolean> dragAllowedSupplier;

	private final List<TabDragListener> dragListeners = new ArrayList<>();

	public DragAndDropTabbedPane()
	{
		this(TOP);
	}

	public DragAndDropTabbedPane(int tabPlacement)
	{
		super(tabPlacement);
		TabDragMouseAdapter mouseAdapter = new TabDragMouseAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}

	/**
	 * Suppress tab selection changes while a drag is in progress or
	 * potentially starting. Without this, the UI delegate's mousePressed
	 * toggles the selected tab (opening/closing the plugin panel) before
	 * mouseDragged has a chance to initiate the drag.
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
	 * the UI delegate's mouse listener. The UI delegate fires first in the
	 * listener chain (registered before our adapter), so we must act here.
	 */
	@Override
	protected void processMouseEvent(MouseEvent e)
	{
		if (e.getID() == MouseEvent.MOUSE_PRESSED
			&& SwingUtilities.isLeftMouseButton(e)
			&& getTabCount() > 1
			&& isDragAllowed())
		{
			int tabIndex = indexAtLocation(e.getX(), e.getY());
			if (tabIndex >= 0)
			{
				potentialDrag = true;
			}
		}
		super.processMouseEvent(e);
	}

	/**
	 * Add a listener to be notified when a tab has been dragged to a new position.
	 */
	public void addTabDragListener(TabDragListener listener)
	{
		dragListeners.add(listener);
	}

	/**
	 * Remove a tab drag listener.
	 */
	public void removeTabDragListener(TabDragListener listener)
	{
		dragListeners.remove(listener);
	}

	private boolean isDragAllowed()
	{
		if (!dragEnabled)
		{
			return false;
		}
		if (dragAllowedSupplier != null)
		{
			return dragAllowedSupplier.get();
		}
		return true;
	}

	private void startDragging()
	{
		dragIndex = pressedTabIndex;
		if (dragIndex < 0 || dragIndex >= getTabCount())
		{
			dragStartPoint = null;
			return;
		}

		dragging = true;
		dropTargetIndex = dragIndex;

		// Create a floating image of the tab icon
		Icon icon = getIconAt(dragIndex);
		if (icon != null)
		{
			int pad = 4;
			int w = icon.getIconWidth() + pad * 2;
			int h = icon.getIconHeight() + pad * 2;
			dragImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = dragImage.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(ColorUtil.colorWithAlpha(ColorScheme.DARKER_GRAY_COLOR, 200));
			g.fillRoundRect(0, 0, w, h, 6, 6);
			icon.paintIcon(this, g, pad, pad);
			g.dispose();
		}

		repaint();
	}

	/**
	 * Update the drop target index based on the current mouse position.
	 * No tabs are physically moved — only the visual indicator changes.
	 */
	private void drag(Point point)
	{
		currentDragPoint = point;

		int tabPlacement = getTabPlacement();
		boolean vertical = (tabPlacement == LEFT || tabPlacement == RIGHT);

		int newTarget = dragIndex;
		for (int i = 0; i < getTabCount(); i++)
		{
			Rectangle bounds = getBoundsAt(i);
			if (bounds == null)
			{
				continue;
			}

			int mid = vertical
				? bounds.y + bounds.height / 2
				: bounds.x + bounds.width / 2;
			int mousePos = vertical ? point.y : point.x;

			if (mousePos < mid)
			{
				newTarget = i;
				break;
			}
			newTarget = i + 1;
		}

		if (newTarget != dropTargetIndex)
		{
			dropTargetIndex = newTarget;
		}

		repaint();
	}

	private void finishDragging()
	{
		if (dragIndex >= 0 && dropTargetIndex >= 0)
		{
			// Adjust target: if dropping after the dragged tab's original
			// position, account for the removal shifting indices down
			int targetIndex = dropTargetIndex > dragIndex
				? dropTargetIndex - 1
				: dropTargetIndex;

			if (targetIndex != dragIndex)
			{
				moveTab(dragIndex, targetIndex);

				final int fromIndex = dragIndex;
				final int toIndex = targetIndex;
				dragListeners.forEach(l -> l.onTabDragged(fromIndex, toIndex));
			}
		}

		resetDragState();
	}

	private void cancelDragging()
	{
		resetDragState();
	}

	private void resetDragState()
	{
		dragStartPoint = null;
		pressedTabIndex = -1;
		dragIndex = -1;
		dropTargetIndex = -1;
		dragImage = null;
		currentDragPoint = null;
		dragging = false;
		potentialDrag = false;
		repaint();
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

	/**
	 * Move a tab from one index to another, preserving all tab properties.
	 */
	public void moveTab(int fromIndex, int toIndex)
	{
		if (fromIndex == toIndex || fromIndex < 0 || toIndex < 0 ||
			fromIndex >= getTabCount() || toIndex >= getTabCount())
		{
			return;
		}

		Component comp = getComponentAt(fromIndex);
		String title = getTitleAt(fromIndex);
		Icon icon = getIconAt(fromIndex);
		String tooltip = getToolTipTextAt(fromIndex);
		boolean enabled = isEnabledAt(fromIndex);

		int selectedIndex = super.getSelectedIndex();
		boolean wasSelected = (selectedIndex == fromIndex);

		removeTabAt(fromIndex);
		insertTab(title, icon, comp, tooltip, toIndex);
		setEnabledAt(toIndex, enabled);

		if (wasSelected)
		{
			super.setSelectedIndex(toIndex);
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

	/**
	 * Listener interface for tab drag events.
	 */
	@FunctionalInterface
	public interface TabDragListener
	{
		/**
		 * Called after a tab has been dragged to a new position.
		 *
		 * @param fromIndex the original index of the tab (at drag start)
		 * @param toIndex   the final index of the tab (at drop)
		 */
		void onTabDragged(int fromIndex, int toIndex);
	}

	private class TabDragMouseAdapter extends MouseAdapter
	{
		private int selectedIndexOnPress = -1;

		@Override
		public void mousePressed(MouseEvent e)
		{
			if (!SwingUtilities.isLeftMouseButton(e))
			{
				return;
			}

			pressedTabIndex = -1;
			selectedIndexOnPress = DragAndDropTabbedPane.super.getSelectedIndex();

			if (getTabCount() > 1 && isDragAllowed())
			{
				int tabIndex = indexAtLocation(e.getX(), e.getY());
				if (tabIndex >= 0)
				{
					pressedTabIndex = tabIndex;
					dragStartPoint = e.getPoint();
				}
			}
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if (!SwingUtilities.isLeftMouseButton(e) || dragStartPoint == null)
			{
				return;
			}

			if (!isDragAllowed())
			{
				cancelDragging();
				return;
			}

			Point point = e.getPoint();
			if (dragging)
			{
				drag(point);
			}
			else if (point.distance(dragStartPoint) > DragSource.getDragThreshold())
			{
				// Restore the selection state from before the press so
				// the tab deselect from clicking doesn't interfere
				if (DragAndDropTabbedPane.super.getSelectedIndex() != selectedIndexOnPress)
				{
					DragAndDropTabbedPane.super.setSelectedIndex(selectedIndexOnPress);
				}
				startDragging();
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
					// Was a click, not a drag — perform the deferred
					// tab selection that we suppressed in mousePressed
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
				pressedTabIndex = -1;
			}
		}
	}
}
