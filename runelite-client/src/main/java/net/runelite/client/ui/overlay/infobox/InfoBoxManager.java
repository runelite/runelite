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

import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.TreeMultimap;
import com.google.common.eventbus.Subscribe;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

@Singleton
@Slf4j
public class InfoBoxManager implements KeyListener
{
	private static final String DEFAULT_NAME = "Overlay";

	private final Multimap<String, InfoBox> infoBoxes = TreeMultimap.create(Comparator.naturalOrder(), (a, b) ->
	{
		int priority = a.getPriority().compareTo(b.getPriority());
		if (priority != 0)
		{
			return priority * -1;
		}

		int i = a.getName().compareTo(b.getName());
		return i != 0 ? i : 1;
	});

	private final Map<String, InfoBoxOverlay> overlays = new HashMap<>();
	private final Map<String, InfoBoxOverlay> snapCorners = new HashMap<>();

	private final RuneLiteConfig runeLiteConfig;
	private final OverlayManager overlayManager;
	private final TooltipManager tooltipManager;
	private final Client client;
	private final KeyManager keyManager;

	@Getter
	private boolean inOverlayDraggingMode = false;

	@Inject
	private InfoBoxManager(final RuneLiteConfig runeLiteConfig, final OverlayManager overlayManager, final TooltipManager tooltipManager, final Client client, final KeyManager keyManager)
	{
		this.runeLiteConfig = runeLiteConfig;
		this.overlayManager = overlayManager;
		this.tooltipManager = tooltipManager;
		this.client = client;
		this.keyManager = keyManager;

		keyManager.registerKeyListener(this);
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			rebuildOverlays();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("runelite"))
		{
			if (event.getKey().equals("infoBoxSize"))
			{
				infoBoxes.values().forEach(this::updateInfoBoxImage);
			}
			else if (event.getKey().equals("infoBoxSeparate"))
			{
				rebuildOverlays();
			}
		}
	}

	private InfoBoxOverlay lazyLoad(String name)
	{
		if (!overlays.containsKey(name))
		{
			InfoBoxOverlay overlay = makeOverlay(name);
			overlayManager.loadOverlay(overlay);
			overlayManager.add(overlay);
			overlays.put(name, overlay);

			overlay.setHide(overlay.getPreferredLocation() == null);
			overlay.setGrouped(overlay.getPreferredLocation() == null);

			overlay.setInfoBoxes(Multimaps.filterKeys(infoBoxes, key -> key.equals(name)));

			return overlay;
		}

		return overlays.get(name);
	}

	private void rebuildOverlays()
	{
		overlays.values().forEach(overlayManager::remove);
		snapCorners.values().forEach(overlayManager::remove);

		overlays.clear();
		snapCorners.clear();

		if (runeLiteConfig.infoBoxSeparate())
		{
			for (OverlayPosition position : OverlayPosition.values())
			{
				if (position == OverlayPosition.DYNAMIC || position == OverlayPosition.DETACHED || position == OverlayPosition.TOOLTIP)
				{
					continue;
				}

				InfoBoxOverlay overlay = makeOverlay(position.toString());
				snapCorners.put(position.toString(), overlay);

				overlay.setInfoBoxes(Multimaps.filterKeys(infoBoxes, key ->
				{
					InfoBoxOverlay o = overlays.get(key);
					if (o != null &&
						(o.getPreferredPosition() == overlay.getPosition() ||
							(o.getPreferredPosition() == null && o.getPosition() == overlay.getPosition() && o.getPreferredLocation() == null)))
					{
						o.setGrouped(true);
						return true;
					}

					return false;
				}));

				overlay.setPosition(position);
				overlayManager.add(overlay);
			}

			for (Map.Entry<String, InfoBox> entry : infoBoxes.entries())
			{
				lazyLoad(entry.getKey());
			}

			groupInfoBoxes(false);
		}
		else
		{
			InfoBoxOverlay overlay = makeOverlay(DEFAULT_NAME);
			overlayManager.loadOverlay(overlay);
			snapCorners.put(DEFAULT_NAME, overlay);

			overlay.setPosition(OverlayPosition.TOP_LEFT);
			overlay.setInfoBoxes(infoBoxes);
			overlayManager.add(overlay);
		}
	}

	private InfoBoxOverlay makeOverlay(String name)
	{
		InfoBoxOverlay overlay = new InfoBoxOverlay(
			this,
			tooltipManager,
			client,
			runeLiteConfig);
		overlay.setName("InfoBox" + name);

		return overlay;
	}

	public void addInfoBox(InfoBox infoBox)
	{
		if (infoBoxes.containsEntry(infoBox.getName(), infoBox))
		{
			return;
		}

		log.debug("InfoBox added {}", infoBox);

		infoBoxes.put(infoBox.getName(), infoBox);
		lazyLoad(!runeLiteConfig.infoBoxSeparate() ? DEFAULT_NAME : infoBox.getName());
		updateInfoBoxImage(infoBox);

		groupInfoBoxes(false);
	}

	public void removeInfoBox(InfoBox infoBox)
	{
		if (infoBox == null)
		{
			return;
		}

		log.debug("Removing InfoBox {}", infoBox);
		infoBoxes.removeAll(infoBox);
	}

	public void removeIf(Predicate<InfoBox> filter)
	{
		log.debug("Removing InfoBoxes for filter {}", filter);
		Multimap<String, InfoBox> filtered = Multimaps.filterValues(infoBoxes, filter);
		filtered.clear();
	}

	public void cull()
	{
		for (Iterator<InfoBox> it = infoBoxes.values().iterator(); it.hasNext(); )
		{
			InfoBox box = it.next();

			if (box.cull())
			{
				log.debug("Culling InfoBox {}", box);
				it.remove();
			}
		}
	}

	private void updateInfoBoxImage(final InfoBox infoBox)
	{
		if (infoBox.getImage() == null)
		{
			return;
		}

		// Set scaled InfoBox image
		final Image image = infoBox.getImage();
		Image resultImage = image;
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

	private void groupInfoBoxes(boolean showIndividual)
	{
		if (!runeLiteConfig.infoBoxSeparate())
		{
			return;
		}

		for (InfoBoxOverlay overlay : snapCorners.values())
		{
			overlay.setHide(showIndividual);
		}

		for (InfoBoxOverlay overlay : overlays.values())
		{
			overlay.setHide(!showIndividual);

			if (overlay.getPreferredLocation() != null)
			{
				overlay.setHide(false);
				overlay.setGrouped(false);
			}
		}
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
			if (!inOverlayDraggingMode)
			{
				groupInfoBoxes(true);
			}

			inOverlayDraggingMode = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (!e.isAltDown())
		{
			if (inOverlayDraggingMode)
			{
				groupInfoBoxes(false);

			}

			inOverlayDraggingMode = false;
		}
	}
}
