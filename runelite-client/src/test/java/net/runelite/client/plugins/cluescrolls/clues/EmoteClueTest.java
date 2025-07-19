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
import net.runelite.api.Item;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
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
	public void uniqueIds()
	{
		final Set<EmoteClue> cluesWithIds = EmoteClue.CLUES.stream()
			.filter((clue) ->
			{
				final int itemId = clue.getItemId();
				return itemId != ItemID.TRAIL_CLUE_MASTER && itemId != ItemID.TRAIL_CLUE_BEGINNER;
			})
			.collect(Collectors.toUnmodifiableSet());
		final Set<Integer> clueIds = cluesWithIds.stream()
			.mapToInt(EmoteClue::getItemId)
			.boxed()
			.collect(Collectors.toUnmodifiableSet());

		assertEquals(cluesWithIds.size(), clueIds.size());
	}

	@Test
	public void itemRequirementsFullBarrowsSetNonDegraged()
	{
		EmoteClue barrowsClue = EmoteClue.forText("Do a jig at the barrows chest. Beware of double agents! Equip any full barrows set.");
		ItemRequirement[] requirements = barrowsClue.getItemRequirements();

		assertEquals(1, requirements.length);

		ItemRequirement fullBarrowsSetRequirement = requirements[0];

		assertTrue("Full Ahrim set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_AHRIM_WEAPON), item(ItemID.BARROWS_AHRIM_HEAD), item(ItemID.BARROWS_AHRIM_BODY), item(ItemID.BARROWS_AHRIM_LEGS) }));
		assertTrue("Full Dharok set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_DHAROK_WEAPON), item(ItemID.BARROWS_DHAROK_HEAD), item(ItemID.BARROWS_DHAROK_BODY), item(ItemID.BARROWS_DHAROK_LEGS) }));
		assertTrue("Full Guthan set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_GUTHAN_WEAPON), item(ItemID.BARROWS_GUTHAN_HEAD), item(ItemID.BARROWS_GUTHAN_BODY), item(ItemID.BARROWS_GUTHAN_LEGS) }));
		assertTrue("Full Karil set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_KARIL_WEAPON), item(ItemID.BARROWS_KARIL_HEAD), item(ItemID.BARROWS_KARIL_BODY), item(ItemID.BARROWS_KARIL_LEGS) }));
		assertTrue("Full Torag set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_TORAG_WEAPON), item(ItemID.BARROWS_TORAG_HEAD), item(ItemID.BARROWS_TORAG_BODY), item(ItemID.BARROWS_TORAG_LEGS) }));
		assertTrue("Full Verac set, nondegraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_VERAC_WEAPON), item(ItemID.BARROWS_VERAC_HEAD), item(ItemID.BARROWS_VERAC_BODY), item(ItemID.BARROWS_VERAC_LEGS) }));
	}

	@Test
	public void itemRequirementsFullBarrowsSetDegraded()
	{
		EmoteClue barrowsClue = EmoteClue.forText("Do a jig at the barrows chest. Beware of double agents! Equip any full barrows set.");
		ItemRequirement[] requirements = barrowsClue.getItemRequirements();

		assertEquals(1, requirements.length);

		ItemRequirement fullBarrowsSetRequirement = requirements[0];

		assertTrue("Full Ahrim set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_AHRIM_WEAPON_50), item(ItemID.BARROWS_AHRIM_HEAD_50), item(ItemID.BARROWS_AHRIM_BODY_50), item(ItemID.BARROWS_AHRIM_LEGS_50) }));
		assertTrue("Full Dharok set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_DHAROK_WEAPON_50), item(ItemID.BARROWS_DHAROK_HEAD_50), item(ItemID.BARROWS_DHAROK_BODY_50), item(ItemID.BARROWS_DHAROK_LEGS_50) }));
		assertTrue("Full Guthan set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_GUTHAN_WEAPON_50), item(ItemID.BARROWS_GUTHAN_HEAD_50), item(ItemID.BARROWS_GUTHAN_BODY_50), item(ItemID.BARROWS_GUTHAN_LEGS_50) }));
		assertTrue("Full Karil set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_KARIL_WEAPON_50), item(ItemID.BARROWS_KARIL_HEAD_50), item(ItemID.BARROWS_KARIL_BODY_50), item(ItemID.BARROWS_KARIL_LEGS_50) }));
		assertTrue("Full Torag set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_TORAG_WEAPON_50), item(ItemID.BARROWS_TORAG_HEAD_50), item(ItemID.BARROWS_TORAG_BODY_50), item(ItemID.BARROWS_TORAG_LEGS_50) }));
		assertTrue("Full Verac set, degraded", fullBarrowsSetRequirement.fulfilledBy(new Item[]{ item(ItemID.BARROWS_VERAC_WEAPON_50), item(ItemID.BARROWS_VERAC_HEAD_50), item(ItemID.BARROWS_VERAC_BODY_50), item(ItemID.BARROWS_VERAC_LEGS_50) }));
	}

	@Test
	public void itemRequirementsCombatBraceletAllTypes()
	{
		EmoteClue slayerTowerClue = EmoteClue.forText("Headbang at the top of Slayer Tower. Equip a seercull, a combat bracelet and helm of Neitiznot.");
		ItemRequirement[] requirements = slayerTowerClue.getItemRequirements();

		assertEquals(3, requirements.length);

		ItemRequirement combatBraceletRequirement = requirements[1];

		assertTrue("Combat Bracelet", combatBraceletRequirement.fulfilledBy(ItemID.JEWL_BRACELET_OF_COMBAT));
		assertTrue("Combat Bracelet (1)", combatBraceletRequirement.fulfilledBy(ItemID.JEWL_BRACELET_OF_COMBAT_1));
		assertTrue("Combat Bracelet (2)", combatBraceletRequirement.fulfilledBy(ItemID.JEWL_BRACELET_OF_COMBAT_2));
		assertTrue("Combat Bracelet (3)", combatBraceletRequirement.fulfilledBy(ItemID.JEWL_BRACELET_OF_COMBAT_3));
		assertTrue("Combat Bracelet (4)", combatBraceletRequirement.fulfilledBy(ItemID.JEWL_BRACELET_OF_COMBAT_4));
		assertTrue("Combat Bracelet (5)", combatBraceletRequirement.fulfilledBy(ItemID.JEWL_BRACELET_OF_COMBAT_5));
		assertTrue("Combat Bracelet (6)", combatBraceletRequirement.fulfilledBy(ItemID.JEWL_BRACELET_OF_COMBAT_6));
	}
}
