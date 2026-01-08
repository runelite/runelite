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

import java.util.EnumSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter(onMethod_ = @Override)
public enum PrayerBonus implements SkillBonus
{
	BONECRUSHER("Bonecrusher", 0.5f),
	SACRED_BONE_BURNER("Sacred Bone Burner", 3),
	SINISTER_OFFERING("Sinister Offering", 3),
	LIT_GILDED_ALTAR("Lit Gilded Altar", 3.5f),
	ECTOFUNTUS("Ectofuntus", 4),
	CHAOS_ALTAR("Chaos Altar", 7),
	BLESSED_SUNFIRE_WINE("Blessed Sunfire Wine", 1.2f),
	DEMONIC_OFFERING("Demonic Offering", 3),
	MORYTANIA_DIARY_3_SHADES("Morytania Diary 3 Shades", 1.5f),
	ZEALOT_ROBES("Zealot Robes", 1.05f),
	;

	private final String name;
	private final float value;

	@Override
	public Set<PrayerBonus> getCanBeStackedWith()
	{
		switch (this)
		{
			case ECTOFUNTUS:
			case LIT_GILDED_ALTAR:
			case CHAOS_ALTAR:
			case SINISTER_OFFERING:
				return EnumSet.complementOf(EnumSet.of(ECTOFUNTUS, LIT_GILDED_ALTAR, CHAOS_ALTAR, SINISTER_OFFERING, SACRED_BONE_BURNER, BONECRUSHER));
			case BONECRUSHER:
			case SACRED_BONE_BURNER:
				return EnumSet.complementOf(EnumSet.of(ECTOFUNTUS, LIT_GILDED_ALTAR, CHAOS_ALTAR, SINISTER_OFFERING, SACRED_BONE_BURNER, BONECRUSHER, ZEALOT_ROBES));
			case ZEALOT_ROBES:
				return EnumSet.complementOf(EnumSet.of(BONECRUSHER, SACRED_BONE_BURNER, ZEALOT_ROBES));
			default:
				return EnumSet.complementOf(EnumSet.of(this));
		}
	}
}
