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

import com.google.common.base.Joiner;
import java.util.Arrays;
import net.runelite.api.Client;
import net.runelite.api.ItemContainer;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InventoryID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.clues.ThreeStepCrypticClue.STEP_TO_CLUE_PART;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ThreeStepCrypticClueTest
{
	private static final Joiner THREE_CRYPTIC_NEWLINE_JOINER = Joiner.on("<br><br>");

	@Mock
	private ClueScrollPlugin plugin;

	@Mock
	private Client client;

	@Test
	public void forTextEmptyString()
	{
		assertNull(ThreeStepCrypticClue.forText("", ""));
	}

	@Test
	public void nonNullLocations()
	{
		when(plugin.getClient()).thenReturn(client);
		when(client.getVarbitValue(VarbitID.SECRET_GHOST_RANDOMISER)).thenReturn(1);

		final String clueText = Joiner.on("<br><br>").join(CrypticClue.CLUES.stream().map(CrypticClue::getText).toArray());
		final ThreeStepCrypticClue clue = ThreeStepCrypticClue.forText(Text.sanitizeMultilineText(clueText).toLowerCase(), clueText);

		assertNotNull(clue);
		for (final WorldPoint location : clue.getLocations(plugin))
		{
			assertNotNull(location);
		}
	}

	@Test
	public void propagateSpadeLightRequirements()
	{
		final String lightClueText = "I live in a deserted crack collecting soles.";
		final String spadeClueText = "A massive battle rages beneath so be careful when you dig by the large broken crossbow.";
		final String thirdClueText = "Probably filled with books on magic.";
		final String[] clues = { lightClueText, spadeClueText, thirdClueText };

		final CrypticClue spadeClue = ThreeStepCrypticClue.getCrypticFromText(spadeClueText);
		assertNotNull(spadeClue);
		assertTrue(spadeClue.isRequiresSpade());
		final CrypticClue lightClue = ThreeStepCrypticClue.getCrypticFromText(lightClueText);
		assertNotNull(lightClue);
		assertTrue(lightClue.isRequiresLight());

		final String clueText = THREE_CRYPTIC_NEWLINE_JOINER.join(clues);
		final ThreeStepCrypticClue clue = ThreeStepCrypticClue.forText(Text.sanitizeMultilineText(clueText).toLowerCase(), clueText);

		assertNotNull(clue);
		assertTrue(clue.isRequiresLight());
		assertTrue(clue.isRequiresSpade());

		// Complete only the light clue
		completeSteps(clue, 1);

		assertFalse(clue.isRequiresLight());
		assertTrue(clue.isRequiresSpade());

		// Complete only the spade clue
		completeSteps(clue, 2);

		assertFalse(clue.isRequiresLight());
		assertFalse(clue.isRequiresSpade());

		// Un-complete all steps
		resetAllSteps(clue);

		assertFalse(clue.isRequiresLight());
		assertFalse(clue.isRequiresSpade());
	}

	private static void resetAllSteps(final ThreeStepCrypticClue clue)
	{
		completeSteps(clue);
	}

	/**
	 * Completes the given clue step parts of the clue scroll. (and un-completes those not given)
	 *
	 * @param clue      The {@link ThreeStepCrypticClue three step cryptic clue} to be updated.
	 * @param steps     Clue steps to be completed by inserting their respective torn clue parts into a mock inventory
	 *                  (and removing those parts not given), then updating the clue via
	 *                  {@link ThreeStepCrypticClue#update(int, ItemContainer)}
	 */
	private static void completeSteps(final ThreeStepCrypticClue clue, final int... steps)
	{
		if (Arrays.stream(steps).anyMatch(i -> i < 1 || i > 3))
		{
			throw new IllegalArgumentException("All steps to be completed must be between 1 and 3, inclusive.");
		}

		final ItemContainer inventory = mock(ItemContainer.class);
		when(inventory.getId()).thenReturn(InventoryID.INV);

		STEP_TO_CLUE_PART.forEach((step, cluePart) ->
			when(inventory.contains(cluePart)).thenReturn(ArrayUtils.contains(steps, step)));

		clue.update(inventory.getId(), inventory);
	}
}
