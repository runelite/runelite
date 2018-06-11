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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.kourendlibrary.Book.KILLING_OF_A_KING;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KourendLibraryTest
{
	private Library library = new Library();

	private Map<Bookcase, Book> bookByBookcase;

	private Book activeDarkManuscript;

	private void fillBookcases(List<Book> sequence, int startingIndex, Book activeDarkManuscript)
	{
		this.activeDarkManuscript = activeDarkManuscript;
		bookByBookcase = new HashMap<>();
		int step = library.getStep();
		List<Bookcase> byIndex = library.getBookcaseByIndex();
		for (int i = 0; i < byIndex.size(); i++)
		{
			int ai = (i + startingIndex) % byIndex.size();
			Book seqBook = ((i % step == 0) && (i / step < sequence.size())) ? sequence.get(i / step) : null;
			Bookcase iBookcase = byIndex.get(ai);

			if (seqBook != null)
			{
				assert !bookByBookcase.containsKey(iBookcase);
				bookByBookcase.put(iBookcase, seqBook);
			}
		}
	}

	private void searchBookcaseIndex(int i)
	{
		if (i < 0)
		{
			i += library.getBookcaseByIndex().size();
		}
		else if (i >= library.getBookcaseByIndex().size())
		{
			i -= library.getBookcaseByIndex().size();
		}
		Bookcase bookcase = library.getBookcaseByIndex().get(i);
		Book book = bookByBookcase.getOrDefault(bookcase, null);
		if (book != null && book.isDarkManuscript() && book != activeDarkManuscript)
		{
			book = null;
		}
		library.mark(bookcase.getLocation(), book);
	}

	@Test
	public void testTryMarkingNonExistentBookcase()
	{
		library.mark(new WorldPoint(0, 0, 0), KILLING_OF_A_KING);
		assert library.getState() == SolvedState.NO_DATA;
	}

	@Test
	public void testSetCustomerAndCustomerBook()
	{
		LibraryCustomer customer = LibraryCustomer.VILLIA;
		Book book = KILLING_OF_A_KING;
		library.setCustomer(customer, book);
		assert library.getCustomer() == customer;
		assert library.getCustomerBook() == book;
	}

	@Test
	public void testSolveLibraryWithEmptyBookcase()
	{
		assert library.getState() == SolvedState.NO_DATA;
		fillBookcases(library.getSequences().get(0), 0, null);
		searchBookcaseIndex(library.getStep()); // Finds Killing of a king in single index bookcase
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 5;
		searchBookcaseIndex(library.getStep() * 3); // Finds Ideology of darkness
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 2; // First two sequences left
		searchBookcaseIndex(library.getStep() * 4); // Same book for both sequences left
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 2;
		searchBookcaseIndex(library.getStep() * 12); // Empty (dark manuscript) for first sequence only
		assert library.getState() == SolvedState.COMPLETE;
		searchBookcaseIndex(0);
		assert library.getState() == SolvedState.COMPLETE;
	}

	@Test
	public void testSolveLibraryWithDarkManuscripts()
	{
		assert library.getState() == SolvedState.NO_DATA;
		fillBookcases(library.getSequences().get(0), 0, library.getSequences().get(0).get(22));
		searchBookcaseIndex(-library.getStep()); // Finds Nothing
		assert library.getState() == SolvedState.NO_DATA;
		searchBookcaseIndex(library.getStep()); // Finds Killing of a king, two sequences left
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 2;
		searchBookcaseIndex(library.getStep() * 22); // Finds DARK_MANUSCRIPT_13517
		assert library.getState() == SolvedState.COMPLETE;
		assert !library.getSequences().get(0).get(22).isAvailableInBookcase();
	}

	@Test
	public void testSolveLibraryWithDoubleIndexBookcase()
	{
		// Index 234 is currently a double bookcase
		assert library.getState() == SolvedState.NO_DATA;
		fillBookcases(library.getSequences().get(0), 234 - library.getStep(), null);
		searchBookcaseIndex(234); // Finds Killing of a king in double index bookcase
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 10; // 5 using 234 to get zero index and 5 using 263
		searchBookcaseIndex(234 - 2 * library.getStep()); // Finds nothing
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 7; // Eliminate 3 sequences for index 234
		searchBookcaseIndex(263 - 2 * library.getStep()); // Finds nothing
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 4; // Eliminate 3 sequences for index 263
		searchBookcaseIndex(234 + 2 * library.getStep()); // Finds Ideology of darkness in double index bookcase
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 2; // Only sequences 1 and 2 starting using index 234 left
		searchBookcaseIndex(234 + 11 * library.getStep()); // Finds null in bookcase
		assert library.getState() == SolvedState.COMPLETE; // Only sequences 1 left using index 234
	}

	@Test
	public void testEliminateSequenceForDoubleIndexBookcase()
	{
		// Index 234 is currently a double bookcase, make it so sequences 0, 1, 2 and 4 expect null in it
		/*assert library.getState() == SolvedState.NO_DATA;
		fillBookcases(library.getSequences().get(3), 275, null);
		searchBookcaseIndex(221); // Finds Transportation incantations
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getCountAvailableSequences() == 5;
		searchBookcaseIndex(234); // Finds Soul journey, except sequence 3, every other sequence expect null here
		assert library.getState() == SolvedState.COMPLETE;*/// Index 234 is currently a double bookcase, make it so sequences 0, 1, 2 and 4 expect null in it
		assert library.getState() == SolvedState.NO_DATA;
		fillBookcases(library.getSequences().get(0), 0, null);
		searchBookcaseIndex(library.getStep()); // Finds Killing of a King
		searchBookcaseIndex(18 * library.getStep()); // Find book in double index bookcase
		assert library.getState() == SolvedState.COMPLETE;
	}

	@Test
	public void testLibraryReset()
	{
		fillBookcases(library.getSequences().get(0), 0, null);

		// Reset during during incomplete state
		library.reset();
		searchBookcaseIndex(library.getStep());
		assert library.getState() == SolvedState.INCOMPLETE;
		library.mark(library.getBookcaseByIndex().get(library.getStep()).getLocation(), null);
		assert library.getState() == SolvedState.NO_DATA;

		// Reset if incorrect book is found in bookcase for which the book is known
		library.reset();
		searchBookcaseIndex(library.getStep());
		searchBookcaseIndex(library.getStep() * 3); // Sequences 1 and 2 left
		searchBookcaseIndex(library.getStep() * 13); // Sequence 1 left
		assert library.getState() == SolvedState.COMPLETE;
		library.mark(library.getBookcaseByIndex().get(library.getStep()).getLocation(), null);
		assert library.getState() == SolvedState.NO_DATA;

		// Reset if incorrect book is found in bookcase for which we expected another book
		library.reset();
		searchBookcaseIndex(library.getStep());
		assert library.getBookcaseByIndex().get(library.getStep()).getBook() == KILLING_OF_A_KING;
		library.mark(library.getBookcaseByIndex().get(library.getStep() * 3).getLocation(), KILLING_OF_A_KING);
		assert library.getBookcaseByIndex().get(library.getStep()).getBook() == null;

		// Reset if book is found in bookcase that should be empty during incomplete state
		library.reset();
		searchBookcaseIndex(library.getStep());
		assert library.getBookcaseByIndex().get(library.getStep()).getBook() == KILLING_OF_A_KING;
		library.mark(library.getBookcaseByIndex().get(1).getLocation(), KILLING_OF_A_KING);
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getBookcaseByIndex().get(library.getStep()).getBook() == null;

		// Reset if book is found in bookcase that should be empty during complete state
		library.reset();
		searchBookcaseIndex(library.getStep());
		searchBookcaseIndex(library.getStep() * 3); // Sequences 1 and 2 left
		searchBookcaseIndex(library.getStep() * 13); // Sequence 1 left
		assert library.getState() == SolvedState.COMPLETE;
		library.mark(library.getBookcaseByIndex().get(1).getLocation(), KILLING_OF_A_KING);
		assert library.getState() == SolvedState.INCOMPLETE;
		assert library.getBookcaseByIndex().get(library.getStep()).getBook() == null;

		// Reset if all dark manuscript are checked but none was found
		library.reset();
		searchBookcaseIndex(library.getStep());
		searchBookcaseIndex(library.getStep() * 3); // Sequences 1 and 2 left
		searchBookcaseIndex(library.getStep() * 13); // Sequence 1 left
		assert library.getState() == SolvedState.COMPLETE;
		searchBookcaseIndex(0);
		searchBookcaseIndex(library.getStep() * 2);
		searchBookcaseIndex(library.getStep() * 7);
		searchBookcaseIndex(library.getStep() * 8);
		searchBookcaseIndex(library.getStep() * 12);
		searchBookcaseIndex(library.getStep() * 14);
		searchBookcaseIndex(library.getStep() * 16);
		searchBookcaseIndex(library.getStep() * 20);
		searchBookcaseIndex(library.getStep() * 22);
		assert library.getState() == SolvedState.COMPLETE; // One dark manuscript left to check
		searchBookcaseIndex(library.getStep() * 24);
		assert library.getState() == SolvedState.NO_DATA;
	}
}