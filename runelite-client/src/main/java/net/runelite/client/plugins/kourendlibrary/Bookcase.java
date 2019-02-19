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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

class Bookcase
{
	Bookcase(WorldPoint location)
	{
		this.location = location;
		this.index = new ArrayList<>();
	}

	@Getter
	private final WorldPoint location;

	@Getter
	private final List<Integer> index;

	@Getter
	private boolean isBookSet;

	/**
	 * Book in this bookcase as found by the player.
	 * Will be correct as long as isBookSet is true, unless the library has reset;
	 */
	@Getter
	private Book book;

	/**
	 * Books that can be in this slot. Will only be populated if library.state != SolvedState.NO_DATA
	 */
	@Getter
	private Set<Book> possibleBooks = new HashSet<>();

	void clearBook()
	{
		book = null;
		isBookSet = false;
	}

	void setBook(Book book)
	{
		this.book = book;
		this.isBookSet = true;
	}

	String getLocationString()
	{
		LibraryLevel level = LibraryLevel.getLevel(location);
		LibrarySection section = LibrarySection.getSection(location);

		if (level == null)
		{
			return "Unknown";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(section.getName());
		sb.append(" ");
		sb.append(level.getName());

		if (KourendLibraryPlugin.debug)
		{
			sb.append(" ").append(index.stream().map(Object::toString).collect(Collectors.joining(", ")));
		}

		return sb.toString();
	}

	@Nullable
	Book getPredictedBook()
	{
		if (isBookSet && book == null)
		{
			for (Book possibleBook : possibleBooks)
			{
				if (possibleBook != null && possibleBook.isDarkManuscript())
				{
					return possibleBook;
				}
			}
		}
		else if (possibleBooks.size() == 1)
		{
			return possibleBooks.iterator().next();
		}

		return book;
	}
}
