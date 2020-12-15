/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ArrayListMultimap;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PluginChanged;

/**
 * Manages state of all game overlays
 */
@Singleton
public class OverlayManager
{
	public static final String OPTION_CONFIGURE = "Configure";

	private static final String OVERLAY_CONFIG_PREFERRED_LOCATION = "_preferredLocation";
	private static final String OVERLAY_CONFIG_PREFERRED_POSITION = "_preferredPosition";
	private static final String OVERLAY_CONFIG_PREFERRED_SIZE = "_preferredSize";
	private static final String RUNELITE_CONFIG_GROUP_NAME = RuneLiteConfig.class.getAnnotation(ConfigGroup.class).value();

	@VisibleForTesting
	static final Comparator<Overlay> OVERLAY_COMPARATOR = (a, b) ->
	{
		final OverlayPosition aPos = MoreObjects.firstNonNull(a.getPreferredPosition(), a.getPosition());
		final OverlayPosition bPos = MoreObjects.firstNonNull(b.getPreferredPosition(), b.getPosition());

		if (aPos != bPos)
		{
			// This is so non-dynamic overlays render after dynamic
			// overlays, which are generally in the scene
			return aPos.compareTo(bPos);
		}

		// For dynamic overlays, higher priority means to
		// draw *later* so it is on top.
		// For non-dynamic overlays, higher priority means
		// draw *earlier* so that they are closer to their
		// defined position.
		return aPos == OverlayPosition.DYNAMIC
			? a.getPriority().compareTo(b.getPriority())
			: b.getPriority().compareTo(a.getPriority());
	};

	/**
	 * Insertion-order sorted set of overlays
	 * All access to this must be guarded by a lock on this OverlayManager
	 */
	@Getter(AccessLevel.PACKAGE)
	private final List<Overlay> overlays = new ArrayList<>();
	@Getter
	@Setter
	private Collection<WidgetItem> widgetItems = Collections.emptyList();

	/**
	 * Valid keys are:
	 * OverlayLayer ABOVE_SCENE, UNDER_WIDGETS, and ALWAYS_ON_TOP
	 * A component id that is a layer
	 * An interface id << 16 | 0xffff
	 */
	private ArrayListMultimap<Object, Overlay> overlayMap = ArrayListMultimap.create();

	private final ConfigManager configManager;
	private final EventBus eventBus;
	private final RuneLiteConfig runeLiteConfig;

	@Inject
	private OverlayManager(final ConfigManager configManager, final EventBus eventBus, final RuneLiteConfig runeLiteConfig)
	{
		this.configManager = configManager;
		this.eventBus = eventBus;
		this.runeLiteConfig = runeLiteConfig;
	}

	@Subscribe
	public void onConfigChanged(final ConfigChanged event)
	{
		if (!RuneLiteConfig.GROUP_NAME.equals(event.getGroup()) || !"overlayBackgroundColor".equals(event.getKey()))
		{
			return;
		}

		overlays.forEach(this::updateOverlayConfig);
	}

	@Subscribe
	public void onPluginChanged(final PluginChanged event)
	{
		overlays.forEach(this::loadOverlay);
		rebuildOverlayLayers();
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		MenuAction menuAction = event.getMenuAction();
		if (menuAction != MenuAction.RUNELITE_OVERLAY && menuAction != MenuAction.RUNELITE_OVERLAY_CONFIG)
		{
			return;
		}

		event.consume();

		Overlay overlay = overlays.get(event.getId());
		if (overlay != null)
		{
			List<OverlayMenuEntry> menuEntries = overlay.getMenuEntries();
			OverlayMenuEntry overlayMenuEntry = menuEntries.stream()
				.filter(me -> me.getOption().equals(event.getMenuOption()))
				.findAny()
				.orElse(null);
			if (overlayMenuEntry != null)
			{
				eventBus.post(new OverlayMenuClicked(overlayMenuEntry, overlay));
			}
		}
	}

	/**
	 * Gets all of the overlays on a layer sorted by priority and position
	 *
	 * @param layer the layer
	 * @return An immutable list of all of the overlays on that layer
	 */
	Collection<Overlay> getLayer(OverlayLayer layer)
	{
		return Collections.unmodifiableCollection(overlayMap.get(layer));
	}

	Collection<Overlay> getForInterface(int interfaceId)
	{
		return Collections.unmodifiableCollection(overlayMap.get(interfaceId << 16 | 0xffff));
	}

	Collection<Overlay> getForLayer(int layerId)
	{
		return Collections.unmodifiableCollection(overlayMap.get(layerId));
	}

	/**
	 * Add overlay.
	 *
	 * @param overlay the overlay
	 * @return true if overlay was added
	 */
	public synchronized boolean add(final Overlay overlay)
	{
		if (overlays.contains(overlay))
		{
			return false;
		}

		// Add is always true
		overlays.add(overlay);
		loadOverlay(overlay);
		updateOverlayConfig(overlay);

		// WidgetItemOverlays have a reference to the overlay manager in order to get the WidgetItems
		// for each frame.
		if (overlay instanceof WidgetItemOverlay)
		{
			((WidgetItemOverlay) overlay).setOverlayManager(this);
		}

		rebuildOverlayLayers();
		return true;
	}

	/**
	 * Remove overlay.
	 *
	 * @param overlay the overlay
	 * @return true if overlay was removed
	 */
	public synchronized boolean remove(final Overlay overlay)
	{
		final boolean remove = overlays.remove(overlay);

		if (remove)
		{
			rebuildOverlayLayers();
		}

		return remove;
	}

	/**
	 * Remove if overlay matches filter
	 *
	 * @param filter the filter
	 * @return true if any overlay was removed
	 */
	public synchronized boolean removeIf(Predicate<Overlay> filter)
	{
		final boolean removeIf = overlays.removeIf(filter);

		if (removeIf)
		{
			rebuildOverlayLayers();
		}

		return removeIf;
	}

	/**
	 * Returns whether an overlay exists which matches the given predicate.
	 *
	 * @param filter Filter predicate function
	 * @return {@code true} if any overlays match the given filter, {@code false} otherwise
	 */
	public synchronized boolean anyMatch(Predicate<Overlay> filter)
	{
		return overlays.stream().anyMatch(filter);
	}

	/**
	 * Clear all overlays
	 */
	public synchronized void clear()
	{
		overlays.clear();
		rebuildOverlayLayers();
	}

	/**
	 * Force save overlay data
	 *
	 * @param overlay overlay to save
	 */
	public synchronized void saveOverlay(final Overlay overlay)
	{
		saveOverlayPosition(overlay);
		saveOverlaySize(overlay);
		saveOverlayLocation(overlay);
		rebuildOverlayLayers();
	}

	/**
	 * Resets stored overlay position data
	 *
	 * @param overlay overlay to reset
	 */
	public synchronized void resetOverlay(final Overlay overlay)
	{
		overlay.setPreferredPosition(null);
		overlay.setPreferredSize(null);
		overlay.setPreferredLocation(null);
		saveOverlay(overlay);
	}

	synchronized void rebuildOverlayLayers()
	{
		ArrayListMultimap<Object, Overlay> overlayMap = ArrayListMultimap.create();
		for (final Overlay overlay : overlays)
		{
			OverlayLayer layer = overlay.getLayer();

			if (overlay.getPreferredLocation() != null && overlay.getPreferredPosition() == null)
			{
				// When UNDER_WIDGET overlays are in preferred locations, move to
				// ABOVE_WIDGETS so that it can draw over interfaces
				if (layer == OverlayLayer.UNDER_WIDGETS && !(overlay instanceof WidgetOverlay))
				{
					layer = OverlayLayer.ABOVE_WIDGETS;
				}
			}

			switch (layer)
			{
				case ABOVE_SCENE:
				case UNDER_WIDGETS:
				case ALWAYS_ON_TOP:
					overlayMap.put(layer, overlay);
					break;
				case ABOVE_WIDGETS:
					// draw after each of the top level interfaces
					overlayMap.put(WidgetID.FIXED_VIEWPORT_GROUP_ID << 16 | 0xffff, overlay);
					overlayMap.put(WidgetID.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX_GROUP_ID << 16 | 0xffff, overlay);
					overlayMap.put(WidgetID.RESIZABLE_VIEWPORT_BOTTOM_LINE_GROUP_ID << 16 | 0xffff, overlay);
					break;
			}

			for (int drawHook : overlay.getDrawHooks())
			{
				overlayMap.put(drawHook, overlay);
			}
		}

		for (Object key : overlayMap.keys())
		{
			overlayMap.get(key).sort(OVERLAY_COMPARATOR);
		}

		this.overlayMap = overlayMap;
	}

	private void loadOverlay(final Overlay overlay)
	{
		final Point location = loadOverlayLocation(overlay);
		overlay.setPreferredLocation(location);
		final Dimension size = loadOverlaySize(overlay);
		overlay.setPreferredSize(size);
		final OverlayPosition position = loadOverlayPosition(overlay);
		overlay.setPreferredPosition(position);
	}

	private void updateOverlayConfig(final Overlay overlay)
	{
		if (overlay instanceof OverlayPanel)
		{
			// Update preferred color for overlay panels based on configuration
			((OverlayPanel) overlay).setPreferredColor(runeLiteConfig.overlayBackgroundColor());
		}
	}

	private void saveOverlayLocation(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		if (overlay.getPreferredLocation() != null)
		{
			configManager.setConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key,
				overlay.getPreferredLocation());
		}
		else
		{
			configManager.unsetConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key);
		}
	}

	private void saveOverlaySize(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_SIZE;
		if (overlay.getPreferredSize() != null)
		{
			configManager.setConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key,
				overlay.getPreferredSize());
		}
		else
		{
			configManager.unsetConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key);
		}
	}

	private void saveOverlayPosition(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_POSITION;
		if (overlay.getPreferredPosition() != null)
		{
			configManager.setConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key,
				overlay.getPreferredPosition());
		}
		else
		{
			configManager.unsetConfiguration(
				RUNELITE_CONFIG_GROUP_NAME,
				key);
		}
	}

	private Point loadOverlayLocation(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_LOCATION;
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, key, Point.class);
	}

	private Dimension loadOverlaySize(final Overlay overlay)
	{
		final String key = overlay.getName() + OVERLAY_CONFIG_PREFERRED_SIZE;
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, key, Dimension.class);
	}

	private OverlayPosition loadOverlayPosition(final Overlay overlay)
	{
		final String locationKey = overlay.getName() + OVERLAY_CONFIG_PREFERRED_POSITION;
		return configManager.getConfiguration(RUNELITE_CONFIG_GROUP_NAME, locationKey, OverlayPosition.class);
	}
}