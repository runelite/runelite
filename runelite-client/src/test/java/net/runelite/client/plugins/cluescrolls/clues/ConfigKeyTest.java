/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.fail;
import org.junit.Test;

public class ConfigKeyTest
{
	@Test
	public void testConfigKeyUnique()
	{
		List<ClueScroll> allClues = new ArrayList<>();
		allClues.addAll(FairyRingClue.CLUES);
		allClues.addAll(CoordinateClue.CLUES.values());
		allClues.addAll(CipherClue.CLUES);
		allClues.addAll(CrypticClue.CLUES);
		allClues.addAll(FaloTheBardClue.CLUES);
		allClues.addAll(AnagramClue.CLUES);
		allClues.addAll(MapClue.CLUES);
		allClues.addAll(SkillChallengeClue.CLUES);
		allClues.addAll(EmoteClue.CLUES);

		Set<Integer> seen = new HashSet<>();
		for (ClueScroll c : allClues)
		{
			for (int key : c.getConfigKeys())
			{
				if (!seen.add(key))
				{
					fail("duplicate clue config key");
				}
			}
		}
	}
}
