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
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import static net.runelite.api.ItemID.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class EmoteClueTest
{
	private Item item(final int id)
	{
		return new Item(id, 1);
	}

	@Test
	public void forTextEmptyString()
	{
		assertNull(EmoteClue.forText(""));
	}

	@Test
	public void itemRequirementsFullBarrowsSetNonDegraged()
	{
		EmoteClue barrowsClue = EmoteClue.forText("Do a jig at the barrows chest. Beware of double agents! Equip any full barrows set.");
		ItemRequirement[] requirements = barrowsClue.getItemRequirements();

		assertEquals(1, requirements.length);

		ItemRequirement fullBarrowsSetRequirement = requirements[0];

		assertTrue("Full Ahrim set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(AHRIMS_STAFF), item(AHRIMS_HOOD), item(AHRIMS_ROBETOP), item(AHRIMS_ROBESKIRT) }));
		assertTrue("Full Dharok set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(DHAROKS_GREATAXE), item(DHAROKS_HELM), item(DHAROKS_PLATEBODY), item(DHAROKS_PLATELEGS) }));
		assertTrue("Full Guthan set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(GUTHANS_WARSPEAR), item(GUTHANS_HELM), item(GUTHANS_PLATEBODY), item(GUTHANS_CHAINSKIRT) }));
		assertTrue("Full Karil set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(KARILS_CROSSBOW), item(KARILS_COIF), item(KARILS_LEATHERTOP), item(KARILS_LEATHERSKIRT) }));
		assertTrue("Full Torag set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(TORAGS_HAMMERS), item(TORAGS_HELM), item(TORAGS_PLATEBODY), item(TORAGS_PLATELEGS) }));
		assertTrue("Full Verac set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(VERACS_FLAIL), item(VERACS_HELM), item(VERACS_BRASSARD), item(VERACS_PLATESKIRT) }));
	}

	@Test
	public void itemRequirementsFullBarrowsSetDegraded()
	{
		EmoteClue barrowsClue = EmoteClue.forText("Do a jig at the barrows chest. Beware of double agents! Equip any full barrows set.");
		ItemRequirement[] requirements = barrowsClue.getItemRequirements();

		assertEquals(1, requirements.length);

		ItemRequirement fullBarrowsSetRequirement = requirements[0];

		assertTrue("Full Ahrim set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(AHRIMS_STAFF_50), item(AHRIMS_HOOD_50), item(AHRIMS_ROBETOP_50), item(AHRIMS_ROBESKIRT_50) }));
		assertTrue("Full Dharok set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(DHAROKS_GREATAXE_50), item(DHAROKS_HELM_50), item(DHAROKS_PLATEBODY_50), item(DHAROKS_PLATELEGS_50) }));
		assertTrue("Full Guthan set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(GUTHANS_WARSPEAR_50), item(GUTHANS_HELM_50), item(GUTHANS_PLATEBODY_50), item(GUTHANS_CHAINSKIRT_50) }));
		assertTrue("Full Karil set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(KARILS_CROSSBOW_50), item(KARILS_COIF_50), item(KARILS_LEATHERTOP_50), item(KARILS_LEATHERSKIRT_50) }));
		assertTrue("Full Torag set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(TORAGS_HAMMERS_50), item(TORAGS_HELM_50), item(TORAGS_PLATEBODY_50), item(TORAGS_PLATELEGS_50) }));
		assertTrue("Full Verac set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(VERACS_FLAIL_50), item(VERACS_HELM_50), item(VERACS_BRASSARD_50), item(VERACS_PLATESKIRT_50) }));
	}

	@Test
	public void itemRequirementsCombatBraceletAllTypes()
	{
		EmoteClue slayerTowerClue = EmoteClue.forText("Headbang at the top of Slayer Tower. Equip a seercull, a combat bracelet and helm of Neitiznot.");
		ItemRequirement[] requirements = slayerTowerClue.getItemRequirements();

		assertEquals(3, requirements.length);

		ItemRequirement combatBraceletRequirement = requirements[1];

		assertTrue("Combat Bracelet", combatBraceletRequirement.fulfilledBy(COMBAT_BRACELET));
		assertTrue("Combat Bracelet (1)", combatBraceletRequirement.fulfilledBy(COMBAT_BRACELET1));
		assertTrue("Combat Bracelet (2)", combatBraceletRequirement.fulfilledBy(COMBAT_BRACELET2));
		assertTrue("Combat Bracelet (3)", combatBraceletRequirement.fulfilledBy(COMBAT_BRACELET3));
		assertTrue("Combat Bracelet (4)", combatBraceletRequirement.fulfilledBy(COMBAT_BRACELET4));
		assertTrue("Combat Bracelet (5)", combatBraceletRequirement.fulfilledBy(COMBAT_BRACELET5));
		assertTrue("Combat Bracelet (6)", combatBraceletRequirement.fulfilledBy(COMBAT_BRACELET6));
	}
}
