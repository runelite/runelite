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
import com.google.common.collect.ComparisonChain;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.RuneLiteConfig;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.InfoBoxMenuClicked;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.util.AsyncBufferedImage;

@Singleton
@Slf4j
public class InfoBoxManager
{
	private final List<InfoBox> infoBoxes = new CopyOnWriteArrayList<>();
	private final RuneLiteConfig runeLiteConfig;
	private final EventBus eventBus;
	private int infoboxesAdded;

	@Inject
	private InfoBoxManager(final RuneLiteConfig runeLiteConfig, final EventBus eventBus)
	{
		this.runeLiteConfig = runeLiteConfig;
		this.eventBus = eventBus;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("runelite") && event.getKey().equals("infoBoxSize"))
		{
			infoBoxes.forEach(this::updateInfoBoxImage);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (event.getMenuAction() != MenuAction.RUNELITE_INFOBOX)
		{
			return;
		}

		// don't pass the event to the client
		event.consume();

		// find the correct infobox to handle the menu action
		Optional<InfoBox> optionalInfobox = infoBoxes.stream().filter(o -> o.getId() == event.getId()).findAny();
		if (optionalInfobox.isPresent())
		{
			InfoBox infoBox = optionalInfobox.get();
			List<OverlayMenuEntry> menuEntries = infoBox.getMenuEntries();
			Optional<OverlayMenuEntry> optionalMenuEntry = menuEntries.stream()
				.filter(entry -> entry.getOption().equals(event.getMenuOption()))
				.findAny();
			optionalMenuEntry.ifPresent(menuEntry -> eventBus.post(new InfoBoxMenuClicked(menuEntry, infoBox)));
		}
	}

	public void addInfoBox(InfoBox infoBox)
	{
		Preconditions.checkNotNull(infoBox);
		log.debug("Adding InfoBox {}", infoBox);

		updateInfoBoxImage(infoBox);

		synchronized (this)
		{
			int idx = Collections.binarySearch(infoBoxes, infoBox, (b1, b2) -> ComparisonChain
				.start()
				.compare(b1.getPriority(), b2.getPriority())
				.compare(b1.getPlugin().getName(), b2.getPlugin().getName())
				.result());

			// create a unique id for each infobox to distinguish which has been clicked
			infoBox.setId(infoboxesAdded++);

			infoBoxes.add(idx < 0 ? -idx - 1 : idx, infoBox);
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
		if (infoBoxes.remove(infoBox))
		{
			log.debug("Removed InfoBox {}", infoBox);
		}
	}

	public synchronized void removeIf(Predicate<InfoBox> filter)
	{
		if (infoBoxes.removeIf(filter))
		{
			log.debug("Removed InfoBoxes for filter {}", filter);
		}
	}

	public List<InfoBox> getInfoBoxes()
	{
		return Collections.unmodifiableList(infoBoxes);
	}

	public synchronized void cull()
	{
		infoBoxes.removeIf(InfoBox::cull);
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
}
