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
import org.intellij.lang.annotations.MagicConstant;

/**
 * A JTabbedPane that supports drag-and-drop reordering of tabs.
 * <p>
 * During a drag, a floating image of the dragged tab follows the cursor
 * and a highlight marks the drop target. The actual tab move only happens
 * once on drop, avoiding expensive intermediate layout passes.
 * <p>
 * This implementation also suppresses tab selection changes while dragging to
 * prevent the displayed tab from changing during the drag operation. This is
 * done by intercepting mouse events and overriding setSelectedIndex to ignore
 * changes while a drag is in progress or potentially starting.
 */
@Slf4j
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
	@Setter
	private Supplier<Boolean> dragAllowedSupplier;

	/**
	 * Restrict arg vals to allowed values in {@link JTabbedPane}
	 */
	public DragAndDropTabbedPane(@MagicConstant(intValues = {TOP, BOTTOM, LEFT, RIGHT}) int tabPlacement)
	{
		super(tabPlacement);
		MouseAdapter mouseAdapter = new DragAndDropTabMouseAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
		this.dragAllowedSupplier = (() -> false);
	}

	// Suppress changing tab while dragging or potentially dragging.
	@Override
	public void setSelectedIndex(int index)
	{
		if (!potentialDrag && !dragging)
		{
			super.setSelectedIndex(index);
		}
	}

	// If drag is allowed, set potentialDrag on MOUSE_PRESSED events before the event reaches the UI delegate's mouse listener.
	// This allows suppressing undesired tab selection behavior only when dragging is possible, e.g. when hotkey is held.
	@Override
	protected void processMouseEvent(MouseEvent e)
	{
		if (dragAllowedSupplier.get() && e.getID() == MouseEvent.MOUSE_PRESSED &&
			SwingUtilities.isLeftMouseButton(e) && getTabCount() > 1)
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

	public void removeDragListener(DragListener listener)
	{
		dragListeners.remove(listener);
	}

	private void startDragging(Point point)
	{
		dragIndex = indexAtLocation(dragStartPoint.x, dragStartPoint.y);
		if (dragIndex >= 0)
		{
			log.debug("startDragging: dragIndex={}", dragIndex);
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
	}

	private void drag(Point point)
	{
		currentDragPoint = point;
		int newDropTarget = calculateDropTargetIndex(point);
		if (newDropTarget != dropTargetIndex)
		{
			log.debug("drag: dropTargetIndex changed from {} to {}, dragIndex={}, tabCount={}",
				dropTargetIndex, newDropTarget, dragIndex, getTabCount());
			dropTargetIndex = newDropTarget;
		}
		repaint();
	}

	private void finishDragging()
	{
		potentialDrag = false;
		if (dragging)
		{
			int fromIndex = dragIndex;
			int toIndex = dropTargetIndex;

			if (fromIndex != toIndex && fromIndex >= 0 && toIndex >= 0)
			{
				moveTab(fromIndex, toIndex);
				dragListeners.forEach(listener -> listener.onDrag(fromIndex, toIndex));
			}

			dragging = false;
			dragImage = null;
			repaint();
		}
	}

	private int calculateDropTargetIndex(Point point)
	{
		int tabCount = getTabCount();
		for (int i = 0; i < tabCount; i++)
		{
			Rectangle bounds = getBoundsAt(i);
			if (bounds != null)
			{
				int midY = bounds.y + bounds.height / 2;
				if (point.y < midY)
				{
					return i;
				}
			}
		}
		return tabCount;
	}

	private void moveTab(int fromIndex, int toIndex)
	{
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

	// Begin graphical functions

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
		boolean showIndicator = dropTargetIndex >= 0 && dropTargetIndex != dragIndex && dropTargetIndex != dragIndex + 1;
		log.debug("paint: dropTargetIndex={}, dragIndex={}, showIndicator={}", dropTargetIndex, dragIndex, showIndicator);

		if (showIndicator)
		{
			drawDropIndicator(g2d);
		}

		// Draw floating dragged icon
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
		final int IND_THICKNESS = 2; // ensure even, otherwise, indicator won't  be centered
		final int OFFSET = IND_THICKNESS / 2; // used to center indicator between tabs
		int tabPlacement = getTabPlacement();
		int tabCount = getTabCount();
		boolean verticalTabs = (tabPlacement == LEFT || tabPlacement == RIGHT);
		boolean beyondEnd = dropTargetIndex >= tabCount;

		Rectangle tab = getBoundsAt(beyondEnd ? tabCount - 1 : dropTargetIndex);
		if (tab != null)
		{
			int indicatorPosition = beyondEnd
				? (verticalTabs ? tab.y + tab.height : tab.x + tab.width) - OFFSET // get coord at end of last tab
				: (verticalTabs ? tab.y : tab.x) - OFFSET;

			g.setColor(ColorScheme.BRAND_ORANGE);
			if (verticalTabs)
			{
				g.fillRect(tab.x, indicatorPosition, tab.width, IND_THICKNESS);
			}
			else
			{
				g.fillRect(indicatorPosition, tab.y, IND_THICKNESS, tab.height);
			}
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
			if (dragAllowedSupplier.get() && SwingUtilities.isLeftMouseButton(e) && getTabCount() > 1)
			{
				dragStartPoint = e.getPoint();
			}
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if (dragAllowedSupplier.get() && SwingUtilities.isLeftMouseButton(e) && dragStartPoint != null)
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
			if (dragAllowedSupplier.get() && SwingUtilities.isLeftMouseButton(e))
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
