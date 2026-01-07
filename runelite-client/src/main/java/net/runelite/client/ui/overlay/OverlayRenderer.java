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
import java.awt.Composite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.KeyCode;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.MouseAdapter;
import net.runelite.client.input.MouseManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.HotkeyListener;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

@Singleton
@Slf4j
public class OverlayRenderer extends MouseAdapter
{
	private static final Marker DEDUPLICATE = MarkerFactory.getMarker("DEDUPLICATE");
	private static final int BORDER = 5;
	private static final int BORDER_TOP = BORDER + 15;
	private static final int PADDING = 2;
	private static final int OVERLAY_RESIZE_TOLERANCE = 5;
	private static final Dimension SNAP_CORNER_SIZE = new Dimension(80, 80);
	private static final Color SNAP_CORNER_COLOR = new Color(0, 255, 255, 50);
	private static final Color SNAP_CORNER_ACTIVE_COLOR = new Color(0, 255, 0, 100);
	private static final Color MOVING_OVERLAY_COLOR = new Color(255, 255, 0, 100);
	private static final Color MOVING_OVERLAY_ACTIVE_COLOR = new Color(255, 255, 0, 200);
	private static final Color MOVING_OVERLAY_TARGET_COLOR = Color.RED;
	private static final Color MOVING_OVERLAY_RESIZING_COLOR = new Color(255, 0, 255, 200);

	private final Client client;
	private final OverlayManager overlayManager;
	private final RuneLiteConfig runeLiteConfig;
	private final ClientUI clientUI;
	private final EventBus eventBus;
	private final ChatMessageManager chatMessageManager;

	private Font font, tooltipFont, interfaceFont;

	// Overlay movement variables
	private final Point overlayOffset = new Point();
	private final Point mousePosition = new Point();
	private Overlay currentManagedOverlay;
	private Overlay dragTargetOverlay;
	private Rectangle currentManagedBounds;
	private boolean inOverlayManagingMode;
	private boolean inOverlayResizingMode;
	private boolean inOverlayDraggingMode;
	private boolean startedMovingOverlay;
	private Overlay curHoveredOverlay; // for building menu entries
	private Overlay lastHoveredOverlay; // for off-thread access

	// Overlay state validation
	private Rectangle viewportBounds;
	private Rectangle chatboxBounds;
	private boolean chatboxHidden;
	private boolean isResizeable;
	private OverlayBounds emptySnapCorners, snapCorners;
	private boolean dragWarn;

	@Inject
	private OverlayRenderer(
		final Client client,
		final OverlayManager overlayManager,
		final RuneLiteConfig runeLiteConfig,
		final MouseManager mouseManager,
		final KeyManager keyManager,
		final ClientUI clientUI,
		final EventBus eventBus,
		final ChatMessageManager chatMessageManager
	)
	{
		this.client = client;
		this.overlayManager = overlayManager;
		this.runeLiteConfig = runeLiteConfig;
		this.clientUI = clientUI;
		this.eventBus = eventBus;
		this.chatMessageManager = chatMessageManager;

		HotkeyListener hotkeyListener = new HotkeyListener(runeLiteConfig::dragHotkey)
		{
			@Override
			public void hotkeyPressed()
			{
				inOverlayManagingMode = true;
			}

			@Override
			public void hotkeyReleased()
			{
				if (inOverlayManagingMode)
				{
					inOverlayManagingMode = false;
					resetOverlayManagementMode();
				}
			}
		};

		keyManager.registerKeyListener(hotkeyListener);
		mouseManager.registerMouseListener(this);
		eventBus.register(this);
	}

	@Subscribe
	public void onFocusChanged(FocusChanged event)
	{
		if (!event.isFocused())
		{
			if (inOverlayManagingMode)
			{
				inOverlayManagingMode = false;
				resetOverlayManagementMode();
			}

			curHoveredOverlay = null;
		}
	}

	@Subscribe
	protected void onClientTick(ClientTick t)
	{
		lastHoveredOverlay = curHoveredOverlay;

		final Overlay overlay = curHoveredOverlay;
		if (overlay == null || client.isMenuOpen())
		{
			return;
		}

		final boolean shift = client.isKeyPressed(KeyCode.KC_SHIFT);
		if (!shift)
		{
			return;
		}

		List<OverlayMenuEntry> menuEntries = overlay.getMenuEntries();
		if (menuEntries.isEmpty())
		{
			return;
		}

		// Add in reverse order so they display correctly in the right-click menu
		for (int i = menuEntries.size() - 1; i >= 0; --i)
		{
			OverlayMenuEntry overlayMenuEntry = menuEntries.get(i);

			client.createMenuEntry(-1)
				.setOption(overlayMenuEntry.getOption())
				.setTarget(ColorUtil.wrapWithColorTag(overlayMenuEntry.getTarget(), JagexColors.MENU_TARGET))
				.setType(overlayMenuEntry.getMenuAction())
				.onClick(MoreObjects.firstNonNull(overlayMenuEntry.callback, e -> eventBus.post(new OverlayMenuClicked(overlayMenuEntry, overlay))));
		}
	}

	@Subscribe
	public void onBeforeRender(BeforeRender event)
	{
		curHoveredOverlay = null;

		if (client.getGameState() == GameState.LOGGED_IN)
		{

			if (shouldInvalidateBounds())
			{
				emptySnapCorners = buildSnapCorners();
			}

			// Create copy of snap corners because overlays will modify them
			snapCorners = new OverlayBounds(emptySnapCorners);
		}
	}

	public void renderOverlayLayer(Graphics2D graphics, final OverlayLayer layer)
	{
		final Collection<Overlay> overlays = overlayManager.getLayer(layer);
		renderOverlays(graphics, overlays, layer);
	}

	public void renderAfterInterface(Graphics2D graphics, int interfaceId, Collection<WidgetItem> widgetItems)
	{
		Collection<Overlay> overlays = overlayManager.getForInterface(interfaceId);
		overlayManager.setWidgetItems(widgetItems);
		renderOverlays(graphics, overlays, OverlayLayer.ABOVE_WIDGETS);
		overlayManager.setWidgetItems(Collections.emptyList());
	}

	public void renderAfterLayer(Graphics2D graphics, Widget layer, Collection<WidgetItem> widgetItems)
	{
		Collection<Overlay> overlays = overlayManager.getForLayer(layer.getId());
		overlayManager.setWidgetItems(widgetItems);
		renderOverlays(graphics, overlays, OverlayLayer.ABOVE_WIDGETS);
		overlayManager.setWidgetItems(Collections.emptyList());
	}

	private void renderOverlays(final Graphics2D graphics, Collection<Overlay> overlays, final OverlayLayer layer)
	{
		if (overlays == null
			|| overlays.isEmpty()
			|| client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		OverlayUtil.setGraphicProperties(graphics);

		// Draw snap corners
		if (inOverlayDraggingMode && layer == OverlayLayer.UNDER_WIDGETS && currentManagedOverlay != null && currentManagedOverlay.isSnappable())
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

		// Save graphics2d properties so we can restore them later
		final AffineTransform transform = graphics.getTransform();
		final Stroke stroke = graphics.getStroke();
		final Composite composite = graphics.getComposite();
		final Paint paint = graphics.getPaint();
		final RenderingHints renderingHints = graphics.getRenderingHints();
		final Color background = graphics.getBackground();

		// Cache overlay fonts
		this.font = runeLiteConfig.fontType().getFont();
		this.tooltipFont = runeLiteConfig.tooltipFontType().getFont();
		this.interfaceFont = runeLiteConfig.interfaceFontType().getFont();

		final Rectangle clip = clipBounds(layer);
		graphics.setClip(clip);

		for (Overlay overlay : overlays)
		{
			final OverlayPosition overlayPosition = getCorrectedOverlayPosition(overlay);
			final Rectangle bounds = overlay.getBounds();
			final Dimension dimension = bounds.getSize();
			final Point preferredLocation = overlay.getPreferredLocation();
			Point location;
			Rectangle snapCorner = null;

			// If the final position is not modified, layout it
			if (overlayPosition != OverlayPosition.DYNAMIC && overlayPosition != OverlayPosition.TOOLTIP
				&& overlayPosition != OverlayPosition.DETACHED && preferredLocation == null)
			{
				snapCorner = snapCorners.forPosition(overlayPosition);
				final Point translation = OverlayUtil.transformPosition(overlayPosition, dimension); // offset from corner
				// Target x/y to draw the overlay
				int destX = snapCorner.x + translation.x;
				int destY = snapCorner.y + translation.y;
				// Clamp the target position to ensure it is on screen or within parent bounds
				location = clampOverlayLocation(destX, destY, dimension.width, dimension.height, overlay);
			}
			else
			{
				location = preferredLocation != null ? preferredLocation : bounds.getLocation();

				// Clamp the overlay position to ensure it is on screen or within parent bounds
				location = clampOverlayLocation(location.x, location.y, dimension.width, dimension.height, overlay);
			}

			if (overlay.getPreferredSize() != null)
			{
				bounds.setSize(overlay.getPreferredSize());
			}

			safeRender(overlay, graphics, location);

			// Adjust snap corner based on where the overlay was drawn
			if (snapCorner != null && bounds.width + bounds.height > 0)
			{
				OverlayUtil.shiftSnapCorner(overlayPosition, snapCorner, bounds, PADDING);
			}

			// Restore graphics2d properties prior to drawing bounds
			graphics.setTransform(transform);
			graphics.setStroke(stroke);
			graphics.setComposite(composite);
			graphics.setPaint(paint);
			graphics.setRenderingHints(renderingHints);
			graphics.setBackground(background);
			if (!graphics.getClip().equals(clip))
			{
				graphics.setClip(clip);
			}

			if (!bounds.isEmpty())
			{
				if (inOverlayManagingMode && overlay.isMovable())
				{
					Color boundsColor;
					if (inOverlayResizingMode && currentManagedOverlay == overlay)
					{
						boundsColor = MOVING_OVERLAY_RESIZING_COLOR;
					}
					else if (inOverlayDraggingMode && currentManagedOverlay == overlay)
					{
						boundsColor = MOVING_OVERLAY_ACTIVE_COLOR;
					}
					else if (inOverlayDraggingMode && overlay.isDragTargetable() && currentManagedOverlay.isDragTargetable()
						&& currentManagedOverlay.getBounds().intersects(bounds))
					{
						boundsColor = MOVING_OVERLAY_TARGET_COLOR;
						assert currentManagedOverlay != overlay;
						dragTargetOverlay = overlay;
					}
					else
					{
						boundsColor = MOVING_OVERLAY_COLOR;
					}

					graphics.setColor(boundsColor);
					graphics.draw(bounds);
					graphics.setPaint(paint);
				}

				if (!client.isMenuOpen() && !client.isWidgetSelected() && bounds.contains(mousePosition))
				{
					curHoveredOverlay = overlay;
					overlay.onMouseOver();
				}
			}
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);

		if (!inOverlayManagingMode)
		{
			return mouseEvent;
		}

		// See if we've clicked on an overlay
		currentManagedOverlay = lastHoveredOverlay;
		if (currentManagedOverlay == null || !currentManagedOverlay.isMovable())
		{
			return mouseEvent;
		}

		if (SwingUtilities.isRightMouseButton(mouseEvent))
		{
			if (currentManagedOverlay.isResettable())
			{
				overlayManager.resetOverlay(currentManagedOverlay);
			}
		}
		else if (SwingUtilities.isLeftMouseButton(mouseEvent))
		{
			final Point offset = new Point(mousePoint.x, mousePoint.y);
			offset.translate(-currentManagedOverlay.getBounds().x, -currentManagedOverlay.getBounds().y);
			overlayOffset.setLocation(offset);

			inOverlayResizingMode = currentManagedOverlay != null && currentManagedOverlay.isResizable() && clientUI.getCurrentCursor() != clientUI.getDefaultCursor();
			inOverlayDraggingMode = !inOverlayResizingMode;
			startedMovingOverlay = true;
			currentManagedBounds = new Rectangle(currentManagedOverlay.getBounds());
		}
		else
		{
			return mouseEvent;
		}

		mouseEvent.consume();
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseMoved(MouseEvent mouseEvent)
	{
		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);

		if (!inOverlayManagingMode)
		{
			return mouseEvent;
		}

		if (!inOverlayResizingMode && !inOverlayDraggingMode)
		{
			currentManagedOverlay = lastHoveredOverlay;
		}

		if (currentManagedOverlay == null || !currentManagedOverlay.isResizable())
		{
			clientUI.setCursor(clientUI.getDefaultCursor());
			return mouseEvent;
		}

		final Rectangle toleranceRect = new Rectangle(currentManagedOverlay.getBounds());
		toleranceRect.grow(-OVERLAY_RESIZE_TOLERANCE, -OVERLAY_RESIZE_TOLERANCE);
		final int outcode = toleranceRect.outcode(mouseEvent.getPoint());

		switch (outcode)
		{
			case Rectangle.OUT_TOP:
				clientUI.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
				break;
			case Rectangle.OUT_TOP | Rectangle.OUT_LEFT:
				clientUI.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
				break;
			case Rectangle.OUT_LEFT:
				clientUI.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
				break;
			case Rectangle.OUT_LEFT | Rectangle.OUT_BOTTOM:
				clientUI.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
				break;
			case Rectangle.OUT_BOTTOM:
				clientUI.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
				break;
			case Rectangle.OUT_BOTTOM | Rectangle.OUT_RIGHT:
				clientUI.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
				break;
			case Rectangle.OUT_RIGHT:
				clientUI.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
				break;
			case Rectangle.OUT_RIGHT | Rectangle.OUT_TOP:
				clientUI.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
				break;
			default:
				// center
				clientUI.setCursor(clientUI.getDefaultCursor());
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		final Point p = mouseEvent.getPoint();
		mousePosition.setLocation(p);

		if (!inOverlayManagingMode)
		{
			return mouseEvent;
		}

		if (currentManagedOverlay == null)
		{
			return mouseEvent;
		}

		if (dragTargetOverlay != null && !currentManagedOverlay.getBounds().intersects(dragTargetOverlay.getBounds()))
		{
			// No longer over drag target
			dragTargetOverlay = null;
		}

		final Rectangle canvasRect = new Rectangle(client.getRealDimensions());

		if (!canvasRect.contains(p))
		{
			return mouseEvent;
		}

		if (inOverlayResizingMode)
		{
			final int left = p.x - currentManagedBounds.x; // Distance (in pixels) from the left edge of the bounds
			final int top = p.y - currentManagedBounds.y;  // Distance (in pixels) from the top edge of the bounds
			final int originalX = currentManagedBounds.x;
			final int originalY = currentManagedBounds.y;
			int x = originalX;
			int y = originalY;
			int width = currentManagedBounds.width;
			int height = currentManagedBounds.height;

			switch (clientUI.getCurrentCursor().getType())
			{
				case Cursor.N_RESIZE_CURSOR:
					y += top;
					height -= top;
					break;
				case Cursor.NW_RESIZE_CURSOR:
					x += left;
					y += top;
					width -= left;
					height -= top;
					break;
				case Cursor.W_RESIZE_CURSOR:
					x += left;
					width -= left;
					break;
				case Cursor.SW_RESIZE_CURSOR:
					x += left;
					width -= left;
					height = top;
					break;
				case Cursor.S_RESIZE_CURSOR:
					height = top;
					break;
				case Cursor.SE_RESIZE_CURSOR:
					width = left;
					height = top;
					break;
				case Cursor.E_RESIZE_CURSOR:
					width = left;
					break;
				case Cursor.NE_RESIZE_CURSOR:
					y += top;
					width = left;
					height -= top;
					break;
				default:
					// center
			}

			final int minOverlaySize = currentManagedOverlay.getMinimumSize();
			final int widthOverflow = Math.max(0, minOverlaySize - width);
			final int heightOverflow = Math.max(0, minOverlaySize - height);
			final int dx = x - originalX;
			final int dy = y - originalY;

			// If this resize operation would cause the dimensions to go below the minimum width/height, reset the
			// dimensions and adjust the x/y position accordingly as needed
			if (widthOverflow > 0)
			{
				width = minOverlaySize;

				if (dx > 0)
				{
					x -= widthOverflow;
				}
			}
			if (heightOverflow > 0)
			{
				height = minOverlaySize;

				if (dy > 0)
				{
					y -= heightOverflow;
				}
			}

			currentManagedBounds.setRect(x, y, width, height);
			currentManagedOverlay.setPreferredSize(new Dimension(currentManagedBounds.width, currentManagedBounds.height));

			if (currentManagedOverlay.getPreferredLocation() != null)
			{
				currentManagedOverlay.setPreferredLocation(currentManagedBounds.getLocation());
			}
		}
		else if (inOverlayDraggingMode)
		{
			Point overlayPosition = new Point(p);
			overlayPosition.translate(-overlayOffset.x, -overlayOffset.y); // adjust by mouse offset to get overlay position

			// Clamp drag to parent component
			final Rectangle overlayBounds = currentManagedOverlay.getBounds();
			overlayPosition = clampOverlayLocation(overlayPosition.x, overlayPosition.y, overlayBounds.width, overlayBounds.height, currentManagedOverlay);
			currentManagedOverlay.setPreferredPosition(null);
			currentManagedOverlay.setPreferredLocation(overlayPosition);
		}
		else
		{
			return mouseEvent;
		}

		if (startedMovingOverlay)
		{
			// Move currently moved overlay to correct layer
			overlayManager.rebuildOverlayLayers();
			startedMovingOverlay = false;
		}

		return mouseEvent;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);

		if (!inOverlayManagingMode || currentManagedOverlay == null || (!inOverlayDraggingMode && !inOverlayResizingMode))
		{
			return mouseEvent;
		}

		if (dragTargetOverlay != null)
		{
			if (dragTargetOverlay.onDrag(currentManagedOverlay))
			{
				mouseEvent.consume();
				resetOverlayManagementMode();
				return mouseEvent;
			}
		}

		// Check if the overlay is over a snapcorner and snap it if so
		if (currentManagedOverlay.isSnappable() && inOverlayDraggingMode)
		{
			final OverlayBounds snapCorners = this.emptySnapCorners.translated(-SNAP_CORNER_SIZE.width, -SNAP_CORNER_SIZE.height);

			for (Rectangle snapCorner : snapCorners.getBounds())
			{
				if (snapCorner.contains(mousePoint))
				{
					OverlayPosition position = snapCorners.fromBounds(snapCorner);

					if (position == getCorrectedOverlayPosition(currentManagedOverlay))
					{
						// overlay moves back to default position
						position = null;
					}

					currentManagedOverlay.setPreferredPosition(position);
					currentManagedOverlay.setPreferredLocation(null); // from dragging
					currentManagedOverlay.revalidate();
					break;
				}
			}
		}

		if (inOverlayDraggingMode && currentManagedOverlay instanceof WidgetOverlay && !dragWarn)
		{
			dragWarn = true;
			chatMessageManager.queue(QueuedMessage.builder()
				.type(ChatMessageType.CONSOLE)
				.runeLiteFormattedMessage("You've repositioned one of the in-game interfaces. Hold " + runeLiteConfig.dragHotkey() +
					" and drag to reposition the interface again, or " + runeLiteConfig.dragHotkey() + " and right-click to reset.")
				.build());
		}

		overlayManager.saveOverlay(currentManagedOverlay);
		resetOverlayManagementMode();
		mouseEvent.consume();
		return mouseEvent;
	}

	private Rectangle clipBounds(OverlayLayer layer)
	{
		if (!isResizeable && (layer == OverlayLayer.ABOVE_SCENE || layer == OverlayLayer.UNDER_WIDGETS))
		{
			return new Rectangle(client.getViewportXOffset(),
				client.getViewportYOffset(),
				client.getViewportWidth(),
				client.getViewportHeight());
		}
		else
		{
			return new Rectangle(0, 0, client.getCanvasWidth(), client.getCanvasHeight());
		}
	}

	private void safeRender(Overlay overlay, Graphics2D graphics, Point point)
	{
		final OverlayPosition position = overlay.getPosition();

		// Set font based on configuration
		if (position == OverlayPosition.DYNAMIC || position == OverlayPosition.DETACHED)
		{
			graphics.setFont(font);
		}
		else if (position == OverlayPosition.TOOLTIP)
		{
			graphics.setFont(tooltipFont);
		}
		else
		{
			graphics.setFont(interfaceFont);
		}

		graphics.translate(point.x, point.y);
		overlay.getBounds().setLocation(point);

		final Dimension overlayDimension;
		try
		{
			overlayDimension = overlay.render(graphics);
		}
		catch (Exception ex)
		{
			log.warn(DEDUPLICATE, "Error during overlay rendering", ex);
			return;
		}

		if (overlayDimension != null)
		{
			overlay.getBounds().setSize(overlayDimension);
		}
		else
		{
			overlay.getBounds().setSize(0, 0);
		}
	}

	private OverlayPosition getCorrectedOverlayPosition(final Overlay overlay)
	{
		OverlayPosition overlayPosition = overlay.getPosition();

		if (overlay.getPreferredPosition() != null)
		{
			overlayPosition = overlay.getPreferredPosition();
		}

		if (!isResizeable)
		{
			// On fixed mode, ABOVE_CHATBOX_RIGHT is in the same location as
			// BOTTOM_RIGHT and CANVAS_TOP_RIGHT is same as TOP_RIGHT.
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

		return overlayPosition;
	}

	private void resetOverlayManagementMode()
	{
		inOverlayResizingMode = false;
		inOverlayDraggingMode = false;
		currentManagedOverlay = null;
		dragTargetOverlay = null;
		currentManagedBounds = null;
		clientUI.setCursor(clientUI.getDefaultCursor());
	}

	private boolean shouldInvalidateBounds()
	{
		final Widget chatbox = client.getWidget(InterfaceID.Chatbox.CHATAREA);
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

		Widget viewportWidget = getViewportLayer();
		Rectangle viewport = viewportWidget != null ? viewportWidget.getBounds() : new Rectangle();
		final boolean viewportChanged = !viewport.equals(viewportBounds);

		if (viewportChanged)
		{
			viewportBounds = viewport;
			changed = true;
		}

		return changed;
	}

	private Widget getViewportLayer()
	{
		if (client.isResized())
		{
			if (client.getVarbitValue(VarbitID.RESIZABLE_STONE_ARRANGEMENT) == 1)
			{
				return client.getWidget(InterfaceID.ToplevelPreEoc.HUD_CONTAINER_FRONT);
			}
			else
			{
				return client.getWidget(InterfaceID.ToplevelOsrsStretch.HUD_CONTAINER_FRONT);
			}
		}
		return client.getWidget(InterfaceID.Toplevel.OVERLAY_HUD);
	}

	private OverlayBounds buildSnapCorners()
	{
		final Point topLeftPoint = new Point(
			viewportBounds.x + BORDER,
			viewportBounds.y + BORDER_TOP);

		final Point topCenterPoint = new Point(
			viewportBounds.x + viewportBounds.width / 2,
			viewportBounds.y + BORDER
		);

		final Point topRightPoint = new Point(
			viewportBounds.x + viewportBounds.width - BORDER,
			topCenterPoint.y);

		final Point bottomLeftPoint = new Point(
			topLeftPoint.x,
			viewportBounds.y + viewportBounds.height - BORDER);

		final Point bottomRightPoint = new Point(
			topRightPoint.x,
			bottomLeftPoint.y);

		// Check to see if chat box is minimized
		if (isResizeable && chatboxHidden)
		{
			bottomLeftPoint.y += chatboxBounds.height;
		}

		final Point rightChatboxPoint = isResizeable ? new Point(
			viewportBounds.x + chatboxBounds.width - BORDER,
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

	/**
	 * Adjust the given overlay position to be within its parent's bounds.
	 *
	 * @param overlayX
	 * @param overlayY
	 * @param overlayWidth
	 * @param overlayHeight
	 * @param overlay       the overlay
	 * @return the clamped position
	 */
	private Point clampOverlayLocation(int overlayX, int overlayY, int overlayWidth, int overlayHeight, Overlay overlay)
	{
		int px, py, pw, ph;
		Rectangle parentBounds = overlay.getParentBounds();
		if (parentBounds == null || parentBounds.isEmpty())
		{
			// If no bounds are set, use the full client bounds
			Dimension dim = client.getRealDimensions();
			px = py = 0;
			pw = dim.width;
			ph = dim.height;
		}
		else
		{
			px = parentBounds.x;
			py = parentBounds.y;
			pw = parentBounds.width;
			ph = parentBounds.height;
		}

		// Constrain overlay position to be within the parent bounds
		return new Point(
			Ints.constrainToRange(overlayX, px,
				Math.max(px, px + pw - overlayWidth)),
			Ints.constrainToRange(overlayY, py,
				Math.max(py, py + ph - overlayHeight))
		);
	}
}
