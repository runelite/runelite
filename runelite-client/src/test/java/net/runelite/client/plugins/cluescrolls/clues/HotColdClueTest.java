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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import net.runelite.api.gameval.ItemID;
import org.junit.Test;

public class HotColdClueTest
{
	private static final String BEGINNER_CLUE_TEXT = "Buried beneath the ground, who knows where it's found. Lucky for you, A man called Reldo may have a clue.";
	private static final String MASTER_CLUE_TEXT = "Buried beneath the ground, who knows where it's found. Lucky for you, A man called Jorral may have a clue.";
	private static final String LEAGUE_TUTOR_CLUE_TEXT = "Buried beneath the ground, who knows where it's found. The League Tutor may have a strange device lying around.";

	@Test
	public void forTextEmptyString()
	{
		assertNull(HotColdClue.forText(""));
	}

	@Test
	public void forTextBeginner()
	{
		HotColdClue clue = HotColdClue.forText(BEGINNER_CLUE_TEXT);
		assertNotNull(clue);
		assertTrue(clue.isBeginner());
	}

	@Test
	public void forTextMaster()
	{
		HotColdClue clue = HotColdClue.forText(MASTER_CLUE_TEXT);
		assertNotNull(clue);
		assertFalse(clue.isBeginner());
	}

	@Test
	public void forTextLeagueTutorWithoutItemId()
	{
		assertNull(HotColdClue.forText(LEAGUE_TUTOR_CLUE_TEXT));
	}

	@Test
	public void forTextLeagueTutorBeginnerItemId()
	{
		HotColdClue clue = HotColdClue.forText(LEAGUE_TUTOR_CLUE_TEXT, ItemID.TRAIL_CLUE_BEGINNER);
		assertNotNull(clue);
		assertTrue(clue.isBeginner());
	}

	@Test
	public void forTextLeagueTutorMasterItemId()
	{
		HotColdClue clue = HotColdClue.forText(LEAGUE_TUTOR_CLUE_TEXT, ItemID.TRAIL_CLUE_MASTER);
		assertNotNull(clue);
		assertFalse(clue.isBeginner());
	}
}
