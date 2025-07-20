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

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.game.ItemManager;

@AllArgsConstructor
@Getter
public enum RunecraftAction implements ItemSkillAction
{
	AIR_RUNE(ItemID.AIRRUNE, 1, 5, false),
	AIR_TIARA(ItemID.TIARA_AIR, 1, 25, true),
	MIND_TIARA(ItemID.TIARA_MIND, 1, 27.5f, true),
	WATER_TIARA(ItemID.TIARA_WATER, 1, 30, true),
	EARTH_TIARA(ItemID.TIARA_EARTH, 1, 32.5f, true),
	FIRE_TIARA(ItemID.TIARA_FIRE, 1, 35, true),
	BODY_TIARA(ItemID.TIARA_BODY, 1, 37.5f, true),
	COSMIC_TIARA(ItemID.TIARA_COSMIC, 1, 40, true),
	CHAOS_TIARA(ItemID.TIARA_CHAOS, 1, 42.5f, true),
	NATURE_TIARA(ItemID.TIARA_NATURE, 1, 45, true),
	LAW_TIARA(ItemID.TIARA_LAW, 1, 47.5f, true),
	DEATH_TIARA(ItemID.TIARA_DEATH, 1, 50, true),
	WRATH_TIARA(ItemID.TIARA_WRATH, 1, 52.5f, true),
	MIND_RUNE(ItemID.MINDRUNE, 2, 5.5f, false),
	MIND_CORE(ItemID.CAMDOZAAL_GOLEM_CORE_MIND, 2, 55, true),
	WATER_RUNE(ItemID.WATERRUNE, 5, 6, false),
	MIST_RUNE(ItemID.MISTRUNE, 6, 8.5f, false),
	EARTH_RUNE(ItemID.EARTHRUNE, 9, 6.5f, false),
	DUST_RUNE(ItemID.DUSTRUNE, 10, 9, false),
	MUD_RUNE(ItemID.MUDRUNE, 13, 9.5f, false),
	FIRE_RUNE(ItemID.FIRERUNE, 14, 7, false),
	SMOKE_RUNE(ItemID.SMOKERUNE, 15, 9.5f, false),
	STEAM_RUNE(ItemID.STEAMRUNE, 19, 10, false),
	BODY_RUNE(ItemID.BODYRUNE, 20, 7.5f, false),
	BODY_CORE(ItemID.CAMDOZAAL_GOLEM_CORE_BODY, 20, 75, true),
	LAVA_RUNE(ItemID.LAVARUNE, 23, 10.5f, false),
	COSMIC_RUNE(ItemID.COSMICRUNE, 27, 8, false, true),
	SUNFIRE_RUNE(ItemID.SUNFIRERUNE, 33, 9, false),
	CHAOS_RUNE(ItemID.CHAOSRUNE, 35, 8.5f, false, true),
	CHAOS_CORE(ItemID.CAMDOZAAL_GOLEM_CORE_CHAOS, 35, 85, true),
	ASTRAL_RUNE(ItemID.ASTRALRUNE, 40, 8.7f, false),
	NATURE_RUNE(ItemID.NATURERUNE, 44, 9, false, true),
	LAW_RUNE(ItemID.LAWRUNE, 54, 9.5f, false, true),
	DEATH_RUNE(ItemID.DEATHRUNE, 65, 10, false, true),
	TRUE_BLOOD_RUNE(ItemID.BLOODRUNE, 77, 10.5f, false)
	{
		@Override
		public String getName(final ItemManager itemManager)
		{
			return "Blood rune (True Altar)";
		}
	},
	ZEAH_BLOOD_RUNE(ItemID.BLOODRUNE, 77, 24.425f, true)
	{
		@Override
		public String getName(final ItemManager itemManager)
		{
			return "Blood rune (Zeah)";
		}
	},
	AETHER_RUNE(ItemID.AETHERRUNE, 90, 20, false),
	SOUL_RUNE(ItemID.SOULRUNE, 90, 30.325f, true),
	WRATH_RUNE(ItemID.WRATHRUNE, 95, 8, false),
	;

	private static final Set<RunecraftBonus> RUNECRAFT_BONUSES = EnumSet.allOf(RunecraftBonus.class);

	private final int itemId;
	private final int level;
	private final float xp;
	private final boolean ignoreBonus;
	private final boolean isMembersOverride;

	RunecraftAction(int itemId, int level, float xp, boolean ignoreBonus)
	{
		this(itemId, level, xp, ignoreBonus, false);
	}

	@Override
	public Set<RunecraftBonus> getExcludedSkillBonuses()
	{
		if (ignoreBonus)
		{
			return RUNECRAFT_BONUSES;
		}

		return Collections.emptySet();
	}
}
