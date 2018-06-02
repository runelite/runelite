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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ItemID;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;

/**
 * Numerous books are available in the Kourend Library, this class makes an enumeration of those books.
 * We make a distinction between dark manuscripts and other books in this class. Dark manuscript are specific in that
 * they share the same name (although not the same item id) and by the fact that only one can be retrieved at a time.
 * At the time of writing the Library contains 26 books, including 10 dark manuscripts.
 */
public enum Book
{
	DARK_MANUSCRIPT_13514(ItemID.DARK_MANUSCRIPT),
	DARK_MANUSCRIPT_13515(ItemID.DARK_MANUSCRIPT_13515),
	DARK_MANUSCRIPT_13516(ItemID.DARK_MANUSCRIPT_13516),
	DARK_MANUSCRIPT_13517(ItemID.DARK_MANUSCRIPT_13517),
	DARK_MANUSCRIPT_13518(ItemID.DARK_MANUSCRIPT_13518),
	DARK_MANUSCRIPT_13519(ItemID.DARK_MANUSCRIPT_13519),
	DARK_MANUSCRIPT_13520(ItemID.DARK_MANUSCRIPT_13520),
	DARK_MANUSCRIPT_13521(ItemID.DARK_MANUSCRIPT_13521),
	DARK_MANUSCRIPT_13522(ItemID.DARK_MANUSCRIPT_13522),
	DARK_MANUSCRIPT_13523(ItemID.DARK_MANUSCRIPT_13523),
	RADAS_CENSUS(ItemID.RADAS_CENSUS, "Rada's Census", "Census of King Rada III, by Matthias Vorseth."),
	RICKTORS_DIARY_7(ItemID.RICKTORS_DIARY_7, "Ricktor's Diary 7", "Diary of Steklan Ricktor, volume 7."),
	EATHRAM_RADA_EXTRACT(ItemID.EATHRAM__RADA_EXTRACT, "Eathram & Rada extract", "An extract from Eathram & Rada, by Anonymous."),
	KILLING_OF_A_KING(ItemID.KILLING_OF_A_KING, "Killing of a King", "Killing of a King, by Griselle."),
	HOSIDIUS_LETTER(ItemID.HOSIDIUS_LETTER, "Hosidius Letter", "A letter from Lord Hosidius to the Council of Elders."),
	WINTERTODT_PARABLE(ItemID.WINTERTODT_PARABLE, "Wintertodt Parable", "The Parable of the Wintertodt, by Anonymous."),
	TWILL_ACCORD(ItemID.TWILL_ACCORD, "Twill Accord", "The Royal Accord of Twill."),
	BYRNES_CORONATION_SPEECH(ItemID.BYRNES_CORONATION_SPEECH, "Byrnes Coronation Speech", "Speech of King Byrne I, on the occasion of his coronation."),
	IDEOLOGY_OF_DARKNESS(ItemID.IDEOLOGY_OF_DARKNESS, "The Ideology of Darkness", "The Ideology of Darkness, by Philophaire."),
	RADAS_JOURNEY(ItemID.RADAS_JOURNEY, "Rada's Journey", "The Journey of Rada, by Griselle."),
	TRANSVERGENCE_THEORY(ItemID.TRANSVERGENCE_THEORY, "Transvergence Theory", "The Theory of Transvergence, by Amon Ducot."),
	TRISTESSAS_TRAGEDY(ItemID.TRISTESSAS_TRAGEDY, "Tristessa's Tragedy", "The Tragedy of Tristessa."),
	TREACHERY_OF_ROYALTY(ItemID.TREACHERY_OF_ROYALTY, "The Treachery of Royalty", "The Treachery of Royalty, by Professor Answith."),
	TRANSPORTATION_INCANTATIONS(ItemID.TRANSPORTATION_INCANTATIONS, "Transportation Incantations", "Transportation Incantations, by Amon Ducot."),
	SOUL_JOURNEY(ItemID.SOUL_JOURNEY, "Soul Journey", "The Journey of Souls, by Aretha."),
	VARLAMORE_ENVOY(ItemID.VARLAMORE_ENVOY, "Varlamore Envoy", "The Envoy to Varlamore, by Deryk Paulson.");

	/**
	 * Map of books by id. Used in KourendLibraryPlugin when we need to get a book by its id.
	 */
	private static final Map<Integer, Book> BY_ID;

	/**
	 * Map of books by name. Used in KourendLibraryPlugin  when we need to get a book by its name.
	 */
	private static final Map<String, Book> BY_NAME;

	/**
	 * Item id of the book.
	 */
	@Getter
	private final int item;

	/**
	 * Full name of the book used by the Library customers when requesting a book.
	 */
	@Getter
	private final String name;

	/**
	 * Short name of the book used in the overlays.
	 */
	@Getter
	private final String shortName;

	/**
	 * Icon of the book used in the overlays.
	 */
	@Getter
	private AsyncBufferedImage icon;

	/**
	 * Whether or not the book is a dark manuscript.
	 */
	@Getter
	private final boolean isDarkManuscript;

	/**
	 * Whether this is the last dark manuscript that was found.
	 */
	private boolean isCheckedDarkManuscript;

	/**
	 * Whether or not a book is present in the player inventory.
	 * This value is updated whenever the player's inventory changes.
	 */
	@Getter
	@Setter
	private boolean isInInventory;

	// Static variables initialization
	static
	{
		BY_ID = buildById();
		BY_NAME = buildByName();
	}

	/**
	 * Static method, create a HashMap of books using their id as key.
	 *
	 * @return Map of books by id.
	 */
	private static Map<Integer, Book> buildById()
	{
		HashMap<Integer, Book> byId = new HashMap<>();
		for (Book b : Book.values())
		{
			byId.put(b.item, b);
		}
		return Collections.unmodifiableMap(byId);
	}

	/**
	 * Static method, create a HashMap of books using their name as key. This is used to identify the book required by
	 * the customers. We do not need dark manuscripts in this map as they are never requested.
	 *
	 * @return Map of books by name.
	 */
	private static Map<String, Book> buildByName()
	{
		HashMap<String, Book> byName = new HashMap<>();
		for (Book b : Book.values())
		{
			if (!b.isDarkManuscript)
			{
				byName.put(b.name, b);
			}
		}
		return Collections.unmodifiableMap(byName);
	}

	/**
	 * Static method, return a book given its id.
	 *
	 * @param id Id of the book.
	 * @return The book associated to the id if it exists.
	 */
	public static Book byId(int id)
	{
		return BY_ID.get(id);
	}

	/**
	 * Static method, return a book given its name.
	 *
	 * @param name Name of the book.
	 * @return The book associated to the name if it exists.
	 */
	public static Book byName(String name)
	{
		return BY_NAME.get(name);
	}

	// Variables initialization
	{
		isInInventory = false;
		isCheckedDarkManuscript = false;
	}

	/**
	 * Constructor for books (not dark manuscripts).
	 *
	 * @param id        Id of the book as found in the client.
	 * @param shortName Short name of the book displayed to the player.
	 * @param name      Full name of the book used by the Library customers.
	 */
	Book(int id, String shortName, String name)
	{
		this.item = id;
		this.isDarkManuscript = false;
		this.shortName = shortName;
		this.name = name;
	}

	/**
	 * Constructor for dark manuscripts.
	 *
	 * @param id Id of the dark manuscript as found in the client.
	 */
	Book(int id)
	{
		this.item = id;
		this.isDarkManuscript = true;
		this.name = "Dark Manuscript";
		this.shortName = "Dark Manuscript";
	}

	/**
	 * Reset the book.
	 * As of now this simply set dark manuscripts to unchecked.
	 */
	public void reset()
	{
		if (isDarkManuscript)
		{
			isCheckedDarkManuscript = false;
		}
	}

	/**
	 * A book can be found in the bookcase if it's a dark manuscript and we haven't checked the bookcase yet / dark
	 * manuscripts haven't reset yet or otherwise if it's not in the player's inventory.
	 *
	 * @return Availability of this book in its respective bookcase.
	 */
	public boolean isAvailableInBookcase()
	{
		return this.isDarkManuscript ? !this.isCheckedDarkManuscript : !this.isInInventory;
	}

	/**
	 * Alternative function to set isCheckedDarkManuscript to false.
	 */
	public void setIsCheckedDarkManuscriptToFalse()
	{
		this.isCheckedDarkManuscript = false;
	}

	/**
	 * Should only be called for dark manuscripts. When called set the current book as checked (not in the bookcase)
	 * and in the case where we actually picked a book from the bookcase also reset this variable for other manuscripts.
	 *
	 * @param bookFoundWasDarkManuscript Whether or not we just picked a dark manuscript.
	 */
	public void setIsCheckedDarkManuscript(boolean bookFoundWasDarkManuscript)
	{
		this.isCheckedDarkManuscript = true;
		if (bookFoundWasDarkManuscript)
		{
			Arrays.stream(Book.values())
				.filter(b -> b.isDarkManuscript() && b != this)
				.forEach(Book::setIsCheckedDarkManuscriptToFalse);
		}
	}

	/**
	 * Used to count currently available (potentially present in the bookcase) dark manuscripts.
	 *
	 * @return The current number of available dark manuscripts.
	 */
	public static int countAvailableDarkManuscripts()
	{
		return (int) Arrays.stream(Book.values())
			.filter(Book::isDarkManuscript)
			.filter(Book::isAvailableInBookcase)
			.count();
	}

	/**
	 * Fill the book icon of all books. This is deliberately done outside of constructor to let the item manager get
	 * the images beforehand.
	 *
	 * @param itemManager Item manager of Runelite.
	 */
	public static void fillImages(ItemManager itemManager)
	{
		for (Book b : values())
		{
			b.icon = itemManager.getImage(b.item);
		}
	}
}