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

/**
 * A JTabbedPane that supports drag-and-drop reordering of tabs.
 * <p>
 * Follows the same behavioral pattern as {@link DragAndDropReorderPane}:
 * tabs are moved in real-time as the user drags, so other tabs shift
 * to accommodate the dragged tab's new position immediately.
 */
@Slf4j
public class DragAndDropTabbedPane extends JTabbedPane
{
	private Point dragStartPoint;
	private int pressedTabIndex = -1;

	/**
	 * The current index of the tab being dragged. Updated live as the tab moves.
	 */
	private int dragIndex = -1;

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


		repaint();
	}

	/**
	 * Handle an ongoing drag by checking if the mouse has crossed the midpoint
	 * of an adjacent tab and, if so, moving the dragged tab to that position.
	 * This mirrors {@link DragAndDropReorderPane}'s live-reorder behavior.
	 */
	private void drag(Point point)
	{
		int tabPlacement = getTabPlacement();
		boolean vertical = (tabPlacement == LEFT || tabPlacement == RIGHT);

		for (int i = 0; i < getTabCount(); i++)
		{
			if (i == dragIndex)
			{
				continue;
			}

			Rectangle bounds = getBoundsAt(i);
			if (bounds == null)
			{
				continue;
			}

			int mid = vertical
				? bounds.y + bounds.height / 2
				: bounds.x + bounds.width / 2;

			int mousePos = vertical ? point.y : point.x;
			boolean dragUp = i < dragIndex;

			// Require the mouse to cross the midpoint of the target tab
			if (dragUp && mousePos < mid)
			{
				moveTab(dragIndex, i);
				dragIndex = i;
				repaint();
				return;
			}
			else if (!dragUp && mousePos > mid)
			{
				moveTab(dragIndex, i);
				dragIndex = i;
				repaint();
				return;
			}
		}
	}

	private void finishDragging()
	{
		if (dragIndex >= 0 && pressedTabIndex >= 0 && dragIndex != pressedTabIndex)
		{
			final int fromIndex = pressedTabIndex;
			final int toIndex = dragIndex;
			dragListeners.forEach(l -> l.onTabDragged(fromIndex, toIndex));
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
		dragging = false;
		potentialDrag = false;
		repaint();
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		if (!dragging || dragIndex < 0 || dragIndex >= getTabCount())
		{
			return;
		}

		Rectangle bounds = getBoundsAt(dragIndex);
		if (bounds == null)
		{
			return;
		}

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(ColorScheme.DARKEST_GRAY_COLOR);
		// g2d.fillRoundRect(bounds.x + 1, bounds.y + 1, bounds.width - 2, bounds.height - 2, 4, 4);
		g2d.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

		// Repaint the tab icon on top of the highlight
		Icon icon = getIconAt(dragIndex);
		if (icon != null)
		{
			int iconX = bounds.x + (bounds.width - icon.getIconWidth()) / 2;
			int iconY = bounds.y + (bounds.height - icon.getIconHeight()) / 2;
			icon.paintIcon(this, g2d, iconX, iconY);
		}

		g2d.dispose();
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

		// Use super to bypass our drag suppression override
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
