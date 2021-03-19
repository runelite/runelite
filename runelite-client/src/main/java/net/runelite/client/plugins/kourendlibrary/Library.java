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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.coords.WorldPoint;

import static net.runelite.client.plugins.kourendlibrary.Book.*;

/**
 * Library represents a instance of the Kourend/Arceuus House library.
 * <p>
 * The library changes the locations of it's books every 60-90 minutes.
 * Of the 554 bookcases in the library, only 346 of them can ever have books.
 * 6 of the bookcases in the south-west corner of the top floor are duplicated.
 * These 6 bookcases are not handled 100% correctly due to their low chance
 * of being used to train the predictor.
 * <p>
 * Each of the 352 bookcase slots "Bookcase"s has an index which is used to
 * place the book inside of them. The game chooses one of the 5 sequences and a
 * bookcase starting index, then places a book from the sequence into every 13th
 * bookcase, by index. Each sequence contains 26 Books, consisting of 16 books
 * and 10 dark manuscripts. You can only get one dark manuscript at a time, though
 * they are all placed into shelves.
 */
@Singleton
@Slf4j
class Library
{
	private final Map<WorldPoint, Bookcase> byPoint = new HashMap<>();
	private final Map<Integer, ArrayList<Bookcase>> byLevel = new HashMap<>();
	private final List<Bookcase> byIndex = new ArrayList<>();

	private final List<List<Book>> sequences = populateSequences();

	private final int step;

	@Getter
	private SolvedState state;

	@Getter
	private Book customerBook;

	@Getter
	private int customerId;

	Library()
	{
		populateBooks();
		step = byIndex.size() / Book.values().length;
		reset();
	}

	synchronized List<Bookcase> getBookcasesOnLevel(int z)
	{
		return Collections.unmodifiableList(byLevel.get(z));
	}

	synchronized List<Bookcase> getBookcases()
	{
		return Collections.unmodifiableList(byIndex);
	}

	void setCustomer(int customerId, Book book)
	{
		this.customerId = customerId;
		this.customerBook = book;
	}

	synchronized void reset()
	{
		state = SolvedState.NO_DATA;
		for (Bookcase b : byIndex)
		{
			b.clearBook();
			b.getPossibleBooks().clear();
		}
		log.info("Library is now reset");
	}

	synchronized void mark(WorldPoint loc, Book book)
	{
		Bookcase bookcase = byPoint.get(loc);
		if (bookcase == null)
		{
			log.debug("Requested non-existent bookcase at {}", loc);
			return;
		}

		if (bookcase.isBookSet())
		{
			// Bookcase is set from a previous mark
			// Check for a mismatch, unless it is now null and had a dark manuscript or Varlamore Envoy
			if (book != bookcase.getBook()
				&& !(book == null && (bookcase.getBook().isDarkManuscript() || bookcase.getBook() == VARLAMORE_ENVOY)))
			{
				reset();
			}
		}
		else if (state != SolvedState.NO_DATA)
		{
			// Reset if the book we found isn't what we expected

			if (book != null && !bookcase.getPossibleBooks().contains(book))
			{
				reset();
			}
		}

		if (state == SolvedState.COMPLETE)
		{
			// Reset if we found nothing when we expected something that wasn't a Dark Manuscript or Varlamore Envoy
			// since the layout has changed
			if (book == null
				&& !bookcase.getPossibleBooks().isEmpty()
				&& bookcase.getPossibleBooks().stream().noneMatch(b -> b.isDarkManuscript() || b == VARLAMORE_ENVOY))
			{
				reset();
			}
			else
			{
				// Everything is known, nothing to do
				return;
			}
		}

		log.info("Setting bookcase {} to {}", bookcase.getIndex(), book);
		for (; ; )
		{
			bookcase.setBook(book);

			// Basing the sequences on null is not supported, though possible
			if (book == null)
			{
				return;
			}

			// This is one of the 6 bookcases with 2 ids. Not fully supported.
			if (bookcase.getIndex().size() != 1)
			{
				return;
			}

			int bookcaseIndex = bookcase.getIndex().get(0);

			state = SolvedState.INCOMPLETE;

			// Map each sequence to the number of bookcases that match the sequence
			// return 0 if it is a mismatch.
			// Keep in mind that Bookcases with dark manuscripts may be set to null.
			int[] certainty = sequences.stream().mapToInt(sequence ->
			{
				int zero = getBookcaseZeroIndexForSequenceWithBook(sequence, bookcaseIndex, book);

				int found = 0;
				for (int i = 0; i < byIndex.size(); i++)
				{
					int ai = (i + zero) % byIndex.size();
					Bookcase iBookcase = byIndex.get(ai);
					if (i % step == 0)
					{
						int seqI = i / step;
						if (iBookcase.isBookSet() && seqI < sequence.size())
						{
							Book seqBook = sequence.get(seqI);
							boolean isSeqManuscript = seqBook == null || seqBook.isDarkManuscript();
							if (!((isSeqManuscript && iBookcase.getBook() == null) || (iBookcase.getBook() == seqBook)))
							{
								log.debug("Bailing @ i={} ai={} {}; {} != {}", i, ai, iBookcase.getIndex(), iBookcase.getBook(), seqBook);
								found = 0;
								break;
							}
							found++;
						}
					}
					else
					{
						// Only bail if this isn't a double bookcase
						if (iBookcase.isBookSet() && iBookcase.getBook() != null && iBookcase.getIndex().size() == 1)
						{
							log.debug("Bailing @ i={} ai={} {}; {} is set", i, ai, iBookcase.getIndex(), iBookcase.getBook());
							found = 0;
							break;
						}
					}
				}
				return found;
			}).toArray();
			log.info("Certainty is now {}", certainty);

			for (Bookcase b : byIndex)
			{
				b.getPossibleBooks().clear();
			}

			// Write the most likely sequences onto the bookcases
			int max = IntStream.of(certainty).max().getAsInt();

			// We have books set, but 0 sequences match, Something is wrong, reset.
			if (max == 0)
			{
				reset();
				continue;
			}

			IntStream.range(0, sequences.size())
				.filter(i -> certainty[i] == max)
				.forEach(isequence ->
				{
					List<Book> sequence = sequences.get(isequence);
					int zero = getBookcaseZeroIndexForSequenceWithBook(sequence, bookcaseIndex, book);

					for (int i = 0; i < byIndex.size(); i++)
					{
						int ai = (i + zero) % byIndex.size();
						Bookcase iBookcase = byIndex.get(ai);
						if (iBookcase.getBook() == null)
						{
							int iseq = i / step;
							if (i % step == 0 && iseq < sequence.size())
							{
								Book seqBook = sequence.get(iseq);
								iBookcase.getPossibleBooks().add(seqBook);
							}
						}
					}
				});
			if (IntStream.range(0, certainty.length).filter(i -> certainty[i] == max).count() == 1)
			{
				state = SolvedState.COMPLETE;
			}
			return;
		}
	}

	/**
	 * Find the bookcase index that is index zero in the sequence, identifying by the book in bookcase
	 */
	private int getBookcaseZeroIndexForSequenceWithBook(List<Book> sequences, int bookcaseIndex, Book book)
	{
		int bookSequence = sequences.indexOf(book);
		assert bookSequence >= 0;

		bookcaseIndex -= step * bookSequence;
		while (bookcaseIndex < 0)
		{
			bookcaseIndex += byIndex.size();
		}
		return bookcaseIndex;
	}

	private List<List<Book>> populateSequences()
	{
		List<List<Book>> books = Arrays.asList(
			Arrays.asList(
				DARK_MANUSCRIPT_13516,
				KILLING_OF_A_KING,
				DARK_MANUSCRIPT_13520,
				IDEOLOGY_OF_DARKNESS,
				RADAS_JOURNEY,
				TRANSVERGENCE_THEORY,
				TRISTESSAS_TRAGEDY,
				DARK_MANUSCRIPT_13523,
				DARK_MANUSCRIPT_13521,
				RADAS_CENSUS,
				TREACHERY_OF_ROYALTY,
				HOSIDIUS_LETTER,
				DARK_MANUSCRIPT_13519,
				RICKTORS_DIARY_7,
				DARK_MANUSCRIPT_13514,
				EATHRAM_RADA_EXTRACT,
				DARK_MANUSCRIPT_13522,
				VARLAMORE_ENVOY,
				WINTERTODT_PARABLE,
				TWILL_ACCORD,
				DARK_MANUSCRIPT_13515,
				BYRNES_CORONATION_SPEECH,
				DARK_MANUSCRIPT_13517,
				SOUL_JOURNEY,
				DARK_MANUSCRIPT_13518,
				TRANSPORTATION_INCANTATIONS
			),
			Arrays.asList(
				DARK_MANUSCRIPT_13516,
				KILLING_OF_A_KING,
				DARK_MANUSCRIPT_13520,
				IDEOLOGY_OF_DARKNESS,
				RADAS_JOURNEY,
				TRANSVERGENCE_THEORY,
				TRISTESSAS_TRAGEDY,
				DARK_MANUSCRIPT_13523,
				DARK_MANUSCRIPT_13521,
				RADAS_CENSUS,
				TREACHERY_OF_ROYALTY,
				HOSIDIUS_LETTER,
				VARLAMORE_ENVOY,
				DARK_MANUSCRIPT_13519,
				RICKTORS_DIARY_7,
				DARK_MANUSCRIPT_13514,
				EATHRAM_RADA_EXTRACT,
				DARK_MANUSCRIPT_13522,
				SOUL_JOURNEY,
				WINTERTODT_PARABLE,
				TWILL_ACCORD,
				DARK_MANUSCRIPT_13515,
				BYRNES_CORONATION_SPEECH,
				DARK_MANUSCRIPT_13517,
				DARK_MANUSCRIPT_13518,
				TRANSPORTATION_INCANTATIONS
			),
			Arrays.asList(
				RICKTORS_DIARY_7,
				VARLAMORE_ENVOY,
				DARK_MANUSCRIPT_13514,
				EATHRAM_RADA_EXTRACT,
				IDEOLOGY_OF_DARKNESS,
				DARK_MANUSCRIPT_13516,
				DARK_MANUSCRIPT_13521,
				RADAS_CENSUS,
				DARK_MANUSCRIPT_13515,
				KILLING_OF_A_KING,
				DARK_MANUSCRIPT_13520,
				TREACHERY_OF_ROYALTY,
				HOSIDIUS_LETTER,
				DARK_MANUSCRIPT_13519,
				BYRNES_CORONATION_SPEECH,
				DARK_MANUSCRIPT_13517,
				SOUL_JOURNEY,
				DARK_MANUSCRIPT_13522,
				WINTERTODT_PARABLE,
				TWILL_ACCORD,
				RADAS_JOURNEY,
				TRANSVERGENCE_THEORY,
				TRISTESSAS_TRAGEDY,
				DARK_MANUSCRIPT_13523,
				DARK_MANUSCRIPT_13518,
				TRANSPORTATION_INCANTATIONS
			),
			Arrays.asList(
				RADAS_CENSUS,
				DARK_MANUSCRIPT_13522,
				RICKTORS_DIARY_7,
				DARK_MANUSCRIPT_13514,
				EATHRAM_RADA_EXTRACT,
				DARK_MANUSCRIPT_13516,
				KILLING_OF_A_KING,
				DARK_MANUSCRIPT_13520,
				HOSIDIUS_LETTER,
				DARK_MANUSCRIPT_13519,
				DARK_MANUSCRIPT_13521,
				WINTERTODT_PARABLE,
				TWILL_ACCORD,
				DARK_MANUSCRIPT_13515,
				BYRNES_CORONATION_SPEECH,
				DARK_MANUSCRIPT_13517,
				IDEOLOGY_OF_DARKNESS,
				RADAS_JOURNEY,
				TRANSVERGENCE_THEORY,
				TRISTESSAS_TRAGEDY,
				DARK_MANUSCRIPT_13523,
				TREACHERY_OF_ROYALTY,
				DARK_MANUSCRIPT_13518,
				TRANSPORTATION_INCANTATIONS,
				SOUL_JOURNEY,
				VARLAMORE_ENVOY
			),
			Arrays.asList(
				RADAS_CENSUS,
				TRANSVERGENCE_THEORY,
				TREACHERY_OF_ROYALTY,
				RADAS_JOURNEY,
				KILLING_OF_A_KING,
				DARK_MANUSCRIPT_13520,
				VARLAMORE_ENVOY,
				DARK_MANUSCRIPT_13522,
				BYRNES_CORONATION_SPEECH,
				DARK_MANUSCRIPT_13517,
				HOSIDIUS_LETTER,
				DARK_MANUSCRIPT_13516,
				DARK_MANUSCRIPT_13519,
				TRISTESSAS_TRAGEDY,
				DARK_MANUSCRIPT_13523,
				DARK_MANUSCRIPT_13521,
				RICKTORS_DIARY_7,
				DARK_MANUSCRIPT_13514,
				IDEOLOGY_OF_DARKNESS,
				WINTERTODT_PARABLE,
				TWILL_ACCORD,
				SOUL_JOURNEY,
				DARK_MANUSCRIPT_13515,
				EATHRAM_RADA_EXTRACT,
				DARK_MANUSCRIPT_13518,
				TRANSPORTATION_INCANTATIONS
			)
		);

		for (int i = 0; i < books.size(); i++)
		{
			assert new HashSet<>(books.get(i)).size() == books.get(i).size();
			books.set(i, Collections.unmodifiableList(books.get(i)));
		}
		return Collections.unmodifiableList(books);
	}

	private void add(int x, int y, int z, int i)
	{
		// 'i' is added as a parameter for readability
		WorldPoint p = new WorldPoint(x, y, z);
		Bookcase b = byPoint.get(p);
		if (b == null)
		{
			b = new Bookcase(p);
			byPoint.put(p, b);
			byLevel.computeIfAbsent(z, a -> new ArrayList<>()).add(b);
		}
		b.getIndex().add(i);
		assert i == byIndex.size();
		byIndex.add(b);
	}

	private void populateBooks()
	{
		add(1626, 3795, 0, 0);
		add(1625, 3793, 0, 1);
		add(1623, 3793, 0, 2);
		add(1620, 3792, 0, 3);
		add(1624, 3792, 0, 4);
		add(1626, 3788, 0, 5);
		add(1626, 3787, 0, 6);
		add(1624, 3784, 0, 7);
		add(1623, 3784, 0, 8);
		add(1621, 3784, 0, 9);
		add(1615, 3785, 0, 10);
		add(1615, 3788, 0, 11);
		add(1615, 3790, 0, 12);
		add(1614, 3790, 0, 13);
		add(1614, 3788, 0, 14);
		add(1614, 3786, 0, 15);
		add(1612, 3784, 0, 16);
		add(1610, 3784, 0, 17);
		add(1609, 3784, 0, 18);
		add(1607, 3786, 0, 19);
		add(1607, 3789, 0, 20);
		add(1607, 3795, 0, 21);
		add(1607, 3796, 0, 22);
		add(1607, 3799, 0, 23);
		add(1610, 3801, 0, 24);
		add(1612, 3801, 0, 25);
		add(1618, 3801, 0, 26);
		add(1620, 3801, 0, 27);
		add(1620, 3814, 0, 28);
		add(1618, 3814, 0, 29);
		add(1617, 3814, 0, 30);
		add(1615, 3816, 0, 31);
		add(1615, 3817, 0, 32);
		add(1615, 3820, 0, 33);
		add(1614, 3820, 0, 34);
		add(1614, 3817, 0, 35);
		add(1614, 3816, 0, 36);
		add(1612, 3814, 0, 37);
		add(1610, 3814, 0, 38);
		add(1607, 3816, 0, 39);
		add(1607, 3817, 0, 40);
		add(1607, 3820, 0, 41);
		add(1607, 3826, 0, 42);
		add(1607, 3828, 0, 43);
		add(1609, 3831, 0, 44);
		add(1612, 3831, 0, 45);
		add(1614, 3831, 0, 46);
		add(1619, 3831, 0, 47);
		add(1621, 3831, 0, 48);
		add(1624, 3831, 0, 49);
		add(1626, 3829, 0, 50);
		add(1626, 3827, 0, 51);
		add(1624, 3823, 0, 52);
		add(1622, 3823, 0, 53);
		add(1620, 3823, 0, 54);
		add(1621, 3822, 0, 55);
		add(1624, 3822, 0, 56);
		add(1626, 3820, 0, 57);
		add(1639, 3821, 0, 58);
		add(1639, 3822, 0, 59);
		add(1639, 3827, 0, 60);
		add(1639, 3829, 0, 61);
		add(1642, 3831, 0, 62);
		add(1645, 3831, 0, 63);
		add(1646, 3829, 0, 64);
		add(1646, 3827, 0, 65);
		add(1646, 3826, 0, 66);
		add(1647, 3827, 0, 67);
		add(1647, 3829, 0, 68);
		add(1647, 3830, 0, 69);
		add(1652, 3831, 0, 70);
		add(1653, 3831, 0, 71);
		add(1656, 3831, 0, 72);
		add(1658, 3829, 0, 73);
		add(1658, 3826, 0, 74);
		add(1658, 3825, 0, 75);
		add(1658, 3820, 0, 76);
		add(1658, 3819, 0, 77);
		add(1658, 3816, 0, 78);
		add(1655, 3814, 0, 79);
		add(1654, 3814, 0, 80);
		add(1651, 3817, 0, 81);
		add(1651, 3819, 0, 82);
		add(1651, 3820, 0, 83);
		add(1650, 3821, 0, 84);
		add(1650, 3819, 0, 85);
		add(1650, 3816, 0, 86);
		add(1648, 3814, 0, 87);
		add(1646, 3814, 0, 88);
		add(1645, 3814, 0, 89);
		add(1607, 3820, 1, 90);
		add(1607, 3821, 1, 91);
		add(1609, 3822, 1, 92);
		add(1612, 3823, 1, 93);
		add(1611, 3823, 1, 94);
		add(1607, 3824, 1, 95);
		add(1607, 3825, 1, 96);
		add(1607, 3827, 1, 97);
		add(1611, 3831, 1, 98);
		add(1612, 3831, 1, 99);
		add(1613, 3831, 1, 100);
		add(1617, 3831, 1, 101);
		add(1618, 3831, 1, 102);
		add(1620, 3831, 1, 103);
		add(1624, 3831, 1, 104);
		add(1624, 3829, 1, 105);
		add(1624, 3825, 1, 106);
		add(1624, 3824, 1, 107);
		add(1624, 3819, 1, 108);
		add(1624, 3817, 1, 109);
		add(1623, 3816, 1, 110);
		add(1621, 3816, 1, 111);
		add(1617, 3816, 1, 112);
		add(1616, 3816, 1, 113);
		add(1611, 3816, 1, 114);
		add(1609, 3816, 1, 115);
		add(1620, 3820, 1, 116);
		add(1620, 3822, 1, 117);
		add(1620, 3824, 1, 118);
		add(1620, 3825, 1, 119);
		add(1620, 3827, 1, 120);
		add(1621, 3826, 1, 121);
		add(1621, 3822, 1, 122);
		add(1621, 3820, 1, 123);
		add(1607, 3788, 1, 124);
		add(1607, 3789, 1, 125);
		add(1609, 3790, 1, 126);
		add(1611, 3790, 1, 127);
		add(1613, 3790, 1, 128);
		add(1614, 3789, 1, 129);
		add(1615, 3788, 1, 130);
		add(1615, 3790, 1, 131);
		add(1614, 3791, 1, 132);
		add(1613, 3791, 1, 133);
		add(1610, 3791, 1, 134);
		add(1609, 3791, 1, 135);
		add(1608, 3791, 1, 136);
		add(1607, 3793, 1, 137);
		add(1607, 3794, 1, 138);
		add(1608, 3799, 1, 139);
		add(1610, 3799, 1, 140);
		add(1615, 3799, 1, 141);
		add(1616, 3799, 1, 142);
		add(1621, 3799, 1, 143);
		add(1623, 3799, 1, 144);
		add(1624, 3798, 1, 145);
		add(1624, 3796, 1, 146);
		add(1624, 3792, 1, 147);
		add(1624, 3791, 1, 148);
		add(1623, 3789, 1, 149);
		add(1621, 3789, 1, 150);
		add(1620, 3788, 1, 151);
		add(1621, 3788, 1, 152);
		add(1624, 3787, 1, 153);
		add(1624, 3786, 1, 154);
		add(1619, 3784, 1, 155);
		add(1618, 3784, 1, 156);
		add(1616, 3784, 1, 157);
		add(1612, 3784, 1, 158);
		add(1611, 3784, 1, 159);
		add(1625, 3801, 1, 160);
		add(1625, 3802, 1, 161);
		add(1625, 3803, 1, 162);
		add(1625, 3804, 1, 163);
		add(1625, 3806, 1, 164);
		add(1625, 3807, 1, 165);
		add(1625, 3808, 1, 166);
		add(1625, 3809, 1, 167);
		add(1625, 3811, 1, 168);
		add(1625, 3812, 1, 169);
		add(1625, 3813, 1, 170);
		add(1625, 3814, 1, 171);
		add(1626, 3815, 1, 172);
		add(1627, 3815, 1, 173);
		add(1631, 3815, 1, 174);
		add(1632, 3815, 1, 175);
		add(1633, 3815, 1, 176);
		add(1634, 3815, 1, 177);
		add(1638, 3815, 1, 178);
		add(1639, 3815, 1, 179);
		add(1640, 3814, 1, 180);
		add(1640, 3813, 1, 181);
		add(1640, 3803, 1, 182);
		add(1640, 3802, 1, 183);
		add(1640, 3801, 1, 184);
		add(1639, 3800, 1, 185);
		add(1638, 3800, 1, 186);
		add(1634, 3800, 1, 187);
		add(1633, 3800, 1, 188);
		add(1632, 3800, 1, 189);
		add(1631, 3800, 1, 190);
		add(1627, 3800, 1, 191);
		add(1626, 3800, 1, 192);
		add(1641, 3817, 1, 193);
		add(1641, 3818, 1, 194);
		add(1641, 3819, 1, 195);
		add(1641, 3824, 1, 196);
		add(1641, 3825, 1, 197);
		add(1641, 3829, 1, 198);
		add(1645, 3831, 1, 199);
		add(1646, 3831, 1, 200);
		add(1647, 3831, 1, 201);
		add(1648, 3831, 1, 202);
		add(1649, 3830, 1, 203);
		add(1649, 3828, 1, 204);
		add(1650, 3829, 1, 205);
		add(1652, 3831, 1, 206);
		add(1653, 3831, 1, 207);
		add(1658, 3827, 1, 208);
		add(1658, 3826, 1, 209);
		add(1658, 3823, 1, 210);
		add(1658, 3822, 1, 211);
		add(1658, 3821, 1, 212);
		add(1658, 3820, 1, 213);
		add(1656, 3816, 1, 214);
		add(1655, 3816, 1, 215);
		add(1651, 3816, 1, 216);
		add(1649, 3816, 1, 217);
		add(1648, 3816, 1, 218);
		add(1644, 3816, 1, 219);
		add(1643, 3816, 1, 220);
		add(1607, 3785, 2, 221);
		add(1607, 3786, 2, 222);
		add(1607, 3796, 2, 223);
		add(1607, 3797, 2, 224);
		add(1608, 3799, 2, 225);
		add(1610, 3799, 2, 226);
		add(1611, 3799, 2, 227);
		add(1618, 3799, 2, 228);
		add(1621, 3799, 2, 229);
		add(1624, 3797, 2, 230);
		add(1624, 3795, 2, 231);
		add(1624, 3794, 2, 232);
		add(1624, 3792, 2, 233);
		add(1623, 3791, 2, 234);
		add(1622, 3791, 2, 235);
		add(1618, 3792, 2, 236);
		add(1618, 3793, 2, 237);
		add(1618, 3794, 2, 238);
		add(1617, 3793, 2, 239);
		add(1617, 3792, 2, 240);
		add(1618, 3790, 2, 241);
		add(1620, 3790, 2, 242);
		add(1622, 3790, 2, 243);
		add(1624, 3789, 2, 244);
		add(1624, 3788, 2, 245);
		add(1624, 3786, 2, 246);
		add(1624, 3785, 2, 247);
		add(1623, 3784, 2, 248);
		add(1621, 3784, 2, 249);
		add(1611, 3784, 2, 250);
		add(1609, 3784, 2, 251);
		add(1612, 3789, 2, 252);
		add(1612, 3791, 2, 253);
		add(1612, 3794, 2, 254);
		add(1613, 3793, 2, 255);
		add(1613, 3792, 2, 256);
		add(1613, 3791, 2, 257);
		add(1617, 3791, 2, 258);
		add(1617, 3793, 2, 259);
		add(1618, 3794, 2, 260);
		add(1618, 3792, 2, 261);
		add(1619, 3791, 2, 262);
		add(1623, 3791, 2, 263);
		add(1623, 3790, 2, 264);
		add(1622, 3790, 2, 265);
		add(1619, 3790, 2, 266);
		add(1611, 3816, 2, 267);
		add(1610, 3816, 2, 268);
		add(1609, 3816, 2, 269);
		add(1607, 3817, 2, 270);
		add(1607, 3819, 2, 271);
		add(1607, 3829, 2, 272);
		add(1608, 3831, 2, 273);
		add(1610, 3831, 2, 274);
		add(1611, 3831, 2, 275);
		add(1622, 3831, 2, 276);
		add(1623, 3831, 2, 277);
		add(1624, 3829, 2, 278);
		add(1624, 3828, 2, 279);
		add(1624, 3821, 2, 280);
		add(1624, 3819, 2, 281);
		add(1622, 3816, 2, 282);
		add(1620, 3816, 2, 283);
		add(1618, 3816, 2, 284);
		add(1615, 3821, 2, 285);
		add(1617, 3821, 2, 286);
		add(1619, 3822, 2, 287);
		add(1619, 3824, 2, 288);
		add(1618, 3826, 2, 289);
		add(1617, 3826, 2, 290);
		add(1615, 3827, 2, 291);
		add(1616, 3827, 2, 292);
		add(1618, 3827, 2, 293);
		add(1620, 3826, 2, 294);
		add(1620, 3824, 2, 295);
		add(1620, 3822, 2, 296);
		add(1620, 3821, 2, 297);
		add(1619, 3820, 2, 298);
		add(1617, 3820, 2, 299);
		add(1615, 3820, 2, 300);
		add(1641, 3818, 2, 301);
		add(1641, 3820, 2, 302);
		add(1641, 3821, 2, 303);
		add(1641, 3829, 2, 304);
		add(1643, 3831, 2, 305);
		add(1644, 3831, 2, 306);
		add(1654, 3831, 2, 307);
		add(1656, 3831, 2, 308);
		add(1658, 3830, 2, 309);
		add(1658, 3828, 2, 310);
		add(1658, 3818, 2, 311);
		add(1658, 3817, 2, 312);
		add(1656, 3816, 2, 313);
		add(1655, 3816, 2, 314);
		add(1652, 3816, 2, 315);
		add(1648, 3817, 2, 316);
		add(1648, 3819, 2, 317);
		add(1648, 3821, 2, 318);
		add(1649, 3823, 2, 319);
		add(1650, 3823, 2, 320);
		add(1652, 3823, 2, 321);
		add(1654, 3822, 2, 322);
		add(1654, 3820, 2, 323);
		add(1655, 3820, 2, 324);
		add(1655, 3821, 2, 325);
		add(1655, 3823, 2, 326);
		add(1653, 3824, 2, 327);
		add(1652, 3824, 2, 328);
		add(1649, 3824, 2, 329);
		add(1648, 3824, 2, 330);
		add(1647, 3822, 2, 331);
		add(1647, 3820, 2, 332);
		add(1647, 3818, 2, 333);
		add(1645, 3816, 2, 334);
		add(1644, 3816, 2, 335);
		add(1625, 3802, 2, 336);
		add(1625, 3804, 2, 337);
		add(1625, 3811, 2, 338);
		add(1625, 3812, 2, 339);
		add(1627, 3815, 2, 340);
		add(1628, 3815, 2, 341);
		add(1635, 3815, 2, 342);
		add(1637, 3815, 2, 343);
		add(1638, 3815, 2, 344);
		add(1640, 3813, 2, 345);
		add(1640, 3811, 2, 346);
		add(1640, 3810, 2, 347);
		add(1638, 3800, 2, 348);
		add(1632, 3800, 2, 349);
		add(1630, 3800, 2, 350);
		add(1629, 3800, 2, 351);
		add(1627, 3800, 2, 352);
	}
}