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
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
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
		final OverlayPosition aPos = a.getPreferredPosition() != null
			? a.getPreferredPosition()
			: a.getPosition();

		final OverlayPosition bPos = b.getPreferredPosition() != null
			? b.getPreferredPosition()
			: b.getPosition();

		if (aPos != bPos)
		{
			// This is so non-dynamic overlays render after dynamic
			// overlays, which are generally in the scene
			return aPos.compareTo(bPos);
		}

		// For dynamic overlays, higher priority means to
		// draw *later* so it is on top.
		// For non-dynamic overlays, higher priority means
		// draw *first* so that they are closer to their
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

	private final Map<OverlayLayer, List<Overlay>> overlayLayers = new EnumMap<>(OverlayLayer.class);

	private final ConfigManager configManager;
	private final EventBus eventBus;

	@Inject
	private OverlayManager(final ConfigManager configManager, final EventBus eventBus)
	{
		this.configManager = configManager;
		this.eventBus = eventBus;
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
		if (event.getMenuAction() != MenuAction.RUNELITE_OVERLAY)
		{
			return;
		}

		event.consume();

		Optional<Overlay> optionalOverlay = overlays.stream().filter(o -> overlays.indexOf(o) == event.getId()).findAny();
		if (optionalOverlay.isPresent())
		{
			Overlay overlay = optionalOverlay.get();
			List<OverlayMenuEntry> menuEntries = overlay.getMenuEntries();
			Optional<OverlayMenuEntry> optionalOverlayMenuEntry = menuEntries.stream()
				.filter(me -> me.getOption().equals(event.getMenuOption()))
				.findAny();
			if (optionalOverlayMenuEntry.isPresent())
			{
				eventBus.post(new OverlayMenuClicked(optionalOverlayMenuEntry.get(), overlay));
			}
		}
	}

	/**
	 * Gets all of the overlays on a layer sorted by priority and position
	 *
	 * @param layer the layer
	 * @return An immutable list of all of the overlays on that layer
	 */
	synchronized List<Overlay> getLayer(OverlayLayer layer)
	{
		return overlayLayers.get(layer);
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

	private synchronized void rebuildOverlayLayers()
	{
		for (OverlayLayer l : OverlayLayer.values())
		{
			overlayLayers.put(l, new ArrayList<>());
		}

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

			overlayLayers.get(layer).add(overlay);
		}

		overlayLayers.forEach((layer, value) ->
		{
			value.sort(OVERLAY_COMPARATOR);
			overlayLayers.put(layer, Collections.unmodifiableList(value));
		});
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