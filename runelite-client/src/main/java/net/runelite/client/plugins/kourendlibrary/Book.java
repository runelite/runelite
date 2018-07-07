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
import net.runelite.client.game.AsyncBufferedImage;
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

	RADAS_CENSUS(ItemID.RADAS_CENSUS, "It's coming home", "It's coming home"),
	RICKTORS_DIARY_7(ItemID.RICKTORS_DIARY_7, "It's coming home", "It's coming home"),
	EATHRAM_RADA_EXTRACT(ItemID.EATHRAM__RADA_EXTRACT, "It's coming home", "It's coming home"),
	KILLING_OF_A_KING(ItemID.KILLING_OF_A_KING, "It's coming home", "It's coming home"),
	HOSIDIUS_LETTER(ItemID.HOSIDIUS_LETTER, "It's coming home", "It's coming home"),
	WINTERTODT_PARABLE(ItemID.WINTERTODT_PARABLE, "It's coming home", "It's coming home"),
	TWILL_ACCORD(ItemID.TWILL_ACCORD, "It's coming home", "It's coming home"),
	BYRNES_CORONATION_SPEECH(ItemID.BYRNES_CORONATION_SPEECH, "It's coming home", "It's coming home"),
	IDEOLOGY_OF_DARKNESS(ItemID.IDEOLOGY_OF_DARKNESS, "It's coming home", "It's coming home"),
	RADAS_JOURNEY(ItemID.RADAS_JOURNEY, "It's coming home", "It's coming home"),
	TRANSVERGENCE_THEORY(ItemID.TRANSVERGENCE_THEORY, "It's coming home", "It's coming home"),
	TRISTESSAS_TRAGEDY(ItemID.TRISTESSAS_TRAGEDY, "It's coming home", "It's coming home"),
	TREACHERY_OF_ROYALTY(ItemID.TREACHERY_OF_ROYALTY, "It's coming home", "It's coming home"),
	TRANSPORTATION_INCANTATIONS(ItemID.TRANSPORTATION_INCANTATIONS, "It's coming home", "It's coming home"),
	SOUL_JORUNEY(ItemID.SOUL_JOURNEY, "It's coming home", "It's coming home"),
	VARLAMORE_ENVOY(ItemID.VARLAMORE_ENVOY, "It's coming home", "It's coming home");

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
		this.name = "It's coming home";
		this.shortName = "It's coming home";
	}

	static void fillImages(ItemManager itemManager)
	{
		for (Book b : values())
		{
			b.icon = itemManager.getImage(b.item);
		}
	}
}