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
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CipherClueTest
{
	@Mock
	private ClueScrollPlugin plugin;

	@Mock
	private Client client;

	@Test
	public void forTextEmptyString()
	{
		assertNull(CipherClue.forText(""));
	}

	@Test
	public void uniqueIds()
	{
		final Set<Integer> clueIds = CipherClue.CLUES.stream()
			.mapToInt(CipherClue::getItemId)
			.boxed()
			.collect(Collectors.toUnmodifiableSet());

		assertEquals(CipherClue.CLUES.size(), clueIds.size());
	}

	@Test
	public void defaultNpcValue()
	{
		CipherClue clue = CipherClue.forText("The cipher reveals who to speak to next: ESBZOPS QJH QFO");
		assert clue != null;

		assertEquals(-1, clue.getNpc());
	}

	@Test
	public void elunedLocation()
	{
		when(plugin.getClient()).thenReturn(client);
		when(client.getIntStack()).thenReturn(new int[]{1}, new int[]{0}, new int[]{2}); // NOT_STARTED, IN_PROGRESS, FINISHED

		CipherClue clue = CipherClue.forText("The cipher reveals who to speak to next: OVEXON");
		assert clue != null;

		assertEquals("Outside Lletya", clue.getArea(plugin));
		assertEquals("Outside Lletya", clue.getArea(plugin));
		assertEquals("Prifddinas", clue.getArea(plugin));
	}
}
