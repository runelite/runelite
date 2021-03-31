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

import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Arrays;

public class SkillChallengeClueTest
{
	@Test
	public void forTextEmptyString()
	{
		assertNull(SkillChallengeClue.forText("", ""));
	}

	@Test
	public void testAnglerOutfitRequirement()
	{
		assertTrue("regular angler outfit should meet requirement", fulfilledBy(SkillChallengeClue.ANGLER_OUTFIT,
			ItemID.ANGLER_HAT, ItemID.ANGLER_TOP, ItemID.ANGLER_WADERS, ItemID.ANGLER_BOOTS));
		assertTrue("spirit angler outfit should meet requirement", fulfilledBy(SkillChallengeClue.ANGLER_OUTFIT,
			ItemID.SPIRIT_ANGLER_HEADBAND, ItemID.SPIRIT_ANGLER_TOP, ItemID.SPIRIT_ANGLER_WADERS, ItemID.SPIRIT_ANGLER_BOOTS));
		assertTrue("mixed angler outfit should meet requirement", fulfilledBy(SkillChallengeClue.ANGLER_OUTFIT,
			ItemID.ANGLER_HAT, ItemID.SPIRIT_ANGLER_TOP, ItemID.ANGLER_WADERS, ItemID.SPIRIT_ANGLER_BOOTS));
		assertTrue("multiple angler outfits should meet requirement", fulfilledBy(SkillChallengeClue.ANGLER_OUTFIT,
			ItemID.ANGLER_HAT, ItemID.ANGLER_TOP, ItemID.ANGLER_WADERS, ItemID.ANGLER_BOOTS,
			ItemID.SPIRIT_ANGLER_HEADBAND, ItemID.SPIRIT_ANGLER_TOP, ItemID.SPIRIT_ANGLER_WADERS, ItemID.SPIRIT_ANGLER_BOOTS));

		assertFalse("incomplete angler outfit shouldn't meet requirement", fulfilledBy(SkillChallengeClue.ANGLER_OUTFIT,
			ItemID.ANGLER_HAT, ItemID.SPIRIT_ANGLER_HEADBAND, ItemID.ANGLER_WADERS, ItemID.SPIRIT_ANGLER_WADERS));
	}

	private boolean fulfilledBy(ItemRequirement itemRequirement, int... itemIDs)
	{
		final Item[] items = Arrays.stream(itemIDs)
			.mapToObj(itemID -> new Item(itemID, 1))
			.toArray(Item[]::new);
		return itemRequirement.fulfilledBy(items);
	}
}
