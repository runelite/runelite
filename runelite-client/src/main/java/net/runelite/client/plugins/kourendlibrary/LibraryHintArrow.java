/*
 * Copyright (c) 2019 Koekkruimels
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

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Comparator;

@Singleton
@Slf4j
public class LibraryHintArrow
{
	@Inject
	private KourendLibraryConfig config;

	@Inject
	private Client client;

	@Inject
	private Library library;

	private boolean isShowingHintArrow = false;

	public void update()
	{
		if (!config.showHintArray())
		{
			clear();
			return;
		}

		if (library.getState() != SolvedState.COMPLETE)
		{
			clear();
			return;
		}

		Book book = library.getCustomerBook();

		if (book == null)
		{
			clear();
			return;
		}

		if (containsBook(book))
		{
			clear();
			return;
		}

		show(book);
	}

	public void clear()
	{
		if (!isShowingHintArrow)
		{
			return;
		}

		isShowingHintArrow = false;
		client.clearHintArrow();
	}

	private void show(@Nonnull Book book)
	{
		Bookcase bookcase = getBookcase(book);

		if (bookcase == null)
		{
			return;
		}

		LibraryStaircase staircase = getStaircase(bookcase);

		if (staircase != null)
		{
			client.setHintArrow(staircase.getLocation());
		}
		else
		{
			client.setHintArrow(bookcase.getLocation());
		}

		isShowingHintArrow = true;
	}

	@Nullable
	private Bookcase getBookcase(@Nonnull Book book)
	{
		return library.getBookcases()
			.stream()
			.filter(bookcase -> book.equals(bookcase.getPredictedBook()))
			.findFirst()
			.orElse(null);
	}

	@Nullable
	private LibraryStaircase getStaircase(@Nonnull Bookcase bookcase)
	{
		WorldPoint desiredLocation = bookcase.getLocation();
		WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();

		LibraryLevel playerLevel = LibraryLevel.getLevel(playerLocation);
		LibrarySection playerSection = LibrarySection.getSection(playerLocation);

		LibraryLevel desiredLevel = LibraryLevel.getLevel(desiredLocation);
		LibrarySection desiredSection = LibrarySection.getSection(desiredLocation);

		if (playerLevel == null)
		{
			return null;
		}

		if (desiredLevel == null)
		{
			return null;
		}

		if (playerLevel == desiredLevel)
		{
			if (playerSection == desiredSection)
			{
				return null;
			}
			else if (playerLevel.canReachOtherSections())
			{
				return null;
			}
			else
			{
				int suggestedDirection = LibraryLevel.maxLevel() == playerLevel ? -1 : 1;

				return Arrays.stream(LibraryStaircase.values())
					.filter(staircase -> staircase.getFromLevel() == playerLevel)
					.filter(staircase -> staircase.getSection() == playerSection)
					.filter(staircase -> staircase.direction() == suggestedDirection)
					.min(Comparator.comparingInt(staircase -> staircase.getLocation().distanceTo2D(playerLocation)))
					.orElse(null);
			}
		}

		int direction = Math.min(Math.max((desiredLocation.getPlane() - playerLocation.getPlane()), -1), 1);

		if (playerLevel.canReachOtherSections())
		{
			return Arrays.stream(LibraryStaircase.values())
				.filter(staircase -> staircase.getFromLevel() == playerLevel)
				.filter(staircase -> staircase.direction() == direction)
				.filter(staircase -> desiredLevel.canReachOtherSections() || staircase.getSection() == desiredSection || (playerLevel == LibraryLevel.GROUND_FLOOR && desiredSection == LibrarySection.CENTER))
				.min(Comparator.comparingInt(stair -> stair.getLocation().distanceTo2D(playerLocation)))
				.orElse(null);
		}
		else
		{
			return Arrays.stream(LibraryStaircase.values())
				.filter(staircase -> staircase.getFromLevel() == playerLevel)
				.filter(staircase -> staircase.direction() == direction)
				.filter(staircase -> staircase.getSection() == playerSection)
				.min(Comparator.comparingInt(staircase -> staircase.getLocation().distanceTo2D(playerLocation)))
				.orElse(null);
		}
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
