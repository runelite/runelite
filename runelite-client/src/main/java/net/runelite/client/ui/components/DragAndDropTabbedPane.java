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
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.dnd.DragSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
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
import org.jetbrains.annotations.NotNull;

/**
 * A JTabbedPane that supports drag-and-drop reordering of tabs.
 * Borrows patterns from DragAndDropReorderPane.
 */
@Slf4j
public class DragAndDropTabbedPane extends JTabbedPane
{
	private static final int ARROW_HEAD_WIDTH = 4;
	private static final int ARROW_HEAD_HEIGHT = 5;
	private static final int LINE_THICKNESS = 1;
	private static final int LINE_PADDING = 0;

	private Point dragStartPoint;
	private int pressedTabIndex = -1;
	private int draggingTabIndex = -1;
	private int dropTargetIndex = -1;
	private BufferedImage dragImage;
	private Point dragImageOffset;
	private Point currentDragPoint;

	@Getter
	private boolean dragging;

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
	 * Add a listener to be notified when a tab is dragged to a new position.
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

	private void prepareDragImage()
	{
		if (pressedTabIndex < 0 || pressedTabIndex >= getTabCount())
		{
			return;
		}

		Icon icon = getIconAt(pressedTabIndex);
		if (icon == null)
		{
			return;
		}

		int pad = 4;
		int w = icon.getIconWidth() + pad * 2;
		int h = icon.getIconHeight() + pad * 2;
		dragImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = dragImage.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(ColorUtil.colorWithAlpha(ColorScheme.LIGHT_GRAY_COLOR, 128));
		g.fillRoundRect(0, 0, w, h, 6, 6);
		icon.paintIcon(this, g, pad, pad);
		g.dispose();

		// Center the drag image on the cursor
		dragImageOffset = new Point(w / 2, h / 2);
	}

	private void startDragging(Point point)
	{
		draggingTabIndex = pressedTabIndex;
		if (draggingTabIndex < 0 || draggingTabIndex >= getTabCount())
		{
			dragStartPoint = null;
			return;
		}

		dragging = true;
		currentDragPoint = point;
		dropTargetIndex = draggingTabIndex;
		repaint();
	}

	private void drag(Point point)
	{
		currentDragPoint = point;

		// Determine drop target based on mouse position
		int newDropTarget = calculateDropIndex(point);
		if (newDropTarget != dropTargetIndex)
		{
			dropTargetIndex = newDropTarget;
		}

		repaint();
	}

	private int calculateDropIndex(Point point)
	{
		int tabPlacement = getTabPlacement();
		boolean vertical = (tabPlacement == LEFT || tabPlacement == RIGHT);

		for (int i = 0; i < getTabCount(); i++)
		{
			Rectangle bounds = getBoundsAt(i);
			if (bounds == null)
			{
				continue;
			}

			if (vertical)
			{
				int midY = bounds.y + bounds.height / 2;
				if (point.y < midY)
				{
					return i;
				}
			}
			else
			{
				int midX = bounds.x + bounds.width / 2;
				if (point.x < midX)
				{
					return i;
				}
			}
		}

		return getTabCount();
	}

	private void finishDragging()
	{
		if (draggingTabIndex >= 0 && dropTargetIndex >= 0 && draggingTabIndex != dropTargetIndex)
		{
			// Adjust for the removal shifting indices
			int targetIndex = dropTargetIndex > draggingTabIndex ? dropTargetIndex - 1 : dropTargetIndex;

			if (targetIndex != draggingTabIndex)
			{
				moveTab(draggingTabIndex, targetIndex);

				// Notify listeners
				final int fromIndex = draggingTabIndex;
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
		draggingTabIndex = -1;
		dropTargetIndex = -1;
		dragImage = null;
		dragImageOffset = null;
		currentDragPoint = null;
		dragging = false;

		repaint();
	}

	/**
	 * Move a tab from one index to another.
	 */
	public void moveTab(int fromIndex, int toIndex)
	{
		if (fromIndex == toIndex || fromIndex < 0 || toIndex < 0 ||
			fromIndex >= getTabCount() || toIndex >= getTabCount())
		{
			return;
		}

		// Save tab properties
		Component comp = getComponentAt(fromIndex);
		String title = getTitleAt(fromIndex);
		Icon icon = getIconAt(fromIndex);
		String tooltip = getToolTipTextAt(fromIndex);
		boolean enabled = isEnabledAt(fromIndex);

		// Track if this was the selected tab
		int selectedIndex = getSelectedIndex();
		boolean wasSelected = (selectedIndex == fromIndex);

		// Remove and re-insert
		removeTabAt(fromIndex);
		insertTab(title, icon, comp, tooltip, toIndex);
		setEnabledAt(toIndex, enabled);

		// Restore selection
		if (wasSelected)
		{
			setSelectedIndex(toIndex);
		}
		else if (selectedIndex > fromIndex && selectedIndex <= toIndex)
		{
			setSelectedIndex(selectedIndex - 1);
		}
		else if (selectedIndex < fromIndex && selectedIndex >= toIndex)
		{
			setSelectedIndex(selectedIndex + 1);
		}
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

		// Draw drop indicator
		if (dropTargetIndex >= 0)
		{
			drawDropIndicator(g2d);
		}

		// Draw drag image
		if (dragImage != null && currentDragPoint != null)
		{
			int x = currentDragPoint.x - dragImageOffset.x;
			int y = currentDragPoint.y - dragImageOffset.y;
			g2d.drawImage(dragImage, x, y, null);
		}

		g2d.dispose();
	}

	private void drawDropIndicator(Graphics2D g)
	{
		int tabPlacement = getTabPlacement();
		boolean verticalTabs = (tabPlacement == LEFT || tabPlacement == RIGHT);

		Rectangle indicatorBounds = getDropIndicatorBounds();
		if (indicatorBounds == null)
		{
			return;
		}

		g.setColor(ColorScheme.BRAND_ORANGE);

		if (verticalTabs)
		{
			// Horizontal line indicator
			Area arrowArea = getArea(indicatorBounds);
			g.fill(arrowArea);
		}
		else
		{
			// Vertical line indicator
			int x = indicatorBounds.x;
			int y1 = indicatorBounds.y;
			int y2 = indicatorBounds.y + indicatorBounds.height;

			// Draw line
			g.fillRect(x - 1, y1, 3, y2 - y1);

			// Draw arrow points
			int[] xPoints = {x, x - 4, x + 4};
			int[] yPoints = {y1, y1 + 6, y1 + 6};
			g.fillPolygon(xPoints, yPoints, 3);
		}
	}

	private static @NotNull Area getArea(Rectangle indicatorBounds)
	{
		int x = indicatorBounds.x;
		int y = indicatorBounds.y;
		int lineWidth = indicatorBounds.width - (LINE_PADDING * 2);

		Rectangle rect = new Rectangle(x + LINE_PADDING, y - LINE_THICKNESS, lineWidth, LINE_THICKNESS * 2);

		// triangle, pointing right
		Polygon arrowHead = new Polygon();
		arrowHead.addPoint(x, y - ARROW_HEAD_WIDTH);   // top-left
		arrowHead.addPoint(x + ARROW_HEAD_HEIGHT, y);  // point
		arrowHead.addPoint(x, y + ARROW_HEAD_WIDTH);   // bottom-left

		Area arrowArea = new Area(arrowHead);
		Area rectArea = new Area(rect);
		arrowArea.add(rectArea);
		return arrowArea;
	}

	private Rectangle getDropIndicatorBounds()
	{
		if (dropTargetIndex < 0)
		{
			return null;
		}

		int tabPlacement = getTabPlacement();
		boolean vertical = (tabPlacement == LEFT || tabPlacement == RIGHT);

		Rectangle bounds;
		if (dropTargetIndex >= getTabCount())
		{
			// After last tab
			bounds = getBoundsAt(getTabCount() - 1);
			if (bounds == null)
			{
				return null;
			}
			if (vertical)
			{
				return new Rectangle(bounds.x, bounds.y + bounds.height, bounds.width, 0);
			}
			else
			{
				return new Rectangle(bounds.x + bounds.width, bounds.y, 0, bounds.height);
			}
		}
		else
		{
			bounds = getBoundsAt(dropTargetIndex);
			if (bounds == null)
			{
				return null;
			}
			if (vertical)
			{
				return new Rectangle(bounds.x, bounds.y, bounds.width, 0);
			}
			else
			{
				return new Rectangle(bounds.x, bounds.y, 0, bounds.height);
			}
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
		 * @param fromIndex the original index of the tab
		 * @param toIndex   the new index of the tab
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
			selectedIndexOnPress = getSelectedIndex();

			if (getTabCount() > 1 && isDragAllowed())
			{
				// Use indexAtLocation which is JTabbedPane's built-in hit test
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
				// Capture the drag image before restoring selection, since
				// setSelectedIndex triggers a layout change that can invalidate
				// tab bounds and icon references during fast drags
				prepareDragImage();

				if (getSelectedIndex() != selectedIndexOnPress)
				{
					setSelectedIndex(selectedIndexOnPress);
				}
				startDragging(point);
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
				else
				{
					dragStartPoint = null;
					pressedTabIndex = -1;
				}
			}
		}
	}
}

