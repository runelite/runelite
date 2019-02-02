/*
 * Copyright (c) 2018 Abex
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
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Setter;
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

class KourendLibraryOverlay extends Overlay
{
	private final static int MAXIMUM_DISTANCE = 24;
	private final Library library;
	private final Client client;

	@Setter(AccessLevel.PACKAGE)
	private boolean hidden;

	@Inject
	private KourendLibraryOverlay(Library library, Client client)
	{
		this.library = library;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		if (hidden)
		{
			return null;
		}

		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		WorldPoint playerLoc = player.getWorldLocation();

		if (playerLoc.getRegionID() != KourendLibraryPlugin.REGION)
		{
			return null;
		}

		List<Bookcase> allBookcases = library.getBookcasesOnLevel(client.getPlane());

		for (Bookcase bookcase : allBookcases)
		{
			// AABB
			WorldPoint caseLoc = bookcase.getLocation();
			if (Math.abs(playerLoc.getX() - caseLoc.getX()) > MAXIMUM_DISTANCE
				|| Math.abs(playerLoc.getY() - caseLoc.getY()) > MAXIMUM_DISTANCE)
			{
				continue;
			}

			LocalPoint localBookcase = LocalPoint.fromWorld(client, caseLoc);
			if (localBookcase == null)
			{
				continue;
			}
			Point screenBookcase = Perspective.localToCanvas(client, localBookcase, caseLoc.getPlane(), 25);

			if (screenBookcase != null)
			{
				boolean bookIsKnown = bookcase.isBookSet();
				Book book = bookcase.getBook();
				Set<Book> possible = bookcase.getPossibleBooks();
				if (bookIsKnown && book == null)
				{
					for (Book b : possible)
					{
						if (b != null && b.isDarkManuscript())
						{
							book = b;
							break;
						}
					}
				}

				if (!bookIsKnown && possible.size() == 1)
				{
					book = possible.iterator().next();
					bookIsKnown = true;
				}
				Color color = bookIsKnown ? Color.ORANGE : Color.WHITE;

				// Render the poly on the floor
				if (!(bookIsKnown && book == null) && (library.getState() == SolvedState.NO_DATA || book != null || !possible.isEmpty()))
				{
					Polygon poly = getCanvasTilePoly(client, localBookcase);
					if (poly != null)
					{
						OverlayUtil.renderPolygon(g, poly, color);
					}
				}

				int height = 0;
				// If the book is singled out, render the text and the book's icon
				if (bookIsKnown)
				{
					if (book != null)
					{
						FontMetrics fm = g.getFontMetrics();
						Rectangle2D bounds = fm.getStringBounds(book.getShortName(), g);
						height = (int) bounds.getHeight() + book.getIcon().getHeight() + 6;
						Point textLoc = new Point(
							(int) (screenBookcase.getX() - (bounds.getWidth() / 2)),
							screenBookcase.getY() - (height / 2) + (int) bounds.getHeight()
						);
						OverlayUtil.renderTextLocation(g, textLoc, book.getShortName(), color);
						g.drawImage(
							book.getIcon(),
							screenBookcase.getX() - (book.getIcon().getWidth() / 2),
							screenBookcase.getY() + (height / 2) - book.getIcon().getHeight(),
							null
						);
					}
				}
				else
				{
					// otherwise render up to 9 icons of the possible books in the bookcase in a square
					final int BOOK_ICON_SIZE = 32;
					Book[] books = possible.stream()
						.filter(Objects::nonNull)
						.limit(9)
						.toArray(Book[]::new);
					if (books.length > 1 && books.length <= 9)
					{
						int cols = (int) Math.ceil(Math.sqrt(books.length));
						int rows = (int) Math.ceil((double) books.length / cols);
						height = rows * BOOK_ICON_SIZE;
						int xbase = screenBookcase.getX() - ((cols * BOOK_ICON_SIZE) / 2);
						int ybase = screenBookcase.getY() - rows * BOOK_ICON_SIZE / 2;

						for (int i = 0; i < books.length; i++)
						{
							int col = i % cols;
							int row = i / cols;
							int x = col * BOOK_ICON_SIZE;
							int y = row * BOOK_ICON_SIZE;
							if (row == rows - 1)
							{
								x += (BOOK_ICON_SIZE * (books.length % rows)) / 2;
							}
							g.drawImage(books[i].getIcon(), xbase + x, ybase + y, null);
						}
					}
				}

				// Draw the bookcase's ID on top
				if (KourendLibraryPlugin.debug)
				{
					FontMetrics fm = g.getFontMetrics();
					String str = bookcase.getIndex().stream().map(Object::toString).collect(Collectors.joining(", "));
					Rectangle2D bounds = fm.getStringBounds(str, g);
					Point textLoc = new Point((int) (screenBookcase.getX() - (bounds.getWidth() / 2)), screenBookcase.getY() - (height / 2));
					OverlayUtil.renderTextLocation(g, textLoc, str, Color.WHITE);
				}
			}
		}

		// Render the customer's wanted book on their head and a poly under their feet
		LibraryCustomer customer = library.getCustomer();
		if (customer != null)
		{
			client.getNpcs().stream()
				.filter(n -> n.getId() == customer.getId())
				.forEach(n ->
				{
					Book b = library.getCustomerBook();
					LocalPoint local = n.getLocalLocation();
					Polygon poly = getCanvasTilePoly(client, local);
					OverlayUtil.renderPolygon(g, poly, Color.WHITE);
					Point screen = Perspective.localToCanvas(client, local, client.getPlane(), n.getLogicalHeight());
					if (screen != null)
					{
						g.drawImage(b.getIcon(), screen.getX() - (b.getIcon().getWidth() / 2), screen.getY() - b.getIcon().getHeight(), null);
					}
				});
		}

		return null;
	}
}
