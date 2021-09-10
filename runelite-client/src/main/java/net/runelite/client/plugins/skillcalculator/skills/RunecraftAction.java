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
public enum RunecraftAction implements SkillAction
{
	AIR_TIARA("Air tiara", 1, 25, ItemID.AIR_TIARA, true),
	MIND_TIARA("Mind tiara", 1, 27.5f, ItemID.MIND_TIARA, true),
	WATER_TIARA("Water tiara", 1, 30, ItemID.WATER_TIARA, true),
	EARTH_TIARA("Earth tiara", 1, 32.5f, ItemID.EARTH_TIARA, true),
	FIRE_TIARA("Fire tiara", 1, 35, ItemID.FIRE_TIARA, true),
	BODY_TIARA("Body tiara", 1, 37.5f, ItemID.BODY_TIARA, true),
	COSMIC_TIARA("Cosmic tiara", 1, 40, ItemID.COSMIC_TIARA, true),
	CHAOS_TIARA("Chaos tiara", 1, 42.5f, ItemID.CHAOS_TIARA, true),
	NATURE_TIARA("Nature tiara", 1, 45, ItemID.NATURE_TIARA, true),
	LAW_TIARA("Law tiara", 1, 47.5f, ItemID.LAW_TIARA, true),
	DEATH_TIARA("Death tiara", 1, 50, ItemID.DEATH_TIARA, true),
	WRATH_TIARA("Wrath tiara", 1, 52.5f, ItemID.WRATH_TIARA, true),
	AIR_RUNE("Air rune", 1, 5, ItemID.AIR_RUNE, false),
	MIND_RUNE("Mind rune", 2, 5.5f, ItemID.MIND_RUNE, false),
	MIND_CORE("Mind core", 2, 55, ItemID.MIND_CORE, false),
	WATER_RUNE("Water rune", 5, 6, ItemID.WATER_RUNE, false),
	MIST_RUNE("Mist rune", 6, 8.5f, ItemID.MIST_RUNE, false),
	EARTH_RUNE("Earth rune", 9, 6.5f, ItemID.EARTH_RUNE, false),
	DUST_RUNE("Dust rune", 10, 9, ItemID.DUST_RUNE, false),
	MUD_RUNE("Mud rune", 13, 9.5f, ItemID.MUD_RUNE, false),
	FIRE_RUNE("Fire rune", 14, 7, ItemID.FIRE_RUNE, false),
	SMOKE_RUNE("Smoke rune", 15, 9.5f, ItemID.SMOKE_RUNE, false),
	STEAM_RUNE("Steam rune", 19, 10, ItemID.STEAM_RUNE, false),
	BODY_RUNE("Body rune", 20, 7.5f, ItemID.BODY_RUNE, false),
	BODY_CORE("Body core", 20, 75, ItemID.BODY_CORE, false),
	LAVA_RUNE("Lava rune", 23, 10.5f, ItemID.LAVA_RUNE, false),
	COSMIC_RUNE("Cosmic rune", 27, 8, ItemID.COSMIC_RUNE, false),
	CHAOS_RUNE("Chaos rune", 35, 8.5f, ItemID.CHAOS_RUNE, false),
	CHAOS_CORE("Chaos core", 35, 85, ItemID.CHAOS_CORE, false),
	ASTRAL_RUNE("Astral rune", 40, 8.7f, ItemID.ASTRAL_RUNE, false),
	NATURE_RUNE("Nature rune", 44, 9, ItemID.NATURE_RUNE, false),
	LAW_RUNE("Law rune", 54, 9.5f, ItemID.LAW_RUNE, false),
	DEATH_RUNE("Death rune", 65, 10, ItemID.DEATH_RUNE, false),
	BLOOD_RUNE("Blood rune", 77, 24.425f, ItemID.BLOOD_RUNE, true),
	SOUL_RUNE("Soul rune", 90, 30.325f, ItemID.SOUL_RUNE, true),
	WRATH_RUNE("Wrath rune", 95, 8, ItemID.WRATH_RUNE, false),
	;

	private final String name;
	private final int level;
	private final float xp;
	private final int icon;
	private final boolean ignoreBonus;
}
