/*
 * Copyright (c) 2018, TheStonedTurtle <www.github.com/TheStonedTurtle>
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
package net.runelite.client.plugins.loottracker;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
public enum Pet
{
	// GWD Pets
	PET_GENERAL_GRAARDOR(ItemID.PET_GENERAL_GRAARDOR, "General graador"),
	PET_KREEARRA(ItemID.PET_KREEARRA, "Kree'arra"),
	PET_KRIL_TSUTSAROTH(ItemID.PET_KRIL_TSUTSAROTH, "K'ril tsutsaroth"),
	PET_ZILYANA(ItemID.PET_ZILYANA, "Commander zilyana"),
	// Wildy Pets
	CALLISTO_CUB(ItemID.CALLISTO_CUB, "Callisto"),
	PET_CHAOS_ELEMENTAL(ItemID.PET_CHAOS_ELEMENTAL, "Chaos Elemental", "Chaos Fanatic"),
	SCORPIAS_OFFSPRING(ItemID.SCORPIAS_OFFSPRING, "Scorpia"),
	VENENATIS_SPIDERLING(ItemID.VENENATIS_SPIDERLING, "Venenatis"),
	VETION_JR(ItemID.VETION_JR, "Vet'ion"),
	// KBD isn't really in wildy but meh
	PRINCE_BLACK_DRAGON(ItemID.PRINCE_BLACK_DRAGON, "King Black Dragon"),
	// Slayer Pets
	ABYSSAL_ORPHAN(ItemID.ABYSSAL_ORPHAN, "Abyssal Sire"),
	HELLPUPPY(ItemID.HELLPUPPY, "Cerberus"),
	NOON(ItemID.NOON, "Noon", "Dusk"),
	PET_KRAKEN(ItemID.PET_KRAKEN, "Kraken"),
	PET_SMOKE_DEVIL(ItemID.PET_SMOKE_DEVIL, "Thermonuclear Smoke Devil"),
	SKOTOS(ItemID.SKOTOS, "Skotizo"),
	// Other Bosses
	BABY_MOLE(ItemID.BABY_MOLE, "Giant Mole"),
	KALPHITE_PRINCESS(ItemID.KALPHITE_PRINCESS, "Kalphite Queen"),
	OLMLET(ItemID.OLMLET, "Chambers of Xeric"),
	LIL_ZIK(ItemID.LIL_ZIK, "Theatre of Blood"),
	PET_DARK_CORE(ItemID.PET_DARK_CORE, "Corporeal Beast"),
	PET_SNAKELING(ItemID.PET_SNAKELING, "Zulrah"),
	PET_DAGANNOTH_REX(ItemID.PET_DAGANNOTH_REX, "Dagannoth Rex"),
	PET_DAGANNOTH_PRIME(ItemID.PET_DAGANNOTH_PRIME, "Dagannoth Prime"),
	PET_DAGANNOTH_SUPREME(ItemID.PET_DAGANNOTH_SUPREME, "Dagannoth Supreme"),
	VORKI(ItemID.VORKI, "Vorkath"),
	BLOODHOUND(ItemID.BLOODHOUND, "Clue Scroll (Master)"),
	HERBI(ItemID.HERBI, "Herbiboar"),
	IKKLE_HYDRA(ItemID.IKKLE_HYDRA, "Alchemical Hydra"),
	PHOENIX(ItemID.PHOENIX, "Wintertodt"),
	YOUNGLLEF(ItemID.YOUNGLLEF, "Gauntlet"),
	SRARACHA(ItemID.SRARACHA, "Sraracha");

	private final int petID;
	private final String[] bossNames;
	private static final Map<String, Pet> byBossName = buildBossMap();

	Pet(int id, String... bossNames)
	{
		this.petID = id;
		this.bossNames = bossNames;
	}

	public static Pet getByBossName(String name)
	{
		return byBossName.get(name.toUpperCase());
	}

	private static Map<String, Pet> buildBossMap()
	{
		Map<String, Pet> byName = new HashMap<>();
		for (Pet pet : values())
		{
			String[] droppingBosses = pet.getBossNames();
			for (String bossName : droppingBosses)
			{
				byName.put(bossName.toUpperCase(), pet);
			}
		}
		return byName;
	}
}