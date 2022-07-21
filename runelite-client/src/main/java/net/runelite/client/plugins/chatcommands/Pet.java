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

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@AllArgsConstructor
@Getter
enum Pet
{
	ABYSSAL_ORPHAN("Abyssal orphan", ItemID.ABYSSAL_ORPHAN),
	IKKLE_HYDRA("Ikkle hydra", ItemID.IKKLE_HYDRA),
	CALLISTO_CUB("Callisto cub", ItemID.CALLISTO_CUB),
	HELLPUPPY("Hellpuppy", ItemID.HELLPUPPY),
	PET_CHAOS_ELEMENTAL("Pet chaos elemental", ItemID.PET_CHAOS_ELEMENTAL),
	PET_ZILYANA("Pet zilyana", ItemID.PET_ZILYANA),
	PET_DARK_CORE("Pet dark core", ItemID.PET_DARK_CORE),
	PET_DAGANNOTH_PRIME("Pet dagannoth prime", ItemID.PET_DAGANNOTH_PRIME),
	PET_DAGANNOTH_SUPREME("Pet dagannoth supreme", ItemID.PET_DAGANNOTH_SUPREME),
	PET_DAGANNOTH_REX("Pet dagannoth rex", ItemID.PET_DAGANNOTH_REX),
	TZREKJAD("Tzrek-jad", ItemID.TZREKJAD),
	PET_GENERAL_GRAARDOR("Pet general graardor", ItemID.PET_GENERAL_GRAARDOR),
	BABY_MOLE("Baby mole", ItemID.BABY_MOLE),
	NOON("Noon", ItemID.NOON),
	JALNIBREK("Jal-nib-rek", ItemID.JALNIBREK),
	KALPHITE_PRINCESS("Kalphite princess", ItemID.KALPHITE_PRINCESS),
	PRINCE_BLACK_DRAGON("Prince black dragon", ItemID.PRINCE_BLACK_DRAGON),
	PET_KRAKEN("Pet kraken", ItemID.PET_KRAKEN),
	PET_KREEARRA("Pet kree'arra", ItemID.PET_KREEARRA),
	PET_KRIL_TSUTSAROTH("Pet k'ril tsutsaroth", ItemID.PET_KRIL_TSUTSAROTH),
	SCORPIAS_OFFSPRING("Scorpia's offspring", ItemID.SCORPIAS_OFFSPRING),
	SKOTOS("Skotos", ItemID.SKOTOS),
	PET_SMOKE_DEVIL("Pet smoke devil", ItemID.PET_SMOKE_DEVIL),
	VENENATIS_SPIDERLING("Venenatis spiderling", ItemID.VENENATIS_SPIDERLING),
	VETION_JR("Vet'ion jr.", ItemID.VETION_JR),
	VORKI("Vorki", ItemID.VORKI),
	PHOENIX("Phoenix", ItemID.PHOENIX),
	PET_SNAKELING("Pet snakeling", ItemID.PET_SNAKELING),
	OLMLET("Olmlet", ItemID.OLMLET),
	LIL_ZIK("Lil' zik", ItemID.LIL_ZIK),
	BLOODHOUND("Bloodhound", ItemID.BLOODHOUND),
	PET_PENANCE_QUEEN("Pet penance queen", ItemID.PET_PENANCE_QUEEN),
	HERON("Heron", ItemID.HERON),
	ROCK_GOLEM("Rock golem", ItemID.ROCK_GOLEM),
	BEAVER("Beaver", ItemID.BEAVER),
	BABY_CHINCHOMPA("Baby chinchompa", ItemID.BABY_CHINCHOMPA_13324),
	GIANT_SQUIRREL("Giant squirrel", ItemID.GIANT_SQUIRREL),
	TANGLEROOT("Tangleroot", ItemID.TANGLEROOT),
	ROCKY("Rocky", ItemID.ROCKY),
	RIFT_GUARDIAN("Rift guardian", ItemID.RIFT_GUARDIAN),
	HERBI("Herbi", ItemID.HERBI),
	CHOMPY_CHICK("Chompy chick", ItemID.CHOMPY_CHICK),
	SRARACHA("Sraracha", ItemID.SRARACHA),
	SMOLCANO("Smolcano", ItemID.SMOLCANO),
	YOUNGLLEF("Youngllef", ItemID.YOUNGLLEF),
	LITTLE_NIGHTMARE("Little nightmare", ItemID.LITTLE_NIGHTMARE),
	LIL_CREATOR("Lil' creator", ItemID.LIL_CREATOR),
	TINY_TEMPOR("Tiny tempor", ItemID.TINY_TEMPOR),
	NEXLING("Nexling", ItemID.NEXLING),
	ABYSSAL_PROTECTOR("Abyssal protector", ItemID.ABYSSAL_PROTECTOR),
	;

	private final String name;
	private final Integer iconID;

	static Pet findPet(String petName)
	{
		for (Pet pet : values())
		{
			if (pet.name.equals(petName))
			{
				return pet;
			}
		}
		return null;
	}
}
