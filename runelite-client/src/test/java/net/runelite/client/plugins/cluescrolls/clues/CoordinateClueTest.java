/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateClueTest
{
	@Mock
	private ClueScrollPlugin plugin;

	@Mock
	private Client client;

	@Test
	public void testDuplicateCoordinates()
	{
		// If this doesn't throw then the clues map doesn't have duplicate keys
		CoordinateClue.builder().build();
	}

	@Test
	public void testRequiresLight()
	{
		final CoordinateClue clueWithFirepit = CoordinateClue.forLocation(new WorldPoint(3830, 3060, 0));
		final CoordinateClue clueWithoutFirepit = CoordinateClue.forLocation(new WorldPoint(2217, 3092, 0));

		assertTrue(clueWithFirepit.isRequiresLight());
		assertFalse(clueWithoutFirepit.isRequiresLight());
	}

	@Test
	public void testIsleOfSoulsNpcs()
	{
		for (CoordinateClue clue : CoordinateClue.CLUES.values())
		{
			final Enemy enemy = clue.getEnemy();
			if (!(enemy == Enemy.ARMADYLEAN_GUARD || enemy == Enemy.BANDOSIAN_GUARD))
			{
				continue;
			}

			assertTrue("Armadylean guard-only and Bandosian guard-only clues only occur on the Isle of Souls; the following entry must be corrected:\n" + clue, clue.getDirections(plugin).contains("Isle of Souls"));
		}
	}

	@Test
	public void testResourceAreaCosts()
	{
		when(plugin.getClient()).thenReturn(client);
		when(client.getVarbitValue(Varbits.DIARY_WILDERNESS_ELITE)).thenReturn(1, 0, 0, 0, 0);
		when(client.getVarbitValue(Varbits.DIARY_WILDERNESS_HARD)).thenReturn(1, 0, 0, 0);
		when(client.getVarbitValue(Varbits.DIARY_WILDERNESS_MEDIUM)).thenReturn(1, 0, 0);

		CoordinateClue clue = CoordinateClue.forLocation(new WorldPoint(3188, 3933, 0));
		assert clue != null;

		assertFalse(clue.getDirections(plugin).contains("entry fee"));
		assertTrue(clue.getDirections(plugin).contains("An entry fee of 3,750 coins is required."));
		assertTrue(clue.getDirections(plugin).contains("An entry fee of 6,000 coins is required."));
		assertTrue(clue.getDirections(plugin).contains("An entry fee of 7,500 coins is required."));
		assertTrue(clue.getDirections(plugin).contains("An entry fee of 7,500 coins is required."));
	}

	@Test
	public void testHardwoodGroveCost()
	{
		when(plugin.getClient()).thenReturn(client);
		when(client.getVarbitValue(Varbits.DIARY_KARAMJA_ELITE)).thenReturn(1, 0);

		CoordinateClue clue = CoordinateClue.forLocation(new WorldPoint(2820, 3078, 0));
		assert clue != null;

		assertFalse(clue.getDirections(plugin).contains("entry fee"));
		assertTrue(clue.getDirections(plugin).contains("100 trading sticks"));
	}
}
