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
package net.runelite.client.plugins.reordersidebar;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ColorUtil;

/**
 * Handles the drag-and-drop reordering of sidebar tabs.
 */
class TabReorderHandler extends TransferHandler
{
	private final ReorderSidebar reorderSidebar;
	private final JTabbedPane sidebar;
	private final List<NavigationButton> sidebarTabOrder;
	private final DropIndicatorGlassPane glassPane;

	private int sourceIndex;

	TabReorderHandler(ReorderSidebar reorderSidebar, JTabbedPane sidebar,
		List<NavigationButton> sidebarTabOrder, DropIndicatorGlassPane glassPane)
	{
		this.reorderSidebar = reorderSidebar;
		this.sidebar = sidebar;
		this.sidebarTabOrder = sidebarTabOrder;
		this.glassPane = glassPane;
	}

	private boolean isDropInUpperHalf(Point dropPoint, Rectangle tabBounds, int tabPlacement)
	{
		boolean isHorizontal = tabPlacement == JTabbedPane.TOP || tabPlacement == JTabbedPane.BOTTOM;
		return isHorizontal
			? dropPoint.getX() < tabBounds.x + tabBounds.width / 2.0
			: dropPoint.getY() < tabBounds.y + tabBounds.height / 2.0;
	}

	/**
	 * Installs a custom DropTarget on the sidebar to show the drop indicator during drag operations.
	 * This is necessary because the default DropTarget does not provide the necessary hooks for custom indicators.
	 */
	void installDropIndicator()
	{
		DropTarget existingDropTarget = sidebar.getDropTarget();
		sidebar.setDropTarget(new DropTarget(sidebar, DnDConstants.ACTION_MOVE,
			new IndicatorDropTargetListener(existingDropTarget), true));
	}

	@Override
	protected Transferable createTransferable(JComponent c)
	{
		JTabbedPane pane = (JTabbedPane) c;

		// Use the index captured at mouse press, not getSelectedIndex()
		// prevents moving wrong tab when user moves mouse quickly
		int pendingIndex = reorderSidebar.getPendingDragSourceIndex();
		sourceIndex = pendingIndex != -1 ? pendingIndex : pane.getSelectedIndex();
		reorderSidebar.clearPendingDragSourceIndex();

		if (sourceIndex < 0 || sourceIndex >= pane.getTabCount())
		{
			return null;
		}

		Icon icon = pane.getIconAt(sourceIndex);
		if (icon != null)
		{
			int pad = 4;
			int w = icon.getIconWidth() + pad * 2;
			int h = icon.getIconHeight() + pad * 2;
			BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = img.createGraphics();
			g.setColor(ColorUtil.colorWithAlpha(ColorScheme.LIGHT_GRAY_COLOR, 128));
			g.fillRoundRect(0, 0, w, h, 6, 6);
			icon.paintIcon(pane, g, pad, pad);
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

		// Secondary safeguard: don't allow drop if custom order is disabled
		if (!reorderSidebar.getConfig().useCustomTabOrder())
		{
			hideDropIndicator();
			return false;
		}

		JTabbedPane pane = (JTabbedPane) support.getComponent();
		Icon icon = pane.getIconAt(sourceIndex);
		Point dropPoint = support.getDropLocation().getDropPoint();
		int hoveredIndex = pane.indexAtLocation((int) dropPoint.getX(), (int) dropPoint.getY());

		hideDropIndicator();

		if (hoveredIndex == -1 || sourceIndex == -1)
		{
			return false;
		}

		Rectangle tabBounds = pane.getBoundsAt(hoveredIndex);
		if (tabBounds == null)
		{
			return false;
		}

		// Determine target index based on drop position
		int tabPlacement = pane.getTabPlacement();
		boolean dropInUpperHalf = isDropInUpperHalf(dropPoint, tabBounds, tabPlacement);

		int targetIndex = dropInUpperHalf ? hoveredIndex : hoveredIndex + 1;
		if (sourceIndex < targetIndex)
		{
			targetIndex--;
		}

		if (sourceIndex == targetIndex)
		{
			return false;
		}

		// Move the tab
		Component tab = pane.getComponentAt(sourceIndex);
		String title = pane.getTitleAt(sourceIndex);
		String toolTip = pane.getToolTipTextAt(sourceIndex);

		pane.remove(sourceIndex);
		pane.insertTab(title, icon, tab, toolTip, targetIndex);

		// Update internal order
		NavigationButton navBtn = sidebarTabOrder.remove(sourceIndex);
		sidebarTabOrder.add(targetIndex, navBtn);

		// Save the new order
		reorderSidebar.setCustomOrderTabs(sidebarTabOrder);
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
		if (glassPane != null && sidebar != null)
		{
			Point tabLocation = new Point(bounds.x, bounds.y);
			SwingUtilities.convertPointToScreen(tabLocation, sidebar);
			SwingUtilities.convertPointFromScreen(tabLocation, glassPane);
			glassPane.showIndicator(
				new Rectangle(tabLocation.x, tabLocation.y, bounds.width, bounds.height),
				above);
		}
	}

	/**
	 * Listens for drag events and updates the drop indicator position.
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
			if (originalDropTarget != null)
			{
				originalDropTarget.dragEnter(dtde);
			}
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde)
		{
			updateDropIndicator(dtde.getLocation());
			if (originalDropTarget != null)
			{
				originalDropTarget.dragOver(dtde);
			}
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde)
		{
			if (originalDropTarget != null)
			{
				originalDropTarget.dropActionChanged(dtde);
			}
		}

		@Override
		public void dragExit(DropTargetEvent dte)
		{
			hideDropIndicator();
			if (originalDropTarget != null)
			{
				originalDropTarget.dragExit(dte);
			}
		}

		@Override
		public void drop(DropTargetDropEvent dtde)
		{
			hideDropIndicator();
			if (originalDropTarget != null)
			{
				originalDropTarget.drop(dtde);
			}
		}

		private void updateDropIndicator(Point location)
		{
			int targetIndex = sidebar.indexAtLocation(location.x, location.y);
			if (targetIndex == -1)
			{
				hideDropIndicator();
				return;
			}

			Rectangle tabBounds = sidebar.getBoundsAt(targetIndex);
			if (tabBounds == null)
			{
				hideDropIndicator();
				return;
			}

			boolean above = isDropInUpperHalf(location, tabBounds, sidebar.getTabPlacement());
			showDropIndicator(tabBounds, above);
		}
	}
}

