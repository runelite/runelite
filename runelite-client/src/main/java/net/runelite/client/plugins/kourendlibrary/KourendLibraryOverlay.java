/*
 * Copyright (c) 2018 Abex
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
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.List;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import static net.runelite.api.Perspective.getCanvasTilePoly;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

/**
 * Kourend Library overlay class used to display polygons as well as the books icons and names.
 */
public class KourendLibraryOverlay extends Overlay
{
	private final Client client;

	private final Library library;
	private final KourendLibraryConfig config;

	@Inject
	KourendLibraryOverlay(Client client, Library library, KourendLibraryConfig config)
	{
		this.client = client;
		this.library = library;
		this.config = config;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
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

		List<Bookcase> allBookcases = library.getFloors().get(client.getPlane()).getBookcases();

		// Display a polygon under bookcases and the book(s) that might be or are present in them.
		if (!allBookcases.isEmpty())
		{
			allBookcases.stream()
				.filter(bookcase -> !(bookcase.isBookSet() && bookcase.getBook() == null))
				.forEach(bookcase ->
				{
					WorldPoint caseLoc = bookcase.getLocation();
					if (playerLoc.distanceTo(caseLoc) > KourendLibraryPlugin.OVERLAY_MAXIMUM_DISTANCE)
					{
						return;
					}

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

					// Determine the color used the polygon and book name where applicable
					Color color = (book == null) ? config.unknownBook() :
						book.isDarkManuscript() ? config.darkManuscriptColor() :
							!book.isAvailableInBookcase() ? config.noAvailableActionColor() :
								book == library.getCustomerBook() ? config.requestedBook() :
									config.availableActionColor();

					// Draw the polygon under the bookcase
					Polygon poly = getCanvasTilePoly(client, localPoint);
					if (poly != null)
					{
						OverlayUtil.renderPolygon(g, poly, color);
					}

					// Draw the book icon and name.
					Point point = Perspective.worldToCanvas(
						client, localPoint.getX(), localPoint.getY(), caseLoc.getPlane(), 25);
					if (point != null)
					{
						if (book != null)
						{
							FontMetrics fm = g.getFontMetrics();
							Rectangle2D bounds = fm.getStringBounds(book.getShortName(), g);
							int height = (int) bounds.getHeight() + book.getIcon().getHeight() + 6;
							if (config.showBookName())
							{
								Point textLoc = new Point(
									(int) (point.getX() - (bounds.getWidth() / 2)),
									point.getY() - (height / 2) + (int) bounds.getHeight()
								);
								OverlayUtil.renderTextLocation(g, textLoc, book.getShortName(), color);
							}
							if (config.showBookIcon())
							{
								g.drawImage(
									book.getIcon(),
									point.getX() - (book.getIcon().getWidth() / 2),
									point.getY() + (height / 2) - book.getIcon().getHeight(),
									null
								);
							}
						}
						else
						{
							List<Book> books = bookcase.getPossibleBooks();
							int length = books.size();
							if (length != 0)
							{
								if (length > 9)
								{
									length = 9;            // Block display of more than 9 books
								}
								final int BOOK_ICON_SIZE = 32;
								int cols = (int) Math.ceil(Math.sqrt(length));
								int rows = (int) Math.ceil((double) length / cols);
								int xBase = point.getX() - ((cols * BOOK_ICON_SIZE) / 2);
								int yBase = point.getY() - rows * BOOK_ICON_SIZE / 2;

								for (int i = 0; i < length; i++)
								{
									int col = i % cols;
									int row = i / cols;
									int x = col * BOOK_ICON_SIZE;
									int y = row * BOOK_ICON_SIZE;
									if (row == rows - 1)
									{
										x += (BOOK_ICON_SIZE * (length % rows)) / 2;
									}
									g.drawImage(books.get(i).getIcon(), xBase + x, yBase + y, null);
								}
							}
						}
					}
				});
		}

		LibraryCustomer customer = library.getCustomer();
		Book customerBook = library.getCustomerBook();

		// Display a polygon under customer when they requested a book as well as the requested book above their head.
		if (customer != null && customerBook != null)
		{
			client.getNpcs().stream()
				.filter(n -> n.getId() == customer.getId())
				.forEach(n ->
				{
					LocalPoint localPoint = n.getLocalLocation();
					if (localPoint != null)
					{
						Color color = customerBook.isInInventory()
							? config.requestedBook() : config.noAvailableActionColor();

						// Draw the polygon under the customer
						Polygon poly = getCanvasTilePoly(client, localPoint);
						if (poly != null)
						{
							OverlayUtil.renderPolygon(g, poly, color);
						}

						// Draw the book icon and name.
						Point point = Perspective.worldToCanvas(
							client, localPoint.getX(), localPoint.getY(), client.getPlane(), n.getLogicalHeight());
						if (point != null)
						{
							FontMetrics fm = g.getFontMetrics();
							Rectangle2D bounds = fm.getStringBounds(customerBook.getShortName(), g);
							int height = (int) bounds.getHeight() + customerBook.getIcon().getHeight() + 6;
							if (config.showBookName())
							{
								Point textLoc = new Point(
									(int) (point.getX() - (bounds.getWidth() / 2)),
									point.getY() - (height / 2) + (int) bounds.getHeight()
								);
								OverlayUtil.renderTextLocation(g, textLoc, customerBook.getShortName(), color);
							}
							if (config.showBookIcon())
							{
								g.drawImage(
									customerBook.getIcon(),
									point.getX() - (customerBook.getIcon().getWidth() / 2),
									point.getY() + (height / 2) - customerBook.getIcon().getHeight(),
									null
								);
							}
						}
					}
				});
		}

		return null;
	}
}