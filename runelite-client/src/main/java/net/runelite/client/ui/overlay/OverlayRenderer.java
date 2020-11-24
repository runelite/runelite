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
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.KeyCode;
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
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.JagexColors;
import net.runelite.client.util.ColorUtil;

@Singleton
@Slf4j
public class OverlayRenderer extends MouseAdapter implements KeyListener
{
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
		final KeyManager keyManager,
		final ClientUI clientUI)
	{
		this.client = client;
		this.overlayManager = overlayManager;
		this.runeLiteConfig = runeLiteConfig;
		this.clientUI = clientUI;
		keyManager.registerKeyListener(this);
		mouseManager.registerMouseListener(this);
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

			menuEntries = null;
		}
	}

	@Subscribe
	protected void onClientTick(ClientTick t)
	{
		if (menuEntries == null)
		{
			return;
		}

		final boolean shift = client.isKeyPressed(KeyCode.KC_SHIFT);
		if (!shift && runeLiteConfig.menuEntryShift())
		{
			return;
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
		if (inOverlayDraggingMode && layer == OverlayLayer.UNDER_WIDGETS && currentManagedOverlay != null && currentManagedOverlay.getPosition() != OverlayPosition.DETACHED)
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

		// Save graphics2d properties so we can restore them later
		final AffineTransform transform = graphics.getTransform();
		final Stroke stroke = graphics.getStroke();
		final Composite composite = graphics.getComposite();
		final Paint paint = graphics.getPaint();
		final RenderingHints renderingHints = graphics.getRenderingHints();
		final Color background = graphics.getBackground();

		for (Overlay overlay : overlays)
		{
			final OverlayPosition overlayPosition = getCorrectedOverlayPosition(overlay);

			if (overlayPosition == OverlayPosition.DYNAMIC || overlayPosition == OverlayPosition.TOOLTIP)
			{
				safeRender(client, overlay, layer, graphics, new Point());

				// Restore graphics2d properties
				graphics.setTransform(transform);
				graphics.setStroke(stroke);
				graphics.setComposite(composite);
				graphics.setPaint(paint);
				graphics.setRenderingHints(renderingHints);
				graphics.setBackground(background);
			}
			else
			{
				final Point location = overlay.getBounds().getLocation();
				final Dimension dimension = overlay.getBounds().getSize();

				// If the final position is not modified, layout it
				if (overlayPosition != OverlayPosition.DETACHED && (overlay.getPreferredLocation() == null || overlay.getPreferredPosition() != null))
				{
					final Rectangle snapCorner = snapCorners.forPosition(overlayPosition);
					final Point translation = OverlayUtil.transformPosition(overlayPosition, dimension);
					location.setLocation(snapCorner.getX() + translation.x, snapCorner.getY() + translation.y);
					final Point padding = OverlayUtil.padPosition(overlayPosition, dimension, PADDING);
					snapCorner.translate(padding.x, padding.y);
				}
				else
				{
					final Point preferredLocation = overlay.getPreferredLocation();

					if (preferredLocation != null)
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
				}

				safeRender(client, overlay, layer, graphics, location);

				// Restore graphics2d properties prior to drawing bounds
				graphics.setTransform(transform);
				graphics.setStroke(stroke);
				graphics.setComposite(composite);
				graphics.setPaint(paint);
				graphics.setRenderingHints(renderingHints);
				graphics.setBackground(background);

				final Rectangle bounds = overlay.getBounds();

				if (!bounds.isEmpty())
				{
					if (inOverlayManagingMode)
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

					if (!client.isMenuOpen() && !client.getSpellSelected() && bounds.contains(mouse))
					{
						if (menuEntries == null)
						{
							menuEntries = createRightClickMenuEntries(overlay);
						}

						overlay.onMouseOver();
					}
				}
			}
		}
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		if (!inOverlayManagingMode)
		{
			return mouseEvent;
		}

		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);

		if (currentManagedOverlay == null)
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
		if (!inOverlayManagingMode)
		{
			return mouseEvent;
		}

		final Point mousePoint = mouseEvent.getPoint();
		mousePosition.setLocation(mousePoint);

		if (!inOverlayResizingMode && !inOverlayDraggingMode)
		{
			currentManagedOverlay = null;

			synchronized (overlayManager)
			{
				for (Overlay overlay : overlayManager.getOverlays())
				{
					if (overlay.getPosition() == OverlayPosition.DYNAMIC || overlay.getPosition() == OverlayPosition.TOOLTIP)
					{
						// never allow moving dynamic or tooltip overlays
						continue;
					}

					final Rectangle bounds = overlay.getBounds();
					if (bounds.contains(mousePoint))
					{
						currentManagedOverlay = overlay;
						break;
					}
				}
			}
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
		if (!inOverlayManagingMode)
		{
			return mouseEvent;
		}

		final Point p = mouseEvent.getPoint();
		mousePosition.setLocation(p);

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
			final Dimension realDimension = client.getRealDimensions();
			p.translate(-overlayOffset.x, -overlayOffset.y);
			p.x = Ints.constrainToRange(p.x, 0, Math.max(0, realDimension.width - currentManagedOverlay.getBounds().width));
			p.y = Ints.constrainToRange(p.y, 0, Math.max(0, realDimension.height - currentManagedOverlay.getBounds().height));
			currentManagedOverlay.setPreferredPosition(null);
			currentManagedOverlay.setPreferredLocation(p);
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

		mouseEvent.consume();
		return mouseEvent;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		if (!inOverlayManagingMode || currentManagedOverlay == null || (!inOverlayDraggingMode && !inOverlayResizingMode))
		{
			return mouseEvent;
		}

		mousePosition.setLocation(-1, -1);

		if (dragTargetOverlay != null)
		{
			if (dragTargetOverlay.onDrag(currentManagedOverlay))
			{
				mouseEvent.consume();
				resetOverlayManagementMode();
				return mouseEvent;
			}
		}

		// Check if the overlay is over a snapcorner and move it if so, unless it is a detached overlay
		if (currentManagedOverlay.getPosition() != OverlayPosition.DETACHED && inOverlayDraggingMode)
		{
			final OverlayBounds snapCorners = this.snapCorners.translated(-SNAP_CORNER_SIZE.width, -SNAP_CORNER_SIZE.height);

			for (Rectangle snapCorner : snapCorners.getBounds())
			{
				if (snapCorner.contains(mouseEvent.getPoint()))
				{
					OverlayPosition position = snapCorners.fromBounds(snapCorner);

					if (position == currentManagedOverlay.getPosition())
					{
						// overlay moves back to default position
						position = null;
					}

					currentManagedOverlay.setPreferredPosition(position);
					currentManagedOverlay.setPreferredLocation(null); // from dragging
					break;
				}
			}
		}

		overlayManager.saveOverlay(currentManagedOverlay);
		resetOverlayManagementMode();
		mouseEvent.consume();
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
			inOverlayManagingMode = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (!e.isAltDown() && inOverlayManagingMode)
		{
			inOverlayManagingMode = false;
			resetOverlayManagementMode();
		}
	}

	private void safeRender(Client client, Overlay overlay, OverlayLayer layer, Graphics2D graphics, Point point)
	{
		if (!isResizeable && (layer == OverlayLayer.ABOVE_SCENE || layer == OverlayLayer.UNDER_WIDGETS))
		{
			graphics.setClip(client.getViewportXOffset(),
				client.getViewportYOffset(),
				client.getViewportWidth(),
				client.getViewportHeight());
		}
		else
		{
			graphics.setClip(0, 0, client.getCanvasWidth(), client.getCanvasHeight());
		}

		final OverlayPosition position = overlay.getPosition();

		// Set font based on configuration
		if (position == OverlayPosition.DYNAMIC || position == OverlayPosition.DETACHED)
		{
			graphics.setFont(runeLiteConfig.fontType().getFont());
		}
		else if (position == OverlayPosition.TOOLTIP)
		{
			graphics.setFont(runeLiteConfig.tooltipFontType().getFont());
		}
		else
		{
			graphics.setFont(runeLiteConfig.interfaceFontType().getFont());
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
			log.warn("Error during overlay rendering", ex);
			return;
		}

		final Dimension dimension = MoreObjects.firstNonNull(overlayDimension, new Dimension());
		overlay.getBounds().setSize(dimension);
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
		List<OverlayMenuEntry> menuEntries = overlay.getMenuEntries();
		if (menuEntries.isEmpty())
		{
			return null;
		}

		final MenuEntry[] entries = new MenuEntry[menuEntries.size()];

		// Add in reverse order so they display correctly in the right-click menu
		for (int i = menuEntries.size() - 1; i >= 0; --i)
		{
			OverlayMenuEntry overlayMenuEntry = menuEntries.get(i);

			final MenuEntry entry = new MenuEntry();
			entry.setOption(overlayMenuEntry.getOption());
			entry.setTarget(ColorUtil.wrapWithColorTag(overlayMenuEntry.getTarget(), JagexColors.MENU_TARGET));
			entry.setType(overlayMenuEntry.getMenuAction().getId());
			entry.setIdentifier(overlayManager.getOverlays().indexOf(overlay)); // overlay id

			entries[i] = entry;
		}

		return entries;
	}
}
