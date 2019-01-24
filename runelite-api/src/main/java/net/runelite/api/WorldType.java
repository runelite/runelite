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

/**
 * An enumeration of possible world types.
 */
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
	 * Skill total world type.
	 */
	SKILL_TOTAL(1 << 7),
	/**
	 * Pvp high risk world type.
	 */
	PVP_HIGH_RISK(1 << 10),
	/**
	 * Last man standing world type.
	 */
	LAST_MAN_STANDING(1 << 14),
	/**
	 * Tournament world type.
	 */
	TOURNAMENT(1 << 25),
	/**
	 * Deadman Tournament world type.
	 */
	DEADMAN_TOURNAMENT(1 << 26),
	/**
	 * Deadman world type.
	 */
	DEADMAN(1 << 29),
	/**
	 * Seasonal deadman world type.
	 */
	SEASONAL_DEADMAN(1 << 30);

	private final int mask;

	WorldType(int mask)
	{
		this.mask = mask;
	}

	private static final EnumSet<WorldType> PVP_WORLD_TYPES = EnumSet.of(
		DEADMAN,
		DEADMAN_TOURNAMENT,
		PVP,
		PVP_HIGH_RISK,
		SEASONAL_DEADMAN
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
