/*
 * Copyright (c) 2021, Jordan Atwood <nightfirecat@protonmail.com>
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
package net.runelite.client.plugins.skillcalculator.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@AllArgsConstructor
@Getter
public enum FishingAction implements ItemSkillAction
{
	RAW_SHRIMPS(ItemID.RAW_SHRIMPS, 1, 10),
	RAW_KARAMBWANJI(ItemID.RAW_KARAMBWANJI, 5, 5),
	RAW_SARDINE(ItemID.RAW_SARDINE, 5, 20),
	RAW_GUPPY(ItemID.RAW_GUPPY, 7, 8),
	RAW_HERRING(ItemID.RAW_HERRING, 10, 30),
	RAW_ANCHOVIES(ItemID.RAW_ANCHOVIES, 15, 40),
	RAW_MACKEREL(ItemID.RAW_MACKEREL, 16, 20),
	RAW_CAVEFISH(ItemID.RAW_CAVEFISH, 20, 16),
	RAW_BREAM(ItemID.RAW_BREAM, 20, 20),
	RAW_TROUT(ItemID.RAW_TROUT, 20, 50),
	RAW_COD(ItemID.RAW_COD, 23, 45),
	RAW_PIKE(ItemID.RAW_PIKE, 25, 60),
	RAW_SLIMY_EEL(ItemID.RAW_SLIMY_EEL, 28, 80),
	RAW_SALMON(ItemID.RAW_SALMON, 30, 70),
	RAW_TETRA(ItemID.RAW_TETRA, 33, 24),
	RAW_TUNA(ItemID.RAW_TUNA, 35, 80),
	RAW_CAVE_EEL(ItemID.RAW_CAVE_EEL, 38, 80),
	RAW_RAINBOW_FISH(ItemID.RAW_RAINBOW_FISH, 38, 80),
	RAW_LOBSTER(ItemID.RAW_LOBSTER, 40, 90),
	RAW_CATFISH(ItemID.RAW_CATFISH, 46, 33),
	RAW_BASS(ItemID.RAW_BASS, 46, 100),
	LEAPING_TROUT(ItemID.LEAPING_TROUT, 48, 50),
	RAW_SWORDFISH(ItemID.RAW_SWORDFISH, 50, 100),
	LEAPING_SALMON(ItemID.LEAPING_SALMON, 58, 70),
	RAW_MONKFISH(ItemID.RAW_MONKFISH, 62, 120),
	RAW_KARAMBWAN(ItemID.RAW_KARAMBWAN, 65, 50),
	LEAPING_STURGEON(ItemID.LEAPING_STURGEON, 70, 80),
	RAW_SHARK(ItemID.RAW_SHARK, 76, 110),
	RAW_SEA_TURTLE(ItemID.RAW_SEA_TURTLE, 79, 38),
	INFERNAL_EEL(ItemID.INFERNAL_EEL, 80, 95),
	RAW_MANTA_RAY(ItemID.RAW_MANTA_RAY, 81, 46),
	MINNOW(ItemID.MINNOW, 82, 26.5f),
	RAW_ANGLERFISH(ItemID.RAW_ANGLERFISH, 82, 120),
	RAW_DARK_CRAB(ItemID.RAW_DARK_CRAB, 85, 130),
	SACRED_EEL(ItemID.SACRED_EEL, 87, 105),
	;

	private final int itemId;
	private final int level;
	private final float xp;
}
