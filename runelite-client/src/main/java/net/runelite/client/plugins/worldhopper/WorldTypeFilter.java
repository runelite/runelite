/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.worldhopper;

import com.google.common.collect.Sets;
import java.util.EnumSet;
import java.util.Set;
import net.runelite.http.api.worlds.WorldType;

enum WorldTypeFilter
{
	NORMAL
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				EnumSet<WorldType> normal = EnumSet.of(WorldType.MEMBERS, WorldType.SKILL_TOTAL, WorldType.LAST_MAN_STANDING);
				EnumSet<WorldType> inverse = EnumSet.complementOf(normal);
				return Sets.intersection(types, inverse).isEmpty();
			}
		},
	DEADMAN
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				return types.contains(WorldType.DEADMAN);
			}
		},
	SEASONAL
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				return types.contains(WorldType.SEASONAL) || types.contains(WorldType.TOURNAMENT);
			}
		},
	QUEST_SPEEDRUNNING
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				return types.contains(WorldType.QUEST_SPEEDRUNNING);
			}
		},
	FRESH_START_WORLD
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				return types.contains(WorldType.FRESH_START_WORLD);
			}
		},
	PVP
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				return types.contains(WorldType.PVP);
			}
		},
	SKILL_TOTAL
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				return types.contains(WorldType.SKILL_TOTAL);
			}
		},
	HIGH_RISK
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				return types.contains(WorldType.HIGH_RISK) && !types.contains(WorldType.PVP);
			}
		},
	BOUNTY_HUNTER
		{
			@Override
			boolean matches(Set<WorldType> types)
			{
				return types.contains(WorldType.BOUNTY);
			}
		};

	abstract boolean matches(Set<WorldType> types);
}
