/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.plugins.runepouch;

import com.google.common.collect.ImmutableMap;
import java.awt.image.BufferedImage;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import static net.runelite.api.ItemID.*;

public enum Runes
{
	AIR(1, AIR_RUNE),
	WATER(2, WATER_RUNE),
	EARTH(3, EARTH_RUNE),
	FIRE(4, FIRE_RUNE),
	MIND(5, MIND_RUNE),
	CHAOS(6, CHAOS_RUNE),
	DEATH(7, DEATH_RUNE),
	BLOOD(8, BLOOD_RUNE),
	COSMIC(9, COSMIC_RUNE),
	NATURE(10, NATURE_RUNE),
	LAW(11, LAW_RUNE),
	BODY(12, BODY_RUNE),
	SOUL(13, SOUL_RUNE),
	ASTRAL(14, ASTRAL_RUNE),
	MIST(15, MIST_RUNE),
	MUD(16, MUD_RUNE),
	DUST(17, DUST_RUNE),
	LAVA(18, LAVA_RUNE),
	STEAM(19, STEAM_RUNE),
	SMOKE(20, SMOKE_RUNE),
	WRATH(21, WRATH_RUNE);

	@Getter(AccessLevel.PACKAGE)
	private final int id;
	@Getter(AccessLevel.PACKAGE)
	private final int itemId;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private BufferedImage image;

	private static final Map<Integer, Runes> runes;

	static
	{
		ImmutableMap.Builder<Integer, Runes> builder = new ImmutableMap.Builder<>();
		for (Runes rune : values())
		{
			builder.put(rune.getId(), rune);
		}
		runes = builder.build();
	}

	Runes(final int id, final int itemId)
	{
		this.id = id;
		this.itemId = itemId;
	}

	public static Runes getRune(int varbit)
	{
		return runes.get(varbit);
	}

	public String getName()
	{
		String name = this.name();
		name = name.substring(0, 1) + name.substring(1).toLowerCase();
		return name;
	}
}
