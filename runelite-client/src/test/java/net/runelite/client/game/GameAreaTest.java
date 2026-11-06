/*
 * Copyright (c) 2025, Jordan Atwood <nightfirecat@nightfirec.at>
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
package net.runelite.client.game;

import java.util.Arrays;
import net.runelite.api.coords.WorldPoint;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

public class GameAreaTest
{
	@Test
	public void ensureNoOverlappingAreas()
	{
		for (final GameArea gameArea : GameArea.values())
		{
			for (final GameArea otherGameArea : Arrays.copyOfRange(GameArea.values(), gameArea.ordinal(), GameArea.values().length))
			{
				for (final RegionArea regionArea : gameArea.getRegionAreas())
				{
					for (final RegionArea otherRegionArea : otherGameArea.getRegionAreas())
					{
						if (regionArea == otherRegionArea)
						{
							continue;
						}

						if (regionArea.subRegionIntersects(otherRegionArea))
						{
							fail("Game area " + gameArea + " has region area " + regionArea
								+ " which overlaps area of " + otherGameArea + ": " + otherRegionArea);
						}
					}
				}
			}
		}
	}

	@Test
	public void testFromPoint()
	{
		assertEquals(GameArea.VARROCK, GameArea.fromPoint(new WorldPoint(3213, 3427, 0)));
		assertEquals(GameArea.BARBARIAN_OUTPOST, GameArea.fromPoint(new WorldPoint(2535, 3571, 0)));
		assertEquals(GameArea.RELLEKKA, GameArea.fromPoint(new WorldPoint(2657, 3676, 0)));
		assertEquals(GameArea.FREMENNIK_PROVINCE, GameArea.fromPoint(new WorldPoint(2663, 3609, 0)));
		assertEquals(GameArea.TOWER_OF_LIFE_DUNGEON, GameArea.fromPoint(new WorldPoint(3040, 4382, 0)));
		assertEquals(GameArea.DAGANNOTH_KINGS, GameArea.fromPoint(new WorldPoint(2913, 4383, 0)));
		assertEquals(GameArea.DAGANNOTH_KINGS, GameArea.fromPoint(new WorldPoint(2911, 4451, 0)));
		assertEquals(GameArea.NIGHTMARE_ZONE, GameArea.fromPoint(new WorldPoint(2277, 4695, 1)));
		assertNull(null, GameArea.fromPoint(new WorldPoint(2277, 4695, 0))); // King Black Dragon on plane 0
		assertEquals(GameArea.MTA_ENCHANTING_CHAMBER, GameArea.fromPoint(new WorldPoint(3365, 9636, 0)));
		assertEquals(GameArea.MTA_CREATURE_GRAVEYARD, GameArea.fromPoint(new WorldPoint(3365, 9636, 1)));
		assertEquals(GameArea.MTA_ALCHEMISTS_PLAYGROUND, GameArea.fromPoint(new WorldPoint(3365, 9636, 2)));
	}
}
