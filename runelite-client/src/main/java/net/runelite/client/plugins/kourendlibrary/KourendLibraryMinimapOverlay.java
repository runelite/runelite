/*
 * Copyright (c) 2018, Franck Maillot <https://github.com/Franck-M>
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
package net.runelite.client.plugins.kourendlibrary;

import com.google.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class KourendLibraryMinimapOverlay extends Overlay
{
	private final Client client;

	private final Library library;
	private final KourendLibraryConfig config;

	@Inject
	KourendLibraryMinimapOverlay(Client client, Library library, KourendLibraryConfig config)
	{
		this.client = client;
		this.library = library;
		this.config = config;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		WorldPoint playerLoc = player.getWorldLocation();
		if (playerLoc.distanceTo2D(KourendLibraryPlugin.LIBRARY_CENTER) > KourendLibraryPlugin.ROUGH_ENABLE_DISTANCE)
		{
			return null;
		}

		if (library.getState() == SolvedState.NO_DATA || !config.showMinimapDot())
		{
			return null;
		}

		List<Bookcase> allBookcases = library.getFloors().get(client.getPlane()).getBookcases();

		if (!allBookcases.isEmpty())
		{
			allBookcases.stream()
				.filter(bookcase -> !(bookcase.isBookSet() && bookcase.getBook() == null))
				.forEach(bookcase ->
				{
					WorldPoint caseLoc = bookcase.getLocation();
					LocalPoint localPoint = LocalPoint.fromWorld(client, caseLoc);
					if (localPoint == null)
					{
						return;
					}

					Book book = bookcase.getBook();

					// Do not draw anything if the book is known but shouldn't be displayed according to config
					if (book != null && ((book.isDarkManuscript() && config.hideDarkManuscripts())
						|| (config.showAvailableBooksOnly() && !book.isAvailableInBookcase())))
					{
						return;
					}

					// Determine the color used the for the minimap dot
					Color color = (book == null) ? config.unknownBook() :
						book.isDarkManuscript() ? config.darkManuscriptColor() :
							!book.isAvailableInBookcase() ? config.noAvailableActionColor() :
								book == library.getCustomerBook() ? config.requestedBook() :
									config.availableActionColor();

					// Draw the minimap dot for this bookcase
					Point point = Perspective.worldToMiniMap(client, localPoint.getX(), localPoint.getY());
					if (point != null)
					{
						OverlayUtil.renderMinimapLocation(g, point, color);
					}
				});
		}
		return null;
	}
}