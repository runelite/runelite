/*
 * Copyright (c) 2025, Car_role
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ClientTick;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ProfileChanged;

/**
 * Manages overlay anchors for custom UI positioning.
 * This is a core component that integrates with OverlayRenderer.
 */
@Singleton
@Slf4j
public class OverlayAnchorManager
{
	private static final String OVERLAY_CONFIG_ANCHOR_ID = "_anchorId";
	private static final String ANCHORS_CONFIG_KEY = "overlayAnchors";
	private static final String SAVED_CANVAS_SIZE_KEY = "savedCanvasSize";
	private static final String RUNELITE_CONFIG_GROUP_NAME = RuneLiteConfig.class.getAnnotation(ConfigGroup.class).value();
	private static final Gson GSON = new Gson();
	private static final int RESIZE_HANDLE_SIZE = 8;
	private static final long STARTUP_GRACE_PERIOD_MS = 2000;

	private final ConfigManager configManager;
	private final Client client;
	private final OverlayManager overlayManager;
	private final EventBus eventBus;

	@Getter
	private final List<OverlayAnchor> anchors = new CopyOnWriteArrayList<>();
	private final Map<String, Integer> overlayAnchorAssignments = new HashMap<>();
	private final Map<String, Overlay> trackedOverlays = new HashMap<>();
	// Stores the order of overlays within each anchor (anchorId -> list of overlay names in order)
	private final Map<Integer, List<String>> anchorOverlayOrder = new HashMap<>();
	private int nextAnchorId = 1;
	private static final int PADDING = 2;

	@Getter
	@Setter
	private boolean managementModeActive = false;

	@Getter
	@Setter
	private OverlayAnchor draggedAnchor = null;

	@Getter
	@Setter
	private boolean anchorDragging = false;

	@Getter
	@Setter
	private boolean anchorResizing = false;

	@Getter
	@Setter
	private int resizeDirection = 0;

	// Resize direction constants
	public static final int NORTH = 1;
	public static final int SOUTH = 2;
	public static final int EAST = 4;
	public static final int WEST = 8;

	// Window resize handling
	private Dimension lastViewportSize = null;
	private Dimension savedCanvasSize = null;
	private long lastResizeTime = 0;
	private long startupTime = 0;
	private boolean started = false;
	private boolean initialRepositionDone = false;
	private static final long INITIAL_REPOSITION_DELAY_MS = 1000;

	// Anchor drag state
	private Point dragStartPoint = null;
	private Rectangle originalBounds = null;

	// Overlay being dragged - skip repositioning for this overlay
	@Getter
	@Setter
	private Overlay currentlyDraggedOverlay = null;

	// Callback for when an anchor is selected (e.g., Alt+Click)
	private java.util.function.Consumer<OverlayAnchor> anchorSelectedCallback = null;

	public void setAnchorSelectedCallback(java.util.function.Consumer<OverlayAnchor> callback)
	{
		this.anchorSelectedCallback = callback;
	}

	public void notifyAnchorSelected(OverlayAnchor anchor)
	{
		if (anchorSelectedCallback != null)
		{
			anchorSelectedCallback.accept(anchor);
		}
	}

	@Inject
	public OverlayAnchorManager(ConfigManager configManager, Client client, OverlayManager overlayManager, EventBus eventBus)
	{
		this.configManager = configManager;
		this.client = client;
		this.overlayManager = overlayManager;
		this.eventBus = eventBus;
	}

	public void startUp()
	{
		startupTime = System.currentTimeMillis();
		started = true;
		eventBus.register(this);
		loadAnchors();
		loadOverlayAnchorAssignments();
		loadSavedCanvasSize();
	}

	public void shutDown()
	{
		started = false;
		eventBus.unregister(this);
		saveCanvasSize();
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged event)
	{
		loadAnchors();
		loadOverlayAnchorAssignments();
	}

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		handleWindowResize();
		positionOverlays();
	}

	public void loadAnchors()
	{
		anchors.clear();
		overlayAnchorAssignments.clear();

		String json = configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, ANCHORS_CONFIG_KEY);
		if (json != null && !json.isEmpty())
		{
			try
			{
				Type listType = new TypeToken<List<OverlayAnchor>>()
				{
				}.getType();
				List<OverlayAnchor> loaded = GSON.fromJson(json, listType);
				if (loaded != null)
				{
					anchors.addAll(loaded);
					for (OverlayAnchor anchor : anchors)
					{
						if (anchor.getId() >= nextAnchorId)
						{
							nextAnchorId = anchor.getId() + 1;
						}
					}
				}
			}
			catch (Exception e)
			{
				log.warn("Failed to load anchors", e);
			}
		}
	}

	public void saveAnchors()
	{
		try
		{
			String json = GSON.toJson(anchors);
			configManager.setConfiguration(RUNELITE_CONFIG_GROUP_NAME, ANCHORS_CONFIG_KEY, json);
		}
		catch (Exception e)
		{
			log.warn("Failed to save anchors", e);
		}
	}

	public OverlayAnchor createAnchor(String name, int x, int y, int width, int height)
	{
		OverlayAnchor anchor = new OverlayAnchor(nextAnchorId++, name, x, y, width, height);
		anchors.add(anchor);
		saveAnchors();
		return anchor;
	}

	public void deleteAnchor(OverlayAnchor anchor)
	{
		anchors.remove(anchor);
		overlayAnchorAssignments.entrySet().removeIf(entry -> entry.getValue() == anchor.getId());
		saveAnchors();
	}

	public void updateAnchor(OverlayAnchor anchor)
	{
		saveAnchors();
		// Force immediate repositioning of overlays in this anchor
		// This ensures alignment/stacking changes take effect immediately
		forceRepositionOverlaysInAnchor(anchor);
	}

	/**
	 * Force repositioning of overlays in a specific anchor, bypassing the Alt-key check.
	 * Used when anchor properties (alignment, stacking) are changed via the panel.
	 */
	private void forceRepositionOverlaysInAnchor(OverlayAnchor anchor)
	{
		List<Overlay> overlaysInAnchor = new ArrayList<>();
		for (Map.Entry<String, Overlay> entry : trackedOverlays.entrySet())
		{
			String overlayId = entry.getKey();
			Overlay overlay = entry.getValue();
			Integer assignedAnchorId = overlayAnchorAssignments.get(overlayId);
			if (assignedAnchorId != null && assignedAnchorId == anchor.getId() && overlay.isMovable())
			{
				overlaysInAnchor.add(overlay);
			}
		}
		if (!overlaysInAnchor.isEmpty())
		{
			layoutOverlaysInAnchor(anchor, overlaysInAnchor);
		}
	}

	@Nullable
	public OverlayAnchor getAnchor(int id)
	{
		for (OverlayAnchor anchor : anchors)
		{
			if (anchor.getId() == id)
			{
				return anchor;
			}
		}
		return null;
	}

	@Nullable
	public OverlayAnchor getAnchorAt(Point point)
	{
		for (OverlayAnchor anchor : anchors)
		{
			if (anchor.getBounds().contains(point))
			{
				return anchor;
			}
		}
		return null;
	}

	public void assignOverlayToAnchor(Overlay overlay, OverlayAnchor anchor)
	{
		overlayAnchorAssignments.put(overlay.getName(), anchor.getId());
		saveOverlayAnchorId(overlay, anchor.getId());
	}

	public void unassignOverlayFromAnchor(Overlay overlay)
	{
		overlayAnchorAssignments.remove(overlay.getName());
		saveOverlayAnchorId(overlay, null);
	}

	@Nullable
	public Integer getOverlayAnchorId(Overlay overlay)
	{
		return overlayAnchorAssignments.get(overlay.getName());
	}

	@Nullable
	public OverlayAnchor getOverlayAnchor(Overlay overlay)
	{
		Integer anchorId = getOverlayAnchorId(overlay);
		if (anchorId == null)
		{
			return null;
		}
		return getAnchor(anchorId);
	}

	public List<Overlay> getOverlaysForAnchor(OverlayAnchor anchor)
	{
		List<Overlay> result = new ArrayList<>();
		overlayManager.anyMatch(overlay ->
		{
			Integer anchorId = overlayAnchorAssignments.get(overlay.getName());
			if (anchorId != null && anchorId == anchor.getId())
			{
				result.add(overlay);
			}
			return false;
		});
		return result;
	}

	/**
	 * Calculate the position for an overlay based on its anchor assignment.
	 * Returns null if the overlay is not assigned to an anchor.
	 * 
	 * NOTE: This method now always returns null because we no longer continuously
	 * reposition overlays. Overlays are only positioned when:
	 * 1. Dropped into an anchor (via onOverlayDragEnd)
	 * 2. Anchor properties change (via forceRepositionOverlaysInAnchor)
	 * This prevents teleporting on Alt press/release.
	 */
	@Nullable
	public Point calculateOverlayPosition(Overlay overlay)
	{
		// For overlays assigned to anchors, return the anchor-calculated position
		// This ensures the anchor position takes priority over any saved config location
		if (overlay == null)
		{
			return null;
		}

		String overlayId = overlay.getName();
		Integer anchorId = overlayAnchorAssignments.get(overlayId);
		if (anchorId == null)
		{
			return null;
		}

		OverlayAnchor anchor = getAnchor(anchorId);
		if (anchor == null)
		{
			return null;
		}

		// Get all overlays in this anchor and calculate positions
		List<Overlay> overlaysInAnchor = getOverlaysInAnchor(anchor);
		if (overlaysInAnchor.isEmpty())
		{
			return null;
		}

		// Calculate the position for this specific overlay within the anchor
		return calculatePositionInAnchor(overlay, anchor, overlaysInAnchor);
	}

	/**
	 * Calculate the position for a specific overlay within an anchor.
	 */
	@Nullable
	private Point calculatePositionInAnchor(Overlay targetOverlay, OverlayAnchor anchor, List<Overlay> overlays)
	{
		// Sort overlays by their saved order
		List<String> savedOrder = anchorOverlayOrder.get(anchor.getId());
		if (savedOrder != null && !savedOrder.isEmpty())
		{
			overlays.sort((a, b) ->
			{
				int indexA = savedOrder.indexOf(a.getName());
				int indexB = savedOrder.indexOf(b.getName());
				if (indexA == -1)
				{
					indexA = Integer.MAX_VALUE;
				}
				if (indexB == -1)
				{
					indexB = Integer.MAX_VALUE;
				}
				return Integer.compare(indexA, indexB);
			});
		}
		else
		{
			overlays.sort(Comparator.comparingInt(o -> o.getBounds().y));
		}

		OverlayAnchorStacking stacking = anchor.getStacking();
		if (stacking == null)
		{
			stacking = OverlayAnchorStacking.VERTICAL;
		}

		int totalLayoutWidth = 0;
		int totalLayoutHeight = 0;
		int currentX = 0;
		int currentY = 0;
		int rowMaxH = 0;
		int colMaxW = 0;

		// Calculate relative positions for all overlays
		Map<Overlay, Rectangle> relativeBounds = new HashMap<>();
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

			int xPos = 0;
			int yPos = 0;

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
			relativeBounds.put(overlay, new Rectangle(xPos, yPos, w, h));
		}

		// Calculate start position based on alignment
		OverlayAnchorAlignment align = anchor.getAlignment();
		if (align == null)
		{
			align = OverlayAnchorAlignment.CENTER;
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
				startY = anchor.getY() + (anchor.getHeight() - totalLayoutHeight) / 2;
				break;
			default:
				break;
		}

		// Find the target overlay's position
		Rectangle rel = relativeBounds.get(targetOverlay);
		if (rel == null)
		{
			return null;
		}

		int targetX = startX + rel.x;
		int targetY = startY + rel.y;

		OverlayAnchorStacking finalStacking = stacking;
		if (finalStacking == OverlayAnchorStacking.VERTICAL)
		{
			targetX = startX + (totalLayoutWidth - rel.width) / 2;
		}
		if (finalStacking == OverlayAnchorStacking.HORIZONTAL)
		{
			targetY = startY + (totalLayoutHeight - rel.height) / 2;
		}

		return new Point(targetX, targetY);
	}

	public Dimension getCanvasSize()
	{
		return client.getRealDimensions();
	}

	private void saveOverlayAnchorId(Overlay overlay, Integer anchorId)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_ANCHOR_ID;
		if (anchorId != null)
		{
			configManager.setConfiguration(RUNELITE_CONFIG_GROUP_NAME, key, anchorId);
		}
		else
		{
			configManager.unsetConfiguration(RUNELITE_CONFIG_GROUP_NAME, key);
		}
	}

	public void loadOverlayAnchorAssignments()
	{
		overlayAnchorAssignments.clear();
		overlayManager.anyMatch(overlay ->
		{
			final String key = overlay.getName() + OVERLAY_CONFIG_ANCHOR_ID;
			Integer anchorId = configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, key, Integer.class);
			if (anchorId != null)
			{
				overlayAnchorAssignments.put(overlay.getName(), anchorId);
			}
			return false;
		});
	}

	// ==================== Window Resize Handling ====================

	private void handleWindowResize()
	{
		Dimension currentSize = client.getRealDimensions();
		if (currentSize == null)
		{
			return;
		}

		// On first run, adjust anchors based on saved canvas size vs current canvas size
		// This handles the case where the panel was open/closed between sessions
		if (lastViewportSize == null)
		{
			lastViewportSize = currentSize;
			if (savedCanvasSize != null && !savedCanvasSize.equals(currentSize))
			{
				int deltaW = currentSize.width - savedCanvasSize.width;
				int deltaH = currentSize.height - savedCanvasSize.height;
				log.debug("Adjusting anchors for canvas size change on startup: saved={}x{}, current={}x{}",
					savedCanvasSize.width, savedCanvasSize.height, currentSize.width, currentSize.height);
				for (OverlayAnchor anchor : anchors)
				{
					updateAnchorForResize(anchor, deltaW, deltaH);
				}
				// Save the adjusted positions
				saveAnchors();
			}
			// Update saved canvas size to current
			saveCanvasSize();
			return;
		}

		if (!lastViewportSize.equals(currentSize))
		{
			lastResizeTime = System.currentTimeMillis();
			int deltaW = currentSize.width - lastViewportSize.width;
			int deltaH = currentSize.height - lastViewportSize.height;

			for (OverlayAnchor anchor : anchors)
			{
				updateAnchorForResize(anchor, deltaW, deltaH);
				// Reposition overlays in this anchor to match new anchor position
				forceRepositionOverlaysInAnchor(anchor);
			}

			// Clamp anchors to stay within canvas bounds after resize
			clampAnchorsToBounds();

			lastViewportSize = currentSize;
			saveAnchors();
			// Save canvas size so we can adjust on next startup if panel state changes
			saveCanvasSize();
		}
	}

	private void updateAnchorForResize(OverlayAnchor anchor, int deltaW, int deltaH)
	{
		OverlayAnchorConstraint constraint = anchor.getConstraint();
		if (constraint == null)
		{
			constraint = OverlayAnchorConstraint.TOP_LEFT;
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

	private void loadSavedCanvasSize()
	{
		String json = configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, SAVED_CANVAS_SIZE_KEY);
		if (json != null && !json.isEmpty())
		{
			try
			{
				savedCanvasSize = GSON.fromJson(json, Dimension.class);
			}
			catch (Exception e)
			{
				log.warn("Failed to load saved canvas size", e);
			}
		}
	}

	private void saveCanvasSize()
	{
		Dimension currentSize = client.getRealDimensions();
		if (currentSize != null)
		{
			try
			{
				String json = GSON.toJson(currentSize);
				configManager.setConfiguration(RUNELITE_CONFIG_GROUP_NAME, SAVED_CANVAS_SIZE_KEY, json);
			}
			catch (Exception e)
			{
				log.warn("Failed to save canvas size", e);
			}
		}
	}

	// ==================== Anchor Dragging/Resizing ====================

	public void startAnchorDrag(OverlayAnchor anchor, Point mousePoint, int direction)
	{
		draggedAnchor = anchor;
		dragStartPoint = mousePoint;
		originalBounds = new Rectangle(anchor.getBounds());
		resizeDirection = direction;
		anchorDragging = true;
		anchorResizing = direction != 0;

		// Notify panel to select this anchor
		notifyAnchorSelected(anchor);
	}

	public void updateAnchorDrag(Point currentPoint)
	{
		if (draggedAnchor == null || dragStartPoint == null || originalBounds == null)
		{
			return;
		}

		int dx = currentPoint.x - dragStartPoint.x;
		int dy = currentPoint.y - dragStartPoint.y;

		if (anchorResizing)
		{
			handleAnchorResize(dx, dy);
		}
		else
		{
			handleAnchorMove(dx, dy);
		}

		// Reposition overlays in real-time as anchor moves/resizes
		forceRepositionOverlaysInAnchor(draggedAnchor);
	}

	public void endAnchorDrag()
	{
		if (draggedAnchor != null)
		{
			saveAnchors();
			// Reposition overlays inside this anchor to match new anchor position
			forceRepositionOverlaysInAnchor(draggedAnchor);
		}
		draggedAnchor = null;
		dragStartPoint = null;
		originalBounds = null;
		anchorDragging = false;
		anchorResizing = false;
		resizeDirection = 0;
	}

	private void handleAnchorMove(int dx, int dy)
	{
		draggedAnchor.setX(originalBounds.x + dx);
		draggedAnchor.setY(originalBounds.y + dy);
	}

	private void handleAnchorResize(int dx, int dy)
	{
		int x = originalBounds.x;
		int y = originalBounds.y;
		int w = originalBounds.width;
		int h = originalBounds.height;

		if ((resizeDirection & WEST) != 0)
		{
			x += dx;
			w -= dx;
		}
		if ((resizeDirection & EAST) != 0)
		{
			w += dx;
		}
		if ((resizeDirection & NORTH) != 0)
		{
			y += dy;
			h -= dy;
		}
		if ((resizeDirection & SOUTH) != 0)
		{
			h += dy;
		}

		// Minimum size (20 pixels)
		if (w < 20)
		{
			if ((resizeDirection & WEST) != 0)
			{
				x = originalBounds.x + originalBounds.width - 20;
			}
			w = 20;
		}
		if (h < 20)
		{
			if ((resizeDirection & NORTH) != 0)
			{
				y = originalBounds.y + originalBounds.height - 20;
			}
			h = 20;
		}

		draggedAnchor.setX(x);
		draggedAnchor.setY(y);
		draggedAnchor.setWidth(w);
		draggedAnchor.setHeight(h);
	}

	public boolean isNearResizeHandle(Rectangle bounds, Point p)
	{
		Rectangle expanded = new Rectangle(
			bounds.x - RESIZE_HANDLE_SIZE / 2,
			bounds.y - RESIZE_HANDLE_SIZE / 2,
			bounds.width + RESIZE_HANDLE_SIZE,
			bounds.height + RESIZE_HANDLE_SIZE);
		Rectangle inner = new Rectangle(
			bounds.x + RESIZE_HANDLE_SIZE,
			bounds.y + RESIZE_HANDLE_SIZE,
			bounds.width - 2 * RESIZE_HANDLE_SIZE,
			bounds.height - 2 * RESIZE_HANDLE_SIZE);
		return expanded.contains(p) && !inner.contains(p);
	}

	public int getResizeDirectionAt(Rectangle bounds, Point p)
	{
		int dir = 0;
		int buffer = RESIZE_HANDLE_SIZE;

		boolean nearTop = p.y >= bounds.y - buffer && p.y <= bounds.y + buffer;
		boolean nearBottom = p.y >= bounds.y + bounds.height - buffer && p.y <= bounds.y + bounds.height + buffer;
		boolean nearLeft = p.x >= bounds.x - buffer && p.x <= bounds.x + buffer;
		boolean nearRight = p.x >= bounds.x + bounds.width - buffer && p.x <= bounds.x + bounds.width + buffer;

		if (nearTop)
		{
			dir |= NORTH;
		}
		if (nearBottom)
		{
			dir |= SOUTH;
		}
		if (nearLeft)
		{
			dir |= WEST;
		}
		if (nearRight)
		{
			dir |= EAST;
		}

		return dir;
	}

	public long getLastResizeTime()
	{
		return lastResizeTime;
	}

	// ==================== Overlay Positioning ====================

	private void positionOverlays()
	{
		if (anchors.isEmpty())
		{
			return;
		}

		// Periodically try to re-acquire overlay references for saved assignments
		if (!overlayAnchorAssignments.isEmpty() && trackedOverlays.size() < overlayAnchorAssignments.size())
		{
			scanAndReacquireOverlays();
		}

		cleanupTrackedOverlays();

		// After startup delay, do one-time reposition of all anchored overlays
		// This ensures overlays are correctly positioned after they've had a chance to render
		// and have valid bounds. We check every tick until all overlays have valid bounds.
		if (!initialRepositionDone && (System.currentTimeMillis() - startupTime) > INITIAL_REPOSITION_DELAY_MS)
		{
			boolean allOverlaysHaveValidBounds = true;
			for (Overlay overlay : trackedOverlays.values())
			{
				if (overlay.getBounds().width <= 0 || overlay.getBounds().height <= 0)
				{
					allOverlaysHaveValidBounds = false;
					break;
				}
			}

			if (allOverlaysHaveValidBounds || (System.currentTimeMillis() - startupTime) > 3000)
			{
				initialRepositionDone = true;
				for (OverlayAnchor anchor : anchors)
				{
					forceRepositionOverlaysInAnchor(anchor);
				}
				log.debug("Initial overlay repositioning complete");
			}
		}

		// IMPORTANT: We do NOT continuously reposition overlays here anymore.
		// Overlays are only positioned when:
		// 1. They are first dropped into an anchor (via onOverlayDroppedInAnchor)
		// 2. Anchor properties change (via forceRepositionOverlaysInAnchor)
		// 3. Window is resized (handled separately)
		// 4. Initial startup reposition (once, after delay)
		// This prevents the "teleporting" behavior on Alt press/release.
	}

	private void layoutOverlaysInAnchor(OverlayAnchor anchor, List<Overlay> overlays)
	{
		// Sort overlays by their saved order in this anchor, or by Y position if no order saved
		List<String> savedOrder = anchorOverlayOrder.get(anchor.getId());
		if (savedOrder != null && !savedOrder.isEmpty())
		{
			overlays.sort((a, b) ->
			{
				int indexA = savedOrder.indexOf(a.getName());
				int indexB = savedOrder.indexOf(b.getName());
				// If not in saved order, put at end
				if (indexA == -1)
				{
					indexA = Integer.MAX_VALUE;
				}
				if (indexB == -1)
				{
					indexB = Integer.MAX_VALUE;
				}
				return Integer.compare(indexA, indexB);
			});
		}
		else
		{
			// No saved order - use Y position as initial order
			overlays.sort(Comparator.comparingInt(o -> o.getBounds().y));
		}

		OverlayAnchorStacking stacking = anchor.getStacking();
		if (stacking == null)
		{
			stacking = OverlayAnchorStacking.VERTICAL;
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

			int xPos = 0;
			int yPos = 0;

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

		OverlayAnchorAlignment align = anchor.getAlignment();
		if (align == null)
		{
			align = OverlayAnchorAlignment.CENTER;
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

			if (stacking == OverlayAnchorStacking.VERTICAL)
			{
				targetX = startX + (totalLayoutWidth - rel.width) / 2;
			}
			if (stacking == OverlayAnchorStacking.HORIZONTAL)
			{
				targetY = startY + (totalLayoutHeight - rel.height) / 2;
			}

			// Skip repositioning if this overlay is currently being dragged
			if (overlay == currentlyDraggedOverlay)
			{
				continue;
			}

			if (overlay.getPreferredPosition() != OverlayPosition.DYNAMIC)
			{
				overlay.setPreferredPosition(OverlayPosition.DYNAMIC);
			}

			// Set overlay to render on top of OSRS native UI when inside an anchor
			if (overlay.getLayer() != OverlayLayer.ALWAYS_ON_TOP)
			{
				overlay.setLayer(OverlayLayer.ALWAYS_ON_TOP);
			}

			Point currentLoc = overlay.getPreferredLocation();
			if (currentLoc == null || currentLoc.x != targetX || currentLoc.y != targetY)
			{
				overlay.setPreferredLocation(new Point(targetX, targetY));
			}
		}
	}

	private void scanAndReacquireOverlays()
	{
		if (overlayAnchorAssignments.isEmpty())
		{
			return;
		}

		// Track which anchors need repositioning
		Set<Integer> anchorsToReposition = new HashSet<>();

		overlayManager.anyMatch(overlay ->
		{
			if (overlay == null || !overlay.isMovable())
			{
				return false;
			}

			String overlayId = overlay.getName();

			if (overlayAnchorAssignments.containsKey(overlayId) && !trackedOverlays.containsKey(overlayId))
			{
				trackedOverlays.put(overlayId, overlay);
				Integer anchorId = overlayAnchorAssignments.get(overlayId);
				anchorsToReposition.add(anchorId);
				log.debug("Re-acquired overlay {} for anchor {}", overlayId, anchorId);
			}

			return false;
		});

		// Reposition overlays in anchors that had overlays re-acquired
		for (Integer anchorId : anchorsToReposition)
		{
			OverlayAnchor anchor = getAnchor(anchorId);
			if (anchor != null)
			{
				forceRepositionOverlaysInAnchor(anchor);
			}
		}
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

	// ==================== Overlay Drag Detection ====================

	/**
	 * Called when an overlay is being dragged. Checks if it should be captured by or released from an anchor.
	 * Uses mouse position to determine capture/release.
	 * Note: Does NOT reposition the overlay - that only happens on drop (onOverlayDragEnd).
	 */
	public void onOverlayDragged(Overlay overlay, Point mousePosition)
	{
		if (overlay == null || !overlay.isMovable())
		{
			return;
		}

		String overlayId = overlay.getName();
		OverlayAnchor targetAnchor = getAnchorAt(mousePosition);
		Integer currentAssignment = overlayAnchorAssignments.get(overlayId);

		if (targetAnchor != null)
		{
			// Mouse is inside an anchor - mark this overlay as assigned to that anchor
			if (currentAssignment == null || currentAssignment != targetAnchor.getId())
			{
				overlayAnchorAssignments.put(overlayId, targetAnchor.getId());
				saveOverlayAnchorId(overlay, targetAnchor.getId());
				// Track the overlay
				if (!trackedOverlays.containsKey(overlayId))
				{
					trackedOverlays.put(overlayId, overlay);
				}
				log.debug("Assigned overlay {} to anchor {}", overlayId, targetAnchor.getName());
			}
		}
		else
		{
			// Mouse is outside all anchors - release this overlay if it was assigned
			if (currentAssignment != null)
			{
				overlayAnchorAssignments.remove(overlayId);
				saveOverlayAnchorId(overlay, null);
				log.debug("Released overlay {} from anchor (mouse outside)", overlayId);
			}
		}
	}

	/**
	 * Called when an overlay drag ends (mouse released).
	 * If the overlay is inside an anchor, snap it to the anchor's alignment.
	 */
	public void onOverlayDragEnd(Overlay overlay, Point mousePosition)
	{
		if (overlay == null || !overlay.isMovable())
		{
			return;
		}

		String overlayId = overlay.getName();

		// Check if mouse is over an anchor at drop time
		OverlayAnchor targetAnchor = getAnchorAt(mousePosition);

		if (targetAnchor != null)
		{
			// Dropped inside an anchor - assign and snap
			overlayAnchorAssignments.put(overlayId, targetAnchor.getId());
			saveOverlayAnchorId(overlay, targetAnchor.getId());

			// Track the overlay
			if (!trackedOverlays.containsKey(overlayId))
			{
				trackedOverlays.put(overlayId, overlay);
			}

			// Get all overlays in this anchor
			List<Overlay> overlaysInAnchor = getOverlaysInAnchor(targetAnchor);
			if (!overlaysInAnchor.contains(overlay))
			{
				overlaysInAnchor.add(overlay);
			}

			// Sort by current Y position to determine new order based on where user dropped
			overlaysInAnchor.sort(Comparator.comparingInt(o ->
			{
				Point loc = o.getPreferredLocation();
				return loc != null ? loc.y : o.getBounds().y;
			}));

			// Save this order for future layouts
			List<String> newOrder = new ArrayList<>();
			for (Overlay o : overlaysInAnchor)
			{
				newOrder.add(o.getName());
			}
			anchorOverlayOrder.put(targetAnchor.getId(), newOrder);

			// Now layout with the new order
			layoutOverlaysInAnchor(targetAnchor, overlaysInAnchor);
			log.debug("Snapped overlay {} to anchor {} alignment, order: {}", overlayId, targetAnchor.getName(), newOrder);
		}
		else
		{
			// Dropped outside all anchors - unassign if was assigned
			Integer currentAssignment = overlayAnchorAssignments.get(overlayId);
			if (currentAssignment != null)
			{
				overlayAnchorAssignments.remove(overlayId);
				saveOverlayAnchorId(overlay, null);
				// Restore overlay to normal layer when removed from anchor
				if (overlay.getLayer() == OverlayLayer.ALWAYS_ON_TOP)
				{
					overlay.setLayer(OverlayLayer.UNDER_WIDGETS);
				}
				log.debug("Released overlay {} from anchor (dropped outside)", overlayId);
			}
		}
	}

	/**
	 * Get all overlays currently assigned to an anchor.
	 */
	private List<Overlay> getOverlaysInAnchor(OverlayAnchor anchor)
	{
		List<Overlay> result = new ArrayList<>();
		for (Map.Entry<String, Overlay> entry : trackedOverlays.entrySet())
		{
			String overlayId = entry.getKey();
			Overlay overlay = entry.getValue();
			Integer assignedAnchorId = overlayAnchorAssignments.get(overlayId);
			if (assignedAnchorId != null && assignedAnchorId == anchor.getId() && overlay.isMovable())
			{
				result.add(overlay);
			}
		}
		return result;
	}

	/**
	 * Clamp anchor positions to stay within the game canvas bounds.
	 */
	public void clampAnchorsToBounds()
	{
		Dimension canvasSize = client.getRealDimensions();
		if (canvasSize == null)
		{
			return;
		}

		for (OverlayAnchor anchor : anchors)
		{
			int x = anchor.getX();
			int y = anchor.getY();
			int w = anchor.getWidth();
			int h = anchor.getHeight();

			// Clamp position to keep anchor visible
			if (x < 0)
			{
				x = 0;
			}
			if (y < 0)
			{
				y = 0;
			}
			if (x + w > canvasSize.width)
			{
				x = Math.max(0, canvasSize.width - w);
			}
			if (y + h > canvasSize.height)
			{
				y = Math.max(0, canvasSize.height - h);
			}

			if (x != anchor.getX() || y != anchor.getY())
			{
				anchor.setX(x);
				anchor.setY(y);
			}
		}
	}

	/**
	 * Check if an overlay is assigned to any anchor.
	 */
	public boolean isOverlayAssigned(Overlay overlay)
	{
		if (overlay == null)
		{
			return false;
		}
		return overlayAnchorAssignments.containsKey(overlay.getName());
	}
}
