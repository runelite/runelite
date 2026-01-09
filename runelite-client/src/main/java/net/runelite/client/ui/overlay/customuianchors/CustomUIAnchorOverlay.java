/*
 * Copyright (c) 2024, Car_role
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
package net.runelite.client.ui.overlay.customuianchors;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.KeyCode;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

/**
 * Renders the visual representation of custom UI anchors on the game canvas.
 * This overlay is always active to receive drag events, but only draws visuals when in management mode.
 */
@Singleton
public class CustomUIAnchorOverlay extends Overlay
{
	private static final Color ANCHOR_BORDER_COLOR = Color.CYAN;
	private static final Color ANCHOR_FILL_COLOR = new Color(0, 255, 255, 20);
	private static final Color ANCHOR_HOVER_COLOR = Color.YELLOW;
	private static final Color ANCHOR_DRAGGING_COLOR = Color.GREEN;
	private static final Color ANCHOR_DRAGGING_FILL_COLOR = new Color(0, 255, 0, 40);
	private static final Color RESIZE_HANDLE_COLOR = Color.WHITE;
	private static final Color CAPTURE_HIGHLIGHT_COLOR = new Color(0, 255, 0, 60);

	private final Client client;
	private final CustomUIAnchorManager customUIAnchorManager;
	private CustomUIAnchorPanel panel;

	@Inject
	public CustomUIAnchorOverlay(Client client, CustomUIAnchorManager customUIAnchorManager)
	{
		this.client = client;
		this.customUIAnchorManager = customUIAnchorManager;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		// Lower priority so other overlays can be selected first
		setPriority(-1.0f);
		setDragTargetable(true);
		setMovable(false);
		setPreferredLocation(new java.awt.Point(0, 0));
	}

	public void setPanel(CustomUIAnchorPanel panel)
	{
		this.panel = panel;
	}

	/**
	 * Check if anchors should be visible (panel open OR Alt held).
	 */
	private boolean isVisible()
	{
		boolean isPanelOpen = panel != null && panel.isShowing();
		boolean isAltHeld = client.isKeyPressed(KeyCode.KC_ALT);
		return isPanelOpen || isAltHeld;
	}

	@Override
	public boolean onDrag(Overlay other)
	{
		customUIAnchorManager.onOverlayDragged(other);
		return false;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Check if we should be visible
		boolean visible = isVisible();
		if (!visible)
		{
			// Return null - no bounds, doesn't block anything
			return null;
		}

		// Draw visual elements when visible
		graphics.setStroke(new BasicStroke(2));

		CustomUIAnchor draggingAnchor = customUIAnchorManager.getDraggedAnchor();
		net.runelite.api.Point mouseCanvasPos = client.getMouseCanvasPosition();
		java.awt.Point mousePosition = new java.awt.Point(mouseCanvasPos.getX(), mouseCanvasPos.getY());
		boolean isAltDown = client.isKeyPressed(KeyCode.KC_ALT);

		for (CustomUIAnchor anchor : customUIAnchorManager.getAnchors())
		{
			boolean isDraggingThis = draggingAnchor != null && draggingAnchor.getId() == anchor.getId();
			boolean isHovering = anchor.getBounds().contains(mousePosition);

			drawAnchor(graphics, anchor, isDraggingThis, isHovering, isAltDown);
		}

		// Return null - no bounds means we don't block other overlays
		// The onDrag callback still works when other overlays intersect with us
		return null;
	}

	private void drawAnchor(Graphics2D graphics, CustomUIAnchor anchor, boolean isDragging, boolean isHovering, boolean isAltDown)
	{
		boolean showHighlight = isDragging || (isHovering && isAltDown);

		Color borderColor = showHighlight ? (isDragging ? ANCHOR_DRAGGING_COLOR : ANCHOR_HOVER_COLOR) : ANCHOR_BORDER_COLOR;
		Color fillColor = isDragging ? ANCHOR_DRAGGING_FILL_COLOR : ANCHOR_FILL_COLOR;

		Rectangle bounds = anchor.getBounds();

		graphics.setColor(fillColor);
		graphics.fill(bounds);

		graphics.setColor(borderColor);
		graphics.draw(bounds);

		String label = anchor.getName();
		int textWidth = graphics.getFontMetrics().stringWidth(label);
		int textX = bounds.x + (bounds.width - textWidth) / 2;
		int textY = bounds.y + bounds.height / 2 + 5;

		graphics.setColor(Color.WHITE);
		graphics.drawString(label, textX, textY);

		if ((isHovering && isAltDown) || isDragging)
		{
			drawResizeHandles(graphics, bounds);
		}
	}

	private void drawResizeHandles(Graphics2D graphics, Rectangle bounds)
	{
		int size = 6;
		int half = size / 2;

		graphics.setColor(RESIZE_HANDLE_COLOR);

		graphics.fillRect(bounds.x - half, bounds.y - half, size, size);
		graphics.fillRect(bounds.x + bounds.width - half, bounds.y - half, size, size);
		graphics.fillRect(bounds.x - half, bounds.y + bounds.height - half, size, size);
		graphics.fillRect(bounds.x + bounds.width - half, bounds.y + bounds.height - half, size, size);

		graphics.fillRect(bounds.x + bounds.width / 2 - half, bounds.y - half, size, size);
		graphics.fillRect(bounds.x + bounds.width / 2 - half, bounds.y + bounds.height - half, size, size);
		graphics.fillRect(bounds.x - half, bounds.y + bounds.height / 2 - half, size, size);
		graphics.fillRect(bounds.x + bounds.width - half, bounds.y + bounds.height / 2 - half, size, size);
	}
}
