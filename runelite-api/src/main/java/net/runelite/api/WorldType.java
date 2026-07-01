/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.api;

import java.util.Collection;
import java.util.EnumSet;
import lombok.AllArgsConstructor;

/**
 * An enumeration of possible world types.
 */
@AllArgsConstructor
public enum WorldType
{
	/**
	 * Members world type.
	 */
	MEMBERS(1),
	/**
	 * Pvp world type.
	 */
	PVP(1 << 2),
	/**
	 * Bounty world type.
	 */
	BOUNTY(1 << 5),
	/**
	 * PVP arena world type.
	 */
	PVP_ARENA(1 << 6),
	/**
	 * Skill total world type.
	 */
	SKILL_TOTAL(1 << 7),
	/**
	 * Quest speedrunning
	 */
	QUEST_SPEEDRUNNING(1 << 8),
	/**
	 * High risk world type.
	 */
	HIGH_RISK(1 << 10),
	/**
	 * Last man standing world type.
	 */
	LAST_MAN_STANDING(1 << 14),
	/**
	 * Beta world.
	 */
	BETA_WORLD(1 << 16),
	LEGACY_ONLY(1 << 22),
	EOC_ONLY(1 << 23),
	/**
	 * Beta worlds without profiles that are saved.
	 */
	NOSAVE_MODE(1 << 25),
	/**
	 * Tournament world type
	 */
	TOURNAMENT_WORLD(1 << 26),
	/**
	 * Fresh start world type
	 */
	FRESH_START_WORLD(1 << 27),
	/**
	 * Deadman world type.
	 */
	DEADMAN(1 << 29),
	/**
	 * Seasonal world type for leagues and seasonal deadman.
	 */
	SEASONAL(1 << 30);

	private final int mask;

	private static final EnumSet<WorldType> PVP_WORLD_TYPES = EnumSet.of(
		DEADMAN, // dmmt worlds are also flaged as DEADMAN
		PVP
	);

	/**
	 * Create enum set of world types from mask.
	 *
	 * @param mask the mask
	 * @return the enum set
	 */
	public static EnumSet<WorldType> fromMask(final int mask)
	{
		final EnumSet<WorldType> types = EnumSet.noneOf(WorldType.class);

		for (WorldType type : WorldType.values())
		{
			if ((mask & type.mask) != 0)
			{
				types.add(type);
			}
		}

		return types;
	}

	/**
	 * Create mask from enum set of world types.
	 *
	 * @param types the types
	 * @return the int containing all mask
	 */
	public static int toMask(final EnumSet<WorldType> types)
	{
		int mask = 0;

		for (WorldType type : types)
		{
			mask |= type.mask;
		}

		return mask;
	}

	/**
	 * Checks whether a world having a {@link Collection} of {@link WorldType}s is a PVP world.
	 *
	 * @param worldTypes A {@link Collection} of {@link WorldType}s describing the given world.
	 * @return           True if the given worldtypes of the world are a PVP world, false otherwise.
	 * @see Client#getWorldType()
	 */
	public static boolean isPvpWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(PVP_WORLD_TYPES::contains);
	}
}
