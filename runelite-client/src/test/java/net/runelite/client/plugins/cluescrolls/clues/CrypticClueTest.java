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

import net.runelite.api.Client;
import net.runelite.api.Varbits;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CrypticClueTest
{
	@Mock
	private ClueScrollPlugin plugin;

	@Mock
	private Client client;

	@Test
	public void forTextEmptyString()
	{
		assertNull(CrypticClue.forText(""));
	}

	@Test
	public void forViggoraLocations()
	{
		when(plugin.getClient()).thenReturn(client);
		when(client.getVarbitValue(Varbits.VIGGORA_LOCATION)).thenReturn(0, 1, 2, 3, 4);

		CrypticClue clue = CrypticClue.forText("Come brave adventurer, your sense is on fire. If you talk to me, it's an old god you desire.");
		assert clue != null;

		assertNull(clue.getLocation(plugin));
		assertNotNull(clue.getLocation(plugin));
		assertNotNull(clue.getLocation(plugin));
		assertNotNull(clue.getLocation(plugin));
		assertNull(clue.getLocation(plugin));
	}
}
