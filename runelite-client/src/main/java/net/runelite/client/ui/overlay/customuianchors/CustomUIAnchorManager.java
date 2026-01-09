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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.KeyCode;
import net.runelite.api.events.ClientTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayPosition;

/**
 * Manages custom UI anchors and overlay assignments for custom UI positioning.
 */
@Singleton
@Slf4j
public class CustomUIAnchorManager
{
	private static final String CONFIG_GROUP = "customUIAnchors";
	private static final String CONFIG_KEY_ANCHORS = "anchors";
	private static final String CONFIG_KEY_ASSIGNMENTS = "assignments";
	private static final String CONFIG_KEY_SAVED_CANVAS_SIZE = "savedCanvasSize";
	private static final int PADDING = 2;
	private static final long STARTUP_GRACE_PERIOD_MS = 2000;

	private final Client client;
	private final ConfigManager configManager;
	private final OverlayManager overlayManager;
	private final Gson gson;
	private final EventBus eventBus;

	@Getter
	private final List<CustomUIAnchor> anchors = new CopyOnWriteArrayList<>();

	private final Map<String, Integer> overlayAssignments = new HashMap<>();
	private final Map<String, Overlay> trackedOverlays = new HashMap<>();

	private Dimension lastViewportSize = null;
	private Dimension savedCanvasSize = null;
	private long lastResizeTime = 0;
	private long startupTime = 0;

	@Getter
	private boolean anchorDragging = false;

	@Getter
	private CustomUIAnchor draggedAnchor = null;

	@Setter
	private CustomUIAnchorPanel panel = null;

	@Inject
	public CustomUIAnchorManager(
		Client client,
		ConfigManager configManager,
		OverlayManager overlayManager,
		Gson gson,
		EventBus eventBus
	)
	{
		this.client = client;
		this.configManager = configManager;
		this.overlayManager = overlayManager;
		this.gson = gson;
		this.eventBus = eventBus;
	}

	public void startUp()
	{
		startupTime = System.currentTimeMillis();
		eventBus.register(this);
		loadAnchors();
		loadAssignments();
		loadSavedCanvasSize();
		scanAndReacquireOverlays();
	}

	public void shutDown()
	{
		eventBus.unregister(this);
		anchors.clear();
		overlayAssignments.clear();
		trackedOverlays.clear();
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged event)
	{
		loadAnchors();
		loadAssignments();
		scanAndReacquireOverlays();
	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		handleWindowResize();
		positionOverlays();
	}

	/**
	 * Check if an overlay is assigned to any custom UI anchor.
	 */
	public boolean isAssigned(Overlay overlay)
	{
		if (overlay == null)
		{
			return false;
		}
		String overlayId = getOverlayId(overlay);
		return overlayAssignments.containsKey(overlayId);
	}

	/**
	 * Get the custom UI anchor an overlay is assigned to.
	 */
	public CustomUIAnchor getAssignedAnchor(Overlay overlay)
	{
		if (overlay == null)
		{
			return null;
		}
		String overlayId = getOverlayId(overlay);
		Integer anchorId = overlayAssignments.get(overlayId);
		if (anchorId == null)
		{
			return null;
		}
		return anchors.stream()
			.filter(a -> a.getId() == anchorId)
			.findFirst()
			.orElse(null);
	}

	/**
	 * Create a new custom UI anchor at the center of the viewport.
	 */
	public CustomUIAnchor createAnchor()
	{
		int nextId = 1;
		List<Integer> ids = new ArrayList<>();
		for (CustomUIAnchor a : anchors)
		{
			ids.add(a.getId());
		}
		Collections.sort(ids);

		for (int id : ids)
		{
			if (id == nextId)
			{
				nextId++;
			}
			else
			{
				break;
			}
		}

		Dimension viewport = client.getRealDimensions();
		int x = viewport != null ? viewport.width / 2 - 50 : 100;
		int y = viewport != null ? viewport.height / 2 - 50 : 100;

		CustomUIAnchor anchor = new CustomUIAnchor(
			nextId,
			"Anchor " + nextId,
			x,
			y,
			100,
			100,
			AnchorConstraint.TOP_LEFT,
			AnchorAlignment.CENTER,
			AnchorStacking.VERTICAL
		);

		anchors.add(anchor);
		saveAnchors();
		return anchor;
	}

	/**
	 * Delete a custom UI anchor and unassign all overlays from it.
	 */
	public void deleteAnchor(CustomUIAnchor anchor)
	{
		if (anchor == null)
		{
			return;
		}

		overlayAssignments.entrySet().removeIf(e -> e.getValue() == anchor.getId());
		anchors.remove(anchor);
		saveAnchors();
		saveAssignments();
	}

	/**
	 * Update an anchor's properties and save.
	 */
	public void updateAnchor(CustomUIAnchor anchor)
	{
		saveAnchors();
	}

	/**
	 * Assign an overlay to a custom UI anchor.
	 */
	public void assignOverlay(Overlay overlay, CustomUIAnchor anchor)
	{
		if (overlay == null || anchor == null)
		{
			return;
		}

		String overlayId = getOverlayId(overlay);
		overlayAssignments.put(overlayId, anchor.getId());
		trackedOverlays.put(overlayId, overlay);
		saveAssignments();
		log.debug("Assigned overlay {} to anchor {}", overlayId, anchor.getName());
	}

	/**
	 * Unassign an overlay from its current anchor.
	 */
	public void unassignOverlay(Overlay overlay)
	{
		if (overlay == null)
		{
			return;
		}

		String overlayId = getOverlayId(overlay);
		if (overlayAssignments.remove(overlayId) != null)
		{
			saveAssignments();
			log.debug("Unassigned overlay {}", overlayId);
		}
	}

	/**
	 * Called when an overlay is dragged. Checks if it should be captured by a custom UI anchor.
	 */
	public void onOverlayDragged(Overlay overlay)
	{
		if (overlay == null || !overlay.isMovable())
		{
			return;
		}

		// Don't capture our own overlay
		if (overlay instanceof CustomUIAnchorOverlay)
		{
			return;
		}

		String overlayId = getOverlayId(overlay);

		if (!trackedOverlays.containsKey(overlayId))
		{
			trackedOverlays.put(overlayId, overlay);
		}

		Rectangle overlayBounds = overlay.getBounds();
		if (overlayBounds.isEmpty())
		{
			Point loc = overlay.getPreferredLocation();
			if (loc == null)
			{
				return;
			}
			Dimension size = overlay.getPreferredSize();
			if (size == null)
			{
				size = new Dimension(100, 20);
			}
			overlayBounds = new Rectangle(loc.x, loc.y, size.width, size.height);
		}

		Point center = new Point((int) overlayBounds.getCenterX(), (int) overlayBounds.getCenterY());

		boolean foundInAnchor = false;
		for (CustomUIAnchor anchor : anchors)
		{
			if (anchor.getBounds().contains(center))
			{
				Integer currentAssignment = overlayAssignments.get(overlayId);
				if (currentAssignment == null || currentAssignment != anchor.getId())
				{
					overlayAssignments.put(overlayId, anchor.getId());
					saveAssignments();
					log.debug("Captured overlay {} into anchor {}", overlayId, anchor.getName());
				}
				foundInAnchor = true;
				break;
			}
		}

		if (!foundInAnchor && overlayAssignments.containsKey(overlayId))
		{
			overlayAssignments.remove(overlayId);
			saveAssignments();
			log.debug("Released overlay {} from all anchors", overlayId);
		}
	}

	/**
	 * Set the dragging state for custom UI anchors.
	 */
	public void setAnchorDragging(boolean dragging, CustomUIAnchor anchor)
	{
		this.anchorDragging = dragging;
		this.draggedAnchor = anchor;
	}

	/**
	 * Check if the anchor management UI should be visible.
	 * Returns true if panel is open OR Alt is held.
	 */
	public boolean isManagementModeActive()
	{
		boolean isPanelOpen = panel != null && panel.isShowing();
		boolean isAltHeld = client.isKeyPressed(KeyCode.KC_ALT);
		return isPanelOpen || isAltHeld;
	}

	/**
	 * Get the current canvas size.
	 */
	public Dimension getCanvasSize()
	{
		return client.getRealDimensions();
	}

	private void handleWindowResize()
	{
		Dimension currentSize = client.getRealDimensions();
		if (currentSize == null)
		{
			return;
		}

		// During startup grace period, adjust anchors to match saved canvas size
		// This handles the case where panel was open when saved but closed on restart
		boolean inStartupGrace = (System.currentTimeMillis() - startupTime) < STARTUP_GRACE_PERIOD_MS;
		if (inStartupGrace && savedCanvasSize != null && lastViewportSize == null)
		{
			lastViewportSize = currentSize;
			if (!savedCanvasSize.equals(currentSize))
			{
				int deltaW = currentSize.width - savedCanvasSize.width;
				int deltaH = currentSize.height - savedCanvasSize.height;
				log.debug("Adjusting anchors for canvas size change: saved={}x{}, current={}x{}, delta={}x{}",
					savedCanvasSize.width, savedCanvasSize.height, currentSize.width, currentSize.height, deltaW, deltaH);

				for (CustomUIAnchor anchor : anchors)
				{
					updateAnchorForResize(anchor, deltaW, deltaH);
				}
			}
			return;
		}

		if (lastViewportSize == null)
		{
			lastViewportSize = currentSize;
			return;
		}

		if (!lastViewportSize.equals(currentSize))
		{
			lastResizeTime = System.currentTimeMillis();
			int deltaW = currentSize.width - lastViewportSize.width;
			int deltaH = currentSize.height - lastViewportSize.height;

			for (CustomUIAnchor anchor : anchors)
			{
				updateAnchorForResize(anchor, deltaW, deltaH);
			}

			lastViewportSize = currentSize;
			saveAnchors();
		}
	}

	private void updateAnchorForResize(CustomUIAnchor anchor, int deltaW, int deltaH)
	{
		AnchorConstraint constraint = anchor.getConstraint();
		if (constraint == null)
		{
			constraint = AnchorConstraint.TOP_LEFT;
		}

		switch (constraint)
		{
			case BOTTOM_LEFT:
			case BOTTOM_CENTER:
			case BOTTOM_RIGHT:
				anchor.setY(anchor.getY() + deltaH);
				break;
			case CENTER_LEFT:
			case CENTER:
			case CENTER_RIGHT:
				anchor.setY(anchor.getY() + deltaH / 2);
				break;
			default:
				break;
		}

		switch (constraint)
		{
			case TOP_RIGHT:
			case CENTER_RIGHT:
			case BOTTOM_RIGHT:
				anchor.setX(anchor.getX() + deltaW);
				break;
			case TOP_CENTER:
			case BOTTOM_CENTER:
			case CENTER:
				anchor.setX(anchor.getX() + deltaW / 2);
				break;
			default:
				break;
		}
	}

	private void positionOverlays()
	{
		if (anchors.isEmpty())
		{
			return;
		}

		// Periodically try to re-acquire overlay references for saved assignments
		// This handles the case where overlays weren't loaded yet on startup
		if (!overlayAssignments.isEmpty() && trackedOverlays.size() < overlayAssignments.size())
		{
			scanAndReacquireOverlays();
		}

		boolean isAltDown = client.isKeyPressed(KeyCode.KC_ALT);
		boolean isResizing = (System.currentTimeMillis() - lastResizeTime) < 500;
		boolean isDraggingAnchor = anchorDragging;

		// Lock assignments unless Alt is held AND we're not resizing AND we're not dragging an anchor
		// This matches the original plugin's behavior
		boolean allowAssignmentChanges = isAltDown && !isResizing && !isDraggingAnchor;

		cleanupTrackedOverlays();

		// When Alt is held, scan ALL overlays to detect new captures
		if (allowAssignmentChanges)
		{
			scanAllOverlaysForCapture();
		}

		Map<Integer, List<Overlay>> buckets = new HashMap<>();
		for (CustomUIAnchor a : anchors)
		{
			buckets.put(a.getId(), new ArrayList<>());
		}

		for (Map.Entry<String, Overlay> entry : trackedOverlays.entrySet())
		{
			String overlayId = entry.getKey();
			Overlay overlay = entry.getValue();

			if (!overlay.isMovable())
			{
				continue;
			}

			Rectangle overlayBounds = overlay.getBounds();
			if (overlayBounds.isEmpty())
			{
				Point loc = overlay.getPreferredLocation();
				if (loc == null)
				{
					continue;
				}
				Dimension size = overlay.getPreferredSize();
				if (size == null)
				{
					size = new Dimension(100, 20);
				}
				overlayBounds = new Rectangle(loc.x, loc.y, size.width, size.height);
			}

			Point center = new Point((int) overlayBounds.getCenterX(), (int) overlayBounds.getCenterY());
			Integer assignedAnchorId = overlayAssignments.get(overlayId);

			if (allowAssignmentChanges)
			{
				// Capture phase - check if overlay moved into a different anchor or out of all anchors
				boolean foundInAnchor = false;
				for (CustomUIAnchor anchor : anchors)
				{
					if (anchor.getBounds().contains(center))
					{
						if (assignedAnchorId == null || assignedAnchorId != anchor.getId())
						{
							overlayAssignments.put(overlayId, anchor.getId());
							saveAssignments();
							log.debug("Captured overlay {} into anchor {}", overlayId, anchor.getName());
						}
						buckets.get(anchor.getId()).add(overlay);
						foundInAnchor = true;
						break;
					}
				}

				// If moved out of all anchors, unassign
				if (!foundInAnchor && overlayAssignments.containsKey(overlayId))
				{
					overlayAssignments.remove(overlayId);
					saveAssignments();
					log.debug("Released overlay {} from all anchors", overlayId);
				}
			}
			else
			{
				// Maintenance phase - just add to bucket if assigned
				if (assignedAnchorId != null && buckets.containsKey(assignedAnchorId))
				{
					buckets.get(assignedAnchorId).add(overlay);
				}
			}
		}

		// Always reposition assigned overlays - this ensures:
		// - Overlays snap immediately when captured
		// - Overlays follow anchor when anchor is dragged
		// - Overlays stay in position when Alt is released
		for (CustomUIAnchor anchor : anchors)
		{
			List<Overlay> overlays = buckets.get(anchor.getId());
			if (overlays.isEmpty())
			{
				continue;
			}

			layoutOverlaysInAnchor(anchor, overlays);
		}
	}

	private void layoutOverlaysInAnchor(CustomUIAnchor anchor, List<Overlay> overlays)
	{
		overlays.sort(Comparator.comparingInt(o -> o.getBounds().y));

		AnchorStacking stacking = anchor.getStacking();
		if (stacking == null)
		{
			stacking = AnchorStacking.VERTICAL;
		}

		List<Rectangle> relativeBounds = new ArrayList<>();
		int totalLayoutWidth = 0;
		int totalLayoutHeight = 0;

		int currentX = 0;
		int currentY = 0;
		int rowMaxH = 0;
		int colMaxW = 0;

		for (Overlay overlay : overlays)
		{
			int w = overlay.getBounds().width;
			if (w <= 0)
			{
				w = overlay.getPreferredSize() != null ? overlay.getPreferredSize().width : 100;
			}
			int h = overlay.getBounds().height;
			if (h <= 0)
			{
				h = overlay.getPreferredSize() != null ? overlay.getPreferredSize().height : 24;
			}

			int xPos = 0, yPos = 0;

			switch (stacking)
			{
				case VERTICAL:
					xPos = 0;
					yPos = currentY;
					currentY += h + PADDING;
					totalLayoutWidth = Math.max(totalLayoutWidth, w);
					totalLayoutHeight = currentY - PADDING;
					break;

				case HORIZONTAL:
					xPos = currentX;
					yPos = 0;
					currentX += w + PADDING;
					totalLayoutHeight = Math.max(totalLayoutHeight, h);
					totalLayoutWidth = currentX - PADDING;
					break;

				case FILL_HORIZONTAL:
					if (currentX + w > anchor.getWidth() && currentX > 0)
					{
						currentX = 0;
						currentY += rowMaxH + PADDING;
						rowMaxH = 0;
					}
					xPos = currentX;
					yPos = currentY;
					currentX += w + PADDING;
					rowMaxH = Math.max(rowMaxH, h);
					totalLayoutWidth = Math.max(totalLayoutWidth, xPos + w);
					totalLayoutHeight = Math.max(totalLayoutHeight, yPos + h);
					break;

				case FILL_VERTICAL:
					if (currentY + h > anchor.getHeight() && currentY > 0)
					{
						currentY = 0;
						currentX += colMaxW + PADDING;
						colMaxW = 0;
					}
					xPos = currentX;
					yPos = currentY;
					currentY += h + PADDING;
					colMaxW = Math.max(colMaxW, w);
					totalLayoutWidth = Math.max(totalLayoutWidth, xPos + w);
					totalLayoutHeight = Math.max(totalLayoutHeight, yPos + h);
					break;
			}
			relativeBounds.add(new Rectangle(xPos, yPos, w, h));
		}

		AnchorAlignment align = anchor.getAlignment();
		if (align == null)
		{
			align = AnchorAlignment.CENTER;
		}

		int startX = anchor.getX();
		int startY = anchor.getY();

		switch (align)
		{
			case TOP_RIGHT:
			case CENTER_RIGHT:
			case BOTTOM_RIGHT:
				startX = anchor.getX() + anchor.getWidth() - totalLayoutWidth;
				break;
			case TOP_CENTER:
			case BOTTOM_CENTER:
			case CENTER:
			case STRETCH:
				startX = anchor.getX() + (anchor.getWidth() - totalLayoutWidth) / 2;
				break;
			default:
				break;
		}

		switch (align)
		{
			case BOTTOM_LEFT:
			case BOTTOM_CENTER:
			case BOTTOM_RIGHT:
				startY = anchor.getY() + anchor.getHeight() - totalLayoutHeight;
				break;
			case CENTER_LEFT:
			case CENTER:
			case CENTER_RIGHT:
			case STRETCH:
				startY = anchor.getY() + (anchor.getHeight() - totalLayoutHeight) / 2;
				break;
			default:
				break;
		}

		for (int i = 0; i < overlays.size(); i++)
		{
			Overlay overlay = overlays.get(i);
			Rectangle rel = relativeBounds.get(i);

			int targetX = startX + rel.x;
			int targetY = startY + rel.y;

			if (stacking == AnchorStacking.VERTICAL)
			{
				targetX = startX + (totalLayoutWidth - rel.width) / 2;
			}
			if (stacking == AnchorStacking.HORIZONTAL)
			{
				targetY = startY + (totalLayoutHeight - rel.height) / 2;
			}

			if (overlay.getPreferredPosition() != OverlayPosition.DYNAMIC)
			{
				overlay.setPreferredPosition(OverlayPosition.DYNAMIC);
			}

			Point currentLoc = overlay.getPreferredLocation();
			if (currentLoc == null || currentLoc.x != targetX || currentLoc.y != targetY)
			{
				overlay.setPreferredLocation(new Point(targetX, targetY));
			}
		}
	}

	/**
	 * Scan ALL overlays to detect if any overlay is being dragged into/out of an anchor.
	 * Association is based on MOUSE POSITION while dragging, not overlay center.
	 * This ensures associations only happen when user explicitly drags into an anchor.
	 */
	private void scanAllOverlaysForCapture()
	{
		// Get current mouse position - this is what determines capture/release
		net.runelite.api.Point mouseCanvasPos = client.getMouseCanvasPosition();
		final Point mousePos = new Point(mouseCanvasPos.getX(), mouseCanvasPos.getY());

		// Find which anchor the mouse is currently over (if any)
		final CustomUIAnchor targetAnchor = findAnchorAtPoint(mousePos);

		overlayManager.anyMatch(overlay ->
		{
			if (overlay == null || !overlay.isMovable())
			{
				return false;
			}

			// Don't capture our own overlay
			if (overlay instanceof CustomUIAnchorOverlay)
			{
				return false;
			}

			String overlayId = getOverlayId(overlay);

			// Get overlay bounds to check if mouse is over this overlay (being dragged)
			Rectangle overlayBounds = overlay.getBounds();
			if (overlayBounds.isEmpty())
			{
				Point loc = overlay.getPreferredLocation();
				if (loc == null)
				{
					return false;
				}
				Dimension size = overlay.getPreferredSize();
				if (size == null)
				{
					size = new Dimension(100, 20);
				}
				overlayBounds = new Rectangle(loc.x, loc.y, size.width, size.height);
			}

			// Check if mouse is over this overlay (user is dragging it)
			// Use a small tolerance around the overlay bounds
			Rectangle dragBounds = new Rectangle(overlayBounds);
			dragBounds.grow(20, 20); // Small tolerance for drag detection

			if (!dragBounds.contains(mousePos))
			{
				// Mouse is not near this overlay, skip it
				return false;
			}

			// Track this overlay since user is interacting with it
			if (!trackedOverlays.containsKey(overlayId))
			{
				trackedOverlays.put(overlayId, overlay);
				log.debug("Started tracking overlay {}", overlayId);
			}

			Integer currentAssignment = overlayAssignments.get(overlayId);

			if (targetAnchor != null)
			{
				// Mouse is inside an anchor - capture this overlay to that anchor
				if (currentAssignment == null || currentAssignment != targetAnchor.getId())
				{
					overlayAssignments.put(overlayId, targetAnchor.getId());
					saveAssignments();
					log.debug("Captured overlay {} into anchor {}", overlayId, targetAnchor.getName());
				}
			}
			else
			{
				// Mouse is outside all anchors - release this overlay if it was assigned
				if (currentAssignment != null)
				{
					overlayAssignments.remove(overlayId);
					saveAssignments();
					log.debug("Released overlay {} from anchor (mouse outside)", overlayId);
				}
			}

			return false;
		});
	}

	private CustomUIAnchor findAnchorAtPoint(Point point)
	{
		for (CustomUIAnchor anchor : anchors)
		{
			if (anchor.getBounds().contains(point))
			{
				return anchor;
			}
		}
		return null;
	}

	private void scanAndReacquireOverlays()
	{
		if (overlayAssignments.isEmpty())
		{
			return;
		}

		overlayManager.anyMatch(overlay ->
		{
			if (overlay == null || !overlay.isMovable())
			{
				return false;
			}

			String overlayId = getOverlayId(overlay);

			if (overlayAssignments.containsKey(overlayId) && !trackedOverlays.containsKey(overlayId))
			{
				trackedOverlays.put(overlayId, overlay);
				log.debug("Re-acquired overlay {} for anchor {}", overlayId, overlayAssignments.get(overlayId));
			}

			return false;
		});

		log.debug("Re-acquired {} overlay references out of {} assignments",
			trackedOverlays.size(), overlayAssignments.size());
	}

	private void cleanupTrackedOverlays()
	{
		trackedOverlays.entrySet().removeIf(entry ->
		{
			Overlay overlay = entry.getValue();
			boolean exists = overlayManager.anyMatch(o -> o == overlay);
			if (!exists)
			{
				log.debug("Removed stale overlay reference: {}", entry.getKey());
			}
			return !exists;
		});
	}

	private String getOverlayId(Overlay overlay)
	{
		// Use overlay name if available (e.g., WidgetOverlay has unique names)
		// Fall back to class name for other overlays
		String name = overlay.getName();
		if (name != null && !name.isEmpty())
		{
			return name;
		}
		return overlay.getClass().getName();
	}

	private void loadAnchors()
	{
		anchors.clear();
		String json = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY_ANCHORS);
		if (json == null || json.isEmpty())
		{
			return;
		}

		try
		{
			Type listType = new TypeToken<List<CustomUIAnchor>>()
			{
			}.getType();
			List<CustomUIAnchor> loaded = gson.fromJson(json, listType);
			if (loaded != null)
			{
				anchors.addAll(loaded);
			}
		}
		catch (Exception e)
		{
			log.error("Failed to load custom UI anchors", e);
		}
	}

	public void saveAnchors()
	{
		String json = gson.toJson(anchors);
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_ANCHORS, json);
		saveCanvasSize();
	}

	private void saveCanvasSize()
	{
		Dimension currentSize = client.getRealDimensions();
		if (currentSize != null)
		{
			String sizeStr = currentSize.width + "x" + currentSize.height;
			configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_SAVED_CANVAS_SIZE, sizeStr);
		}
	}

	private void loadSavedCanvasSize()
	{
		String sizeStr = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY_SAVED_CANVAS_SIZE);
		if (sizeStr != null && sizeStr.contains("x"))
		{
			try
			{
				String[] parts = sizeStr.split("x");
				int width = Integer.parseInt(parts[0]);
				int height = Integer.parseInt(parts[1]);
				savedCanvasSize = new Dimension(width, height);
				log.debug("Loaded saved canvas size: {}x{}", width, height);
			}
			catch (NumberFormatException e)
			{
				log.warn("Failed to parse saved canvas size: {}", sizeStr);
			}
		}
	}

	private void loadAssignments()
	{
		overlayAssignments.clear();
		String json = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY_ASSIGNMENTS);
		if (json == null || json.isEmpty())
		{
			return;
		}

		try
		{
			Type type = new TypeToken<Map<String, Integer>>()
			{
			}.getType();
			Map<String, Integer> loaded = gson.fromJson(json, type);
			if (loaded != null)
			{
				overlayAssignments.putAll(loaded);
			}
		}
		catch (Exception e)
		{
			log.warn("Failed to load overlay assignments", e);
		}
	}

	private void saveAssignments()
	{
		String json = gson.toJson(overlayAssignments);
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY_ASSIGNMENTS, json);
	}
}
