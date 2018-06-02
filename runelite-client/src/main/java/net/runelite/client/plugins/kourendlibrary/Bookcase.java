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

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

/**
 * A bookcase in the library is defined by its location and its indexes. Once the book found in a bookcase is known,
 * it is set in the parameter book and isBookSet is set to true. In the same manner if we know that no book is found
 * in the bookcase isBookSet is set to true.
 */
class Bookcase
{
	/**
	 * The 'physical' emplacement of a bookcase, used when drawing the bookcase overlay.
	 */
	@Getter
	private final WorldPoint location;

	/**
	 * Some bookcases might have two indexes which are used by the book sequences.
	 * Values are stored in an ArrayList to ensure order is conserved.
	 */
	@Getter
	private final List<Integer> index = new ArrayList<>();

	/**
	 * If library.state != SolvedState.COMPLETE, isBookSet is set to true when the player checks a bookcase
	 * or when we know for sure the book present in this bookcase (or absence of book).
	 * Otherwise when the library is completed, isBookSet is always true.
	 */
	@Getter
	private boolean isBookSet;

	/**
	 * Either null or a Book value.
	 * When this.isBookSet == true, this is the book currently available in the bookcase. In some cases a bookcase
	 * that should contain a dark manuscript may be set to null, this is fixed when completing the library.
	 */
	@Getter
	private Book book;

	/**
	 * Can have values only if isBookSet is false, in which case it lists the potential books found in this bookcase.
	 * Having a single possible book does not mean that it will necessarily be found in the bookcase but that a single
	 * sequence thought there would be one here.
	 * The choice was made to allow the same book in this list more than once, this is done so that we can check
	 * afterward if all sequences wanted to put the same book. This also means that on the overlay the same book might
	 * appear more than once currently, this might seem like redundant information but a book that appears twice is in
	 * fact twice as likely to be in the bookcase compared to a book appearing only once.
	 */
	@Getter
	private List<Book> possibleBooks;

	// Variables initialization
	{
		possibleBooks = new ArrayList<>();
	}

	/**
	 * Constructor for the Bookcase class. Simply the location of the bookcase used for drawing on it.
	 *
	 * @param location WorldPoint location of the bookcase.
	 */
	Bookcase(WorldPoint location)
	{
		this.location = location;
	}

	/**
	 * Reset the bookcase to the base state.
	 */
	void reset()
	{
		isBookSet = false;
		book = null;
	}

	/**
	 * Used to set the book found or determined to be in the bookcase.
	 *
	 * @param book Book found in this bookcase.
	 */
	public void setBook(Book book)
	{
		this.book = book;
		this.isBookSet = true;
	}
}