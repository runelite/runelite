/*
 * Copyright (c) 2020, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.plugins.cluescrolls.clues;

import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.api.Client;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnagramClueTest
{
	@Mock
	private ClueScrollPlugin plugin;

	@Mock
	private Client client;

	@Before
	public void before()
	{
		when(plugin.getClient()).thenReturn(client);
	}

	@Test
	public void forTextEmptyString()
	{
		assertNull(AnagramClue.forText(plugin, ""));
	}

	@Test
	public void uniqueIds()
	{
		final Set<AnagramClue> cluesWithIds = AnagramClue.CLUES.stream()
			.filter((clue) ->
			{
				final int clueId = clue.getItemId();
				return clueId != -1 && clueId != ItemID.TRAIL_CLUE_MASTER && clueId != ItemID.TRAIL_CLUE_BEGINNER;
			})
			.collect(Collectors.toUnmodifiableSet());
		final Set<Integer> clueIds = cluesWithIds.stream()
			.mapToInt(AnagramClue::getItemId)
			.boxed()
			.collect(Collectors.toSet());

		assertEquals(cluesWithIds.size(), clueIds.size());
	}

	@Test
	public void countLumbridgeGravestones()
	{
		when(client.getVarbitValue(VarbitID.HW17_JARVIS_DEAD)).thenReturn(0, 1, 2, 3);

		AnagramClue clue = AnagramClue.forText(plugin, "How many gravestones are in the church graveyard?");
		assert clue != null;

		assertEquals("19", clue.getAnswer(plugin));
		assertEquals("20", clue.getAnswer(plugin));
		assertEquals("19", clue.getAnswer(plugin));
		assertEquals("19", clue.getAnswer(plugin));
	}

	@Test
	public void nieveSteve()
	{
		when(client.getVarbitValue(VarbitID.MM2_SLAYER_MASTER)).thenReturn(0);

		AnagramClue clue1 = AnagramClue.forText(plugin, AnagramClue.ANAGRAM_TEXT + "I EVEN");

		assertArrayEquals(new String[]{"Nieve"}, clue1.getNpcs(plugin));

		when(client.getVarbitValue(VarbitID.MM2_SLAYER_MASTER)).thenReturn(1);

		AnagramClue clue2 = AnagramClue.forText(plugin, AnagramClue.ANAGRAM_TEXT + "VESTE");

		assertArrayEquals(new String[]{"Steve"}, clue2.getNpcs(plugin));
		assertSame(clue1, clue2);
	}
}
