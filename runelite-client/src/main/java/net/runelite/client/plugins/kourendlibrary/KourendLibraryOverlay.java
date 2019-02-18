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
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.NPC;
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
	private KourendLibraryConfig config;

	@Inject
	private KourendLibraryOverlay(Library library, Client client)
	{
		this.library = library;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
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

		WorldPoint playerLocation = player.getWorldLocation();

		if (playerLocation.getRegionID() != KourendLibraryPlugin.REGION)
		{
			return null;
		}

		renderBookcases(graphics, playerLocation);

		renderLibraryCustomer(graphics);

		return null;
	}

	private void renderBookcases(@Nonnull Graphics2D graphics, @Nonnull WorldPoint playerLocation)
	{
		List<Bookcase> allBookcases = library.getBookcasesOnLevel(client.getPlane());

		for (Bookcase bookcase : allBookcases)
		{
			WorldPoint bookcaseLocation = bookcase.getLocation();

			if (!isBookcaseInRange(playerLocation, bookcaseLocation))
			{
				continue;
			}

			LocalPoint bookcaseLocal = LocalPoint.fromWorld(client, bookcaseLocation);

			if (bookcaseLocal == null)
			{
				continue;
			}

			Point screenBookcase = Perspective.localToCanvas(client, bookcaseLocal, bookcaseLocation.getPlane(), 25);

			if (screenBookcase == null)
			{
				continue;
			}

			Book book = bookcase.getPredictedBook();

			boolean bookIsKnown = bookcase.isBookSet() || bookcase.getPossibleBooks().size() == 1;

			if (!(bookIsKnown && book == null) && (library.getState() == SolvedState.NO_DATA || book != null || !bookcase.getPossibleBooks().isEmpty()))
			{
				if (book != null)
				{
					renderKnownBookTile(graphics, bookcaseLocal, book);
				}
				else
				{
					renderUnknownBookTile(graphics, bookcaseLocal);
				}
			}

			if (!bookIsKnown)
			{
				renderMultipleBooks(graphics, bookcase, screenBookcase);
			}
			else if (book != null)
			{
				renderSingleBook(graphics, book, bookcase, screenBookcase);
			}
		}
	}

	private void renderUnknownBookTile(@Nonnull Graphics2D graphics, @Nonnull LocalPoint bookcaseLocation)
	{
		Polygon polygon = getCanvasTilePoly(client, bookcaseLocation);

		if (polygon == null)
		{
			return;
		}

		OverlayUtil.renderPolygon(graphics, polygon, Color.white);
	}

	private void renderKnownBookTile(@Nonnull Graphics2D graphics, @Nonnull LocalPoint bookcaseLocation, @Nonnull Book book)
	{
		if (config.hideDarkManuscript() && book.isDarkManuscript())
		{
			return;
		}

		boolean containsBook = containsBook(book);

		if (config.hideDuplicateBooks() && containsBook)
		{
			return;
		}

		Polygon polygon = getCanvasTilePoly(client, bookcaseLocation);

		if (polygon == null)
		{
			return;
		}

		Color color = containsBook ? Color.red : (library.getCustomerBook() == book && library.getState() == SolvedState.COMPLETE) ? Color.green : Color.orange;

		OverlayUtil.renderPolygon(graphics, polygon, color);
	}

	private boolean isBookcaseInRange(@Nonnull WorldPoint playerLocation, @Nonnull WorldPoint bookcaseLocation)
	{
		return Math.abs(playerLocation.getX() - bookcaseLocation.getX()) <= MAXIMUM_DISTANCE && Math.abs(playerLocation.getY() - bookcaseLocation.getY()) <= MAXIMUM_DISTANCE;
	}

	// If the book is singled out, render the text and the book's icon
	private void renderSingleBook(@Nonnull Graphics2D graphics, @Nonnull Book book, @Nonnull Bookcase bookcase, @Nonnull Point screenBookcase)
	{
		if (config.hideDarkManuscript() && book.isDarkManuscript())
		{
			return;
		}

		if (config.hideDuplicateBooks() && containsBook(book))
		{
			return;
		}

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D bounds = fm.getStringBounds(book.getShortName(), graphics);
		int height = (int) bounds.getHeight() + book.getIcon().getHeight() + 6;

		Point textLoc = new Point(
			(int) (screenBookcase.getX() - (bounds.getWidth() / 2)),
			screenBookcase.getY() - (height / 2) + (int) bounds.getHeight()
		);

		Color color = containsBook(book) ? Color.red : (library.getCustomerBook() == book && library.getState() == SolvedState.COMPLETE) ? Color.green : Color.orange;

		OverlayUtil.renderTextLocation(graphics, textLoc, book.getShortName(), color);

		graphics.drawImage(
			book.getIcon(),
			screenBookcase.getX() - (book.getIcon().getWidth() / 2),
			screenBookcase.getY() + (height / 2) - book.getIcon().getHeight(),
			null
		);

		renderBookID(graphics, bookcase, screenBookcase, height);
	}

	// Render up to 9 icons of the possible books in the bookcase in a square
	private void renderMultipleBooks(@Nonnull Graphics2D graphics, @Nonnull Bookcase bookcase, @Nonnull Point screenBookcase)
	{
		Book[] books = bookcase.getPossibleBooks().stream()
			.filter(Objects::nonNull)
			.limit(9)
			.toArray(Book[]::new);

		if (books.length <= 1 || books.length > 9)
		{
			return;
		}

		final int BOOK_ICON_SIZE = 32;

		int cols = (int) Math.ceil(Math.sqrt(books.length));
		int rows = (int) Math.ceil((double) books.length / cols);
		int height = rows * BOOK_ICON_SIZE;
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
			graphics.drawImage(books[i].getIcon(), xbase + x, ybase + y, null);
		}

		renderBookID(graphics, bookcase, screenBookcase, height);
	}

	// Draw the bookcase's ID on top
	private void renderBookID(@Nonnull Graphics2D graphics, @Nonnull Bookcase bookcase, @Nonnull Point screenBookcase, int height)
	{
		if (!KourendLibraryPlugin.debug)
		{
			return;
		}

		FontMetrics fm = graphics.getFontMetrics();
		String str = bookcase.getIndex().stream().map(Object::toString).collect(Collectors.joining(", "));
		Rectangle2D bounds = fm.getStringBounds(str, graphics);
		Point textLoc = new Point((int) (screenBookcase.getX() - (bounds.getWidth() / 2)), screenBookcase.getY() - (height / 2));
		OverlayUtil.renderTextLocation(graphics, textLoc, str, Color.WHITE);
	}

	// Render the customer's wanted book on their head and a poly under their feet
	private void renderLibraryCustomer(@Nonnull Graphics2D graphics)
	{
		LibraryCustomer customer = library.getCustomer();

		if (customer == null)
		{
			client.getNpcs()
				.stream()
				.filter(npc -> Arrays.stream(LibraryCustomer.values()).anyMatch(lc -> lc.getId() == npc.getId() && lc != library.getLastCustomer()))
				.forEach(npc -> renderNpcHull(graphics, npc, Color.white));
		}
		else
		{
			client.getNpcs()
				.stream()
				.filter(npc -> npc.getId() == customer.getId())
				.findFirst()
				.ifPresent(npc -> {
					Book book = library.getCustomerBook();

					if (book == null)
					{
						return;
					}

					renderNpcHull(graphics, npc, containsBook(book) ? Color.green : Color.white);

					LocalPoint local = npc.getLocalLocation();
					Point screen = Perspective.localToCanvas(client, local, client.getPlane(), npc.getLogicalHeight());

					if (screen == null)
					{
						return;
					}

					graphics.drawImage(book.getIcon(), screen.getX() - (book.getIcon().getWidth() / 2), screen.getY() - book.getIcon().getHeight(), null);
				});
		}
	}

	private void renderNpcHull(@Nonnull Graphics2D graphics, @Nonnull NPC npc, @Nonnull Color color)
	{
		Polygon polygon = npc.getConvexHull();

		if (polygon == null)
		{
			return;
		}

		graphics.setColor(color);
		graphics.setStroke(new BasicStroke(2));
		graphics.draw(polygon);
		graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
		graphics.fill(polygon);
	}

	private boolean containsBook(@Nonnull Book book)
	{
		ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);

		if (itemContainer == null)
		{
			return false;
		}

		Item[] items = itemContainer.getItems();

		return Arrays.stream(items).anyMatch(item -> book.getItemId() == item.getId());
	}
}
