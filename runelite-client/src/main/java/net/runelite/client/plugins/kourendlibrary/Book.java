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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;

enum Book
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

	private static final Map<Integer, Book> BY_ID = buildById();

	private static final Map<String, Book> BY_NAME = buildByName();

	private static Map<Integer, Book> buildById()
	{
		HashMap<Integer, Book> byId = new HashMap<>();
		for (Book b : Book.values())
		{
			byId.put(b.item, b);
		}
		return Collections.unmodifiableMap(byId);
	}

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

	static Book byId(int id)
	{
		return BY_ID.get(id);
	}

	static Book byName(String name)
	{
		return BY_NAME.get(name);
	}

	@Getter
	private final int item;

	@Getter
	private final String name;

	@Getter
	private final String shortName;

	@Getter
	private AsyncBufferedImage icon;

	@Getter
	private final boolean isDarkManuscript;

	Book(int id, String shortName, String name)
	{
		this.item = id;
		this.isDarkManuscript = false;
		this.shortName = shortName;
		this.name = name;
	}

	Book(int id)
	{
		this.item = id;
		this.isDarkManuscript = true;
		this.name = "Dark Manuscript";
		this.shortName = "Dark Manuscript";
	}

	static void fillImages(ItemManager itemManager)
	{
		for (Book b : values())
		{
			b.icon = itemManager.getImage(b.item);
		}
	}
}