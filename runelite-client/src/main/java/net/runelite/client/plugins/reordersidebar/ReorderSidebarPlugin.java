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

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.inject.Provides;
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
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;

@PluginDescriptor(
	name = "Reorder Sidebar",
	description = "Allows reordering of sidebar icons via drag and drop",
	tags = {"sidebar", "icons", "reorder", "drag", "drop"}
)
@Slf4j
public class ReorderSidebarPlugin extends Plugin
{
	static final String CONFIG_GROUP = "reorder";
	private static final String CONFIG_KEY_CUSTOM_ORDER = "customOrder";
	private static final String CONFIG_KEY_ORIGINAL_PRIORITIES = "originalPriorities";
	private static final String ENTRY_SEPARATOR = ",";
	private static final String PRIORITY_SEPARATOR = ":";
	private static final Color DROP_INDICATOR_COLOR = new Color(255, 200, 0, 200);
	private static final int INDICATOR_THICKNESS = 3;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ReorderSidebarConfig config;

	@Inject
	private ClientUI clientUI;

	// Order management state
	private final Map<String, Integer> originalPriorities = new HashMap<>();
	private List<String> customOrder = new ArrayList<>();
	private boolean hasCustomOrder = false;
	private boolean configLoaded = false;

	// Drag state
	private JTabbedPane sidebar;
	private List<NavigationButton> sidebarTabOrder;
	private TabReorderHandler transferHandler;
	private DropIndicatorGlassPane glassPane;

	@Provides
	ReorderSidebarConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ReorderSidebarConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		// Get sidebar and tab order from ClientUI
		sidebar = clientUI.getSidebar();
		sidebarTabOrder = clientUI.getSidebarTabOrder();

		if (sidebar != null && sidebarTabOrder != null)
		{
			installDragHandler();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		// Remove our transfer handler
		if (sidebar != null)
		{
			sidebar.setTransferHandler(null);
		}
	}

	private void installDragHandler()
	{
		transferHandler = new TabReorderHandler();
		sidebar.setTransferHandler(transferHandler);
		transferHandler.installDropIndicator();

		// Add mouse motion listener for drag initiation
		sidebar.addMouseMotionListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent e)
			{
				if (!isDragAllowed(e))
				{
					return;
				}

				int index = sidebar.indexAtLocation(e.getX(), e.getY());
				if (index != -1)
				{
					sidebar.setSelectedIndex(index);
					TransferHandler handler = sidebar.getTransferHandler();
					handler.exportAsDrag(sidebar, e, TransferHandler.MOVE);
				}
			}
		});
	}

	private boolean isDragAllowed(MouseEvent e)
	{
		if (config.dragOnShiftOnly())
		{
			return e.isShiftDown();
		}
		return true;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(CONFIG_GROUP))
		{
			return;
		}

		if (event.getKey().equals("resetIconOrder") && "true".equals(event.getNewValue()))
		{
			resetToDefaultOrder();
			rebuildSidebar();
			// Reset the toggle back to false
			configManager.setConfiguration(CONFIG_GROUP, "resetIconOrder", false);
		}
	}

	// ==================== Order Management ====================

	private void ensureConfigLoaded()
	{
		if (!configLoaded)
		{
			loadFromConfig();
			configLoaded = true;
		}
	}

	private void loadFromConfig()
	{
		try
		{
			// Load original priorities
			String prioritiesStr = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY_ORIGINAL_PRIORITIES);
			if (!Strings.isNullOrEmpty(prioritiesStr))
			{
				for (String entry : Splitter.on(ENTRY_SEPARATOR).omitEmptyStrings().split(prioritiesStr))
				{
					int separatorIndex = entry.lastIndexOf(PRIORITY_SEPARATOR);
					if (separatorIndex > 0)
					{
						String tooltip = entry.substring(0, separatorIndex);
						try
						{
							int priority = Integer.parseInt(entry.substring(separatorIndex + 1));
							originalPriorities.put(tooltip, priority);
						}
						catch (NumberFormatException e)
						{
							log.warn("Invalid priority format in sidebar config: {}", entry);
						}
					}
				}
			}

			// Load custom order
			String orderStr = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
			if (!Strings.isNullOrEmpty(orderStr))
			{
				customOrder = new ArrayList<>(Splitter.on(ENTRY_SEPARATOR).omitEmptyStrings().splitToList(orderStr));
				hasCustomOrder = !customOrder.isEmpty();
			}

			log.debug("Loaded sidebar order: {} original priorities, {} custom order entries, hasCustomOrder={}",
				originalPriorities.size(), customOrder.size(), hasCustomOrder);
		}
		catch (Exception e)
		{
			log.warn("Failed to load sidebar order config, using defaults", e);
		}
	}

	public void registerOriginalPriority(NavigationButton navBtn)
	{
		ensureConfigLoaded();
		String tooltip = navBtn.getTooltip();
		if (!originalPriorities.containsKey(tooltip))
		{
			originalPriorities.put(tooltip, navBtn.getPriority());
			saveOriginalPriorities();
		}
	}

	public int getInsertionIndex(NavigationButton navBtn, List<NavigationButton> currentButtons)
	{
		ensureConfigLoaded();
		String tooltip = navBtn.getTooltip();

		// Check if this button already has a position in the custom order
		int existingIndex = customOrder.indexOf(tooltip);
		if (existingIndex >= 0)
		{
			// Find the correct position based on what buttons are currently present
			int adjustedIndex = 0;
			for (int i = 0; i < existingIndex && i < customOrder.size(); i++)
			{
				String orderTooltip = customOrder.get(i);
				for (NavigationButton btn : currentButtons)
				{
					if (btn.getTooltip().equals(orderTooltip))
					{
						adjustedIndex++;
						break;
					}
				}
			}
			return Math.min(adjustedIndex, currentButtons.size());
		}

		// If no custom order or button not in custom order, use priority-based insertion
		if (!hasCustomOrder)
		{
			return -1; // Use default TreeSet ordering
		}

		// Insert new button based on its original priority relative to existing buttons
		int btnPriority = navBtn.getPriority();
		for (int i = 0; i < currentButtons.size(); i++)
		{
			NavigationButton existing = currentButtons.get(i);
			int existingPriority = originalPriorities.getOrDefault(existing.getTooltip(), existing.getPriority());
			if (btnPriority < existingPriority)
			{
				return i;
			}
			else if (btnPriority == existingPriority)
			{
				// Same priority, compare by tooltip
				if (tooltip.compareTo(existing.getTooltip()) < 0)
				{
					return i;
				}
			}
		}

		return currentButtons.size();
	}

	public void saveCustomOrder(List<NavigationButton> orderedButtons)
	{
		ensureConfigLoaded();
		customOrder = orderedButtons.stream()
			.map(NavigationButton::getTooltip)
			.collect(Collectors.toList());

		hasCustomOrder = true;

		String orderStr = String.join(ENTRY_SEPARATOR, customOrder);
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, orderStr);

		log.debug("Saved custom sidebar order: {} entries", customOrder.size());
	}

	private void saveOriginalPriorities()
	{
		String prioritiesStr = originalPriorities.entrySet().stream()
			.map(e -> e.getKey() + PRIORITY_SEPARATOR + e.getValue())
			.collect(Collectors.joining(ENTRY_SEPARATOR));

		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_ORIGINAL_PRIORITIES, prioritiesStr);
	}

	public boolean hasCustomOrder()
	{
		ensureConfigLoaded();
		return hasCustomOrder;
	}

	public void resetToDefaultOrder()
	{
		ensureConfigLoaded();
		customOrder.clear();
		hasCustomOrder = false;
		configManager.unsetConfiguration(CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
		log.debug("Reset sidebar to default order");
	}

	public void removeButton(NavigationButton navBtn)
	{
		ensureConfigLoaded();
		String tooltip = navBtn.getTooltip();
		customOrder.remove(tooltip);

		if (hasCustomOrder)
		{
			String orderStr = String.join(ENTRY_SEPARATOR, customOrder);
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, orderStr);
		}
	}

	public int getOriginalPriority(String tooltip)
	{
		ensureConfigLoaded();
		return originalPriorities.getOrDefault(tooltip, Integer.MAX_VALUE);
	}

	public List<NavigationButton> getOrderedButtons(Collection<NavigationButton> buttons)
	{
		ensureConfigLoaded();
		if (!hasCustomOrder || customOrder.isEmpty())
		{
			return new ArrayList<>(buttons);
		}

		List<NavigationButton> ordered = new ArrayList<>();
		Map<String, NavigationButton> buttonMap = new HashMap<>();
		for (NavigationButton btn : buttons)
		{
			buttonMap.put(btn.getTooltip(), btn);
		}

		// Add buttons in custom order
		for (String tooltip : customOrder)
		{
			NavigationButton btn = buttonMap.remove(tooltip);
			if (btn != null)
			{
				ordered.add(btn);
			}
		}

		// Add any remaining buttons (new plugins) in priority order
		List<NavigationButton> remaining = new ArrayList<>(buttonMap.values());
		remaining.sort((a, b) ->
		{
			int cmp = Integer.compare(a.getPriority(), b.getPriority());
			if (cmp != 0)
			{
				return cmp;
			}
			return a.getTooltip().compareTo(b.getTooltip());
		});

		// Insert remaining buttons at appropriate positions based on priority
		for (NavigationButton btn : remaining)
		{
			int insertIndex = getInsertionIndex(btn, ordered);
			if (insertIndex < 0 || insertIndex >= ordered.size())
			{
				ordered.add(btn);
			}
			else
			{
				ordered.add(insertIndex, btn);
			}
		}

		return ordered;
	}

	private void rebuildSidebar()
	{
		if (sidebar == null || sidebarTabOrder == null)
		{
			return;
		}

		// Rebuild the sidebar with default order
		clientUI.rebuildSidebar();
	}

	// ==================== Tab Reorder Handler ====================

	private class TabReorderHandler extends TransferHandler
	{
		private int sourceIndex;

		void installDropIndicator()
		{
			// Get the existing drop target created by the TransferHandler
			DropTarget existingDropTarget = sidebar.getDropTarget();
			// Create a new drop target that adds our visual indicator functionality
			// while still delegating to the TransferHandler's drop handling
			DropTarget newDropTarget = new DropTarget(sidebar, DnDConstants.ACTION_MOVE,
				new IndicatorDropTargetListener(existingDropTarget), true);
			sidebar.setDropTarget(newDropTarget);
		}

		private void ensureGlassPane()
		{
			if (glassPane == null && sidebar != null)
			{
				JRootPane rootPane = SwingUtilities.getRootPane(sidebar);
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

			// Update the sidebarTabOrder list
			NavigationButton navBtn = sidebarTabOrder.get(sourceIndex);
			sidebarTabOrder.remove(sourceIndex);
			sidebarTabOrder.add(targetIndex, navBtn);

			// Save the new custom order
			saveCustomOrder(sidebarTabOrder);

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
			if (glassPane != null && sidebar != null)
			{
				Point tabLocation = new Point(bounds.x, bounds.y);
				SwingUtilities.convertPointToScreen(tabLocation, sidebar);
				SwingUtilities.convertPointFromScreen(tabLocation, glassPane);

				Rectangle glassPaneBounds = new Rectangle(tabLocation.x, tabLocation.y, bounds.width, bounds.height);
				glassPane.showIndicator(glassPaneBounds, above, sidebar.getTabPlacement());
			}
		}

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
				if (sidebar == null)
				{
					return;
				}

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

				boolean above;
				int tabPlacement = sidebar.getTabPlacement();
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

	// ==================== Drop Indicator Glass Pane ====================

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
				int x = showAbove ? tabBounds.x : tabBounds.x + tabBounds.width;
				int y = tabBounds.y;
				int height = tabBounds.height;

				xPoints = new int[]{x - 6, x, x + 6, x + 6, x + INDICATOR_THICKNESS, x + INDICATOR_THICKNESS, x - INDICATOR_THICKNESS, x - INDICATOR_THICKNESS, x - 6};
				yPoints = new int[]{y, y + 8, y, y + 4, y + 4, height - 4 + y, height - 4 + y, y + 4, y + 4};
				g2d.fillPolygon(xPoints, yPoints, 9);
			}
			else
			{
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
}


