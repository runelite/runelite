/*
 * Copyright (c) 2024 LlemonDuck
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
package net.runelite.client.plugins.wiki.dps;

import javax.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Spell
{

	// ancient spells
	ICE_BARRAGE(46, "Ice Barrage"),
	BLOOD_BARRAGE(45, "Blood Barrage"),
	SHADOW_BARRAGE(44, "Shadow Barrage"),
	SMOKE_BARRAGE(43, "Smoke Barrage"),
	ICE_BLITZ(42, "Ice Blitz"),
	BLOOD_BLITZ(41, "Blood Blitz"),
	SHADOW_BLITZ(40, "Shadow Blitz"),
	SMOKE_BLITZ(39, "Smoke Blitz"),
	ICE_BURST(38, "Ice Burst"),
	BLOOD_BURST(37, "Blood Burst"),
	SHADOW_BURST(36, "Shadow Burst"),
	SMOKE_BURST(35, "Smoke Burst"),
	ICE_RUSH(34, "Ice Rush"),
	BLOOD_RUSH(33, "Blood Rush"),
	SHADOW_RUSH(32, "Shadow Rush"),
	SMOKE_RUSH(31, "Smoke Rush"),

	// standard spells
	FIRE_SURGE(51, "Fire Surge"),
	EARTH_SURGE(50, "Earth Surge"),
	WATER_SURGE(49, "Water Surge"),
	WIND_SURGE(48, "Wind Surge"),
	FIRE_WAVE(16, "Fire Wave"),
	EARTH_WAVE(15, "Earth Wave"),
	WATER_WAVE(14, "Water Wave"),
	WIND_WAVE(13, "Wind Wave"),
	FIRE_BLAST(12, "Fire Blast"),
	EARTH_BLAST(11, "Earth Blast"),
	WATER_BLAST(10, "Water Blast"),
	WIND_BLAST(9, "Wind Blast"),
	FIRE_BOLT(8, "Fire Bolt"),
	EARTH_BOLT(7, "Earth Bolt"),
	WATER_BOLT(6, "Water Bolt"),
	WIND_BOLT(5, "Wind Bolt"),
	FIRE_STRIKE(4, "Fire Strike"),
	EARTH_STRIKE(3, "Earth Strike"),
	WATER_STRIKE(2, "Water Strike"),
	WIND_STRIKE(1, "Wind Strike"),

	// standard but not autocast without special staff
	FLAMES_OF_ZAMORAK(20, "Flames of Zamorak"),
	CLAWS_OF_GUTHIX(-1, "Claws of Guthix"),
	SARADOMIN_STRIKE(-1, "Saradomin Strike"),
	CRUMBLE_UNDEAD(17, "Crumble Undead"),
	IBAN_BLAST(47, "Iban Blast"),
	MAGIC_DART(18, "Magic Dart"),

	// arceuus
	INFERIOR_DEMONBANE(53, "Inferior Demonbane"),
	SUPERIOR_DEMONBANE(54, "Superior Demonbane"),
	DARK_DEMONBANE(55, "Dark Demonbane"),
	GHOSTLY_GRASP(56, "Ghostly Grasp"),
	SKELETAL_GRASP(57, "Skeletal Grasp"),
	UNDEAD_GRASP(58, "Undead Grasp"),
	;

	private final int varbValue;

	private final String name;

	@Nullable
	static Spell fromVarb(int spellVarb)
	{
		for (Spell spell : values())
		{
			if (spell.varbValue == spellVarb)
			{
				return spell;
			}
		}

		return null;
	}

}
