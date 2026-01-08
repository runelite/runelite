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
import net.runelite.api.gameval.ItemID;

@AllArgsConstructor
@Getter
@Deprecated
enum Pet
{
	ABYSSAL_ORPHAN("Abyssal orphan", ItemID.ABYSSALSIRE_PET),
	IKKLE_HYDRA("Ikkle hydra", ItemID.HYDRAPET),
	CALLISTO_CUB("Callisto cub", ItemID.CALLISTO_PET),
	HELLPUPPY("Hellpuppy", ItemID.HELL_PET),
	PET_CHAOS_ELEMENTAL("Pet chaos elemental", ItemID.CHAOSELEPET),
	PET_ZILYANA("Pet zilyana", ItemID.SARADOMINPET),
	PET_DARK_CORE("Pet dark core", ItemID.COREPET),
	PET_DAGANNOTH_PRIME("Pet dagannoth prime", ItemID.PRIMEPET),
	PET_DAGANNOTH_SUPREME("Pet dagannoth supreme", ItemID.SUPREMEPET),
	PET_DAGANNOTH_REX("Pet dagannoth rex", ItemID.REXPET),
	TZREKJAD("Tzrek-jad", ItemID.JAD_PET),
	PET_GENERAL_GRAARDOR("Pet general graardor", ItemID.BANDOSPET),
	BABY_MOLE("Baby mole", ItemID.MOLEPET),
	NOON("Noon", ItemID.DAWNPET),
	JALNIBREK("Jal-nib-rek", ItemID.INFERNOPET),
	KALPHITE_PRINCESS("Kalphite princess", ItemID.KQPET_WALKING),
	PRINCE_BLACK_DRAGON("Prince black dragon", ItemID.KBDPET),
	PET_KRAKEN("Pet kraken", ItemID.KRAKENPET),
	PET_KREEARRA("Pet kree'arra", ItemID.ARMADYLPET),
	PET_KRIL_TSUTSAROTH("Pet k'ril tsutsaroth", ItemID.ZAMORAKPET),
	SCORPIAS_OFFSPRING("Scorpia's offspring", ItemID.SCORPIA_PET),
	SKOTOS("Skotos", ItemID.SKOTIZOPET),
	PET_SMOKE_DEVIL("Pet smoke devil", ItemID.SMOKEPET),
	VENENATIS_SPIDERLING("Venenatis spiderling", ItemID.VENENATIS_PET),
	VETION_JR("Vet'ion jr.", ItemID.VETION_PET),
	VORKI("Vorki", ItemID.VORKATHPET),
	PHOENIX("Phoenix", ItemID.PHOENIXPET),
	PET_SNAKELING("Pet snakeling", ItemID.SNAKEPET),
	OLMLET("Olmlet", ItemID.OLMPET),
	LIL_ZIK("Lil' zik", ItemID.VERZIKPET),
	BLOODHOUND("Bloodhound", ItemID.BLOODHOUND_PET),
	PET_PENANCE_QUEEN("Pet penance queen", ItemID.PENANCEPET),
	HERON("Heron", ItemID.SKILLPETFISH),
	ROCK_GOLEM("Rock golem", ItemID.SKILLPETMINING),
	BEAVER("Beaver", ItemID.SKILLPETWC),
	BABY_CHINCHOMPA("Baby chinchompa", ItemID.SKILLPETHUNTER_GREY),
	GIANT_SQUIRREL("Giant squirrel", ItemID.SKILLPETAGILITY),
	TANGLEROOT("Tangleroot", ItemID.SKILLPETFARMING),
	ROCKY("Rocky", ItemID.SKILLPETTHIEVING),
	RIFT_GUARDIAN("Rift guardian", ItemID.SKILLPETRUNECRAFTING_FIRE),
	HERBI("Herbi", ItemID.HERBIBOARPET),
	CHOMPY_CHICK("Chompy chick", ItemID.CHOMPYBIRD_PET),
	SRARACHA("Sraracha", ItemID.SARACHNISPET),
	SMOLCANO("Smolcano", ItemID.ZALCANOPET),
	YOUNGLLEF("Youngllef", ItemID.GAUNTLETPET),
	LITTLE_NIGHTMARE("Little nightmare", ItemID.NIGHTMAREPET),
	LIL_CREATOR("Lil' creator", ItemID.SOULWARSPET_BLUE),
	TINY_TEMPOR("Tiny tempor", ItemID.TEMPOROSSPET),
	NEXLING("Nexling", ItemID.NEXPET),
	ABYSSAL_PROTECTOR("Abyssal protector", ItemID.ABYSSALPET),
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
