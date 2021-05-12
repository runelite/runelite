/*
 * Copyright (c) 2021, Illya Myshakov <https://github.com/IllyaMyshakov>
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
package net.runelite.client.plugins.chatcommands;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public enum Pet
{
	ABYSSAL_ORPHAN("Abyssal orphan", 13262),
	IKKLE_HYDRA("Ikkle hydra", 22746),
	CALLISTO_CUB("Callisto cub", 13178),
	HELLPUPPY("Hellpuppy", 13247),
	PET_CHAOS_ELEMENTAL("Pet chaos elemental", 11995),
	PET_ZILYANA("Pet zilyana", 12651),
	PET_DARK_CORE("Pet dark core", 12816),
	PET_DAGANNOTH_PRIME("Pet dagannoth prime", 12644),
	PET_DAGANNOTH_SUPREME("Pet dagannoth supreme", 12643),
	PET_DAGANNOTH_REX("Pet dagannoth rex", 12645),
	TZREKJAD("Tzrek-jad", 13225),
	PET_GENERAL_GRAARDOR("Pet general graardor", 12650),
	BABY_MOLE("Baby mole", 12646),
	NOON("Noon", 21748),
	JALNIBREK("Jal-nib-rek", 21291),
	KALPHITE_PRINCESS("Kalphite princess", 12647),
	PRINCE_BLACK_DRAGON("Prince black dragon", 12653),
	PET_KRAKEN("Pet kraken", 12655),
	PET_KREEARRA("Pet kree'arra", 12649),
	PET_KRIL_TSUTSAROTH("Pet k'ril tsutsaroth", 12652),
	SCORPIAS_OFFSPRING("Scorpia's offspring", 13181),
	SKOTOS("Skotos", 21273),
	PET_SMOKE_DEVIL("Pet smoke devil", 12648),
	VENENATIS_SPIDERLING("Venenatis spiderling", 13177),
	VETION_JR("Vet'ion jr.", 13179),
	VORKI("Vorki", 21992),
	PHOENIX("Phoenix", 20693),
	PET_SNAKELING("Pet snakeling", 12921),
	OLMLET("Olmlet", 20851),
	LIL_ZIK("Lil' zik", 22473),
	BLOODHOUND("Bloodhound", 19730),
	PET_PENANCE_QUEEN("Pet penance queen", 12703),
	HERON("Heron", 13320),
	ROCK_GOLEM("Rock golem", 13321),
	BEAVER("Beaver", 13322),
	BABY_CHINCHOMPA("Baby chinchompa", 13323),
	GIANT_SQUIRREL("Giant squirrel", 20659),
	TANGLEROOT("Tangleroot", 20661),
	ROCKY("Rocky", 20663),
	RIFT_GUARDIAN("Rift guardian", 20665),
	HERBI("Herbi", 21509),
	CHOMPY_CHICK("Chompy chick", 13071),
	SRARACHA("Sraracha", 23495),
	SMOLCANO("Smolcano", 23760),
	YOUNGLLEF("Youngllef", 23757),
	LITTLE_NIGHTMARE("Little nightmare", 24491),
	LIL_CREATOR("Lil' creator", 25348),
	TINY_TEMPOR("Tiny tempor", 25602);

	private static final Map<String, Pet> petMap = new HashMap<>();

	private final String name;
	private final Integer iconID;

	static
	{
		for (final Pet pet : values())
		{
			petMap.put(pet.name, pet);
		}
	}

	Pet(String name, Integer iconID)
	{
		this.name = name;
		this.iconID = iconID;
	}

	public static Pet getPet(String petName)
	{
		return petMap.get(petName);
	}
}
