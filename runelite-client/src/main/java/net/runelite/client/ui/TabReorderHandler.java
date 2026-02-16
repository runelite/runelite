/*
 * Copyright (c) 2024, Smoke (Smoked today) <https://github.com/Varietyz>
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
package net.runelite.client.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

class TabReorderHandler extends TransferHandler
{
	private static final Color DROP_INDICATOR_COLOR = new Color(255, 200, 0, 200);
	private static final int INDICATOR_THICKNESS = 3;

	private int sourceIndex;
	private final NavigableSet<NavigationButton> sidebarEntries;
	private DropIndicatorGlassPane glassPane;
	private JTabbedPane tabbedPane;

	public TabReorderHandler(NavigableSet<NavigationButton> sidebarEntries)
	{
		this.sidebarEntries = sidebarEntries;
	}

	/**
	 * Installs the drop indicator overlay on the given tabbed pane.
	 * Call this after setting the transfer handler on the JTabbedPane.
	 */
	public void installDropIndicator(JTabbedPane tabbedPane)
	{
		this.tabbedPane = tabbedPane;
		// Get the existing drop target created by the TransferHandler
		DropTarget existingDropTarget = tabbedPane.getDropTarget();
		// Create a new drop target that adds our visual indicator functionality
		// while still delegating to the TransferHandler's drop handling
		DropTarget newDropTarget = new DropTarget(tabbedPane, DnDConstants.ACTION_MOVE,
			new IndicatorDropTargetListener(existingDropTarget), true);
		tabbedPane.setDropTarget(newDropTarget);
	}

	private void ensureGlassPane()
	{
		if (glassPane == null && tabbedPane != null)
		{
			JRootPane rootPane = SwingUtilities.getRootPane(tabbedPane);
			if (rootPane != null)
			{
				glassPane = new DropIndicatorGlassPane();
				rootPane.setGlassPane(glassPane);
			}
		}
	}

	@Override
	protected Transferable createTransferable(JComponent c)
	{
		JTabbedPane pane = (JTabbedPane) c;
		sourceIndex = pane.getSelectedIndex();

		// Capture the icon for drag image
		Icon icon = pane.getIconAt(sourceIndex);
		if (icon != null)
		{
			BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = img.createGraphics();
			icon.paintIcon(pane, g, 0, 0);
			g.dispose();
			setDragImage(img);
		}

		return new StringSelection(Integer.toString(sourceIndex));
	}

	@Override
	public boolean canImport(TransferSupport support)
	{
		return support.isDrop();
	}

	@Override
	public boolean importData(TransferSupport support)
	{
		if (!canImport(support))
		{
			return false;
		}

		JTabbedPane pane = (JTabbedPane) support.getComponent();
		Icon icon = pane.getIconAt(sourceIndex);
		DropLocation dropLocation = support.getDropLocation();
		Point dropPoint = dropLocation.getDropPoint();
		int hoveredIndex = pane.indexAtLocation((int) dropPoint.getX(), (int) dropPoint.getY());

		// Hide the drop indicator
		hideDropIndicator();

		if (hoveredIndex == -1 || sourceIndex == -1)
		{
			return false;
		}

		// Calculate the actual target index based on drop position within the tab
		// This matches the logic used in the visual indicator
		Rectangle tabBounds = pane.getBoundsAt(hoveredIndex);
		if (tabBounds == null)
		{
			return false;
		}

		int targetIndex;
		int tabPlacement = pane.getTabPlacement();
		boolean dropInUpperHalf;

		if (tabPlacement == JTabbedPane.TOP || tabPlacement == JTabbedPane.BOTTOM)
		{
			dropInUpperHalf = dropPoint.getX() < tabBounds.x + tabBounds.width / 2;
		}
		else
		{
			dropInUpperHalf = dropPoint.getY() < tabBounds.y + tabBounds.height / 2;
		}

		// If dropping in upper half, insert before the hovered tab; otherwise insert after
		if (dropInUpperHalf)
		{
			targetIndex = hoveredIndex;
		}
		else
		{
			targetIndex = hoveredIndex + 1;
		}

		// Adjust target index if we're moving from before the target position
		// (because removing the source shifts indices down)
		if (sourceIndex < targetIndex)
		{
			targetIndex--;
		}

		// Don't move if source and target are the same
		if (sourceIndex == targetIndex)
		{
			return false;
		}

		Component tab = pane.getComponentAt(sourceIndex);
		String title = pane.getTitleAt(sourceIndex);
		String toolTip = pane.getToolTipTextAt(sourceIndex);

		pane.remove(sourceIndex);
		pane.insertTab(title, icon, tab, toolTip, targetIndex);

		// Convert NavigableSet to List for index-based reordering
		List<NavigationButton> orderedList = new ArrayList<>(sidebarEntries);
		NavigationButton navBtn = orderedList.get(sourceIndex);
		orderedList.remove(sourceIndex);
		orderedList.add(targetIndex, navBtn);

		// Save the new order
		SidebarOrderManager orderManager = new SidebarOrderManager();
		orderManager.saveOrder(orderedList);

		pane.setSelectedIndex(targetIndex);
		return true;
	}

	@Override
	public int getSourceActions(JComponent c)
	{
		return TransferHandler.MOVE;
	}

	@Override
	protected void exportDone(JComponent source, Transferable data, int action)
	{
		super.exportDone(source, data, action);
		hideDropIndicator();
	}

	private void hideDropIndicator()
	{
		if (glassPane != null)
		{
			glassPane.hideIndicator();
		}
	}

	private void showDropIndicator(Rectangle bounds, boolean above)
	{
		ensureGlassPane();
		if (glassPane != null && tabbedPane != null)
		{
			// Convert tab bounds to glass pane coordinates
			Point tabLocation = new Point(bounds.x, bounds.y);
			SwingUtilities.convertPointToScreen(tabLocation, tabbedPane);
			SwingUtilities.convertPointFromScreen(tabLocation, glassPane);

			Rectangle glassPaneBounds = new Rectangle(tabLocation.x, tabLocation.y, bounds.width, bounds.height);
			glassPane.showIndicator(glassPaneBounds, above, tabbedPane.getTabPlacement());
		}
	}

	/**
	 * Glass pane that draws the drop indicator.
	 */
	private static class DropIndicatorGlassPane extends JPanel
	{
		private Rectangle tabBounds;
		private boolean showAbove;
		private int tabPlacement;

		DropIndicatorGlassPane()
		{
			setOpaque(false);
			setVisible(false);
		}

		void showIndicator(Rectangle bounds, boolean above, int placement)
		{
			this.tabBounds = bounds;
			this.showAbove = above;
			this.tabPlacement = placement;
			setVisible(true);
			repaint();
		}

		void hideIndicator()
		{
			this.tabBounds = null;
			setVisible(false);
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			if (tabBounds == null)
			{
				return;
			}

			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(DROP_INDICATOR_COLOR);

			int[] xPoints;
			int[] yPoints;

			if (tabPlacement == JTabbedPane.TOP || tabPlacement == JTabbedPane.BOTTOM)
			{
				// Horizontal tabs - draw vertical wedge
				int x = showAbove ? tabBounds.x : tabBounds.x + tabBounds.width;
				int y = tabBounds.y;
				int height = tabBounds.height;

				xPoints = new int[]{x - 6, x, x + 6, x + 6, x + INDICATOR_THICKNESS, x + INDICATOR_THICKNESS, x - INDICATOR_THICKNESS, x - INDICATOR_THICKNESS, x - 6};
				yPoints = new int[]{y, y + 8, y, y + 4, y + 4, height - 4 + y, height - 4 + y, y + 4, y + 4};
				g2d.fillPolygon(xPoints, yPoints, 9);
			}
			else
			{
				// Vertical tabs (LEFT or RIGHT) - draw horizontal wedge
				int x = tabBounds.x;
				int y = showAbove ? tabBounds.y : tabBounds.y + tabBounds.height;
				int width = tabBounds.width;

				xPoints = new int[]{x, x + 8, x, x + 4, x + 4, width - 4 + x, width - 4 + x, x + 4, x + 4};
				yPoints = new int[]{y - 6, y, y + 6, y + 6, y + INDICATOR_THICKNESS, y + INDICATOR_THICKNESS, y - INDICATOR_THICKNESS, y - INDICATOR_THICKNESS, y - 6};
				g2d.fillPolygon(xPoints, yPoints, 9);
			}

			g2d.dispose();
		}
	}

	/**
	 * Listener for drag events to show the drop indicator while delegating
	 * drop handling to the original TransferHandler's drop target.
	 */
	private class IndicatorDropTargetListener implements DropTargetListener
	{
		private final DropTarget originalDropTarget;

		IndicatorDropTargetListener(DropTarget originalDropTarget)
		{
			this.originalDropTarget = originalDropTarget;
		}

		@Override
		public void dragEnter(DropTargetDragEvent dtde)
		{
			updateDropIndicator(dtde.getLocation());
			// Delegate to original
			if (originalDropTarget != null)
			{
				originalDropTarget.dragEnter(dtde);
			}
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde)
		{
			updateDropIndicator(dtde.getLocation());
			// Delegate to original
			if (originalDropTarget != null)
			{
				originalDropTarget.dragOver(dtde);
			}
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde)
		{
			// Delegate to original
			if (originalDropTarget != null)
			{
				originalDropTarget.dropActionChanged(dtde);
			}
		}

		@Override
		public void dragExit(DropTargetEvent dte)
		{
			hideDropIndicator();
			// Delegate to original
			if (originalDropTarget != null)
			{
				originalDropTarget.dragExit(dte);
			}
		}

		@Override
		public void drop(DropTargetDropEvent dtde)
		{
			hideDropIndicator();
			// Delegate to original TransferHandler's drop handling
			if (originalDropTarget != null)
			{
				originalDropTarget.drop(dtde);
			}
		}

		private void updateDropIndicator(Point location)
		{
			if (tabbedPane == null)
			{
				return;
			}

			int targetIndex = tabbedPane.indexAtLocation(location.x, location.y);
			if (targetIndex == -1)
			{
				hideDropIndicator();
				return;
			}

			Rectangle tabBounds = tabbedPane.getBoundsAt(targetIndex);
			if (tabBounds == null)
			{
				hideDropIndicator();
				return;
			}

			// Determine if we're in the top/left half or bottom/right half of the tab
			boolean above;
			int tabPlacement = tabbedPane.getTabPlacement();
			if (tabPlacement == JTabbedPane.TOP || tabPlacement == JTabbedPane.BOTTOM)
			{
				above = location.x < tabBounds.x + tabBounds.width / 2;
			}
			else
			{
				above = location.y < tabBounds.y + tabBounds.height / 2;
			}

			showDropIndicator(tabBounds, above);
		}
	}
}