/*
 * Copyright (c) 2026, Jeremy Bahadirli <https://github.com/jeremybahadirli>
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
package net.runelite.client.plugins.slayer;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;

/**
 * Utility class providing {@link Predicate predicates} for matching {@link NPC NPCs}.
 * <p>
 * All predicates produced by this class operate on the NPC's
 * {@link NPC#getTransformedComposition() transformed composition} and will
 * return {@code false} if no transformed composition is available.
 *
 * @see NPC
 * @see NPCComposition
 */
final class NpcPredicates
{
	/**
	 * Creates a predicate that matches NPCs whose transformed {@link NPCComposition#getName()} exactly equals any of the
	 * provided names (case-insensitive).
	 *
	 * @param names candidate NPC names
	 * @return a predicate that matches NPCs by the specified names
	 */
	static Predicate<NPC> byName(String... names)
	{
		return npc ->
		{
			final NPCComposition composition = npc.getTransformedComposition();
			if (composition == null)
			{
				return false;
			}

			final String npcName = composition.getName()
				.replace('\u00A0', ' ');

			for (String name : names)
			{
				if (name != null && name.equalsIgnoreCase(npcName))
				{
					return true;
				}
			}
			return false;
		};
	}

	/**
	 * Creates a predicate that matches NPCs whose transformed {@link NPCComposition#getName()} contains any of the
	 * provided name fragments as whole words (case-insensitive).
	 * <p>
	 * For example, {@code "Bear"} will match {@code "Black bear"} and {@code "Grizzly bear cub"}
	 * but not {@code "Jonny the beard"}.
	 *
	 * @param nameFragments candidate NPC name fragments
	 * @return a predicate that matches NPCs by the specified name fragments
	 */
	static Predicate<NPC> byNameContaining(String... nameFragments)
	{
		final Pattern[] patterns = Arrays.stream(nameFragments)
			.filter(Objects::nonNull)
			.map(String::trim)
			.filter(s -> !s.isEmpty())
			.map(s -> Pattern.compile("(?:\\s|^)" + Pattern.quote(s) + "(?:\\s|$)", Pattern.CASE_INSENSITIVE))
			.toArray(Pattern[]::new);

		return npc ->
		{
			final NPCComposition composition = npc.getTransformedComposition();
			if (composition == null)
			{
				return false;
			}

			final String name = composition.getName()
				.replace('\u00A0', ' ');

			for (Pattern pattern : patterns)
			{
				if (pattern.matcher(name).find())
				{
					return true;
				}
			}
			return false;
		};
	}

	/**
	 * Creates a predicate that matches NPCs whose transformed {@link NPCComposition#getCombatLevel()} equals any of the provided values.
	 *
	 * @param combatLevels candidate combat levels
	 * @return a predicate that matches NPCs by the specified combat levels
	 */
	static Predicate<NPC> byCombatLevel(int... combatLevels)
	{
		return npc ->
		{
			final NPCComposition composition = npc.getTransformedComposition();
			if (composition == null)
			{
				return false;
			}

			final int npcLevel = composition.getCombatLevel();
			for (int combatLevel : combatLevels)
			{
				if (combatLevel == npcLevel)
				{
					return true;
				}
			}
			return false;
		};
	}

	/**
	 * Creates a predicate that matches NPCs whose transformed {@link NPCComposition#getId()} equals any of the provided values.
	 *
	 * @param ids candidate ids
	 * @return a predicate that matches NPCs by the specified ids
	 */
	static Predicate<NPC> byId(int... ids)
	{
		return npc ->
		{
			final NPCComposition composition = npc.getTransformedComposition();
			if (composition == null)
			{
				return false;
			}

			final int npcId = composition.getId();
			for (int id : ids)
			{
				if (id == npcId)
				{
					return true;
				}
			}
			return false;
		};
	}
}
