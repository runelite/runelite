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
package net.runelite.client.util;

import java.util.EnumSet;
import net.runelite.api.WorldType;

/**
 * Utility class for RuneScape worlds
 */
public class WorldUtil
{
	/**
	 * Converts http-api world types to runelite-api world types
	 * TODO: Find a better way to handle these to not have duplicate interfaces
	 *
	 * @param apiTypes http-api world types
	 * @return runelite-api world types
	 */
	public static EnumSet<WorldType> toWorldTypes(final EnumSet<net.runelite.http.api.worlds.WorldType> apiTypes)
	{
		final EnumSet<WorldType> types = EnumSet.noneOf(WorldType.class);

		for (net.runelite.http.api.worlds.WorldType apiType : apiTypes)
		{
			types.add(fromApiWorldType(apiType));
		}

		return types;
	}

	private static WorldType fromApiWorldType(net.runelite.http.api.worlds.WorldType apiType)
	{
		switch (apiType)
		{
			case MEMBERS:
				return WorldType.MEMBERS;
			case PVP:
				return WorldType.PVP;
			case BOUNTY:
				return WorldType.BOUNTY;
			case PVP_ARENA:
				return WorldType.PVP_ARENA;
			case SKILL_TOTAL:
				return WorldType.SKILL_TOTAL;
			case QUEST_SPEEDRUNNING:
				return WorldType.QUEST_SPEEDRUNNING;
			case HIGH_RISK:
				return WorldType.HIGH_RISK;
			case LAST_MAN_STANDING:
				return WorldType.LAST_MAN_STANDING;
			case BETA_WORLD:
				return WorldType.BETA_WORLD;
			case NOSAVE_MODE:
				return WorldType.NOSAVE_MODE;
			case TOURNAMENT:
				return WorldType.TOURNAMENT_WORLD;
			case FRESH_START_WORLD:
				return WorldType.FRESH_START_WORLD;
			case DEADMAN:
				return WorldType.DEADMAN;
			case SEASONAL:
				return WorldType.SEASONAL;
			default:
				throw new IllegalArgumentException("unknown world type " + apiType);
		}
	}
}
