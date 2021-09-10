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
public enum FishingAction implements SkillAction
{
	RAW_SHRIMPS("Raw shrimps", 1, 10, ItemID.RAW_SHRIMPS),
	RAW_SARDINE("Raw sardine", 5, 20, ItemID.RAW_SARDINE),
	RAW_KARAMBWANJI("Raw karambwanji", 5, 5, ItemID.RAW_KARAMBWANJI),
	RAW_GUPPY("Raw guppy", 7, 8, ItemID.RAW_GUPPY),
	RAW_HERRING("Raw herring", 10, 30, ItemID.RAW_HERRING),
	RAW_ANCHOVIES("Raw anchovies", 15, 40, ItemID.RAW_ANCHOVIES),
	RAW_MACKEREL("Raw mackerel", 16, 20, ItemID.RAW_MACKEREL),
	RAW_TROUT("Raw trout", 20, 50, ItemID.RAW_TROUT),
	RAW_CAVEFISH("Raw cavefish", 20, 16, ItemID.RAW_CAVEFISH),
	RAW_COD("Raw cod", 23, 45, ItemID.RAW_COD),
	RAW_PIKE("Raw pike", 25, 60, ItemID.RAW_PIKE),
	RAW_SLIMY_EEL("Raw slimy eel", 28, 65, ItemID.RAW_SLIMY_EEL),
	RAW_SALMON("Raw salmon", 30, 70, ItemID.RAW_SALMON),
	RAW_TETRA("Raw tetra", 33, 24, ItemID.RAW_TETRA),
	RAW_TUNA("Raw tuna", 35, 80, ItemID.RAW_TUNA),
	RAW_RAINBOW_FISH("Raw rainbow fish", 38, 80, ItemID.RAW_RAINBOW_FISH),
	RAW_CAVE_EEL("Raw cave eel", 38, 80, ItemID.RAW_CAVE_EEL),
	RAW_LOBSTER("Raw lobster", 40, 90, ItemID.RAW_LOBSTER),
	RAW_BASS("Raw bass", 46, 100, ItemID.RAW_BASS),
	RAW_CATFISH("Raw catfish", 46, 33, ItemID.RAW_CATFISH),
	LEAPING_TROUT("Leaping trout", 48, 50, ItemID.LEAPING_TROUT),
	RAW_SWORDFISH("Raw swordfish", 50, 100, ItemID.RAW_SWORDFISH),
	LEAPING_SALMON("Leaping salmon", 58, 70, ItemID.LEAPING_SALMON),
	RAW_MONKFISH("Raw monkfish", 62, 120, ItemID.RAW_MONKFISH),
	RAW_KARAMBWAN("Raw karambwan", 65, 50, ItemID.RAW_KARAMBWAN),
	LEAPING_STURGEON("Leaping sturgeon", 70, 80, ItemID.LEAPING_STURGEON),
	RAW_SHARK("Raw shark", 76, 110, ItemID.RAW_SHARK),
	RAW_SEA_TURTLE("Raw sea turtle", 79, 38, ItemID.RAW_SEA_TURTLE),
	INFERNAL_EEL("Infernal eel", 80, 95, ItemID.INFERNAL_EEL),
	RAW_MANTA_RAY("Raw manta ray", 81, 46, ItemID.RAW_MANTA_RAY),
	RAW_ANGLERFISH("Raw anglerfish", 82, 120, ItemID.RAW_ANGLERFISH),
	MINNOW("Minnow", 82, 26.5f, ItemID.MINNOW),
	RAW_DARK_CRAB("Raw dark crab", 85, 130, ItemID.RAW_DARK_CRAB),
	SACRED_EEL("Sacred eel", 87, 105, ItemID.SACRED_EEL),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
}
