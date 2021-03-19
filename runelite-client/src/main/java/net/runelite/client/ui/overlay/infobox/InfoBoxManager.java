/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay.infobox;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.InfoBoxMenuClicked;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;
import net.runelite.client.util.AsyncBufferedImage;

@Singleton
@Slf4j
public class InfoBoxManager
{
	private static final String INFOBOXLAYER_KEY = "infoboxlayer";
	private static final String INFOBOXOVERLAY_KEY = "infoboxoverlay";
	private static final String INFOBOXOVERLAY_ORIENTATION_PREFIX = "orient_";
	private static final String DEFAULT_LAYER = "InfoBoxOverlay";

	private static final String DETACH = "Detach";
	private static final String FLIP = "Flip";
	private static final String DELETE = "Delete";

	private static final OverlayMenuEntry DETACH_ME = new OverlayMenuEntry(MenuAction.RUNELITE_INFOBOX, DETACH, "InfoBox");
	private static final OverlayMenuEntry FLIP_ME = new OverlayMenuEntry(MenuAction.RUNELITE_INFOBOX, FLIP, "InfoBox Group");
	private static final OverlayMenuEntry DELETE_ME = new OverlayMenuEntry(MenuAction.RUNELITE_INFOBOX, DELETE, "InfoBox Group");

	private final Map<String, InfoBoxOverlay> layers = new ConcurrentHashMap<>();

	private final RuneLiteConfig runeLiteConfig;
	private final TooltipManager tooltipManager;
	private final Client client;
	private final EventBus eventBus;
	private final OverlayManager overlayManager;
	private final ConfigManager configManager;

	@Inject
	private InfoBoxManager(
		final RuneLiteConfig runeLiteConfig,
		final TooltipManager tooltipManager,
		final Client client,
		final EventBus eventBus,
		final OverlayManager overlayManager,
		final ConfigManager configManager)
	{
		this.runeLiteConfig = runeLiteConfig;
		this.tooltipManager = tooltipManager;
		this.client = client;
		this.eventBus = eventBus;
		this.overlayManager = overlayManager;
		this.configManager = configManager;
		eventBus.register(this);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("runelite") && event.getKey().equals("infoBoxSize"))
		{
			layers.values().forEach(l -> l.getInfoBoxes().forEach(this::updateInfoBoxImage));
		}
	}

	@Subscribe
	public void onInfoBoxMenuClicked(InfoBoxMenuClicked event)
	{
		if (DETACH.equals(event.getEntry().getOption()))
		{
			// The layer name doesn't matter as long as it is unique
			splitInfobox(event.getInfoBox().getName() + "_" + System.currentTimeMillis(), event.getInfoBox());
		}
		else if (FLIP.equals(event.getEntry().getOption()))
		{
			InfoBoxOverlay infoBoxOverlay = layers.get(getLayer(event.getInfoBox()));
			ComponentOrientation newOrientation = infoBoxOverlay.flip();
			setOrientation(infoBoxOverlay.getName(), newOrientation);
		}
		else if (DELETE.equals(event.getEntry().getOption()))
		{
			// This is just a merge into the default layer
			InfoBoxOverlay source = layers.get(getLayer(event.getInfoBox()));
			InfoBoxOverlay dest = layers.computeIfAbsent(DEFAULT_LAYER, this::makeOverlay);
			if (source != dest)
			{
				mergeInfoBoxes(source, dest);
			}
		}
	}

	public void addInfoBox(InfoBox infoBox)
	{
		Preconditions.checkNotNull(infoBox);
		log.debug("Adding InfoBox {}", infoBox);

		updateInfoBoxImage(infoBox);

		String layerName = getLayer(infoBox);
		InfoBoxOverlay overlay = layers.computeIfAbsent(layerName, this::makeOverlay);
		List<OverlayMenuEntry> menuEntries = infoBox.getMenuEntries();
		menuEntries.add(DETACH_ME);
		menuEntries.add(FLIP_ME);
		if (!layerName.equals(DEFAULT_LAYER))
		{
			// Non default-group infoboxes have a delete option to delete the group
			menuEntries.add(DELETE_ME);
		}

		synchronized (this)
		{
			int idx = findInsertionIndex(overlay.getInfoBoxes(), infoBox, (b1, b2) -> ComparisonChain
				.start()
				.compare(b1.getPriority(), b2.getPriority())
				.compare(b1.getPlugin().getName(), b2.getPlugin().getName())
				.result());
			overlay.getInfoBoxes().add(idx, infoBox);
		}

		BufferedImage image = infoBox.getImage();

		if (image instanceof AsyncBufferedImage)
		{
			AsyncBufferedImage abi = (AsyncBufferedImage) image;
			abi.onLoaded(() -> updateInfoBoxImage(infoBox));
		}
	}

	public synchronized void removeInfoBox(InfoBox infoBox)
	{
		if (infoBox == null)
		{
			return;
		}

		if (layers.get(getLayer(infoBox)).getInfoBoxes().remove(infoBox))
		{
			log.debug("Removed InfoBox {}", infoBox);
		}

		infoBox.getMenuEntries().remove(DETACH_ME);
		infoBox.getMenuEntries().remove(FLIP_ME);
		infoBox.getMenuEntries().remove(DELETE_ME);
	}

	public synchronized void removeIf(Predicate<InfoBox> filter)
	{
		for (InfoBoxOverlay overlay : layers.values())
		{
			if (overlay.getInfoBoxes().removeIf(filter))
			{
				log.debug("Removed InfoBoxes for filter {} from {}", filter, overlay);
			}
		}
	}

	public List<InfoBox> getInfoBoxes()
	{
		return layers.values().stream().map(InfoBoxOverlay::getInfoBoxes).flatMap(Collection::stream).collect(Collectors.toList());
	}

	public synchronized void cull()
	{
		layers.values().forEach(l -> l.getInfoBoxes().removeIf(InfoBox::cull));
	}

	public void updateInfoBoxImage(final InfoBox infoBox)
	{
		if (infoBox.getImage() == null)
		{
			return;
		}

		// Set scaled InfoBox image
		final BufferedImage image = infoBox.getImage();
		BufferedImage resultImage = image;
		final double width = image.getWidth(null);
		final double height = image.getHeight(null);
		final double size = Math.max(2, runeLiteConfig.infoBoxSize()); // Limit size to 2 as that is minimum size not causing breakage

		if (size < width || size < height)
		{
			final double scalex = size / width;
			final double scaley = size / height;

			if (scalex == 1 && scaley == 1)
			{
				return;
			}

			final double scale = Math.min(scalex, scaley);
			final int newWidth = (int) (width * scale);
			final int newHeight = (int) (height * scale);
			final BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
			final Graphics g = scaledImage.createGraphics();
			g.drawImage(image, 0, 0, newWidth, newHeight, null);
			g.dispose();
			resultImage = scaledImage;
		}

		infoBox.setScaledImage(resultImage);
	}

	private InfoBoxOverlay makeOverlay(String name)
	{
		ComponentOrientation orientation = getOrientation(name);
		if (orientation == null)
		{
			if (name.equals(DEFAULT_LAYER))
			{
				// Fall back to old orientation config option
				orientation = runeLiteConfig.infoBoxVertical() ? ComponentOrientation.VERTICAL : ComponentOrientation.HORIZONTAL;
				setOrientation(name, orientation);
			}
			else
			{
				// Default infobox orientation
				orientation = ComponentOrientation.HORIZONTAL;
			}
		}

		InfoBoxOverlay infoBoxOverlay = new InfoBoxOverlay(
			this,
			tooltipManager,
			client,
			runeLiteConfig,
			eventBus,
			name,
			orientation);
		overlayManager.add(infoBoxOverlay);
		eventBus.register(infoBoxOverlay);
		return infoBoxOverlay;
	}

	private void removeOverlay(InfoBoxOverlay overlay)
	{
		unsetOrientation(overlay.getName());
		eventBus.unregister(overlay);
		overlayManager.remove(overlay);
		layers.remove(overlay.getName());
	}

	private synchronized void splitInfobox(String newLayer, InfoBox infoBox)
	{
		String layer = getLayer(infoBox);
		InfoBoxOverlay oldOverlay = layers.get(layer);
		// Find all infoboxes with the same name, as they are all within the same group and so move at once.
		Collection<InfoBox> filtered = oldOverlay.getInfoBoxes().stream()
			.filter(i -> i.getName().equals(infoBox.getName())).collect(Collectors.toList());

		oldOverlay.getInfoBoxes().removeAll(filtered);
		if (oldOverlay.getInfoBoxes().isEmpty())
		{
			log.debug("Deleted layer: {}", oldOverlay.getName());
			removeOverlay(oldOverlay);
		}

		InfoBoxOverlay newOverlay = layers.computeIfAbsent(newLayer, this::makeOverlay);
		newOverlay.getInfoBoxes().addAll(filtered);

		// Adjust config for new infoboxes
		for (InfoBox i : filtered)
		{
			setLayer(i, newLayer);

			if (!i.getMenuEntries().contains(DELETE_ME))
			{
				i.getMenuEntries().add(DELETE_ME);
			}
		}

		log.debug("Moving infobox named {} (layer {}) to layer {}: {} boxes", infoBox.getName(), layer, newLayer, filtered.size());
	}

	public synchronized void mergeInfoBoxes(InfoBoxOverlay source, InfoBoxOverlay dest)
	{
		Collection<InfoBox> infoBoxesToMove = source.getInfoBoxes();
		boolean isDefault = dest.getName().equals(DEFAULT_LAYER);

		log.debug("Merging InfoBoxes from {} into {} ({} boxes)", source.getName(), dest.getName(), infoBoxesToMove.size());

		for (InfoBox infoBox : infoBoxesToMove)
		{
			setLayer(infoBox, dest.getName());

			if (isDefault)
			{
				infoBox.getMenuEntries().remove(DELETE_ME);
			}
		}

		dest.getInfoBoxes().addAll(infoBoxesToMove);
		source.getInfoBoxes().clear();

		// remove source
		removeOverlay(source);
		log.debug("Deleted layer: {}", source.getName());
	}

	private String getLayer(InfoBox infoBox)
	{
		String name = configManager.getConfiguration(INFOBOXLAYER_KEY, infoBox.getName());
		if (Strings.isNullOrEmpty(name))
		{
			return DEFAULT_LAYER;
		}

		return name;
	}

	private void setLayer(InfoBox infoBox, String layer)
	{
		if (layer.equals(DEFAULT_LAYER))
		{
			configManager.unsetConfiguration(INFOBOXLAYER_KEY, infoBox.getName());
		}
		else
		{
			configManager.setConfiguration(INFOBOXLAYER_KEY, infoBox.getName(), layer);
		}
	}

	ComponentOrientation getOrientation(String name)
	{
		return configManager.getConfiguration(INFOBOXOVERLAY_KEY, INFOBOXOVERLAY_ORIENTATION_PREFIX + name, ComponentOrientation.class);
	}

	void setOrientation(String name, ComponentOrientation orientation)
	{
		configManager.setConfiguration(INFOBOXOVERLAY_KEY, INFOBOXOVERLAY_ORIENTATION_PREFIX + name, orientation);
	}

	void unsetOrientation(String name)
	{
		configManager.unsetConfiguration(INFOBOXOVERLAY_KEY, INFOBOXOVERLAY_ORIENTATION_PREFIX + name);
	}

	/**
	 * Find insertion point for the given key into the given sorted list. If key already exists in the list,
	 * return the index after the last occurrence.
	 * @param list
	 * @param key
	 * @param c
	 * @param <T>
	 * @return
	 */
	private static <T> int findInsertionIndex(List<? extends T> list, T key, Comparator<? super T> c)
	{
		int idx = Collections.binarySearch(list, key, c);

		if (idx < 0)
		{
			// key isn't found in the list
			return -idx - 1;
		}

		// list(idx) is equal to key, so it is not necessary to recheck it
		for (int i = idx + 1; i < list.size(); ++i)
		{
			T cur = list.get(i);
			int cmp = c.compare(cur, key);
			if (cmp > 0)
			{
				// this is the first element which is greater
				return i;
			}
		}

		return list.size();
	}
}
