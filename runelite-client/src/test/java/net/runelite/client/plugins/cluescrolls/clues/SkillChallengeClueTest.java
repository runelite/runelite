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

import net.runelite.api.gameval.ItemID;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SkillChallengeClueTest
{
	@Test
	public void forTextEmptyString()
	{
		assertNull(SkillChallengeClue.forText("", ""));
	}

	@Test
	public void itemRequirementsCreateABarrowsTeleportTablet()
	{
		String clueText = "Create a Barrows teleport tablet.";
		SkillChallengeClue barrowsClue = SkillChallengeClue.forText(clueText.toLowerCase(), clueText.toLowerCase());
		ItemRequirement[] requirements = barrowsClue.getItemRequirements();

		assertEquals(4, requirements.length);
		ItemRequirement darkEssenceBlock = requirements[0];
		ItemRequirement bloodRune = requirements[1];
		ItemRequirement lawRune = requirements[2];
		ItemRequirement soulRune = requirements[3];

		assertTrue("Dark Essence Block", darkEssenceBlock.fulfilledBy(ItemID.ARCEUUS_ESSENCE_BLOCK_DARK));
		assertTrue("Blood Rune x1", bloodRune.fulfilledBy(ItemID.BLOODRUNE));
		assertTrue("Law Rune x2", lawRune.fulfilledBy(ItemID.LAWRUNE));
		assertTrue("Soul Rune x2", soulRune.fulfilledBy(ItemID.SOULRUNE));
	}
}
