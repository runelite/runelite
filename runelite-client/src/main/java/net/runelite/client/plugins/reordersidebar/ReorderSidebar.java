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

import com.google.common.reflect.TypeToken;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;

/**
 * Handles sidebar icon reordering via drag and drop.
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Inject))
class ReorderSidebar
{
	private static final String CONFIG_KEY_CUSTOM_ORDER = "customOrder";
	private static final Color DROP_INDICATOR_COLOR = new Color(255, 200, 0, 200);
	private static final int INDICATOR_THICKNESS = 3;

	private final ConfigManager configManager;
	@Getter
	private final ReorderSidebarConfig config;
	private final ClientUI clientUI;

	private JTabbedPane sidebar;
	private List<NavigationButton> sidebarTabOrder;
	private DropIndicatorGlassPane glassPane;
	private MouseAdapter dragMouseListener;
	private int pendingDragSourceIndex = -1;

	/**
	 * Check if the configured drag hotkey is currently pressed.
	 * Uses the MouseEvent modifiers since Swing components don't use the game's KeyManager.
	 */
	private boolean isHotkeyPressed(MouseEvent e)
	{
		Keybind hotkey = config.dragHotkey();
		if (hotkey == null || hotkey.equals(Keybind.NOT_SET))
		{
			return true; // No hotkey configured, allow drag
		}

		int modifiers = e.getModifiersEx();

		// Check modifier keys
		if (hotkey.equals(Keybind.SHIFT) && (modifiers & MouseEvent.SHIFT_DOWN_MASK) != 0)
		{
			return true;
		}
		if (hotkey.equals(Keybind.CTRL) && (modifiers & MouseEvent.CTRL_DOWN_MASK) != 0)
		{
			return true;
		}
		if (hotkey.equals(Keybind.ALT) && (modifiers & MouseEvent.ALT_DOWN_MASK) != 0)
		{
			return true;
		}

		// For other keys, check the hotkey's modifiers against the event
		int requiredModifiers = hotkey.getModifiers();
		return requiredModifiers != 0 && (modifiers & requiredModifiers) == requiredModifiers;
	}

	void startUp()
	{
		sidebar = clientUI.getSidebar();
		sidebarTabOrder = clientUI.getSidebarTabOrder();

		if (sidebar == null || sidebarTabOrder == null)
		{
			return;
		}

		installDragHandler();

		// Apply saved custom order on startup if enabled
		if (config.useCustomTabOrder())
		{
			applyCustomOrder();
		}
	}

	void shutDown()
	{
		if (sidebar != null)
		{
			sidebar.setTransferHandler(null);
			if (dragMouseListener != null)
			{
				sidebar.removeMouseListener(dragMouseListener);
				sidebar.removeMouseMotionListener(dragMouseListener);
				dragMouseListener = null;
			}
		}
	}

	void reset()
	{
		configManager.unsetConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
		clientUI.rebuildSidebar(clientUI.getSidebarEntries());
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		log.info("Config changed: {}.{} = {}", event.getGroup(), event.getKey(), event.getNewValue());
		if (!event.getGroup().equals(ReorderSidebarConfig.CONFIG_GROUP) ||
			!event.getKey().equals("useCustomTabOrder"))
		{
			return;
		}

		if (config.useCustomTabOrder())
		{
			applyCustomOrder();
		}
		else
		{
			clientUI.rebuildSidebar(clientUI.getSidebarEntries());
		}
	}

	/**
	 * Apply the saved custom order to the sidebar, or use default if none saved.
	 */
	private void applyCustomOrder()
	{
		List<NavigationButton> orderedButtons = getCustomOrderTabs();
		log.info("Applying custom sidebar order with {} entries: {}", orderedButtons.size(),
			orderedButtons.stream().map(NavigationButton::getTooltip).collect(java.util.stream.Collectors.toList()));

		if (!orderedButtons.isEmpty())
		{
			clientUI.rebuildSidebar(orderedButtons);
		}
	}

	/**
	 * Save the current sidebar order as the custom order.
	 */
	private void setCustomOrderTabs(List<NavigationButton> entries)
	{
		if (entries == null || entries.isEmpty())
		{
			return;
		}

		// Extract tooltip strings from NavigationButtons
		List<String> tooltips = new ArrayList<>();
		for (NavigationButton btn : entries)
		{
			tooltips.add(btn.getTooltip());
		}

		String json = new com.google.gson.Gson().toJson(tooltips);
		configManager.setConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER, json);
		log.debug("Saved custom order: {} entries", tooltips.size());
	}

	/**
	 * Get the saved custom order as NavigationButtons.
	 * Returns buttons in saved order, with any new plugins appended.
	 */
	private List<NavigationButton> getCustomOrderTabs()
	{
		String json = configManager.getConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
		log.info("Loading custom sidebar order from config: {}", json);

		if (json == null || json.isEmpty())
		{
			log.info("No custom order saved, using default sidebar order");
			return new ArrayList<>();
		}

		List<String> tooltips;
		try
		{
			// CHECKSTYLE:OFF
			tooltips = new com.google.gson.Gson().fromJson(json, new TypeToken<List<String>>(){}.getType());
			// CHECKSTYLE:ON
		}
		catch (Exception e)
		{
			log.warn("Corrupted custom order config, clearing it: {}", e.getMessage());
			configManager.unsetConfiguration(ReorderSidebarConfig.CONFIG_GROUP, CONFIG_KEY_CUSTOM_ORDER);
			return new ArrayList<>();
		}

		if (tooltips == null || tooltips.isEmpty())
		{
			return new ArrayList<>();
		}


		Collection<NavigationButton> allButtons = clientUI.getSidebarEntries();
		List<NavigationButton> result = new ArrayList<>();

		// Add buttons in saved order
		for (String tooltip : tooltips)
		{
			for (NavigationButton btn : allButtons)
			{
				if (btn.getTooltip().equals(tooltip))
				{
					result.add(btn);
					log.info("Added button to custom order: {}", tooltip);
					break;
				}
			}
		}

		// Append any new buttons not in saved order
		for (NavigationButton btn : allButtons)
		{
			if (!result.contains(btn))
			{
				result.add(btn);
			}
		}

		log.info("Final custom order has {} entries: {}", result.size(),
			result.stream().map(NavigationButton::getTooltip).collect(java.util.stream.Collectors.toList()));
		return result;
	}

	private void installDragHandler()
	{
		if (dragMouseListener != null)
		{
			sidebar.removeMouseMotionListener(dragMouseListener);
		}

		TabReorderHandler transferHandler = new TabReorderHandler();
		sidebar.setTransferHandler(transferHandler);
		transferHandler.installDropIndicator();

		dragMouseListener = new MouseAdapter()
		{
			private boolean dragInitiated = false;
			private int dragStartIndex = -1;

			@Override
			public void mousePressed(MouseEvent e)
			{
				// Only prepare for drag if custom order is enabled
				if (!config.useCustomTabOrder())
				{
					dragStartIndex = -1;
					return;
				}

				// Only prepare for drag if hotkey requirement is met
				if (config.dragRequiresHotkey() && !isHotkeyPressed(e))
				{
					dragStartIndex = -1;
					return;
				}

				// Capture the index at the moment of mouse press (before any dragging)
				dragStartIndex = sidebar.indexAtLocation(e.getX(), e.getY());
				dragInitiated = false;
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				dragStartIndex = -1;
				dragInitiated = false;
			}

			@Override
			public void mouseDragged(MouseEvent e)
			{
				// Don't allow dragging if custom order is disabled
				if (!config.useCustomTabOrder())
				{
					return;
				}

				// Don't allow dragging if hotkey is required but not pressed
				if (config.dragRequiresHotkey() && !isHotkeyPressed(e))
				{
					return;
				}

				// Use the index captured at mouse press, not current location
				if (dragStartIndex != -1 && !dragInitiated)
				{
					dragInitiated = true;
					pendingDragSourceIndex = dragStartIndex;
					sidebar.getTransferHandler().exportAsDrag(sidebar, e, TransferHandler.MOVE);
				}
			}
		};
		sidebar.addMouseListener(dragMouseListener);
		sidebar.addMouseMotionListener(dragMouseListener);
	}

	// TODO: Refactor this class to separate the drag-and-drop logic from the config management and sidebar
	//  rebuilding logic for better maintainability and testability.
	// ==================== Tab Reorder Handler ====================

	private class TabReorderHandler extends TransferHandler
	{
		private int sourceIndex;

		void installDropIndicator()
		{
			DropTarget existingDropTarget = sidebar.getDropTarget();
			sidebar.setDropTarget(new DropTarget(sidebar, DnDConstants.ACTION_MOVE,
				new IndicatorDropTargetListener(existingDropTarget), true));
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
			// Use the index captured at mouse press, not getSelectedIndex()
			sourceIndex = pendingDragSourceIndex != -1 ? pendingDragSourceIndex : pane.getSelectedIndex();
			pendingDragSourceIndex = -1;

			if (sourceIndex < 0 || sourceIndex >= pane.getTabCount())
			{
				return null;
			}

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

			// Secondary safeguard: don't allow drop if custom order is disabled
			if (!config.useCustomTabOrder())
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
			boolean dropInUpperHalf = (tabPlacement == JTabbedPane.TOP || tabPlacement == JTabbedPane.BOTTOM)
				? dropPoint.getX() < tabBounds.x + tabBounds.width / 2.0
				: dropPoint.getY() < tabBounds.y + tabBounds.height / 2.0;

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

			// Save and select
			setCustomOrderTabs(sidebarTabOrder);
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
				glassPane.showIndicator(
					new Rectangle(tabLocation.x, tabLocation.y, bounds.width, bounds.height),
					above, sidebar.getTabPlacement());
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
				if (originalDropTarget != null) originalDropTarget.dragEnter(dtde);
			}

			@Override
			public void dragOver(DropTargetDragEvent dtde)
			{
				updateDropIndicator(dtde.getLocation());
				if (originalDropTarget != null) originalDropTarget.dragOver(dtde);
			}

			@Override
			public void dropActionChanged(DropTargetDragEvent dtde)
			{
				if (originalDropTarget != null) originalDropTarget.dropActionChanged(dtde);
			}

			@Override
			public void dragExit(DropTargetEvent dte)
			{
				hideDropIndicator();
				if (originalDropTarget != null) originalDropTarget.dragExit(dte);
			}

			@Override
			public void drop(DropTargetDropEvent dtde)
			{
				hideDropIndicator();
				if (originalDropTarget != null) originalDropTarget.drop(dtde);
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

				int tabPlacement = sidebar.getTabPlacement();
				boolean above = (tabPlacement == JTabbedPane.TOP || tabPlacement == JTabbedPane.BOTTOM)
					? location.x < tabBounds.x + tabBounds.width / 2.0
					: location.y < tabBounds.y + tabBounds.height / 2.0;

				showDropIndicator(tabBounds, above);
			}
		}
	}

	// TODO: refactor this class to a separate file for better maintainability and testability.
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

			int[] xPoints, yPoints;

			if (tabPlacement == JTabbedPane.TOP || tabPlacement == JTabbedPane.BOTTOM)
			{
				int x = showAbove ? tabBounds.x : tabBounds.x + tabBounds.width;
				int y = tabBounds.y;
				int height = tabBounds.height;

				xPoints = new int[]{x - 6, x, x + 6, x + 6, x + INDICATOR_THICKNESS, x + INDICATOR_THICKNESS,
					x - INDICATOR_THICKNESS, x - INDICATOR_THICKNESS, x - 6};
				yPoints = new int[]{y, y + 8, y, y + 4, y + 4, height - 4 + y, height - 4 + y, y + 4, y + 4};
			}
			else
			{
				int x = tabBounds.x;
				int y = showAbove ? tabBounds.y : tabBounds.y + tabBounds.height;
				int width = tabBounds.width;

				xPoints = new int[]{x, x + 8, x, x + 4, x + 4, width - 4 + x, width - 4 + x, x + 4, x + 4};
				yPoints = new int[]{y - 6, y, y + 6, y + 6, y + INDICATOR_THICKNESS, y + INDICATOR_THICKNESS,
					y - INDICATOR_THICKNESS, y - INDICATOR_THICKNESS, y - 6};
			}

			g2d.fillPolygon(xPoints, yPoints, 9);
			g2d.dispose();
		}
	}
}
