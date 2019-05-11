/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay;

import com.google.common.base.MoreObjects;
import com.google.common.primitives.Ints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseAdapter;
import net.runelite.client.input.MouseManager;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

@Singleton
public class OverlayRenderer extends MouseAdapter implements KeyListener
{
	private static final int BORDER = 5;
	private static final int BORDER_TOP = BORDER + 15;
	private static final int PADDING = 2;
	private static final Dimension SNAP_CORNER_SIZE = new Dimension(80, 80);
	private static final Color SNAP_CORNER_COLOR = new Color(0, 255, 255, 50);
	private static final Color SNAP_CORNER_ACTIVE_COLOR = new Color(0, 255, 0, 100);
	private static final Color MOVING_OVERLAY_COLOR = new Color(255, 255, 0, 100);
	private static final Color MOVING_OVERLAY_ACTIVE_COLOR = new Color(255, 255, 0, 200);
<<<<<<< HEAD
	private static final String OVERLAY_CONFIG_PREFERRED_LOCATION = "_preferredLocation";
	private static final String OVERLAY_CONFIG_PREFERRED_POSITION = "_preferredPosition";
<<<<<<< HEAD
=======
	private static final String OVERLAY_CONFIG_PREFERRED_SIZE = "_preferredSize";
>>>>>>> upstream/master

	private final PluginManager pluginManager;
	private final Provider<Client> clientProvider;
	private final InfoBoxOverlay infoBoxOverlay;
	private final ConfigManager configManager;
=======
	private final Client client;
	private final OverlayManager overlayManager;
>>>>>>> upstream/master
	private final RuneLiteConfig runeLiteConfig;

	// Overlay movement variables
	private final Point overlayOffset = new Point();
	private final Point mousePosition = new Point();
	private Overlay movedOverlay;
	private boolean inOverlayDraggingMode;
	private boolean inMenuEntryMode;
	private MenuEntry[] menuEntries;

	// Overlay state validation
	private Rectangle viewportBounds;
	private Rectangle chatboxBounds;
	private int viewportOffset;
	private boolean chatboxHidden;
	private boolean isResizeable;
	private OverlayBounds snapCorners;

	@Inject
	private OverlayRenderer(
		final Client client,
		final OverlayManager overlayManager,
		final RuneLiteConfig runeLiteConfig,
		final MouseManager mouseManager,
		final KeyManager keyManager)
	{
		this.client = client;
		this.overlayManager = overlayManager;
		this.runeLiteConfig = runeLiteConfig;
		keyManager.registerKeyListener(this);
		mouseManager.registerMouseListener(this);
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			inOverlayDraggingMode = false;
			inMenuEntryMode = false;
			menuEntries = null;
		}
	}

<<<<<<< HEAD
<<<<<<< HEAD
	private void rebuildOverlays()
=======
	/**
	 * Force save overlay data
	 * @param overlay overlay to save
	 */
	public void saveOverlay(final Overlay overlay)
	{
		saveOverlayPosition(overlay);
		saveOverlaySize(overlay);
		saveOverlayLocation(overlay);
	}

	/**
	 * Resets stored overlay position data
	 * @param overlay overlay to reset
	 */
	public void resetOverlay(final Overlay overlay)
	{
		final String locationKey = overlay.getName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		final String positionKey = overlay.getName() + OVERLAY_CONFIG_PREFERRED_POSITION;
		final String sizeKey = overlay.getName() + OVERLAY_CONFIG_PREFERRED_SIZE;
		configManager.unsetConfiguration(runeliteGroupName, locationKey);
		configManager.unsetConfiguration(runeliteGroupName, positionKey);
		configManager.unsetConfiguration(runeliteGroupName, sizeKey);
	}

	/**
	 * Rebuild overlay cache for rendering
	 */
	public void rebuildOverlays()
>>>>>>> upstream/master
=======
	@Subscribe
	protected void onClientTick(ClientTick t)
>>>>>>> upstream/master
	{
		if (menuEntries == null)
		{
			return;
		}

		if (!inMenuEntryMode && runeLiteConfig.menuEntryShift())
		{
<<<<<<< HEAD
			final Point location = loadOverlayLocation(overlay);

			if (location != null
				&& client.getCanvas() != null
				&& !client.getCanvas().contains(location))
			{
				overlay.setPreferredLocation(null);
				saveOverlayLocation(overlay);
			}
<<<<<<< HEAD
			else
=======
			else if (location != null)
>>>>>>> upstream/master
			{
				overlay.setPreferredLocation(location);
			}

<<<<<<< HEAD
=======
			final Dimension size = loadOverlaySize(overlay);

			if (size != null)
			{
				overlay.setPreferredSize(size);
			}

>>>>>>> upstream/master
			final OverlayPosition position = loadOverlayPosition(overlay);
			overlay.setPreferredPosition(position);
=======
			return;
>>>>>>> upstream/master
		}

		if (client.isMenuOpen())
		{
			return;
		}

		MenuEntry[] clientMenuEntries = client.getMenuEntries();
		MenuEntry[] newEntries = new MenuEntry[clientMenuEntries.length + menuEntries.length];

		newEntries[0] = clientMenuEntries[0]; // Keep cancel at 0
		System.arraycopy(menuEntries, 0, newEntries, 1, menuEntries.length); // Add overlay menu entries
		System.arraycopy(clientMenuEntries, 1, newEntries, menuEntries.length + 1, clientMenuEntries.length - 1); // Add remaining menu entries
		client.setMenuEntries(newEntries);
	}

	@Subscribe
	public void onBeforeRender(BeforeRender event)
	{
		menuEntries = null;
	}

	public void render(Graphics2D graphics, final OverlayLayer layer)
	{
		if (layer != OverlayLayer.ABOVE_MAP
			&& client.getWidget(WidgetInfo.FULLSCREEN_MAP_ROOT) != null
			&& !client.getWidget(WidgetInfo.FULLSCREEN_MAP_ROOT).isHidden())
		{
			return;
		}

		final List<Overlay> overlays = overlayManager.getLayer(layer);

		if (overlays == null
			|| overlays.isEmpty()
			|| client.getGameState() != GameState.LOGGED_IN
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null
			|| client.getViewportWidget() == null)
		{
			return;
		}

		if (shouldInvalidateBounds())
		{
			snapCorners = buildSnapCorners();
		}

		// Create copy of snap corners because overlays will modify them
		OverlayBounds snapCorners = new OverlayBounds(this.snapCorners);
		OverlayUtil.setGraphicProperties(graphics);

		// Draw snap corners
<<<<<<< HEAD
		if (layer == OverlayLayer.UNDER_WIDGETS && movedOverlay != null)
=======
		if (layer == OverlayLayer.UNDER_WIDGETS && movedOverlay != null && movedOverlay.getPosition() != OverlayPosition.DETACHED)
>>>>>>> upstream/master
		{
			final OverlayBounds translatedSnapCorners = snapCorners.translated(
				-SNAP_CORNER_SIZE.width,
				-SNAP_CORNER_SIZE.height);

			final Color previous = graphics.getColor();

			for (final Rectangle corner : translatedSnapCorners.getBounds())
			{
				graphics.setColor(corner.contains(mousePosition) ? SNAP_CORNER_ACTIVE_COLOR : SNAP_CORNER_COLOR);
				graphics.fill(corner);
			}

			graphics.setColor(previous);
		}

		// Get mouse position
		final net.runelite.api.Point mouseCanvasPosition = client.getMouseCanvasPosition();
		final Point mouse = new Point(mouseCanvasPosition.getX(), mouseCanvasPosition.getY());

		for (Overlay overlay : overlays)
		{
			OverlayPosition overlayPosition = overlay.getPosition();

			if (overlay.getPreferredPosition() != null)
			{
				overlayPosition = overlay.getPreferredPosition();
			}

			if (!isResizeable)
			{
				// On fixed mode, ABOVE_CHATBOX_RIGHT is in the same location as
				// BOTTOM_RIGHT and CANVAST_TOP_RIGHT is same as TOP_RIGHT.
				// Just use BOTTOM_RIGHT and TOP_RIGHT to prevent overlays from
				// drawing over each other.
				switch (overlayPosition)
				{
					case CANVAS_TOP_RIGHT:
						overlayPosition = OverlayPosition.TOP_RIGHT;
						break;
					case ABOVE_CHATBOX_RIGHT:
						overlayPosition = OverlayPosition.BOTTOM_RIGHT;
						break;
				}
			}

			if (overlayPosition == OverlayPosition.DYNAMIC || overlayPosition == OverlayPosition.TOOLTIP)
			{
				safeRender(client, overlay, layer, graphics, new Point());
			}
			else
			{
				final Point location = overlay.getBounds().getLocation();
				final Dimension dimension = overlay.getBounds().getSize();

				// If the final position is not modified, layout it
<<<<<<< HEAD
				if (overlay.getPreferredLocation() == null || overlay.getPreferredPosition() != null)
=======
				if (overlayPosition != OverlayPosition.DETACHED && (overlay.getPreferredLocation() == null || overlay.getPreferredPosition() != null))
>>>>>>> upstream/master
				{
					final Rectangle snapCorner = snapCorners.forPosition(overlayPosition);
					final Point translation = OverlayUtil.transformPosition(overlayPosition, dimension);
					location.setLocation(snapCorner.getX() + translation.x, snapCorner.getY() + translation.y);
					final Point padding = OverlayUtil.padPosition(overlayPosition, dimension, PADDING);
					snapCorner.translate(padding.x, padding.y);
				}
				else
				{
<<<<<<< HEAD
<<<<<<< HEAD
					location.setLocation(overlay.getPreferredLocation());
=======
					if (overlay.getPreferredLocation() != null)
=======
					final Point preferredLocation = overlay.getPreferredLocation();

					if (preferredLocation != null)
>>>>>>> upstream/master
					{
						location.setLocation(preferredLocation);
					}

					final Dimension realDimensions = client.getRealDimensions();
					location.x = Ints.constrainToRange(location.x, 0, Math.max(0, realDimensions.width - dimension.width));
					location.y = Ints.constrainToRange(location.y, 0, Math.max(0, realDimensions.height - dimension.height));
				}

				if (overlay.getPreferredSize() != null)
				{
					overlay.getBounds().setSize(overlay.getPreferredSize());
>>>>>>> upstream/master
				}

				safeRender(client, overlay, layer, graphics, location);
				final Rectangle bounds = overlay.getBounds();

				if (bounds.isEmpty())
				{
					continue;
				}

				if (inOverlayDraggingMode)
				{
					final Color previous = graphics.getColor();
					graphics.setColor(movedOverlay == overlay ? MOVING_OVERLAY_ACTIVE_COLOR : MOVING_OVERLAY_COLOR);
					graphics.draw(bounds);
					graphics.setColor(previous);
				}

				if (menuEntries == null && !client.isMenuOpen() && bounds.contains(mouse))
				{
					menuEntries = createRightClickMenuEntries(overlay);
				}
			}
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		if (!inOverlayDraggingMode)
		{
			return mouseEvent;
		}

		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);

		synchronized (overlayManager)
		{
			for (Overlay overlay : overlayManager.getOverlays())
			{
				if (overlay.getBounds().contains(mousePoint))
				{
<<<<<<< HEAD
<<<<<<< HEAD
					overlay.setPreferredLocation(null);
					overlay.setPreferredPosition(null);
					saveOverlayPosition(overlay);
					saveOverlayLocation(overlay);
					rebuildOverlayLayers();
=======
					// detached overlays have no place to reset back to
					if (overlay.getPosition() != OverlayPosition.DETACHED)
=======
					if (SwingUtilities.isRightMouseButton(mouseEvent))
>>>>>>> upstream/master
					{
						overlayManager.resetOverlay(overlay);
					}
					else
					{
						final Point offset = new Point(mousePoint.x, mousePoint.y);
						offset.translate(-overlay.getBounds().x, -overlay.getBounds().y);
						overlayOffset.setLocation(offset);

						mousePoint.translate(-offset.x, -offset.y);
						movedOverlay = overlay;
						movedOverlay.setPreferredPosition(null);
						movedOverlay.setPreferredLocation(mousePoint);
						overlayManager.saveOverlay(movedOverlay);
					}
<<<<<<< HEAD
>>>>>>> upstream/master
				}
				else
				{
					mousePoint.translate(-overlay.getBounds().x, -overlay.getBounds().y);
					overlayOffset.setLocation(mousePoint);
					movedOverlay = overlay;
				}
=======
>>>>>>> upstream/master

					mouseEvent.consume();
					break;
				}
			}
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		if (!inOverlayDraggingMode)
		{
			return mouseEvent;
		}

		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);
		final Rectangle canvasRect = new Rectangle(client.getRealDimensions());

		if (!canvasRect.contains(mousePoint))
		{
			return mouseEvent;
		}

		if (movedOverlay != null)
		{
			final Dimension realDimension = client.getRealDimensions();
			mousePoint.translate(-overlayOffset.x, -overlayOffset.y);
			mousePoint.x = Ints.constrainToRange(mousePoint.x, 0, Math.max(0, realDimension.width - movedOverlay.getBounds().width));
			mousePoint.y = Ints.constrainToRange(mousePoint.y, 0, Math.max(0, realDimension.height - movedOverlay.getBounds().height));
			movedOverlay.setPreferredPosition(null);
			movedOverlay.setPreferredLocation(mousePoint);
			mouseEvent.consume();
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		if (movedOverlay != null)
		{
			mousePosition.setLocation(-1, -1);
<<<<<<< HEAD
			final OverlayBounds snapCorners = this.snapCorners.translated(-SNAP_CORNER_SIZE.width, -SNAP_CORNER_SIZE.height);

			for (Rectangle snapCorner : snapCorners.getBounds())
			{
				if (snapCorner.contains(mouseEvent.getPoint()))
				{
					OverlayPosition position = snapCorners.fromBounds(snapCorner);
					if (position == movedOverlay.getPosition())
					{
						// overlay moves back to default position
						position = null;
					}
					movedOverlay.setPreferredPosition(position);
					movedOverlay.setPreferredLocation(null); // from dragging
					break;
=======

			// do not snapcorner detached overlays
			if (movedOverlay.getPosition() != OverlayPosition.DETACHED)
			{
				final OverlayBounds snapCorners = this.snapCorners.translated(-SNAP_CORNER_SIZE.width, -SNAP_CORNER_SIZE.height);

				for (Rectangle snapCorner : snapCorners.getBounds())
				{
					if (snapCorner.contains(mouseEvent.getPoint()))
					{
						OverlayPosition position = snapCorners.fromBounds(snapCorner);

						if (position == movedOverlay.getPosition())
						{
							// overlay moves back to default position
							position = null;
						}

						movedOverlay.setPreferredPosition(position);
						movedOverlay.setPreferredLocation(null); // from dragging
						break;
					}
>>>>>>> upstream/master
				}
			}

			overlayManager.saveOverlay(movedOverlay);
			movedOverlay = null;
			mouseEvent.consume();
		}

		return mouseEvent;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.isAltDown())
		{
			inOverlayDraggingMode = true;
		}

		if (e.isShiftDown() && runeLiteConfig.menuEntryShift())
		{
			inMenuEntryMode = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (!e.isAltDown())
		{
			inOverlayDraggingMode = false;
		}

		if (!e.isShiftDown())
		{
			inMenuEntryMode = false;
		}
	}

	private void safeRender(Client client, Overlay overlay, OverlayLayer layer, Graphics2D graphics, Point point)
	{
		final Graphics2D subGraphics = (Graphics2D) graphics.create();

		if (!isResizeable && (layer == OverlayLayer.ABOVE_SCENE || layer == OverlayLayer.UNDER_WIDGETS))
		{
			subGraphics.setClip(client.getViewportXOffset(),
				client.getViewportYOffset(),
				client.getViewportWidth(),
				client.getViewportHeight());
		}

		final OverlayPosition position = overlay.getPosition();

		// Set font based on configuration
		if (position == OverlayPosition.DYNAMIC || position == OverlayPosition.DETACHED)
		{
			subGraphics.setFont(runeLiteConfig.fontType().getFont());
		}
		else if (position == OverlayPosition.TOOLTIP)
		{
			subGraphics.setFont(runeLiteConfig.tooltipFontType().getFont());
		}
		else
		{
			subGraphics.setFont(runeLiteConfig.interfaceFontType().getFont());
		}

		subGraphics.translate(point.x, point.y);
		final Dimension dimension = MoreObjects.firstNonNull(overlay.render(subGraphics), new Dimension());
		subGraphics.dispose();
		overlay.setBounds(new Rectangle(point, dimension));
	}

	private boolean shouldInvalidateBounds()
	{
		final Widget chatbox = client.getWidget(WidgetInfo.CHATBOX);
		final boolean resizeableChanged = isResizeable != client.isResized();
		boolean changed = false;

		if (resizeableChanged)
		{
			isResizeable = client.isResized();
			changed = true;
		}

		final boolean chatboxBoundsChanged = chatbox == null || !chatbox.getBounds().equals(chatboxBounds);

		if (chatboxBoundsChanged)
		{
			chatboxBounds = chatbox != null ? chatbox.getBounds() : new Rectangle();
			changed = true;
		}

		final boolean chatboxHiddenChanged = chatboxHidden != (chatbox == null || chatbox.isHidden());

		if (chatboxHiddenChanged)
		{
			chatboxHidden = chatbox == null || chatbox.isHidden();
			changed = true;
		}

		final boolean viewportChanged = !client.getViewportWidget().getBounds().equals(viewportBounds);

		if (viewportChanged)
		{
			viewportBounds = client.getViewportWidget().getBounds();
			changed = true;
		}

		final boolean viewportOffsetChanged = client.getViewportXOffset() != viewportOffset;

		if (viewportOffsetChanged)
		{
			viewportOffset = client.getViewportXOffset();
			changed = true;
		}

		return changed;
	}

	private OverlayBounds buildSnapCorners()
	{
		final Point topLeftPoint = new Point(
			viewportOffset + BORDER,
			viewportOffset + BORDER_TOP);

		final Point topCenterPoint = new Point(
			viewportOffset + viewportBounds.width / 2,
			viewportOffset + BORDER
		);

		final Point topRightPoint = new Point(
			viewportOffset + viewportBounds.width - BORDER,
			topCenterPoint.y);

		final Point bottomLeftPoint = new Point(
			topLeftPoint.x,
			viewportOffset + viewportBounds.height - BORDER);

		final Point bottomRightPoint = new Point(
			topRightPoint.x,
			bottomLeftPoint.y);

		// Check to see if chat box is minimized
		if (isResizeable && chatboxHidden)
		{
			bottomLeftPoint.y += chatboxBounds.height;
		}

		final Point rightChatboxPoint = isResizeable ? new Point(
			viewportOffset + chatboxBounds.width - BORDER,
			bottomLeftPoint.y) : bottomRightPoint;

		final Point canvasTopRightPoint = isResizeable ? new Point(
			(int)client.getRealDimensions().getWidth(),
			0) : topRightPoint;

		return new OverlayBounds(
			new Rectangle(topLeftPoint, SNAP_CORNER_SIZE),
			new Rectangle(topCenterPoint, SNAP_CORNER_SIZE),
			new Rectangle(topRightPoint, SNAP_CORNER_SIZE),
			new Rectangle(bottomLeftPoint, SNAP_CORNER_SIZE),
			new Rectangle(bottomRightPoint, SNAP_CORNER_SIZE),
			new Rectangle(rightChatboxPoint, SNAP_CORNER_SIZE),
			new Rectangle(canvasTopRightPoint, SNAP_CORNER_SIZE));
	}

	private MenuEntry[] createRightClickMenuEntries(Overlay overlay)
	{
<<<<<<< HEAD
<<<<<<< HEAD
		final String key = overlay.getClass().getSimpleName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
=======
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
>>>>>>> upstream/master
		if (overlay.getPreferredLocation() != null)
		{
			configManager.setConfiguration(
				runeliteGroupName,
				key,
				overlay.getPreferredLocation());
		}
		else
		{
			configManager.unsetConfiguration(
				runeliteGroupName,
				key);
		}
	}

<<<<<<< HEAD
	private void saveOverlayPosition(final Overlay overlay)
	{
		final String key = overlay.getClass().getSimpleName() + OVERLAY_CONFIG_PREFERRED_POSITION;
=======
	private void saveOverlaySize(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_SIZE;
		if (overlay.getPreferredSize() != null)
		{
			configManager.setConfiguration(
				runeliteGroupName,
				key,
				overlay.getPreferredSize());
		}
		else
		{
			configManager.unsetConfiguration(
				runeliteGroupName,
				key);
		}
	}

	private void saveOverlayPosition(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_POSITION;
>>>>>>> upstream/master
		if (overlay.getPreferredPosition() != null)
=======
		List<OverlayMenuEntry> menuEntries = overlay.getMenuEntries();
		final MenuEntry[] entries = new MenuEntry[menuEntries.size()];

		// Add in reverse order so they display correctly in the right-click menu
		for (int i = menuEntries.size() - 1; i >= 0; --i)
>>>>>>> upstream/master
		{
			OverlayMenuEntry overlayMenuEntry = menuEntries.get(i);

<<<<<<< HEAD
	private Point loadOverlayLocation(final Overlay overlay)
	{
<<<<<<< HEAD
		final String key = overlay.getClass().getSimpleName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		return configManager.getConfiguration(runeliteGroupName, key, Point.class);
	}

	private OverlayPosition loadOverlayPosition(final Overlay overlay)
	{
		final String locationKey = overlay.getClass().getSimpleName() + OVERLAY_CONFIG_PREFERRED_POSITION;
=======
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		return configManager.getConfiguration(runeliteGroupName, key, Point.class);
	}
=======
			final MenuEntry entry = new MenuEntry();
			entry.setOption(overlayMenuEntry.getOption());
			entry.setTarget(ColorUtil.wrapWithColorTag(overlayMenuEntry.getTarget(), JagexColors.MENU_TARGET));
			entry.setType(MenuAction.RUNELITE_OVERLAY.getId());
			entry.setIdentifier(overlayManager.getOverlays().indexOf(overlay)); // overlay id
>>>>>>> upstream/master

			entries[i] = entry;
		}

<<<<<<< HEAD
	private OverlayPosition loadOverlayPosition(final Overlay overlay)
	{
		final String locationKey = overlay.getName() + OVERLAY_CONFIG_PREFERRED_POSITION;
>>>>>>> upstream/master
		return configManager.getConfiguration(runeliteGroupName, locationKey, OverlayPosition.class);
=======
		return entries;
>>>>>>> upstream/master
	}
}
